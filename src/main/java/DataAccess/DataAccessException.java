package DataAccess;

public class DataAccessException extends Exception {
    /**
     * Data access exception class for the DAOs classes.
     */

    /**
     * Constructor
     * @param message
     */
    DataAccessException(String message)
    {
        super(message);
    }

    DataAccessException()
    {
        super();
    }
}

