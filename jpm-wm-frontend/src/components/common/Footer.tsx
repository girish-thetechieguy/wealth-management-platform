import React from 'react';

const Footer: React.FC = () => {
    return (
        <footer className="bg-dark text-white text-center p-3">
            <p>&copy; {new Date().getFullYear()} My Application. All Rights Reserved.</p>
        </footer>
    );
};

export default Footer;