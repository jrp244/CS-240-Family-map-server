package JunitTestCases;

import DataAccess.DataAccessException;
import Model.AuthToken;
import Request.ClearRequest;
import Result.ClearResult;
import Result.FillResult;
import Service.ClearService;
import Service.FillService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ClearServiceTest {
    @Test
    public void clearPass() throws DataAccessException {
        ClearRequest request = new ClearRequest("myName", "4567");
        ClearService service = new ClearService();
        ClearResult result = service.doService(request);
        assertNotNull(result);
    }
    @Test
    public void clearFail() throws DataAccessException {
        ClearRequest request = new ClearRequest("myName", "4567");
        ClearService service = new ClearService();
        ClearResult result = service.doService(request);
        assertNotNull(result);
    }
}

