package tests;

import Data.DataSource;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import Data.Setup;

import java.io.IOException;


public class LoginTest extends Setup {

    private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

    @Test(dataProvider = "user")
    public void openBrowser(String username, String password) throws IOException, InterruptedException {
        Thread.sleep(5000);
        WebDriver driver = InitializeDriver();
        //driver.get("http://retailop.release.yijiupidev.com/templates/loginNoCaptcha.html#/onlineOrderList.html");
        //driver.navigate().to("http://retailop.release.yijiupidev.com/templates/loginNoCaptcha.html#/onlineOrderList.html");
        driver.get(DataSource.url);
        Thread.sleep(3000);
        LoginPage loginPage = new LoginPage(driver);
       // Assert.assertEquals(loginPage.getSubmit().getText(),"登录 ");
        loginPage.getUsername().sendKeys(username);

        loginPage.getPassword().sendKeys(password);
        loginPage.getSubmit().click();
        logger.info("success login");
    }

    @DataProvider(name="user")//数据
    public Object[][] Users(){
        return new Object[][]{
                {"18827040216","123456"},
                {"cnblogs.com", "tankxiao"},
                {"tank","xiao"}
        };
    }

    @AfterMethod
    public void tearDown(){
        Setup.driver.close();
        Setup.driver = null;
    }
}
