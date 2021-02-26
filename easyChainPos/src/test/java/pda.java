import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


/*
用到的数据
账号 17671607980  17671607988
条码   40394  手撕包 40395 凤爪 6954767423579 可乐
 6901028315425  红塔山



*/



public class pda {
    public static AndroidDriver driver;
    public static final String packagename="com.yjpeasychainpdaproject";
    public static final String hongtashan="6901028315425";
    public static final String shousibao="40394";
    @BeforeClass
    public static AndroidDriver SetUp() throws MalformedURLException {

//        File f = new File("src");
//        File fs = new File(f,"08-28-10-17-45_易酒批零_retail_19_v1.0.19.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        //desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,packagename);//testpre(release) test pre
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjpeasychainpdaproject.MainActivity");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        desiredCapabilities.setCapability("noReset", true);//false,true 是否重置软件,控制每次是否登录

        //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"127.0.0.1:7555");//选择运行哪台机器,用UID号来区别,只有一台机器的话可以注释掉

        desiredCapabilities.setCapability("sessionOverride",true);  //第二次运行可覆盖第一次的session,建议开启
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "160");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");//使用哪个自动化引擎,uiautomator2   appium
        //desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("ANDROID_UIAUTOMATOR", "uiautomator2");//升级为uiautomator2,Python用的
        //AndroidDriver driver = new AndroidDriver(new URL("http://192.168.217.2:4723/wd/hub"),desiredCapabilities);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //点击首页的几个烦人按钮,如果不登录则不需要
        /*WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        allowButton.click();*/
        System.out.println("启动成功");
        return driver;

    }

    @AfterClass//关闭App
    public void tearDown() {
        //driver.closeApp();
    }

    public AndroidElement denglu(){AndroidElement denglu= (AndroidElement) driver.findElementByAndroidUIAutomator("text(\"登录\")");   return  denglu; }

    @Test(priority = 1)//登录
    public void login() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("17671607988");
        MobileElement mima= (MobileElement) driver.findElementsByClassName("android.widget.EditText").get(1);//密码输入框

        //List <MobileElement> mima1=driver.findElementsByClassName("android.widget.EditText"); //第二种写法
        //mima1.get(1).click();

        mima.clear();
        mima.sendKeys("a709394");
        Thread.sleep(100);

        //driver.findElementByAndroidUIAutomator("text(\"登录\")").click();
        denglu().click();
        Thread.sleep(4000);
        driver.findElementByAndroidUIAutomator("text(\"易久批进货\")");
        Reporter.log("登录成功");
    }

    @Test(priority = 2)//切换店铺到4636
    public void qeihuandianpu() throws InterruptedException {
        driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("4636");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"拉萨4636客栈\")").click();
        //driver.findElementByAndroidUIAutomator("textContains(\"客栈\")").click();//需要双击差评
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"拉萨4636客栈\")");
        Reporter.log("切换到4636客栈");
    }



    @Test(priority = 3)//易久批进货页面点击
    public void yijiupijinhuo() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"易久批进货\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"易久批商城\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"返回易店宝\")").click();
        Thread.sleep(500);
        AndroidElement jinhuo=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"易久批进货\")").get(1);//页面中有2个易久批进货
        jinhuo.click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"返回\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"进货车\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"已提交\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"已发货\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"已取消\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"按单退货\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        shanghua();//上滑
        driver.findElementByAndroidUIAutomator("text(\"退货中\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"已退货\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        AndroidElement quxiao=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"已取消\")").get(1);//页面有2个已取消
        quxiao.click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"已拒绝\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"android\")").click();
        Thread.sleep(500);
        Reporter.log("易久批进货");
    }



    @Test(priority = 4)//直配进货,然后退货,同时到商品页面校验库存是否正确
    public void zhipeiliucheng() throws InterruptedException {
        //driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        //Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"库存和调拨\")").click();             //获取库存
        Thread.sleep(500);
        AndroidElement kucun=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"店铺商品库存\")") .get(1);//有两个相同的文本
        kucun.click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(hongtashan);
        driver.findElementByClassName("android.widget.EditText").click();
        enter();
        Thread.sleep(3000);
        String num=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.TextView[4]").getText();
        String nu=num.substring(5,num.length()-1);//截取库存字段
        double n=Double.parseDouble(nu);//转化为数值
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);

        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();                  //新增进货单
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"扫码收货\")").click();
        Thread.sleep(100);
        //driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击-,删除已有缓存商品
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"备注\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("没得备注");
        driver.findElementByAndroidUIAutomator("text(\"添加备注\")").click();

        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView[1]").click();//上传图片
        driver.findElementByAndroidUIAutomator("text(\"从手机相册选择\")").click();
        driver.findElementById("com.android.documentsui:id/icon_thumb").click();//选择第一张图片
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView[1]").click();//上传图片
        driver.findElementByAndroidUIAutomator("text(\"从手机相册选择\")").click();
        driver.findElementById("com.android.documentsui:id/icon_thumb").click();//选择第一张图片
        Thread.sleep(2000);

        driver.findElementByClassName("android.widget.EditText").clear();//添加商品
        driver.findElementByClassName("android.widget.EditText").sendKeys(hongtashan);
        driver.findElementByClassName("android.widget.EditText").click();
        enter();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("2");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("6");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"12.00\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);

        driver.findElementByAndroidUIAutomator("text(\"待提交\")").click();   //编辑再次添加商品并提交
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();//详情
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(shousibao);
        driver.findElementByClassName("android.widget.EditText").click();
        enter();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("3");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("6.66");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"19.98\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退出\")").click();
        Thread.sleep(500);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回

        AndroidElement daishenhe=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"待审核\")").get(1);     //确认入库
        daishenhe.click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();//详情
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认入库\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);



        driver.findElementByAndroidUIAutomator("text(\"按单退货\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"已完成入库\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成入库\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"退货原因\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"无理由退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.EditText[1]").sendKeys("1");
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");

        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"库存和调拨\")").click();//获取库存
        Thread.sleep(100);
        kucun.click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(hongtashan);
        enter();
        Thread.sleep(3000);
        String num1=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.TextView[4]").getText();
        String nu1=num1.substring(5,num1.length()-1);//截取库存字段
        double n1=Double.parseDouble(nu1);//转化为数值
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);


        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();//完成退货,查询退货后的库存并校验是否正确
        Thread.sleep(100);
        shanghua();
        driver.findElementByAndroidUIAutomator("text(\"已提交\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();//详情
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[2]").click();//详情
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认已退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();
        Thread.sleep(100);

        driver.findElementByAndroidUIAutomator("text(\"库存和调拨\")").click();//获取库存
        Thread.sleep(100);
        kucun.click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(hongtashan);
        enter();
        Thread.sleep(3000);
        String num2=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.TextView[4]").getText();
        String nu2=num2.substring(5,num2.length()-1);//截取库存字段
        double n2=Double.parseDouble(nu2);//转化为数值
        System.out.println(nu+" "+nu1+" "+nu2);
        System.out.println(n+" "+n1+" "+n2);
        System.out.println(num+" "+num1+" "+num2);
        Assert.assertTrue(n+2==n1,"进货后入库数量不正确");
        Assert.assertTrue(n1-1==n2,"退货后出库数量不正确");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        Reporter.log("直配流程");
    }

    //@Test(priority = 3)//仓配进货,然后退货
    public void 仓配进货2() throws InterruptedException {
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        /*driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击我的
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"退出登录\")").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("17671607988");
        MobileElement mima= (MobileElement) driver.findElementsByClassName("android.widget.EditText").get(1);//密码输入框
        mima.clear();
        mima.sendKeys("607988");
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"登录\")").click();
        Thread.sleep(4000);//换账号登录

        driver.findElementByAndroidUIAutomator("text(\"统仓统配\")").click();
        Thread.sleep(500);*/
        driver.findElementByAndroidUIAutomator("text(\"快捷进货\")").click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.TextView").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("店仓");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击+
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]").click();//点击去进货
        Thread.sleep(1000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]").click();//点击提交到仓库
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();//创建进货单
        Thread.sleep(3000);


        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击详情
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();//原单退货
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"退货原因\")").click();
        driver.findElementByAndroidUIAutomator("text(\"质量问题\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击+
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();//创建待提交的退货单
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"统仓统配\")");

        driver.findElementByAndroidUIAutomator("text(\"待提交\")").click();//提交退货单
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击详情
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(3000);
        String num0=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]").getText();//获取单号
        String num=num0.substring(5);//获取退货单号
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\""+"["+num+"]"+"\")");//校验退货完成
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"统仓统配\")");
        Reporter.log("仓配进货2");
    }






    //@Test(priority = 8)//供应商直配_扫码收货_保存进货单
    public void baocun1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"扫码收货\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("6954767423579");
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        driver.pressKey(keyEvent);
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("3");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").click();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("1.11");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"3.33\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();//供应商输入框
        driver.findElementByClassName("android.widget.EditText").sendKeys("西藏");
        driver.findElementByXPath("//android.view.ViewGroup/android.widget.ImageView[1]").click();//搜索
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("直配保存1");
    }

    //@Test(priority = 9)//供应商直配_扫码收货_提交进货单
    public void zuofei1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"待提交\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        //获取订单号
        String zuofei0=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        String zuofei=zuofei0.substring(5);//截取订单号  去掉开头5位开始截取,从第6位开始
        //System.out.println(zuofei);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(zuofei);
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        driver.pressKey(keyEvent);
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"已作废\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已作废\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        //driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\""+zuofei0+"\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("直配作废1");
    }



    //@Test(priority = 10)//供应商直配_扫码收货_提交进货单
    public void tijiao1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"扫码收货\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("40394");

        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        //keyEvent.withKey(AndroidKey.ENTER);
        driver.pressKey(keyEvent);
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击+增加数量
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();
        //driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击-减少数量
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击-减少数量
        driver.findElementByAndroidUIAutomator("text(\"2\")").click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("5");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").click();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("6.66");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"33.30\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();//未选择供应商保存被拦截
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(5000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退出\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("直配提交1");
    }



    //@Test(priority = 11)//供应商直配_待审核_完成
    public void ruku1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"待审核\")").click();
        Thread.sleep(3000);
//        driver.findElementByAndroidUIAutomator("text(\"待审核\")").click();
//        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"撤回\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"确认入库\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//这里会被防重复提交拦截,所以需要确认入库2次
        driver.findElementByAndroidUIAutomator("text(\"确认入库\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"退货\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("直配入库1");
    }

    //@Test(priority = 12)//供应商直配_扫码收货_保存
    public void baocun2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"扫码收货\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("40394");
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        //keyEvent.withKey(AndroidKey.ENTER);
        driver.pressKey(keyEvent);
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("3");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").click();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("6.66");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"19.98\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);

        driver.findElementByClassName("android.widget.EditText").clear();
//        driver.findElementByClassName("android.widget.EditText").sendKeys("40394");//相同的商品扫码会拦截,现在不会拦截
//        driver.pressKey(keyEvent);
        Thread.sleep(3000);

        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("40395");//添加第二个商品
        driver.pressKey(keyEvent);
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("2");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").click();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("7.77");//输入进货价格
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"15.54\")");//校验进货合计金额正确
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("直配保存2");
    }

    //@Test(priority = 13)//供应商直配_待提交_完成
    public void ruku2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"待提交\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认入库\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"退货\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
    }


    //@Test(priority = 15)//供应商直配_退货1  订单详情中退货 ,第一次退掉全部商品,第二次就无法继续退货,然后完成退货,
    public void tuihuo1() throws InterruptedException {
        //login(); driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();//调试专用
        driver.findElementByAndroidUIAutomator("text(\"已入库\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(3000);
        String num0=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        String num=num0.substring(5);//截取订单号,把前5位汉字去掉
        //System.out.println(num);
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();//数据不全无法提交
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击第一个+
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击第一个+
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击第一个+
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击第二个+
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.EditText[1]").click();//第二个输入框
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.EditText[1]").clear();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.EditText[1]").sendKeys("9");
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();//未选择退回原因无法提交
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("丑拒+1");
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);//
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);//返回列表

        //第二次退货
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);//搜索前面的订单
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        //driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"质量问题\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();//未填写数据无法提交
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"该商品暂无可退数量\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");

        //完成退货
        driver.findElementByAndroidUIAutomator("text(\"已提交\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\""+num+"\")");//校验这个是刚才建的退货单
        driver.findElementByAndroidUIAutomator("text(\"撤回\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"确认已退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("退货1");
    }


    //@Test(priority = 16)//供应商直配_退货2  按商品退货保存,编辑提交 并完成
    public void tuihuo2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"按商品退货\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"供应商\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"西藏供应商\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"退货原因\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"无理由退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"无理由退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("40394");
        enter();//模拟enter键
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("2");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").clear();//价格输入框
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.EditText[1]").sendKeys("6.66");
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();//新建退货完成
        Thread.sleep(3000);
        driver.findElementById(packagename+":id/layout_back_rn").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");

        WebElement daitijiao =(WebElement) driver.findElementsByAndroidUIAutomator("text(\"待提交\")").get(1);
        daitijiao.click();//提交并完成退货
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("40395");
        enter();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//删除
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//删除
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"确认已退货\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        String num0=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        String num=num0.substring(5);//截取订单号,把前5位汉字去掉
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);
        enter();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        //driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\""+num0+"\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("退货2");
    }



    //@Test(priority = 17)//供应商直配_退货2  按订单退货保存,然后作废
    public void tuihuo3() throws InterruptedException {
        //login(); driver.findElementByAndroidUIAutomator("text(\"供应商直配\")").click();//调试专用
        driver.findElementByAndroidUIAutomator("text(\"按单退货\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//点击第二个订单
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("丑拒+2");
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView[1]").click();//点击+增加数量
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();//保存退货单
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");


        WebElement daitijiao =(WebElement) driver.findElementsByAndroidUIAutomator("text(\"待提交\")").get(1);
        daitijiao.click();//作废
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        String num0=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        String num=num0.substring(5);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"已作废\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已作废\")").click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);
        enter();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        //driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//详情
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\""+num0+"\")");
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("TopTitle_backButton").click();//返回
        driver.findElementByAndroidUIAutomator("text(\"供应商直配\")");
        Reporter.log("退货3");
    }

    public void shanghua(){
        int width=driver.manage().window().getSize().width;

        int height=driver.manage().window().getSize().height;

        int y1 = height*2/3; //上滑的开始点，从y1开始也就是屏幕三分之二处
        int y2 = height*1/4; //上滑的结束点，到y2结束也就是屏幕的三分之一处
        TouchAction tAction = new TouchAction(driver);
        PointOption point1 = PointOption.point(width / 2, y1);//上滑的开始点
        PointOption point2 = PointOption.point(width / 2, y2);//上滑的结束点
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();

        //tAction.press(width/2,y1).waitAction(Duration.ofMillis(1000)).moveTo(width/2,y2).release().perform();
    }


    public static void enter(){
        KeyEvent keyEvent = new KeyEvent();
        keyEvent.withKey(AndroidKey.ENTER);//模拟enter键
        driver.pressKey(keyEvent);
    }


    









}
