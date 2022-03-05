import vcs.GitServer;
import vcs.VersionControlServerCreator;
import vcs.enums.ServerType;
import vcs.interfaces.IVersionControlServer;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        IVersionControlServer git = VersionControlServerCreator.createOrGetExistentServer(ServerType.GIT);
        IVersionControlServer svn = VersionControlServerCreator.createOrGetExistentServer(ServerType.SVN);
        git.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //to check it doesn't crash
        svn.stop();

        git.stop();
    }
}
