package io.salmonllama.unifiapiwrapper.core;

import com.google.gson.reflect.TypeToken;
import io.salmonllama.unifiapiwrapper.api.UnifiApi;
import io.salmonllama.unifiapiwrapper.api.UnifiApiResponse;
import io.salmonllama.unifiapiwrapper.core.internal.UnifiApiPath;
import io.salmonllama.unifiapiwrapper.api.models.Device;
import io.salmonllama.unifiapiwrapper.api.models.Host;
import io.salmonllama.unifiapiwrapper.api.models.Site;

import java.io.IOException;
import java.util.Collection;

public class UnifiApiImpl implements UnifiApi {
    private final String API_KEY;

    public UnifiApiImpl(String apiKey) {
        this.API_KEY = apiKey;
    }

    @Override
    public UnifiApiResponse<Collection<Host>> listHosts() throws IOException {
        TypeToken<Collection<Host>> collectionTypeToken = new TypeToken<>(){};

        UnifiApiRequest request = new UnifiApiRequest();

        return request
                .apiKey(API_KEY)
                .get()
                .uriPath(UnifiApiPath.LIST_HOSTS.toString())
                .send(collectionTypeToken);
    }

    @Override
    public UnifiApiResponse<Host> getHostById(String hostId) throws IOException {
        TypeToken<Host> hostTypeToken = new TypeToken<>(){};

        UnifiApiRequest request = new UnifiApiRequest();

        return request
                .apiKey(API_KEY)
                .get()
                .uriPath(UnifiApiPath.GET_HOST_BY_ID + hostId)
                .send(hostTypeToken);
    }

    @Override
    public UnifiApiResponse<Collection<Site>> listSites() {
        return null;
    }

    @Override
    public UnifiApiResponse<Collection<Device>> listDevices() {
        return null;
    }
}
