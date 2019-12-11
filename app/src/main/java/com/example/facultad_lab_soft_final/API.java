package com.example.facultad_lab_soft_final;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class API {

    String url ="http://www.amock.io/api/labo/actividades";
    Activity activity;
    RequestQueue queue;

    public API(Activity activity) {
        this.activity = activity;

        // Instantiate the RequestQueue.
        this.queue = Volley.newRequestQueue(activity);
    }

    public void consulta() {
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    Toast.makeText(activity,response,Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.getMessage());
                    Toast.makeText(activity,error.getMessage(),Toast.LENGTH_SHORT).show();
                }
        });

        // Add the request to the RequestQueue.
        this.queue.add(stringRequest);
    }

}
