package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class OrangeHrmLive {

    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static  String browser = "Edge";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //launch the browser
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }


        //open the URL into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //print the title of the page
        System.out.println("Print the title of the page: " + driver.getTitle());

        //print the current URL
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //print the page source
        System.out.print("Print the page source: " + driver.getPageSource());

        //click on Forgot your password link
        WebElement forgotPasswordLink = driver.findElement(By.className("orangehrm-login-forgot-header"));
        //WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password? "));
        forgotPasswordLink.click();

        //print the current URL
        System.out.println(driver.getCurrentUrl());

        //navigate back to the login page
        driver.navigate().back();
        System.out.println("Navigate back to the login page: " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page: " + driver.getCurrentUrl());

        //enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        //enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //click on login button
        WebElement login = driver.findElement(By.xpath("//button[@type ='submit']"));
        login.click();

        //closing the browser automatically
        driver.quit();

    }
}