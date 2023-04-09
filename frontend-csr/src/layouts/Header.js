import { NavLink } from "react-router-dom";

function logout() {
    localStorage.clear();
    window.location.href = '/';
}

export default function Header({ header }) {
    return (
        <div>
            {Object.keys(header).map(x => <NavLink
                key={x}
                to={x}
            >
                {header[x].label}
            </NavLink>)}
            <NavLink to='/' onClick={logout}>Logout</NavLink>
        </div>
    )
}