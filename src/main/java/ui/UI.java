package ui;

import java.util.Scanner;

public class UI {
    private Scanner sc;

    public void greet() {
        // greeting message
        System.out.println("Hello! I'm Paimon");
        System.out.println("What can I do for you?\n");    
    }

    public String readCommand() {
        System.out.print("\nPlease enter a command: ");
        return sc.nextLine();
    }

    public void print(Object str) {
        System.out.println(str);
    }
    
    public void goodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
