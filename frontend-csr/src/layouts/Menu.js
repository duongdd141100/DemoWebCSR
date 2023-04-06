import { Link } from "react-router-dom"

export default function Menu({ menu, menuKeys }) {
    return (
        <ul>
            {menuKeys.map(x => <li key={x}><Link to={`${menu[x].parent}${x}`}>{menu[x].label}</Link></li>)}
        </ul>
    )
}