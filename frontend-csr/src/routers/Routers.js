import { useState, useEffect } from 'react'
import Login from '../components/Login'
import MainLayout from '../layouts/MainLayout'
import { getHeaderApi } from '../constants/ServiceConstants'
import { Services } from '../services/Service'
import Home from '../layouts/Home'
import About from '../layouts/About'
import Docs from '../components/Docs'
import Email from '../components/Email'
import Logout from '../components/Logout'
import { Routes, Route } from 'react-router-dom'


let headerRouters = {
    '/home': {
        component: <Home />
    },
    '/about': {
        component: <About />
    },
    '/logout': {
        component: <Logout />
    }
}

let menuRouters = {
    '/docs': {
        component: <Docs />,
    },
    '/email': {
        component: <Email />,
    },
};
export default function Routers() {
    const [token, setToken] = useState("");
    const [header, setHeader] = useState([]);
    // localStorage.setItem("token", "")
    useEffect(() => {
        if (Object.keys(token).length !== 0 || localStorage.getItem("token").length !== 0) {
            Services.get(getHeaderApi, (data) => setHeader(data.body), (data) => {
                throw new Error(data.body);
            }, token)
        }
    }, [token]);

    if (Object.keys(token).length === 0 && localStorage.getItem("token").length === 0) {
        return <Login setToken={(value) => setToken(value)}/>
    }
    header.forEach(r => {
        headerRouters[r.slug].label = r.label;
    });
    return (
        <MainLayout header={headerRouters} menu={menuRouters}>
            <Routes>
                {Object.keys(headerRouters).map(key => {
                    return <Route key={key} path={key} element={headerRouters[key].component} />
                })}
            </Routes>
        </MainLayout>
    )
}
