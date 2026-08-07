import { useState, useEffect } from 'react';
import useStickyHeaders from '../hooks/useStickyHeaders';
import { useNavigate } from 'react-router-dom';
import { ArrowLeft } from 'lucide-react';
import useDownloadExcel from '../hooks/useDownloadExcel';
import { getAllCamMeasurements } from '../services/camMeasurementService';
import t71a from '../assets/images/T-7-1-A.png';
import t71b from '../assets/images/T-7-1-B.png';

function ImageDropZone({ height = '120px', label, defaultImage }) {
  const [image, setImage] = useState(defaultImage || null);
  const [dragOver, setDragOver] = useState(false);
  const handleDrop = (e) => { e.preventDefault(); setDragOver(false); const file = e.dataTransfer.files[0]; if (file && file.type.startsWith('image/')) { const reader = new FileReader(); reader.onload = (ev) => setImage(ev.target.result); reader.readAsDataURL(file); } };
  const handleDragOver = (e) => { e.preventDefault(); setDragOver(true); };
  const handleDragLeave = () => setDragOver(false);
  const handleClick = () => { const input = document.createElement('input'); input.type = 'file'; input.accept = 'image/*'; input.onchange = (e) => { const file = e.target.files[0]; if (file) { const reader = new FileReader(); reader.onload = (ev) => setImage(ev.target.result); reader.readAsDataURL(file); } }; input.click(); };
  return (
    <div>
      {label && <div style={{ fontSize: '9px', fontWeight: 700, color: '#212121', marginBottom: '2px', textAlign: 'center' }}>{label}</div>}
      <div onClick={handleClick} onDrop={handleDrop} onDragOver={handleDragOver} onDragLeave={handleDragLeave} style={{ width: '100%', height, border: `2px dashed ${dragOver ? '#0d6efd' : '#ccc'}`, borderRadius: '4px', display: 'flex', alignItems: 'center', justifyContent: 'center', cursor: 'pointer', background: dragOver ? '#eaf4ff' : image ? `url(${image}) center/cover no-repeat` : 'transparent', color: '#999', fontSize: '10px', transition: 'all 0.2s' }}>
        {!image && 'Drop image'}
      </div>
    </div>
  );
}

export default function FormT71() {
  const navigate = useNavigate();
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  const [camMeasurements, setCamMeasurements] = useState([]);

  useEffect(() => {
    loadCamMeasurements();
  }, []);

  const loadCamMeasurements = async () => {
    try {
      const response = await getAllCamMeasurements();

      setCamMeasurements(response);

    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container-fluid py-3">
      <style>{`.tolerance-table th:last-child, .tolerance-table td:last-child { border: none !important; background: none !important; } .compact-table td { padding: 6px 4px !important; font-size: 10px; line-height: 1.3; } .compact-table { font-size: 10px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 6px 4px !important; } .compact-table th { background: none !important; background-color: transparent !important; }`}</style>
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <button type="button" onClick={() => navigate(-1)} title="Back" style={{ border: 'none', background: 'transparent', padding: 0, cursor: 'pointer' }}><ArrowLeft aria-hidden="true" /></button>
        <h1 className="h6 mb-0">Form T-7-1</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of CAM injected thickness (Flat Plate)</span>
        <span>No. <input type="text"
          value={camMeasurements[0]?.formNo || ""}
          readOnly className="d-inline-block" style={{ width: '60px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} /></span>
        <span className="ms-2">Date: <input type="text"
          value={camMeasurements[0]?.inspectionDate || ""}
          readOnly className="d-inline-block" style={{ width: '100px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} placeholder="/ /" /></span>
        <div className="form-export-actions">
          <button type="button" onClick={() => window.print()} title="Download as PDF"><i className="fa-solid fa-file-pdf" /></button>
          <button type="button" onClick={() => downloadExcel('Form-T-7-1.xls')} title="Download as Excel"><i className="fa-solid fa-file-excel" /></button>
        </div>
      </div>

      <div style={{ overflow: 'visible', marginBottom: '1rem' }}>
        <table className="table table-bordered table-striped table-sm align-middle form-table tolerance-table export-table compact-table mb-0" border="1">
          <thead>
            <tr>
              <th width="50">Tolerances</th>
              <th width="90">Thickness Around RC anchor：<span style={{ color: 'red' }}>20 - 60 mm</span> (Resin), <span style={{ color: 'red' }}>30 - 100 mm</span> (CAM)</th>
              <th width="60" style={{ textAlign: 'left' }}>Thickness of CAM : <span style={{ color: 'red' }}>40 - 100 mm</span></th>
              <th width="50" style={{ textAlign: 'center' }}>Gap: Within <span style={{ color: 'red' }}>1 mm</span></th>
              <th width="50"></th>
            </tr>
          </thead>
        </table>
      </div>

      <div style={{ overflow: 'visible' }}>
        <table className="table table-striped table-bordered table-sm align-middle form-table measurement-table export-table compact-table mb-0" border="1">
          <thead>
            <tr>
              <th width="57" rowSpan={3}>Up /<br />Down</th>
              <th width="62" rowSpan={3}>Serial<br />Number<br />of<br />RC anchor</th>
              <td height="75" colSpan={3} rowSpan={2}>Chainage</td>
              <td colSpan={2} rowSpan={2}>Track Slab</td>
              <td colSpan={2} style={{ borderBottom: '2px solid #000' }}>Resin injection thickness</td>
              <td colSpan={9} rowSpan={2} style={{ whiteSpace: 'nowrap', borderBottom: '2px solid #000' }}>CAM injection thickness</td>
              <td colSpan={2} rowSpan={2} style={{ borderBottom: '2px solid #000' }}>Gap</td>
              <td colSpan={2} rowSpan={2}>Reference pin condition</td>
              <td rowSpan={3}>Remarks</td>
            </tr>
            <tr>
              <td height="76" colSpan={2}>If it exceeds <span style={{ color: 'red' }}>60 mm</span>,<br />it is indicated in ( ).</td>
            </tr>
            <tr>
              <td>km</td>
              <td></td>
              <td style={{ textAlign: 'right' }}>m</td>
              <td width="75">Number Type</td>
              <td width="33">Type</td>
              <td width="47">Origin</td>
              <td width="36">End</td>
              <td width="46">1</td>
              <td width="65">2</td>
              <td width="65">3</td>
              <td width="47">4</td>
              <td width="65">5</td>
              <td width="65">6</td>
              <td width="63">7</td>
              <td width="54">8</td>
              <td width="222">Average</td>
              <td width="47">Origin</td>
              <td width="47">End</td>
              <td width="54">Origin</td>
              <td width="54">End</td>
            </tr>
          </thead>
          <tbody>

            {camMeasurements.length === 0 ? (
              Array.from({ length: 10 }, (_, r) => (
                <tr key={`empty-${r}`}>
                  {Array.from({ length: 22 }, (_, c) => (
                    <td key={c}>&nbsp;</td>
                  ))}
                  {r === 0 && (
                    <td
                      rowSpan={10}
                      style={{
                        padding: "2px",
                        verticalAlign: "top",
                        fontSize: "10px"
                      }}
                    >
                      <ImageDropZone height="120px" label="T-7-1-A" defaultImage={t71a} />

                      <div style={{ height: "6px" }} />

                      <ImageDropZone height="90px" label="T-7-1-B" defaultImage={t71b} />

                    </td>
                  )}
                </tr>
              ))
            ) : (
              camMeasurements.flatMap((header) =>

              header.details.map((detail, index) => (

                <tr key={detail.camMeasurementDetailId}>

                  <td>{detail.trackDirectionName}</td>

                  <td>{detail.rcAnchorSerialNo}</td>

                  <td>{detail.chainageKm}</td>

                  <td>+</td>

                  <td>{detail.chainageM}</td>

                  <td>{detail.trackSlabNumber}</td>

                  <td>{detail.trackSlabType}</td>

                  <td>{detail.resinOriginThickness}</td>

                  <td>{detail.resinEndThickness}</td>

                  <td>{detail.camThickness1}</td>

                  <td>{detail.camThickness2}</td>

                  <td>{detail.camThickness3}</td>

                  <td>{detail.camThickness4}</td>

                  <td>{detail.camThickness5}</td>

                  <td>{detail.camThickness6}</td>

                  <td>{detail.camThickness7}</td>

                  <td>{detail.camThickness8}</td>

                  <td>{detail.camAverageThickness}</td>

                  <td>{detail.gapOrigin}</td>

                  <td>{detail.gapEnd}</td>

                  <td>{detail.referencePinOrigin}</td>

                  <td>{detail.referencePinEnd}</td>

                  <td>{detail.remarks}</td>

                  {index === 0 && (

                    <td
                      rowSpan={header.details.length}
                      style={{
                        padding: "2px",
                        verticalAlign: "top",
                        fontSize: "10px"
                      }}
                    >
                      <ImageDropZone height="120px" label="T-7-1-A" defaultImage={t71a} />

                      <div style={{ height: "6px" }} />

                      <ImageDropZone height="90px" label="T-7-1-B" defaultImage={t71b} />

                    </td>

                  )}

                </tr>

              ))
            )
            )}

          </tbody>
        </table>
      </div>
    </div>
  );
}
