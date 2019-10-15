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

public class Demo1 {
    public static AndroidDriver driver;

    @BeforeClass
    public static AndroidDriver Setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//隐式等待
        return driver;
    }

    @AfterClass//关闭App
    public void tearDown() {
        //driver.closeApp();
    }

    @Test(priority = 1)
    public  void dingdanchaxun() throws InterruptedException {
        Element element=new Element(driver);
        element.getdingdanchaxun().click();
        //driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();
        Thread.sleep(2000);
        //driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();
        element.getdingdanchaxun().click();
        Reporter.log("你大爷的");
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(1000);
        element.shanghua();
        Reporter.log("你妹的");

    }




}
