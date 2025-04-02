import React from 'react';
import { ProfileData } from '../../types/profile';

interface ProfileHeaderProps {
  profile: ProfileData;
}

const ProfileHeader: React.FC<ProfileHeaderProps> = ({ profile }) => {
  return (
    <div className="page-header min-height-300 border-radius-xl mt-4" 
      style={{ backgroundImage: `url(${profile.coverImage})` }}>
      <span className="mask bg-gradient-dark opacity-6"></span>
      
      <div className="card card-body mx-2 mx-md-2 mt-n6">
        <div className="row gx-4 mb-2">
          <div className="col-auto">
            <div className="avatar avatar-xl position-relative">
              <img 
                src={profile.avatar} 
                alt={profile.fullName}
                className="w-100 border-radius-lg shadow-sm"
              />
            </div>
          </div>
          
          <div className="col-auto my-auto">
            <div className="h-100">
              <h5 className="mb-1">{profile.fullName}</h5>
              <p className="mb-0 font-weight-normal text-sm">
                {profile.position}
              </p>
            </div>
          </div>
          
          <div className="col-lg-4 col-md-6 my-sm-auto ms-sm-auto me-sm-0 mx-auto mt-3">
            <div className="nav-wrapper position-relative end-0">
              <ul className="nav nav-pills nav-fill p-1" role="tablist">
                <li className="nav-item">
                  <button className="nav-link mb-0 px-0 py-1 active">
                    <span className="material-symbols-rounded text-lg position-relative">person</span>
                    <span className="ms-1">Advisor</span>
                  </button>
                </li>
                {/* Other tabs */}
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfileHeader;