package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

public class CommandEmpty extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        return true;
    }
}