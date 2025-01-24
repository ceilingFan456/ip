package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;
import paimon.items.Todo;

public class CommandCreate extends Command {
    private Todo td;

    public CommandCreate(Todo td) {
        this.td = td;
    }

    @Override
    public boolean execute(TaskList t, UI ui) {
        t.add(this.td);

        ui.print("Got it. I've added this task:");
        ui.print(this.td);
        ui.print("Now you have " + t.size() + " tasks in the list.\n");
        return true;
    }
}
