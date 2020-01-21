import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AndroidDriver driver;

    public static AndroidDriver SetUp() throws MalformedURLException {

//        File f = new File("src");
//        File fs = new File(f,"08-28-10-17-45_易酒批零_retail_19_v1.0.19.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,Environment.DeviceName);
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,Environment.PackageName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjp.entrance.view.StartActivity");//com.yjp.entrance.view.StartActivity
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"197.168.14.232:5555");//选择运行哪台机器,用UID号来区别,只有一台机器的话可以注释掉
        desiredCapabilities.setCapability("noReset", true);//false,true 是否重置软件,控制每次是否登录
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "160");
        desiredCapabilities.setCapability("sessionOverride",true);  //第二次运行可覆盖第一次的session,建议开启
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("ANDROID_UIAUTOMATOR", "uiautomator2");//升级为uiautomator2

        //AndroidDriver driver = new AndroidDriver(new URL("http://192.168.217.2:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        //点击首页的几个烦人按钮,如果不登录则不需要
        /*WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        allowButton.click();*/
        return driver;
    }

    public String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());//获取当前系统时间
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置日期格式
        String retStrFormatNowDate = sdFormatter.format(nowTime);//使当前系统时间用到模板是设置好的模板
        return retStrFormatNowDate;//返回这个设置好的时间模板
    }

    public void screenShot(String name) throws IOException {
        String filePath = "E:\\YJPLPIC";
        String fileName = refFormatNowDate() + ".png";
        //File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath + "\\" + name + fileName));
    }
}
