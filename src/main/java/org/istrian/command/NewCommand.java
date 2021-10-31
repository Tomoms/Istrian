package org.istrian.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Add a new entry to the database")
public class NewCommand {

    @Parameter(names = { "-a", "--amount" })
    private double amount;

    @Parameter(names = { "-d", "--description" })
    private String description;

}
