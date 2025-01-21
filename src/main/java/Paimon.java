import java.util.Scanner;

import exceptions.PaimonException;
import exceptions.PaimonInvalidInputException;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Paimon {
    private Scanner sc;
    private ArrayList<Todo> items;
    private File file;
    private final String filePath = "data/items.txt";

    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
        this.items = new ArrayList<Todo>();
        this.file = new File(this.filePath);

        // create file if not exists
        try {
            // create folder if not exists
            File parentDir = this.file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
                System.out.println("New folder created: " + parentDir);
            }

            // create file if not exists
            if (!(this.file.exists())) {
                this.file.createNewFile();
                System.out.println("New file created: " + this.filePath);
            }
        } catch (IOException e) {
            System.out.println("An error occurred with creating new file: " + e.getMessage());
        }

        // load from file
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" \\| "); // split uses regular expression and using "|" means space.                
                // handle three cases
                if (arr[0].equals("[T]")) {
                    Todo todo = new Todo(arr[2]);
                    this.items.add(todo);
                } else if (arr[0].equals("[D]")) {
                    Deadline deadline = new Deadline(arr[2], arr[3]);
                    this.items.add(deadline);
                } else if (arr[0].equals("[E]")) {
                    Event event = new Event(arr[2], arr[3], arr[4]);
                    this.items.add(event);
                }

                // mark the status
                if (arr[1].equals("1")) {
                    this.items.get(this.items.size() - 1).mark();
                }
            }

            // print current item count 
            System.out.println("Loaded " + this.items.size() + " items from the saved list.");

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public void save_items() {
        // clear the current file content
        try {
            this.file.delete();
            this.file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred with creating new file: " + e.getMessage());
        }

        // write the content of the new item list
        try (FileWriter writer = new FileWriter(this.file)) {
            for (Todo item : this.items) {
                writer.write(item.to_save() + "\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
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
                    String[] arr = description.split("/");
                    Event event = new Event(arr[0], arr[1].substring(5), arr[2].substring(3));
                    items.add(event);
                    System.out.println("Got it. I've added this task:");
                    System.out.println(event);
                    System.out.println("Now you have " + items.size() + " tasks in the list.\n");

                } else {
                    throw new PaimonInvalidInputException(str);
                }

                // save the items
                this.save_items();
            }
        } catch (PaimonException e) {
            System.out.println("An error occurred: " + e.getMessage() + "\nExited with error.");
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
