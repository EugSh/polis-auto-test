package project.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoBotsBase {
    protected WebDriver driver1;
    protected WebDriver driver2;
    private final String BASE_URL = "https://ok.ru";

    @Before
    public void init() {
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get(BASE_URL);
        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get(BASE_URL);
    }

    @After
    public void stop() {
        driver1.quit();
        driver2.quit();
        System.out.println("out");
    }
}
