package xyz.stankovic.lifxcontrol.request;

import ch.viascom.groundwork.restclient.http.request.PutRequest;
import ch.viascom.groundwork.restclient.response.NoContentResponse;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import xyz.stankovic.lifxcontrol.request.models.SetState;
import xyz.stankovic.lifxcontrol.util.JSONUtil;

/**
 * Created by stankovic on 26.11.2016.
 */
public class SetStateRequest extends PutRequest<NoContentResponse> {

    public SetStateRequest(String url, HttpClient httpClient, String appToken) {
        this(new SetState().setDefaults(), url, httpClient, appToken);
    }

    public SetStateRequest(SetState setStateModel, String url, HttpClient httpClient, String appToken) {
        super(url, httpClient);

        setPath("/" + setStateModel.getSelector() + "/state");
        addHeaders("Authorization", "Bearer " + appToken);

        setRequestBody(new StringEntity(JSONUtil.objectToJSON(setStateModel), Consts.UTF_8));
    }
}
