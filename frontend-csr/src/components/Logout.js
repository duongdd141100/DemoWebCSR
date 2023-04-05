import Login from "./Login";

export default function Logout() {
    localStorage.setItem('token', '');
    return <Login />
}