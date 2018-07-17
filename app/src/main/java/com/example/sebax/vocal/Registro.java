package com.example.sebax.vocal;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText EditextNombre, EditextRut;
    Button BTNregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditextNombre = findViewById(R.id.EditextNombre);
        EditextRut = findViewById(R.id.Editextrut);

        BTNregistrar = findViewById(R.id.BTNregistrar);

        BTNregistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final String Nombre = EditextNombre.getText().toString();
        final  String Rut = EditextRut.getText().toString();

        Response.Listener<String> responListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Boolean success = jsonObject.getBoolean("success");
                    if (success){
                        Intent intent = new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Intentar otra vez").setNegativeButton("Retry",null).create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        RegisterRequest  regiRequest = new RegisterRequest(Nombre,Rut,responListener);
        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(regiRequest);
    }
}
