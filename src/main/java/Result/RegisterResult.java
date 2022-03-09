package Result;

import java.util.UUID;

public class RegisterResult {
    /**
     * Stores the attributes of the registerresult object
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

    public RegisterResult(boolean success, String message, String username, String password, String email ,String firstName, String lastName, String gender, String personID) {
        this.username = username;
        UUID uuid = UUID.randomUUID();
        this.success = success;
        this.message = message;
        this.authToken = uuid.toString();

        this.personID = personID;
    }

    public RegisterResult(boolean success, String message) {
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
