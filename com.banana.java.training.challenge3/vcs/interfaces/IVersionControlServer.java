package vcs.interfaces;

public interface IVersionControlServer {
    void start();
    void stop();
    long upTimeInSecond();
}
