package Request;

import DataAccess.*;
import Result.ClearResult;

public class EventIDRequest {
    /**
     *     Returns the single Event object with the specified ID (if the event is associated with the current user).
     *     The current user is determined by the provided authtoken.
     */
    /**
     * stores a fail or a success message
     */
    private String message;

    /**
     * stores whether it was a fail or a success of the operation
     */
    private boolean success;
    /**
     * stores the ID for a specific event
     */
    private String eventID;
    /**
     * stores the associated username to the event
     */
    private String authenToken;
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

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
}
