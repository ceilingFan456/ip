package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

/**
 * CommandMark marks a task at given index as done.
 */
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandMark) {
            CommandMark c = (CommandMark) obj;
            return this.index == c.index;
        } else {
            return false;
        }
    }
}
