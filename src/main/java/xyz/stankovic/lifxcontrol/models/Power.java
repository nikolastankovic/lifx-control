package xyz.stankovic.lifxcontrol.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stankovic on 26.11.2016.
 */
public enum Power {
    @SerializedName("on")
    ON,
    @SerializedName("off")
    OFF;
}
