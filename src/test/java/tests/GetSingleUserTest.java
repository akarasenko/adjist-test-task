package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserTest extends BaseTest {
    @Test
    public void GetSingleUserTest() {
        int id = 2;

        User user = new User()
                        .withFirstName("Janet")
                        .withLastName("Weaver")
                        .withEmail("janet.weaver@reqres.in")
                        .withAvatar("https://reqres.in/img/faces/2-image.jpg");

        User responseUser = app.getUserById(id);
        Assert.assertEquals(responseUser, user);
    }
}
