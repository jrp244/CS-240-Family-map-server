package Request;

public class FillRequest {
    /**
     * stores variables used for a specific fillRequest object
     */
    /**
     * stores the username for this account
     */
    private String username;
    /**
     * stores the password needed for this account
     */
    private String password;

    /**
     * Constructor
     * @param username
     * @param password
     */
    public FillRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
