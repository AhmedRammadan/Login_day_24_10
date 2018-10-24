package comasdfasdf.hoda.www.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  Ahmed Ramadan
 */
public class MainActivity extends AppCompatActivity {

    String lgname,lgpassword;
    EditText etusername,etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername = findViewById(R.id.lgName);
        etpassword = findViewById(R.id.lgPassword);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle(R.string.login);
    }


    public void Creataccount(View view) {
        startActivity(new Intent(MainActivity.this,RegistorScreen.class));
    }

    public void login(View view) {
        lgname = etusername.getText().toString();
        lgpassword = etpassword.getText().toString();
        SharedPreferences preferences =getSharedPreferences("MyLogin", MODE_PRIVATE);

        String name=preferences.getString("name","name");
        String password=preferences.getString("password","name");

        if (lgname.equals(name) && lgpassword.equals(password)) {
            startActivity(new Intent(MainActivity.this, MainScreen.class));
        }else if (!lgname.equals(name) && !lgpassword.equals(password)){
           AlertDialog("Your"+"username"+"password" +"is not correct");
        }else if (!lgname.equals(name)){
            AlertDialog("Your"+"user Name is not correct");
        }
        else if (!lgpassword.equals(password)){
            AlertDialog("Your password" +"is not correct");
        }
    }
    public  void  AlertDialog(String error){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Error").setMessage("Pleas Enter "+error)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                }).show();

    }
}
