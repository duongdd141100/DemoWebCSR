import Header from "../layouts/Header";
import Menu from '../layouts/Menu'

export default function MainLayout({ children, header, menu }) {
    
    return (
        <div>
            <div className="header">
                <Header header={header} />
            </div>
            <div className="body">
                <div className="menu">
                    <Menu menu={menu} />
                </div>
                <div className="content">
                    {children}
                </div>
            </div>
        </div>
    )
}