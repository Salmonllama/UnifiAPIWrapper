package io.salmonllama.unifiapiwrapper.core;

import io.salmonllama.unifiapiwrapper.api.UnifiApiResponse;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

public final class UnifiApiResponseImpl<T> implements UnifiApiResponse<T> {
    @Nullable
    private final String code;
    private final int httpStatus;
    @Nullable
    private final String message;
    @Nullable
    private final String traceId;
    @Nullable
    private final T data;

    public UnifiApiResponseImpl(
            @Nullable String code,
            int httpStatus,
            @Nullable String message,
            @Nullable String traceId,
            @Nullable T data
            ) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.traceId = traceId;
        this.data = data;
    }

    @Override
    public Response getResponse() {
        return null;
    }

    @Nullable
    public String getCode() {
        return code;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    @Nullable
    public String getTraceId() {
        return traceId;
    }

    @Nullable
    public T getData() {
        return data;
    }
}
