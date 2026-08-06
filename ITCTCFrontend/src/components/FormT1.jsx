import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 10;

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
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="d-flex gap-3">
        {[0, 1].map((tableIndex) => (
          <div key={tableIndex} style={{ overflow: 'auto', flexGrow: 1, minWidth: 0 }}>
            <table className="table table-bordered align-middle form-table export-table compact-table mb-0" border="1" style={{ width: '100%', borderCollapse: 'collapse' }}>
              <thead>
                <tr>
                  <th colSpan={3}>Chainage</th>
                  <th rowSpan={2} style={{ width: '12%' }}>Straight /<br />Curve</th>
                  <th rowSpan={2} style={{ width: '12%' }}>Design value (A)</th>
                  <th rowSpan={2} style={{ width: '12%' }}>Measured value (B)</th>
                  <th rowSpan={2} style={{ width: '12%', textAlign: 'center' }}>Difference<br />(B) - (A)</th>
                  <th rowSpan={2} style={{ width: '20%' }}>Remarks</th>
                </tr>
                <tr>
                  <td style={{ width: '7%' }}>km</td>
                  <td style={{ width: '8%' }}>m</td>
                  <td style={{ width: '8%' }}>cm</td>
                </tr>
              </thead>
              <tbody>
                {Array.from({ length: MEASUREMENT_ROWS }, (_, i) => (
                  <tr key={i} style={{ height: '35px' }}>
                    {Array.from({ length: 8 }, (_, c) => (
                      <td key={c} style={{ height: '35px' }}>&nbsp;</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        ))}
      </div>
    </div>
  );
}
