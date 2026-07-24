import { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import './dashboard.css';

const sidebarNav = [
  { id: 'overview', label: 'Overview', icon: 'fa-solid fa-gauge-high' },
  { id: 'sections', label: 'Sections', icon: 'fa-solid fa-table-cells-large' },
  { id: 'workflow', label: 'Workflow', icon: 'fa-solid fa-diagram-project' },
  { id: 'defects', label: 'Defects', icon: 'fa-solid fa-triangle-exclamation' },
  { id: 'reports', label: 'Reports', icon: 'fa-solid fa-chart-column' },
  { id: 'forms', label: 'Forms', icon: 'fa-solid fa-table-list' },
  { id: 'logs', label: 'Inspection Logs', icon: 'fa-solid fa-clock-rotate-left' },
];

const formLinks = [
  { path: '/form-c1', code: 'C-1', name: 'Formation Width', type: 'civil' },
  { path: '/form-c7', code: 'C-7', name: 'Civil Measurement', type: 'civil' },
  { path: '/form-t2', code: 'T-2', name: 'Track Irregularity', type: 'track' },
  { path: '/form-t5', code: 'T-5', name: 'Track Geometry', type: 'track' },
  { path: '/form-t7-2', code: 'T-7-2', name: 'Track Alignment', type: 'track' },
  { path: '/form-t8', code: 'T-8', name: 'Track Structure', type: 'track' },
  { path: '/form-t9', code: 'T-9', name: 'Track Geometry Rev', type: 'track' },
  { path: '/form-t10', code: 'T-10', name: 'Track Installation', type: 'track' },
  { path: '/form-t13', code: 'T-13', name: 'Switch Measurement', type: 'track' },
  { path: '/form-t21', code: 'T-21', name: 'Track Component', type: 'track' },
  { path: '/form-t22', code: 'T-22', name: 'Buffer Stop', type: 'track' },
];

const workflowStages = [
  { id: 'inspector', label: 'Inspector', subtitle: 'Create & Submit', desc: 'Creates a new inspection record. Completes all required inspection details, observations, measurements, photographs, and attachments. Submits the inspection to the PMC for review.', iconClass: 'fa-solid fa-clipboard-list', color: '#DB2828', count: 12, pending: 3 },
  { id: 'pmc-review', label: 'PMC Review', subtitle: 'Review & Forward', desc: 'Reviews the inspection details submitted by the Inspector. Approve and forward to ITC Preconfirmation Engineer, or return to Inspector with comments.', iconClass: 'fa-solid fa-magnifying-glass', color: '#f2711c', count: 8, pending: 2 },
  { id: 'inspector-rework', label: 'Inspector Rework', subtitle: 'Update & Resubmit', desc: 'Reviews the PMC comments. Updates the inspection record as required. Resubmits the inspection to the PMC for review.', iconClass: 'fa-solid fa-rotate', color: '#4d9dd9', count: 5, pending: 1 },
  { id: 'itc-engineer', label: 'ITC Preconfirmation Engineer', subtitle: 'Final Review', desc: 'Reviews the inspection after PMC approval. Approve (final approved), return to PMC with comments, or return directly to Inspector for correction.', iconClass: 'fa-solid fa-shield-halved', color: '#79d58f', count: 6, pending: 2 },
  { id: 'pmc-response', label: 'PMC Response to ITC Comments', subtitle: 'Address ITC Comments', desc: 'If the inspection is returned by the ITC Preconfirmation Engineer to the PMC: The PMC reviews the comments and has two options — Address the comments and resubmit to the ITC Preconfirmation Engineer, or Return the inspection to the Inspector if changes require modification of the inspection data or form.', iconClass: 'fa-solid fa-paper-plane', color: '#212121', count: 3, pending: 1 },
  { id: 'final-approved', label: 'Final Approval', subtitle: 'Completed', desc: 'When the ITC Preconfirmation Engineer approves the inspection, the workflow is complete. The inspection status changes to Approved, and no further review is required unless reopened through a separate administrative process.', iconClass: 'fa-solid fa-circle-check', color: '#79d58f', count: 1, pending: 0 },
  { id: 'total', label: 'Total', subtitle: 'All Inspections', desc: 'Combined total of all inspections across every workflow stage.', iconClass: 'fa-solid fa-layer-group', color: '#212121', count: 81, pending: 9 },
];

const recentInspections = [
  { id: 'INS-2026-0471', form: 'C-1', title: 'Formation Width Inspection', chainage: 'KM 1.50 + 250 M', inspector: 'Rajesh Kumar', stage: 'pmc-review', date: '24 Jul 2026', priority: 'normal' },
  { id: 'INS-2026-0470', form: 'T-5', title: 'Track Geometry Measurement', chainage: 'KM 2.10 + 000 M', inspector: 'Amit Sharma', stage: 'inspector-rework', date: '24 Jul 2026', priority: 'urgent' },
  { id: 'INS-2026-0469', form: 'T-2', title: 'Track Irregularity Assessment', chainage: 'KM 1.25 + 340 M', inspector: 'Suresh Patel', stage: 'itc-engineer', date: '23 Jul 2026', priority: 'normal' },
  { id: 'INS-2026-0468', form: 'T-8', title: 'Track Structure Inspection', chainage: 'KM 3.00 + 000 M', inspector: 'Vikram Singh', stage: 'final-approved', date: '23 Jul 2026', priority: 'normal' },
  { id: 'INS-2026-0467', form: 'C-7', title: 'Civil Measurement Report', chainage: 'KM 1.75 + 100 M', inspector: 'Manoj Verma', stage: 'pmc-response', date: '23 Jul 2026', priority: 'urgent' },
  { id: 'INS-2026-0466', form: 'T-13', title: 'Switch Measurement Audit', chainage: 'KM 4.00 + 000 M', inspector: 'Deepak Gupta', stage: 'final-approved', date: '22 Jul 2026', priority: 'normal' },
  { id: 'INS-2026-0465', form: 'T-9', title: 'Track Geometry Review', chainage: 'KM 3.25 + 000 M', inspector: 'Rajesh Kumar', stage: 'inspector', date: '22 Jul 2026', priority: 'normal' },
  { id: 'INS-2026-0464', form: 'T-22', title: 'Buffer Stop Verification', chainage: 'KM 4.50 + 000 M', inspector: 'Amit Sharma', stage: 'final-approved', date: '22 Jul 2026', priority: 'normal' },
];

const stageLabels = {
  'inspector': { label: 'Submitted', tone: 'blue' },
  'pmc-review': { label: 'PMC Review', tone: 'purple' },
  'inspector-rework': { label: 'Rework', tone: 'amber' },
  'itc-engineer': { label: 'ITC Review', tone: 'teal' },
  'pmc-response': { label: 'PMC Response', tone: 'cyan' },
  'final-approved': { label: 'Approved', tone: 'green' },
};

const weeklyTrend = [
  { day: 'Mon', submitted: 4, approved: 3, rework: 1, pending: 2, review: 1, confirmed: 3 },
  { day: 'Tue', submitted: 6, approved: 5, rework: 0, pending: 3, review: 2, confirmed: 4 },
  { day: 'Wed', submitted: 3, approved: 2, rework: 2, pending: 1, review: 1, confirmed: 2 },
  { day: 'Thu', submitted: 5, approved: 4, rework: 1, pending: 2, review: 1, confirmed: 3 },
  { day: 'Fri', submitted: 7, approved: 5, rework: 1, pending: 4, review: 2, confirmed: 5 },
  { day: 'Sat', submitted: 2, approved: 2, rework: 0, pending: 1, review: 0, confirmed: 2 },
  { day: 'Sun', submitted: 0, approved: 0, rework: 0, pending: 0, review: 0, confirmed: 0 },
];

const formStats = [
  { code: 'C-1', name: 'Formation Width', total: 18, passed: 15, pending: 3, path: '/form-c1' },
  { code: 'C-7', name: 'Civil Measurement', total: 12, passed: 10, pending: 2, path: '/form-c7' },
  { code: 'T-2', name: 'Track Irregularity', total: 22, passed: 18, pending: 4, path: '/form-t2' },
  { code: 'T-5', name: 'Track Geometry', total: 15, passed: 13, pending: 2, path: '/form-t5' },
  { code: 'T-7-2', name: 'Track Alignment', total: 10, passed: 8, pending: 2, path: '/form-t7-2' },
  { code: 'T-8', name: 'Track Structure', total: 14, passed: 11, pending: 3, path: '/form-t8' },
  { code: 'T-9', name: 'Track Geometry Rev', total: 8, passed: 7, pending: 1, path: '/form-t9' },
  { code: 'T-10', name: 'Track Installation', total: 6, passed: 5, pending: 1, path: '/form-t10' },
  { code: 'T-13', name: 'Switch Measurement', total: 9, passed: 7, pending: 2, path: '/form-t13' },
  { code: 'T-21', name: 'Track Component', total: 11, passed: 9, pending: 2, path: '/form-t21' },
  { code: 'T-22', name: 'Buffer Stop', total: 5, passed: 4, pending: 1, path: '/form-t22' },
];

const defectsData = [
  { id: 'DEF-001', form: 'T-2', description: 'Gauge width exceeding tolerance at KM 3.00', chainage: 'KM 3.00 + 000 M', severity: 'critical', inspector: 'Vikram Singh', date: '23 Jul 2026' },
  { id: 'DEF-002', form: 'C-1', description: 'Formation width deviation noted at Viaduct Section', chainage: 'KM 1.50 + 250 M', severity: 'major', inspector: 'Rajesh Kumar', date: '24 Jul 2026' },
  { id: 'DEF-003', form: 'T-8', description: 'Track structure crack detected near bridge pier', chainage: 'KM 3.50 + 100 M', severity: 'critical', inspector: 'Vikram Singh', date: '23 Jul 2026' },
  { id: 'DEF-004', form: 'T-5', description: 'Alignment deviation beyond acceptable limit', chainage: 'KM 5.00 + 000 M', severity: 'minor', inspector: 'Amit Sharma', date: '24 Jul 2026' },
  { id: 'DEF-005', form: 'C-7', description: 'Noise barrier height below design specification', chainage: 'KM 2.00 + 500 M', severity: 'major', inspector: 'Deepak Gupta', date: '22 Jul 2026' },
];

const activityFeed = [
  { time: '10:24 AM', action: 'Inspection INS-2026-0471 forwarded to PMC', user: 'Rajesh Kumar', iconClass: 'fa-solid fa-share', color: '#212121' },
  { time: '09:48 AM', action: 'INS-2026-0470 returned to Inspector with comments', user: 'PMC Review', iconClass: 'fa-solid fa-rotate-left', color: '#f2711c' },
  { time: '09:15 AM', action: 'INS-2026-0469 escalated to ITC Engineer', user: 'PMC Team', iconClass: 'fa-solid fa-arrow-up-right-dots', color: '#4d9dd9' },
  { time: '08:52 AM', action: 'INS-2026-0468 approved — Final clearance granted', user: 'ITC Engineer', iconClass: 'fa-solid fa-circle-check', color: '#4d9dd9' },
  { time: '08:30 AM', action: 'INS-2026-0467 resubmitted after rework', user: 'Manoj Verma', iconClass: 'fa-solid fa-pen-to-square', color: '#DB2828' },
  { time: 'Yesterday', action: 'INS-2026-0466 approved — Final clearance granted', user: 'ITC Engineer', iconClass: 'fa-solid fa-circle-check', color: '#4d9dd9' },
];

export default function Dashboard() {
  const navigate = useNavigate();
  const location = useLocation();
  const [activeNav, setActiveNav] = useState('overview');
  const [activeStage, setActiveStage] = useState(null);
  const [searchQuery, setSearchQuery] = useState('');
  const [sidebarOpen, setSidebarOpen] = useState(false);
  const [showLogout, setShowLogout] = useState(false);

  useEffect(() => {
    if (location.state?.activeNav) {
      setActiveNav(location.state.activeNav);
    }
  }, [location.state]);

  const totalInspections = workflowStages.reduce((sum, s) => sum + s.count, 0);
  const pendingTotal = workflowStages.reduce((sum, s) => sum + s.pending, 0);
  const approvedCount = workflowStages.find(s => s.id === 'final-approved')?.count || 0;
  const approvalRate = totalInspections > 0 ? ((approvedCount / totalInspections) * 100).toFixed(1) : '0';

  const filteredInspections = recentInspections.filter(item => {
    const matchesSearch = searchQuery === '' ||
      `${item.id} ${item.form} ${item.title} ${item.inspector}`.toLowerCase().includes(searchQuery.toLowerCase());
    const matchesStage = !activeStage || item.stage === activeStage;
    return matchesSearch && matchesStage;
  });

  const maxTrendVal = Math.max(...weeklyTrend.map(d => Math.max(d.submitted || 1, d.approved || 1, d.rework || 1, d.pending || 1, d.review || 1, d.confirmed || 1)));

  return (
    <div className="railway-layout">
      {/* SIDEBAR */}
      <aside className={`railway-sidebar ${sidebarOpen ? 'is-open' : ''}`}>
        <div className="sidebar-brand">
          <div className="sidebar-brand-text">
            <strong>ITCTC</strong>
            <small>Inspection Portal</small>
          </div>
        </div>

        <nav className="sidebar-nav">
          <p className="sidebar-section-label">WORKSPACE</p>
          {sidebarNav.map(item => (
            <button
              key={item.id}
              className={`sidebar-nav-item ${activeNav === item.id ? 'active' : ''}`}
              onClick={() => {
                setActiveNav(item.id);
                setSidebarOpen(false);
              }}
            >
              <i className={item.icon} />
              <span>{item.label}</span>
              {item.id === 'workflow' && <span className="sidebar-badge">81</span>}
              {item.id === 'inspections' && <span className="sidebar-badge amber">9</span>}
            </button>
          ))}
        </nav>

      </aside>

      {/* BACKDROP */}
      {sidebarOpen && <div className="sidebar-backdrop" onClick={() => setSidebarOpen(false)} />}

      {/* MAIN AREA */}
      <div className="railway-main-area">
        {/* TOP HEADER */}
        <header className="railway-topbar">
          <div className="topbar-left">
            <button className="sidebar-toggle" onClick={() => setSidebarOpen(true)}>
              <i className="fa-solid fa-bars" />
            </button>
            <div className="topbar-title">
              <h1>
                {activeNav === 'overview' && <><i className="fa-solid fa-gauge-high" /> Overview</>}
                {activeNav === 'workflow' && <><i className="fa-solid fa-diagram-project" /> Workflow</>}
                {activeNav === 'defects' && <><i className="fa-solid fa-triangle-exclamation" /> Defects</>}
                {activeNav === 'reports' && <><i className="fa-solid fa-chart-column" /> Reports</>}
                {activeNav === 'forms' && <><i className="fa-solid fa-table-list" /> Forms</>}
                {activeNav === 'logs' && <><i className="fa-solid fa-clock-rotate-left" /> Inspection Logs</>}
              </h1>
              <p>Welcome back. Here is today's inspection summary.</p>
            </div>
          </div>
          <div className="topbar-right">
            <div className="topbar-search">
              <i className="fa-solid fa-magnifying-glass" />
              <input
                type="text"
                placeholder="Search..."
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
              />
            </div>
            <button className="topbar-icon-btn" title="Notifications">
              <i className="fa-solid fa-bell" />
              <span className="notif-dot" />
            </button>
            <button className="topbar-icon-btn" title="Settings">
              <i className="fa-solid fa-gear" />
            </button>
            <div className="topbar-user-wrap">
              <button className="topbar-user" onClick={() => setShowLogout(!showLogout)}>
                <div className="topbar-avatar">D</div>
                <span className="topbar-user-name">David</span>
              </button>
              {showLogout && (
                <div className="topbar-dropdown">
                  <button onClick={() => window.location.href = '/'}>
                    <i className="fa-solid fa-right-from-bracket" /> Logout
                  </button>
                </div>
              )}
            </div>
          </div>
        </header>

        {/* CONTENT */}
        <main className="railway-content">

          {/* ============ OVERVIEW ============ */}
          {activeNav === 'overview' && (
            <>
              <section className="railway-stats-row">
                <div className="railway-stat-card stat-blue">
                  <div className="stat-card-icon"><i className="fa-solid fa-file-lines" /></div>
                  <div className="stat-card-info">
                    <span className="stat-card-value">{totalInspections}</span>
                    <span className="stat-card-label">Total Inspections</span>
                  </div>
                </div>
                <div className="railway-stat-card stat-amber">
                  <div className="stat-card-icon"><i className="fa-solid fa-clock-rotate-left" /></div>
                  <div className="stat-card-info">
                    <span className="stat-card-value">{pendingTotal}</span>
                    <span className="stat-card-label">Pending Review</span>
                  </div>
                </div>
                <div className="railway-stat-card stat-green">
                  <div className="stat-card-icon" style={{ color: '#79d58f' }}><i className="fa-solid fa-circle-check" /></div>
                  <div className="stat-card-info">
                    <span className="stat-card-value">{approvedCount}</span>
                    <span className="stat-card-label">Final Approved</span>
                  </div>
                </div>
                <div className="railway-stat-card stat-purple">
                  <div className="stat-card-icon"><i className="fa-solid fa-chart-line" /></div>
                  <div className="stat-card-info">
                    <span className="stat-card-value">{approvalRate}%</span>
                    <span className="stat-card-label">Approval Rate</span>
                  </div>
                </div>
                <div className="railway-stat-card stat-red">
                  <div className="stat-card-icon"><i className="fa-solid fa-triangle-exclamation" /></div>
                  <div className="stat-card-info">
                    <span className="stat-card-value">2</span>
                    <span className="stat-card-label">Urgent Items</span>
                  </div>
                </div>
              </section>

              {/* 100 KM Overview + Key Metrics side by side */}
              <section className="overview-split">
                <div className="overview-left">
                  <div className="km-header">
                    <h3>100 K.M Project Overview</h3>
                  </div>
                  <div className="km-sections-grid">
                    {[
                      { section: 'Section A', range: '0 - 25 KM', km: 25, passed: 19, pending: 3, color: '#DB2828', pct: 76 },
                      { section: 'Section B', range: '25 - 50 KM', km: 25, passed: 16, pending: 4, color: '#212121', pct: 64 },
                      { section: 'Section C', range: '50 - 75 KM', km: 25, passed: 14, pending: 4, color: '#f2711c', pct: 56 },
                      { section: 'Section D', range: '75 - 100 KM', km: 25, passed: 18, pending: 3, color: '#4d9dd9', pct: 72 },
                    ].map(s => (
                      <div key={s.section} className="km-box" style={{ borderLeft: `4px solid ${s.color}` }}>
                        <div className="km-box-top">
                          <div className="km-box-icon" style={{ background: '#f2f2f2', color: s.color }}>
                            <i className="fa-solid fa-train" />
                          </div>
                          <span className="km-box-name">{s.section}</span>
                          <span className="km-box-pct" style={{ color: s.color }}>{s.pct}%</span>
                        </div>
                        <div className="km-box-range">{s.range}</div>
                        <div className="km-box-bar-track">
                          <div className="km-box-bar" style={{ width: `${s.pct}%`, background: s.color }} />
                        </div>
                        <div className="km-box-footer">
                          <div className="km-box-footer-item">
                            <span className="km-box-footer-val" style={{ color: s.color }}>{s.passed}</span>
                            <span className="km-box-footer-label">Passed</span>
                          </div>
                          <div className="km-box-footer-divider" />
                          <div className="km-box-footer-item">
                            <span className="km-box-footer-val" style={{ color: '#f2711c' }}>{s.pending}</span>
                            <span className="km-box-footer-label">Pending</span>
                          </div>
                        </div>
                      </div>
                    ))}
                  </div>
                  <div className="key-metrics-inline">
                    <div className="km-header">
                      <h3>Key Metrics Summary</h3>
                    </div>
                    <div className="key-metrics-grid">
                      {[
                        { label: 'Total Sections', value: '4', sub: 'of 100 KM', color: '#DB2828' },
                        { label: 'Completion', value: '77%', sub: 'overall', color: '#f2711c' },
                        { label: 'Pass Rate', value: '82%', sub: 'per section', color: '#4d9dd9' },
                        { label: 'Open Issues', value: '14', sub: 'needs attention', color: '#79d58f' },
                        { label: 'Forms Done', value: '11', sub: 'of 11', color: '#212121' },
                        { label: 'Deadline', value: '18', sub: 'days left', color: '#DB2828' },
                      ].map(m => (
                        <div key={m.label} className="metric-card">
                          <div className="metric-info">
                            <span className="metric-value" style={{ color: m.color }}>{m.value}</span>
                            <span className="metric-label">{m.label}</span>
                            <span className="metric-sub">{m.sub}</span>
                          </div>
                        </div>
                      ))}
                    </div>
                  </div>
                </div>

                <div className="overview-right railway-card pie-card">
                  <div className="card-header">
                    <h3>Inspection Status Overview</h3>
                  </div>
                  <div className="pie-chart-container">
                    {(() => {
                      const statusData = [
                        { label: 'Inspector', count: 12, color: '#DB2828' },
                        { label: 'PMC Review', count: 8, color: '#f2711c' },
                        { label: 'Inspector Rework', count: 5, color: '#4d9dd9' },
                        { label: 'ITC Preconfirmation', count: 6, color: '#79d58f' },
                        { label: 'PMC Response', count: 3, color: '#212121' },
                        { label: 'Final Approved', count: 47, color: '#79d58f' },
                      ];
                      const total = statusData.reduce((a, b) => a + b.count, 0);
                      let cumulative = 0;
                      const gradientParts = statusData.map(item => {
                        const start = cumulative;
                        cumulative += (item.count / total) * 360;
                        return `${item.color} ${start}deg ${cumulative}deg`;
                      });
                      return (
                        <>
                          <div className="pie-chart" style={{ background: `conic-gradient(${gradientParts.join(', ')})` }}>
                            <div className="pie-chart-hole">
                              <span className="pie-total">{total}</span>
                              <span className="pie-total-label">Total</span>
                            </div>
                          </div>
                          <div className="pie-legend">
                            {statusData.map(item => (
                              <div key={item.label} className={`pie-legend-item${item.label === 'Final Approved' ? ' final-approved-legend-item' : ''}`}>
                                <span className="pie-legend-dot" style={{ background: item.color }} />
                                <span className="pie-legend-label">{item.label}</span>
                                <span className="pie-legend-count">{item.count}</span>
                                <span className="pie-legend-pct">{((item.count / total) * 100).toFixed(0)}%</span>
                              </div>
                            ))}
                          </div>
                        </>
                      );
                    })()}
                  </div>
                </div>
              </section>

              <div className="railway-card activity-feed-card">
                <div className="card-header">
                  <h3>Activity Feed</h3>
                  <span className="card-badge"><i className="fa-solid fa-clock" /> Live</span>
                </div>
                <div className="activity-feed">
                  {activityFeed.map((item, i) => (
                    <div key={i} className="activity-item">
                      <div className="activity-icon" style={{ background: `${item.color}14`, color: item.color }}>
                        <i className={item.iconClass} />
                      </div>
                      <div className="activity-content">
                        <p>{item.action}</p>
                        <small><i className="fa-solid fa-user" /> {item.user} &middot; <i className="fa-regular fa-clock" /> {item.time}</small>
                      </div>
                    </div>
                  ))}
                </div>
              </div>

              {/* Workflow Pipeline */}
              <div className="railway-card workflow-overview-card">
                <div className="card-header">
                  <h3>Workflow Pipeline</h3>
                  <span className="card-badge">81 Total</span>
                </div>
                <div className="workflow-overview-grid">
                    {workflowStages.filter(s => s.id !== 'total').map(stage => (
                      <div key={stage.id} className="workflow-overview-item">
                        <div className="workflow-overview-icon" style={{ background: '#f2f2f2', color: stage.color }}>
                          <i className={stage.iconClass} />
                        </div>
                        <div className="workflow-overview-info">
                          <span className="workflow-overview-label">{stage.label}</span>
                          <span className="workflow-overview-count" style={{ color: stage.color }}>{stage.count}</span>
                          {stage.pending > 0 && (
                            <span className="workflow-overview-pending">{stage.pending} pending</span>
                          )}
                        </div>
                      </div>
                    ))}
                </div>
              </div>
            </>
          )}

          {/* ============ WORKFLOW ============ */}
          {activeNav === 'workflow' && (
            <>
              <div className="workflow-overview-grid" style={{ marginBottom: 16 }}>
                {workflowStages.filter(s => s.id !== 'total').map(stage => (
                  <div key={stage.id} className="workflow-overview-item" style={{ cursor: 'pointer', borderLeft: `3px solid ${stage.color}` }} onClick={() => setActiveStage(activeStage === stage.id ? null : stage.id)}>
                     <div className="workflow-overview-icon" style={{ background: '#f2f2f2', color: stage.color }}>
                       <i className={stage.iconClass} />
                     </div>
                     <div className="workflow-overview-info">
                       <span className="workflow-overview-label">{stage.label}</span>
                       <span className="workflow-overview-count" style={{ color: stage.color }}>{stage.count}</span>
                       {stage.pending > 0 && (
                         <span className="workflow-overview-pending">{stage.pending} pending</span>
                       )}
                     </div>
                  </div>
                ))}
              </div>
              <div className="workflow-details-grid">
                <div className="railway-card">
                  <div className="card-header">
                    <h3><i className="fa-solid fa-chart-pie" /> Stage Breakdown</h3>
                  </div>
                  <div className="breakdown-list">
                    {workflowStages.map(stage => {
                      const pct = totalInspections > 0 ? ((stage.count / totalInspections) * 100) : 0;
                      return (
                        <div key={stage.id} className="breakdown-item">
                          <div className="breakdown-label">
                            <i className={stage.iconClass} style={{ color: stage.color, fontSize: '13px' }} />
                            <span>{stage.label}</span>
                          </div>
                          <div className="breakdown-bar-track">
                            <div className="breakdown-bar" style={{ width: `${pct}%`, background: stage.color }} />
                          </div>
                          <span className="breakdown-count">{stage.count}</span>
                        </div>
                      );
                    })}
                  </div>
                </div>

                <div className="railway-card">
                  <div className="card-header">
                    <h3><i className="fa-solid fa-chart-simple" /> Weekly Activity</h3>
                    <span className="card-badge"><i className="fa-solid fa-calendar-days" /> This Week</span>
                  </div>
                  <div className="trend-bars">
                    {weeklyTrend.map(d => (
                      <div key={d.day} className="trend-day">
                          <div className="trend-bar-stack">
                            <div className="trend-bar" style={{ height: `${(d.submitted / maxTrendVal) * 100}%`, background: '#DB2828' }} title={`Submitted: ${d.submitted}`} />
                            <div className="trend-bar" style={{ height: `${(d.approved / maxTrendVal) * 100}%`, background: '#4d9dd9' }} title={`Approved: ${d.approved}`} />
                            <div className="trend-bar" style={{ height: `${(d.rework / maxTrendVal) * 100}%`, background: '#DB2828' }} title={`Rework: ${d.rework}`} />
                            <div className="trend-bar" style={{ height: `${(d.pending / maxTrendVal) * 100}%`, background: '#f2711c' }} title={`Pending: ${d.pending}`} />
                            <div className="trend-bar" style={{ height: `${(d.review / maxTrendVal) * 100}%`, background: '#fcd76a' }} title={`Review: ${d.review}`} />
                            <div className="trend-bar" style={{ height: `${(d.confirmed / maxTrendVal) * 100}%`, background: '#79d58f' }} title={`Confirmed: ${d.confirmed}`} />
                          </div>
                        <span className="trend-label">{d.day}</span>
                      </div>
                    ))}
                  </div>
                  <div className="trend-legend">
                    <span><i className="dot" style={{ background: '#DB2828' }} /> Submitted</span>
                    <span><i className="dot" style={{ background: '#4d9dd9' }} /> Approved</span>
                    <span><i className="dot" style={{ background: '#DB2828' }} /> Rework</span>
                    <span><i className="dot" style={{ background: '#f2711c' }} /> Pending</span>
                    <span><i className="dot" style={{ background: '#fcd76a' }} /> Review</span>
                    <span><i className="dot" style={{ background: '#79d58f' }} /> Confirmed</span>
                  </div>
                </div>

                <div className="railway-card activity-feed-card">
                  <div className="card-header">
                    <h3><i className="fa-solid fa-timeline" /> Activity Feed</h3>
                    <span className="card-badge"><i className="fa-solid fa-clock" /> Live</span>
                  </div>
                  <div className="activity-feed">
                    {activityFeed.map((item, i) => (
                      <div key={i} className="activity-item">
                        <div className="activity-icon" style={{ background: `${item.color}14`, color: item.color }}>
                          <i className={item.iconClass} />
                        </div>
                        <div className="activity-content">
                          <p>{item.action}</p>
                          <small><i className="fa-solid fa-user" /> {item.user} &middot; <i className="fa-regular fa-clock" /> {item.time}</small>
                        </div>
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            </>
          )}

          {activeNav === 'reports' && (
            <div className="reports-panel">
              <div className="card-header">
                <h3><i className="fa-solid fa-chart-column" /> Inspection Reports</h3>
                <div className="report-actions">
                  <button type="button" onClick={() => window.print()} title="Download Report as PDF"><i className="fa-solid fa-file-pdf" /> PDF</button>
                  <button type="button" onClick={() => downloadExcel('Reports-Overview.xls')} title="Download Report as Excel"><i className="fa-solid fa-file-excel" /> Excel</button>
                </div>
              </div>

              <div className="tolerance-report-grid">
                <div className="tolerance-panel">
                  <h3>Overall Compliance</h3>
                  <div className="tolerance-summary">
                    <div className="pie-chart" style={{ background: `conic-gradient(rgb(219, 40, 40) 0 ${(((workflowStages.find(s=>s.id==='inspector')?.count||0) + (workflowStages.find(s=>s.id==='pmc-response')?.count||0)) / Math.max(totalInspections,1)) * 360}deg rgb(45, 106, 225) 0deg)` }}>
                      <div className="pie-chart-hole">
                        <span className="pie-total">{totalInspections}</span>
                        <span className="pie-total-label">Total</span>
                      </div>
                    </div>
                    <div className="tolerance-legend">
                      <span><i className="pie-dot" style={{ background: 'rgb(219, 40, 40)' }} /> Inspector</span>
                      <span><i className="pie-dot" style={{ background: '#f2711c' }} /> PMC Review</span>
                      <span><i className="pie-dot" style={{ background: '#4d9dd9' }} /> Rework</span>
                      <span><i className="pie-dot" style={{ background: '#79d58f' }} /> ITC Review</span>
                      <span><i className="pie-dot" style={{ background: '#212121' }} /> PMC Response</span>
                      <span><i className="pie-dot" style={{ background: '#79d58f' }} /> Final Approved</span>
                    </div>
                  </div>
                </div>

                <div className="tolerance-panel">
                  <h3>Stage Breakdown</h3>
                  <div className="breakdown-list">
                    {workflowStages.filter(s => s.id !== 'total').map(stage => {
                      const pct = totalInspections > 0 ? ((stage.count / totalInspections) * 100) : 0;
                      return (
                        <div key={stage.id} className="breakdown-item">
                          <div className="breakdown-label">
                            <i className={stage.iconClass} style={{ color: stage.color, fontSize: '13px' }} />
                            <span>{stage.label}</span>
                          </div>
                          <div className="breakdown-bar-track">
                            <div className="breakdown-bar" style={{ width: `${pct}%`, background: stage.color }} />
                          </div>
                          <span className="breakdown-count">{stage.count}</span>
                        </div>
                      );
                    })}
                  </div>
                </div>
              </div>

              <div className="railway-card" style={{ marginTop: '18px' }}>
                <div className="card-header">
                  <h3><i className="fa-solid fa-triangle-exclamation" /> Urgent Items</h3>
                </div>
                {recentInspections.filter(i => i.priority === 'urgent').length > 0 ? (
                  <div className="inspections-table-wrap">
                    <table className="inspections-table">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Form</th>
                          <th>Title</th>
                          <th>Chainage</th>
                          <th>Inspector</th>
                          <th>Stage</th>
                          <th>Date</th>
                        </tr>
                      </thead>
                      <tbody>
                        {recentInspections.filter(i => i.priority === 'urgent').map(item => (
                          <tr key={item.id}>
                            <td><strong>{item.id}</strong></td>
                            <td><span className={`form-badge ${item.form.startsWith('T') ? 'track' : 'civil'}`}>{item.form}</span></td>
                            <td>{item.title}</td>
                            <td className="chainage-cell">{item.chainage}</td>
                            <td>{item.inspector}</td>
                            <td><span className={`stage-tag tone-amber`}>Urgent</span></td>
                            <td className="date-cell">{item.date}</td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  </div>
                ) : (
                  <p style={{ padding: '20px', textAlign: 'center', color: 'var(--text-muted)' }}>No urgent items at this time.</p>
                )}
              </div>
            </div>
          )}

          {/* ============ DEFECTS ============ */}
          {activeNav === 'defects' && (
            <div className="railway-card">
              <div className="card-header">
                <h3><i className="fa-solid fa-triangle-exclamation" /> Defects Register</h3>
                <span className="card-badge"><i className="fa-solid fa-flag" /> {defectsData.length} Items</span>
              </div>
              <div className="inspections-table-wrap">
                <table className="inspections-table">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Form</th>
                      <th>Defect Description</th>
                      <th>Chainage</th>
                      <th>Severity</th>
                      <th>Inspector</th>
                      <th>Date</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    {[...defectsData].sort((a, b) => a.inspector.localeCompare(b.inspector)).map(defect => (
                      <tr key={defect.id}>
                        <td><strong>{defect.id}</strong></td>
                        <td><span className={`form-badge ${defect.form.startsWith('T') ? 'track' : 'civil'}`}>{defect.form}</span></td>
                        <td>{defect.description}</td>
                        <td className="chainage-cell">{defect.chainage}</td>
                        <td><span className={`stage-tag ${defect.severity === 'critical' ? 'tone-amber' : defect.severity === 'major' ? 'tone-red' : 'tone-blue'}`}>{defect.severity}</span></td>
                        <td>{defect.inspector}</td>
                        <td className="date-cell">{defect.date}</td>
                        <td>
                          <button type="button" className="view-btn" title="View Details"><i className="fa-solid fa-eye" /></button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* ============ FORMS ============ */}
          {activeNav === 'forms' && (
            <div className="railway-card">
              <div className="card-header">
                <h3><i className="fa-solid fa-table-list" /> Form-wise Inspection Summary</h3>
                <span className="card-badge"><i className="fa-solid fa-file-lines" /> {formStats.length} Forms</span>
              </div>
               <div className="forms-grid">
                  {formStats.map(f => {
                    const passRate = f.total > 0 ? ((f.passed / f.total) * 100).toFixed(0) : 0;
                    return (
                      <div 
                        key={f.code} 
                        className="form-summary-item"
                        onClick={() => navigate(f.path)}
                      >
                        <div className="form-summary-header">
                          <span className={`form-badge ${f.code.startsWith('T') ? 'track' : 'civil'}`}>{f.code}</span>
                          <span className="form-pass-rate" style={{ color: passRate >= 80 ? '#4d9dd9' : '#f2711c' }}>{passRate}%</span>
                        </div>
                        <span className="form-summary-name">{f.name}</span>
                        <div className="form-summary-bar-track">
                          <div className="form-summary-bar" style={{ width: `${passRate}%` }} />
                        </div>
                        <div className="form-summary-meta">
                          <span><i className="fa-solid fa-circle-check" /> {f.passed} passed</span>
                          <span><i className="fa-solid fa-clock" /> {f.pending} pending</span>
                        </div>
                      </div>
                    );
                  })}
              </div>
            </div>
          )}

          {/* ============ LOGS ============ */}
          {activeNav === 'logs' && (
            <div className="railway-card">
              <div className="card-header">
                <h3><i className="fa-solid fa-clock-rotate-left" /> Inspection Logs</h3>
              </div>
              <div className="inspections-table-wrap">
                <table className="inspections-table">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Form</th>
                      <th>Description</th>
                      <th>Chainage</th>
                      <th>Inspector</th>
                      <th>Stage</th>
                      <th>Date</th>
                    </tr>
                  </thead>
                  <tbody>
                    {recentInspections.map(item => {
                      const st = stageLabels[item.stage];
                      return (
                        <tr key={item.id}>
                          <td><strong>{item.id}</strong></td>
                          <td><span className={`form-badge ${item.form.startsWith('T') ? 'track' : 'civil'}`}>{item.form}</span></td>
                          <td>{item.title}</td>
                          <td className="chainage-cell">{item.chainage}</td>
                          <td>{item.inspector}</td>
                          <td><span className={`stage-tag tone-${st.tone}`}>{st.label}</span></td>
                          <td className="date-cell">{item.date}</td>
                        </tr>
                      );
                    })}
                  </tbody>
                </table>
              </div>
            </div>
          )}

        </main>
      </div>
    </div>
  );
}
