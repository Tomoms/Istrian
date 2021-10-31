package org.istrian;

import com.beust.jcommander.JCommander;
import org.istrian.command.BalanceCommand;
import org.istrian.command.Command;
import org.istrian.command.NewCommand;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IstrianInstance instance = IstrianInstance.getInstance();

        List<Command> commandList = List.of(
                new NewCommand(),
                new BalanceCommand()
        );
        final JCommander.Builder builder = JCommander.newBuilder();
        commandList.forEach(command -> builder.addCommand(command.getName(), command));
        JCommander jc = builder.build();

        jc.parse(args);
        commandList.stream().filter(command -> command.getName().equals(args[0])).forEach(Command::execute);

        instance.destroy();
    }

}
