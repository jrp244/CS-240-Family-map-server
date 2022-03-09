package Model;

public class User {
    /**
     * base class for a user object. stores all the vars
     */
    /**
     * username associated with the user
     */
    private String username;
    /**
     * user's password
     */
    private String password;
    /**
     * user's email
     */
    private String email;
    /**
     * user's first name
     */
    private String firstName;
    /**
     * user's last name
     */
    private String lastName;
    /**
     * user's gender
     */
    private String gender;
    /**
     * user's connected personID
     */
    private String personID;

    /**
     * Constructor
     * @param personID
     * @param username
     * @param firstName
     * @param lastName
     * @param gender
     * @param email
     * @param password
     */
    public User(String username, String password, String email, String firstName, String lastName, String gender, String personID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonID() {
        return personID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    /**
     * Check to see if this instance equals another user object
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof User) {
            User oEvent = (User) o;
            return oEvent.getPersonID().equals(getPersonID()) &&
                    oEvent.getUsername().equals(getUsername()) &&
                    oEvent.getFirstName().equals(getFirstName()) &&
                    oEvent.getLastName().equals(getLastName()) &&
                    oEvent.getGender().equals(getGender()) &&
                    oEvent.getEmail().equals(getEmail()) &&
                    oEvent.getPassword().equals(getPassword());
        } else {
            return false;
        }
    }
}
