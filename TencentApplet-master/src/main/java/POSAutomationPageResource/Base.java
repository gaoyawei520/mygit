package POSAutomationPageResource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Environment;

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

        String processName = "com.tencent.mm:toolsmp";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Environment.DeviceName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Environment.PackageName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.LauncherUI");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "50");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS, true);
//        desiredCapabilities.setCapability("automationName", "uiautomator2");
        File chromedriver = new File("E:\\chromedriver2.26\\chromedriver.exe");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriver.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", processName);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        desiredCapabilities.setCapability("browserName", "");
//        AndroidDriver driver = new AndroidDriver(new URL("http://192.168.217.2:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filePath + "\\" + name + fileName));
    }
}
