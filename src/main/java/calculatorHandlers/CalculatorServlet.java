package calculatorHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dynamic.IServlet;
import protocol.HttpRequest;
import protocol.Protocol;
import protocol.response.HttpResponseBuilder;
import protocol.response.IHttpResponse;

import java.util.HashMap;

/**
 * Created by Davis on 2/12/2017.
 */
public class CalculatorServlet implements IServlet {

    public CalculatorServlet() {
    }


    public IHttpResponse calc(HttpRequest request) {
        if(request.getBody().length == 0) {
            return null;
        }

        String body = new String(request.getBody());

        Gson gson = new Gson();
        try {
            CalcRequest toCalc = gson.fromJson(body, CalcRequest.class);

            return build200Response(gson.toJson(new CalcResponse(toCalc.first + toCalc.second)));
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    @Override
    public IHttpResponse handleDelete(HttpRequest request) {
        return calc(request);
    }

    @Override
    public IHttpResponse handleGet(HttpRequest request) {
        return calc(request);
    }

    @Override
    public IHttpResponse handleHead(HttpRequest request) {
        return calc(request);
    }

    @Override
    public IHttpResponse handlePost(HttpRequest request) {
        return calc(request);
    }

    @Override
    public IHttpResponse handlePut(HttpRequest request) {
        return calc(request);
    }

    private IHttpResponse build200Response(String body) {
        HttpResponseBuilder responseBuilder = new HttpResponseBuilder();
        responseBuilder.setStatus(Protocol.OK_CODE);
        responseBuilder.setPhrase(Protocol.OK_TEXT);
        responseBuilder.setHeaders(new HashMap<String, String>());
        responseBuilder.setConnection(Protocol.CLOSE);
        responseBuilder.setBody(body);
        return responseBuilder.build();
    }
}
