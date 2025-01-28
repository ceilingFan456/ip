package paimon.tasklist;

import java.util.ArrayList;

import paimon.items.Todo;

public class TaskList implements Iterable<Todo> {
    private ArrayList<Todo> items;

    public TaskList() {
        this.items = new ArrayList<>();
    }

    public Todo get(int index) {
        return this.items.get(index);
    }

    public void add(Todo task) {
        this.items.add(task);
    }

    public Todo remove(int index) {
        return this.items.remove(index);
    }

    public int size() {
        return this.items.size();
    }

    public void mark(int index) {
        this.items.get(index).mark();
    }

    public void unmark(int index) {
        this.items.get(index).unmark();
    }

    /**
     * Find tasks that contain the keyword
     * 
     * @param keyword the keyword to search for
     * @return a TaskList only containing the tasks that contain the keyword
     */
    public TaskList find(String keyword) {
        TaskList found = new TaskList();
        for (Todo task : this.items) {
            if (task.getDescription().contains(keyword)) {
                found.add(task);
            }
        }
        return found;
    }

    public void list_items() {
        if (this.items.size() == 0) {
            System.out.println("Empty list!");
        } else {
            for (int i = 0; i < this.items.size(); i++) {
                System.out.println((i + 1) + ". " + this.items.get(i));
            }
        }
        System.out.println();
    }

    @Override
    public java.util.Iterator<Todo> iterator() {
        return this.items.iterator();
    }
}
