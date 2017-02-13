package calculatorHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dynamic.IServlet;
import dynamic.PluginRouter;
import protocol.HttpRequest;
import protocol.Protocol;
import protocol.response.HttpResponseBuilder;
import protocol.response.IHttpResponse;
import calculatorPlugin.PluginLoader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Davis on 2/12/2017.
 */
public class CalculatorServlet implements IServlet {

    public CalculatorServlet() {
    }

    @Override
    public IHttpResponse handleDelete(HttpRequest request) {
        return build404Response();
    }

    @Override
    public IHttpResponse handleGet(HttpRequest request) {
        return build404Response();
    }

    @Override
    public IHttpResponse handleHead(HttpRequest request) {
        return build404Response();
    }

    @Override
    public IHttpResponse handlePost(HttpRequest request) {
        return build404Response();
    }

    @Override
    public IHttpResponse handlePut(HttpRequest request) {
        return build404Response();
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

    private IHttpResponse build404Response() {
        HttpResponseBuilder responseBuilder = new HttpResponseBuilder();
        responseBuilder.setStatus(Protocol.NOT_FOUND_CODE);
        responseBuilder.setPhrase(Protocol.NOT_FOUND_TEXT);
        responseBuilder.setHeaders(new HashMap<String, String>());
        responseBuilder.setConnection(Protocol.CLOSE);
        responseBuilder.setBody("File");
        return responseBuilder.build();
    }
}
