package Result;

public class EventIDResult {
    /**
     * stores attributes for EventIDResult
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
    public EventIDResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

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
