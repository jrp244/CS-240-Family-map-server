package Result;

import Model.Person;

public class PersonResult {
    /**
     * Returns an array of all family members of the current user
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
     * person array for json
     */
    private Person[] people;

    /**
     * Constructor
     * @param success
     * @param message
     */
    public PersonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public PersonResult(boolean success, String message, Person[] people) {
        this.success = success;
        this.message = message;
        this.people = people;
    }

    /**
     * Array of all family members of the current user.
     */
    private Person[] personArray;
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
