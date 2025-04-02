import React from 'react';
import { Link } from 'react-router-dom';
import jpmLogo from '../../assets/img/jpm/jpm-wm-logo.jpeg';

const Navbar: React.FC = () => {
  const [mobileOpen, setMobileOpen] = React.useState(false);

  const navItems = [
    { name: 'J.P. Morgan', url: 'https://www.jpmorgan.com/global', icon: 'chart-pie' },
    { name: 'Privacy', url: 'https://www.jpmorgan.com/privacy', icon: 'user' },
    { name: 'Security', url: 'https://privatebank.jpmorgan.com/nam/en/about-us/security-hub', icon: 'user' },
    { name: 'Terms of use', url: 'https://www.jpmorgan.com/terms-of-use', icon: 'user' },
    { name: 'Accessibility', url: 'https://www.chase.com/digital/resources/accessibility', icon: 'user' },
    { name: 'Sign In', url: '/sign-in', icon: 'key' },
  ];

  return (
    <nav className="navbar navbar-expand-lg blur border-radius-lg top-0 z-index-3 shadow position-absolute mt-4 py-2 start-0 end-0 mx-4">
      <div className="container-fluid ps-2 pe-0">
        <Link className="navbar-brand font-weight-bolder ms-lg-0 ms-3" to="/">
          <img src={jpmLogo} alt="J.P. Morgan Wealth Management" width="200" height="25" />
        </Link>
        
        <button 
          className="navbar-toggler shadow-none ms-2" 
          type="button" 
          onClick={() => setMobileOpen(!mobileOpen)}
          aria-expanded={mobileOpen}
        >
          <span className="navbar-toggler-icon mt-2">
            <span className="navbar-toggler-bar bar1"></span>
            <span className="navbar-toggler-bar bar2"></span>
            <span className="navbar-toggler-bar bar3"></span>
          </span>
        </button>
        
        <div className={`collapse navbar-collapse ${mobileOpen ? 'show' : ''}`} id="navigation">
          <ul className="navbar-nav mx-auto">
            {navItems.map((item, index) => (
              <li key={index} className="nav-item">
                <a className="nav-link d-flex align-items-center me-2" href={item.url}>
                  <i className={`fa fa-${item.icon} opacity-6 text-dark me-1`}></i>
                  {item.name}
                </a>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;