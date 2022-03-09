package Service;

import DataAccess.*;
import Request.ClearRequest;
import Request.EventRequest;
import Result.ClearResult;
import Result.EventResult;

public class EventService {
    /**
     *   Returns ALL events for ALL family members of the current user. The current user is determined from the provided auth token.
     */

    /**
     *  takes in an event request, and then loads the program and returns the result of the load
     * @param r event request object
     * @return a event request object the tells if it was a failure or a success
     */
    public EventResult doService(EventRequest r) throws DataAccessException { //TODO: how to return gson.
        Database db = new Database();
        try {
            db.openConnection();
            new EventDao(db.getConnection()).getUserEvents(r.getUsername());
            db.closeConnection(true);
            EventResult result = new EventResult(true,"Clear succeeded");
            return result;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            EventResult result= new EventResult(false, "Error:");
            return result;
        }
    }
}
