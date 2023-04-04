import { Services } from "../services/Service";
import { getHeaderApi } from '../constants/ServiceConstants'
import { useState } from "react";

async function getHeader(token) {
    let routers = [];
    await Services.get(getHeaderApi, (data) => { routers = data.body}, (data) => {
        throw new Error(data.body);
    }, token);
    console.log(routers)
}

export default function MainLayout({ token }) {
    const [headerRouters, setHeaderRouters] = useState([]);

    getHeader(token)
    
    // setTimeout(() => console.log(routers), 2000);
}