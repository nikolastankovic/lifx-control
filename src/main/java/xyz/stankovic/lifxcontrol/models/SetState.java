package xyz.stankovic.lifxcontrol.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by stankovic on 26.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetState implements Serializable {
    private String selector;
    private String duration;
    private String brightness;
    private String color;
    private Power power;

    public SetState setDefaults() {
        this.selector = "all";
        this.duration = "1";
        this.brightness = "1.0";
        setColor(Color.WHITE);
        this.power = Power.ON;

        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color.toString().toLowerCase();
    }

    public void setColorAsRGB(int red, int green, int blue) {
        this.color = "rgb:" + red + "," + green + "," + blue;
    }

    public void setColorAsKelvin(int kelvin) {
        this.color = "kelvin:" + kelvin;
    }

    public void setColorAsKelvin(int kelvin, double saturation) {
        this.color = "kelvin:" + kelvin + " saturation:" + saturation;
    }
}
