import useStickyHeaders from '../hooks/useStickyHeaders';
import formT13Diagram from '../assets/images/Form_T-13.png';

function StaticDiagram() {
  return <div style={{ width: '914px', height: '188px', border: '1px solid #ccc', borderRadius: '4px', background: `#fff url(${formT13Diagram}) center/contain no-repeat` }} />;
}

const tableHeaders = (
  <thead>
    <tr style={{ height: '40px' }}>
      <th scope="col" style={{ width: '36%' }}>Chainage and Location of the Fouling Mark</th>
      <th scope="col" style={{ width: '14%' }}>Design value (m)</th>
      <th scope="col" style={{ width: '19%' }}>Measured value (m)</th>
      <th scope="col" style={{ width: '15%' }}>Difference (m)</th>
      <th scope="col" style={{ width: '16%' }}>Remarks</th>
    </tr>
  </thead>
);

const tableBody = (
  <tbody>
    {Array.from({ length: 10 }, (_, r) => (
      <tr key={r}>
        {Array.from({ length: 5 }, (_, c) => (
          <td key={c}>&nbsp;</td>
        ))}
      </tr>
    ))}
  </tbody>
);

export default function FormT13() {
  useStickyHeaders();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-13</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Fouling Mark</span>
      </div>
      <style>{'.compact-table td { padding: 6px 4px !important; font-size: 12px; line-height: 1.4; } .compact-table { font-size: 12px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 4px 4px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="mb-2">
        <span className="me-1">Line:</span>
        <input type="text" className="d-inline-block" style={{ width: '120px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} />
      </div>
      <div className="mb-3 d-flex justify-content-center">
        <StaticDiagram />
      </div>

      <div style={{ overflow: 'auto' }}>
        <table border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ width: '100%', borderCollapse: 'collapse' }}>
          {tableHeaders}
          {tableBody}
        </table>
      </div>
    </div>
  );
}
