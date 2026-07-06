import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

const MEASUREMENT_ROWS = 18;

export default function FormT2() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-2</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_T-2.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>

      <div className="table-responsive mb-3">
        <table className="table table-bordered table-striped table-sm align-middle form-table tolerance-table export-table mb-0" style={{ marginLeft: '128px' }} width="1323" border="1">
          <thead>
            <tr>
              <th width="105" rowSpan="2">Tolerances</th>
              <th width="88" rowSpan="2">Slab Track</th>
              <td>Gauge</td>
              <td>Cross Level</td>
              <td colSpan="2">Longitudinal alignment</td>
              <th width="147" rowSpan="2">Ballasted Track</th>
              <td>Gauge</td>
              <td width="107">Cross Level</td>
              <td>Longitudinal alignment</td>
              <td>Lateral alignment</td>
            </tr>
            <tr>
              <td className="tolerance-value" width="73">&plusmn; 1</td>
              <td className="tolerance-value" width="123">&plusmn; 1</td>
              <td className="tolerance-value" width="67">&plusmn; 2/10 m-chord</td>
              <td className="tolerance-value" width="100">&plusmn; 2/10 m-chord</td>
              <td className="tolerance-value" width="73">&plusmn; 2</td>
              <td className="tolerance-value">&plusmn; 2</td>
              <td className="tolerance-value" width="202">&plusmn; 3/10 m-chord</td>
              <td className="tolerance-value" width="168">&plusmn; 3/10 m-chord</td>
            </tr>
          </thead>
        </table>
      </div>

      <div className="table-responsive">
        <table className="table table-striped table-bordered table-sm align-middle form-table measurement-table export-table mb-0" width="2544" border="1">
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
                {Array.from({ length: 39 }, (_, j) => (
                  <td key={j}>&nbsp;</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
