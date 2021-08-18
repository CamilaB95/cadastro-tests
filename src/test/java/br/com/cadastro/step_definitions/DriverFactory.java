package br.com.cadastro.step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @Before
    public void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        wait  = new WebDriverWait(driver, 10);
    }

    @After
    public void afterClass() throws Exception {
        driver.quit();
    }

}