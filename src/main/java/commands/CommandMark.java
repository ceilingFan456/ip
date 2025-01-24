package commands;

import tasklist.TaskList;
import ui.UI;

public class CommandMark extends Command {
    private int index;

    public CommandMark(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList t, UI ui) {
        t.mark(index);
        ui.print("Nice! I've marked this task as done:");
        ui.print(t.get(index) + "\n");
        return true;
    }
}
