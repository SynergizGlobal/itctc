import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

const sectionFields = [
  { prefix: 'no', type: 'text' },
  { prefix: 'km', type: 'text' },
  { prefix: 'sep', type: 'text' },
  { prefix: 'm', type: 'text' },
  { prefix: 'g1_1', type: 'text' }, { prefix: 'g1_2', type: 'text' }, { prefix: 'g1_3', type: 'text' },
  { prefix: 'g2_1', type: 'text' }, { prefix: 'g2_2', type: 'text' }, { prefix: 'g2_3', type: 'text' },
  { prefix: 'g3_1', type: 'text' }, { prefix: 'g3_2', type: 'text' }, { prefix: 'g3_3', type: 'text' },
  { prefix: 'g4_1', type: 'text' }, { prefix: 'g4_2', type: 'text' }, { prefix: 'g4_3', type: 'text' },
  { prefix: 'alignment', type: 'select', options: ['--', 'Longitudinal', 'Lateral'] },
  { prefix: 'welding', type: 'select', options: ['--', 'GP', 'FB', 'EA'] },
  { prefix: 'origin', type: 'text' },
  { prefix: 'end', type: 'text' },
];

const renderSection = (num) => (
  <tr key={`section-row-${num}`}>
    {sectionFields.map((field, j) => (
      <td key={j}>
        {field.type === 'select' ? (
          <select className="form-control form-control-sm table-input" name={`${field.prefix}${num}[]`} defaultValue="">
            {field.options.map((opt, k) => (
              <option key={k} value={opt === '--' ? '' : opt}>{opt}</option>
            ))}
          </select>
        ) : (
          <input type="text" className="form-control form-control-sm table-input" name={`${field.prefix}${num}[]`} defaultValue="" />
        )}
      </td>
    ))}
  </tr>
);

export default function FormT5() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-5</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_T-5.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>

      <div className="d-flex align-items-center gap-3 mb-3 flex-wrap">
        <span className="title-main">Measurement record of Rail head shape (Per 1.0 m span) No.</span>
        <span className="ms-auto">Date: <input type="text" className="form-control form-control-sm d-inline-block" style={{ width: '100px' }} placeholder="/ /" /></span>
      </div>

      <div className="tolerance-info mb-3">
        <strong>Finished tolerance for Rail welds</strong> &nbsp; Lateral alignment : &plusmn; 0.3 mm, Longitudinal alignment : 0 mm - +0.3 mm
      </div>

      <div className="table-responsive">
        <table className="table table-bordered table-sm align-middle form-table export-table mb-0" width="2000" border="1">
          <thead>
            <tr>
              <th rowSpan="3" width="50">No.</th>
              <th colSpan="3" rowSpan="2" width="130">Chainage</th>
              <th colSpan="8" width="480">Down Line</th>
              <th colSpan="8" width="480">Up Line</th>
              <th rowSpan="3" width="100">Track Alignment</th>
              <th rowSpan="3" width="130">Type of welding</th>
              <th rowSpan="3" width="80">Origin side</th>
              <th rowSpan="3" width="80">End side</th>
            </tr>
            <tr>
              <th colSpan="4" width="240">G1</th>
              <th colSpan="4" width="240">G2</th>
              <th colSpan="4" width="240">G3</th>
              <th colSpan="4" width="240">G4</th>
            </tr>
            <tr>
              <th width="50">km</th><th width="30">/</th><th width="50">m</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
              <th width="60">(1)</th><th width="60">(2)</th><th width="60">(3)</th>
            </tr>
          </thead>
          <tbody>
            <tr><th className="sub-heading" colSpan="23">(1)</th></tr>
            {renderSection(1)}
            <tr><th className="sub-heading" colSpan="23">(2)</th></tr>
            {renderSection(2)}
            <tr><th className="sub-heading" colSpan="23">(3)</th></tr>
            {renderSection(3)}

            <tr><th colSpan="23" className="sub-heading">Longitudinal alignment</th></tr>
            <tr>
              <td colSpan="23" className="p-2">
                <table className="table table-bordered table-sm table-input align-middle mb-0" style={{ width: '100%', fontSize: '12px' }}>
                  <thead><tr><th width="60">No.</th><th width="100">Chainage</th><th width="130">Measured value (mm)</th><th width="130">Design value (mm)</th><th width="130">Irregularity (mm)</th><th>Remarks</th></tr></thead>
                  <tbody><tr>
                    {['longNo', 'longChainage', 'longMeasured', 'longDesign', 'longIrregularity', 'longRemarks'].map((n, i) => (
                      <td key={i}><input type="text" className="form-control form-control-sm table-input" name={`${n}1[]`} /></td>
                    ))}
                  </tr></tbody>
                </table>
              </td>
            </tr>

            <tr><th colSpan="23" className="sub-heading">Lateral alignment</th></tr>
            <tr>
              <td colSpan="23" className="p-2">
                <table className="table table-bordered table-sm table-input align-middle mb-0" style={{ width: '100%', fontSize: '12px' }}>
                  <thead><tr><th width="60">No.</th><th width="100">Chainage</th><th width="130">Measured value (mm)</th><th width="130">Design value (mm)</th><th width="130">Irregularity (mm)</th><th>Remarks</th></tr></thead>
                  <tbody><tr>
                    {['latNo', 'latChainage', 'latMeasured', 'latDesign', 'latIrregularity', 'latRemarks'].map((n, i) => (
                      <td key={i}><input type="text" className="form-control form-control-sm table-input" name={`${n}1[]`} /></td>
                    ))}
                  </tr></tbody>
                </table>
              </td>
            </tr>

            <tr><th colSpan="23" className="sub-heading">Track Alignment</th></tr>
            <tr>
              <td colSpan="23" className="p-2">
                <table className="table table-bordered table-sm table-input align-middle mb-0" style={{ width: '100%', fontSize: '12px' }}>
                  <thead><tr><th width="60">No.</th><th width="100">Chainage</th><th width="130">Longitudinal (mm)</th><th width="130">Lateral (mm)</th><th>Remarks</th></tr></thead>
                  <tbody><tr>
                    {['trackNo', 'trackChainage', 'trackLong', 'trackLat', 'trackRemarks'].map((n, i) => (
                      <td key={i}><input type="text" className="form-control form-control-sm table-input" name={`${n}1[]`} /></td>
                    ))}
                  </tr></tbody>
                </table>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}
