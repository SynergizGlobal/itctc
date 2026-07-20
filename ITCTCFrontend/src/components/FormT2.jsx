import useStickyHeaders from '../hooks/useStickyHeaders';

const MEASUREMENT_ROWS = 18;

const variations = [0.2, -0.4, 0.6, -0.3, 0.5, -0.7, 0.1, 0.4, -0.2, 0.7, -0.5, 0.3, -0.6, 0.2, 0.5, -0.4, 0.1, -0.3];

function measurementRow(index) {
  if (index >= 10) return Array(39).fill('');
  const down = variations[index];
  const up = variations[(index + 5) % variations.length];
  const chainageM = 250 + index * 10;
  const triplet = (design, variation, digits = 1) => [design.toFixed(digits), (design + variation).toFixed(digits), variation.toFixed(digits)];

  return [
    '', '',
    ...triplet(0, down * 0.8), ...triplet(0, down * 1.4), ...triplet(0, down * 1.2),
    ...triplet(0, down), ...triplet(1435, down, 1), `D${index + 1}`,
    '1', '+', chainageM.toFixed(0),
    `U${index + 1}`, ...triplet(1435, up, 1), ...triplet(0, up),
    ...triplet(0, up * 1.2), ...triplet(0, up * 1.4), ...triplet(0, up * 0.8),
    '', '',
  ];
}

export default function FormT2() {
  useStickyHeaders();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-2</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Finished state of track Irregularity</span>
        <span>No. <input type="text" defaultValue="T2-001" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" defaultValue="17/07/2026" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
      </div>

      <div style={{ overflow: 'auto', marginBottom: '1rem' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table tolerance-table export-table mb-0" style={{ marginLeft: '128px' }} border="1">
          <thead>
            <tr>
              <th width="105" rowSpan="2">Tolerances</th>
              <th width="88" rowSpan="2">Slab Track</th>
              <td>Gauge</td>
              <td>Cross Level</td>
              <td>Longitudinal alignment</td>
              <td>Lateral alignment</td>
              <th width="147" rowSpan="2">Ballasted Track</th>
              <td>Gauge</td>
              <td width="107">Cross Level</td>
              <td>Longitudinal alignment</td>
              <td>Lateral alignment</td>
            </tr>
            <tr>
              <td className="tolerance-value" width="73" style={{ color: 'red' }}>&plusmn; 1</td>
              <td className="tolerance-value" width="123" style={{ color: 'red' }}>&plusmn; 1</td>
              <td className="tolerance-value" width="67" style={{ color: 'red' }}>&plusmn; 2/10 m-chord</td>
              <td className="tolerance-value" width="100" style={{ color: 'red' }}>&plusmn; 2/10 m-chord</td>
              <td className="tolerance-value" width="73" style={{ color: 'red' }}>&plusmn; 2</td>
              <td className="tolerance-value" style={{ color: 'red' }}>&plusmn; 2</td>
              <td className="tolerance-value" width="202" style={{ color: 'red' }}>&plusmn; 3/10 m-chord</td>
              <td className="tolerance-value" width="168" style={{ color: 'red' }}>&plusmn; 3/10 m-chord</td>
            </tr>
          </thead>
        </table>
      </div>

      <div style={{ overflow: 'auto' }}>
        <table className="table table-striped table-bordered table-sm align-middle form-table measurement-table export-table mb-0" border="1">
          <thead>
            <tr>
              <th className="vertical-text diagram-text" width="57" rowSpan="3">Vertical curve diagram</th>
              <th className="vertical-text diagram-text" width="54" rowSpan="3">Plane curve diagram</th>
              <th colSpan="16">Down Line</th>
              <th className="chainage-heading" colSpan="3" rowSpan="2">Chainage</th>
              <th colSpan="16">Up Line</th>
              <th className="vertical-text diagram-text" width="66" rowSpan="3">Plane curve diagram</th>
              <th className="vertical-text diagram-text" width="66" rowSpan="3">Vertical curve diagram</th>
            </tr>
            <tr>
              <td colSpan="3">Twist</td>
              <td colSpan="3">Lateral alignment</td>
              <td colSpan="3">Longitudinal alignment</td>
              <td colSpan="3">Cross Level</td>
              <td colSpan="3">Gauge</td>
              <td className="vertical-text" width="63" rowSpan="2">Measuring point</td>
              <td className="vertical-text" width="63" rowSpan="2">Measuring point</td>
              <td colSpan="3">Gauge</td>
              <td colSpan="3">Cross Level</td>
              <td colSpan="3">Longitudinal alignment</td>
              <td colSpan="3">Lateral alignment</td>
              <td colSpan="3">Twist</td>
            </tr>
            <tr>
              <td className="vertical-text" width="45">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="75">Irregularity</td>
              <td className="vertical-text" width="47">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="47">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="46">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="47">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td width="54">km</td>
              <td width="54">&nbsp;</td>
              <td width="54">m</td>
              <td className="vertical-text" width="47">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="46">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="48">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="48">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
              <td className="vertical-text" width="48">Design value</td>
              <td className="vertical-text" width="65">Measured value</td>
              <td className="vertical-text" width="65">Irregularity</td>
            </tr>
          </thead>
          <tbody>
            {Array.from({ length: MEASUREMENT_ROWS }, (_, i) => (
              <tr key={i}>
                {Array.from({ length: 39 }, (_, j) => {
                  const row = measurementRow(i);
                  if (i === 0 && (j === 0 || j === 1 || j === 37 || j === 38)) {
                    return <td key={j} rowSpan={MEASUREMENT_ROWS}>&nbsp;</td>;
                  }
                  if (i > 0 && (j === 0 || j === 1 || j === 37 || j === 38)) {
                    return null;
                  }
                  return <td key={j}>{row[j] || '\u00a0'}</td>;
                })}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}


