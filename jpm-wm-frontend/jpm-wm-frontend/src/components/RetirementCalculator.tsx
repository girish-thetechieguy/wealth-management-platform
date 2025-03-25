import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';

const RetirementCalculator: React.FC = () => {
  const [age, setAge] = useState<number>(0);
  const [income, setIncome] = useState<number>(0);
  const [savings, setSavings] = useState<number>(0);

  const calculateRetirement = () => {
    // Add logic to calculate retirement savings
    alert(`Retirement Savings: ${savings}`);
  };

  return (
    <div>
      <h3>Retirement Calculator</h3>
      <Form>
        <Form.Group>
          <Form.Label>Age</Form.Label>
          <Form.Control type="number" value={age} onChange={(e) => setAge(Number(e.target.value))} />
        </Form.Group>
        <Form.Group>
          <Form.Label>Income</Form.Label>
          <Form.Control type="number" value={income} onChange={(e) => setIncome(Number(e.target.value))} />
        </Form.Group>
        <Form.Group>
          <Form.Label>Savings</Form.Label>
          <Form.Control type="number" value={savings} onChange={(e) => setSavings(Number(e.target.value))} />
        </Form.Group>
        <Button onClick={calculateRetirement}>Calculate</Button>
      </Form>
    </div>
  );
};

export default RetirementCalculator;