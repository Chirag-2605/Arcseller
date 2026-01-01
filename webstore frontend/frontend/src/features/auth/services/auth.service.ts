import type {LoginPayload, SignupPayload} from "../types";
import { api } from "../../../services/api";

const handleLogin = async (payload: LoginPayload) => {
    const response = await api("/users/login", {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(payload),
    });
    return response;
}

const handleSignup = async (payload: SignupPayload) => {
    const response = await api("/users/signup", {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(payload),
    });
    return response;
}


export {handleLogin, handleSignup};