import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

export default function FormT8() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-8</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Sleeper's spacing and squareness with Synthetic Sleepers</span>
        <span>Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-8.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
        <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>
      <div className="d-flex justify-content-between align-items-center mb-2">
        <div className="fw-bold" style={{ textDecoration: 'underline' }}>Solid-bed Track</div>
        <table className="table table-bordered table-sm align-middle mb-0" border="1" style={{ width: 300, fontSize: '12px' }}>
          <tbody>
            <tr>
              <td style={{ padding: 0, background: 'linear-gradient(to top right, transparent calc(50% - 1px), black calc(50% - 1px), black calc(50% + 1px), transparent calc(50% + 1px))' }}></td>
              <td>Squareness</td>
              <td>Spacing<br />irregularity</td>
            </tr>
            <tr>
              <td>Tolerances</td>
              <td><span style={{ color: 'red' }}>± 5 mm</span></td>
              <td><span style={{ color: 'red' }}>± 5 mm</span></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className="mt-1 mb-2 text-start" style={{ fontSize: '12px' }}>*( ) indicates Construction Chainage.</div>
      <div className="d-flex gap-3">
        <div style={{ overflow: 'auto', flexGrow: 1, minWidth: 0 }}>
          <table className="table table-bordered align-middle form-table export-table compact-table mb-0" border="1" style={{ width: '100%', borderCollapse: 'collapse' }}>
            <thead>
              <tr>
                <th rowSpan={2} style={{ width: '10%', background: 'none' }}>Up /<br />Down</th>
                <th colSpan={3}>Chainage</th>
                <th rowSpan={2} style={{ width: '8%' }}>Sleeper<br />No.</th>
                <th rowSpan={2} style={{ width: '12%' }}>Squareness</th>
                <th colSpan={3}>Spacing</th>
                <th style={{ width: '15%' }}>Remarks</th>
              </tr>
              <tr>
                <td style={{ width: '5%' }}>km</td>
                <td style={{ width: '6%' }}>m</td>
                <td style={{ width: '7%' }}>cm</td>
                <td style={{ width: '14%', background: 'none' }}>Design value</td>
                <td style={{ width: '13%', background: 'none' }}>Measured<br />value</td>
                <td style={{ width: '10%', background: 'none' }}>Irregularity</td>
                <td style={{ background: 'none' }}></td>
              </tr>
            </thead>
            <tbody>
              {Array.from({ length: 9 }, (_, r) => (
                <tr key={r} style={{ height: '35px' }}>
                  {Array.from({ length: 10 }, (_, c) => (
                    <td key={c} style={{ height: '35px' }}>&nbsp;</td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div style={{ overflow: 'auto', flexGrow: 1, minWidth: 0 }}>
          <table className="table table-bordered align-middle form-table export-table compact-table mb-0" border="1" style={{ width: '100%', borderCollapse: 'collapse' }}>
            <thead>
              <tr>
                <th rowSpan={2} style={{ width: '10%', background: 'none' }}>Up /<br />Down</th>
                <th colSpan={3}>Chainage</th>
                <th rowSpan={2} style={{ width: '8%' }}>Sleeper<br />No.</th>
                <th rowSpan={2} style={{ width: '12%' }}>Squareness</th>
                <th colSpan={3}>Spacing</th>
                <th style={{ width: '15%' }}>Remarks</th>
              </tr>
              <tr>
                <td style={{ width: '5%' }}>km</td>
                <td style={{ width: '6%' }}>m</td>
                <td style={{ width: '7%' }}>cm</td>
                <td style={{ width: '14%', background: 'none' }}>Design value</td>
                <td style={{ width: '13%', background: 'none' }}>Measured<br />value</td>
                <td style={{ width: '10%', background: 'none' }}>Irregularity</td>
                <td style={{ background: 'none' }}></td>
              </tr>
            </thead>
            <tbody>
              {Array.from({ length: 9 }, (_, r) => (
                <tr key={r} style={{ height: '35px' }}>
                  {Array.from({ length: 10 }, (_, c) => (
                    <td key={c} style={{ height: '35px' }}>&nbsp;</td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <div className="mt-1 text-start" style={{ fontSize: '12px' }}>*Squareness: The left rail is used as the base and the right rail is measured.<br />Move to Origin side: (+), Move to end side: (-)</div>
    </div>
  );
}
