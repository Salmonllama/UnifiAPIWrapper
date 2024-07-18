package io.salmonllama.unifiapiwrapper.api;

import io.salmonllama.unifiapiwrapper.api.models.Device;
import io.salmonllama.unifiapiwrapper.api.models.Host;
import io.salmonllama.unifiapiwrapper.api.models.Site;

import java.io.IOException;
import java.util.Collection;

public interface UnifiApi {

    UnifiApiResponse<Collection<Host>> listHosts() throws IOException;

    UnifiApiResponse<Host> getHostById(String hostId) throws IOException;

    UnifiApiResponse<Collection<Site>> listSites() throws IOException;

    UnifiApiResponse<Collection<Device>> listDevices() throws IOException;
}
