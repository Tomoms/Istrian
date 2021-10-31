package org.istrian.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.istrian.Entry;
import org.istrian.EntryType;
import org.istrian.IstrianInstance;

import java.util.NavigableSet;

@Parameters(commandDescription = "Add a new entry to the database")
public class NewCommand implements Command {

    @Parameter(names = { "-a", "--amount" })
    private double amount;

    @Parameter(names = { "-d", "--description" })
    private String description;

    @Override
    public void execute() {
        final IstrianInstance instance = IstrianInstance.getInstance();
        NavigableSet<Entry> set = instance.getSet();
        int nextId = set.last().getId() + 1;
        set.add(new Entry(nextId,
                amount < 0 ? EntryType.OUTFLOW : EntryType.INCOME,
                Math.abs(amount),
                description));
    }

    @Override
    public String getName() {
        return "new";
    }

}
