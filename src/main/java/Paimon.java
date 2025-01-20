import java.util.Scanner;
import java.util.ArrayList;

public class Paimon {
    private Scanner sc;
    private ArrayList<Todo> items;

    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
        this.items = new ArrayList<Todo>();
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
                        System.out.println((i + 1) + ". " + items.get(i));
                    }
                }
                System.out.println();

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

            } else if (str.startsWith("todo")) {
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
                System.out.println("Sorry i dont understand what you have asked: " + str);
            }
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
