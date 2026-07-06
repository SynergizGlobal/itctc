import useStickyHeaders from '../hooks/useStickyHeaders';
import useDownloadExcel from '../hooks/useDownloadExcel';

export default function FormT10() {
  useStickyHeaders();
  const downloadExcel = useDownloadExcel();

  return (
    <div className="container-fluid py-3">
      <div className="panel-heading d-flex align-items-center justify-content-between mb-3">
        <h1 className="h6 mb-0">Form T-10</h1>
        <button type="button" className="btn btn-primary btn-sm" onClick={() => downloadExcel('Form_T-10.xls')}>
          <i className="fa-solid fa-download"></i>
        </button>
      </div>
      <div className="table-responsive">
        <p className="text-center text-muted py-5">Form T-10 content goes here</p>
      </div>
    </div>
  );
}
