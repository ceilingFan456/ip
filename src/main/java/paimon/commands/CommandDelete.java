package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;
import paimon.items.Todo;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandDelete) {
            CommandDelete c = (CommandDelete) obj;
            return this.index == c.index;
        } else {
            return false;
        }
    }
}
