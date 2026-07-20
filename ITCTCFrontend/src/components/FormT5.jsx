import useStickyHeaders from '../hooks/useStickyHeaders';
import formT5Diagram from '../assets/images/Form_T-5.png';

function StaticDiagram({ height = '80px', width = '100%', image }) {
  return <div style={{ width, height, border: '1px solid #ccc', borderRadius: '4px', background: `#fff url(${image}) center/contain no-repeat` }} />;
}

const verticalTextStyle = {
  width: '130px',
  height: '50px',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  justifyContent: 'center',
  transform: 'rotate(270deg)',
  msTransform: 'rotate(270deg)',
  MozTransform: 'rotate(270deg)',
  WebkitTransform: 'rotate(270deg)',
  OTransform: 'rotate(270deg)',
  textAlign: 'center',
  gap: '2px',
  fontSize: '11px'
};

export default function FormT5() {
  useStickyHeaders();

  return (
    <div className="container-fluid py-3 form-t5">
      <style>{`.form-t5 table.form-table thead tr th.empty-th, .form-t5 table.form-table tbody td:not(.keep-blue) { background: none !important; } .form-t5 .keep-blue { background-color: #cfe2ff !important; }`}</style>
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-5</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Rail head shape (Per <span style={{ color: 'red' }}>1.0</span> m span)</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
      </div>

      <div className="d-flex gap-3 align-items-start">
        <div className="flex-grow-1" style={{ overflowX: 'auto', overflowY: 'hidden' }}>
          <table className="table table-bordered table-sm align-middle form-table export-table mb-0" border="1">
            <thead>
              <tr>
                <th colSpan="3" scope="col" className="empty-th"></th>
                <th colSpan="5" scope="col">Finished tolerance for Rail welds</th>
                <th width="582" colSpan="9" scope="col">Lateral alignment : <span style={{ color: 'red' }}>&plusmn; 0.3 mm</span>, Longitudinal alignment : <span style={{ color: 'red' }}>0 mm - +0.3 mm</span></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td colSpan="3" style={{ padding: '4px', verticalAlign: 'top' }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', fontSize: '12px', fontWeight: 600, marginBottom: '4px' }}>
                    <span>Origin side</span>
                    <span>End side</span>
                  </div>
                  <StaticDiagram width="180px" height="150px" image={formT5Diagram} />
                </td>
                <td width="122">
                  <p><span className="d-block text-start">(1)</span>
                    <span style={verticalTextStyle}><span>&nbsp; &nbsp;Longitudinal</span><span>alignment</span></span></p>
                  <p>
                    <span className="d-block text-start">(2)</span>
                    <span style={verticalTextStyle}><span>Lateral</span><span>alignment</span></span></p>
                </td>
                <td colSpan="13">
                  <textarea name="textraea_A" className="form-control" rows="5" style={{ width: '100%' }}></textarea>
                </td>
              </tr>
              <tr>
                <td colspan="3" className="keep-blue"><div align="center">Chainage</div></td>
                <td rowSpan="5">
                  <p><span className="d-block text-start">(2)</span>
                    <span style={verticalTextStyle}><span>&nbsp; &nbsp;Longitudinal</span><span>alignment</span></span></p>
                  <p>
                    <span className="d-block text-start">(2)</span>
                    <span style={verticalTextStyle}><span>Lateral</span><span>alignment</span></span></p>
                </td>
                <td colSpan="13" rowSpan="5">
                  <textarea name="textraea_b" className="form-control" rows="5" style={{ width: '100%' }}></textarea>
                </td>
              </tr>
              <tr>
                <td width="22" className="text-center">(1)<br /> </td>
                <td width="70">km</td>
                <td width="54">m</td>
              </tr>
              <tr>
                <td className="text-center">(2)<br /> </td>
                <td>km</td>
                <td>m</td>
              </tr>
              <tr>
                <td className="text-center">(3)<br /> </td>
                <td>km</td>
                <td>m</td>
              </tr>
              <tr>
                <td colSpan="3" className="keep-blue"><div align="center">Type of welding</div></td>
              </tr>
              <tr>
                <td>(1)</td>
                <td colspan="2" className="text-center"><div align="center">GP・FB・EA</div></td>
                <td rowSpan="4">
                  <p><span className="d-block text-start">(3)</span>
                    <span style={verticalTextStyle}><span>&nbsp; &nbsp;Longitudinal</span><span>alignment</span></span></p>
                  <p>
                    <span className="d-block text-start">(3)</span>
                    <span style={verticalTextStyle}><span>Lateral</span><span>alignment</span></span></p>
                </td>
                <td colSpan="13" rowSpan="4">
                  <textarea name="textraea_c" className="form-control" rows="5" style={{ width: '100%' }}></textarea>
                </td>
              </tr>
              <tr>
                <td>(2)</td>
                <td colspan="2" className="text-center"><div align="center">GP・FB・EA</div></td>
              </tr>
              <tr>
                <td>(3)</td>
                <td colspan="2" className="text-center"><div align="center">GP・FB・EA</div></td>
              </tr>
              <tr>
                <td colSpan="3" className="keep-blue"><p align="center" style={{ borderBottom: '1px solid #000', paddingBottom: '2px', marginBottom: '4px' }}>Track Alignment</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div className="d-flex flex-column" style={{ minWidth: '80px' }}>
          <div style={{ height: '90px' }}></div>
          <div className="text-center"><span style={{ fontSize: '11px' }}>End side:</span><br /><i className="fa-solid fa-arrow-right" style={{ fontSize: '0.8rem' }}></i></div>
          <div className="text-center" style={{ marginTop: '110px' }}><span style={{ fontSize: '11px' }}>End side:</span><br /><i className="fa-solid fa-arrow-right" style={{ fontSize: '0.8rem' }}></i></div>
          <div className="text-center" style={{ marginTop: '130px' }}><span style={{ fontSize: '11px' }}>End side:</span><br /><i className="fa-solid fa-arrow-right" style={{ fontSize: '0.8rem' }}></i></div>
        </div>
      </div>
    </div>
  );
}

 


