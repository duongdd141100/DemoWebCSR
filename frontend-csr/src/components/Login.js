import { useState } from "react"
import { signIn } from "../constants/ServiceConstants";

function loginHandler(user, pass, setToken) {
    fetch(signIn,
        {
            method: 'POST',
            body: JSON.stringify({
                username: user,
                password: pass
            })
        })
        .then(response => response.json())
        .then(data => {
            setToken(`Bearer ${data.body}`)
        })
}

export default function Login({ setToken }) {
    const [user, setUser] = useState("");
    const [pass, setPass] = useState("");
    return <div>
        <label>username</label>
        <input type="text" name="username" id="username" onChange={e => setUser(e.target.value)}/>

        <label>password</label>
        <input type={"password"} name="password" id="password" onChange={e => setPass(e.target.value)} />

        <button onClick={() => loginHandler(user, pass, setToken)}>Login</button>

    </div>
}