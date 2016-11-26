package xyz.stankovic.lifxcontrol.api;

import ch.viascom.groundwork.restclient.exception.RESTClientException;
import ch.viascom.groundwork.restclient.response.NoContentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.HttpClient;
import xyz.stankovic.lifxcontrol.request.SetStateRequest;
import xyz.stankovic.lifxcontrol.request.ToggleLightRequest;
import xyz.stankovic.lifxcontrol.request.models.SetState;

/**
 * Created by stankovic on 26.11.2016.
 */
@Getter
@Setter
@AllArgsConstructor
public class LifxAPI {
    private String APP_TOKEN;
    private String URL;
    private HttpClient httpClient;

    public NoContentResponse toggleLight(String selector, String duration) throws RESTClientException {

        ToggleLightRequest toggleLightRequest = new ToggleLightRequest(selector, duration, URL, httpClient, APP_TOKEN);
        return toggleLightRequest.execute();
    }

    public NoContentResponse toggleLight() throws RESTClientException {

        ToggleLightRequest toggleLightRequest = new ToggleLightRequest(URL, httpClient, APP_TOKEN);
        return toggleLightRequest.execute();
    }

    public NoContentResponse setState(SetState setStateModel) throws RESTClientException {

        SetStateRequest setStateRequest = new SetStateRequest(setStateModel, URL, httpClient, APP_TOKEN);
        return setStateRequest.execute();
    }

    public NoContentResponse setDefaultState() throws RESTClientException {

        SetStateRequest setStateRequest = new SetStateRequest(URL, httpClient, APP_TOKEN);
        return setStateRequest.execute();
    }
}
