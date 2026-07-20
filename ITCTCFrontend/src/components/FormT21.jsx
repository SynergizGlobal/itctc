import useStickyHeaders from '../hooks/useStickyHeaders';
import formT21Diagram from '../assets/images/Form_T-21.png';

export default function FormT21() {
  useStickyHeaders();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-21</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Track effective length in stations and depots</span>
        <span>Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
      </div>
      <style>{'.compact-table td { padding: 6px 4px !important; font-size: 12px; line-height: 1.4; } .compact-table { font-size: 12px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 4px 4px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="mb-3">
        <span className="me-1">Location:</span>
        <input type="text" className="d-inline-block" style={{ width: '300px', border: 'none', borderBottom: '1px solid #000', background: 'transparent', outline: 'none' }} />
      </div>

      <div style={{ overflow: 'auto' }}>
        <table border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr>
              <th rowSpan={2} scope="col" style={{ width: '12%' }}>Line</th>
              <th rowSpan={2} scope="col" style={{ width: '10%' }}>Chainage</th>
              <th colSpan={2} scope="col" style={{ width: '28%' }}>Distance from Fouling Mark to<br />Insulated Joint</th>
              <th colSpan={3} scope="col" style={{ width: '38%' }}>Track effective length<br />(Insulated Joint + 1.0 m - The Stop Limit Sign)</th>
              <th rowSpan={2} scope="col" style={{ width: '12%' }}>Remarks</th>
            </tr>
            <tr>
              <td><div align="center">Design value<br />(A)</div></td>
              <td><div align="center">Measured value<br />(D)</div></td>
              <td><div align="center">Design value<br />(B)</div></td>
              <td><div align="center">Measured value<br />(E)</div></td>
              <td><div align="center">Irregularity<br />(E)-(B)</div></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td><div align="center" style={{ color: 'blue' }}>5.0 m or more</div></td>
              <td>&nbsp;</td>
              <td><div align="center" style={{ color: 'blue' }}>332.0 m</div></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            {Array.from({ length: 7 }, (_, r) => (
              <tr key={r}>
                {Array.from({ length: 8 }, (_, c) => (
                  <td key={c}>&nbsp;</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="d-flex justify-content-center mt-2">
        <img src={formT21Diagram} alt="Form T-21 reference diagram" style={{ width: '497px', height: '250px', objectFit: 'contain', background: '#fff' }} />
      </div>
    </div>
  );
}

