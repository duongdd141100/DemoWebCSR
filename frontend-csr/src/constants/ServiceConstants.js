const serverIp = "127.0.0.1";
const port = "8082";
const baseServer = `http://${serverIp}:${port}`;

export const getHeader = `${baseServer}/api/v1/entries/header`;

export const signIn = `${baseServer}/api/v1/auth/sign-in`;