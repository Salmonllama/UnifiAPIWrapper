package io.salmonllama.unifiapiwrapper.core;

import com.google.gson.reflect.TypeToken;
import io.salmonllama.unifiapiwrapper.api.UnifiApiResponse;
import io.salmonllama.unifiapiwrapper.core.controllers.UnifiRestController;
import okhttp3.Request;

import java.io.IOException;

class UnifiApiRequest {
    private final String REQUEST_URL = "https://api.ui.com";

    private String uriPath;
    private String apiKey;
    private String method;

    public UnifiApiRequest() {
    }

    public UnifiApiRequest get() {
        this.method = "GET";
        return this;
    }

    public UnifiApiRequest apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public UnifiApiRequest uriPath(String path) {
        this.uriPath = path;
        return this;
    }

    public <T> UnifiApiResponse<T> send(TypeToken<T> typeToken) throws IOException, NullPointerException {
        // The request is built and executed here.
        Request request = new Request.Builder()
                .url(REQUEST_URL + uriPath)
                .method(method, null)
                .addHeader("X-API-KEY", apiKey)
                .build();

        return UnifiRestController.handleRequest(request, typeToken);
    }
}
