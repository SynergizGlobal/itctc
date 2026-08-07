import { useState } from 'react';
import FormT1 from './FormT1';
import FormT3 from './FormT3';
import FormT4 from './FormT4';
import FormT61 from './FormT-6-1';
import FormT62 from './FormT-6-2';
import FormT71 from './FormT-7-1';
import FormT121 from './FormT-12-1';
import FormT122 from './FormT-12-2';
import FormT14 from './FormT14';
import FormT15 from './FormT15';
import FormT16 from './FormT16';
import FormT17 from './FormT17';
import FormT18 from './FormT18';
import FormT19 from './FormT19';
import FormT20 from './FormT20';
import FormT23 from './FormT23';
import FormC2 from './FormC2';
import FormC4 from './FormC4';
import FormC5 from './FormC5';
import FormC6 from './FormC6';
import FormCa22 from './FormCa2-2';
import FormCa27 from './FormCa2-7';
import FormCa513 from './FormCa5-13';
import '../dashboard/dashboard.css';

const allForms = [
  { code: 'T-1', Comp: FormT1 },
  { code: 'T-3', Comp: FormT3 },
  { code: 'T-4', Comp: FormT4 },
  { code: 'T-6-1', Comp: FormT61 },
  { code: 'T-6-2', Comp: FormT62 },
  { code: 'T-7-1', Comp: FormT71 },
  { code: 'T-12-1', Comp: FormT121 },
  { code: 'T-12-2', Comp: FormT122 },
  { code: 'T-14', Comp: FormT14 },
  { code: 'T-15', Comp: FormT15 },
  { code: 'T-16', Comp: FormT16 },
  { code: 'T-17', Comp: FormT17 },
  { code: 'T-18', Comp: FormT18 },
  { code: 'T-19', Comp: FormT19 },
  { code: 'T-20', Comp: FormT20 },
  { code: 'T-23', Comp: FormT23 },
  { code: 'C-2', Comp: FormC2 },
  { code: 'C-4', Comp: FormC4 },
  { code: 'C-5', Comp: FormC5 },
  { code: 'C-6', Comp: FormC6 },
  { code: 'Ca-2-2', Comp: FormCa22 },
  { code: 'Ca-2-7', Comp: FormCa27 },
  { code: 'Ca-5-13', Comp: FormCa513 },
];

export default function Forms() {
  const [active, setActive] = useState(allForms[0].code);
  const activeForm = allForms.find(f => f.code === active);

  return (
    <div>
      <header className="railway-topbar" style={{ height: 'auto', padding: '12px 28px', flexWrap: 'wrap', gap: '8px' }}>
        <div className="topbar-left" style={{ flexWrap: 'wrap', gap: '10px' }}>
          <div className="sidebar-brand-text">
            <strong>ITCTC</strong>
            <small>Inspection Portal</small>
          </div>
          <div className="topbar-title" style={{ borderLeft: '1px solid var(--border)', paddingLeft: '18px' }}>
            <h1><i className="fa-solid fa-table-list" /> Forms</h1>
            <p>Click a form to view it</p>
          </div>
        </div>
      </header>

      <div style={{ borderBottom: '1px solid var(--border)', background: '#f2f2f2', padding: '10px 28px', display: 'flex', gap: '6px', flexWrap: 'wrap', position: 'sticky', top: '68px', zIndex: '40' }}>
        {allForms.map(f => (
          <button
            key={f.code}
            type="button"
            onClick={() => setActive(f.code)}
            style={{
              border: active === f.code ? '1px solid #de3d3d' : '1px solid #f2f2f2',
              background: active === f.code ? '#de3d3d' : '#fff',
              color: active === f.code ? '#f2f2f2' : '#212121',
              padding: '5px 12px',
              borderRadius: '6px',
              fontSize: '12px',
              fontWeight: 700,
              cursor: 'pointer',
              fontFamily: 'inherit',
            }}
          >
            {f.code}
          </button>
        ))}
      </div>

      <main className="railway-content">
        {activeForm && <activeForm.Comp />}
      </main>
    </div>
  );
}
