import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';

const MEASUREMENT_ROWS = 12;

const STRUCTURE_TYPES = ['Earthwork', 'Viaduct', 'Bridge'];

function measurementRow(index) {
  const base = 200 + index * 20;
  const km = Math.floor(base / 1000);
  const m = base % 1000;
  const type = STRUCTURE_TYPES[index % STRUCTURE_TYPES.length];
  const leftGauge = (1.67 + (index % 4) * 0.01).toFixed(2);
  const rightGauge = (1.67 + ((index + 1) % 4) * 0.01).toFixed(2);
  const clearance = (2.5 + (index % 3) * 0.05).toFixed(2);
  return {
    sl: String(index + 1).padStart(2, '0'),
    point: `P${index + 1}`,
    km,
    m,
    type,
    leftGauge,
    rightGauge,
    clearance,
    remarks: '',
  };
}

export default function FormC4() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form C-4</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of structure gauge (Earthwork, Viaduct and Bridge section)</span>
        <span>No. <input type="text" defaultValue="C4-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-C-4.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
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
                <th rowSpan="2" width="140">Structure type</th>
                <th colSpan="2">Gauge (m)</th>
                <th rowSpan="2" width="120">Clearance (m)</th>
                <th rowSpan="2" width="160">Remarks</th>
              </tr>
              <tr>
                <th width="70">km</th>
                <th width="90">m</th>
                <th width="100">Left</th>
                <th width="100">Right</th>
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
                    <td className="text-center">{r.type}</td>
                    <td className="text-center">{r.leftGauge}</td>
                    <td className="text-center">{r.rightGauge}</td>
                    <td className="text-center">{r.clearance}</td>
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
