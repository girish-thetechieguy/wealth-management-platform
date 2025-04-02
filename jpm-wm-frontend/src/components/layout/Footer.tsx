import React from 'react';

const Footer: React.FC = () => {
  const footerLinks = [
    { text: 'Help', url: 'blank' },
    { text: 'J.P. Morgan', url: 'https://www.jpmorgan.com/global' },
    { text: 'Privacy', url: 'https://www.jpmorgan.com/privacy' },
    { text: 'Security', url: 'https://privatebank.jpmorgan.com/nam/en/about-us/security-hub' },
    { text: 'Terms of use', url: 'https://www.jpmorgan.com/terms-of-use' },
    { text: 'Accessibility', url: 'https://www.chase.com/digital/resources/accessibility' },
  ];

  return (
    <footer className="footer position-absolute bottom-2 py-2 w-100">
      <div className="container">
        <div className="row align-items-center justify-content-lg-between">
          <div className="col-12 col-md-6 my-auto">
            <div className="copyright text-center text-sm text-white text-lg-start">
              Copyright © {new Date().getFullYear()},
              <i className="fa fa-heart" aria-hidden="true"></i>
              JPMorgan Chase & Co. All rights reserved.
            </div>
          </div>
          <div className="col-12 col-md-6">
            <ul className="nav nav-footer justify-content-center justify-content-lg-end">
              {footerLinks.map((link, index) => (
                <li key={index} className="nav-item">
                  <a 
                    href={link.url} 
                    className={`nav-link text-white ${index === footerLinks.length - 1 ? 'pe-0' : ''}`}
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    {link.text}
                  </a>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;