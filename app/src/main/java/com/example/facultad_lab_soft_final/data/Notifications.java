package com.example.facultad_lab_soft_final.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Response;
import com.example.facultad_lab_soft_final.Helpers.API;
import com.example.facultad_lab_soft_final.Helpers.NotificationsSection;
import com.example.facultad_lab_soft_final.R;
import com.example.facultad_lab_soft_final.data.model.Notification;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class Notifications extends AppCompatActivity {

    RecyclerView recyclerView;
    SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        // Configura recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.notifications);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Realiza request de actividades
        API api = new API(this);

        sectionAdapter = new SectionedRecyclerViewAdapter();

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("YYYY/MM/dd");
        api.request("notificaciones", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                Notification[] notifications = gson.fromJson(response, Notification[].class);

                sectionAdapter.addSection(new NotificationsSection("General", new ArrayList<Notification>(Arrays.asList(notifications))));
                recyclerView.setAdapter(sectionAdapter);
            }
        });
    }
}
