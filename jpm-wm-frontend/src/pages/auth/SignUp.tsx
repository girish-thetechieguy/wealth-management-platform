import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from '../../components/layout/Navbar';
import FormInput from '../../components/ui/FormInput';
import signUpBg from '../../assets/img/jpm/sign-up-bg.jpg';

const SignUp: React.FC = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    city: '',
    country: '',
    phone: '',
    username: '',
    password: '',
    educationPlans: true,
    retirementPlans: true,
    agreeTerms: true,
  });

  const handleChange = (field: keyof typeof formData, value: string | boolean) => {
    setFormData(prev => ({ ...prev, [field]: value }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle form submission logic
    console.log('Form submitted:', formData);
    navigate('/dashboard');
  };

  return (
    <>
      <div className="container position-sticky z-index-sticky top-0">
        <div className="row">
          <div className="col-12">
            <Navbar />
          </div>
        </div>
      </div>

      <main className="main-content mt-0">
        <section>
          <div className="page-header min-vh-100">
            <div className="container">
              <div className="row">
                <div className="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
                  <div 
                    className="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center" 
                    style={{ 
                      background: `#f0f0f0 url(${signUpBg}) no-repeat center center`, 
                      backgroundSize: 'cover' 
                    }}
                  ></div>
                </div>
                
                <div className="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
                  <div className="card card-plain">
                    <div className="card-header">
                      <h4 className="font-weight-bolder">
                        <br/><br/>
                        Sign Up
                        </h4>
                      <p className="mb-0">Enter your following details to register</p>
                    </div>
                    
                    <div className="card-body">
                      <form onSubmit={handleSubmit}>
                        <FormInput
                          type="text"
                          label="Firstname"
                          value={formData.firstName}
                          onChange={(val) => handleChange('firstName', val)}
                        />
                        
                        <FormInput
                          type="text"
                          label="Lastname"
                          value={formData.lastName}
                          onChange={(val) => handleChange('lastName', val)}
                        />
                        
                        <FormInput
                          type="email"
                          label="Email"
                          value={formData.email}
                          onChange={(val) => handleChange('email', val)}
                        />
                        
                        <FormInput
                          type="text"
                          label="City"
                          value={formData.city}
                          onChange={(val) => handleChange('city', val)}
                        />
                        
                        <FormInput
                          type="text"
                          label="Country"
                          value={formData.country}
                          onChange={(val) => handleChange('country', val)}
                        />
                        
                        <FormInput
                          type="text"
                          label="Phone No"
                          value={formData.phone}
                          onChange={(val) => handleChange('phone', val)}
                        />
                        
                        <FormInput
                          type="text"
                          label="Username"
                          value={formData.username}
                          onChange={(val) => handleChange('username', val)}
                        />
                        
                        <FormInput
                          type="password"
                          label="Password"
                          value={formData.password}
                          onChange={(val) => handleChange('password', val)}
                        />
                        
                        <ul className="list-group">
                          <li className="list-group-item border-0 px-0">
                            <div className="form-check form-switch ps-0">
                              <label className="form-check-label text-body ms-3 text-truncate w-80 mb-0">
                                Interested in Education plans?
                              </label>
                              <input 
                                className="form-check-input ms-auto" 
                                type="checkbox" 
                                checked={formData.educationPlans}
                                onChange={(e) => handleChange('educationPlans', e.target.checked)}
                              />
                            </div>
                            
                            <div className="form-check form-switch ps-0">
                              <label className="form-check-label text-body ms-3 text-truncate w-80 mb-0">
                                Interested in Retirement plans?
                              </label>
                              <input 
                                className="form-check-input ms-auto" 
                                type="checkbox" 
                                checked={formData.retirementPlans}
                                onChange={(e) => handleChange('retirementPlans', e.target.checked)}
                              />
                            </div>
                          </li>
                        </ul>

                        <div className="form-check form-check-info text-start ps-0 mt-3">
                          <input 
                            className="form-check-input" 
                            type="checkbox" 
                            checked={formData.agreeTerms}
                            onChange={(e) => handleChange('agreeTerms', e.target.checked)}
                          />
                          <label className="form-check-label">
                            I agree the <Link to="/terms" className="text-dark font-weight-bolder">Terms and Conditions</Link>
                          </label>
                        </div>
                        
                        <div className="text-center">
                          <button 
                            type="submit" 
                            className="btn btn-lg bg-gradient-dark btn-lg w-100 mt-4 mb-0"
                            disabled={!formData.agreeTerms}
                          >
                            Sign Up
                          </button>
                        </div>
                      </form>
                    </div>
                    
                    <div className="card-footer text-center pt-0 px-lg-2 px-1">
                      <p className="mb-2 text-sm mx-auto">
                        Already have an account?
                        <Link to="/sign-in" className="text-primary text-gradient font-weight-bold"> Sign in</Link>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </main>
    </>
  );
};

export default SignUp;