/**
 * Represents an Event
 */
public class Event extends Task {

    protected String at;

    /**
     * Initialises an Event. Has type E and a event time.
     * @param description description of event
     * @param at event time
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.type = "E";
    }

    /**
     * Returns a new string format with "(at: )" inserted at the end of the printout
     *
     * @return String of event.
     */

    @Override
    public String toString() {
        return  super.toString() + " (at: " + at + ")";
    }

}