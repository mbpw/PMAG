package com.mbbz.apturyst;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.storage.StorageReference;
import com.mbbz.apturyst.utils.Zdjecie;

/*
 * Customowy "dymek" zawierający miniaturkę zdjęcia
 */

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;
    private StorageReference storageReference;

    public CustomInfoWindowGoogleMap(Context ctx, StorageReference sr){
        context = ctx;
        storageReference = sr;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.custom_info_window, null);

        TextView desc = view.findViewById(R.id.desc);
        TextView date = view.findViewById(R.id.date);
        ImageView img = view.findViewById(R.id.pic);
        
        Zdjecie infoWindowData = (Zdjecie) marker.getTag();

        if (infoWindowData != null) {
            desc.setText(infoWindowData.getDesc());
            String dateTxt = "Dodano: " + infoWindowData.getTimestamp();
            date.setText(dateTxt);
            String filename = infoWindowData.getImgFileName();
        }
//        int imageId = context.getResources().getIdentifier(infoWindowData.getImgFileName(),
//                "drawable", context.getPackagedesc());
//        img.setImageResource(imageId);

        return view;
    }
}