package xyz.stankovic.lifxcontrol;

import ch.viascom.groundwork.restclient.exception.RESTClientException;

import java.io.IOException;

/**
 * Created by stankovic on 26.11.2016.
 */
public class Main {

    public static void main(String[] args) throws RESTClientException, IOException {
        new Fader().start(30);
    }
}
