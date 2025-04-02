export interface Advisor {
    id: number;
    name: string;
    avatar: string;
    message: string;
  }
  
  export interface ProfileData {
    fullName: string;
    position: string;
    bio: string;
    mobile: string;
    email: string;
    country: string;
    company: string;
    username: string;
    avatar: string;
    coverImage: string;
  }
  
  export interface PlatformSettings {
    retirementPortfolios: boolean;
    educationPortfolios: boolean;
    hedgePortfolios: boolean;
    emailAlerts: boolean;
    notifications: boolean;
    newsletter: boolean;
  }