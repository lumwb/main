package seedu.address.logic.commands.statistics;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.CommandResultType;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.statistics.Statistics;

/**
 * Generates a Statistics Report
 */
public class StatisticsAddCommand extends StatisticsCommand {

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Generates Statistics Report\n"
            + "Parameters:\n"
            + "file/{relative/full excel file path}\n"
            + "Example: statistics file/C:\\Users\\MyUser\\Desktop\\SampleData.xlsx\n";

    public static final String MESSAGE_SUCCESS = "Statistics Generated";

    private final Statistics toAdd;

    /**
     * Creates a StatisticsAddCommand to add the specified {@code Statistics}
     *
     * @param stats to set.
     */
    public StatisticsAddCommand(Statistics stats) {
        requireNonNull(stats);
        toAdd = stats;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.addStatistics(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd), CommandResultType.SHOW_STATISTIC);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof StatisticsAddCommand // instanceof handles nulls
            && toAdd.equals(((StatisticsAddCommand) other).toAdd));
    }
}