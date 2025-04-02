import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import jpmLogo from '../../assets/img/jpm/jpm-wm-logo.jpeg';

const Sidebar: React.FC = () => {
  const location = useLocation();
  
  const navItems = [
    { path: '/dashboard', icon: 'dashboard', text: 'Dashboard' },
    { path: '/portfolios', icon: 'table_view', text: 'Portfolios' },
    { path: '/billing', icon: 'receipt_long', text: 'Account-Billing' },
    { path: '/profile', icon: 'person', text: 'Profile' },
    { path: '/sign-in', icon: 'login', text: 'Log Out' },
  ];

  return (
    <aside className="sidenav navbar navbar-vertical navbar-expand-xs border-radius-lg fixed-start ms-2 bg-white my-2">
      <div className="sidenav-header">
        <Link className="navbar-brand px-4 py-3 m-0" to="/">
          <img src={jpmLogo} alt="J.P. Morgan" width="200" height="25" />
        </Link>
      </div>
      <hr className="horizontal dark mt-0 mb-2" />
      <div className="collapse navbar-collapse w-auto" id="sidenav-collapse-main">
        <ul className="navbar-nav">
          {navItems.map((item, index) => (
            <li key={index} className="nav-item">
              <Link
                className={`nav-link ${location.pathname === item.path ? 'active bg-gradient-dark text-white' : 'text-dark'}`}
                to={item.path}
              >
                <span className="material-symbols-rounded opacity-5">{item.icon}</span>
                <span className="nav-link-text ms-1">{item.text}</span>
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </aside>
  );
};

export default Sidebar;