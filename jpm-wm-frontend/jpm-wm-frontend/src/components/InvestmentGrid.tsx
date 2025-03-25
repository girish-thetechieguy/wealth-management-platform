import React from 'react';
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';
import { useInvestments } from '../hooks/useInvestments';

const InvestmentGrid: React.FC = () => {
  const { data, isLoading } = useInvestments();

  const columnDefs = [
    { headerName: 'ID', field: 'id' },
    { headerName: 'Name', field: 'name' },
    { headerName: 'Amount', field: 'amount' },
    { headerName: 'Type', field: 'type' },
  ];

  if (isLoading) return <div>Loading...</div>;

  return (
    <div className="ag-theme-alpine" style={{ height: 400, width: '100%' }}>
      <AgGridReact
        rowData={data}
        columnDefs={columnDefs}
        pagination={true}
        paginationPageSize={10}
      />
    </div>
  );
};

export default InvestmentGrid;