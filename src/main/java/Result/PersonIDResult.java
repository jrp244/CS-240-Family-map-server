package Result;

public class PersonIDResult {
    /**
     * Returns a person object with a specified ID
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
     * unique identifier for a person
     */
    private String personID;
    /**
     * what username put in the person
     */
    private String associatedUsername;
    /**
     * stores the firstName of the person
     */
    private String firstName;
    /**
     * stores the last name of the person
     */
    private String lastName;
    /**
     * stores the gender for the person
     */
    private String gender;
    /**
     * Constructor
     * @param success
     * @param message
     */
    public PersonIDResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public PersonIDResult(boolean success, String message, String personID, String associatedUsername, String firstName, String lastName, String gender) {
        this.success = success;
        this.message = message;
        this.personID = personID;
        this.associatedUsername = associatedUsername;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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
