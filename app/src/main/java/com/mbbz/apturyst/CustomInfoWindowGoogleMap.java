package com.mbbz.apturyst;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.storage.StorageReference;
import com.mbbz.apturyst.utils.Zdjecie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


/*
 * Customowy "dymek" zawierający miniaturkę zdjęcia
 */

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private View popup=null;
    private LayoutInflater inflater=null;

    private Context context;
    private StorageReference storageReference;
    private Marker lastMarker=null;

    public CustomInfoWindowGoogleMap(Context ctx, LayoutInflater inflater, StorageReference sr){
        context = ctx;
        this.inflater = inflater;
        storageReference = sr;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(final Marker marker) {
        if (popup == null) {
            popup=inflater.inflate(R.layout.custom_info_window, null);
        }


        if (lastMarker == null
                || !lastMarker.getId().equals(marker.getId())) {
            lastMarker = marker;

            final TextView desc = popup.findViewById(R.id.desc);
            final TextView date = popup.findViewById(R.id.date);
            final ImageView img = popup.findViewById(R.id.pic);

            final Zdjecie infoWindowData = (Zdjecie) marker.getTag();

            if (infoWindowData != null) {
                desc.setText(infoWindowData.getDesc());
                String dateTxt = "Dodano: " + infoWindowData.getTimestamp();
                date.setText(dateTxt);
                String filename = infoWindowData.getImgFileName();

                StorageReference islandRef = storageReference.child("images/" + filename);
                Log.d("IMG", islandRef.toString());

                Uri uri = infoWindowData.getPublicImageURI();
                if (uri == null) {
                    img.setVisibility(View.GONE);
                }

                Picasso.with(context).load(uri).noFade().placeholder(R.drawable.placeholder)
                        .into(img, new MarkerCallback(marker));

            }
        }
        return popup;
    }

    static class MarkerCallback implements Callback {
        Marker marker=null;

        MarkerCallback(Marker marker) {
            this.marker=marker;
        }

        @Override
        public void onError() {
            Log.e(getClass().getSimpleName(), "Error loading thumbnail!");
        }

        @Override
        public void onSuccess() {
            if (marker != null && marker.isInfoWindowShown()) {
                marker.showInfoWindow();
            }
        }
    }
}