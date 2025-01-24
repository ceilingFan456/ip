package parser;

import commands.Command;
import commands.CommandGoodbye;
import commands.CommandList;
import commands.CommandMark;
import commands.CommandUnmark;
import commands.CommandDelete;
import commands.CommandEmpty;
import commands.CommandCreate;

import items.Todo;
import items.Deadline;
import items.Event;

import exceptions.PaimonInvalidInputException;

public class Parser {

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

            }  else if (str.startsWith("todo")) {
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
            } else {
                throw new PaimonInvalidInputException(str);
            }
        } catch (PaimonInvalidInputException e) {
            System.out.println(e.getMessage());
        }
        return new CommandEmpty();
    }
}
