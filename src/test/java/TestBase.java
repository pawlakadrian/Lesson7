import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    WebDriver driver;

    static ChromeOptions options = new ChromeOptions();

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "src" + File.separator + "download");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
