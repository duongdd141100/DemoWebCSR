const serverIp = "127.0.0.1";
const port = "8082";
const baseServer = `http://${serverIp}:${port}`;

export const getHeaderApi = `${baseServer}/api/v1/entries/header`;

export const signInApi = `${baseServer}/api/v1/auth/sign-in`;