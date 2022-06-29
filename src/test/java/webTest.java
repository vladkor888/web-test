import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class webTest {

    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    private WebDriver driver;

@BeforeAll
public static void setUpAll() {
    System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
}

@BeforeEach
    public void setUp() {
    driver = new ChromeDriver();
}

@AfterEach
    public void tearDown() {
    driver.quit();
    driver = null;
}

@Test
    public void shouldSendForm() {
    driver.get("http://localhost:9999");
    driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Мария Лесникова");
    driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79512164264");
    driver.findElement(By.cssSelector(".checkbox__box")).click();
    driver.findElement(By.cssSelector(".button")).click();
    String actualText = driver.findElement(By.cssSelector(".paragraph")).getText().trim();
    String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
    assertEquals(expected, actualText);
}

}
