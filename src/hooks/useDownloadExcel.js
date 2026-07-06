export default function useDownloadExcel() {
  const downloadExcel = (filename) => {
    const tables = Array.from(document.querySelectorAll('.export-table'));
    const content = tables.map((table) => table.outerHTML).join('<br><br>');
    const html = `<!doctype html><html><head><meta charset="utf-8"></head><body>${content}</body></html>`;
    const blob = new Blob([html], { type: 'application/vnd.ms-excel' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = filename;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
    URL.revokeObjectURL(link.href);
  };
  return downloadExcel;
}
