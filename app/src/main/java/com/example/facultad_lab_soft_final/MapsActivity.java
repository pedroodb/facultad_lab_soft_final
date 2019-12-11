package com.example.facultad_lab_soft_final;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.facultad_lab_soft_final.data.model.Actividad;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Carga los marcadores de las obras
        ArrayList<Actividad> actividades = (ArrayList<Actividad>) getIntent().getSerializableExtra("actividades");
        for (Actividad actividad : actividades) {
            LatLng marker = new LatLng(actividad.getUbicacion().getLatitud(), actividad.getUbicacion().getLongitud());
            mMap.addMarker(new MarkerOptions().position(marker).title(actividad.getNombre()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(actividades.get(0).getUbicacion().getLatitud(),actividades.get(0).getUbicacion().getLongitud()),13));
    }
}
