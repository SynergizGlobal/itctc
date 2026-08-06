import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';

const MEASUREMENT_ROWS = 16;

function measurementRow(index) {
  const chainageKm = Math.floor((100 + index * 10) / 1000);
  const chainageM = (100 + index * 10) % 1000;
  return {
    sl: String(index + 1).padStart(2, '0'),
    point: `P${index + 1}`,
    km: chainageKm,
    m: chainageM,
    leftFormation: (4.0 + (index % 5) * 0.02).toFixed(2),
    rightFormation: (4.0 + ((index + 2) % 5) * 0.02).toFixed(2),
    formationWidth: (8.0 + (index % 3) * 0.05).toFixed(2),
    remarks: '',
  };
}

export default function FormC2() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form C-2</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of formation width (Tunnel section)</span>
        <span>No. <input type="text" defaultValue="C2-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-C-2.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div className="d-flex gap-3 align-items-start mb-3">
        <div className="flex-grow-1" style={{ overflow: 'auto' }}>
          <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
            <thead>
              <tr>
                <th rowSpan="2" width="50">SL No.</th>
                <th rowSpan="2" width="120">Measurement point</th>
                <th colSpan="2">Chainage</th>
                <th colSpan="3">Formation widths (m)</th>
                <th rowSpan="2" width="180">Remarks</th>
              </tr>
              <tr>
                <th width="70">km</th>
                <th width="90">m</th>
                <th width="100">Left</th>
                <th width="100">Right</th>
                <th width="120">Total width</th>
              </tr>
            </thead>
            <tbody>
              {Array.from({ length: MEASUREMENT_ROWS }, (_, i) => {
                const r = measurementRow(i);
                return (
                  <tr key={i}>
                    <td className="text-center">{r.sl}</td>
                    <td className="text-center">{r.point}</td>
                    <td className="text-center">{r.km}</td>
                    <td className="text-center">{r.m}</td>
                    <td className="text-center">{r.leftFormation}</td>
                    <td className="text-center">{r.rightFormation}</td>
                    <td className="text-center">{r.formationWidth}</td>
                    <td>{r.remarks || '\u00a0'}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
