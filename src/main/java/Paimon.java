import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Paimon {
    private Scanner sc;
    private ArrayList<String> items;

    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
        this.items = new ArrayList<String>();
    }

    public void run() {
        // greeting message
        System.out.println("Hello! I'm Paimon");
        System.out.println("What can I do for you?\n");

        // loop variables
        boolean running = true;

        // main loop
        while (running) {
            // read a str from user
            String str = sc.nextLine();
            
            switch (str) {
                case "bye":
                    running = false;
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                
                case "list":
                    if (items.size() == 0) {
                        System.out.println("Empty list!");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println((i+1) + ". " + items.get(i));
                        }
                    }
                    System.out.println();
                    break;
            
                default:
                    System.out.println("added: " + str + "\n");
                    items.add(str);
                    break;
            }
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
