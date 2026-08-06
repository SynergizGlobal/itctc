import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 20;

const SPACING_DESIGN = 4.7;
const variations = [0.02, -0.03, 0.01, -0.02, 0.03, -0.01, 0.02, -0.03, 0.04, -0.02, 0.01, -0.03, 0.02, -0.01, 0.03, -0.02, 0.04, -0.03, 0.01, 0.02];

function measurementRow(index) {
  const variation = variations[index];
  const spacing = SPACING_DESIGN + variation;
  return [
    String(index + 1).padStart(2, '0'),
    `P${index + 1}`,
    '1',
    String(100 + index * 25),
    spacing.toFixed(2),
    '',
  ];
}

function TrackSpacingDiagram() {
  return (
    <div style={{ width: '100%', maxWidth: '560px', border: '1px solid #ccc', borderRadius: '4px', padding: '18px', background: '#fff' }}>
      <div style={{ textAlign: 'center', fontSize: '12px', fontWeight: 600, marginBottom: '14px' }}>Track Centre Spacing</div>
      <div style={{ border: '2px solid #000', height: '6px', borderRadius: '2px', background: '#555' }}></div>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', margin: '6px 0', fontSize: '11px', color: '#666' }}>
        <span>Track 1 centre</span>
        <div style={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
          <span style={{ borderTop: '1px dashed #000', width: '140px', height: '1px', position: 'relative' }}>
            <span style={{ position: 'absolute', right: '-4px', top: '-4px', fontSize: '10px' }}>&#9654;</span>
          </span>
          <span style={{ fontSize: '12px', fontWeight: 700 }}>S</span>
          <span style={{ borderTop: '1px dashed #000', width: '140px', height: '1px', position: 'relative' }}>
            <span style={{ position: 'absolute', left: '-4px', top: '-4px', fontSize: '10px' }}>&#9664;</span>
          </span>
        </div>
        <span>Track 2 centre</span>
      </div>
      <div style={{ border: '2px solid #000', height: '6px', borderRadius: '2px', background: '#555' }}></div>
      <div style={{ textAlign: 'center', fontSize: '11px', color: '#666', marginTop: '14px' }}>S = Track centre spacing (m)</div>
    </div>
  );
}

export default function FormT1() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
<button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Track centre spacing between tracks</span>
        <span>No. <input type="text" defaultValue="T1-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div className="d-flex gap-3 align-items-start mb-3">
        <div className="flex-grow-1" style={{ overflow: 'auto' }}>
          <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
            <thead>
              <tr>
                <th className="vertical-text" width="50" rowSpan="2">SL No.</th>
                <th width="90" rowSpan="2">Measurement point</th>
                <th colSpan="2">Chainage</th>
                <th width="160" rowSpan="2">Track centre spacing<br />S (m)</th>
                <th width="220" rowSpan="2">Remarks</th>
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
                    <td>{row[5] || '\u00a0'}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
        <div className="flex-shrink-0">
          <TrackSpacingDiagram />
        </div>
      </div>
    </div>
  );
}
