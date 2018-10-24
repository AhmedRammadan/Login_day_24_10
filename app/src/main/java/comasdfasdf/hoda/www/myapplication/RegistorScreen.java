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
import android.widget.Toast;

public class RegistorScreen extends AppCompatActivity {
    EditText etusername,etpassword;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor_screen);
        etusername = findViewById(R.id.reName);
        etpassword = findViewById(R.id.rePassword);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle(R.string.register);

    }

    public void register(View view) {
        username   = etusername.getText().toString();
        password   = etpassword.getText().toString();
        if (!username.equals("") && !password.equals("")) {
            SharedPreferences.Editor editor = getSharedPreferences("MyLogin", MODE_PRIVATE).edit();
            editor.putString("name", username);
            editor.putString("password", password);
            editor.apply();
            startActivity(new Intent(RegistorScreen.this, MainScreen.class));
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
        }else if (username.equals("")){
            AlertDialog("User Name");
        }else if (password.equals("")){
            AlertDialog("password");
        }

    }
    public  void  AlertDialog(String error){
       new AlertDialog.Builder(RegistorScreen.this)
               .setTitle("Error").setMessage("Pleas Enter "+error)
               .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                    return;
                   }
               }).show();

    }
}
