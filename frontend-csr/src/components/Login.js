import { useState } from "react"
import { signIn } from "../constants/ServiceConstants";
import { post } from "../services/Service"

function loginHandler(user, pass, setToken) {
    post(signIn,
        JSON.stringify({
            username: user,
            password: pass
        }),
        (data) => setToken(data.body),
        (data) => {throw new Error(data.body);}
        );
    // fetch(signIn,
    //     {
    //         method: 'POST',
    //         body: JSON.stringify({
    //             username: user,
    //             password: pass
    //         })
    //     })
    //     .then(response => {
    //         if (!response.ok) {
    //             return response.json();
    //         }
    //         let object = response.json().then((result) => result)
    //         console.log(object + 1)
    //         throw new Error(response.json().then((result) => result.body))
    //     })
    //     .then(data => {
    //         throw new Error(data.body);
    //         setToken(`Bearer ${data.body}`)
    //     })
    //     .catch(error => {
    //         console.log(error.message);
    //     })
}

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