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

    /**
     * Add an item to the list
     * 
     * @param task
     */
    public void add(Todo task) {
        this.items.add(task);
    }

    /**
     * Remove an item from the list
     * 
     * @param index index of the item to be removed, 0 indexed
     * @return the item that was removed
     */
    public Todo remove(int index) {
        return this.items.remove(index);
    }

    /**
     * Get the number of items in the list
     * 
     * @return number of items in the list
     */
    public int size() {
        return this.items.size();
    }

    /**
     * Mark an item as done
     * 
     * @param index index of the item to be marked as done, 0 indexed
     */
    public void mark(int index) {
        this.items.get(index).mark();
    }

    /**
     * Unmark an item as done
     * 
     * @param index index of the item to be unmarked, 0 indexed
     */
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
