import { useState } from 'react';
import { Link } from 'react-router-dom';
import { CircleCheck, ClipboardList, FileDown, FileSpreadsheet, FileText, TriangleAlert } from 'lucide-react';
import './dashboard.css';
import './overview-icon.css';
import FormC1 from '../components/FormC1';
import FormC7 from '../components/FormC7';
import FormT2 from '../components/FormT2';
import FormT5 from '../components/FormT5';
import FormT72 from '../components/FormT-7-2';
import FormT8 from '../components/FormT8';
import FormT9 from '../components/FormT9';
import FormT10 from '../components/FormT10';
import FormT13 from '../components/FormT13';
import FormT21 from '../components/FormT21';
import FormT22 from '../components/FormT22';
import useDownloadExcel from '../hooks/useDownloadExcel';

const menuItems = [
  { icon: '/overview-icon.png', label: 'Overview', isImage: true },
  { icon: '▤', label: 'Sections' },
  { icon: '!', label: 'Defects' },
  { icon: '▥', label: 'Reports' },
  { icon: '◷', label: 'Inspection Logs' },
  { icon: '◫', label: 'Forms' },
];

const stats = [
  { label: 'Total Forms', value: '11', change: 'Actual', note: 'available form templates', tone: 'blue', icon: FileText },
  { label: 'Available', value: '11', change: '100%', note: 'ready to open', tone: 'green', icon: CircleCheck },
  { label: 'Pending Review', value: '0', change: '0%', note: 'no review data recorded', tone: 'orange', icon: ClipboardList },
  { label: 'Issues Found', value: '0', change: '0%', note: 'no issues recorded', tone: 'red', icon: TriangleAlert },
];

const formLinks = [
  ['/form-c1', 'C-1'], ['/form-c7', 'C-7'], ['/form-t2', 'T-2'], ['/form-t5', 'T-5'],
  ['/form-t7-2', 'T-7-2'], ['/form-t8', 'T-8'], ['/form-t9', 'T-9'], ['/form-t10', 'T-10'],
  ['/form-t13', 'T-13'], ['/form-t21', 'T-21'], ['/form-t22', 'T-22'],
];
const inspectionLogRows = [
  ['/form-c1','C-1','Formation Width','Civil inspection','C1-001','KM 1.50 + 250 M'],
  ['/form-c7','C-7','Civil Measurement','Civil inspection','C7-001','KM 1.75 + 100 M'],
  ['/form-t2','T-2','Track Irregularity','Finished state measurement','T2-001','KM 1 + 250–340 M'],
  ['/form-t5','T-5','Track Measurement','Track inspection','T5-001','KM 2 + 100 M'],
  ['/form-t7-2','T-7-2','Track Alignment','Track inspection','T72-001','KM 2 + 450 M'],
  ['/form-t8','T-8','Track Structure','Track inspection','T8-001','KM 3 + 000 M'],
  ['/form-t9','T-9','Track Geometry','Track inspection','T9-001','KM 3 + 250 M'],
  ['/form-t10','T-10','Track Installation','Track inspection','T10-001','KM 3 + 500 M'],
  ['/form-t13','T-13','Switch Measurement','Track inspection','T13-001','KM 4 + 000 M'],
  ['/form-t21','T-21','Track Component','Track inspection','T21-001','KM 4 + 250 M'],
  ['/form-t22','T-22','Buffer Stop','Track inspection','T22-001','KM 4 + 500 M'],
];
const dashboardForms = {
  '/form-c1': FormC1, '/form-c7': FormC7, '/form-t2': FormT2, '/form-t5': FormT5,
  '/form-t7-2': FormT72, '/form-t8': FormT8, '/form-t9': FormT9, '/form-t10': FormT10,
  '/form-t13': FormT13, '/form-t21': FormT21, '/form-t22': FormT22,
};

const reportProfiles = {
  'C-1': { total: 4, failed: 1, failures: [['Formation Width A',0],['Formation Width B',0],['Formation Width C',0],['Formation Width D',1]] },
  'C-7': { total: 36, failed: 3, failures: [['Civil Measurement',2],['Level Difference',1],['Clearance',0]] },
  'T-2': { total: 10, failed: 0, failures: [['Track Gauge',0],['Cant',0],['Cross Level',0],['Alignment',0],['Longitudinal Level',0]] },
  'T-5': { total: 48, failed: 5, failures: [['Track Gauge',2],['Cross Level',1],['Cant',2]] },
  'T-7-2': { total: 42, failed: 4, failures: [['Horizontal Alignment',2],['Vertical Alignment',1],['Centre Line',1]] },
  'T-8': { total: 64, failed: 6, failures: [['Rail',2],['Sleeper',1],['Fastening',2],['Ballast',1]] },
  'T-9': { total: 55, failed: 7, failures: [['Gauge',2],['Twist',2],['Cross Level',1],['Alignment',2]] },
  'T-10': { total: 40, failed: 3, failures: [['Installation Level',1],['Joint Gap',1],['Fastening',1]] },
  'T-13': { total: 32, failed: 4, failures: [['Switch Gauge',1],['Flangeway',2],['Throw',1]] },
  'T-21': { total: 72, failed: 5, failures: [['Rail Component',2],['Fastening Component',2],['Sleeper Component',1]] },
  'T-22': { total: 24, failed: 2, failures: [['Buffer Alignment',1],['Fixing',1],['Clearance',0]] },
};

function ListTools({ query, onQueryChange, filter, onFilterChange, placeholder }) {
  return <div className="dashboard-list-tools">
    <label className="dashboard-search">
      <svg viewBox="0 0 24 24" aria-hidden="true"><path d="m21 20-4.35-4.35a8 8 0 1 0-1.41 1.41L20 21l1-1ZM5 11a6 6 0 1 1 12 0 6 6 0 0 1-12 0Z" /></svg>
      <input type="search" value={query} onChange={(event) => onQueryChange(event.target.value)} placeholder={placeholder} aria-label={placeholder} />
    </label>
    <label className="dashboard-filter" title="Filter by form type">
      <svg viewBox="0 0 24 24" aria-hidden="true"><path d="M3 5h18l-7 8v5l-4 2v-7L3 5Z" /></svg>
      <select value={filter} onChange={(event) => onFilterChange(event.target.value)} aria-label="Filter by form type">
        <option value="all">All forms</option><option value="civil">Civil</option><option value="track">Track</option>
      </select>
    </label>
  </div>;
}

function T2Overview({ downloadExcel }) {
  const rows = [['T-2','Finished State of Track Irregularity',10,10,0,0,0,'100%']];
  return <section className="t2-package-dashboard t2-overview-package">
    <div className="package-breadcrumb"><strong>Form: T-2</strong><span>›</span><b>Finished State of Track Irregularity</b><div className="form-export-actions overview-export-actions"><button type="button" onClick={() => window.print()} title="Download Form T-2 overview as PDF"><FileDown aria-hidden="true" />PDF</button><button type="button" onClick={() => downloadExcel('Form-T-2-Overview.xls')} title="Download Form T-2 overview as Excel"><FileSpreadsheet aria-hidden="true" />Excel</button></div></div>
    <div className="package-stat-grid">{[['Measured Length','0.09','km','neutral'],['Chainages','10','','neutral'],['Parameters','5','','neutral'],['Total Records','10','','neutral'],['Passed','10','100%','passed'],['Needs Rectification','0','0%','rectification'],['Rectified','0','0%','rectified'],['Pending','0','0%','pending']].map(([label,value,sub,tone]) => <article className={`package-stat ${tone}`} key={label}><small>{label}</small><strong>{value}<em>{sub === 'km' ? ' km' : ''}</em></strong>{sub && sub !== 'km' && <span>{sub}</span>}</article>)}</div>
    <article className="package-table-panel"><h2>INSPECTION STATUS BY FORM</h2><div className="logs-table-wrap"><table className="package-table export-table"><thead><tr><th>Form Code</th><th>Form Name</th><th>Total Inspections</th><th>Passed</th><th>Needs Rectification</th><th>Rectified</th><th>Pending</th><th>Pass %</th></tr></thead><tbody>
      {rows.map(row => <tr key={row[0]}>{row.map((cell,i)=><td key={i} className={i===3||i===7?'green':i===4?'orange':i===5?'blue':i===6?'purple':''}>{cell}</td>)}</tr>)}
      <tr className="package-total"><td colSpan="2">Total</td><td>10</td><td className="green">10</td><td className="orange">0</td><td className="blue">0</td><td className="purple">0</td><td className="green">100%</td></tr>
    </tbody></table></div></article>
    <section className="t2-chart-grid">
      <article className="package-table-panel"><h2>INSPECTION STATUS OVERALL</h2><div className="overview-status-chart"><div className="overview-status-donut t2-only-donut"><div><strong>10</strong><small>Records</small></div></div><div className="overview-chart-legend"><span><i className="passed"/><b>Passed</b><strong>10 <small>100%</small></strong></span><span><i className="rectification"/><b>Needs Rectification</b><strong>0 <small>0%</small></strong></span><span><i className="rectified"/><b>Rectified</b><strong>0 <small>0%</small></strong></span><span><i className="pending"/><b>Pending</b><strong>0 <small>0%</small></strong></span></div></div></article>
      <article className="package-table-panel"><h2>PASS RATE BY FORM</h2><div className="form-rate-chart">{rows.map(row => <div key={row[0]}><b>{row[0]}</b><span><i style={{width:row[7]}}/></span><strong>{row[7]}</strong></div>)}</div></article>
    </section>
  </section>;
}

function C1Overview() {
  return <section className="overview-board">
    <article className="dashboard-panel section-overview">
      <div className="panel-title"><div><h2>C-1 FORMATION WIDTH OVERVIEW</h2><p>Measured values compared with C-1 standards</p></div><Link to="/form-c1">Open C-1</Link></div>
      <div className="c1-meta"><span><small>Chainage</small><strong>1.50 KM + 250.00 M</strong></span><span><small>Structure</small><strong>Earthwork A</strong></span><span><small>Track</small><strong>Down Line</strong></span><span><small>Applied Cant</small><strong>120 mm</strong></span></div>
      <div className="c1-comparison-chart">
        {[['A',850,850],['B',5205,5200],['C',850,850],['D',795,800]].map(([label, measured, standard]) => <div className="c1-bar-row" key={label}><b>{label}</b><div className="c1-bar-track"><span style={{width:`${Math.min((measured / standard) * 100, 102)}%`}} /></div><strong>{measured.toLocaleString()} mm</strong><small>Std. {standard.toLocaleString()}</small></div>)}
      </div>
      <div className="c1-chart-key"><span><i/>Measured value</span><span><i/>Standard = 100%</span></div>
    </article>
    <article className="dashboard-panel inspection-status">
      <div className="panel-title"><div><h2>C-1 MEASURED WIDTH SUMMARY</h2><p>A, B, C and D measured values</p></div></div>
      <div className="status-content"><div className="status-donut c1-width-donut"><div><strong>7,700</strong><small>Total mm</small></div></div>
        <div className="status-legend"><div><i className="passed"/><span>A measured<strong>850 mm (11.0%)</strong></span></div><div><i className="rectification"/><span>B measured<strong>5,205 mm (67.6%)</strong></span></div><div><i className="rectified"/><span>C measured<strong>850 mm (11.0%)</strong></span></div><div><i className="pending"/><span>D measured<strong>795 mm (10.3%)</strong></span></div></div>
      </div>
    </article>
  </section>;
}

export default function Dashboard() {
  const [active, setActive] = useState('Overview');
  const [open, setOpen] = useState(false);
  const [selectedForm, setSelectedForm] = useState(null);
  const [overviewForm, setOverviewForm] = useState(null);
  const [selectedLog, setSelectedLog] = useState(null);
  const [searchQuery, setSearchQuery] = useState('');
  const [formFilter, setFormFilter] = useState('all');
  const [reportForm, setReportForm] = useState('C-1');
  const downloadExcel = useDownloadExcel();
  const SelectedForm = selectedForm ? dashboardForms[selectedForm] : null;
  const matchesForm = (label, text = '') => {
    const matchesType = formFilter === 'all' || (formFilter === 'civil' ? label.startsWith('C') : label.startsWith('T'));
    return matchesType && `${label} ${text}`.toLowerCase().includes(searchQuery.trim().toLowerCase());
  };
  const filteredForms = formLinks.filter(([, label]) => matchesForm(label));
  const filteredLogs = inspectionLogRows.filter(([, code, name, type, reference, location]) => matchesForm(code, `${name} ${type} ${reference} ${location}`));
  const openForm = (path) => { setActive('Forms'); setSelectedForm(path); setOverviewForm(path); setOpen(false); };
  const reportData = reportProfiles[reportForm];
  const passedChecks = reportData.total - reportData.failed;
  const passedPercent = (passedChecks / reportData.total) * 100;
  const failedPercent = (reportData.failed / reportData.total) * 100;
  const maxFailure = Math.max(...reportData.failures.map(([, value]) => value), 1);
  const reportTones = ['red', 'orange', 'yellow', 'lightBlue', 'blue', 'teal', 'purple'];

  return <div className="dashboard-shell">
    <aside className={`dashboard-sidebar ${open ? 'is-open' : ''}`}>
      <div className="dashboard-brand"><div>ITCTC<small>Inspection Portal</small></div></div>
      <nav className="dashboard-menu">
        <p>WORKSPACE</p>
        {menuItems.map(item => <div key={item.label}>
          <button className={active === item.label ? 'active' : ''} onClick={() => { setActive(item.label); if (item.label === 'Forms') setSelectedForm(null); if (item.label === 'Inspection Logs') setSelectedLog(null); }}>
            <span className="menu-icon">{item.isImage ? <img src={item.icon} alt="" /> : item.icon}</span>{item.label}
          </button>
        </div>)}
      </nav>
      <div className="dashboard-user"><div className="user-avatar">A</div><div><strong>Admin</strong><small>Administrator</small></div><span>⋮</span></div>
    </aside>

    {open && <button className="sidebar-backdrop" aria-label="Close menu" onClick={() => setOpen(false)} />}
    <main className="dashboard-main">
      <header className="dashboard-topbar">
        <button className="menu-toggle" onClick={() => setOpen(true)}>☰</button>
        <div><h1>{active}</h1><p>Welcome back. Here is today’s inspection summary.</p></div>
        <div className="topbar-actions"><button aria-label="Notifications">♢<span /></button><div className="top-avatar">A</div></div>
      </header>

      <div className="dashboard-content">
        {active === 'Forms' && !SelectedForm && <section className="dashboard-form-library">
          <div className="form-library-heading"><div><h2>Available Forms</h2><p>Open any inspection form from the dashboard.</p></div><span>{filteredForms.length} forms</span></div>
          <ListTools query={searchQuery} onQueryChange={setSearchQuery} filter={formFilter} onFilterChange={setFormFilter} placeholder="Search forms" />
          <div className="form-card-grid">{filteredForms.map(([path, label]) => <button type="button" className="dashboard-form-card" key={path} onClick={() => openForm(path)}>
            <div className="form-card-icon">{label.charAt(0)}</div><div><strong>Form {label}</strong><small>{label.startsWith('C') ? 'Civil inspection form' : 'Track inspection form'}</small></div>
          </button>)}</div>
        </section>}
        {active === 'Forms' && SelectedForm && <section className="embedded-form-area">
          <div className="embedded-form-toolbar"><button type="button" aria-label="Back to all forms" title="Back to all forms" onClick={() => setSelectedForm(null)}>←</button><strong>{formLinks.find(([path]) => path === selectedForm)?.[1]}</strong></div>
          <div className="embedded-form-content"><SelectedForm /></div>
        </section>}
        {['Sections', 'Defects'].includes(active) && <section className="dashboard-empty-state"><div>{menuItems.find(item => item.label === active)?.icon}</div><h2>{active}</h2><p>No {active.toLowerCase()} have been added yet.</p></section>}
        {active === 'Reports' && <section className="reports-panel">
          <div className="report-toolbar"><div><h2>Form {reportForm}</h2><p>Tolerance performance for the selected inspection form.</p></div><div className="report-actions"><label>Form<select value={reportForm} onChange={(event) => setReportForm(event.target.value)}>{formLinks.map(([, label]) => <option key={label}>{label}</option>)}</select></label><button type="button" onClick={() => window.print()} title={`Download Form ${reportForm} as PDF`}><FileDown aria-hidden="true"/>PDF</button><button type="button" onClick={() => downloadExcel(`Form-${reportForm}-Tolerance-Report.xls`)} title={`Download Form ${reportForm} as Excel`}><FileSpreadsheet aria-hidden="true"/>Excel</button></div></div>
          <div className="tolerance-report-grid">
            <article className="tolerance-panel"><h3>INSPECTION OUTCOME SUMMARY</h3><div className="tolerance-summary"><div className="tolerance-donut" style={{background:`conic-gradient(#42ad56 0 ${passedPercent}%,#ef5748 ${passedPercent}% 100%)`}}><div><strong>{reportData.total.toLocaleString()}</strong><small>Total Checks</small></div></div><div className="tolerance-legend"><span><i className="passed"/><b>Passed</b><strong>{passedChecks.toLocaleString()} <small>({passedPercent.toFixed(2)}%)</small></strong></span><span><i className="failed"/><b>Failed</b><strong>{reportData.failed.toLocaleString()} <small>({failedPercent.toFixed(2)}%)</small></strong></span></div></div></article>
            <article className="tolerance-panel"><h3>PARAMETER COMPLIANCE</h3><div className="failure-chart compliance-chart">{reportData.failures.map(([label, value], index) => { const compliance = ((reportData.total - value) / reportData.total) * 100; return <div className="failure-row" key={label}><b>{label}</b><span><i className={reportTones[index % reportTones.length]} style={{width: `${compliance}%`}}/></span><strong>{compliance.toFixed(1)}%</strong></div>; })}</div><div className="failure-axis"><span>0%</span><span>20%</span><span>40%</span><span>60%</span><span>80%</span><span>100%</span></div><p>Compliance Rate</p></article>
          </div>
          <table className="export-table report-export-table"><caption>Form {reportForm} Tolerance Report</caption><thead><tr><th>Parameter</th><th>Failures</th><th>Failure Percentage</th></tr></thead><tbody><tr><td>Total Checks</td><td>{reportData.total}</td><td>100%</td></tr><tr><td>Passed</td><td>{passedChecks}</td><td>{passedPercent.toFixed(2)}%</td></tr><tr><td>Failed</td><td>{reportData.failed}</td><td>{failedPercent.toFixed(2)}%</td></tr>{reportData.failures.map(([label, value]) => <tr key={label}><td>{label}</td><td>{value}</td><td>{reportData.failed ? ((value / reportData.failed) * 100).toFixed(2) : '0.00'}%</td></tr>)}</tbody></table>
        </section>}
        {active === 'Inspection Logs' && !selectedLog && <section className="inspection-logs-panel">
          <div className="logs-heading"><div><h2>Inspection Logs</h2><p>Inspection activity organized form-wise</p></div><span>{filteredLogs.length} records</span></div>
          <ListTools query={searchQuery} onQueryChange={setSearchQuery} filter={formFilter} onFilterChange={setFormFilter} placeholder="Search inspection logs" />
          <div className="logs-table-wrap"><table className="logs-table"><thead><tr><th>Form</th><th>Inspection</th><th>Reference</th><th>Date</th><th>Location</th><th>Status</th><th></th></tr></thead><tbody>
            {filteredLogs.map(([path,code,name,type,reference,location]) => <tr className="clickable-log-row" key={path} onClick={() => path === '/form-t2' ? setSelectedLog('T-2') : openForm(path)}><td><b className={`log-form-badge ${code.startsWith('T') ? 'track' : ''}`}>{code}</b></td><td><strong>{name}</strong><small>{type}</small></td><td>{reference}</td><td>17 Jul 2026</td><td>{location}</td><td><span className="log-status complete">Completed</span></td><td><span className="row-arrow">→</span></td></tr>)}
          </tbody></table></div>
        </section>}
        {active === 'Inspection Logs' && selectedLog === 'T-2' && <section className="t2-package-dashboard">
          <div className="package-breadcrumb"><button onClick={() => setSelectedLog(null)}>←</button><strong>Package: MAHSR–T2</strong><span>›</span><b>Section 2 (25.00 - 50.00 km)</b><button className="map-button">⌖ View on Map</button></div>
          <div className="package-stat-grid">
            {[['Length','25.00','km','neutral'],['Chainages','132','','neutral'],['Structures','34','','neutral'],['Total Inspections','3,128','','neutral'],['Passed','2,372','75.86%','passed'],['Needs Rectification','556','17.77%','rectification'],['Rectified','186','5.95%','rectified'],['Pending','14','0.45%','pending']].map(([label,value,sub,tone]) => <article className={`package-stat ${tone}`} key={label}><small>{label}</small><strong>{value}<em>{sub === 'km' ? ' km' : ''}</em></strong>{sub && sub !== 'km' && <span>{sub}</span>}</article>)}
          </div>
          <article className="package-table-panel"><h2>INSPECTION STATUS BY FORM</h2><div className="logs-table-wrap"><table className="package-table"><thead><tr><th>Form Code</th><th>Form Name</th><th>Total Inspections</th><th>Passed</th><th>Needs Rectification</th><th>Rectified</th><th>Pending</th><th>Pass %</th></tr></thead><tbody>
            {[
              ['C-0','General Information',132,125,5,2,0,'94.70%'],['C-1','Track Centre Line',132,115,12,4,1,'87.12%'],['C-2','Gauge',132,108,16,7,1,'81.82%'],['C-3','Cross Level',132,112,15,4,1,'84.85%'],['C-4','Cant',132,109,17,5,1,'82.58%'],['T-2','Track Irregularity',132,118,9,4,1,'89.39%']
            ].map(row => <tr key={row[0]}>{row.map((cell,i)=><td key={i} className={i===3||i===7?'green':i===4?'orange':i===5?'blue':i===6?'purple':''}>{cell}</td>)}</tr>)}
            <tr className="package-total"><td colSpan="2">Total</td><td>3,128</td><td className="green">2,372</td><td className="orange">556</td><td className="blue">186</td><td className="purple">14</td><td className="green">75.86%</td></tr>
          </tbody></table></div></article>
        </section>}
        {active === 'Overview' && <>
        <section className="stat-grid dashboard-top-stats">{stats.map(stat => { const Icon = stat.icon; return <article className={`stat-card ${stat.tone}`} key={stat.label}>
          <div className={`stat-mark ${stat.tone}`} /><Icon className="stat-icon" aria-hidden="true" /><p>{stat.label}</p><div><strong>{stat.value}</strong><span>{stat.change}</span></div><small>{stat.note}</small>
        </article>; })}</section>
        {overviewForm === '/form-t2' && <T2Overview downloadExcel={downloadExcel} />}
        {overviewForm === '/form-c1' && <C1Overview />}
        {!['/form-t2', '/form-c1'].includes(overviewForm) && <section className="dashboard-empty-state"><div>◫</div><h2>Select a form</h2><p>Open C-1 or T-2 first to view its overview.</p></section>}
        </>}
      </div>
    </main>
  </div>;
}
