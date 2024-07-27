package Model;


public class LoginContext {
    private String username;
    private String password;

    public LoginContext(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void getCredentials(String username, String password) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginContext [username=" + username + ", password=" + password + "]";
    }

    public boolean isEmpty() {
        return (username == null || username.isEmpty()) && (password == null || password.isEmpty());
    }

}

