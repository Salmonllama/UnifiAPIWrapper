package io.salmonllama.unifiapiwrapper.core.internal;

public enum UnifiApiPath {
    LIST_HOSTS("/ea/hosts"),
    GET_HOST_BY_ID("/ea/hosts/"),
    LIST_SITES("/ea/sites"),
    LIST_DEVICES("/ea/devices")
    ;

    private final String path;

    UnifiApiPath(final String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
