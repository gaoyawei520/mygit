package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class setup {
    public static AndroidDriver driver;

    @Test
    public static AndroidDriver SetUp() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");//控制是模拟器还是真机模拟器是emulator
        //desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"5.1.1");//安卓版本
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2,***
        //desiredCapabilities.setCapability("systemPort","8200");//
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.yijiupi.storeboss");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjpstorebossproject.MainActivity");//com.yjpstorebossproject.MainActivity com.yijiupi.storebosspush-1
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        desiredCapabilities.setCapability("noReset", true);//控制每次是否登录,每次是否重启APP
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "160");
        desiredCapabilities.setCapability("resetKeyboard", true);//控制是否使用appium键盘
        desiredCapabilities.setCapability("unicodeKeyboard",true);//控制是否安装自带输入法

        //desiredCapabilities.setCapability("automationName", "uiautomator2");
        //AndroidDriver driver = new AndroidDriver(new URL("http://197.168.14.39:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
        System.out.println("启动成功");

        return driver;}
}
