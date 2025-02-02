package paimon;

import paimon.commands.Command;
import paimon.parser.Parser;
import paimon.storage.Storage;
import paimon.tasklist.TaskList;
import paimon.ui.UI;

/** 
 * Paimon is a chatbot that keeps track of tasks for users. 
 * It has a TaskList that stores the tasks and storage that saves the files
 * and UI that interacts with the user.
 */
public class Paimon {
    private TaskList items;
    private Storage storage;
    private UI ui;

    /** 
     * Constructor for Paimon chatbot.
     */
    public Paimon() {
        this.items = new TaskList();
        this.storage = new Storage();
        this.ui = new UI();

        // load the items
        this.storage.populateTaskList(this.items);
    }

    /**
     * Runs the main logic loop of paimon.
     *
     */
    public void run() {
        this.ui.greet();
        boolean running = true;
        
        while (running) {
            String str = this.ui.readCommand();
            Command c = Parser.parse(str);
            running = c.execute(items, ui);
            this.storage.save(this.items);
        }
    }

    public static void main(String[] args) {
        new Paimon().run();
    }
}
