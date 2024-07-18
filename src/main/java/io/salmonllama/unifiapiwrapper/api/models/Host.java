package io.salmonllama.unifiapiwrapper.api.models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record Host(
    @SerializedName("id") String id,
    @SerializedName("hardwareId") String hardwareId,
    @SerializedName("ipAddress") String ipAddress,
    @SerializedName("isBlocked") Boolean isBlocked,
    @SerializedName("lastConnectionStateChange") String lastConnectionStateChange,
    @SerializedName("LatestBackupTime") String latestBackupTime,
    @SerializedName("owner") Boolean owner,
    @SerializedName("registrationTime") String registrationTime,
    @SerializedName("reportedState") ReportedState reportedState,
    @SerializedName("type") String type,
    @SerializedName("userData") UserData userData
) {
    public record ReportedState(
            @SerializedName("anonid") String anonId,
            @SerializedName("apps") List<App> apps,
            @SerializedName("availableChannels") List<String> availableChannels,
            @SerializedName("consolesOnSameLocalNetwork") List<String> consolesOnSameLocalNetwork, // TODO: Unknown content
            @SerializedName("controller_uuid") String controllerUuid,
            @SerializedName("deviceId") String deviceId,
            @SerializedName("firmware_version") String firmwareVersion,
            @SerializedName("hardware_id") String hardwareId,
            @SerializedName("controllers") List<Controller> controllers,
            @SerializedName("country") Integer country,
            @SerializedName("deviceErrorCode") Integer deviceErrorCode, // TODO: Unsure if Integer, example shows null
            @SerializedName("deviceState") String deviceState,
            @SerializedName("deviceStateLastChanged") Long deviceStateLastChanged,
            @SerializedName("directConnectDomain") String directConnectDomain,
            @SerializedName("features") Features features,
            @SerializedName("firmwareUpdate") FirmwareUpdate firmwareUpdate,
            @SerializedName("hardware") Hardware hardware,
            @SerializedName("host_type") Integer hostType,
            @SerializedName("hostname") String hostname,
            @SerializedName("inform_port") Integer informPort,
            @SerializedName("internetIssues5min") InternetIssues5Min internetIssues5Min,
            @SerializedName("ip") String ip,
            @SerializedName("apAddrs") List<String> ipAddrs,
            @SerializedName("isStacked") Boolean isStacked,
            @SerializedName("location") Location location,
            @SerializedName("mac") String mac,
            @SerializedName("mgmt_port") Integer mgmtPort,
            @SerializedName("name") String name,
            @SerializedName("releaseChannel") String releaseChannel,
            @SerializedName("state") String state,
            @SerializedName("timezone") String timezone,
            @SerializedName("uidb") UIDB uidb,
            @SerializedName("unadoptedUnifiOSDevices") List<String> unadoptedUnifiOsDevices, //TODO Unknown contents
            @SerializedName("version") String version
    ) {
        public record App(
                @SerializedName("controllerStatus") String controllerStatus,
                @SerializedName("name") String name,
                @SerializedName("port") Integer port,
                @SerializedName("swaiVersion") Integer swaiVersion,
                @SerializedName("type") String type,
                @SerializedName("version") String version
        ) {}

        public record Controller(
                @SerializedName("abridged") Boolean abridged,
                @SerializedName("controllerStatus") String controllerStatus,
                @SerializedName("features") Features features,
                @SerializedName("initialDeviceListSynced") Boolean initialDeviceListSynced,
                @SerializedName("installState") String installState,
                @SerializedName("installable") Boolean installable,
                @SerializedName("isConfigured") Boolean isConfigured,
                @SerializedName("isGeofencingEnabled") Boolean isGeofencingEnabled,
                @SerializedName("isInstalled") Boolean isInstalled,
                @SerializedName("isRunning") Boolean isRunning,
                @SerializedName("name") String name,
                @SerializedName("port") Integer port,
                @SerializedName("releaseChannel") String releaseChannel,
                @SerializedName("restorePercentage") Integer restorePercentage,
                @SerializedName("required") Boolean required,
                @SerializedName("state") String state,
                @SerializedName("status") String status,
                @SerializedName("statusMessage") String statusMessage,
                @SerializedName("swaiVersion") Integer swaiVersion,
                @SerializedName("type") String type,
                @SerializedName("uiVersion") String uiVersion,
                @SerializedName("unadoptedDevices") List<String> unadoptedDevices, // TODO, unknown contents
                @SerializedName("updatable") Boolean updatable,
                @Nullable
                @SerializedName("updateAvailable") Boolean updateAvailable,
                @SerializedName("version") String version
        ) {
            public record Features(
                    @SerializedName("stackable") Boolean stackable
            ) {}
        }

        public record Features(
                @SerializedName("cloud") Cloud cloud,
                @SerializedName("cloudBackup") Boolean cloudBackup,
                @SerializedName("deviceList") DeviceList deviceList,
                @SerializedName("directRemoteConnection") Boolean directRemoteConnection,
                @SerializedName("hasGateway") Boolean hasGateway,
                @SerializedName("hasLCM") Boolean hasLcm,
                @SerializedName("hasLED") Boolean hasLed,
                @SerializedName("infoApis") InfoApis infoApis,
                @SerializedName("isAutomaticFailoverAvailable") Boolean isAutomaticFailoverAvailable,
                @SerializedName("mfa") Boolean mfa,
                @SerializedName("notifications") Boolean notifications,
                @SerializedName("sharedTokens") Boolean sharedTokens,
                @SerializedName("supportForm") Boolean supportForm,
                @SerializedName("teleport") Boolean teleport,
                @SerializedName("teleportState") String teleportState,
                @SerializedName("uidService") Boolean uidService
        ) {
            public record Cloud(
                    @SerializedName("applicationEvents") Boolean applicationEvents,
                    @SerializedName("applicationEventsHttp") Boolean applicationEventsHttp
            ) {}

            public record DeviceList(
                    @SerializedName("autolinkDevice") Boolean autoLinkDevices,
                    @SerializedName("partialUpdates") Boolean partialUpdates,
                    @SerializedName("ucp4Events") Boolean ucp4Events
            ) {}

            public record InfoApis(
                    @SerializedName("firmwareUpdate") Boolean firmwareUpdate
            ) {}
        }

        public record FirmwareUpdate(
                @SerializedName("latestAvailableVersion") @Nullable String latestAvailableVersion// TODO: Pretty sure this is a string. Example is null
        ) {}

        public record Hardware(
                @SerializedName("bom") String bom,
                @SerializedName("cpu.id") String cpuId,
                @SerializedName("debianCodename") String debianCodename,
                @SerializedName("firmwareVersion") String firmwareVersion,
                @SerializedName("hwrev") Long hwRev,
                @SerializedName("mac") String mac,
                @SerializedName("name") String name,
                @SerializedName("qrid") String qrId,
                @SerializedName("reboot") String reboot,
                @SerializedName("serialNo") String serialNo,
                @SerializedName("shortname") String shortName,
                @SerializedName("subtype") String subType,
                @SerializedName("sysid") Long sysId,
                @SerializedName("upgrade") String upgrade,
                @SerializedName("uuid") String uuid
        ) {}

        public record InternetIssues5Min(
                @SerializedName("periods") List<Period> periods
        ) {
            public record Period(
                    @SerializedName("index") Long index
            ) {}
        }

        public record Location(
                @SerializedName("lat") Float latitude,
                @SerializedName("Long") Float longitude,
                @SerializedName("radius") Integer radius,
                @SerializedName("text") String text
        ) {}

        public record UIDB(
                @SerializedName("guid") String guid,
                @SerializedName("id") String id,
                @SerializedName("images") Images images
        ) {
            public record Images(
                    @SerializedName("default") String imageDefault,
                    @SerializedName("nopadding") String noPadding,
                    @SerializedName("topology") String topology
            ) {}
        }
    }

    public record UserData(
        @SerializedName("apps") List<String> apps,
        @SerializedName("consoleGroupMembers") List<ConsoleGroupMember> consoleGroupMembers,
        @SerializedName("controllers") List<String> controllers,
        @SerializedName("email") String email,
        @SerializedName("features") Features features,
        @SerializedName("fullName") String fullName,
        @SerializedName("localId") String localId,
        @SerializedName("permissions") Permissions permission,
        @SerializedName("role") String role,
        @SerializedName("roleId") String roleId,
        @SerializedName("status") String status
    ) {
        public record ConsoleGroupMember(
                @SerializedName("mac") String mac,
                @SerializedName("role") String role,
                @SerializedName("roleAttributes") RoleAttributes roleAttributes,
                Long sysId
        ) {
            public record RoleAttributes(
                    @SerializedName("applications") Applications applications,
                    @SerializedName("candidateRoles") List<String> candidateRoles,
                    @SerializedName("connectedState") String connectedState,
                    @SerializedName("connectedStateLastChanged") String connectedStateLastChanged
            ) {
                public record Applications(
                        @SerializedName("access") Application access,
                        @SerializedName("connect") Application connect,
                        @SerializedName("innerspace") Application innerSpace,
                        @SerializedName("network") Application network,
                        @SerializedName("protect") Application protect,
                        @SerializedName("talk") Application talk
                ) {
                    public record Application(
                            @SerializedName("owned") Boolean owned,
                            @SerializedName("required") Boolean required,
                            @SerializedName("supported") Boolean supported
                    ) {}
                }
            }
        }

        public record Features(
                @SerializedName("deviceGroups") Boolean deviceGroups,
                @SerializedName("floorplan") Floorplan floorplan,
                @SerializedName("manageApplications") Boolean manageApplications,
                @SerializedName("notifications") Boolean notifications,
                @SerializedName("pion") Boolean pion,
                @SerializedName("webrtc") WebRTC webRtc
        ) {
            public record Floorplan(
                    @SerializedName("CanEdit") Boolean canEdit,
                    @SerializedName("canView") Boolean canView
            ) {}

            public record WebRTC(
                    @SerializedName("iceRestart") Boolean iceRestart,
                    @SerializedName("mediaStreams") Boolean mediaStreams,
                    @SerializedName("twoWayAudio") Boolean twoWayAudio
            ) {}
        }

        public record Permissions(
                @SerializedName("network.management") List<String> networkManagement,
                @SerializedName("protect.management") List<String> protectManagement,
                @SerializedName("system.management.location") List<String> systemManagementLocation,
                @SerializedName("system.management.user") List<String> systemManagementUser
        ) {}
    }
}