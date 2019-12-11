package com.example.facultad_lab_soft_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.facultad_lab_soft_final.data.model.Actividades;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Actividades actividades = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        API api = new API(this);
        api.request("actividades", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                Gson gson = new Gson();
                actividades = gson.fromJson(response,Actividades.class);
                Toast.makeText(MainActivity.this,actividades.getGenerales().get(0).getDescripcion(),Toast.LENGTH_SHORT).show();
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

    public void goToMap(View view) {
        if(actividades != null) {
            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("actividades",actividades.getActividades());
            startActivity(intent);
        }
    }
}
