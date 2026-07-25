import { Routes, Route, Navigate } from 'react-router-dom'

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

import Login from './pages/Login'
import ProtectedRoute from './components/ProtectedRoute'

const compMap = {
  '/form-c1': FormC1,
  '/form-c7': FormC7,
  '/form-t2': FormT2,
  '/form-t5': FormT5,
  '/form-t7-2': FormT72,
  '/form-t8': FormT8,
  '/form-t9': FormT9,
  '/form-t10': FormT10,
  '/form-t13': FormT13,
  '/form-t21': FormT21,
  '/form-t22': FormT22,
}

export default function App() {

  return (

    <Routes>

      {/* Public Route */}

      <Route
        path="/login"
        element={<Login />}
      />

      {/* Redirect Root */}

      <Route
        path="/"
        element={<Navigate to="/dashboard" replace />}
      />

      {/* Protected Dashboard */}

      <Route
        path="/dashboard"
        element={
          <ProtectedRoute>
            <Dashboard />
          </ProtectedRoute>
        }
      />

      {/* Protected Forms */}

      {Object.entries(compMap).map(([path, Comp]) => (

        <Route
          key={path}
          path={path}
          element={
            <ProtectedRoute>
              <Comp />
            </ProtectedRoute>
          }
        />

      ))}

      {/* Unknown Route */}

      <Route
        path="*"
        element={<Navigate to="/login" replace />}
      />

    </Routes>

  )

}