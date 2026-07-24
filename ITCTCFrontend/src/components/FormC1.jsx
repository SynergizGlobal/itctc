import { useNavigate } from 'react-router-dom';
import useStickyHeaders from '../hooks/useStickyHeaders';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';
import formC1Diagram from '../assets/images/Form_C-1.png';

const formC1Columns = [
  'chainageKm', 'chainageSeparator', 'chainageM',
  'typeOfStructure', 'straightCurve', 'typeOfTrack', 'appliedCant',
  'aMeasured', 'xCalculatedForA', 'aStandard', 'aMeasuredFinal',
  'bMeasured', 'bDashMeasured', 'bStandard', 'bMeasuredFinal',
  'cMeasured', 'xCalculatedForC', 'cStandard', 'cMeasuredFinal',
  'dStandard', 'dMeasured', 'remarks'
];

const sampleData = {
  chainageKm: '1.50', chainageSeparator: '', chainageM: '250.00',
  typeOfStructure: 'Earthwork A (Cutting Section)',
  straightCurve: 'Curve R=750',
  typeOfTrack: 'Down Line',
  appliedCant: '120.00',
  aMeasured: '100.00', xCalculatedForA: '750.00', aStandard: '850.00', aMeasuredFinal: '850.00',
  bMeasured: '100.00', bDashMeasured: '5205.00', bStandard: '5200.00', bMeasuredFinal: '5205.00',
  cMeasured: '100.00', xCalculatedForC: '750.00', cStandard: '850.00', cMeasuredFinal: '850.00',
  dStandard: '800.00', dMeasured: '795.00',
  remarks: 'Testing Save API'
};

export default function FormC1() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const columnHeaders = [
    { label: 'Chainage', colSpan: 3, rowSpan: 2 },
    { label: 'Type of Structure', rowSpan: 3 },
    { label: 'Straight/Curve (R = ***)', rowSpan: 3 },
    { label: 'Type of Track', rowSpan: 3 },
    { label: 'Applied cant value (mm)', rowSpan: 3 },
    { label: 'Width value (mm)', colSpan: 14, rowSpan: 1 },
    { label: 'Remarks (position of maintenance walkway, etc.)', rowSpan: 3 }
  ];

  const subHeaders = [
    'a', 'X', 'A=a+X', 'b', "b'", 'B = b (or b\')', 'c', 'X', 'C=c+X', 'D'
  ];

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate('/dashboard', { state: { activeNav: 'forms' } })} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form C-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of formation width (Earth work, Viaduct and Bridge section)</span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download Form C-1 as PDF" style={{ border: 'none' }}><i className="fa-solid fa-file-pdf" />PDF</button>
          <button type="button" onClick={() => downloadExcel('Form-C-1.xls')} title="Download Form C-1 as Excel" style={{ border: 'none' }}><i className="fa-solid fa-file-excel" />Excel</button>
        </div>
      </div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '8px' }}>
        <div style={{ width: '740px', height: '200px', border: '1px solid #ccc', borderRadius: '4px', overflow: 'hidden', background: '#fff' }}>
          <img src={formC1Diagram} alt="Formation width measurement reference diagram" style={{ width: '100%', height: '100%', objectFit: 'contain', display: 'block' }} />
        </div>
        <div>
          <table border="1" style={{ borderCollapse: 'collapse', fontSize: '11px', border: '1px solid #000', tableLayout: 'fixed', width: '260px' }}>
            <tbody>
              <tr>
                <td rowSpan="3" style={{ textAlign: 'center', verticalAlign: 'middle', fontWeight: 600, border: '1px solid #000', padding: '4px', width: '33.33%' }}>Witness</td>
                <td style={{ textAlign: 'center', border: '1px solid #000', padding: '4px', width: '33.33%' }}>NHSRCL</td>
                <td style={{ border: '1px solid #000', padding: '4px', width: '33.33%' }}>&nbsp;</td>
              </tr>
              <tr>
                <td style={{ textAlign: 'center', border: '1px solid #000', padding: '4px' }}>The Engineer</td>
                <td style={{ border: '1px solid #000', padding: '4px' }}>&nbsp;</td>
              </tr>
              <tr>
                <td style={{ textAlign: 'center', border: '1px solid #000', padding: '4px' }}>The Contractor</td>
                <td style={{ border: '1px solid #000', padding: '4px' }}>&nbsp;</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div style={{ overflow: 'auto' }}>
        <table className="table table-bordered table-striped table-hover table-sm align-middle form-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th colSpan="3" rowSpan="2">Chainage</th>
              <th width="66" rowSpan="3">Type of<br />Structure</th>
              <th width="75" rowSpan="3">Straight/<br />Curve<br />(R = ***)</th>
              <th width="66" rowSpan="3">Type of<br />Track</th>
              <th width="102" rowSpan="3">Applied<br />cant<br />value<br />(mm)</th>
              <th colSpan="14">Width value (mm)</th>
              <th width="233" rowSpan="3">Remarks<br />(position of maintenance walkway, etc.)</th>
            </tr>
            <tr>
              <td>a</td>
              <td>X</td>
              <td colSpan="2">A=a+X</td>
              <td>b</td>
              <td>b'</td>
              <td colSpan="2">B = b (or b')</td>
              <td>c</td>
              <td>X</td>
              <td colSpan="2">C=c+X</td>
              <td colSpan="2">D</td>
            </tr>
            <tr>
              <td colSpan="3"><span style={{ paddingRight: '50px' }}>KM</span><span>&nbsp;&nbsp;&nbsp; M</span></td>
              <td width="61">Measured value</td>
              <td width="64">Calculated value</td>
              <td width="55">Standard value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="57">Standard value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="64">Calculated value</td>
              <td width="55">Standard value</td>
              <td width="61">Measured value</td>
              <td width="55">Standard value</td>
              <td width="61">Measured value</td>
            </tr>
          </thead>
          <tbody>
            {Array.from({ length: 10 }, (_, i) => (
              <tr key={i}>
                {formC1Columns.map((col, j) => (
                  <td key={j}>
                    <input type="text" className="form-control form-control-sm table-input" name={`${col}[]`} defaultValue={i === 0 && sampleData[col] ? sampleData[col] : ''} />
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}



