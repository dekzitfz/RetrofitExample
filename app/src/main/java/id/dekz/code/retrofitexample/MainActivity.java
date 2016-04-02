package id.dekz.code.retrofitexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.dekz.code.retrofitexample.act.RecyclerViewAct;
import id.dekz.code.retrofitexample.act.UserDetailAct;

public class MainActivity extends AppCompatActivity {

    private Button btnToRecyclerViewAct,btnUserDetail;

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

        btnUserDetail = (Button) findViewById(R.id.btnUserDetail);
        btnUserDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUserDialog();
            }
        });
    }

    private void inputUserDialog(){
        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.dialog_input_user, null, false);
        AlertDialog.Builder inputBuilder = new AlertDialog.Builder(MainActivity.this);
        inputBuilder.setView(promptsView);

        final EditText etUsername = (EditText) promptsView.findViewById(R.id.etUsername);

        inputBuilder.setCancelable(true)
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("SEARCH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "searching "+etUsername.getText().toString(),
                                Toast.LENGTH_SHORT).show();;
                        Intent detail = new Intent(MainActivity.this, UserDetailAct.class);
                        detail.putExtra("username",etUsername.getText().toString());
                        startActivity(detail);
                    }
                });
        inputBuilder.show();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.moveTaskToBack(true);
    }
}
