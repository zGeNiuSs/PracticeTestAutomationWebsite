import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLogin {
    private static final Logger log = LoggerFactory.getLogger(TestLogin.class);
    WebDriver driver = null;
    SoftAssert soft = null;
    LoginPage login = null;

    @BeforeTest
    public void beforeTest(){
        driver = new EdgeDriver();
        soft = new SoftAssert();
        login = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethods(){
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void test1(){
        login.userName().sendKeys("student");
        login.password().sendKeys("Password123");
        login.submitButton().click();
        String actualStatus = login.loginStatus().getText();
        String expectStatus = "Logged In Successfully";
        String actualUrl = driver.getCurrentUrl();
        String expectUrl = "practicetestautomation.com/logged-in-successfully/";
//        System.out.println(actualUrl);
//        System.out.println(actualStatus);
        soft.assertTrue(actualUrl.contains(expectUrl), "URL Error");
        soft.assertTrue(actualStatus.contains(expectStatus), "Failed Login");
        soft.assertAll();
    }

    @Test
    public void test2(){
        login.userName().sendKeys("incorrectUser");
        login.password().sendKeys("Password123");
        login.submitButton().click();
        login.messageError().isDisplayed();
        String actualMessage = login.messageError().getText();
        String expectMessage = "Your username is invalid!";

        soft.assertTrue(login.messageError().isDisplayed(), "error message is not displayed");
        soft.assertTrue(actualMessage.contains(expectMessage), "Failed Login");
        soft.assertAll();
    }

    @Test
    public void test3(){
        login.userName().sendKeys("student");
        login.password().sendKeys("incorrectPassword ");
        login.submitButton().click();
        login.messageError().isDisplayed();
        String actualMessage = login.messageError().getText();
        String expectMessage = "Your password is invalid!";

        soft.assertTrue(login.messageError().isDisplayed(), "error message is not displayed");
        soft.assertTrue(actualMessage.contains(expectMessage), "Failed Login");
        soft.assertAll();
    }

    @AfterTest
    public void afterTest() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

}
