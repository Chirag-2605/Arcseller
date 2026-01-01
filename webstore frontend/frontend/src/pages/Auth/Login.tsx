import AuthLayout from "../../features/auth/components/AuthLayout/AuthLayout";
import LoginForm from "../../features/auth/components/LoginForm";

const Login = () => {
    return (
        <AuthLayout title="Login">
            <LoginForm />
        </AuthLayout>
    )
}

export default Login