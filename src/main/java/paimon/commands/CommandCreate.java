package paimon.commands;

import paimon.items.Todo;
import paimon.tasklist.TaskList;
import paimon.ui.UI;

/**
 * CommandCreate class is a subclass of Command that 
 * creates a new Todo task and adds it to the TaskList.
 */
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandCreate) {
            CommandCreate c = (CommandCreate) obj;
            return this.td.equals(c.td);
        } else {
            return false;
        }
    }
}
