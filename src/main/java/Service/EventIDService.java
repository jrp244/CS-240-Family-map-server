package Service;

import DataAccess.*;
import Request.ClearRequest;
import Request.EventIDRequest;
import Result.ClearResult;
import Result.EventIDResult;


public class EventIDService {
    /**
     *         Returns the single Event object with the specified ID (if the event is associated with the current user).
     *         The current user is determined by the provided authtoken.
     */

    /**
     *  takes in an eventID request, and then loads the program and returns the result of the load
     * @param r eventID request object
     * @return a eventID request object the tells if it was a failure or a success
     */
    public EventIDResult doService(EventIDRequest r) throws DataAccessException { //TODO: how to return gson.
        Database db = new Database();
        try {
            db.openConnection();
            new EventDao(db.getConnection()).find(r.getEventID());
            db.closeConnection(true);
            EventIDResult result = new EventIDResult(true,"Clear succeeded");
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            EventIDResult result= new EventIDResult(false, "Error:");
            return result;
        }
    }
}
