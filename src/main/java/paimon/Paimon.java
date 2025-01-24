package paimon;

import paimon.storage.Storage;
import paimon.tasklist.TaskList;
import paimon.parser.Parser;
import paimon.commands.Command;
import paimon.ui.UI;

public class Paimon {
    private TaskList items;
    private Storage storage;
    private UI ui;

    // constructor
    public Paimon() {
        this.items = new TaskList();
        this.storage = new Storage();
        this.ui = new UI();

        // load the items
        this.storage.populate_tasklist(this.items);
    }

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
