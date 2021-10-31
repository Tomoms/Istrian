package org.istrian.command;

public interface Command {
    String getName();
    void execute();
}
