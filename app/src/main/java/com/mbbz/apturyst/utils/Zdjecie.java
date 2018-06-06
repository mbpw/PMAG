package com.mbbz.apturyst.utils;

/**
 * Klasa zdjęcia (rekordu w Bazie)
 */

public class Zdjecie {
    private String timestamp;
    private String imgFileName;
    private String desc;
    private Double latitude;
    private Double longitude;

    public Zdjecie() {}

    public Zdjecie(String timestamp, String imgFileName, String desc, Double latitude, Double longitude) {
        this.timestamp = timestamp;
        this.imgFileName = imgFileName;
        this.desc = desc;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getImgFileName() {
        return this.imgFileName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
