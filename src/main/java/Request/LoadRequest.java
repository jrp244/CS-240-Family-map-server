package Request;

import Model.Event;
import Model.Person;
import Model.User;

public class LoadRequest {
    /**
     * stores variables used for each LoadRequest
     */
    /**
     * user array created to be used in the load function
     */
    private User[] users;
    /**
     * person array created to be used in the load function
     */
    private Person[] persons;
    /**
     * event array created to be used in the load function
     */
    private Event[] events;

    /**
     * Constructor
     * @param users
     * @param persons
     * @param events
     */
    public LoadRequest(User[] users, Person[] persons, Event[] events) {
        this.users = users;
        this.persons = persons;
        this.events = events;
    }

    public Event[] getEventArray() {
        return events;
    }

    public Person[] getPersonArray() {
        return persons;
    }

    public User[] getUserArray() {
        return users;
    }

    public void setEventArray(Event[] events) {
        this.events = events;
    }

    public void setPersonArray(Person[] persons) {
        this.persons = persons;
    }

    public void setUserArray(User[] users) {
        this.users = users;
    }
}
