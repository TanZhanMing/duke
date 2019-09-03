/**
 * A subclass of the Task class.
 * @see Task
 */

public class ToDo extends Task {

    /**
     * The constructor for the ToDo class.
     * @param description  Description of the event task.
     */

    public ToDo(String description) {
        super(description);
    }

    /**
     * An overridden toString method.
     * @return String containing todo identifier, status and description.
     */

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * An overridden getDetails method for {@link FileWriting}.
     * @return String containing todo identifier, status and description for writing.
     */

    @Override
    public String getDetails() {return "T @ " + super.getDetails();}
}