package io.salmonllama.unifiapiwrapper.core.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.salmonllama.unifiapiwrapper.api.UnifiApiResponse;
import io.salmonllama.unifiapiwrapper.core.UnifiApiResponseImpl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class UnifiRestController {
    public static <T> UnifiApiResponse<T> handleRequest(Request request, TypeToken<T> typeToken) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                if (response.body() == null) {
                    return null; // TODO: Failed result
                }

                Gson gson = new Gson();
                JSONObject jsonRaw = new JSONObject(response.body().string());
                T data = gson.fromJson(jsonRaw.get("data").toString(), typeToken);

                String code = null, message = null, traceId = null;
                int httpStatusCode = jsonRaw.getInt("httpStatusCode"); // There will *always* be a status code

                if (jsonRaw.has("code")) { code = jsonRaw.getString("code"); }
                if (jsonRaw.has("message")) { message = jsonRaw.getString("message"); }
                if (jsonRaw.has("traceId")) { traceId = jsonRaw.getString("traceId"); }

                // Build the UnifiAPIResponse with the data
                return new UnifiApiResponseImpl<>(
                        code,
                        httpStatusCode,
                        message,
                        traceId,
                        data
                );
            } else {
                // Return a failed result.
                return null;
            }
        }
    }
}
