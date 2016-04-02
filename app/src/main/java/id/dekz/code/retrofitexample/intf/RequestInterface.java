package id.dekz.code.retrofitexample.intf;

import java.util.List;

import id.dekz.code.retrofitexample.model.User;
import id.dekz.code.retrofitexample.model.UserDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DEKZ on 3/2/2016.
 */
public interface RequestInterface {

    @GET("users?per_page=10")
    Call<List<User>> getJSON();

    @GET("users/{username}")
    Call<UserDetail> getUser(@Path("username") String username);
}
