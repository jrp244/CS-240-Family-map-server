package Result;

public class LoadResult {
    /**
     * stores attributes for LoadResult
     */
    /**
     * stores whether it failed or succeeded
     */
    private boolean success;
    /**
     * stores the a success or failure message
     */
    private String message;

    /**
     * Constructor
     * @param success
     * @param message
     */
    public LoadResult(boolean success, String message) {
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
