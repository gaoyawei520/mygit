import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static AndroidDriver driver;
    public static final String packagename="com.yijiupi.easychaintestpre"; //testpre(release)   test   pre  null

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
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,packagename);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjp.entrance.view.StartActivity");//testpre(release)   test   pre  null
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

    @Test(priority = 1)//登录
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElementById(packagename+":id/tv_ok").click();//确认 使用离线模式
        driver.findElementById(packagename+":id/userNameET").clear();//账号输入框
        driver.findElementById(packagename+":id/userNameET").sendKeys("17671607980");
        driver.findElementById(packagename+":id/userPwdET").clear();//密码输入框
        driver.findElementById(packagename+":id/userPwdET").sendKeys("607980");
        driver.findElementById(packagename+":id/loginBtn").click();//登录
        Thread.sleep(3000);
//        WebElement tuichu=driver.findElementByAndroidUIAutomator("text(\"退出登录\")");
//        Reporter.log("登录成功");

    }

    @Test(priority = 2)//散客收银,循环多一点次数
    public void shouyin2() throws InterruptedException {
        driver.findElementById(packagename+":id/btn_search").click();//搜索商品
        driver.findElementById(packagename+":id/tv_category").click();//搜索商品
        Thread.sleep(1000);
        for(int a=0;a<=1000;a++){
            if(a%2!=0) shouyin00();
            else shouyin01();
            System.out.println(a);
        }
    }

    public void shouyin00() throws InterruptedException{
        List<AndroidElement> shangpin=driver.findElementsById(packagename+":id/tv_product_name");//添加商品
        shangpin.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(2000);

    }

    public void shouyin01() throws InterruptedException{
        List<AndroidElement> shangpin=driver.findElementsById(packagename+":id/tv_product_name");//添加商品
        shangpin.get(2).click();
        shangpin.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(2000);
    }




}
