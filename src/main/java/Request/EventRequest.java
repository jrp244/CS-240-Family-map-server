package Request;

import DataAccess.*;
import Result.ClearResult;

public class EventRequest {
    /**
     * Returns ALL events for ALL family members of the current user.
     * The current user is determined from the provided auth token.
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
     * username
     */
    private String username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
