import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login,isAuthenticated  } from "../services/authService";
import { useEffect } from "react";


export default function Login() {

   const navigate = useNavigate();

useEffect(() => {
    if (isAuthenticated()) {
        navigate("/dashboard", { replace: true });
    }
}, [navigate]);

const [form, setForm] = useState({
    username: "",
    password: ""
});

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const handleChange = (e) => {

        setForm({
            ...form,
            [e.target.name]: e.target.value
        });

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

        <div
            style={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                height: "100vh",
                background: "#f5f5f5"
            }}
        >

            <form
                onSubmit={handleSubmit}
                style={{
                    width: 350,
                    background: "#fff",
                    padding: 30,
                    borderRadius: 10,
                    boxShadow: "0 0 10px rgba(0,0,0,0.15)"
                }}
            >

                <h2 style={{ textAlign: "center" }}>
                    ITCTC Login
                </h2>

                <br />

                <input
                    type="text"
                    name="username"
                    placeholder="Username"
                    value={form.username}
                    onChange={handleChange}
                    required
                    style={{
                        width: "100%",
                        padding: 10,
                        marginBottom: 15
                    }}
                />

                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={form.password}
                    onChange={handleChange}
                    required
                    style={{
                        width: "100%",
                        padding: 10,
                        marginBottom: 15
                    }}
                />

                {

                    error &&

                    <p
                        style={{
                            color: "red",
                            marginBottom: 15
                        }}
                    >
                        {error}
                    </p>

                }

                <button
                    type="submit"
                    disabled={loading}
                    style={{
                        width: "100%",
                        padding: 10,
                        cursor: "pointer"
                    }}
                >

                    {loading ? "Logging In..." : "Login"}

                </button>

            </form>

        </div>

    );

}