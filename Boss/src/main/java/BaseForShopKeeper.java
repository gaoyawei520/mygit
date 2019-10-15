import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseForShopKeeper {
   private static AndroidDriver driver;

    @Test
    static AndroidDriver SetUp() throws MalformedURLException {

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
        desiredCapabilities.setCapability(MobileCapabilityType.UDID,"FFK0217504001734");//选择运行哪台机器,用UID号来区别,只有一台机器的话可以注释掉
        //desiredCapabilities.setCapability("automationName", "uiautomator2");
        //AndroidDriver driver = new AndroidDriver(new URL("http://197.168.14.39:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);//手动改端口为4713,默认端口则不需要修改
        //driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
        System.out.println("启动成功");

        return driver;



//        List<AndroidElement> textFieldsList=driver.findElementsByClassName("android.widget.EditText");
//        textFieldsList.get(0).sendKeys("17786410583");
//        textFieldsList.get(1).sendKeys("410583");
//        driver.findElementByXPath("//android.widget.Button[@text='登录']").click();
//        System.out.println(textFieldsList);
//        AndroidElement el1 = (AndroidElement) driver.findElementById("com.yijiupi.retail:id/userNameET");
//        el1.sendKeys("123");
//        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.EditText").sendKeys("123");

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
