package id.dekz.code.retrofitexample;

import java.util.List;

import id.dekz.code.retrofitexample.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DEKZ on 3/2/2016.
 */
public interface RequestInterface {

    @GET("users?per_page=10")
    Call<List<User>> getJSON();
}
