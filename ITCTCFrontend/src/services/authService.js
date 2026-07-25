import api from "./api";

/**
 * Login User
 */
export const login = async (username, password) => {

    const response = await api.post("/auth/login", {
        username,
        password,
    });

    const data = response.data;

    // Save JWT Token
    localStorage.setItem("token", data.token);

    // Save Logged In User
    localStorage.setItem(
        "user",
        JSON.stringify({
            userId: data.userId,
            username: data.username,
            role: data.role,
            firstName: data.firstName,
            lastName: data.lastName,
            tokenType: data.tokenType,
        })
    );

    return data;
};

/**
 * Logout User
 */
export const logout = () => {

    localStorage.clear();

    window.location.replace("/login");
};

/**
 * Get Logged In User
 */
export const getCurrentUser = () => {

    const user = localStorage.getItem("user");

    return user ? JSON.parse(user) : null;
};

/**
 * Get JWT Token
 */
export const getToken = () => {

    return localStorage.getItem("token");
};

/**
 * Check Login Status
 */
export const isAuthenticated = () => {

    return !!localStorage.getItem("token");
};