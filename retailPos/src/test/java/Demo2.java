import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static AndroidDriver driver;

    @BeforeClass
    public static AndroidDriver SetUp() throws MalformedURLException {

//        File f = new File("src");
//        File fs = new File(f,"08-28-10-17-45_易酒批零_retail_19_v1.0.19.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.yijiupi.retail");//testpre(release) test pre
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjp.entrance.view.StartActivity");//com.yjp.entrance.view.StartActivity
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        desiredCapabilities.setCapability("noReset", true);//false,true 是否重置软件,控制每次是否登录
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "160");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("ANDROID_UIAUTOMATOR", "uiautomator2");//升级为uiautomator2,Python用的
        //AndroidDriver driver = new AndroidDriver(new URL("http://192.168.217.2:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //点击首页的几个烦人按钮,如果不登录则不需要
        /*WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        allowButton.click();*/
        System.out.println("你妹的");
        return driver;

    }

    @AfterClass//关闭App
    public void tearDown() {
        //driver.closeApp();
    }

    @Test(priority = 1)
    public void test1() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElementById("com.yijiupi.retail:id/ed_ipnut").clear();
        driver.findElementById("com.yijiupi.retail:id/ed_ipnut").sendKeys("1");
        driver.findElementById("com.yijiupi.retail:id/btn_search").click();
        Reporter.log("你大爷的");

    }



}
