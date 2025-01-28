package paimon.items;

public class Todo {
    protected String description;
    protected boolean isDone;

    public Todo(String description) {
        this.description = description;
        this.isDone = false;
    }

    // fixed functions 
    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return this.isDone ? "[X]" : "[ ]";
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    // functions that differ between classes
    public String getType() {
        return "[T]";
    }

    public String to_save() {
        return getType() + " | " + (this.isDone ? "1" : "0") + " | " + getDescription();
    }

    @Override
    public String toString() {
        return getType() + getStatus() + " " + getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Todo) {
            Todo t = (Todo) obj;
            return this.description.equals(t.description) && this.isDone == t.isDone;
        } else {
            return false;
        }
    }
}
