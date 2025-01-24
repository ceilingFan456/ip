import java.util.Scanner;

import exceptions.PaimonException;
import exceptions.PaimonInvalidInputException;
import items.Deadline;
import items.Event;
import items.Todo;
import storage.Storage;
import tasklist.Tasklist;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Paimon {
    private Scanner sc;
    private Tasklist items;
    private Storage storage;


    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
        this.items = new Tasklist();
        this.storage = new Storage();
    }

    public void run() {
        // greeting message
        System.out.println("Hello! I'm Paimon");
        System.out.println("What can I do for you?\n");

        // loop variables
        boolean running = true;

        try {

            // main loop
            while (running) {
                // read a str from user
                String str = sc.nextLine();
                
                // end the program
                if (str.equals("bye")) {
                    running = false;
                    System.out.println("Bye. Hope to see you again soon!");
                    break; // skip the saving process
                
                // list the items 
                } else if (str.equals("list")) {
                    if (this.items.size() == 0) {
                        System.out.println("Empty list!");
                    } else {
                        for (int i = 0; i < this.items.size(); i++) {
                            System.out.println((i + 1) + ". " + this.items.get(i));
                        }
                    }
                    System.out.println();
                    continue; // skip the saving process

                } else if (str.startsWith("mark")) {
                    String num = str.substring(5);
                    int index = Integer.parseInt(num) - 1;

                    items.get(index).mark();

                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(items.get(index) + "\n");
                
                } else if (str.startsWith("unmark")) {
                    String num = str.substring(7);
                    int index = Integer.parseInt(num) - 1;

                    items.get(index).unmark();

                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(items.get(index) + "\n");

                } else if (str.startsWith("delete")) {
                    String num = str.substring(7);
                    int index = Integer.parseInt(num) - 1;

                    Todo deleted = items.remove(index);

                    System.out.println("Noted. I've removed this task:");
                    System.out.println(deleted);
                    System.out.println("Now you have " + items.size() + " tasks in the list.\n");

                }  else if (str.startsWith("todo")) {
                    String description = str.substring(5);
                    Todo todo = new Todo(description);
                    items.add(todo);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(todo);
                    System.out.println("Now you have " + items.size() + " tasks in the list.\n");

                } else if (str.startsWith("deadline")) {
                    String description = str.substring(9);
                    String[] arr = description.split(" /by ");
                    Deadline deadline = new Deadline(arr[0], arr[1]);
                    items.add(deadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(deadline);
                    System.out.println("Now you have " + items.size() + " tasks in the list.\n");

                } else if (str.startsWith("event")) {
                    String description = str.substring(6);
                    String[] arr = description.split(" /from ");
                    String[] arr2 = arr[1].split(" /to ");
                    Event event = new Event(arr[0], arr2[0], arr2[1]);
                    items.add(event);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(event);
                    System.out.println("Now you have " + items.size() + " tasks in the list.\n");

                } else {
                    throw new PaimonInvalidInputException(str);
                }

                // save the items
                this.storage.save(this.items);
            }
        } catch (PaimonException e) {
            System.out.println("An error occurred: " + e.getMessage() + "\nExited with error.");
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
