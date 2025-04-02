import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Navbar from '../../components/layout/Navbar';
import Footer from '../../components/layout/Footer';
import FormInput from '../../components/ui/FormInput';
import signInBg from '../../assets/img/jpm/sign-in-bg.jpeg';

const SignIn: React.FC = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const handleChange = (field: keyof typeof formData, value: string) => {
    setFormData(prev => ({ ...prev, [field]: value }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle authentication logic here
    console.log('Sign in submitted:', formData);
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
        <div 
          className="page-header align-items-start min-vh-100" 
          style={{ 
            background: `#f0f0f0 url(${signInBg}) no-repeat center center`, 
            backgroundSize: 'cover'
          }}
        >
          <span className="mask bg-gradient-dark opacity-6"></span>
          <div className="container my-auto">
            <div className="row">
              <div className="col-lg-4 col-md-8 col-12 mx-auto">
                <div className="card z-index-0 fadeIn3 fadeInBottom">
                  <div className="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div className="bg-gradient-dark shadow-dark border-radius-lg py-3 pe-1">
                      <h4 className="text-white font-weight-bolder text-center mt-2 mb-0">
                        Wealth Client's <br /> Sign in
                      </h4>
                    </div>
                  </div>
                  <div className="card-body">
                    <form onSubmit={handleSubmit} className="text-start">
                      <FormInput
                        type="text"
                        label="Username"
                        value={formData.username}
                        onChange={(val) => handleChange('username', val)}
                        className="my-3"
                      />
                      
                      <FormInput
                        type="password"
                        label="Password"
                        value={formData.password}
                        onChange={(val) => handleChange('password', val)}
                        className="mb-3"
                      />
                      
                      <div className="text-center">
                        <button 
                          type="submit" 
                          className="btn bg-gradient-dark w-100 my-4 mb-2"
                        >
                          Sign in
                        </button>
                      </div>
                      
                      <p className="mt-4 text-sm text-center">
                        Don't have an account?
                        <Link to="/sign-up" className="text-primary text-gradient font-weight-bold"> Sign up</Link>
                      </p>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          <Footer />
        </div>
      </main>
    </>
  );
};

export default SignIn;