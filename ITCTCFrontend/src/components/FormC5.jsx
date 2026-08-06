import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';

const MEASUREMENT_ROWS = 16;

function measurementRow(index) {
  const km = Math.floor((50 + index * 10) / 1000);
  const m = (50 + index * 10) % 1000;
  return {
    sl: String(index + 1).padStart(2, '0'),
    point: `P${index + 1}`,
    km,
    m,
    distance: (2.0 + index * 0.05).toFixed(2),
    height: (0.5 + index * 0.01).toFixed(2),
    remarks: '',
  };
}

export default function FormC5() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft /></button>
        <h1 className="h6 mb-0">Form C-5</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of the distance and height of platform</span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-C-5.xls')} title="Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div className="d-flex gap-3 align-items-start mb-3">
        <div className="flex-grow-1" style={{ overflow: 'auto' }}>
          <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
            <thead>
              <tr>
                <th>SL No.</th>
                <th>Measurement point</th>
                <th>Chainage km</th>
                <th>Chainage m</th>
                <th>Distance (m)</th>
                <th>Height (m)</th>
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
                    <td className="text-center">{r.distance}</td>
                    <td className="text-center">{r.height}</td>
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
