package tests;

import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest{
    @Test
    public void DeleteUserTest() {
        int id=2;
        app.deleteUser(id);
    }
}
