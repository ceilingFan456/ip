package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

public abstract class Command {
    /**
     * Execute the command with current tasklist and ui
     * 
     * @param t tasklist involved
     * @param ui ui for interaction with user
     * @return boolean whether the program should continue to run after command is executed
     */
    public abstract boolean execute(TaskList t, UI ui);

    // same type of command is euqal
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Command) {
            return true;
        } else {
            return false;
        }
    }
}
