package JunitTestCases;

import DataAccess.DataAccessException;
import Result.FillResult;
import Service.FillService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FillServiceTest {
    @Test
    public void fillPass() throws DataAccessException {
        FillService service = new FillService();
        FillResult result = service.fill("userName", 5);
        assertTrue(result.isSuccess());

    }
    @Test
    public void fillFail() throws DataAccessException{
        FillService service = new FillService();
        FillResult result = service.fill("userName", 0);
        assertTrue(result.isSuccess());
    }
}
