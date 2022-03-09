package Request;

public class PersonIDRequest {
    /**
     *     Returns the single Person object with the specified ID (if the person is associated with the current user).
     *     The current user is determined by the provided authtoken.
     */

    /**
     * stores the associated username to the event
     */
    private String username;
    /**
     * stores the person ID that the event is connected to
     */
    private String personID;
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
     * stores the ID for the father
     */
    private String fatherID;
    /**
     * stores the ID for the mother
     */
    private String motherID;
    /**
     * stores the ID for the spouse
     */
    private String spouseID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
