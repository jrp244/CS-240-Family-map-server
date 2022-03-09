package JunitTestCases;

import DataAccess.DataAccessException;
import Request.RegisterRequest;
import Result.RegisterResult;
import Service.RegisterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterServiceTest {
    @Test
    public void registerPass() throws DataAccessException {
        RegisterService service = new RegisterService();
        RegisterRequest request = new RegisterRequest("username", "password", "email", "firstName", "lastName", "m");
        RegisterResult result = service.register(request);
        assertTrue(result.isSuccess());
    }
    @Test
    public void registerFail() throws DataAccessException{
        RegisterService service = new RegisterService();
        RegisterRequest request = new RegisterRequest("username", "password", "email", "firstName", "lastName", "m");
        RegisterResult result = service.register(request);
        assertFalse(result.isSuccess());
    }
}
