package paimon.commands;

import paimon.tasklist.TaskList;
import paimon.ui.UI;

/**
 * CommandFind is a Command that finds tasks with a keyword.
 * Currently it is just sequentially search instead of using some pre-built data structure 
 * to speed up the search. maybe can cache the search result to speed up the search.
 */
public class CommandFind extends Command {
    private String keyword;

    public CommandFind(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean execute(TaskList t, UI ui) {
        // find the task with the keyword
        TaskList found = t.find(this.keyword);

        ui.print("Here are the matching tasks in your list:");
        found.list_items();
        return true;
    }

    // same type of command is euqal
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommandFind) {
            CommandFind c = (CommandFind) obj;
            return this.keyword.equals(c.keyword);
        } else {
            return false;
        }
    }
}
