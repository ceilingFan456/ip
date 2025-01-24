package tasklist;

import java.util.ArrayList;

import items.Todo;

public class Tasklist implements Iterable<Todo> {
    private ArrayList<Todo> items;

    public Tasklist() {
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

    @Override
    public java.util.Iterator<Todo> iterator() {
        return this.items.iterator();
    }
}
