package boss;

import base.*;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import org.apache.poi.ss.formula.functions.T;
import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class test extends setup{
    private AndroidDriver driver;//全局变量

    @BeforeClass//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = setup.SetUp();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
    }

    @AfterClass//关闭App
    public void tearDown() {
        //driver.closeApp();
    }
}
