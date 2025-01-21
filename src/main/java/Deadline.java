class Deadline extends Todo {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getType() {
        return "[D]";
    } 

    @Override
    public String to_save() {
        return getType() + " | " + (this.isDone ? "1" : "0") + " | " + getDescription() + " | " + this.by;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + this.by + ")";
    }
}