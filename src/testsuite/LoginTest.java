package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //set up base url
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “Admin” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        //Enter “admin123 password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        //Verify the ‘Dashboard’ text is display
        WebElement dashBoardText = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']//h6[text()='Dashboard']"));
        String text = dashBoardText.getText();
        System.out.println(text);
        Assert.assertEquals("Dashboard visible", text);
    }

    @After
    public void close() {
        closeBrowser();
    }
}