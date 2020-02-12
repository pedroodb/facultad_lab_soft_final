package com.example.facultad_lab_soft_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.facultad_lab_soft_final.Helpers.API;
import com.example.facultad_lab_soft_final.Helpers.ActivitiesSection;
import com.example.facultad_lab_soft_final.data.model.Actividad;
import com.example.facultad_lab_soft_final.data.model.Actividades;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    Actividades actividades = null;

    RecyclerView recyclerView;
    SectionedRecyclerViewAdapter sectionAdapter;

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Solicita la info del usuario si esta logeado
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(this,"Que haces " + user.getEmail(),Toast.LENGTH_SHORT).show();
        }

        // Configura recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.activities);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sectionAdapter = new SectionedRecyclerViewAdapter();

        // Realiza request de actividades
        API api = new API(this);
        api.request("actividades", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                actividades = gson.fromJson(response,Actividades.class);

                for (Map.Entry<Date, ArrayList<Actividad>> entry : actividades.listadoPorFechas().entrySet()) {

                    ArrayList<Actividad> actividades = entry.getValue();
                    Collections.sort(actividades);

                    sectionAdapter.addSection(new ActivitiesSection(new SimpleDateFormat("dd/MM/yyyy").format(entry.getKey()), actividades));
                }
                recyclerView.setAdapter(sectionAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_item:   //this item has your app icon
                Toast.makeText(this,"Tapped on icon",Toast.LENGTH_SHORT).show();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void toMap(View view) {
        if(actividades != null) {
            Intent intent = new Intent(this, OSMapsActivity.class);
            intent.putExtra("actividades",actividades.getActividades());
            startActivity(intent);
        }
    }

    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openNotifications(MenuItem item) {
        Intent intent = new Intent(this, Notifications.class);
        startActivity(intent);
    }
}
