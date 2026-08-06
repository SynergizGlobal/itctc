import { Routes, Route, Navigate } from 'react-router-dom'

import FormC1 from './components/FormC1'
import FormC7 from './components/FormC7'
import FormT1 from './components/FormT1'
import FormT2 from './components/FormT2'
import FormT3 from './components/FormT3'
import FormT4 from './components/FormT4'
import FormT5 from './components/FormT5'
import FormT61 from './components/FormT61'
import FormT62 from './components/FormT62'
import FormT71 from './components/FormT71'
import FormT72 from './components/FormT-7-2'
import FormT8 from './components/FormT8'
import FormT9 from './components/FormT9'
import FormT10 from './components/FormT10'
import FormT21 from './components/FormT21'
import FormT22 from './components/FormT22'
import FormT13 from './components/FormT13'
import FormT121 from './components/FormT121'
import FormT122 from './components/FormT122'
import FormT14 from './components/FormT14'
import FormT15 from './components/FormT15'
import FormT16 from './components/FormT16'
import FormT17 from './components/FormT17'
import FormT18 from './components/FormT18'
import FormT19 from './components/FormT19'
import FormT20 from './components/FormT20'
import FormT23 from './components/FormT23'
import FormC2 from './components/FormC2'
import FormC4 from './components/FormC4'
import FormC5 from './components/FormC5'
import FormC6 from './components/FormC6'
import FormCa22 from './components/FormCa2-2'
import FormCa27 from './components/FormCa2-7'
import FormCa513 from './components/FormCa5-13'

import Dashboard from './dashboard/Dashboard'

import Login from './pages/Login'
import ProtectedRoute from './components/ProtectedRoute'
import Forms from './components/Forms'

const compMap = {
  '/form-c1': FormC1,
  '/form-c7': FormC7,
  '/form-t1': FormT1,
  '/form-t2': FormT2,
  '/form-t3': FormT3,
  '/form-t4': FormT4,
  '/form-t5': FormT5,
  '/form-t6-1': FormT61,
  '/form-t6-2': FormT62,
  '/form-t7-1': FormT71,
  '/form-t7-2': FormT72,
  '/form-t8': FormT8,
  '/form-t9': FormT9,
  '/form-t10': FormT10,
  '/form-t13': FormT13,
  '/form-t12-1': FormT121,
  '/form-t12-2': FormT122,
  '/form-t14': FormT14,
  '/form-t15': FormT15,
  '/form-t16': FormT16,
  '/form-t17': FormT17,
  '/form-t18': FormT18,
  '/form-t19': FormT19,
  '/form-t20': FormT20,
  '/form-t21': FormT21,
  '/form-t22': FormT22,
  '/form-t23': FormT23,
  '/form-c2': FormC2,
  '/form-c4': FormC4,
  '/form-c5': FormC5,
  '/form-c6': FormC6,
  '/form-ca2-2': FormCa22,
  '/form-ca2-7': FormCa27,
  '/form-ca5-13': FormCa513,
}

export default function App() {

  return (

    <Routes>

      {/* Public Route */}

      <Route
        path="/login"
        element={<Login />}
        
      />
      
      

      <Route
        path="/forms"
        element={<Forms />}
        
      />

      <Route
        path="/form"
        element={<Forms />}
        
      />

      {/* Redirect Root */}

      <Route
        path="/"
        element={<Forms />}
      />

      {/* Protected Dashboard */}

      <Route
        path="/dashboard"
        element={
          // <ProtectedRoute>
          //  
          // </ProtectedRoute>
            <Dashboard />
        }
        
      />

      {/* Protected Forms */}

      {Object.entries(compMap).map(([path, Comp]) => (

        <Route
          key={path}
          path={path}
          element={<Comp />}
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