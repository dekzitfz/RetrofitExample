package id.dekz.code.retrofitexample.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.dekz.code.retrofitexample.R;
import id.dekz.code.retrofitexample.adapter.RecyclerViewAdapter;
import id.dekz.code.retrofitexample.intf.OnItemClickListener;
import id.dekz.code.retrofitexample.intf.RequestInterface;
import id.dekz.code.retrofitexample.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DEKZ on 3/2/2016.
 */
public class RecyclerViewAct extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerView;
    private List<User> users;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        getSupportActionBar().setTitle("GitHub Users");
        getSupportActionBar().setSubtitle("Retrofit with GSON + Picasso");

        initialize();
    }

    private void initialize() {
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<User>> call = requestInterface.getJSON();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = new ArrayList<User>();
                users.clear();
                users = response.body();

                ArrayList<User> listUser = new ArrayList<User>();
                for (int i=0; i<users.size(); i++){
                    listUser.add(users.get(i));
                }

                recyclerViewAdapter = new RecyclerViewAdapter(listUser,getApplicationContext());
                recyclerViewAdapter.setClickListener(RecyclerViewAct.this);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("error ----> ", t.getMessage());
            }
        });

    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        RecyclerViewAct.this.finish();
    }

    @Override
    public void onItemCLick(View view, int position) {
        Toast.makeText(getApplicationContext(),""+users.get(position).getLogin(),Toast.LENGTH_SHORT).show();
    }
}
