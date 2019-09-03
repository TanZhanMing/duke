import java.util.Date;

/**
 * A subclass of the Task class with added variables 'by' and 'date'.
 * @see Task
 */

public class Deadline extends Task {

    protected String by;
    protected Date date;

    /**
     * The constructor for the Deadline class.
     * @param description  Description of the deadline task.
     * @param by Used to store a date or user-inputted temporal descriptions.
     */

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.date = DateParser.parseDate(by);
        if (date != null) { this.by = date.toString(); }
    }


    /**
     * An overridden toString method.
     * @return String containing deadline identifier, status, description and time.
     */

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * An overridden getDetails method for {@link FileWriting}.
     * @return String containing deadline identifier, status, description and time for writing.
     */
    @Override
    public String getDetails() {return "D @ " + super.getDetails() + " @ " + by; }
}