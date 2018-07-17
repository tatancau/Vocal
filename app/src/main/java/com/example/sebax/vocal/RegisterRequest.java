package com.example.sebax.vocal;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebax on 16-07-2018.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://192.168.0.100/Registro.php";
    private Map<String,String> params;
    public RegisterRequest(String Nombre, String Rut, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params=new HashMap<>();
        params.put("Nombre",Nombre);
        params.put("Rut",Rut);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
