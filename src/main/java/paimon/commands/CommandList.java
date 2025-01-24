package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

public class CommandList extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        t.list_items();
        return true;
    }
}
