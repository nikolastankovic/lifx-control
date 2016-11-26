package xyz.stankovic.lifxcontrol.request;

import ch.viascom.groundwork.restclient.http.request.PostRequest;
import ch.viascom.groundwork.restclient.response.NoContentResponse;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

/**
 * Created by stankovic on 26.11.2016.
 */
public class ToggleLightRequest extends PostRequest<NoContentResponse> {

    private static final String selector = "all";
    private static final String duration = "1";

    public ToggleLightRequest(String url, HttpClient httpClient, String appToken) {
        this(selector, duration, url, httpClient, appToken);
    }

    public ToggleLightRequest(String selector, String duration, String url, HttpClient httpClient, String appToken) {
        super(url, httpClient);

        setPath("/" + selector + "/toggle");
        addHeaders("Authorization", "Bearer " + appToken);
        setRequestBody(new StringEntity("{\"duration\":\"" + duration + "\"}", Consts.UTF_8));
    }

}
