package Model;

public class Person {
    /**
     * stores info for a single person object
     */
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

    /**
     * Constructor
     * @param personID
     * @param associatedUsername
     * @param firstName
     * @param lastName
     * @param gender
     * @param fatherID
     * @param motherID
     * @param spouseID
     */
    public Person(String personID, String associatedUsername, String firstName, String lastName, String gender, String fatherID, String motherID, String spouseID) {
        this.personID = personID;
        this.associatedUsername = associatedUsername;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.fatherID = fatherID;
        this.motherID = motherID;
        this.spouseID = spouseID;
    }
    public Person(String firstName, String lastName, String gender, String personID, String associatedUsername, String spouseID) {
        this.personID = personID;
        this.associatedUsername = associatedUsername;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.spouseID = spouseID;
    }

    public void setAssociatedUsername(String associatedUsername) {
        this.associatedUsername = associatedUsername;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setFatherID(String fatherID) {
        this.fatherID = fatherID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMotherID(String motherID) {
        this.motherID = motherID;
    }

    public void setSpouseID(String spouseID) {
        this.spouseID = spouseID;
    }

    public String getAssociatedUsername() {
        return associatedUsername;
    }

    public String getFatherID() {
        return fatherID;
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

    public String getMotherID() {
        return motherID;
    }

    public String getPersonID() {
        return personID;
    }

    public String getSpouseID() {
        return spouseID;
    }
    /**
     * Check to see if this instance equals another person object
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof Person) {
            Person oEvent = (Person) o;
            return oEvent.getPersonID().equals(getPersonID()) &&
                    oEvent.getAssociatedUsername().equals(getAssociatedUsername()) &&
                    oEvent.getFirstName().equals(getFirstName()) &&
                    oEvent.getLastName().equals(getLastName()) &&
                    oEvent.getGender().equals(getGender()) &&
                    oEvent.getFatherID().equals(getFatherID()) &&
                    oEvent.getMotherID().equals(getMotherID()) &&
                    oEvent.getSpouseID().equals(getSpouseID());
        } else {
            return false;
        }
    }
}
