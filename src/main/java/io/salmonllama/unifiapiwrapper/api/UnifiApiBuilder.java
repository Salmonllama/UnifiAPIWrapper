package io.salmonllama.unifiapiwrapper.api;

import io.salmonllama.unifiapiwrapper.core.UnifiApiImpl;

public class UnifiApiBuilder {
    private String apiKey;

    public UnifiApiBuilder() {}

    public UnifiApiBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public UnifiApi build() throws Exception {
        if (this.apiKey == null || this.apiKey.isEmpty()) {
            throw new Exception("API Key cannot be null");
        }
        return new UnifiApiImpl(apiKey);
    }
}
