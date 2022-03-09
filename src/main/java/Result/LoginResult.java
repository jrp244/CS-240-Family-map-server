package Result;

import java.util.UUID;

public class LoginResult {
    /**
     * Stores the attributes of the loginresult object
     */
    /**
     * Stores the authToken ID
     */
    private String authToken;

    /**
     * Stores the username
     */
    private String username;

    /**
     * Stores the password
     */
    private String password;

    /**
     * Stores the person ID
     */
    private String personID;

    /**
     * Stores whether or not it was a success
     */
    private boolean success;

    /**
     * Stores the message. A message from God asking me why I'm still in CS 240
     */
    private String message;

    /**
     * Constructor
     * @param success
     * @param message
     */
    public LoginResult(boolean success, String message, String password, String username)  {
        UUID uuid = UUID.randomUUID();
        this.success = success;
        this.message = message;
        this.username = username;
        this.password = password;
        this.authToken = uuid.toString();
        uuid = UUID.randomUUID();
        this.personID = uuid.toString();
    }

    public LoginResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getAuthToken() {return authToken;}
    public String getUsername() {return username;}
    public String getPersonID() {return personID;}
    public String getMessage() {return message;}
    public boolean isSuccess() {return success;}
    public void setAuthToken(String authToken) {this.authToken = authToken;}
    public void setUsername(String username) {this.username = username;}
    public void setPersonID(String personID) {this.personID = personID;}
    public void setMessage(String message) {this.message = message;}
    public void setSuccess(boolean success) {this.success = success;}
}
