// components/profile/AdvisoryBoard.tsx
import React from 'react';
import AdvisorItem from './AdvisorItem';
import { Advisor } from '../../types/profile';

interface AdvisoryBoardProps {
  advisors: Advisor[];
}

const AdvisoryBoard: React.FC<AdvisoryBoardProps> = ({ advisors }) => {
  return (
    <div className="card card-plain h-100">
      <div className="card-header pb-0 p-3">
        <h6 className="mb-0">Advisory board</h6>
      </div>
      
      <div className="card-body p-3">
        <ul className="list-group">
          {advisors.map(advisor => (
            <AdvisorItem key={advisor.id} advisor={advisor} />
          ))}
        </ul>
      </div>
    </div>
  );
};

export default AdvisoryBoard;