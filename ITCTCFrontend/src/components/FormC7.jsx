import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import formC7Diagram from '../assets/images/Form_C-7.png';
import useDownloadExcel from '../hooks/useDownloadExcel';

const fieldNames = [
  'chainageKm', 'chainageSeparator', 'chainageM',
  'straightCurve', 'appliedCant', 'typeOfTrack',
  'h1Measured', 'h2Measured', 'h3Measured', 'h4Measured',
  'h5Measured', 'h6Measured',
  'aStandard', 'aMeasured',
  'bStandard', 'bMeasured',
  'remarks'
];

const ROWS = 16;

export default function FormC7() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form C-7</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of height of noise barrier (Earth work, Viaduct and Bridge section)</span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-C-7.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '8px' }}>
        <div style={{ width: '650px', height: '200px', border: '1px solid #ccc', borderRadius: '4px', overflow: 'hidden', background: '#fff' }}>
          <img src={formC7Diagram} alt="Noise barrier height measurement reference diagram" style={{ width: '100%', height: '100%', objectFit: 'contain', display: 'block' }} />
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
          <div style={{ fontSize: '9px', marginTop: '4px', lineHeight: 1.8, textAlign: 'left' }}>
            <span style={{ display: 'inline-block', width: '205px' }}>A: Height of noise barrier of Down line</span>Measurement points:<br />
            <span style={{ display: 'inline-block', width: '205px' }}>B: Height of noise barrier of Up line</span>Every <span style={{ color: 'red' }}>50 m</span> in straight section<br />
            <span style={{ display: 'inline-block', width: '205px' }}>h1, h2, h3, h4: Each rail level</span>Every <span style={{ color: 'red' }}>20 m</span> in curve section<br />
            <span style={{ display: 'inline-block', width: '205px' }}>h5, h6: Measured level at the top of noise barrier</span>Start and end points of each type
          </div>
        </div>
      </div>
      <div style={{ overflow: 'auto' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th colSpan="3" rowSpan="2">Chainage</th>
              <th width="75" rowSpan="3">Straight/<br />Curve<br />(R = ***)</th>
              <th width="102" rowSpan="3">Applied<br />cant<br />value<br />(mm)</th>
              <th width="102" rowSpan="3">Type of<br />track</th>
              <th colSpan="10">Height value (mm)</th>
              <th width="233" rowSpan="3">Remarks</th>
            </tr>
            <tr>
              <td>h1</td>
              <td>h2</td>
              <td>h3</td>
              <td>h4</td>
              <td>h5</td>
              <td>h6</td>
              <td colSpan="2">A = (h1 + h2) / 2 + h5</td>
              <td colSpan="2">B = (h3 + h4) / 2 + h6</td>
            </tr>
            <tr>
              <td colSpan="3">KM &nbsp;&nbsp;&nbsp; M</td>
              <td width="61">Measured value</td>
              <td width="64">Measured value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="61">Measured value</td>
              <td width="55">Standard value</td>
              <td width="61">Measured value</td>
              <td width="55">Standard value</td>
              <td width="61">Measured value</td>
            </tr>
          </thead>
          <tbody>
            {Array.from({ length: ROWS }, (_, i) => (
              <tr key={i}>
                {fieldNames.map((name, j) => (
                  <td key={j}>
                    <input type="text" className="form-control form-control-sm table-input" name={`${name}[]`} defaultValue="" />
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div style={{ marginTop: '8px', fontSize: '12px' }}>Record the structure type of main line in the note column</div>
    </div>
  );
}



