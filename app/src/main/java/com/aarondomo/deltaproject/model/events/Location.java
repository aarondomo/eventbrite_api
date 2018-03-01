
package com.aarondomo.deltaproject.model.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("augmented_location")
    @Expose
    private AugmentedLocation augmentedLocation;
    @SerializedName("within")
    @Expose
    private String within;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("address")
    @Expose
    private String address;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public AugmentedLocation getAugmentedLocation() {
        return augmentedLocation;
    }

    public void setAugmentedLocation(AugmentedLocation augmentedLocation) {
        this.augmentedLocation = augmentedLocation;
    }

    public String getWithin() {
        return within;
    }

    public void setWithin(String within) {
        this.within = within;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
