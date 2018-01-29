package com.example.arribasd.a18_sqliteserver.Activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.arribasd.a18_sqliteserver.R;

import java.util.HashMap;
import java.util.Map;

public class Registry extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener{

    EditText email, name, password;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

        registrar =(Button) findViewById(R.id.registrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest sr = new StringRequest(Request.Method.POST, "http://192.168.1.75/ejemplo/registro.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Registry", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Registry", error.getMessage());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("email", email.getText().toString());
                        params.put("name", name.getText().toString());
                        params.put("password", password.getText().toString());

                        return params;
                    }
                };
                Volley.newRequestQueue(getApplicationContext()).add(sr);
            }
        });

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onResponse(String response) {

    }
}
