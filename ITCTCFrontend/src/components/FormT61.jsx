import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';
import t61aImage from '../assets/images/T-6-1-A.png';
import t61bImage from '../assets/images/T-6-1-B.png';

const TABLE_HTML = `
<table width="1009" border="1" class="table table-bordered align-middle form-table export-table compact-table mb-0">
  <tr>
    <th width="65" rowspan="2" scope="col"><div align="center">Origin side<br>
      Anchor<br>
    number</div></th>
    <th width="44" rowspan="2" scope="col"><div align="center">Up /<br>
    Down</div></th>
    <th colspan="3" scope="col"><div align="center">Chainage</div></th>
    <th width="37" rowspan="2" scope="col"><div align="center">left /<br>
    Right</div></th>
    <th width="52" rowspan="2" scope="col"><div align="center">Outside<br>
    / Inside</div></th>
    <th width="61" rowspan="2" scope="col"><div align="center">Type of<br>
      fastening<br>
      and bol<br>
    </div></th>
    <th width="60" rowspan="2" scope="col"><div align="center">Bolt oil<br>
    condition</div></th>
    <th width="60" rowspan="2" scope="col"><div align="center">Spring<br>
    condition<br>
    (Less than<br>
    0.2 mm）<br>
    </div></th>
    <th width="59" rowspan="2" scope="col"><div align="center">Type of<br>
    Fastener</div></th>
    <th colspan="8" scope="col"><div align="center">Measurement position and measured value (Nm)</div></th>
    <th width="70" rowspan="2" scope="col"><div align="center">Remarks<br>
    </div></th>
  </tr>
  <tr>
    <td height="27" colspan="3" align="center" style="background-color: #cfe2ff !important;"><div align="center">km &nbsp;&nbsp;&nbsp;&nbsp;m &nbsp; cm</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(1)</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(2)</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(3)</div></td>
    <td width="70" align="center" style="background-color: #cfe2ff !important;"><div align="center">(4)</div></td>
    <td width="14" align="center" style="background-color: #cfe2ff !important;"><div align="center">(5)</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(6)</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(7)</div></td>
    <td width="19" align="center" style="background-color: #cfe2ff !important;"><div align="center">(8)</div></td>
  </tr>
  <tr>
    <td rowspan="8">&nbsp;</td>
    <td rowspan="8">&nbsp;</td>
    <td width="28" rowspan="16">&nbsp;</td>
    <td width="23" rowspan="16">&nbsp;</td>
    <td width="26" rowspan="16">&nbsp;</td>
    <td rowspan="4" class="vertical-text">Left</td>
    <td rowspan="2"><div align="center">Outside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
    <td rowspan="8">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td rowspan="8"><img src="${t61aImage}" style="max-width: 120px; max-height: 140px; width: auto; height: auto;" /></td>
  </tr>
  <tr>
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="2"><div align="center">Inside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="4" class="vertical-text">Right</td>
    <td rowspan="2"><div align="center">Outside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="2"><div align="center">Inside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="8">&nbsp;</td>
    <td rowspan="8">&nbsp;</td>
    <td rowspan="4" class="vertical-text">Left</td>
    <td rowspan="2"><div align="center">Outside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
    <td rowspan="8">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td rowspan="8"><img src="${t61bImage}" style="max-width: 120px; max-height: 140px; width: auto; height: auto;" /></td>
  </tr>
  <tr>
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="2"><div align="center">Inside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="4" class="vertical-text">Right</td>
    <td rowspan="2"><div align="center">Outside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td>Fastening</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td rowspan="2"><div align="center">Inside</div></td>
    <td>Hexagonal</td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
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
    <td> Fastening<br></td>
    <td>&nbsp;</td>
    <td class="diagonal-split">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
`;

export default function FormT61() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-6-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3" style={{ fontSize: '16px' }}>Measurement record of Rail Fasteners for Slab Track (Directly-laid type 8, improved and low)</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-6-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>
      <style>{'.compact-table td { padding: 2px 1px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 0 1px !important; } th, thead tr:last-child td { background-color: #cfe2ff !important; } .diagonal-split { background-image: linear-gradient(to left top, transparent calc(50% - 0.5px), #000 calc(50% - 0.5px), #000 calc(50% + 0.5px), transparent calc(50% + 0.5px)); }'}</style>

      <div className="table-responsive" style={{ display: 'flex', justifyContent: 'center' }}>
        <table className="table table-bordered align-middle form-table export-table compact-table mb-0" border="1" style={{ width: 'auto', borderCollapse: 'collapse' }}>
          <thead>
            <tr>
              <th scope="col" className="text-center">Type of Bolt</th>
              <th scope="col" className="text-center">Hexagonal Bolt</th>
              <th scope="col" className="text-center">Fastening Bolt</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="text-center">Standard value</td>
              <td className="text-center" style={{ color: 'red' }}>350 Nm</td>
              <td className="text-center" style={{ color: 'red' }}>60 Nm</td>
            </tr>
            <tr>
              <td className="text-center">Tolerances</td>
              <td className="text-center" style={{ color: 'red' }}>350 - 400</td>
              <td className="text-center" style={{ color: 'red' }}>50 - 70</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className="table-responsive">
        <div className="form-table export-table" dangerouslySetInnerHTML={{ __html: TABLE_HTML }} />
      </div>
    </div>
  );
}
