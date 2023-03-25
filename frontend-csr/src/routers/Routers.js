import { useState } from 'react'
import { getHeader } from '../constants/ServiceConstants'
import Login from '../components/Login'
import { get } from '../services/Service'



export default function Routers() {
    const [token, setToken] = useState("");
    if (Object.keys(token).length === 0) {
        return <Login setToken={(value) => setToken(value)}/>
    }

    let headerRouters = get(getHeader, () => {}, (data) => {
        throw new Error(data.body);
    }, token);
    console.log(headerRouters);

    // fetch(getHeader,
    //     {
    //         method: "GET",
    //         headers: {
    //             'Authorization': `${token}`
    //         }
    //     }).then(response => response.json())
    //     .then(data => {
    //         console.log(data)
    //     })
    //     .catch(e => console.error(e))
}