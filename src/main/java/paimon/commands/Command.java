package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

public abstract class Command {
    // an abstract class that manipulate tasklist and makes UI do things
    public abstract boolean execute(TaskList t, UI ui);
}
