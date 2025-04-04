import http from 'k6/http';
import { check, sleep } from "k6";
import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/2.2.0/dist/bundle.js";
import { textSummary } from "https://jslib.k6.io/k6-summary/0.0.1/index.js";

export const options = {
  iterations: 50,
};

const localDomain = "http://localhost:8081/client/app/v1/register";


const checkRegisterAPI = () => {
  const url = `${localDomain}`;
  const payload = { 
    firstName: 'Girish',
    lastName: 'Bale',
    email: 'Testuser@gmail.com',
    city: 'Hong Kong',
    country: 'Hong Kong',
    phone: '+85267567899',
    username: 'WealthManager01',
    password: 'Wealthpassword',
    company: 'ABC corp',
    isVarified: false,
    requestRetirement: true,
    grantRetirementAccess: false,
    requestEducation: false,
    grantEducationAccess: false,
    requestWealthMgmt: false,
    grantWealthMgmt: false,
    wealthInverstType: 'Asset wealth management',
    createdAt: '2025-03-30T08:58:47.124+00:00',
    createdBy: 'user',
    updatedAt: '',
    updatedBy: ''
  };
  const reqBody = JSON.stringify(payload);
  
  const params = {
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    },
  };

  const response = http.post(url, reqBody, params);

  const responseDetails = check(response, {
    'Response HTTP Status is correct': () => response.status === 201
  });
  if (responseDetails == undefined || responseDetails == null) {
    console.log(`Failed with reason : Respones Status : ${response.status} 
      Respones body :${response.body} 
      Error : ${response.error} 
      Error Code : ${response.error_code}`);
    return;
  }
  // Sleep for 1 second to simulate real-world usage
  sleep(0.5);
};

export default function () {
  checkRegisterAPI();
};

export function handleSummary(data) {
  return {
    [`../reports/jpm-client-service/REG-API-${new Date().toISOString()}.html`]: htmlReport(data),
    stdout: textSummary(data, { indent: " ", enableColors: true })
  };
}