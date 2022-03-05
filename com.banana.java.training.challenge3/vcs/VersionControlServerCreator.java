package vcs;

import vcs.enums.ServerType;
import vcs.interfaces.IVersionControlServer;

import java.util.HashMap;
import java.util.Map;

public class VersionControlServerCreator {

    private static final Map<ServerType, IVersionControlServer> serverMap = new HashMap<>();

    public static IVersionControlServer createNewServer(ServerType serverType) {
        switch (serverType) {
            case GIT -> {
                return new GitServer();
            }
            case SVN -> {
                return new SvnServer();
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public static IVersionControlServer createOrGetExistentServer(ServerType serverType) {
        if (!serverMap.containsKey(serverType)) {
            serverMap.put(serverType, createNewServer(serverType));
        }

        return serverMap.get(serverType);
    }
}
