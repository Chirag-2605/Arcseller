import AuthLayout from "../../features/auth/components/AuthLayout/AuthLayout";
import SignupForm from "../../features/auth/components/SignupForm";

const Signup: React.FC = () => {
    return (
        <AuthLayout title="Signup">
            <SignupForm />
        </AuthLayout>
    )
}

export default Signup
