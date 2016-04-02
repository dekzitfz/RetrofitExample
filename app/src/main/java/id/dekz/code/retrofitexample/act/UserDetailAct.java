package id.dekz.code.retrofitexample.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import id.dekz.code.retrofitexample.R;
import id.dekz.code.retrofitexample.intf.RequestInterface;
import id.dekz.code.retrofitexample.model.UserDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DEKZ on 4/2/2016.
 */
public class UserDetailAct extends AppCompatActivity {

    @Bind(R.id.imgUser)ImageView imgUser;
    @Bind(R.id.tvFullNameUser)TextView tvFullNameUser;
    @Bind(R.id.tvCompanyUser)TextView tvCompanyUser;
    @Bind(R.id.tvBlogUser)TextView tvBlogUser;
    @Bind(R.id.tvEmailUser)TextView tvEmailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        Intent user = getIntent();
        String username = user.getStringExtra("username");
        getUser(username);
    }

    private void getUser(String username){
        String BASE_URL = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface req = retrofit.create(RequestInterface.class);
        Call<UserDetail> userDetailCall = req.getUser(username);
        userDetailCall.enqueue(new Callback<UserDetail>() {
            @Override
            public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                if(response.headers().get("status").equals("200 OK")){
                    UserDetail userDetail = response.body();
                    Picasso.with(getApplicationContext())
                            .load(userDetail.getAvatar_url())
                            .into(imgUser);
                    tvFullNameUser.setText(userDetail.getName());
                    tvBlogUser.setText(userDetail.getBlog());
                    tvCompanyUser.setText(userDetail.getCompany());
                    tvEmailUser.setText(userDetail.getEmail());
                }else{
                    Toast.makeText(getApplicationContext(),"username not found!",Toast.LENGTH_LONG).show();
                    UserDetailAct.this.finish();
                }
            }

            @Override
            public void onFailure(Call<UserDetail> call, Throwable t) {
                Toast.makeText(UserDetailAct.this,t.getMessage(),Toast.LENGTH_LONG).show();
                Log.d("error",t.getMessage());
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        UserDetailAct.this.finish();
    }
}
