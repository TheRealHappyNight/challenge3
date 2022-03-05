package vcs;

import vcs.interfaces.IVersionControlServer;

import java.time.Duration;
import java.time.Instant;

public class SvnServer implements IVersionControlServer {

    private Instant startTime;

    SvnServer() {}

    @Override
    public void start() {
        System.out.println("Svn server started");
        startTime = Instant.now();
    }

    @Override
    public void stop() {
        System.out.println("Svn server stopped and ran for " + upTimeInSecond() + " seconds");
    }

    @Override
    public long upTimeInSecond() {
        if (null == startTime) {
            return 0;
        }

        return Duration.between(startTime, Instant.now()).toSeconds();
    }
}
