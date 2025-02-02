package paimon.parser;

import paimon.commands.Command;
import paimon.commands.CommandCreate;
import paimon.commands.CommandDelete;
import paimon.commands.CommandEmpty;
import paimon.commands.CommandFind;
import paimon.commands.CommandGoodbye;
import paimon.commands.CommandList;
import paimon.commands.CommandMark;
import paimon.commands.CommandUnmark;
import paimon.exceptions.PaimonInvalidInputException;
import paimon.items.Deadline;
import paimon.items.Event;
import paimon.items.Todo;

/**
 * Parse class that parse the natural language input string into Command objects.
 */
public class Parser {

    /**
     * Parses the input string and returns the corresponding Command object.
     * 
     * @param str Input string from user.
     * @return Command object that can be executed.
     */
    public static Command parse(String str) {
        try {
            if (str.equals("bye")) {
                return new CommandGoodbye();

            } else if (str.equals("list")) {
                return new CommandList();

            } else if (str.startsWith("mark")) {
                String num = str.substring(5);
                int index = Integer.parseInt(num) - 1;
                return new CommandMark(index);
            
            } else if (str.startsWith("unmark")) {
                String num = str.substring(7);
                int index = Integer.parseInt(num) - 1;
                return new CommandUnmark(index);

            } else if (str.startsWith("delete")) {
                String num = str.substring(7);
                int index = Integer.parseInt(num) - 1;
                return new CommandDelete(index);

            } else if (str.startsWith("todo")) {
                String description = str.substring(5);
                Todo todo = new Todo(description);
                return new CommandCreate(todo);

            } else if (str.startsWith("deadline")) {
                String description = str.substring(9);
                String[] arr = description.split(" /by ");
                Deadline deadline = new Deadline(arr[0], arr[1]);
                return new CommandCreate(deadline);

            } else if (str.startsWith("event")) {
                String description = str.substring(6);
                String[] arr = description.split(" /from ");
                String[] arr2 = arr[1].split(" /to ");
                Event event = new Event(arr[0], arr2[0], arr2[1]);
                return new CommandCreate(event);

            } else if (str.startsWith("find")) {
                String keyword = str.substring(5);
                return new CommandFind(keyword);

            } else {
                throw new PaimonInvalidInputException(str);
            }
        } catch (PaimonInvalidInputException e) {
            System.out.println(e.getMessage());
        }
        return new CommandEmpty();
    }
}
