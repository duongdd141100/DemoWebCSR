import Header from "../layouts/Header";
import Menu from '../layouts/Menu'
import { useLocation } from "react-router-dom";

export default function MainLayout({ children, header, menuRouters, menu }) {
    let parentPath = useLocation().pathname;
    return (
        <div>
            <div className="header">
                <Header header={header} />
            </div>
            <div className="body">
                <div className="menu">
                    <Menu menu={menuRouters} menuKeys={menu.filter(x => x.parent === parentPath).map(x => x.slug)}  />
                </div>
                <div className="content">
                    {children}
                </div>
            </div>
        </div>
    )
}