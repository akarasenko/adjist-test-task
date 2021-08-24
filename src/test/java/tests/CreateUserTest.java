package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest{
    @Test
    public void CreateUserTest() throws IllegalAccessException {
        User user = new User()
                .withName("morpheus")
                .withJob("leader");

        User responseUser = app.createUser(user);
        Assert.assertEquals(responseUser, user);
    }
}
