type LoginPayload = {
    username: string;
    password: string;
};

type SignupPayload = {
    username: string;
    email: string;
    password: string;
    dateOfBirth: string;
};

export type { LoginPayload, SignupPayload };