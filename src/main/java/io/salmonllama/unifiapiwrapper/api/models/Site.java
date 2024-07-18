package io.salmonllama.unifiapiwrapper.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record Site(
        @SerializedName("hostId") String hostId,
        @SerializedName("isOwner") Boolean isOwner,
        @SerializedName("meta") Meta meta,
        @SerializedName("permission") String permission,
        @SerializedName("siteId") String sideId,
        @SerializedName("statistics") Statistics statistics,
        @SerializedName("subscriptionEndTime") String subscriptionEndTime
) {
    public record Meta(
            @SerializedName("desc") String desc,
            @SerializedName("gatewayMac") String gatewayMac,
            @SerializedName("name") String name,
            @SerializedName("timezone") String timezone
    ) {}

    public record Statistics(
            @SerializedName("counts") Counts counts,
            @SerializedName("internetIssues") List<InternetIssue> internetIssues,
            @SerializedName("ispInfo") IspInfo ispInfo,
            @SerializedName("percentages") Percentages percentages
    ) {
        public record Counts(
                @SerializedName("criticalNotification") Integer criticalNotification,
                @SerializedName("gatewayDevice") Integer gatewayDevice,
                @SerializedName("guestClient") Integer guestClient,
                @SerializedName("lanConfiguration") Integer lanConfiguration,
                @SerializedName("offlineDevice") Integer offlineDevice,
                @SerializedName("offlineGatewayDevice") Integer offlineGatewayDevice,
                @SerializedName("offlineWifiDevice") Integer offlineWifiDevice,
                @SerializedName("offlineWiredDevice") Integer offlineWiredDevice,
                @SerializedName("pendingUpdateDevice") Integer pendingUpdateDevice,
                @SerializedName("totalDevice") Integer totalDevice,
                @SerializedName("wanConfiguration") Integer wanConfiguration,
                @SerializedName("wifiClient") Integer wifiClient,
                @SerializedName("wiredClient") Integer wiredClient,
                @SerializedName("wiredDevice") Integer wiredDevice
        ) {}

        public record InternetIssue( // TODO: I *know* this is incomplete. There are more issue type. Must inspect in postman
                @SerializedName("highLatency") Boolean highLatency,
                @SerializedName("index") Long index,
                @SerializedName("latencyAvgMs") Float latencyAvgMs,
                @SerializedName("latencyMaxMs") Float latencyMaxMs
        ) {}

        public record IspInfo(
                @SerializedName("name") String name,
                @SerializedName("organization") String organization
        ) {}

        public record Percentages(
                @SerializedName("txRetry") Float txRetry,
                @SerializedName("wanUptime") Float wanUptime
        ) {}
    }
}
