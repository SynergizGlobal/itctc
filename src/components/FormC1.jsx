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

const data = Array.from({ length: 4 }, (_, i) => ({
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

const COLS_PER_PAGE = 5;
const totalColPages = Math.ceil(formC1Columns.length / COLS_PER_PAGE);

const headerDef = [
  [
    { lines: ['Long'], cStart: 0, cEnd: 2, rSpan: 2 },
    { lines: ['Type of', 'Structure'], cStart: 3, cEnd: 3, rSpan: 3, w: '66' },
    { lines: ['Straight/', 'Curve', '(R = ***)'], cStart: 4, cEnd: 4, rSpan: 3, w: '75' },
    { lines: ['Applied', 'cant', 'value', '(mm)'], cStart: 5, cEnd: 5, rSpan: 3, w: '102' },
    { lines: ['Width value (mm)'], cStart: 6, cEnd: 19, rSpan: 1 },
    { lines: ['Remarks', '(position of maintenance walkway, etc.)'], cStart: 20, cEnd: 20, rSpan: 3, w: '233' },
  ],
  [
    { lines: ['a'], cStart: 6, cEnd: 6 },
    { lines: ['X'], cStart: 7, cEnd: 7 },
    { lines: ['A=a+X'], cStart: 8, cEnd: 9 },
    { lines: ['b'], cStart: 10, cEnd: 10 },
    { lines: ["b'"], cStart: 11, cEnd: 11 },
    { lines: ["B = b (or b')"], cStart: 12, cEnd: 13 },
    { lines: ['c'], cStart: 14, cEnd: 14 },
    { lines: ['X'], cStart: 15, cEnd: 15 },
    { lines: ['C=c+X'], cStart: 16, cEnd: 17 },
    { lines: ['D'], cStart: 18, cEnd: 19 },
  ],
  [
    { lines: ['KM    M'], cStart: 0, cEnd: 2 },
    { lines: ['Measured value'], cStart: 6, cEnd: 6, w: '61' },
    { lines: ['Calculated value'], cStart: 7, cEnd: 7, w: '64' },
    { lines: ['Standard value'], cStart: 8, cEnd: 8, w: '55' },
    { lines: ['Measured value'], cStart: 9, cEnd: 9, w: '61' },
    { lines: ['Measured value'], cStart: 10, cEnd: 10, w: '61' },
    { lines: ['Measured value'], cStart: 11, cEnd: 11, w: '61' },
    { lines: ['Standard value'], cStart: 12, cEnd: 12, w: '57' },
    { lines: ['Measured value'], cStart: 13, cEnd: 13, w: '61' },
    { lines: ['Measured value'], cStart: 14, cEnd: 14, w: '61' },
    { lines: ['Calculated value'], cStart: 15, cEnd: 15, w: '64' },
    { lines: ['Standard value'], cStart: 16, cEnd: 16, w: '55' },
    { lines: ['Measured value'], cStart: 17, cEnd: 17, w: '61' },
    { lines: ['Standard value'], cStart: 18, cEnd: 18, w: '55' },
    { lines: ['Measured value'], cStart: 19, cEnd: 19, w: '61' },
  ],
];

function getVisibleCells(cells, vStart, vEnd) {
  return cells
    .filter(c => c.cStart <= vEnd && c.cEnd >= vStart)
    .map(c => {
      const s = Math.max(c.cStart, vStart);
      const e = Math.min(c.cEnd, vEnd);
      return { ...c, colSpan: e - s + 1 };
    });
}

export default function FormC1() {
  const [colPage, setColPage] = useState(1);
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const colStart = (colPage - 1) * COLS_PER_PAGE;
  const colEnd = Math.min(colStart + COLS_PER_PAGE - 1, formC1Columns.length - 1);
  const visibleCols = formC1Columns.slice(colStart, colEnd + 1);

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
            {headerDef.map((row, ri) => {
              const cells = getVisibleCells(row, colStart, colEnd);
              const Tag = ri === 0 ? 'th' : 'td';
              return (
                <tr key={ri}>
                  {cells.map((c, ci) => {
                    const attrs = {};
                    if (c.colSpan > 1) attrs.colSpan = c.colSpan;
                    if (c.rSpan > 1) attrs.rowSpan = c.rSpan;
                    if (c.w) attrs.width = c.w;
                    return (
                      <Tag key={ci} {...attrs}>
                        {c.lines.map((line, li) => (
                          <span key={li}>{li > 0 && <br />}{line}</span>
                        ))}
                      </Tag>
                    );
                  })}
                </tr>
              );
            })}
          </thead>
          <tbody>
            {data.map((row, i) => (
              <tr key={i}>
                {visibleCols.map((col, j) => (
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
        <small className="text-muted">Cols {colStart + 1}&ndash;{Math.min(colEnd + 1, formC1Columns.length)} of {formC1Columns.length} &mdash; {data.length} rows</small>
        <div className="btn-group btn-group-sm">
          <button className="btn btn-outline-secondary" disabled={colPage === 1} onClick={() => setColPage(p => p - 1)}>Previous</button>
          {Array.from({ length: totalColPages }, (_, i) => (
            <button key={i + 1} className={`btn ${i + 1 === colPage ? 'btn-primary' : 'btn-outline-secondary'}`} onClick={() => setColPage(i + 1)}>{i + 1}</button>
          ))}
          <button className="btn btn-outline-secondary" disabled={colPage === totalColPages} onClick={() => setColPage(p => p + 1)}>Next</button>
        </div>
      </div>
    </div>
  );
}
