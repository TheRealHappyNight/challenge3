package vcs;

import vcs.interfaces.IVersionControlServer;

import java.time.Duration;
import java.time.Instant;

public class GitServer implements IVersionControlServer {

    private Instant startTime;

    GitServer() {}

    @Override
    public void start() {
        System.out.println("Git server started");
        startTime = Instant.now();
    }

    @Override
    public void stop() {
        System.out.println("Git server stopped and ran for " + upTimeInSecond() + " seconds");
    }

    @Override
    public long upTimeInSecond() {
        if (null == startTime) {
            return 0;
        }

        return Duration.between(startTime, Instant.now()).toSeconds();
    }
}
