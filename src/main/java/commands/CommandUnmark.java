package commands;

import tasklist.TaskList;
import ui.UI;

public class CommandUnmark extends Command {
    private int index;

    public CommandUnmark(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList t, UI ui) {
        t.unmark(index);
        ui.print("OK, I've marked this task as not done yet:");
        ui.print(t.get(index) + "\n");
        return true;
    }
}
