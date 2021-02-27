
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.Helpers.DriverManager;


import java.util.List;

public class SeleniumEasyTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
      DriverManager.endSession(driver);
    }

    @Test
    public void seleniumEasy_sendForm() {
        driver.navigate().to("https://www.seleniumeasy.com/test/input-form-demo.html");
        List<WebElement> elements = driver.findElements(By.cssSelector(".form-control"));

        for(int i = 0; i < elements.size(); i++) {
            elements.get(i).sendKeys("dummy text");
        }

        driver.findElement(By.cssSelector("input[value='yes']")).click();
        driver.findElement(By.cssSelector(".form-group:last-child div button"));
    }

    @Test
    public void seleniumEasy_tableDataSearch(){
        driver.navigate().to("https://www.seleniumeasy.com/test/table-search-filter-demo.html ");
        List<WebElement> elements = driver.findElements(By.cssSelector(".table-hover tbody tr:nth-child(1) td"));

        for (int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i).getText());
        }
    }

    @Test
    public void seleniumEasy_columnDataSearch(){
        driver.navigate().to("https://www.seleniumeasy.com/test/table-search-filter-demo.html ");

        List<WebElement> elements = driver.findElements(By.cssSelector(".table-hover tbody tr td:nth-child(3)"));

        System.out.println(driver.findElement(By.cssSelector("thead tr th:nth-child(3)")).getText());
        for (int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i).getText());
        }

    }

    @Test
    public void seleniumEasy_tableDataSearch_filterListedUsers(){
        driver.navigate().to("https://www.seleniumeasy.com/test/table-search-filter-demo.html ");
        driver.findElement(By.cssSelector(".btn-filter")).click();
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("markino");
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Zieko");

        List<WebElement> elements = driver.findElements(By.cssSelector(".filterable table tbody tr"));

        for (int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i).getText());
        }

    }

    @Test
    public void cesarSchool_performActions(){
        driver.navigate().to("https://www.cesar.school/");
        driver.findElement(By.cssSelector("input[name='NomeCompleto']")).sendKeys("markino");
        WebElement element = driver.findElement(By.cssSelector("#menu-item-15614"));
        element.click();
        List<WebElement> elements = element.findElements(By.cssSelector(".sub-menu li "));
        elements.get(1).click();

        WebElement span = driver.findElement(By.cssSelector("a[itemprop='item'] span"));
        WebElement minhaConta = driver.findElement(By.cssSelector("a[href*='minha-conta']"));

        System.out.println(span.getAttribute("itemprop"));
        System.out.println(minhaConta.isDisplayed());
        System.out.println(minhaConta.isEnabled());

    }

}