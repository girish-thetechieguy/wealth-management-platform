import React from 'react';
import { ProfileData } from '../../types/profile';

interface ProfileInfoCardProps {
  profile: ProfileData;
}

const ProfileInfoCard: React.FC<ProfileInfoCardProps> = ({ profile }) => {
  return (
    <div className="card card-plain h-100">
      <div className="card-header pb-0 p-3">
        <div className="row">
          <div className="col-md-8 d-flex align-items-center">
            <h6 className="mb-0">Profile Information</h6>
          </div>
          <div className="col-md-4 text-end">
            <button className="btn btn-link p-0">
              <i className="fas fa-user-edit text-secondary text-sm"></i>
            </button>
          </div>
        </div>
      </div>
      
      <div className="card-body p-3">
        <p className="text-sm">{profile.bio}</p>
        <hr className="horizontal gray-light my-4" />
        
        <ul className="list-group">
          <li className="list-group-item border-0 ps-0 pt-0 text-sm">
            <strong className="text-dark">Full Name:</strong> {profile.fullName}
          </li>
          {/* Other profile fields */}
        </ul>
      </div>
    </div>
  );
};

export default ProfileInfoCard;