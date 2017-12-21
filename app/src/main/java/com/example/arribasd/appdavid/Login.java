package com.example.arribasd.appdavid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

    public void onClickLogin(View view){

        EditText user = (EditText) findViewById(R.id.userEditText);
        EditText password = (EditText) findViewById(R.id.passwordEditText);

        if(user.getText().toString().equals("david") && password.getText().toString().equals("1234")){
            Intent mainIntent = new Intent(this,Main.class);
            startActivity(mainIntent);
        }else{
            Toast.makeText(view.getContext(),"Login o contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}
