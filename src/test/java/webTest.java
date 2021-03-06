import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class webTest {


// //   private WebDriver driver;
//
//@BeforeAll
//public static void setUpAll() {
//    System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
//}
//
//@BeforeEach
//    public void setUp() {
//    driver = new ChromeDriver();
//}
//
//@AfterEach
//    public void tearDown() {
//    driver.quit();
//    driver = null;
//}

//@Test
//    public void shouldSendForm() {
//    driver.get("http://localhost:9999");
//    driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Мария Лесникова");
//    driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79512164264");
//    driver.findElement(By.cssSelector(".checkbox__box")).click();
//    driver.findElement(By.cssSelector(".button")).click();
//    String actualText = driver.findElement(By.cssSelector(".paragraph")).getText().trim();
//    String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
//    assertEquals(expected, actualText);
//}

    @Test
    void test3() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Корнилов Владислав");
        $("[data-test-id=phone] input").setValue("+78123564578");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно " +
                "отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}
