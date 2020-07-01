package com.hot.ashwini.hariomtransport;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class show_info extends Fragment implements OnMapReadyCallback {
    GoogleMap map;


    public show_info() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_show_info, container, false);
        SupportMapFragment mapFragment=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapView_info);
        mapFragment.getMapAsync(this);
        String head=MainActivity.getHead();
        String address=MainActivity.getAddress();
        String mob=MainActivity.getMob();
        TextView tv1=(TextView)v.findViewById(R.id.head);
        TextView tv2=(TextView)v.findViewById(R.id.textView4);
        TextView tv3=(TextView)v.findViewById(R.id.textView7);
        tv1.setText(head);
        tv2.setText(address);
        tv3.setText(mob);



        return v;
    }


    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng pp = MainActivity.getLatLng();
        MarkerOptions option=new MarkerOptions();
        option.position(pp).title("Hari Om Transport Agency").snippet("Here you go!");
        map.addMarker(option);
        CameraPosition hari= CameraPosition.builder().target(pp).zoom(17).tilt(45).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(hari));

    }

}
