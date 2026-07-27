import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { login, isAuthenticated } from "../services/authService";
import "./Login.css";

export default function Login() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", password: "" });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  useEffect(() => {
    if (isAuthenticated()) {
      navigate("/dashboard", { replace: true });
    }
  }, [navigate]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    try {
      await login(form.username, form.password);
      navigate("/dashboard");
    } catch (err) {
      if (err.response?.data?.message) {
        setError(err.response.data.message);
      } else {
        setError("Invalid Username or Password");
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-page">
      <div className="login-card">
        <div className="login-brand">
          <div className="login-brand-row">
            <div className="login-logo">
              <i className="fa-solid fa-train-subway" />
            </div>
            <div className="login-brand-text">
              <h1>ITCTC</h1>
              <p>Inspection Tracking & Compliance</p>
            </div>
          </div>
        </div>

        <form onSubmit={handleSubmit} className="login-form">
          <div className="input-group">
            <i className="fa-solid fa-user" />
            <input
              type="text"
              name="username"
              placeholder="Username"
              value={form.username}
              onChange={handleChange}
              required
              autoComplete="username"
            />
          </div>

          <div className="input-group">
            <i className="fa-solid fa-lock" />
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={form.password}
              onChange={handleChange}
              required
              autoComplete="current-password"
            />
          </div>

          {error && <p className="login-error">{error}</p>}

          <button type="submit" disabled={loading} className="login-btn">
            {loading ? (
              <div className="train-loader">
                <div className="train-icon">
                  <div className="train-body">
                    <div className="train-window" />
                    <div className="train-window" />
                  </div>
                  <div className="train-lights">
                    <div className="train-light" />
                    <div className="train-light" />
                  </div>
                </div>
                <div className="track-wrapper">
                  <div className="track-line" />
                  <div className="track-line" />
                  <div className="track-line" />
                  <div className="track-line" />
                  <div className="track-line" />
                </div>
              </div>
            ) : (
              "Login"
            )}
          </button>
        </form>
      </div>
    </div>
  );
}
