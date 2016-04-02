package id.dekz.code.retrofitexample.model;

/**
 * Created by DEKZ on 4/2/2016.
 */
public class UserDetail {

    private String avatar_url,name,email,company,blog;

    public UserDetail() {
    }


    public UserDetail(String avatar_url, String name, String email, String company, String blog) {
        this.avatar_url = avatar_url;
        this.name = name;
        this.email = email;
        this.company = company;
        this.blog = blog;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
