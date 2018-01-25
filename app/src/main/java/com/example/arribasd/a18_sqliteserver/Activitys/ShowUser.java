package com.example.arribasd.a18_sqliteserver.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.arribasd.a18_sqliteserver.ClassUser.Usuario;
import com.example.arribasd.a18_sqliteserver.R;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class ShowUser extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener{

    EditText passwordInput;
    TextView email,name,password;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        email = findViewById(R.id.emailShow);
        name = findViewById(R.id.nameShow);
        password = findViewById(R.id.passwordShow);

        passwordInput = findViewById(R.id.passwordInsertShow);

        show = findViewById(R.id.showBTN);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest sr = new StringRequest(Request.Method.POST, "http://192.168.1.75/ejemplo/select.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ShowUser.this, response, Toast.LENGTH_LONG).show();

                        Usuario usuario = new Usuario();

                        JSONArray jsonArray = response.optJSONArray("");

                        Log.d("show", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("show", error.getMessage());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("id", passwordInput.getText().toString());
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
    public void onResponse(String response) {

    }
}
