package DataAccess;

import Model.Event;
import Model.Person;
import Model.User;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonDao {
    /**
     * interacts with the person database after being called from the service classes
     */
    /**
     * person object created to be used by the class
     */
    private Person username;
    /**
     * called on object. deletes person that method is called on
     */
    public void delete() {
    }

    /**
     * gets the person object associated with the username
     * @param username that stores the username
     * @return person object that is associated with the username
     */
    public Person getPerson(String username) {return null;}

    /**
     * takes username and finds all the people from that username
     * @param username that stores the username
     * @return and array of person objects associated with username
     */
    public Person[] getPeople(String username) throws DataAccessException {
        ResultSet rs = null;
        String sql = "SELECT * FROM Person WHERE associatedUsername = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            int i = 0;
            ArrayList<Person> personArray = new ArrayList<>();
            while (rs.next()) {
                personArray.set(i, new Person(rs.getString("personID"), rs.getString("associatedUsername"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"),
                        rs.getString("fatherID"), rs.getString("motherID"), rs.getString("spouseID")));
                i++;
            }
            return (Person[]) personArray.toArray();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding person");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * Whenever we want to make a change to our database we will have to open a connection and use
     */
    private final Connection conn;

    /**
     * Constructor
     * @param conn
     */
    public PersonDao(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * gets the connection
     * @return
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * called on object. clears the person database
     */
    public void clear () throws DataAccessException {
        try (Statement stmt = conn.createStatement()){
            String sql = "DELETE FROM Person";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new DataAccessException("SQL Error encountered while clearing tables");
        }
    }
    /**
     *Calls a person object and adds that event to the person database
     */
    public void insert(Person event) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO Person (personID, associatedUsername, firstName, lastName, gender, " +
                "fatherID, motherID, spouseID) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            stmt.setString(1, event.getPersonID());
            stmt.setString(2, event.getAssociatedUsername());
            stmt.setString(3, event.getFirstName());
            stmt.setString(4, event.getLastName());
            stmt.setString(5, event.getGender());
            stmt.setString(6, event.getFatherID());
            stmt.setString(7, event.getMotherID());
            stmt.setString(8, event.getSpouseID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccessException("Error encountered while inserting into the database");
        }
    }
    /**
     * takes the personID string object and finds it in the database, returning the object found
     * @param personID
     * @return person object
     */
    public Person find(String personID) throws DataAccessException {
        Person person;
        ResultSet rs = null;
        String sql = "SELECT * FROM Person WHERE PersonID = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                person = new Person(rs.getString("personID"), rs.getString("associatedUsername"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"),
                        rs.getString("fatherID"), rs.getString("motherID"), rs.getString("spouseID"));
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error encountered while finding person");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
