package xyz.stankovic.lifxcontrol.util;

import com.google.gson.Gson;

/**
 * Created by stankovic on 26.11.2016.
 */
public class JSONUtil {

    public static String objectToJSON(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
