package model.entity;

public class UserAccountEnti {
    private String name;
    private String username;
    private String password;
    private String email;

    public UserAccountEnti() {

    }

    public UserAccountEnti(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public UserAccountEnti setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserAccountEnti setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccountEnti setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserAccountEnti setEmail(String email) {
        this.email = email;
        return this;
    }
}
