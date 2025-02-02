package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

/**
 * CommandList is a Command that lists all the tasks in the task list.
 */
public class CommandList extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        t.list_items();
        return true;
    }
}
