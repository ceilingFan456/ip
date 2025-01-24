import exceptions.PaimonException;
import storage.Storage;
import tasklist.TaskList;
import ui.UI;
import parser.Parser;
import commands.Command;

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

        // loop variables
        boolean running = true;

            // main loop
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
