export default function PdfDownloadButton({ formName }) {
  return (
    <button
      type="button"
      className="btn btn-sm ms-1 p-1"
      style={{ background: '#fff', border: '1px solid #ccc', color: '#000', lineHeight: 1 }}
      onClick={() => window.print()}
      title="Download as PDF"
      aria-label={`Download ${formName} as PDF`}
    >
      <i className="fa-solid fa-download" aria-hidden="true" style={{ color: '#000', fontSize: 12 }}></i>
    </button>
  );
}
