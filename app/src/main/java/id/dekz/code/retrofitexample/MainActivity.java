package id.dekz.code.retrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnToRecyclerViewAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToRecyclerViewAct = (Button) findViewById(R.id.btnRecyclerview);
        btnToRecyclerViewAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recyclerViewAct = new Intent(MainActivity.this,RecyclerViewAct.class);
                startActivity(recyclerViewAct);
            }
        });
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.moveTaskToBack(true);
    }
}
