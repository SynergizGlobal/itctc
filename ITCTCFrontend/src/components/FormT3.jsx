import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';

const DOWN_LINE_TIME_WEATHER_WIDTHS = [12, 11, 8, 10, 20, 24, 15, 13, 12, 8, 8, 7, 8, 7, 8, 7, 1, 7, 4, 7, 4, 7, 4, 7, 1, 7, 1, 7, 4, 7, 4, 7, 4, 7, 4, 7, 4, 19, 12];

const EMPTY_CELLS_20 = Array.from({ length: 20 });
const EMPTY_CELLS_39 = Array.from({ length: 39 });

const MeasurementHeader = ({ label }) => (
  <tr>
    <td width="107" className="text-cell">
      Measurement
      <br />
      date
    </td>
    <td colSpan={2} className="text-cell">
      <div className="text-center">{label}</div>
    </td>
    {EMPTY_CELLS_20.map((_, i) => (
      <td key={i} colSpan={i === EMPTY_CELLS_20.length - 1 ? 1 : 2}>
        &nbsp;
      </td>
    ))}
  </tr>
);

const TimeWeatherRow = ({ withWidths }) => (
  <tr>
    <td rowSpan={4}>&nbsp;</td>
    <td colSpan={2} className="text-cell">
      <div className="text-center">Time/Weather</div>
    </td>
    {withWidths
      ? DOWN_LINE_TIME_WEATHER_WIDTHS.map((w, i) => (
          <td key={i} width={w}>
            &nbsp;
          </td>
        ))
      : EMPTY_CELLS_39.map((_, i) => (
          <td key={i}>
            &nbsp;
          </td>
        ))}
  </tr>
);

const RailTempRow = () => (
  <tr>
    <td colSpan={2} className="text-cell">
      <div className="text-center">Rail temperature</div>
    </td>
    {EMPTY_CELLS_20.map((_, i) => (
      <td key={i} colSpan={2}>
        &nbsp;
      </td>
    ))}
  </tr>
);

const MovementRow = ({ withWidths }) => (
  <tr>
    {withWidths ? (
      <>
        <td width="116" rowSpan={2} className="text-cell">
          <div className="text-center">
            Amount of
            <br />
            movement
          </div>
        </td>
        <td width="78" rowSpan={2} className="text-cell">
          <div className="text-center">
            Left
            <br />
            Right
          </div>
        </td>
      </>
    ) : (
      <>
        <td rowSpan={2} className="text-cell">
          <div className="text-center">
            Amount of
            <br />
            movement
          </div>
        </td>
        <td rowSpan={2} className="text-cell">
          <div className="text-center">
            Left
            <br />
            Right
          </div>
        </td>
      </>
    )}
    {EMPTY_CELLS_20.map((_, i) => (
      <td key={i} colSpan={2}>
        &nbsp;
      </td>
    ))}
  </tr>
);

const EmptyRow = () => (
  <tr>
    {EMPTY_CELLS_20.map((_, i) => (
      <td key={i} colSpan={i === EMPTY_CELLS_20.length - 1 ? 4 : 2}>
        &nbsp;
      </td>
    ))}
  </tr>
);

const MeasurementGroup = ({ withWidths }) => (
  <>
    <TimeWeatherRow withWidths={withWidths} />
    <RailTempRow />
    <MovementRow withWidths={withWidths} />
    <EmptyRow />
  </>
);

export default function FormT3() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-3</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Continuous Welded Rail</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-3.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <div className="mb-1" style={{ fontSize: '10px', lineHeight: '1.5', marginLeft: '6px' }}>
        <div>Serial Number of RC anchor</div>
        <div>Reference points Operation Chainage</div>
        <div>Reference points Construction Chainage</div>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; border: 1px solid #000 !important; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } .compact-table th { background: none !important; background-color: transparent !important; } .text-cell { background-color: #cfe2ff !important; }'}</style>

      <div style={{ overflow: 'auto' }}>
        <div className="container-fluid py-3">
          <div className="table-responsive">
            <table width="100%" border="1" className="table table-bordered align-middle form-table export-table compact-table mb-3" style={{ borderCollapse: 'collapse' }}>
              <tbody>
                <tr>
                  <td width="316" rowSpan={3} style={{ position: 'relative' }} className="text-cell">
                    <div className="text-end" style={{ position: 'absolute', top: '6px', right: 0 }}>Tunnel</div>
                    <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', height: '100%', textAlign: 'right', transform: 'translateY(0px)' }}>
                      <div style={{ marginTop: '25px' }}>Design Temperature</div>
                      <div style={{ marginTop: '18px' }}>Design Temperature</div>
                    </div>
                  </td>
                  <td width="63">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="23">&nbsp;</td>
                  <td width="48">&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </tbody>
            </table>
            <table width="100%" border="1" className="table table-bordered align-middle form-table export-table compact-table mb-0" style={{ borderCollapse: 'collapse' }}>
              <tbody>
                <MeasurementHeader label="Down Line" />
                <MeasurementGroup withWidths />
                <MeasurementGroup />
                <MeasurementGroup />
                <MeasurementHeader label="Up Line" />
                <MeasurementGroup />
                <MeasurementGroup />
                <MeasurementGroup />
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <div className="text-end me-5 mt-2">
        *The rail elongation check position move to Origin side : (+) ; move to End side : (-)
      </div>
    </div>
  );
}
