import useStickyHeaders from '../hooks/useStickyHeaders';
import formT22Diagram from '../assets/images/Form_T-22.png';

const measurementRows = [
  ['P1', 245, 4980, 980, 3370, 3870], ['P2', 248, 5010, 1010, 3410, 3905],
  ['P3', 252, 4995, 995, 3395, 3890], ['P4', 250, 5005, 1005, 3405, 3895],
  ['P5', 247, 4990, 990, 3385, 3880],
];
export default function FormT22() {
  useStickyHeaders();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-22</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Buffer Stop (1st GRADE with GRAVEL FILL)</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
      </div>
      <div className="mb-3">
        <span className="me-1">Line:</span>
        <input type="text" className="d-inline-block" style={{ width: '300px', border: 'none', borderBottom: '1px solid #000', background: 'transparent', outline: 'none' }} />
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th, .compact-table.form-table thead td { background: none !important; background-color: transparent !important; }'}</style>
      <div className="d-flex" style={{ background: '#fff', border: '1px solid #000', borderRadius: '8px', padding: '12px', alignItems: 'flex-start', gap: '16px' }}>
        <div style={{ minWidth: 0, margin: '60px 0 0', width: '50%', overflow: 'auto' }}>
          <table border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ width: '100%', tableLayout: 'fixed', borderCollapse: 'collapse' }}>
            <thead>
            <tr style={{ height: '50px' }}>
              <th rowSpan={2} scope="col" style={{ width: '18%', position: 'relative', overflow: 'hidden' }}>
                <div style={{ position: 'absolute', top: 0, left: 0, width: '100%', height: '100%', background: 'linear-gradient(to top right, transparent calc(50% - 0.5px), #000 calc(50%), transparent calc(50% + 0.5px))' }}></div>
                <div style={{ position: 'absolute', top: '25%', left: '75%', transform: 'translate(-50%, -50%)', fontSize: '9px', textAlign: 'center' }}>Measurement<br />point</div>
                <div style={{ position: 'absolute', top: '75%', left: '25%', transform: 'translate(-50%, -50%)', fontSize: '9px', textAlign: 'center' }}>Location</div>
              </th>
                <th scope="col" style={{ width: '16%' }}>(1)</th>
                <th scope="col" style={{ width: '16%' }}>(2)</th>
                <th scope="col" style={{ width: '16%' }}>(3)</th>
                <th scope="col" style={{ width: '17%' }}>(4)</th>
                <th scope="col" style={{ width: '17%' }}>(5)</th>
              </tr>
            <tr style={{ height: '50px' }}>
              <td style={{ color: 'red' }}>(250 mm)</td>
                <td><div align="center" style={{ color: 'red' }}>(5,000 mm)</div></td>
                <td><div align="center" style={{ color: 'red' }}>(1,000 mm)</div></td>
                <td style={{ color: 'red' }}>(3,400 mm)</td>
                <td style={{ color: 'red' }}>(3,900 mm)</td>
              </tr>
            </thead>
            <tbody>
              {measurementRows.map((row, r) => (
                <tr key={r} style={{ height: '50px' }}>
                  {row.map((val, c) => (
                    <td key={c} style={{ height: '50px' }}>{typeof val === 'number' ? val.toLocaleString() : val}</td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="d-flex justify-content-center align-items-center" style={{ width: '50%' }}>
          <img src={formT22Diagram} alt="Buffer stop side and plane view reference diagram" style={{ width: '100%', maxWidth: '507px', height: 'auto', objectFit: 'contain', background: '#fff' }} />
        </div>
      </div>
    </div>
  );
}



