package io.salmonllama.unifiapiwrapper.api;

import okhttp3.Response;

public interface UnifiApiResponse<T> {
    Response getResponse();
    // Abstracts away from the OkHttp response type.
    // includes reponse data in a neat format that can be parsed out internally via model classes

    String getCode();

    int getHttpStatus();

    String getMessage();

    String getTraceId();

    T getData();
}
