import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

const tableHeaders = (
  <thead>
    <tr style={{ height: '32px' }}>
      <th rowSpan={2} scope="col" style={{ width: '10%' }}>Up /<br />Down</th>
      <th colSpan={3} scope="col" style={{ width: '20%' }}>Chainage</th>
      <th rowSpan={2} scope="col" style={{ width: '9%' }}>Sleeper<br />No.</th>
      <th colSpan={2} scope="col" style={{ width: '25%' }}>Measured value (Nm)</th>
      <th rowSpan={2} scope="col" style={{ width: '14%' }}>Remarks</th>
    </tr>
    <tr style={{ height: '28px' }}>
      <td style={{ width: '5%' }}>km</td>
      <td style={{ width: '7%' }}>m</td>
      <td style={{ width: '8%' }}>CM</td>
      <td style={{ width: '14%' }}>Left</td>
      <td style={{ width: '13%' }}>Right</td>
    </tr>
  </thead>
);

const tableBody = (
  <tbody>
    {Array.from({ length: 6 }, (_, r) => (
      <tr key={r} style={{ height: '35px' }}>
        {Array.from({ length: 8 }, (_, c) => (
          <td key={c} style={{ height: '35px' }}>&nbsp;</td>
        ))}
      </tr>
    ))}
  </tbody>
);

const renderTable = (key) => (
  <div style={{ overflow: 'auto', minWidth: 0 }} key={key}>
    <table className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ width: '100%', borderCollapse: 'collapse' }}>
      {tableHeaders}
      {tableBody}
    </table>
  </div>
);

export default function FormT10() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-10</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Fastening Bolt with Synthetic Sleepers</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <button type="button" className="btn btn-sm ms-1 p-1" style={{ background: 'none', border: '1px solid #ccc', lineHeight: 1 }} onClick={() => downloadExcel('Form_T-10.xls')}>
          <i className="fa fa-download" aria-hidden="true" style={{ fontSize: 12 }}></i>
        </button>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="d-flex justify-content-between align-items-center mb-2">
        <div className="fw-bold" style={{ textDecoration: 'underline' }}>Solid-bed Track</div>
        <table className="table table-bordered table-sm align-middle mb-0" border="1" style={{ width: 400, fontSize: '12px' }}>
          <tbody>
            <tr>
              <td>Standard value</td>
              <td><span style={{ color: 'red' }}>150 Nm</span></td>
            </tr>
            <tr>
              <td>Tolerances</td>
              <td><span style={{ color: 'red' }}>± 10 %</span></td>
            </tr>
          </tbody>
        </table>
      </div>

      <div className="mt-1 mb-2 text-start" style={{ fontSize: '12px' }}>*( ) indicates Construction Chainage.</div>
      <div className="row g-3">
        <div className="col-md-6">{renderTable(0)}</div>
        <div className="col-md-6">{renderTable(1)}</div>
        <div className="col-md-6">{renderTable(2)}</div>
        <div className="col-md-6">{renderTable(3)}</div>
      </div>
    </div>
  );
}
