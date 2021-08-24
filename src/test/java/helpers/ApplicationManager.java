package helpers;

import models.CreateUserResponse;
import models.User;
import models.getSingleUserResponse.SingleUserResponse;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private Properties properties;

    public void init() throws IOException {
        properties = new Properties();
        FileReader file = new FileReader(new File(String.format("src/test/resources/%s.properties", System.getProperty("target", "local"))));
        properties.load(file);
    }

    public User getUserById(int id) {
        String url = this.properties.getProperty("baseUrl") + "/users/" + Integer.toString(id);
        ApiRequest request = new ApiRequest();
        request.withType("get").withUrl(url).execute();

        Assert.assertEquals(request.getStatusCode(), 200);

        return request.getResponseBody().as(SingleUserResponse.class).getUserFromResponse();
    }

    public User createUser(User user) throws IllegalAccessException {
        String url = this.properties.getProperty("baseUrl") + "/users/";
        ApiRequest request = new ApiRequest();
        request.withType("post")
                .withUrl(url)
                .withBody(user.toJsonString())
                .execute();

        Assert.assertEquals(request.getStatusCode(), 201);

        return request.getResponseBody().as(CreateUserResponse.class).getUserFromResponse();
    }

    public void deleteUser(int id) {
        String url = this.properties.getProperty("baseUrl") + "/users/" + Integer.toString(id);
        ApiRequest request = new ApiRequest();
        request.withType("delete")
                .withUrl(url)
                .execute();

        Assert.assertEquals(request.getStatusCode(), 204);
    }
}
