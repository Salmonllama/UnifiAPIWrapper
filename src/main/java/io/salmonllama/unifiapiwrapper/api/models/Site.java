package io.salmonllama.unifiapiwrapper.api.models;

import com.google.gson.annotations.SerializedName;

public record Site(
    @SerializedName("hostId") String hostId,
    @SerializedName("isOwner") Boolean isOwner
) {}
