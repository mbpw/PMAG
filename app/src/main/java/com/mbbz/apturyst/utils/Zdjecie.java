package com.mbbz.apturyst.utils;

/**
 * Created by Mateusz on 06.06.2018.
 */

public class Zdjecie {
    public String timestamp;
    public String imgFileName;
    public Double latitude;
    public Double longitude;


    public Zdjecie(String timestamp, String imgFileName, Double latitude, Double longitude) {
        this.timestamp = timestamp;
        this.imgFileName = imgFileName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
