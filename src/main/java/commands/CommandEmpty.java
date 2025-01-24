package commands;

import tasklist.TaskList;
import ui.UI;

public class CommandEmpty extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        return true;
    }
}