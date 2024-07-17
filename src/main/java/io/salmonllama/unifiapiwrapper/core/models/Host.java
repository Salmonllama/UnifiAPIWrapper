package io.salmonllama.unifiapiwrapper.core.models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public record Host (
    @SerializedName("id") String id,
    @SerializedName("hardwareId") String hardwareId,
    @SerializedName("ipAddress") String ipAddress,
    @SerializedName("isBlocked") boolean isBlocked,
    @SerializedName("lastConnectionStateChange") String lastConnectionStateChange,
    @SerializedName("LatestBackupTime") String latestBackupTime,
    @SerializedName("owner") boolean owner,
    @SerializedName("registrationTime") String registrationTime,
    @SerializedName("reportedState") ReportedState reportedState,
    @SerializedName("type") String type,
    @SerializedName("userData") @Nullable UserData userData
) {
    public record ReportedState(
            @SerializedName("anonid") String anonId,
            @SerializedName("apps") List<App> apps,
            @SerializedName("availableChannels") List<String> availableChannels,
            @SerializedName("consolesOnSameLocalNetwork") List<String> consolesOnSameLocalNetwork, // TODO: Unknown content
            @SerializedName("controller_uuid") String controllerUuid,
            @SerializedName("deviceId") @Nullable String deviceId,
            @SerializedName("firmware_version") @Nullable String firmwareVersion,
            @SerializedName("hardware_id") @Nullable String hardwareId,
            @SerializedName("controllers") List<Controller> controllers,
            @SerializedName("country") int country,
            @SerializedName("deviceErrorCode") int deviceErrorCode, // TODO: Unsure if int, example shows null
            @SerializedName("deviceState") String deviceState,
            @SerializedName("deviceStateLastChanged") long deviceStateLastChanged,
            @SerializedName("directConnectDomain") String directConnectDomain,
            @SerializedName("features") Features features,
            @SerializedName("firmwareUpdate") FirmwareUpdate firmwareUpdate,
            @SerializedName("hardware") Hardware hardware,
            @SerializedName("host_type") int hostType,
            @SerializedName("hostname") String hostname,
            @SerializedName("inform_port") int informPort,
            @SerializedName("internetIssues5min") InternetIssues5Min internetIssues5Min,
            @SerializedName("ip") String ip,
            @SerializedName("apAddrs") List<String> ipAddrs,
            @SerializedName("isStacked") boolean isStacked,
            @SerializedName("location") Location location,
            @SerializedName("mac") String mac,
            @SerializedName("mgmt_port") int mgmtPort,
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
                @SerializedName("port") int port,
                @SerializedName("swaiVersion") int swaiVersion,
                @SerializedName("type") String type,
                @SerializedName("version") String version
        ) {}

        public record Controller(
                @SerializedName("abridged") boolean abridged,
                @SerializedName("controllerStatus") String controllerStatus,
                @SerializedName("features") Features features,
                @SerializedName("initialDeviceListSynced") boolean initialDeviceListSynced,
                @SerializedName("installState") String installState,
                @SerializedName("installable") boolean installable,
                @SerializedName("isConfigured") boolean isConfigured,
                @SerializedName("isGeofencingEnabled") boolean isGeofencingEnabled,
                @SerializedName("isInstalled") boolean isInstalled,
                @SerializedName("isRunning") boolean isRunning,
                @SerializedName("name") String name,
                @SerializedName("port") int port,
                @SerializedName("releaseChannel") String releaseChannel,
                @SerializedName("restorePercentage") int restorePercentage,
                @SerializedName("required") boolean required,
                @SerializedName("state") String state,
                @SerializedName("status") String status,
                @SerializedName("statusMessage") String statusMessage,
                @SerializedName("swaiVersion") int swaiVersion,
                @SerializedName("type") String type,
                @SerializedName("uiVersion") String uiVersion,
                @SerializedName("unadoptedDevices") List<String> unadoptedDevices, // TODO, unknown contents
                @SerializedName("updatable") boolean updatable,
                @SerializedName("updateAvailable") boolean updateAvailable,
                @SerializedName("version") String version
        ) {
            public record Features(
                    @SerializedName("stackable") boolean stackable
            ) {}
        }

        public record Features(
                @SerializedName("cloud") Cloud cloud,
                @SerializedName("cloudBackup") boolean cloudBackup,
                @SerializedName("deviceList") DeviceList deviceList,
                @SerializedName("directRemoteConnection") boolean directRemoteConnection,
                @SerializedName("hasGateway") boolean hasGateway,
                @SerializedName("hasLCM") boolean hasLcm,
                @SerializedName("hasLED") boolean hasLed,
                @SerializedName("infoApis") InfoApis infoApis,
                @SerializedName("isAutomaticFailoverAvailable") boolean isAutomaticFailoverAvailable,
                @SerializedName("mfa") boolean mfa,
                @SerializedName("notifications") boolean notifications,
                @SerializedName("sharedTokens") boolean sharedTokens,
                @SerializedName("supportForm") boolean supportForm,
                @SerializedName("teleport") boolean teleport,
                @SerializedName("teleportState") String teleportState,
                @SerializedName("uidService") boolean uidService
        ) {
            public record Cloud(
                    @SerializedName("applicationEvents") boolean applicationEvents,
                    @SerializedName("applicationEventsHttp") boolean applicationEventsHttp
            ) {}

            public record DeviceList(
                    @SerializedName("autolinkDevice") boolean autoLinkDevices,
                    @SerializedName("partialUpdates") boolean partialUpdates,
                    @SerializedName("ucp4Events") boolean ucp4Events
            ) {}

            public record InfoApis(
                    @SerializedName("firmwareUpdate") boolean firmwareUpdate
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
                @SerializedName("hwrev") long hwRev,
                @SerializedName("mac") String mac,
                @SerializedName("name") String name,
                @SerializedName("qrid") String qrId,
                @SerializedName("reboot") String reboot,
                @SerializedName("serialNo") String serialNo,
                @SerializedName("shortname") String shortName,
                @SerializedName("subtype") String subType,
                @SerializedName("sysid") long sysId,
                @SerializedName("upgrade") String upgrade,
                @SerializedName("uuid") String uuid
        ) {}

        public record InternetIssues5Min(
                @SerializedName("periods") List<Period> periods
        ) {
            public record Period(
                    @SerializedName("index") long index
            ) {}
        }

        public record Location(
                @SerializedName("lat") float latitude,
                @SerializedName("long") float longitude,
                @SerializedName("radius") int radius,
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
                long sysId
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
                            @SerializedName("owned") boolean owned,
                            @SerializedName("required") boolean required,
                            @SerializedName("supported") boolean supported
                    ) {}
                }
            }
        }

        public record Features(
                @SerializedName("deviceGroups") boolean deviceGroups,
                @SerializedName("floorplan") Floorplan floorplan,
                @SerializedName("manageApplications") boolean manageApplications,
                @SerializedName("notifications") boolean notifications,
                @SerializedName("pion") boolean pion,
                @SerializedName("webrtc") WebRTC webRtc
        ) {
            public record Floorplan(
                    @SerializedName("CanEdit") boolean canEdit,
                    @SerializedName("canView") boolean canView
            ) {}

            public record WebRTC(
                    @SerializedName("iceRestart") boolean iceRestart,
                    @SerializedName("mediaStreams") boolean mediaStreams,
                    @SerializedName("twoWayAudio") boolean twoWayAudio
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