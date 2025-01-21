public class Event extends Todo {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override 
    public String getType() {
        return "[E]";
    }

    @Override
    public String to_save() {
        return getType() + " | " + (this.isDone ? "1" : "0") + " | " + getDescription() + " | " + this.from + " | " + this.to;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (at: " + this.from + " to " + this.to + ")";
    }
}
