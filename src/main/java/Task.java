/**
 * Represents a Task
 */

public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;

    /**
     * Initialises a task.
     * @param description description of task
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = "?";
    }

    /**
     * returns the status of the task. returns a tick if done, cross if not done.
     * @return String a tick or cross depending on status of task
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * returns description of task
     * @return String Description of task keyed in by user
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks task as done. Changes the tasks attribute isDone from false to true.
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * Sets tasks type.
     * @param input a string that describes the the task specifically
     */
    public void setType(String input) {
        this.type = input;
    }

    /**
     * Returns the type of the task.
     * @return String a string that describes the task
     */
    public String getType(){
        return type;
    }

    /**
     * Returns a string formatted to have the task's type appended at the end when printed
     * @return String a formatted string with task's type
     */
    @Override
    public String toString() {
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription();

    }


}

