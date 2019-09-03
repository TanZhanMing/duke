/**
 * The Task object class with containing Task description and Task status.
 */

public abstract class Task {

    protected String description;
    protected boolean isDone;

    /**
     * The constructor for the Deadline class.
     * @param description  Description of the task.
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * @return A tick or cross status icon depending on whether the task is completed
     */

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * A setter to set the Task object to 'done'
     */

    public void setDone(){
        isDone=true;
    }

    /**
     * An basic toString method.
     * @return String containing status and description.
     */

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * A getDetails method for {@link FileWriting}.
     * @return String containing status and description for writing.
     */

    public String getDetails() {return description + " @ " + isDone; }

}
