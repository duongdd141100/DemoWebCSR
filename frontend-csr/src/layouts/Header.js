import { NavLink } from "react-router-dom";

export default function Header({ header }) {
    return (
        <div>
            {Object.keys(header).map(x => <NavLink
                key={x}
                to={x}
            >
                {header[x].label}
            </NavLink>)}
        </div>
    )
}