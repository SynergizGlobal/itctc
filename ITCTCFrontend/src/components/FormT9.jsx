import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

export default function FormT9() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const renderDataTable = (key) => (
    <div style={{ overflow: 'auto', minWidth: 0, flex: '1 1 calc(50% - 12px)' }} key={key}>
      <table className="table table-bordered align-middle form-table export-table compact-table mb-0" border="1" style={{ width: '100%', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th rowSpan={2} style={{ width: '8%', background: 'none' }}>Up /<br />Down</th>
            <th colSpan={3}>Chainage</th>
            <th rowSpan={2} style={{ width: '7%' }}>Sleeper<br />No.</th>
            <th colSpan={4}>Injection thickness (mm)</th>
            <th rowSpan={2} style={{ width: '8%' }}>Gap</th>
            <th rowSpan={2} style={{ width: '18%' }}>Remarks</th>
          </tr>
          <tr>
            <td style={{ width: '5%' }}>km</td>
            <td style={{ width: '5%' }}>m</td>
            <td style={{ width: '5%' }}>CM</td>
            <td style={{ width: '9%', background: 'none' }}>Left</td>
            <td style={{ width: '9%', background: 'none' }}>Centre</td>
            <td style={{ width: '9%', background: 'none' }}>Right</td>
            <td style={{ width: '8%', background: 'none' }}>Average</td>
          </tr>
        </thead>
        <tbody>
          {Array.from({ length: 7 }, (_, r) => (
            <tr key={r}>
              {Array.from({ length: 11 }, (_, c) => (
                <td key={c}>&nbsp;</td>
              ))}
            </tr>
          ))}
          <tr>
            <td colSpan={11}>&nbsp;</td>
          </tr>
        </tbody>
      </table>
    </div>
  );

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-9</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Synthetic Resin injection thickness with Synthetic Sleepers</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-9.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="d-flex justify-content-between align-items-center mb-2">
        <div className="fw-bold" style={{ textDecoration: 'underline' }}>Solid-bed Track</div>
        <table className="table table-bordered table-sm align-middle mb-0" border="1" style={{ width: 400, fontSize: '12px' }}>
          <tbody>
            <tr>
              <td>Standard value</td>
              <td><span style={{ color: 'red' }}>25 mm</span></td>
              <td rowSpan={2}>Spring constant</td>
              <td><span style={{ color: 'red' }}>10 MN/m (15 - 35 mm)</span></td>
            </tr>
            <tr>
              <td>Tolerances</td>
              <td><span style={{ color: 'red' }}>± 10 mm</span></td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>

      <div className="mt-1 mb-2 text-start" style={{ fontSize: '12px' }}>*( ) indicates Construction Chainage.</div>
      <div className="row g-3">
        <div className="col-md-6">{renderDataTable(0)}</div>
        <div className="col-md-6">{renderDataTable(1)}</div>
        <div className="col-md-6">{renderDataTable(2)}</div>
        <div className="col-md-6">{renderDataTable(3)}</div>
      </div>
    </div>
  );
}
