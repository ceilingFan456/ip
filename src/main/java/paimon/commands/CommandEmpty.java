package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

/**
 * CommandEmpty is a Command that does nothing.
 * This is used to handle wrong user command.
 */
public class CommandEmpty extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        return true;
    }
}
