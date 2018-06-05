package com.mbbz.apturyst.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.mbbz.apturyst.MapsActivity;

/**
 * Singleton klienta geolokalizacji
 */



public class MyLocationProvider {

    static MyLocationProvider instance;
    private FusedLocationProviderClient mFusedLocationClient;
    Location lastLocation;

    @SuppressLint("MissingPermission")
    private MyLocationProvider(Context ctx) {
        @SuppressLint("RestrictedApi") LocationRequest request = new LocationRequest();
        request.setInterval(5000);
        request.setFastestInterval(1000);
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(ctx);
        LocationCallback callback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {
                    updateLocation(location);
                }
            }
        };
        mFusedLocationClient.requestLocationUpdates(request, callback, null);
    }

    public static MyLocationProvider getInstance(Context context) {
        if (instance == null)
            return new MyLocationProvider(context);
        else
            return instance;
    }

    private void updateLocation(Location location) {
        // Logic to handle location object
        String latVal = Double.toString(location.getLatitude());
        String lonVal = Double.toString(location.getLongitude());

        String timestamp = Double.toString(location.getTime());

        lastLocation = new Location(location);
        Log.d("LOKACJA", "[" + timestamp + "] Location: " + latVal + ", " + lonVal);

    }

    public Location getLastLocation() {
        if (lastLocation != null)
            return lastLocation;
        else
            return null;
    }

}
