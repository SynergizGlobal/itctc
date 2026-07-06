import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

const formC1Columns = [
  'chainageKm', 'chainageSeparator', 'chainageM',
  'typeOfStructure', 'straightCurve', 'appliedCant',
  'aMeasured', 'xCalculatedForA', 'aStandard', 'aMeasuredFinal',
  'bMeasured', 'bDashMeasured', 'bStandard', 'bMeasuredFinal',
  'cMeasured', 'xCalculatedForC', 'cStandard', 'cMeasuredFinal',
  'dStandard', 'dMeasured', 'remarks'
];

const initialData = [
  { chainageKm: '101', chainageSeparator: '/', chainageM: '500', typeOfStructure: 'Bridge', straightCurve: 'Straight', appliedCant: '0', aMeasured: '1200', xCalculatedForA: '50', aStandard: '1250', aMeasuredFinal: '1248', bMeasured: '1180', bDashMeasured: '1185', bStandard: '1190', bMeasuredFinal: '1188', cMeasured: '1220', xCalculatedForC: '40', cStandard: '1260', cMeasuredFinal: '1259', dStandard: '500', dMeasured: '499', remarks: 'OK' },
  { chainageKm: '101', chainageSeparator: '/', chainageM: '600', typeOfStructure: 'Culvert', straightCurve: 'Curve', appliedCant: '75', aMeasured: '1195', xCalculatedForA: '55', aStandard: '1250', aMeasuredFinal: '1247', bMeasured: '1176', bDashMeasured: '1181', bStandard: '1190', bMeasuredFinal: '1186', cMeasured: '1218', xCalculatedForC: '42', cStandard: '1260', cMeasuredFinal: '1258', dStandard: '500', dMeasured: '501', remarks: 'Check' }
];

export default function FormC1() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const columnHeaders = [
    { label: 'Chainage', colSpan: 3, rowSpan: 2 },
    { label: 'Type of Structure', rowSpan: 3 },
    { label: 'Straight/Curve (R = ***)', rowSpan: 3 },
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
        <h1 className="h6 mb-0">Form C-1</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_C-1.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>
      <div className="table-responsive">
        <table className="table table-bordered table-striped table-hover table-sm align-middle form-table export-table mb-0" width="1600" border="1">
          <thead>
            <tr>
              <th colSpan="3" rowSpan="2">Chainage</th>
              <th width="66" rowSpan="3">Type of<br />Structure</th>
              <th width="75" rowSpan="3">Straight/<br />Curve<br />(R = ***)</th>
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
              <td colSpan="3">KM &nbsp;&nbsp;&nbsp; M</td>
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
            {initialData.map((row, i) => (
              <tr key={i}>
                {formC1Columns.map((col, j) => (
                  <td key={j}>
                    <input type="text" className="form-control form-control-sm table-input" name={`${col}[]`} defaultValue={row[col] || ''} />
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
