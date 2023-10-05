package user.models;

public class LoginUserRequest {
    private String email;
    private String password;

    public LoginUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUserRequest() {
    }

    public String getEmail() {
        return email;
    }

    public LoginUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUserRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
