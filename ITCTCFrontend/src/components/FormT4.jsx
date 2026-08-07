import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 20;

export default function FormT4() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
<button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-4</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Vertical Gradient</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-4.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; border: 1px solid #000 !important; } .compact-table { font-size: 10px; } .compact-table th { background: none !important; background-color: transparent !important; padding: 6px 4px !important; font-size: 11px; }'}</style>

      <div style={{ overflow: 'auto' }}>
        <div className="container-fluid py-3">
          <div className="mb-1" style={{ fontSize: '10px', lineHeight: '1.5', marginLeft: '20px' }}>Up / Down</div>
          <div className="table-responsive">
            <table width="100%" border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ borderCollapse: 'collapse' }}>
              <thead>
                <tr>
                  <th rowSpan={2} style={{ width: '9%' }}>Measuring point</th>
                  <th colSpan={3}>Chainage</th>
                  <th style={{ width: '10%' }}>Design Value (mm)</th>
                  <th style={{ width: '12%' }}>Measured value (mm)</th>
                  <th style={{ width: '10%' }}>Difference (mm)</th>
                  <th style={{ width: '12%' }}>&nbsp;</th>
                  <th rowSpan={2} style={{ width: '20%' }}>Remarks</th>
                </tr>
                <tr>
                  <td style={{ width: '10%' }}>km</td>
                  <td style={{ width: '10%' }}>m</td>
                  <td style={{ width: '10%' }}>Cm</td>
                  <td style={{ width: '10%' }}>(A)</td>
                  <td style={{ width: '12%' }}>(B)</td>
                  <td style={{ width: '10%' }}>(B) - (A)</td>
                  <td style={{ width: '12%' }}>Levelling value</td>
                </tr>
              </thead>
              <tbody>
                {Array.from({ length: MEASUREMENT_ROWS }, (_, i) => (
                  <tr key={i} style={{ height: '35px' }}>
                    {Array.from({ length: 9 }, (_, c) => (
                      <td key={c} style={{ height: '35px' }}>&nbsp;</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}
