import { useState } from 'react'
import { getHeader } from '../constants/ServiceConstants'
import Login from '../components/Login'



export default function Routers() {
    const [token, setToken] = useState("");
    if (Object.keys(token).length === 0) {
        return <Login setToken={(value) => setToken(value)}/>
    }

    console.log(token);

    fetch(getHeader,
        {
            method: "GET",
            headers: {
                'Authorization': `${token}`
            }
        }).then(response => response.json())
        .then(data => {
            console.log(data)
        })
        .catch(e => console.error(e))
}