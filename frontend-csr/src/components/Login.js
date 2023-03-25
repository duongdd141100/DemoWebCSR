import { useState } from "react"
import { signIn } from "../constants/ServiceConstants";
import { post } from "../services/Service"

export default function Login({ setToken }) {
    const [user, setUser] = useState("");
    const [pass, setPass] = useState("");
    return <div>
        <label>username</label>
        <input type="text" name="username" id="username" onChange={e => setUser(e.target.value)}/>

        <label>password</label>
        <input type={"password"} name="password" id="password" onChange={e => setPass(e.target.value)} />

        <button onClick={() => post(signIn,
            JSON.stringify({
                username: user,
                password: pass
            }),
            (data) => setToken(`Bearer ${data.body}`),
            (data) => {throw new Error(data.body);}
            )}>Login</button>

    </div>
}