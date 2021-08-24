package tests;

import helpers.ApplicationManager;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {
    ApplicationManager app;

    @BeforeTest
    public void beforeTest() throws IOException {
        app = new ApplicationManager();
        app.init();
        }
}
