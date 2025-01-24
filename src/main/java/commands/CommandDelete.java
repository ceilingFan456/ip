package commands;

import tasklist.TaskList;
import ui.UI;
import items.Todo;

public class CommandDelete extends Command {
    private int index;

    public CommandDelete(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList t, UI ui) {
        Todo d = t.remove(index);
        ui.print("Noted. I've removed this task:");
        ui.print(d);
        ui.print("Now you have " + t.size() + " tasks in the list.\n");
        return true;
    }
}
