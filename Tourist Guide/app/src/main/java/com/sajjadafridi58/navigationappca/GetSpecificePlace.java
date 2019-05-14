package com.sajjadafridi58.navigationappca;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GetSpecificePlace extends Activity  {

    public double mLatitude;
    public double mLongitude;
    GoogleMap mGoogleMap;
    MarkerOptions markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_k);

        try {
            if (mGoogleMap == null) {
                mGoogleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }

            MarkerOptions markerOptions = new MarkerOptions();
            // Enabling MyLocation in Google Map
            mGoogleMap.setMyLocationEnabled(true);

            ////////////////////////////////////////////
            LatLng latLng = new LatLng(35.880192, 76.815087);

            // Setting the position for the marker
            markerOptions.position(latLng);

            markerOptions.title("K-2");

            mGoogleMap.addMarker(markerOptions);
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
            /////////////////////////////////////////
            mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            Marker TP = mGoogleMap.addMarker(new MarkerOptions().
                    position(latLng).title("K-2"));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
