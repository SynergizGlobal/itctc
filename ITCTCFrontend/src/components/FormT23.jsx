import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 18;

const gaugeValues = [1435, 1436, 1435, 1434, 1435, 1436, 1435, 1435, 1434, 1435, 1436, 1435, 1435, 1434, 1435, 1436, 1435, 1435];
const checkGaugeValues = [1438, 1439, 1438, 1437, 1438, 1439, 1438, 1438, 1437, 1438, 1439, 1438, 1438, 1437, 1438, 1439, 1438, 1438];

function measurementRow(index) {
  return [
    String(index + 1).padStart(2, '0'),
    `T${index + 1}`,
    '1',
    String(100 + index * 25),
    gaugeValues[index],
    checkGaugeValues[index],
    '',
  ];
}

export default function FormT23() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
<button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-23</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of turnout [50kgN-1 in 9 (simple)]</span>
        <span>No. <input type="text" defaultValue="T23-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-23.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div style={{ overflow: 'auto' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th className="vertical-text" width="50" rowSpan="2">SL No.</th>
              <th width="90" rowSpan="2">Point No.</th>
              <th colSpan="2">Chainage</th>
              <th width="120" rowSpan="2">Gauge<br />(mm)</th>
              <th width="130" rowSpan="2">Check Gauge<br />(mm)</th>
              <th width="200" rowSpan="2">Remarks</th>
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
