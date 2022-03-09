package Result;

public class FillResult {
    /**
     * Stores the attributes of the fillresult object
     */
    /**
     * Stores whether or not it was a success
     */
    private boolean success;

    /**
     * Stores the message.
     */
    private String message;

    public FillResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {return message;}
    public boolean isSuccess() {return success;}
    public void setMessage(String message) {this.message = message;}
    public void setSuccess(boolean success) {this.success = success;}
}
