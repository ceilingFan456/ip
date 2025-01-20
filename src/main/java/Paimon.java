import java.util.Scanner;
import java.util.ArrayList;

public class Paimon {
    private Scanner sc;
    private ArrayList<String> items;
    private ArrayList<Boolean> isDone;

    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
        this.items = new ArrayList<String>();
        this.isDone = new ArrayList<Boolean>();
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
            
            // end the program
            if (str.equals("bye")) {
                running = false;
                System.out.println("Bye. Hope to see you again soon!");
            
            // list the items 
            } else if (str.equals("list")) {
                if (items.size() == 0) {
                    System.out.println("Empty list!");
                } else {
                    for (int i = 0; i < items.size(); i++) {
                        String status = isDone.get(i) ? "[X]" : "[ ]";
                        System.out.println((i + 1) + ". " + status + " " + items.get(i));
                    }
                }
                System.out.println();

            } else if (str.startsWith("mark")) {
                String num = str.substring(5);
                int index = Integer.parseInt(num) - 1;
                isDone.set(index, true);

                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[X] " + items.get(index) + "\n");
            
            } else if (str.startsWith("unmark")) {
                String num = str.substring(7);
                int index = Integer.parseInt(num) - 1;
                isDone.set(index, false);

                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("[ ] " + items.get(index) + "\n");

            } else {
                System.out.println("added: " + str + "\n");
                items.add(str);
                isDone.add(false);
            }
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
