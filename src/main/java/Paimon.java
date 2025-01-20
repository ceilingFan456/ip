import java.util.Scanner;

public class Paimon {
    private Scanner sc;

    // constructor
    public Paimon() {
        this.sc = new Scanner(System.in);
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
            
                default:
                    System.out.println(str + "\n");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        new Paimon().run();
    }
}
