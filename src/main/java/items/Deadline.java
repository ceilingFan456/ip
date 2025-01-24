package items;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

public class Deadline extends Todo {
    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.by = LocalDateTime.parse(by, formatter);
    }

    @Override
    public String getType() {
        return "[D]";
    } 

    @Override
    public String to_save() {
        return getType() + " | " + (this.isDone ? "1" : "0") + " | " + getDescription() + " | " + this.by.format(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}