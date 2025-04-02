import React, { useState } from 'react';
import Sidebar from '../components/layout/Sidebar';
import ProfileNavBar from '../components/layout/ProfileNavBar';
import Footer from '../components/layout/Footer';
import ProfileHeader from '../components/profile/ProfileHeader';
import ProfileInfoCard from '../components/profile/ProfileInfoCard';
import SettingsCard from '../components/profile/SettingsCard';
import AdvisoryBoard from '../components/profile/AdvisoryBoard';
import { ProfileData, PlatformSettings, Advisor } from '../types/profile';

const ProfilePage: React.FC = () => {
  // Sample data - in a real app, this would come from an API
  const [profile, setProfile] = useState<ProfileData>({
    fullName: 'Richard Davis',
    position: 'CEO / Co-Founder',
    bio: 'Hi, I\'m Richard Davis, Decisions: If you can\'t decide, the answer is no...',
    mobile: '(+852) 5647 8835',
    email: 'alecthompson@mail.com',
    country: 'Hong Kong',
    company: 'Hunderson ltd',
    username: 'RichardDavis',
    avatar: '/assets/img/jpm/advisors/ppl/client.jpg',
    coverImage: 'https://images.unsplash.com/photo-1531512073830-ba890ca4eba2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1920&q=80',
  });

  const [settings, setSettings] = useState<PlatformSettings>({
    retirementPortfolios: true,
    educationPortfolios: false,
    hedgePortfolios: true,
    emailAlerts: false,
    notifications: true,
    newsletter: false,
  });

  const advisors: Advisor[] = [
    {
      id: 1,
      name: 'Gary Fournier',
      avatar: '/assets/img/jpm/advisors/ppl/adv1.jpg',
      message: 'Hi! I need more information..',
    },
    // ... other advisors
  ];

  const handleSettingChange = (key: keyof PlatformSettings, value: boolean) => {
    setSettings(prev => ({ ...prev, [key]: value }));
  };

  return (
    <div className="g-sidenav-show bg-gray-100">
      <Sidebar />
      
      <div className="main-content position-relative max-height-vh-100 h-100">
        <ProfileNavBar />
        
        <ProfileHeader profile={profile} />
        
        <div className="container-fluid px-2 px-md-4">
          <div className="row">
            <div className="col-12 col-xl-4">
              <ProfileInfoCard profile={profile} />
            </div>
            
            <div className="col-12 col-xl-4">
              <SettingsCard 
                settings={settings} 
                onSettingChange={handleSettingChange} 
              />
            </div>
            
            <div className="col-12 col-xl-4">
              <AdvisoryBoard advisors={advisors} />
            </div>
          </div>
        </div>
        
        <Footer />
      </div>
    </div>
  );
};

export default ProfilePage;