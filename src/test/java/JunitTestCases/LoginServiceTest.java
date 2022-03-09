package JunitTestCases;

import DataAccess.DataAccessException;
import Request.LoginRequest;
import Result.LoginResult;
import Service.LoginService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {
    @Test
    public void loginPass() throws DataAccessException {
        LoginService service = new LoginService();
        LoginRequest request = new LoginRequest("username", "password");
        LoginResult result = service.login(request);
        assertTrue(result.isSuccess());
    }
    @Test
    public void loginFail() throws DataAccessException{
        LoginService service = new LoginService();
        LoginRequest request = new LoginRequest(null, null);
        LoginResult result = service.login(request);
        assertFalse(result.isSuccess());
    }
}