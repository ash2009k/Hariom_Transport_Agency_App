package com.hot.ashwini.hariomtransport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */

public class contact extends Fragment implements OnMapReadyCallback {


    GoogleMap map;

    public contact() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_contact, container, false);
        SupportMapFragment mapFragment=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng pp = new LatLng(25.1931,85.5054);
        MarkerOptions option=new MarkerOptions();
        option.position(pp).title("Hari Om Transport Agency").snippet("Here you go!");
        map.addMarker(option);
        CameraPosition hari= CameraPosition.builder().target(pp).zoom(17).tilt(45).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(hari));

    }
}
