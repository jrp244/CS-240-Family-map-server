package Model;

public class Event {
    /**
     * Base class for event that stores the vars used in the program
     */
    /**
     * stores the ID for a specific event
     */
    private String eventID;
    /**
     * stores the associated username to the event
     */
    private String associatedUsername;
    /**
     * stores the person ID that the event is connected to
     */
    private String personID;
    /**
     * latitude of the event
     */
    private float latitude;
    /**
     * Longitude of the event
     */
    private float longitude;
    /**
     * country the event is in
     */
    private String country;
    /**
     * city the event is in
     */
    private String city;
    /**
     * what type of event it is
     */
    private String eventType;
    /**
     * what year the event is in
     */
    private int year;
    /**
     * Constructor
     * @param eventID
     * @param username
     * @param personID
     * @param latitude
     * @param longitude
     * @param country
     * @param city
     * @param eventType
     * @param year
     */
    public Event(String eventID, String username, String personID, float latitude, float longitude,
                 String country, String city, String eventType, int year) {
        this.eventID = eventID;
        this.associatedUsername = username;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }
    /**
     * Get the Event ID
     */
    public String getEventID() {
        return eventID;
    }


    /**
     * Set the Event ID
     */
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }


    /**
     * Get the user's name
     */
    public String getUsername() {
        return associatedUsername;
    }


    /**
     * Set the user's name
     */
    public void setUsername(String username) {
        this.associatedUsername = username;
    }


    /**
     * Get the Person's ID
     */
    public String getPersonID() {
        return personID;
    }


    /**
     * Set the Person's ID
     */
    public void setPersonID(String personID) {
        this.personID = personID;
    }


    /**
     * Get the Latitude
     */
    public float getLatitude() {
        return latitude;
    }


    /**
     * Set the Latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


    /**
     * Get the Longitude
     */
    public float getLongitude() {
        return longitude;
    }


    /**
     * Set the Longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    /**
     * Get the Country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the City
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get Event Type
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Set the Event Type
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * Get the Year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the Year
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * Check to see if this instance equals another event object
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof Event) {
            Event oEvent = (Event) o;
            return oEvent.getEventID().equals(getEventID()) &&
                    oEvent.getUsername().equals(getUsername()) &&
                    oEvent.getPersonID().equals(getPersonID()) &&
                    oEvent.getLatitude() == (getLatitude()) &&
                    oEvent.getLongitude() == (getLongitude()) &&
                    oEvent.getCountry().equals(getCountry()) &&
                    oEvent.getCity().equals(getCity()) &&
                    oEvent.getEventType().equals(getEventType()) &&
                    oEvent.getYear() == (getYear());
        } else {
            return false;
        }
    }
}

