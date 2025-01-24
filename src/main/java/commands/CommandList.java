package commands;

import tasklist.TaskList;
import ui.UI;

public class CommandList extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        t.list_items();
        return true;
    }
}
