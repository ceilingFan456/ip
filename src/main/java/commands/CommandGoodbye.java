package commands;

import tasklist.TaskList;
import ui.UI;

public class CommandGoodbye extends Command {
    @Override
    public boolean execute(TaskList t, UI ui) {
        ui.goodbye();
        return false;
    }
}