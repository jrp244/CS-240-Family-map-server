package Service;

import DataAccess.*;
import Request.ClearRequest;
import Result.ClearResult;

public class ClearService {
    /**
     *     Deletes ALL data from the database, including user, authtoken, person, and event data
     */
    /**
     * stores a fail or a success message
     */
    private String message;

    /**
     * stores whether it was a fail or a success of the operation
     */
    private boolean success;

    /**
     * Called on the object, and goes through and sets all the data to null from particular databases
     * @param request login request object
     * @return a login request object the tells if it was a failure or a success
     */
    public ClearResult doService(ClearRequest request) throws DataAccessException { //TODO: how to return gson.
        Database db = new Database();
        try {
            db.openConnection();
            new EventDao(db.getConnection()).clear();
            new PersonDao(db.getConnection()).clear();
            new UserDao(db.getConnection()).clear();
            new AuthTokenDao(db.getConnection()).clear();
            db.closeConnection(true);
            ClearResult result = new ClearResult(true,"Clear succeeded");
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            ClearResult result= new ClearResult(false, "Error: Internal server error");
            return result;
        }
    }
}
