package paimon.storage;

import java.io.File;
import java.io.IOException;

import paimon.items.Todo;
import paimon.tasklist.TaskList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import paimon.items.Deadline;
import paimon.items.Event;

public class Storage {
    private final File file;
    private final String filePath = "data/items.txt";

    public Storage() {
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
    }

    // load into item list from file.
    public void populate_tasklist(TaskList items) {
        // load from file
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" \\| "); // split uses regular expression and using "|" means space.                
                // handle three cases
                if (arr[0].equals("[T]")) {
                    Todo todo = new Todo(arr[2]);
                    items.add(todo);
                } else if (arr[0].equals("[D]")) {
                    Deadline deadline = new Deadline(arr[2], arr[3]);
                    items.add(deadline);
                } else if (arr[0].equals("[E]")) {
                    Event event = new Event(arr[2], arr[3], arr[4]);
                    items.add(event);
                }

                // mark the status
                if (arr[1].equals("1")) {
                    items.get(items.size() - 1).mark();
                }
            }

            // print current item count 
            System.out.println("Loaded " + items.size() + " items from the saved list.");

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    
    // take item list and save everything to file.
    public void save(TaskList items) {
        // clear the current file content
        try {
            this.file.delete();
            this.file.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred with creating new file: " + e.getMessage());
        }

        // write the content of the new item list
        try (FileWriter writer = new FileWriter(this.file)) {
            for (Todo item : items) {
                writer.write(item.to_save() + "\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
