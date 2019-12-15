package project.tests;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.internal.bind.util.ISO8601Utils;

public class TestBase {
    protected WebDriver driver;
    private final String BASE_URL = "https://ok.ru";

    @Before
    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void stop() {
//        driver.quit();
    }
}
