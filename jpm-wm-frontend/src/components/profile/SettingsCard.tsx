import React from 'react';
import { PlatformSettings } from '../../types/profile';

interface SettingsCardProps {
  settings: PlatformSettings;
  onSettingChange: (key: keyof PlatformSettings, value: boolean) => void;
}

const SettingsCard: React.FC<SettingsCardProps> = ({ settings, onSettingChange }) => {
  return (
    <div className="card card-plain h-100">
      <div className="card-header pb-0 p-3">
        <h6 className="mb-0">Platform Settings</h6>
      </div>
      
      <div className="card-body p-3">
        <h6 className="text-uppercase text-body text-xs font-weight-bolder">Account</h6>
        <ul className="list-group">
          <li className="list-group-item border-0 px-0">
            <div className="form-check form-switch ps-0">
              <input
                className="form-check-input ms-auto"
                type="checkbox"
                checked={settings.retirementPortfolios}
                onChange={(e) => onSettingChange('retirementPortfolios', e.target.checked)}
              />
              <label className="form-check-label text-body ms-3 text-truncate w-80 mb-0">
                Interested in Retirement portfolios?
              </label>
            </div>
          </li>
          {/* Other settings */}
        </ul>
      </div>
    </div>
  );
};

export default SettingsCard;