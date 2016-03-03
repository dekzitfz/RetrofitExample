package id.dekz.code.retrofitexample.model;

/**
 * Created by DEKZ on 3/2/2016.
 */
public class User {

    private String login,avatar_url;

    public User() {
    }

    public User(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
