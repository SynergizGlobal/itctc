import { useState } from 'react';
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

const initialData = Array.from({ length: 52 }, (_, i) => ({
  chainageKm: '101',
  chainageSeparator: '/',
  chainageM: String(500 + i * 10),
  typeOfStructure: i % 3 === 0 ? 'Bridge' : i % 3 === 1 ? 'Culvert' : 'Tunnel',
  straightCurve: i % 2 === 0 ? 'Straight' : 'Curve',
  appliedCant: String((i * 5) % 100),
  aMeasured: String(1190 + (i % 20)),
  xCalculatedForA: String(40 + (i % 15)),
  aStandard: '1250',
  aMeasuredFinal: String(1240 + (i % 10)),
  bMeasured: String(1170 + (i % 15)),
  bDashMeasured: String(1175 + (i % 10)),
  bStandard: '1190',
  bMeasuredFinal: String(1180 + (i % 12)),
  cMeasured: String(1210 + (i % 15)),
  xCalculatedForC: String(35 + (i % 10)),
  cStandard: '1260',
  cMeasuredFinal: String(1250 + (i % 12)),
  dStandard: '500',
  dMeasured: String(495 + (i % 10)),
  remarks: i % 4 === 0 ? 'OK' : i % 4 === 1 ? 'Check' : i % 4 === 2 ? 'Needs repair' : 'Verified'
}));

const ROWS_PER_PAGE = 5;

export default function FormC1() {
  const [page, setPage] = useState(1);
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const totalPages = Math.ceil(initialData.length / ROWS_PER_PAGE);
  const pageData = initialData.slice((page - 1) * ROWS_PER_PAGE, page * ROWS_PER_PAGE);

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
            {pageData.map((row, i) => (
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
      <div className="d-flex align-items-center justify-content-between mt-3">
        <small className="text-muted">Page {page} of {totalPages} ({initialData.length} rows)</small>
        <div className="btn-group btn-group-sm">
          <button className="btn btn-outline-secondary" disabled={page === 1} onClick={() => setPage(p => p - 1)}>Previous</button>
          {Array.from({ length: totalPages }, (_, i) => (
            <button key={i + 1} className={`btn ${i + 1 === page ? 'btn-primary' : 'btn-outline-secondary'}`} onClick={() => setPage(i + 1)}>{i + 1}</button>
          ))}
          <button className="btn btn-outline-secondary" disabled={page === totalPages} onClick={() => setPage(p => p + 1)}>Next</button>
        </div>
      </div>
    </div>
  );
}
