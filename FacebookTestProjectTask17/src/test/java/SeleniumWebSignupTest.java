import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com).
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("koroye1");
        //6. Input an email address on the mail field
        driver.findElement(By.id("user_email")).sendKeys("koroye1@yahoo.com");
        //7.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("abcde1234");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickuser1Item() throws InterruptedException {
        //9. Click on user1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (using Phython with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[34]/div/div/div[1]/a")).click();
        Thread.sleep(5000);

        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}
