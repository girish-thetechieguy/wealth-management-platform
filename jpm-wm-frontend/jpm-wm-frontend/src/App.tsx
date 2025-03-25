import React from 'react';
import Navbar from './components/Navbar';
import InvestmentGrid from './components/InvestmentGrid';
import RetirementCalculator from './components/RetirementCalculator';
import { ReactQueryDevtools } from '@tanstack/react-query-devtools';

const App: React.FC = () => {
  return (
    <div>
      <Navbar />
      <div className="container mt-4">
        <h1>Investment Banking Platform</h1>
        <InvestmentGrid />
        <RetirementCalculator />
      </div>
      <ReactQueryDevtools initialIsOpen={false} />
    </div>
  );
};

export default App;