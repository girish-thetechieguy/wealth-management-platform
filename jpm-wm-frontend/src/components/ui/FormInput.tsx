import React from 'react';

interface FormInputProps {
  type: string;
  label: string;
  value: string;
  onChange: (value: string) => void;
  className?: string;
}

const FormInput: React.FC<FormInputProps> = ({ 
  type, 
  label, 
  value, 
  onChange, 
  className = '' 
}) => {
  return (
    <div className={`input-group input-group-outline mb-3 ${className}`}>
      <label className="form-label">{label}</label>
      <input 
        type={type} 
        className="form-control" 
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  );
};

export default FormInput;