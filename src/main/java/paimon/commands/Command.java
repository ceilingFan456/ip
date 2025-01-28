package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

public abstract class Command {
    // an abstract class that manipulate tasklist and makes UI do things
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
