package id.dekz.code.retrofitexample.util;

import java.util.List;

import id.dekz.code.retrofitexample.model.User;

/**
 * Created by DEKZ on 3/2/2016.
 */
public class JSONResponse {

    /*
    private User[] user;

    public User[] getUser(){
        return user;
    }
    */

    private List<User> users;

    public List<User> getUsers(){
        return users;
    }
}
