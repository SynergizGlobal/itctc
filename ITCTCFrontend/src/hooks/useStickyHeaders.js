import { useEffect } from 'react';

export default function useStickyHeaders() {
  useEffect(() => {
    function setup() {
      document.querySelectorAll('.export-table').forEach((table) => {
        const headerRows = Array.from(table.querySelectorAll('tr')).slice(0, 3);
        let top = 0;
        headerRows.forEach((row) => {
          row.querySelectorAll('th, td').forEach((cell) => {
            cell.classList.add('sticky-header-cell');
            cell.style.setProperty('--sticky-top', `${top}px`);
          });
          top += row.getBoundingClientRect().height;
        });
      });
    }
    setup();
    window.addEventListener('resize', setup);
    return () => window.removeEventListener('resize', setup);
  }, []);
}
