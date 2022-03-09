package Service;

import DataAccess.*;
import Model.User;
import Request.ClearRequest;
import Result.ClearResult;
import Result.FillResult;
import Request.FillRequest;

public class FillService {
    /**
     *     Populates the server's database with generated data for the specified username. The required "username" parameter must be a user already registered with the server. If there is any data in the database already associated with the given username, it is deleted.
     *     The optional "generations" parameter lets the caller specify the number of generations of ancestors to be generated, and must be a non-negative integer (the default is 4, which results in 31 new persons each with associated events).
     *     More details can be found in the earlier section titled Family History Information Generation;
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
     * a value that keeps track with how many generations need to be filled
     */
    private int generationNum = 0;
    /**
     *
     * method called, goes through the method several times, depending on generationNum. Uses while-loops and de-incrememnts (maybe for loops) each time it goes through
     * @param userName takes in a string as a parameter
     * @return FillRequest object returns a success or a failure with associated variables
     */
    public FillResult fill(String userName, int generationNum) throws DataAccessException {
        Database db = new Database();
        try {
            if (generationNum == 0) {
                FillResult result= new FillResult(false, "Error: Invalid username or generations parameter");
                return result;
            }
            db.openConnection();
            new EventDao(db.getConnection()).clear();
            new PersonDao(db.getConnection()).clear();
            new UserDao(db.getConnection()).clear();
            new AuthTokenDao(db.getConnection()).clear();
            PersonDao person = new PersonDao(db.getConnection());
            GenerateService gen =  new GenerateService();
            try {
                User user = new UserDao(db.getConnection()).find(userName);
                gen.generatePerson(user.getGender(), generationNum, person, userName);
                db.closeConnection(true);
                FillResult result = new FillResult(true,"Successfully added X persons and Y events to the database.");
                return result;
            } catch (DataAccessException ex) {
                ex.printStackTrace();
                db.closeConnection(false);
                FillResult result= new FillResult(false, "Error: Invalid username or generations parameter");
                return result;
            }
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            db.closeConnection(false);
            FillResult result= new FillResult(false, "Error: Internal Server Error");
            return result;
        }
    }


}
