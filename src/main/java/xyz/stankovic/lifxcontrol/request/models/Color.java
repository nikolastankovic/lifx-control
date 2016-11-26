package xyz.stankovic.lifxcontrol.request.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stankovic on 26.11.2016.
 */
public enum Color {
    @SerializedName("white")
    WHITE,
    @SerializedName("red")
    RED,
    @SerializedName("orange")
    ORANGE,
    @SerializedName("yellow")
    YELLOW,
    @SerializedName("cyan")
    CYAN,
    @SerializedName("green")
    GREEN,
    @SerializedName("blue")
    BLUE,
    @SerializedName("purple")
    PURPLE,
    @SerializedName("pink")
    PINK;
}
