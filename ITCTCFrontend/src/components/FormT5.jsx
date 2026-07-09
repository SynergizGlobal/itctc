import { useState } from 'react';
import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

function ImageDropZone({ height = '80px' }) {
  const [image, setImage] = useState(null);
  const [dragOver, setDragOver] = useState(false);
  const handleDrop = (e) => { e.preventDefault(); setDragOver(false); const file = e.dataTransfer.files[0]; if (file && file.type.startsWith('image/')) { const reader = new FileReader(); reader.onload = (ev) => setImage(ev.target.result); reader.readAsDataURL(file); } };
  const handleDragOver = (e) => { e.preventDefault(); setDragOver(true); };
  const handleDragLeave = () => setDragOver(false);
  const handleClick = () => { const input = document.createElement('input'); input.type = 'file'; input.accept = 'image/*'; input.onchange = (e) => { const file = e.target.files[0]; if (file) { const reader = new FileReader(); reader.onload = (ev) => setImage(ev.target.result); reader.readAsDataURL(file); } }; input.click(); };
  return (
    <div onClick={handleClick} onDrop={handleDrop} onDragOver={handleDragOver} onDragLeave={handleDragLeave} style={{ width: '100%', height, border: `2px dashed ${dragOver ? '#0d6efd' : '#ccc'}`, borderRadius: '4px', display: 'flex', alignItems: 'center', justifyContent: 'center', cursor: 'pointer', background: dragOver ? '#eaf4ff' : image ? `url(${image}) center/cover no-repeat` : 'transparent', color: '#999', fontSize: '12px', transition: 'all 0.2s' }}>
      {!image && 'Drop image'}
    </div>
  );
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
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3 form-t5">
      <style>{`.form-t5 table.form-table thead tr th.empty-th, .form-t5 table.form-table tbody td:not(.keep-blue) { background: none !important; } .form-t5 .keep-blue { background-color: #cfe2ff !important; }`}</style>
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-5</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Rail head shape (Per <span style={{ color: 'red' }}>1.0</span> m span)</span>
        <span>No. <input type="text" className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text" className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <button type="button" className="btn btn-sm ms-1 p-1" style={{ background: 'none', border: '1px solid #ccc', lineHeight: 1 }} onClick={() => downloadExcel('Form_T-5.xls')}>
          <i className="fa fa-download" aria-hidden="true" style={{ fontSize: 12 }}></i>
        </button>
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
                  <ImageDropZone height="70px" />
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

 


