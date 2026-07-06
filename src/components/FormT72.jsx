import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

export default function FormT72() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-7-2</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_T-7-2.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>
      <div className="d-flex align-items-center gap-3 mb-3 flex-wrap">
        <span className="title-main">T-7-2 Form</span>
        <span className="ms-auto">Date: <input type="text" className="form-control form-control-sm d-inline-block" style={{ width: '100px' }} placeholder="/ /" /></span>
      </div>
      <div className="table-responsive">
        <p className="text-center text-muted py-5">Form T-7-2 content goes here</p>
      </div>
    </div>
  );
}
