package com.aarondomo.deltaproject.remote;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import io.reactivex.Observable;


public class LastLocationProvider {

    private Context context;

    private Location location;

    private FusedLocationProviderClient fusedLocationProviderClient;

    private static final String TAG = LastLocationProvider.class.getName();

    public LastLocationProvider(Context context) {
        this.context = context;
        retrieveLocation();
    }

    public Location getLocation() {
        if(location == null){
            retrieveLocation();
        }
        return location;
    }

    private void retrieveLocation() {

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                setLocation(location);
                                Log.d(TAG, "latitude: " + location.getLatitude());
                                Log.d(TAG, "longitude: " + location.getLongitude());
                            } else {
                                Log.d(TAG, "no location retrieved");
                            }
                        }
                    });
        }

    }

    private void setLocation(Location location) {
        this.location = location;
    }
}
