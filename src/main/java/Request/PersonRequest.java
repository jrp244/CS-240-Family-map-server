package Request;

public class PersonRequest {
    /**
     * Returns ALL family members of the current user.
     * The current user is determined by the provided authtoken
     */
    /**
     * stores a fail or a success message
     */
    private String message;

    /**
     * stores whether it was a fail or a success of the operation
     */
    private boolean success;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
