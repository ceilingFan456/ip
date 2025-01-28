package paimon.items;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Todo {
    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    @Override 
    public String getType() {
        return "[E]";
    }

    @Override
    public String to_save() {
        return getType() + " | " + (this.isDone ? "1" : "0") + " | " + getDescription() + " | " + this.from.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm")) + " | " + this.to.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " to " + this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event e = (Event) obj;
            return super.equals(e) && this.from.equals(e.from) && this.to.equals(e.to);
        } else {
            return false;
        }
    }
}
