package org.istrian.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.istrian.Entry;
import org.istrian.EntryType;
import org.istrian.IstrianInstance;

import java.util.NavigableSet;

@Parameters(commandDescription = "Print balance")
public class BalanceCommand implements Command {

    @Override
    public void execute() {
        final IstrianInstance instance = IstrianInstance.getInstance();
        NavigableSet<Entry> set = instance.getSet();
        double balance = set.stream().map(Entry::getSignedAmount).reduce(0d, Double::sum);
        System.out.println("Balance: " + balance);
    }

    @Override
    public String getName() {
        return "balance";
    }

}
