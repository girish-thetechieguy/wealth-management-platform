import React from 'react';
import { Link } from 'react-router-dom';

const Sidebar: React.FC = () => {
    return (
        <div className="col-md-3">
            <h4>Navigation</h4>
            <ul className="list-group">
                <li className="list-group-item">
                    <Link to="/dashboard" className="nav-link">Dashboard</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/profile" className="nav-link">Profile</Link>
                </li>
                <li className="list-group-item">
                    <Link to="/settings" className="nav-link">Settings</Link>
                </li>
            </ul>
        </div>
    );
};

export default Sidebar;