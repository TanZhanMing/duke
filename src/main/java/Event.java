import java.util.Date;

/**
 * A subclass of the Task class with added variables 'at' and 'date'.
 * @see Task
 */

public class Event extends Task {

    protected String at;
    protected Date date;

    /**
     * The constructor for the Deadline class.
     * @param description  Description of the event task.
     * @param at Used to store a date or user-inputted temporal descriptions.
     */

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.date = DateParser.parseDate(at);
        if (date != null) { this.at = date.toString(); }
    }

    /**
     * An overridden toString method.
     * @return String containing event identifier, status, description and time.
     */

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    /**
     * An overridden getDetails method for {@link FileWriting}.
     * @return String containing event identifier, status, description and time for writing.
     */

    @Override
    public String getDetails() {return "E @ " + super.getDetails() + " @ " + at; }
}