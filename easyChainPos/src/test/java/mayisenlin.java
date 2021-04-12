import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class mayisenlin {
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
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.eg.android.AlipayGphone");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.eg.android.AlipayGphone.AlipayLogin");//com.yjpstorebossproject.MainActivity com.yijiupi.storebosspush-1
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
    public  void getEnergy() throws InterruptedException {

//        Element element=new Element(driver);
//        element.getdingdanchaxun().click();
//        //driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();
//        Thread.sleep(2000);
//        //driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();
//        element.getdingdanchaxun().click();
//        Reporter.log("你大爷的");
//        Thread.sleep(100);
//        driver.findElementByClassName("android.widget.ImageView").click();
//        Thread.sleep(1000);
//        element.shanghua();
//        Reporter.log("你妹的");
        //List<AndroidElement> button=driver.findElementsByClassName("android.widget.Button");
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"蚂蚁森林\")").click();
        clickEnergy();
        System.out.println("开始领取别人的能量");
        String a="我的大树养成记录";
        //String b=driver.findElementByClassName("android.widget.Button").getText();
        int c=1;
        while (driver.findElementByClassName("android.widget.Button").getText().equals(a)) {
            clickEnergy();
            c++;
        }
        System.out.println("收取能量"+c+"次");
        driver.findElementByAndroidUIAutomator("text(\"返回我的森林\")").click();






    }

    public static void clickEnergy() throws InterruptedException {
        PointOption point0 = PointOption.point(984, 1545);//翻页
        Thread.sleep(500);
        PointOption point1 = PointOption.point(218, 754);
        PointOption point2 = PointOption.point(341, 650);
        PointOption point3 = PointOption.point(473, 610);
        PointOption point4 = PointOption.point(612, 612);
        PointOption point5 = PointOption.point(746, 655);
        PointOption point6 = PointOption.point(852, 749);
        (new TouchAction(driver)).tap(point1).perform();
        (new TouchAction(driver)).tap(point2).perform();
        (new TouchAction(driver)).tap(point3).perform();
        (new TouchAction(driver)).tap(point4).perform();
        (new TouchAction(driver)).tap(point5).perform();
        (new TouchAction(driver)).tap(point6).perform();
        (new TouchAction(driver)).tap(point0).perform();//下一个

    }

    




}
