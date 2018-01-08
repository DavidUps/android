package com.example.arribasd.pasardatosentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        final EditText name = (EditText) findViewById(R.id.addName);
        final EditText surname = (EditText) findViewById(R.id.addSurname);
        final EditText email = (EditText) findViewById(R.id.addEmail);
        final EditText telephone = (EditText) findViewById(R.id.addTelephone);
        Button save = (Button) findViewById(R.id.addButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("name",name.getText().toString());
                data.putExtra("surname", surname.getText().toString());
                data.putExtra("email", email.getText().toString());
                data.putExtra("telephone", telephone.getText().toString());
                setResult(Activity.RESULT_OK,data);
                finish();
            }
        });
    }
}
