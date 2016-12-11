package xyz.stankovic.lifxcontrol.api;

import ch.viascom.groundwork.foxhttp.FoxHttpClient;
import ch.viascom.groundwork.foxhttp.authorization.BearerTokenAuthorization;
import ch.viascom.groundwork.foxhttp.authorization.FoxHttpAuthorizationScope;
import ch.viascom.groundwork.foxhttp.body.request.RequestObjectBody;
import ch.viascom.groundwork.foxhttp.body.request.RequestStringBody;
import ch.viascom.groundwork.foxhttp.builder.FoxHttpRequestBuilder;
import ch.viascom.groundwork.foxhttp.parser.GsonParser;
import ch.viascom.groundwork.foxhttp.timeout.FoxHttpTimeoutStrategy;
import ch.viascom.groundwork.foxhttp.type.ContentType;
import ch.viascom.groundwork.foxhttp.type.RequestType;
import lombok.Getter;
import lombok.Setter;
import xyz.stankovic.lifxcontrol.models.SetState;

/**
 * Created by stankovic on 26.11.2016.
 */
@Getter
@Setter
public class LifxAPI {

    private final String appToken;
    private final String url;
    private final FoxHttpClient client;

    public LifxAPI(String appToken, String url){

        this.appToken = appToken;
        this.url = url;

        FoxHttpTimeoutStrategy timeoutStrategy = new FoxHttpTimeoutStrategy() {
            @Override
            public int getConnectionTimeout() {
                return 10_000;
            }

            @Override
            public int getReadTimeout() {
                return 300_000;
            }
        };

        client = new FoxHttpClient();
        client.getFoxHttpAuthorizationStrategy().addAuthorization(
                FoxHttpAuthorizationScope.ANY,
                new BearerTokenAuthorization(appToken)
        );
        client.setFoxHttpTimeoutStrategy(timeoutStrategy);
        client.setFoxHttpRequestParser(new GsonParser());

    }

    public void toggleLight(String selector, String duration) throws Exception {

        new FoxHttpRequestBuilder(url + "/" + selector + "/toggle", RequestType.POST, client)
                .setRequestBody(new RequestStringBody("{\"duration\":\"" + duration + "\"}", ContentType.DEFAULT_JSON))
                .setSkipResponseBody(false)
                .build()
                .execute();
    }

    public void toggleLight() throws Exception{
       toggleLight("all", "1");
    }

    public void setState(SetState setStateModel) throws Exception {

        new FoxHttpRequestBuilder(url + "/" + setStateModel.getSelector() + "/state", RequestType.PUT, client)
                .setRequestBody(new RequestObjectBody(setStateModel))
                .setSkipResponseBody(true)
                .build()
                .execute();
    }

    public void setDefaultState() throws Exception {
        setState(new SetState().setDefaults());
    }
}
