package Result;
import Model.Event;
public class EventResult {
    /**
     * Returns ALL events for ALL family members of the current user.
     * The current user is determined from the provided auth token.
     */
    /**
     * stores whether it failed or succeeded
     */
    private boolean success;
    /**
     * stores the success or failure message
     */
    private String message;

    /**
     * Constructor
     * @param success
     * @param message
     */
    public EventResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * Array of events for all family members of the current user.
     */
    private Event[] eventArray;
    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}
