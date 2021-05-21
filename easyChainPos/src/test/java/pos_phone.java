import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;





/*
  使用到的具体信息
  登录账号 17671607988
  店铺参数 vip收费开启   支持负库存收银 未交接班
  次数卡会员 17671607988
  称重条码  4039400310001375
//  会员id = 169542813580194562 ,大力出奇迹 ,vip会员
//  会员手机号 18871182396      普通会员
  商品助记码 40394,手撕包
  商品助记码g ml kkkl nfsq
  设置折扣的类目,饮料-碳酸饮料,饮料-水未设置折扣
  称重条码 4039400310001375   3.1元
  运行前请确认这些数据有效
  */


public class pos_phone {
    public static AndroidDriver driver;
    public static final String packagename="com.yijiupi.easychainMobile"; // testpre (release)   test   pre  null
    public static final String account="17671607988";
    public static final String password="709394";
    public static final String weixinPayCode="134684755012345678";
    public static final String amountVip="17671607988";
    public static final String cardNo="9168880008000070";
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
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.yjp.entrance.view.StartActivity");//com.yjp.entrance.view.StartActivity
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        desiredCapabilities.setCapability("noReset", true);//false,true 是否重置软件,控制每次是否登录
        desiredCapabilities.setCapability("sessionOverride",true);  //第二次运行可覆盖第一次的session,建议开启
        //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"0123456789ABCDEF");//选择运行哪台机器,用UID号来区别,只有一台机器的话可以注释掉

        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "160");//在下一个命令执行之前的等待最大时长。单位为秒。
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//使用哪个自动化引擎,uiautomator2   appium
        //desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("ANDROID_UIAUTOMATOR", "uiautomator2");//升级为uiautomator2,Python用的
        File chromedriver = new File("C:\\Users\\gaoyawei\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriver.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        String processName = "com.tencent.mm:toolsmp";
        options.setExperimentalOption("androidProcess", processName);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        desiredCapabilities.setCapability("browserName", "");

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

    public AndroidElement denglu(){AndroidElement denglu= (AndroidElement) driver.findElementByAndroidUIAutomator("text(\"登录\")");   return  denglu;}




    @Test(priority = 1)//登录
    public void login() throws InterruptedException {
        Thread.sleep(2000);
        //driver.findElementById(packagename+":id/btn_cancel").click();//关闭升级窗口
        driver.findElementById(packagename+":id/userNameET").clear();//账号输入框
        driver.findElementById(packagename+":id/userNameET").sendKeys(account);
        driver.findElementById(packagename+":id/userPwdET").clear();//密码输入框
        driver.findElementById(packagename+":id/userPwdET").sendKeys(password);
        denglu().click();
        //driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textContains(\"登\")").click();
        //AndroidElement denglu= (AndroidElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"登\")");
        //driver.findElementById(packagename+":id/loginBtn").click();//登录
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"退出登录\")");
        Reporter.log("登录成功");

    }


    //@Test(priority = 2)//切换环境为pre,兼容性测试专用
    public void checkout() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"修改密码\")").click();
        Thread.sleep(1000);
        PointOption point0 = PointOption.point(960, 664);
        PointOption point1 = PointOption.point(952, 23);
        PointOption point2 = PointOption.point(956, 910);
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        for (int i=1;i<=15;i++){
        (new TouchAction(driver)).tap(point0).perform();}
        Thread.sleep(500);
        (new TouchAction(driver)).press(point1).waitAction(waitOptions).moveTo(point2).release().perform();//下拉状态栏
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"开发者调试常驻\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"切换系统API地址\")").click();
        Thread.sleep(500);
        driver.findElementById(packagename+":id/ed_code").clear();
        driver.findElementById(packagename+":id/ed_code").sendKeys("999");
        driver.findElementByAndroidUIAutomator("text(\"生产预发布\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定切换\")").click();
        Thread.sleep(500);
        login();
    }

    //@Test(priority = 3)//交接班1
    public void jiaojieban1() throws InterruptedException {
//        driver.findElementByAndroidUIAutomator("text(\"报表\")").click();
//        driver.findElementByAndroidUIAutomator("text(\"销售订单\")").click();
//        Thread.sleep(1000);
//        driver.findElementByAndroidUIAutomator("text(\"复制\")").click();
//        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//执行时间
//        AndroidElement shurukuang= (AndroidElement) driver.findElementByClassName("android.widget.EditText");
//        new TouchAction(driver).longPress(new LongPressOptions().withElement(ElementOption.element(shurukuang))).waitAction(waitOptions).perform();
//
//        driver.context("WEBVIEW_1");
//        Thread.sleep(1000);
//        driver.findElementByAndroidUIAutomator("text(\"粘贴\")").click();





        driver.findElementByAndroidUIAutomator("text(\"交接班\")").click();
        Thread.sleep(2000);
        try{
        driver.findElementByAndroidUIAutomator("text(\"交班\")").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"回到主页\")").click();}
        catch (Exception e)
        {
            System.out.println("上次已交班");
            driver.findElementById(packagename+":id/ll_close").click();//关闭
        }
        finally {
            Thread.sleep(1000);
        Reporter.log("交接班1");}
    }

    @Test(priority = 4)//散客现金收银
    public void shouyin1() throws InterruptedException {
        Thread.sleep(100);
        //List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        driver.findElementByAndroidUIAutomator("text(\"收银\")").click();
        //driver.findElementById(packagename+":id/tv_product_name").click();//添加商品
        driver.findElementById(packagename+":id/ed_ipnut").clear();//输入框清空
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();//搜索
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件g
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("散客现金收银");
    }

    @Test(priority = 5)//散客购买散称商品
    public void shouyin2() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("40394");//搜索商品,搜索条件ssb,手撕包
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementById(packagename+":id/number_tv").click();//点击数量输入框
        driver.findElementById(packagename+":id/codeET").sendKeys("2.36");//2.36
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"查VIP优惠\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("textContains(\"VIP会员本次可节省\")");
        //driver.findElementById(packagename+":id/iv_close").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"我知道了\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("散客购买散称商品");
    }

    @Test(priority = 6)//购买vip次数卡
    public void buyVip() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"购买VIP\")").click();
        driver.findElementById(packagename+":id/rt_input_card").sendKeys(cardNo);
        driver.findElementById(packagename+":id/rt_input").sendKeys(amountVip);
        driver.findElementByAndroidUIAutomator("textContains(\"次卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"下一步\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("resourceId(\""+packagename+":id/tv\").text(\"现金\")").click();
        //driver.findElementByAndroidUIAutomator("resourceId(\""+packagename+":id/tv_title\").text(\"支付\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认支付\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        Reporter.log("购买次数卡");
    }




    @Test(priority = 7)//vip会员现金付款  先用组合支付失败,再换现金付款
    public void shouyin3() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        //driver.findElementByAndroidUIAutomator("text(\"手机号\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"选择\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/et_online_pay").clear();
        driver.findElementById(packagename+":id/et_online_pay").sendKeys("0.01");
        driver.findElementById(packagename+":id/et_pay_code").sendKeys(weixinPayCode);
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("resourceId(\""+packagename+":id/tv\").text(\"现金\")").click();
        driver.findElementByAndroidUIAutomator("text(\"查询\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("会员现金收银");
    }

    @Test(priority = 8)//vip会员称重条码收银,      扫描已打印好的称重条码  4039400310001375
    public void shouyin4() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("4039400310001375");//扫描称重条码
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        //driver.findElementByAndroidUIAutomator("text(\"VIP会员\")").click();
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        //driver.findElementByAndroidUIAutomator("text(\"手机号\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("resourceId(\""+packagename+":id/tv_real_amount\").text(\"3.10\")").click();//校验价格为3.10,同时触发收款操作
        //driver.findElementById(packagename+":id/rl_xianjin").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("vip会员称重条码收银");
    }


    //@Test(priority = 9)//收银改价功能 ,第一个商品不支持改价,第二次输错密码,第三次正确改价然后再改价
    public void shouyin5() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("nfsq");//扫描助记码
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("textContains(\"农夫山泉\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"改价\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();//提示不支持改价,确认

        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("kkkl");//扫描助记码
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("textContains(\"可口可乐\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"改价\")").click();
        Thread.sleep(4000);
        driver.findElementById(packagename+":id/et_number").clear();
        driver.findElementById(packagename+":id/et_number").sendKeys("66666");//输入密码
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(1000);
        driver.findElementById(packagename+":id/et_number").clear();
        driver.findElementById(packagename+":id/et_number").sendKeys("709394");//密码错误,重新输入密码
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"6折\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"改价\").resourceId(\""+packagename+":id/btn_modify_price\")").click();//第三次改价,这里有个改价标签有干扰,所以需要加上id
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"5折\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        //driver.findElementById(packagename+":id/rl_xianjin").click();//现金
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("收银改价");
    }

    @Test(priority = 10)//散称商品页面
    public void shouyin6() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        //driver.findElementByAndroidUIAutomator("text(\"手机号\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"散称商品\")").click();
        Thread.sleep(1000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("40396");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementById(packagename+":id/clearRL").click();//清空
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        //driver.findElementByAndroidUIAutomator("text(\"返回收银台\")").click();
        driver.findElementById(packagename+":id/ll_close").click();//返回收银台

        driver.findElementByAndroidUIAutomator("text(\"散称商品\")").click();//添加第一个散称商品
        Thread.sleep(1000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ssb");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementById(packagename+":id/ll").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementById(packagename+":id/number_tv").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("0.123");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"散称商品\")").click();//添加第二个散称商品
        Thread.sleep(1000);
        AndroidElement shangpin2=(AndroidElement)driver.findElementsById(packagename+":id/ll").get(1);
        shangpin2.click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("0.231");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        //driver.findElementById(packagename+":id/number_tv").click();
        Thread.sleep(100);

        driver.findElementById(packagename+":id/ed_ipnut").clear();//添加第三个散称商品
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("40394");
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("0.312");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        //driver.findElementById(packagename+":id/number_tv").click();
        Thread.sleep(100);

        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        //driver.findElementById(packagename+":id/rl_xianjin").click();//现金
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("散称商品页面");

    }



    @Test(priority = 17)//vip会员银行卡付款
    public void shouyin15() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        //driver.findElementByAndroidUIAutomator("text(\"手机号\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"散客\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("kkkl");//搜索商品
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"选择\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("nfsq");//搜索商品
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"选择\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/number_tv").click();
        driver.findElementById(packagename+":id/codeET").sendKeys("3");
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        driver.findElementByAndroidUIAutomator("text(\"刷新价格优惠\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"银行卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("vip会员余额付款");
    }

    @Test(priority = 18)//vip会员收银更改商品数量
    public void shouyin16() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(amountVip);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//确定
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//点击+增加数量
        String num =driver.findElementById(packagename+":id/number_tv").getText();
        Assert.assertEquals(num,"2","添加商品数量不正确");
//        if (num=="2") {Reporter.log("添加商品数量正确");}
//        else {Reporter.log("添加商品数量不正确");}
        driver.findElementById(packagename+":id/number_tv").click();
        driver.findElementById(packagename+":id/codeET").sendKeys("6");
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        driver.findElementByAndroidUIAutomator("className(\"android.widget.TextView\").text(\"6\")");//校验第一个商品数量是否正确
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        List<AndroidElement> zengjia=driver.findElementsById(packagename+":id/add_number_iv");//+按钮
        zengjia.get(0).click();
        zengjia.get(0).click();
        zengjia.get(0).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"4\")");//校验第二个商品数量是否正确
        List<AndroidElement> jianshao=driver.findElementsById(packagename+":id/sub_number_iv");
        jianshao.get(0).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"3\")");//校验第二个商品数量是否正确
        driver.findElementByAndroidUIAutomator("text(\"查VIP优惠\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("textContains(\"VIP会员本次可节省\")");
        //driver.findElementById(packagename+":id/iv_close").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"我知道了\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("收银台更改商品数量");
    }


    //@Test(priority = 19)//收银添加赠品
    public void shouyin17() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();   //第一次添加商品
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("40394");//搜索商品,搜索条件ssb,手撕包
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementById(packagename+":id/number_tv").click();//点击数量输入框
        driver.findElementById(packagename+":id/codeET").sendKeys("1.12");//1.12
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementById(packagename+":id/ed_ipnut").clear();   //第二次添加商品
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"选择\")").click();
        driver.findElementById(packagename+":id/add_number_iv").click();//点击+增加数量

        driver.findElementByAndroidUIAutomator("text(\"赠品\")").click();//添加赠品
        driver.findElementById(packagename+":id/et_number").sendKeys("654321");//输入错误的密码
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        driver.findElementById(packagename+":id/et_number").clear();
        driver.findElementById(packagename+":id/et_number").sendKeys("709394");//输入正确的密码
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(500);
        //driver.findElementById(packagename+":id/codeET").sendKeys("40394");//输入条码
        driver.findElementByClassName("android.widget.EditText").sendKeys("40394");//输入条码
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementById(packagename+":id/number_tv").click();//点击数量输入框
        driver.findElementById(packagename+":id/codeET").sendKeys("1.12");//1.12
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"赠品\")").click();//添加赠品
        driver.findElementById(packagename+":id/codeET").sendKeys("ml");//助记码
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"选择\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        //driver.findElementById(packagename+":id/rl_xianjin").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();

        driver.findElementByAndroidUIAutomator("text(\"赠品\")").click();//添加赠品
        driver.findElementById(packagename+":id/iv_close").click();//关闭,只有密码框有xx
        Reporter.log("添加赠品");
    }

    @Test(priority = 20)//挂单
    public void guadan() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件g
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"挂单\")").click();//挂单
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验操作成功没
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验操作成功没
        Thread.sleep(1000);
        Reporter.log("挂单");
    }

    @Test(priority = 21)//解单并现金付款,shouyin8
    public void jiedan() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"解单\")").click();//解单
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByXPath("//android.widget.TextView[@resource-id='"+packagename+":id/tv' and @text='现金']").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");//校验操作成功没
        Reporter.log("解单");
    }


    //@Test(priority = 22)//删除
    public void delete() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件g
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"删除(F3)\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
//        driver.findElementById(packagename+":id/iv_close").click();//关闭    旧版适用
        driver.findElementById(packagename+":id/ll_top").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"删除(F3)\")").click();
        driver.findElementByAndroidUIAutomator("text(\"删除(F3)\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验删除成功
        Reporter.log("删除");
    }

    @Test(priority = 23)//清空
    public void empty() throws InterruptedException {
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"清空\")").click();
        driver.findElementById(packagename+":id/tv_cancel").click();//取消
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        //driver.findElementById(packagename+":id/iv_close").click();//关闭  旧版适用
        driver.findElementById(packagename+":id/ll_top").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"清空\")").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验删除成功
        Reporter.log("清空");
    }

    @Test(priority = 24)//更多
    public void more() throws InterruptedException {
        //driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        //driver.findElementByAndroidUIAutomator("text(\"激活赠送实体卡\")").click();
        //driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        driver.findElementByAndroidUIAutomator("text(\"查询会员\")").click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"会员管理\")");
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        driver.findElementByAndroidUIAutomator("text(\"VIP服务订单\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"VIP服务订单\")").click();
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        //driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        //driver.findElementByAndroidUIAutomator("text(\"库存查询\")").click();
        //Thread.sleep(2000);
        //driver.findElementByAndroidUIAutomator("text(\"店铺商品库存\")");
        //driver.findElementById(packagename+":id/ll_close").click();//关闭
        //Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退货订单\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"退货订单\")");
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        Thread.sleep(100);
        Reporter.log("更多");
    }


    @Test(priority = 25)//订单部分退款,退款需要输入订单号后6位进行,所以需要截取订单号
    public void tuihuo1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"销售订单\")").click();
        Thread.sleep(3000);
        WebElement dingdan =(WebElement) driver.findElementsById(packagename+":id/orderNumTV").get(0);//
        String num =dingdan.getText();//获取订单号
        System.out.println(num);
        String nu=num.substring(num.length()-6);//获取后6位订单号
//        WebElement back= (WebElement) driver.findElementsByClassName("android.widget.ImageView").get(1);//关闭订单查询页面
//        back.click();//关闭订单查询页面
        driver.findElementById(packagename+":id/ll_close").click();//关闭订单查询页面
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        //WebElement tuikuan=(WebElement) driver.findElementsByAndroidUIAutomator("text(\"退款\")").get(1);
        //tuikuan.click();//未勾选无法退货
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(100);
        WebElement gouxuan= (WebElement) driver.findElementsById(packagename+":id/selectAllIV").get(0);
        gouxuan.click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();//未选择数量无法退货
        Thread.sleep(100);
        driver.findElementById(packagename+":id/add_number_iv").click();//增加数量
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/tv_cancel").click();//取消
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        Thread.sleep(100);
        driver.findElementById(packagename+":id/tv_cancel").click();//取消
        Thread.sleep(100);
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        driver.findElementById(packagename+":id/et_confirm").sendKeys("666666");//输入错误的校验码
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        driver.findElementById(packagename+":id/et_confirm").clear();//输入正确的退款校验码
        driver.findElementById(packagename+":id/et_confirm").sendKeys(nu);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(3000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000);
        String num1=driver.findElementById(packagename+":id/productNumTV").getText();//通过可退数量校验功能是否正确
        Assert.assertEquals(num1,"0","退款数量不正确");
//        if (num1.equals("0")) {Reporter.log("退款数量正确");}
//        else {Reporter.log("退款数量不正确");}
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ll_close").click();//关闭-退货页面
        Reporter.log("退单1");

    }

    @Test(priority = 26)//整单全退,退款需要输入订单号后6位进行,所以需要截取订单号
    public void tuihuo2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"销售订单\")").click();
        Thread.sleep(3000);
        WebElement dingdan =(WebElement) driver.findElementsById(packagename+":id/orderNumTV").get(1);//选择第二个订单号
        String num =dingdan.getText();//获取订单号
        System.out.println(num);
        String nu=num.substring(num.length()-6);//获取后6位订单号
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        //WebElement tuikuan=(WebElement) driver.findElementsByAndroidUIAutomator("text(\"退款\")").get(1);
        //tuikuan.click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        //driver.findElementById(packagename+":id/printReceiptSwitchBtn").click();//勾选打印
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        driver.findElementById(packagename+":id/et_confirm").clear();//输入正确的退款校验码
        driver.findElementById(packagename+":id/et_confirm").sendKeys(nu);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(3000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        Thread.sleep(100);
        Reporter.log("退单2");
    }

    @Test(priority = 27)//部分退货,然后全退,退款需要输入订单号后6位进行,所以需要截取订单号
    public void tuihuo3() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"销售订单\")").click();
        Thread.sleep(2000);
        WebElement dingdan =(WebElement) driver.findElementsById(packagename+":id/orderNumTV").get(2);//第三个订单
        String num =dingdan.getText();//获取订单号
        System.out.println(num);
        String nu=num.substring(num.length()-6);//获取后6位订单号
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        driver.findElementByAndroidUIAutomator("text(\"退货\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);//第一次退款
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        List<AndroidElement> gouxuan= driver.findElementsById(packagename+":id/selectAllIV");//勾选
        gouxuan.get(0).click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/add_number_iv").click();//点击+
        //WebElement tuikuan=(WebElement) driver.findElementsByAndroidUIAutomator("text(\"退款\")").get(1);
        //tuikuan.click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        driver.findElementById(packagename+":id/et_confirm").clear();//输入正确的退款校验码
        driver.findElementById(packagename+":id/et_confirm").sendKeys(nu);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);//第二次退款
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        gouxuan.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//点击+
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        //driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        driver.findElementById(packagename+":id/et_confirm").clear();//输入正确的退款校验码
        driver.findElementById(packagename+":id/et_confirm").sendKeys(nu);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(3000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);//第三次退款
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        //driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确定退款
        driver.findElementById(packagename+":id/et_confirm").clear();//输入正确的退款校验码
        driver.findElementById(packagename+":id/et_confirm").sendKeys(nu);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys(num);//第四次退款,校验前面退款成功
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/ll_close").click();//关闭
        Thread.sleep(100);
        //driver.findElementById(packagename+":id/ll_close").click();//关闭-收银页面
        Reporter.log("退单3");
    }

    @Test(priority = 28)//vip服务退单
    public void refundVip() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        driver.findElementByAndroidUIAutomator("text(\"VIP服务订单\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部卡费\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        String num=driver.findElementByAndroidUIAutomator("textContains(\"订单号\")").getText();
        String nu=num.substring(num.length()-6);
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/ll_close").click();//关闭页面

    }

    //@Test(priority = 29)//锁定
    public void suoding() throws InterruptedException {
        driver.findElementById(packagename+":id/ll_lock").click();//点击锁定
        driver.findElementById(packagename+":id/psw_et").sendKeys("1234");//输入密码
        driver.findElementById(packagename+":id/ok_btn").click();//登录
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"清空\")").click();
        driver.findElementById(packagename+":id/ok_btn").click();//登录
        Thread.sleep(100);
        driver.findElementById(packagename+":id/psw_et").sendKeys(password);//输入密码
        driver.findElementById(packagename+":id/ok_btn").click();//登录
        Thread.sleep(1000);
        Reporter.log("锁定");
    }


    @Test(priority = 30)//交接班
    public void jiaojieban2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"更多\")").click();
        driver.findElementByAndroidUIAutomator("text(\"交接班\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"交班\")").click();
        driver.findElementById(packagename+":id/tv_cancel").click();//取消
        driver.findElementByAndroidUIAutomator("text(\"交班\")").click();
        Thread.sleep(1000);
        driver.findElementById(packagename+":id/tv_ok").click();//确定
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"退出登录\")").click();
        login();
        Reporter.log("交接班2");
    }




    //@Test(priority = 31)
    //离线收银 1下载商品然后关闭网络 2重新登录,进入离线收银模式 3离线散客收银 4离线vip会员收银 5开启网络  6重新登录
    //7校验不同时间段的上传订单功能,自动上传时间  0-7 13-17 23-24,其他时间不自动上传
    public void offlineCashier() throws InterruptedException {

        //1 下载商品然后关闭网络
        driver.findElementByAndroidUIAutomator("text(\"下载店铺商品\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(8000);
        PointOption point1 = PointOption.point(952, 23);
        PointOption point2 = PointOption.point(956, 910);
        PointOption point3 = PointOption.point(964, 200);
        PointOption point4 = PointOption.point(956, 910);
        PointOption point5 = PointOption.point(876, 910);
        PointOption point6 = PointOption.point(872, 173);
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        (new TouchAction(driver)).press(point1).waitAction(waitOptions).moveTo(point2).release().perform();//下拉状态栏
        Thread.sleep(100);
        (new TouchAction(driver)).press(point3).waitAction(waitOptions).moveTo(point4).release().perform();//再次下拉状态栏
        Thread.sleep(100);
        //关闭网络
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.View[1]").click();//关闭WiFi
        Thread.sleep(100);
        (new TouchAction(driver)).press(point5).waitAction(waitOptions).moveTo(point6).release().perform();//上拉关闭状态栏
        Thread.sleep(100);
        (new TouchAction(driver)).press(point5).waitAction(waitOptions).moveTo(point6).release().perform();//上拉关闭状态栏
        Thread.sleep(100);




        //2 重新登录,进入离线收银模式
        driver.findElementByAndroidUIAutomator("text(\"退出登录\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/userNameET").clear();//账号输入框
        driver.findElementById(packagename+":id/userNameET").sendKeys(account);
        driver.findElementById(packagename+":id/userPwdET").clear();//密码输入框
        driver.findElementById(packagename+":id/userPwdET").sendKeys(password);
        driver.findElementById(packagename+":id/loginBtn").click();//登录
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);



        //3 离线收银1
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(1).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加库存
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件g
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        xuanze.get(2).click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();//一次收银`
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");

        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze1= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze1.get(0).click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();//二次收银
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");

        //4 离线收银2
//        driver.findElementByAndroidUIAutomator("text(\"VIP会员\")").click();
//        Thread.sleep(100);
//        driver.findElementByAndroidUIAutomator("text(\"VIP会员-999\")");//校验切换为vip会员
        driver.findElementById(packagename+":id/ed_ipnut").clear();
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("ml");//搜索商品,搜索条件ml
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        List<AndroidElement> xuanze2= driver.findElementsByAndroidUIAutomator("text(\"选择\")");
        xuanze2.get(0).click();
        driver.findElementById(packagename+":id/add_number_iv").click();//+按钮,增加数量
        driver.findElementById(packagename+":id/ed_ipnut").clear();//第二个商品
        driver.findElementById(packagename+":id/ed_ipnut").sendKeys("40394");//搜索商品,搜索条件ssb,手撕包
        driver.findElementById(packagename+":id/btn_search").click();
        Thread.sleep(2000);
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementById(packagename+":id/number_tv").click();//点击数量输入框
        driver.findElementById(packagename+":id/codeET").sendKeys("2.39");//2.39
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")");




       // 5 开启网络
        (new TouchAction(driver)).press(point1).waitAction(waitOptions).moveTo(point2).release().perform();//下拉状态栏
        Thread.sleep(100);
        (new TouchAction(driver)).press(point3).waitAction(waitOptions).moveTo(point4).release().perform();//再次下拉状态栏
        Thread.sleep(100);
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.View[1]").click();//开启WiFi
        Thread.sleep(100);
        (new TouchAction(driver)).press(point5).waitAction(waitOptions).moveTo(point6).release().perform();//上拉关闭状态栏
        Thread.sleep(100);
        (new TouchAction(driver)).press(point5).waitAction(waitOptions).moveTo(point6).release().perform();//上拉关闭状态栏
        Thread.sleep(10000);


        // 6重新登录
        driver.findElementById(packagename+":id/ll_close").click();//退出收银界面
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementById(packagename+":id/userNameET").clear();//账号输入框
        driver.findElementById(packagename+":id/userNameET").sendKeys(account);
        driver.findElementById(packagename+":id/userPwdET").clear();//密码输入框
        driver.findElementById(packagename+":id/userPwdET").sendKeys(password);
        driver.findElementById(packagename+":id/loginBtn").click();//登录
        Thread.sleep(3000);


        //7校验不同时间段的上传订单功能,自动上传时间  0-7 13-16 22-24,其他时间不自动上传
        Calendar calendar = Calendar.getInstance();
        driver.findElementByAndroidUIAutomator("text(\"报表\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"离线订单\")").click();
        Thread.sleep(100);
        //driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//获取当前时间的小时数
        if ((hour >= 13 && hour <= 16)||(hour >= 22) || (hour <= 7))  //自动上传的时间段
        {   driver.findElementByAndroidUIAutomator("text(\"上传订单\")").click();
            Thread.sleep(500);
            driver.findElementByAndroidUIAutomator("textContains(\"暂无\")");
            driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
            driver.findElementById(packagename+":id/ll_close").click();//关闭页面
            Thread.sleep(100);
        }
        else {
            driver.findElementByAndroidUIAutomator("text(\"未上传\")");
            driver.findElementByAndroidUIAutomator("text(\"上传订单\")").click();
            Thread.sleep(500);
            driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
            Thread.sleep(3000);
            driver.findElementByAndroidUIAutomator("text(\"已上传\")");
            driver.findElementById(packagename+":id/ll_close").click();//关闭页面
            Thread.sleep(100);
             }
        Reporter.log("离线收银");












    }


    //@Test(priority = 98)//设置登录超时时间为不超时
    public void set1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"系统设置\")").click(); //打开系统设置
        Thread.sleep(200);
        driver.findElementByClassName("android.widget.RelativeLayout").click();//选择退出时间
        driver.findElementByAndroidUIAutomator("text(\"从不\")").click();
        driver.findElementById(packagename+":id/btn_update").click();//保存并设置
        driver.findElementById(packagename+":id/tv_cancel").click();//取消
        driver.findElementById(packagename+":id/btn_update").click();
        driver.findElementById(packagename+":id/tv_ok").click();//确认
        login();

    }

    //@Test(priority = 99)//设置记住密码的功能
    public void set2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"系统设置\")").click(); //打开系统设置
        Thread.sleep(2000);
        String jizhu=driver.findElementById(packagename+":id/switch_button").getAttribute("checked");//获取属性的名称
        System.out.println(jizhu);
        boolean c=jizhu=="true";
        System.out.println(c);
        if (jizhu.equals("true")){
            Reporter.log("已开启记住密码功能");
        }
        else {
            driver.findElementById(packagename+":id/switch_button").click();//开启记住密码功能
            driver.findElementById(packagename+":id/tv_ok").click();//确认
            login();
            driver.findElementByAndroidUIAutomator("text(\"设置\")").click();//重新登录后检查系统设置是否生效
            driver.findElementByAndroidUIAutomator("text(\"系统设置\")").click(); //打开系统设置
            String str = "new UiSelector().resourceId(\"{0}:id/switch_button\").checked(true)";
            str = MessageFormat.format(str, packagename);


            driver.findElementByAndroidUIAutomator(str);
        }

        WebElement back= (WebElement) driver.findElementsByClassName("android.widget.ImageView").get(1);
        back.click();

        //return Reporter.log("登录成功");

    }

   /* public static void main(String[] args) {
        String str = "new UiSelector().resourceId(\"{0}/switch_button\").checked(true)";
        str = MessageFormat.format(str, packagename);
        System.out.println(str);
    }*/


    //@Test(priority = 100)//关闭记住密码的功能
    public void set3() throws InterruptedException{
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"系统设置\")").click(); //打开系统设置
        Thread.sleep(200);
        driver.findElementById(packagename+":id/switch_button").click();//关闭记住密码功能
        driver.findElementById(packagename+":id/tv_ok").click();//确认
    }

}
