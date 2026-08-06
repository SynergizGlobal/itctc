import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 12;

const camThickness = [55, 52, 58, 60, 54, 57, 51, 59, 56, 53, 58, 55];
const gaps = [0.4, 0.2, 0.5, 0.3, 0.4, 0.6, 0.2, 0.3, 0.5, 0.4, 0.3, 0.2];

function measurementRow(index) {
  return [
    index % 2 === 0 ? 'Up' : 'Down',
    String(index + 1).padStart(2, '0'),
    '1',
    String(100 + index * 25),
    camThickness[index],
    gaps[index],
    '',
  ];
}

export default function FormT71() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <style>{`.tolerance-table th:last-child, .tolerance-table td:last-child { border: none !important; background: none !important; }`}</style>
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
<button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-7-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of CAM injected thickness (Flat Plate)</span>
        <span>No. <input type="text" defaultValue="T71-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-7-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div style={{ overflow: 'visible', marginBottom: '1rem' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table tolerance-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th width="50">Tolerances</th>
              <th width="180">Thickness of CAM (Flat Plate) : <span style={{ color: 'red' }}>20 - 60 mm</span></th>
              <th width="160">Gap : Within <span style={{ color: 'red' }}>1 mm</span></th>
              <th width="50"></th>
            </tr>
          </thead>
        </table>
      </div>

      <div style={{ overflow: 'auto' }}>
        <table className="table table-striped table-bordered table-sm align-middle form-table measurement-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th width="70" rowSpan="2">Up /<br />Down</th>
              <th width="60" rowSpan="2">SL No.</th>
              <th colSpan="2">Chainage</th>
              <th width="160" rowSpan="2">CAM injection thickness<br />(mm)</th>
              <th width="120" rowSpan="2">Gap<br />(mm)</th>
              <th width="180" rowSpan="2">Remarks</th>
            </tr>
            <tr>
              <td width="70">km</td>
              <td width="90">m</td>
            </tr>
          </thead>
          <tbody>
            {Array.from({ length: MEASUREMENT_ROWS }, (_, i) => {
              const row = measurementRow(i);
              return (
                <tr key={i}>
                  <td className="text-center">{row[0]}</td>
                  <td className="text-center">{row[1]}</td>
                  <td className="text-center">{row[2]}</td>
                  <td className="text-center">{row[3]}</td>
                  <td className="text-center">{row[4]}</td>
                  <td className="text-center">{row[5]}</td>
                  <td>{row[6] || '\u00a0'}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}
