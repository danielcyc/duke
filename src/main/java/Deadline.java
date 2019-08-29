public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.type = "D";
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
    public static String getBy(String input) throws InvalidDeadlineException{
        if (input.contains("/by")) {
            return input.substring(input.lastIndexOf("/by") + 4);
        }
        else {
            System.out.println("problem");
            throw new InvalidDeadlineException();
        }
    }
    public static String getDescription(String input) throws InvalidDeadlineException{
        if(input.equals("deadline")) {
            throw new InvalidDeadlineException();
        }
        else {
            return input.substring(input.lastIndexOf("deadline")+9, input.lastIndexOf(" /by"));

        }
    }
}