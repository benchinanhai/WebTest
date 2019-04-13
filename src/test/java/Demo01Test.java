import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo01Test {

    private WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type", "--start-maximized");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test
    private void test(){
        driver.get("https://testerhome.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("测试");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    @AfterMethod
    private void tearDown(){
        driver.close();
    }

}
