// components/profile/AdvisorItem.tsx
import React from 'react';
import { Advisor } from '../../types/profile';

interface AdvisorItemProps {
  advisor: Advisor;
}

const AdvisorItem: React.FC<AdvisorItemProps> = ({ advisor }) => {
  return (
    <li className="list-group-item border-0 d-flex align-items-center px-0 mb-2 pt-0">
      <div className="avatar me-3">
        <img src={advisor.avatar} alt={advisor.name} className="border-radius-lg shadow" />
      </div>
      <div className="d-flex align-items-start flex-column justify-content-center">
        <h6 className="mb-0 text-sm">{advisor.name}</h6>
        <p className="mb-0 text-xs">{advisor.message}</p>
      </div>
      <button className="btn btn-link pe-3 ps-0 mb-0 ms-auto w-25 w-md-auto">
        Reply
      </button>
    </li>
  );
};

export default AdvisorItem;

