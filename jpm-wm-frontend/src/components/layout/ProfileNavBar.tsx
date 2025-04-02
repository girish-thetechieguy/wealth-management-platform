import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const ProfileNavBar: React.FC = () => {
  const [showNotifications, setShowNotifications] = useState(false);

  const notifications = [
    {
      id: 1,
      avatar: '/assets/img/team-2.jpg',
      title: 'New message from Laur',
      time: '13 minutes ago',
    },
    // ... other notifications
  ];

  return (
    <nav className="navbar navbar-main navbar-expand-lg px-0 mx-3 shadow-none border-radius-xl">
      <div className="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          <ol className="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li className="breadcrumb-item text-sm">
              <Link className="opacity-5 text-dark" to="/">
                Pages
              </Link>
            </li>
            <li className="breadcrumb-item text-sm text-dark active" aria-current="page">
              Profile
            </li>
          </ol>
        </nav>
        
        <div className="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
          <div className="ms-md-auto pe-md-3 d-flex align-items-center">
            {/* Search or other controls can go here */}
          </div>
          
          <ul className="navbar-nav d-flex align-items-center justify-content-end">
            <li className="nav-item d-xl-none ps-3 d-flex align-items-center">
              <button className="nav-link text-body p-0">
                <div className="sidenav-toggler-inner">
                  <i className="sidenav-toggler-line"></i>
                  <i className="sidenav-toggler-line"></i>
                  <i className="sidenav-toggler-line"></i>
                </div>
              </button>
            </li>
            
            <li className="nav-item dropdown pe-3 d-flex align-items-center">
              <button 
                className="nav-link text-body p-0"
                onClick={() => setShowNotifications(!showNotifications)}
              >
                <span className="material-symbols-rounded">notifications</span>
              </button>
              
              {showNotifications && (
                <ul className="dropdown-menu dropdown-menu-end px-2 py-3 me-sm-n4">
                  {notifications.map(notification => (
                    <li key={notification.id} className="mb-2">
                      <Link className="dropdown-item border-radius-md" to="#">
                        <div className="d-flex py-1">
                          <div className="my-auto">
                            <img 
                              src={notification.avatar} 
                              className="avatar avatar-sm me-3" 
                              alt={notification.title}
                            />
                          </div>
                          <div className="d-flex flex-column justify-content-center">
                            <h6 className="text-sm font-weight-normal mb-1">
                              {notification.title}
                            </h6>
                            <p className="text-xs text-secondary mb-0">
                              <i className="fa fa-clock me-1"></i>
                              {notification.time}
                            </p>
                          </div>
                        </div>
                      </Link>
                    </li>
                  ))}
                </ul>
              )}
            </li>
            
            <li className="nav-item d-flex align-items-center">
              <Link to="/profile" className="nav-link text-body font-weight-bold px-0">
                <span className="material-symbols-rounded">account_circle</span>
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default ProfileNavBar;