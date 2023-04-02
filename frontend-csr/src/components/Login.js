import { useState } from "react"
import { signIn } from "../constants/ServiceConstants";
import { post } from "../services/Service"
import '../css/Common.css'

const divStyle = {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100%',
    flexDirection: 'column',
}

export default function Login({ setToken }) {
    const [user, setUser] = useState("");
    const [pass, setPass] = useState("");
    return <div style={divStyle}>
        <div>
            <h3>Demo Web</h3>
        </div>
        <div>
            <label>Username: </label>
            <input type="text" name="username" id="username" onChange={e => setUser(e.target.value)}/>
        </div>
        <div>
            <label>Password: </label>
            <input type={"password"} name="password" id="password" onChange={e => setPass(e.target.value)} />
        </div>

        <button className="successButton" onClick={() => post(signIn,
            JSON.stringify({
                username: user,
                password: pass
            }),
            (data) => setToken(`Bearer ${data.body}`),
            (data) => {throw new Error(data.body);}
            )}>Login</button>

    </div>
}
