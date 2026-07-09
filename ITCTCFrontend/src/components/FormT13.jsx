import { useState } from 'react';
import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

function ImageDropZone() {
  const [image, setImage] = useState(null);
  const [dragOver, setDragOver] = useState(false);

  const handleDrop = (e) => {
    e.preventDefault();
    setDragOver(false);
    const file = e.dataTransfer.files[0];
    if (file && file.type.startsWith('image/')) {
      const reader = new FileReader();
      reader.onload = (ev) => setImage(ev.target.result);
      reader.readAsDataURL(file);
    }
  };

  const handleDragOver = (e) => {
    e.preventDefault();
    setDragOver(true);
  };

  const handleDragLeave = () => setDragOver(false);

  const handleClick = () => {
    const input = document.createElement('input');
    input.type = 'file';
    input.accept = 'image/*';
    input.onchange = (e) => {
      const file = e.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = (ev) => setImage(ev.target.result);
        reader.readAsDataURL(file);
      }
    };
    input.click();
  };

  return (
    <div
      onClick={handleClick}
      onDrop={handleDrop}
      onDragOver={handleDragOver}
      onDragLeave={handleDragLeave}
      style={{
        width: '500px',
        height: '120px',
        border: `2px dashed ${dragOver ? '#0d6efd' : '#ccc'}`,
        borderRadius: '8px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        cursor: 'pointer',
        background: dragOver ? '#eaf4ff' : image ? `url(${image}) center/cover no-repeat` : 'transparent',
        color: '#999',
        fontSize: '13px',
        transition: 'all 0.2s',
      }}
    >
      {!image && 'Drag & drop image here'}
    </div>
  );
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
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-13</h1>
        <span className="title-main text-center flex-grow-1 mx-3">Measurement record of Fouling Mark</span>
        <button type="button" className="btn btn-sm ms-1 p-1" style={{ background: 'none', border: '1px solid #ccc', lineHeight: 1 }} onClick={() => downloadExcel('Form_T-13.xls')}>
          <i className="fa fa-download" aria-hidden="true" style={{ fontSize: 12 }}></i>
        </button>
      </div>
      <style>{'.compact-table td { padding: 6px 4px !important; font-size: 12px; line-height: 1.4; } .compact-table { font-size: 12px; } .compact-table thead tr:first-child th, .compact-table thead tr:first-child td { padding: 4px 4px !important; } .compact-table th { background: none !important; background-color: transparent !important; }'}</style>

      <div className="mb-2">
        <span className="me-1">Line:</span>
        <input type="text" className="d-inline-block" style={{ width: '120px', border: 'none', borderBottom: '1px solid #000', textAlign: 'center', background: 'transparent', outline: 'none' }} />
      </div>
      <div className="mb-3 d-flex justify-content-end gap-3">
        <ImageDropZone />
        <ImageDropZone />
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
