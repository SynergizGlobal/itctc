import { Routes, Route, NavLink, Navigate, useLocation } from 'react-router-dom'
import FormC1 from './components/FormC1'
import FormC7 from './components/FormC7'
import FormT2 from './components/FormT2'
import FormT5 from './components/FormT5'
import FormT72 from './components/FormT-7-2'
import FormT8 from './components/FormT8'
import FormT9 from './components/FormT9'
import FormT10 from './components/FormT10'
import FormT21 from './components/FormT21'
import FormT22 from './components/FormT22'
import FormT13 from './components/FormT13'
import Dashboard from './dashboard/Dashboard'

const navItems = [
  { path: '/form-c1', label: 'C-1' },
  { path: '/form-c7', label: 'C-7' },
  { path: '/form-t2', label: 'T-2' },
  { path: '/form-t5', label: 'T-5' },
  { path: '/form-t7-2', label: 'T-7-2' },
  { path: '/form-t8', label: 'T-8' },
  { path: '/form-t9', label: 'T-9' },
  { path: '/form-t10', label: 'T-10' },
  { path: '/form-t13', label: 'T-13' },
  { path: '/form-t21', label: 'T-21' },
  { path: '/form-t22', label: 'T-22' },
]

const compMap = {
  '/form-c1': FormC1, '/form-c7': FormC7, '/form-t2': FormT2,
  '/form-t5': FormT5, '/form-t7-2': FormT72, '/form-t8': FormT8,
  '/form-t9': FormT9, '/form-t10': FormT10, '/form-t13': FormT13,
  '/form-t21': FormT21, '/form-t22': FormT22,
}

export default function App() {
  const { pathname } = useLocation()
  const isDashboard = pathname === '/dashboard'
  return (
    <div>
      {!isDashboard && <nav className="navbar navbar-expand navbar-dark bg-dark px-3">
        <span className="navbar-brand me-3 fw-bold">Forms</span>
        <div className="navbar-nav flex-row flex-wrap gap-1">
          {navItems.map(({ path, label }) => (
            <NavLink key={path} className={({ isActive }) => `nav-link py-1 px-2 ${isActive ? 'active' : ''}`} to={path}>
              {label}
            </NavLink>
          ))}
        </div>
      </nav>}
      <Routes>
        <Route path="/" element={<Navigate to="/form-c1" replace />} />
        {Object.entries(compMap).map(([path, Comp]) => (
          <Route key={path} path={path} element={<Comp />} />
        ))}
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </div>
  )
}
