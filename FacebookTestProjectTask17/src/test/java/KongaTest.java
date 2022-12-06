import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {

    //import the selenium WebDriver
    private WebDriver driver;

        //We want to automate the ordering flow of Konga as an existing customer

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your selected app URL (https://konga.com).
        driver.get("https://konga.com");
        Thread.sleep(5000);
        //3. Maximise the window
        driver.manage().window().maximize();
        //4. Get the page title
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/nav/div[2]/div[1]"));
        //5. Click on Sign-in/Login button to open the Signup page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/nav/div[1]")).click();
        Thread.sleep(10000);
    }

    @Test
    public void negativeSignup() throws InterruptedException {
        //6. Input your email address
        driver.findElement(By.id("username")).sendKeys("cyndysworld2000@yahoo.co.uk");
        //7. Input your password
        driver.findElement(By.id("password")).sendKeys("cinderella");
        //8.Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("abcde1234");
        //9. Click on the Sign in/login/Continue button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //10. Click on logout
        driver.findElement(By.xpath("")).click();
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
}
