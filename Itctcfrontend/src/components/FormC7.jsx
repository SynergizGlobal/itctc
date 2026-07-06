import useStickyHeaders from '../hooks/useStickyHeaders';
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
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form C-7</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_C-7.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>
      <div className="table-responsive">
        <table className="table table-bordered table-striped table-sm align-middle form-table export-table mb-0" width="1636" border="1">
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
    </div>
  );
}
