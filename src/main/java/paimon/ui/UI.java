package paimon.ui;

import java.util.Scanner;

public class UI {
    private Scanner sc;

    public UI() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Prints the greeting msg.
     * 
     * @return void
     */
    public void greet() {
        // greeting message
        System.out.println("Hello! I'm Paimon");
        System.out.println("What can I do for you?\n");    
    }

    /**
     * Reads the a str command from the user.
     * 
     * @return String
     */
    public String readCommand() {
        System.out.print("\nPlease enter a command: ");
        return sc.nextLine();
    }

    /**
     * Prints the str to terminal.
     * 
     * @param str
     */
    public void print(Object str) {
        System.out.println(str);
    }
    
    /** 
     * Prints the goodbye message.
     */
    public void goodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
