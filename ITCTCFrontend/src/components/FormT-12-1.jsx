import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

export default function FormT121() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <style>{`.compact-table td { padding: 4px 3px !important; font-size: 9px; line-height: 1.2; } .compact-table { font-size: 9px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 4px 3px !important; } .compact-table th { background: none !important; background-color: transparent !important; } .diagonal-cell { position: relative; overflow: hidden; } .diagonal-cell::after { content: ''; position: absolute; top: 0; left: 0; width: 100%; height: 100%; background: linear-gradient(to bottom right, transparent calc(50% - 1px), #000 50%, transparent calc(50% + 1px)); pointer-events: none; } .no-bg { background: none !important; background-color: transparent !important; }`}</style>
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-12-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Expansion Joint (EJ)</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-12-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div style={{ overflow: 'visible', marginBottom: '1rem', display: 'flex', justifyContent: 'flex-end' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table tolerance-table export-table compact-table mb-0" border="1" width="200">
          <thead>
            <tr>
               <th width="30" className="no-bg" style={{ textAlign: 'right', padding: '1px', fontSize: '8px' }}>TH</th>
              <th width="55" className="no-bg" style={{ textAlign: 'right', padding: '1px', fontSize: '8px' }}>Gauge</th>
              <th width="55" style={{ textAlign: 'right', padding: '1px', fontSize: '8px' }}>Cross level</th>
              <th width="55" style={{ textAlign: 'right', padding: '1px', fontSize: '8px' }}>Lateral alignment</th>
              <th width="55" className="no-bg" style={{ textAlign: 'right', padding: '1px', fontSize: '8px' }}>Longitudinal alignment</th>
            </tr>
          </thead>
        </table>
      </div>

      <div style={{ overflow: 'visible' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table export-table compact-table mb-0" border="1" width="420">
          <thead>
            <tr>
              <th colSpan={2} scope="col"><div align="center">Measurement item</div></th>
              <th width="30" scope="col">(1)</th>
              <th width="28" scope="col">(2)</th>
              <th width="34" scope="col">(3)</th>
              <th width="34" scope="col">(4)</th>
              <th width="28" scope="col">(5)</th>
              <th width="32" scope="col">(6)</th>
              <th width="34" scope="col">(7)</th>
              <th width="100" scope="col">Remarks</th>
            </tr>
          </thead>
          <tbody>
            {[
              { section: 'Design value (mm)', items: ['Gauge', 'Cross level', 'Longitudinal alignment', 'Lateral alignment'] },
              { section: 'Measured value (mm)', items: ['Gauge', 'Cross level', 'Longitudinal alignment', 'Lateral alignment'] },
              { section: 'Irregularity ± 2 mm / 10 m (mm)', items: ['Gauge', 'Cross level', 'Longitudinal alignment', 'Lateral alignment'] },
            ].map((group, gIdx) => (
              group.items.map((item, rIdx) => {
                const isDiagonal = (item === 'Longitudinal alignment' || item === 'Lateral alignment');
                return (
                  <tr key={`${gIdx}-${rIdx}`}>
                    {rIdx === 0 && (
                      <td rowSpan={4} width="145"><div align="center">{group.section}</div></td>
                    )}
                    <td width="127">{item}</td>
                    <td className={isDiagonal ? 'diagonal-cell' : ''}>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td className={isDiagonal ? 'diagonal-cell' : ''}>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td className={isDiagonal ? 'diagonal-cell' : ''}>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td className={isDiagonal ? 'diagonal-cell' : ''}>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                );
              })
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
