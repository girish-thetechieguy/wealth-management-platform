import React from 'react';
import Sidebar from './Sidebar';

const Dashboard: React.FC = () => {
    return (
        <div className="container mt-5">
            <div className="row">
                <Sidebar />
                <div className="col-md-9">
                    <h2>Dashboard</h2>
                    <p>Welcome to your dashboard!</p>
                </div>
            </div>
        </div>
    );
};

export default Dashboard;