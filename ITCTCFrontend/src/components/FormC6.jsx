import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';

const MEASUREMENT_ROWS = 14;

function measurementRow(index) {
  const base = 300 + index * 15;
  return {
    sl: String(index + 1).padStart(2, '0'),
    point: `P${index + 1}`,
    km: Math.floor(base / 1000),
    m: base % 1000,
    leftGauge: (1.67 + (index % 3) * 0.01).toFixed(2),
    rightGauge: (1.67 + ((index + 1) % 3) * 0.01).toFixed(2),
    clearance: (2.8 + (index % 4) * 0.02).toFixed(2),
    remarks: '',
  };
}

export default function FormC6() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft /></button>
        <h1 className="h6 mb-0">Form C-6</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of structure gauge (Tunnel section)</span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-C-6.xls')} title="Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <div className="d-flex gap-3 align-items-start mb-3">
        <div className="flex-grow-1" style={{ overflow: 'auto' }}>
          <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
            <thead>
              <tr>
                <th>SL No.</th>
                <th>Point</th>
                <th>km</th>
                <th>m</th>
                <th>Left Gauge (m)</th>
                <th>Right Gauge (m)</th>
                <th>Clearance (m)</th>
                <th>Remarks</th>
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
