public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = "?";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone(){
        this.isDone = true;
    }

    public void setType(String input) {
        this.type = input;
    }

    public String getType(){
        return type;
    }
    @Override
    public String toString() {
        return "[" + this.getType() + "][" + this.getStatusIcon() + "] " + this.getDescription();

    }


}

