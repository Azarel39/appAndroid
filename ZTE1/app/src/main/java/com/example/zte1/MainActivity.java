package com.example.zte1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView1=(TextView)findViewById(R.id.textwiew1);
        RequestQueue queue = Volley.newRequestQueue(this);

        //String URL ="http://192.168.1.105/pruebavolley/consultarUsuario.php?cc=12345";

        String URL ="http://villafuertee.com/myEsp32/controller/app.php?cc=cc";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                textView1.setText("HOLA AZA LOS RESULADOS QUE OBTUVE SON:"+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

                textView1.setText("Aza no se pudo realizar la conexion");
            }
        });
        queue.add(stringRequest);
    }
}