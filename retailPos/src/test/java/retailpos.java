import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class retailpos {

    public static AndroidDriver driver;//全局变量
    public static final String REGULARMEMBER = "18271421690";//普通会员
    public static final String barcode2 = "6934412510267";//750克小米辣
    public static final String barcode1 = "6954767470573";//冰露水
    public static final String WHOLESALEMEMBER = "17671607988";//批发会员
    public static final String barcode3 = "462674705";//泸州老窖御窖V15/52度500ml
    public static final String TESTSOAPBIGPACK = "456456456";//测试肥皂大包装
    public static final String LOGISTICSCODE = "123123123";
    public static final String PRICEAFTERCHANGED = "2.3";
    public static final String barcode4 = "9900009";//散称瓜子
    public static final String VIPMEMBER = "17786410583";//VIP会员
    public static final String PackageName="com.yijiupi.retail";//testpre(release) test pre
    public static final String DeviceName = "Android Device";
    public static final String ProductOfGoods = "拉菲奥希";
    public static final String PurchaseCount = "1";
    public static final String SpecificationsAmount = "12";
    public static final String SpecificationsRetailPrice = "8000";
    public static final String CostPrice = "4";
    public static final String RetailPrice = "300";
    public static final String WholeSalePrice = "6";
    public static final String BarCode = "7788414";
    public static final String MemberPrice = "250";
    public static final String ProductName = "茅台测试";
    public static final String SecondSpecifications = "12";
    public static final String SecondSpecificationsPrice = "200";
    public static final String Introduction = "TestIntroduction";

    @AndroidFindBy(uiAutomator = "text(\"登录\")")  AndroidElement denglu;
//    @AndroidFindBy(uiAutomator = "text(\"交接\")")  AndroidElement handOversButton;
//    public AndroidElement handOversButton(){ return handOversButton; }



    @BeforeClass//设置和启动
    public static  AndroidDriver setUp() throws MalformedURLException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        //driver = Base.SetUp();
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
        desiredCapabilities.setCapability("fullReset",false);

        //desiredCapabilities.setCapability(MobileCapabilityType.UDID,"192.168.164.101:5555");//选择运行哪台机器,用UID号来区别,只有一台机器的话可以注释掉

        desiredCapabilities.setCapability("noReset", true);//false,true 是否重置软件,控制每次是否登录
        desiredCapabilities.setCapability("newCommandTimeout", "160");
        desiredCapabilities.setCapability("sessionOverride",true);  //第二次运行可覆盖第一次的session,建议开启
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("automationName", "uiautomator2");//升级为uiautomator2
        //desiredCapabilities.setCapability("ANDROID_UIAUTOMATOR", "uiautomator2");//升级为uiautomator2
        //AndroidDriver driver = new AndroidDriver(new URL("http://192.168.217.2:4723/wd/hub"),desiredCapabilities);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }







    @Test(priority = 1)//登录
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElementById(PackageName +":id/userNameET").clear();
        driver.findElementById(PackageName +":id/userNameET").sendKeys("17671607988");
        driver.findElementById(PackageName +":id/userPwdET").clear();
        driver.findElementById(PackageName +":id/userPwdET").sendKeys("709394");
        driver.findElementById(PackageName +":id/loginBtn").click();
        Thread.sleep(4000);
        //denglu.click();
    }


    //@Test(priority = 2)//切换环境为pre,兼容性测试需要
    public void qiehuan() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"修改密码\")").click();
        Thread.sleep(3000);
        PointOption point0 = PointOption.point(952, 723);
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
        driver.findElementById(Environment.PackageName+":id/ed_code").clear();
        driver.findElementById(Environment.PackageName+":id/ed_code").sendKeys("1");
        driver.findElementByAndroidUIAutomator("text(\"生产\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定切换\")").click();
        login();

    }


    @Test(priority = 3)//VIP会员赊账支付
    public void vipMemberCreditSale() throws InterruptedException {
        //StartApp.vipMemberCreditSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(VIPMEMBER);
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"赊账\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();



    }

    @Test(priority = 4)//vip会员现金支付
    public void vipMemberCashSale() throws InterruptedException {
        //StartApp.vipMemberCashSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(VIPMEMBER);
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();

    }

    @Test(priority = 5)//vip会员储蓄卡支付
    public void vipMemberDebitCardSale() throws InterruptedException {
        //StartApp.vipMemberDebitCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(VIPMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"储蓄卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 6)//vip会员信用卡支付
    public void vipMemberCreditCardSale() throws InterruptedException {
        //StartApp.vipMemberCreditCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(VIPMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"信用卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }


    @Test(priority = 7)//普通会员现金支付    先用赊账支付,应该不成功,然后改为现金支付
    public void regularMemberCreditSale() throws InterruptedException {
        //StartApp.switchToOldCashier(driver);
        //StartApp.regularMemberCreditSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(REGULARMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"赊账\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();

    }


    @Test(priority = 9)//普通会员储蓄卡支付
    public void regularMemberDebitCardSale() throws InterruptedException {
        //StartApp.regularMemberDebitCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(REGULARMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"储蓄卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 10)//普通会员信用卡支付
    public void regularMemberCreditCardSale() throws InterruptedException {
        //StartApp.regularMemberCreditCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(REGULARMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"信用卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();

    }

    @Test(priority = 11)//清除商品
    public void clearProduct() throws InterruptedException {
        //StartApp.clearProduct(driver);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"清空\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验清空成功
        Thread.sleep(100);
    }

    @Test(priority = 12)//优惠券扫描  正确的优惠券需要查询后台接口,目前不会
    public void couponScan() throws InterruptedException {
        //StartApp.couponScan(driver);
        driver.findElementByAndroidUIAutomator("text(\"优惠券扫描\")").click();//散客不支持添加优惠券
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(WHOLESALEMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"优惠券扫描\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("123456");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click(); //错误的优惠券无法匹配到
        Thread.sleep(1000);
    }

    @Test(priority = 13)//挂单
    public void  pendingAndHangingOrder() throws InterruptedException{
        //StartApp.pendingAndHangingOrder(driver);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"挂单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验挂单成功
        Thread.sleep(100);
    }

    @Test(priority = 14)//解单 并支付
    public void  acquireOrder() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"解挂\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }



    @Test(priority = 15)//添加赠品
    public void addfreebie() throws InterruptedException {
        //StartApp.addfreebie(driver);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"添加赠品\")").click();//第一次添加赠品
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode3);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"添加赠品\")").click();//第二次添加赠品,只有赠品,支付金额为0
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode3);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();

    }

   /* @Test(priority = 15)//输入物流码
    public void logisticsCodeAdd(){
        StartApp.logisticsCodeAdd(driver);
    }
*/
    @Test(priority = 16)//改价
    public void changePrice() throws InterruptedException {
        //StartApp.changePrice(driver);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"改价\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(PRICEAFTERCHANGED);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }


    @Test(priority = 17) //删除商品
    public void deleteProduct() throws InterruptedException {
        //StartApp.deleteProduct(driver);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode1);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"删除\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();//校验删除成功
        Thread.sleep(100);
    }


    @Test(priority = 18)//批发会员赊账支付
    public void wholeSaleMemberCreditSale() throws InterruptedException {
        //StartApp.wholeSaleMemberCreditSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(WHOLESALEMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"赊账\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 19)//批发会员现金支付
    public void wholeSaleMemberCashSale() throws InterruptedException {
        //StartApp.wholeSaleMemberCashSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(WHOLESALEMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 20)//批发会员储蓄卡支付
    public void wholeSaleMemberDebitCardSale() throws InterruptedException {
        //StartApp.wholeSaleMemberDebitCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(WHOLESALEMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"储蓄卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 21)//批发会员信用卡支付
    public void wholeSaleMemberCreditCardSale() throws InterruptedException {
        //StartApp.wholeSaleMemberCreditCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"添加会员\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(WHOLESALEMEMBER);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"信用卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 22)//散客无条码商品现金支付，开始用赊账付款不成功,后面改为现金
    public void walkingMemberCreditSale() throws InterruptedException {
        //StartApp.walkingMemberCreditSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"    散客    \")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"无条码商品\")").click();
        Thread.sleep(1000);
        for (int i=1;i<=2;i++)
        {
            driver.findElementById(PackageName+":id/add_number_iv").click();//点击第一个+增加数量
        }
        driver.findElementById(PackageName+":id/sub_number_iv").click();//点击第一个-减少数量
        driver.findElementByAndroidUIAutomator("text(\"返回收银台\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode4);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementById(PackageName+":id/add_number_iv").click();//点击第一个+增加数量
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"赊账\")").click();
        driver.findElementById(PackageName+":id/rl_xianjin").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }



    @Test(priority = 23)//散客会员储蓄卡支付
    public void walkingMemberDebitCardSale() throws InterruptedException {
        //StartApp.walkingMemberDebitCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"    散客    \")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"无条码商品\")").click();
        Thread.sleep(1000);
        driver.findElementById(PackageName+":id/number_tv").click();//点击数量输入框直接输入
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("4");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementById(PackageName+":id/sub_number_iv").click();//点击第一个-减少数量
        driver.findElementByAndroidUIAutomator("text(\"返回收银台\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode4);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementById(PackageName+":id/add_number_iv").click();//点击第一个+增加数量
        driver.findElementById(PackageName+":id/add_number_iv").click();//点击第一个+增加数量
        driver.findElementById(PackageName+":id/sub_number_iv").click();//点击第一个-减少数量
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"储蓄卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    @Test(priority = 25)//散客会员信用卡支付
    public void walkingMemberCreditCardSale() throws InterruptedException {
        //StartApp.walkingMemberCreditCardSale(driver);
        driver.findElementByAndroidUIAutomator("text(\"    散客    \")").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"无条码商品\")").click();
        Thread.sleep(1000);
        for (int i=1;i<=3;i++)
        {
            driver.findElementById(PackageName+":id/add_number_iv").click();//点击第一个+增加数量
        }
        driver.findElementByAndroidUIAutomator("text(\"返回收银台\")").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").sendKeys(barcode4);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementById(PackageName+":id/number_tv").click();//点击数量输入框直接输入
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("3");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"信用卡\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }



    @Test(priority = 26)//第一次退款
    public void reFund1() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();
        Thread.sleep(1500);
        AndroidElement ordernum=(AndroidElement) driver.findElementsById(PackageName+":id/orderNumTV").get(1);
        String num=ordernum.getText();//获取订单号
        String nu=num.substring(num.length()-6);//订单号后6位
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        List<AndroidElement> tuikuan=driver.findElementsByAndroidUIAutomator("text(\"退款\")");
        tuikuan.get(1).click();//点击退款
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        tuikuan.get(1).click();//点击退款
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"确定退款\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("666");
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu);//输入订单后6位
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"退款订单查询\")").click();
        Thread.sleep(1500);
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"退款成功\")");
    }

    @Test(priority = 27)//第二次退款
    public void reFund2() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"退款\")").click();
        Thread.sleep(500);
        AndroidElement chaxun=(AndroidElement)driver.findElementsByAndroidUIAutomator("text(\"订单查询\")").get(1);
        chaxun.click();//有两个订单查询,坑
        Thread.sleep(1500);
        AndroidElement xuanze=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"选择\")").get(1);
        xuanze.click();
        Thread.sleep(1500);
        String number=driver.findElementById(PackageName+":id/orderNoTV").getText();
        String num=number.substring(4);//获取订单号
        System.out.println(num);
        String nu=num.substring(num.length()-6);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        Thread.sleep(100);
        AndroidElement tuikuan=(AndroidElement) driver.findElementsByAndroidUIAutomator("text(\"退款\")").get(1);
        tuikuan.click();//点击退款
        driver.findElementByAndroidUIAutomator("text(\"确定退款\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu);//输入订单后6位
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(num);//退款完成后无法再次退款
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"整单全选\")").click();
        tuikuan.click();//点击退款
        Thread.sleep(100);
        tuikuan.click();//提示无法退款了,不会弹窗,所以还可以继续点击退款
        Thread.sleep(100);
    }


    @Test(priority = 28)//查询当日流水 商品销售报表 营收报表 赊账还款查询
    public void enquiry() throws InterruptedException {
        //StartApp.pressDailyTrade(driver);
        driver.findElementByAndroidUIAutomator("text(\"当日流水\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"商品销售报表\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"营收报表\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"赊账还款查询\")").click();
        Thread.sleep(2000);
    }

    @Test(priority = 29)//交接班
    public void handOver() throws InterruptedException {
        //StartApp.handOver(driver);
        driver.findElementByAndroidUIAutomator("text(\"交接班\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"交接\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"交接\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(4000);
        login();
    }






    //上下架
    @Test(priority = 34)
    public void putawayAndUnshelve() throws SQLException, InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"商品\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已下架\")").click();
        Thread.sleep(3000);
        driver.findElementById(PackageName+":id/ll_item_bg").click();//点击第一行商品
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"上架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"上架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已下架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已上架\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"下架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
    }

//    //盘存打印
    //@Test(priority = 35)
    public void inventoryPrint() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSearchBar().sendKeys(Environment.ProductOfGoods);
        productPage.getSearch().click();
        productPage.getOnlineSale().click();
        productPage.getOnlineSale().click();
        //productPage.getSearchBar().clear();
        productPage.getRicewineCategory().click();
        productPage.getInventoryPrint().click();
        productPage.getConfirm().click();
    }

    //进货
    @Test(priority = 36)
    public void purchaseGoods() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getExpansion().click();//点击展开按钮
        productPage.getWineCategory().click();//点击葡萄酒类目
        String beforeStock = productPage.getGetStockOfBeforePurchase().getText();//获取购买之前的数量
        String beforeStock1 = beforeStock.substring(0, beforeStock.length() - 1);//使购买之前的数量去掉后面的瓶以便比对
        productPage.getPurchase().click();//点击购买按钮
        //productPage.getPurchaseCount().sendKeys(Environment.PurchaseCount);//输入购买1瓶
        productPage.getPurchaseCount().click();//点击输入数量
        driver.findElementById(Environment.PackageName+":id/codeET").sendKeys("1");//输入购买1瓶
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        productPage.getPurchase().click();//点击购买按钮
        String afterStock = productPage.getGetStockOfBeforePurchase().getText();//获取购买后的库存文本
        Thread.sleep(1500);
        String afterStock1 = afterStock.substring(0, beforeStock.length() - 1);//使购买后的数量去掉后面的瓶以便比对
        int afterStockInt = Integer.parseInt(afterStock1);
        int beforeStockAdd = Integer.parseInt(beforeStock1);//将购买前的字符串变成int类型以便加1
        int beforeStockAfterAdd = beforeStockAdd + 1;//购买前的数量+1
        Assert.assertEquals(afterStockInt,beforeStockAfterAdd);//比较购买后的数量和购买前的数量是否一致
    }

    //添加规格
    @Test(priority = 37)
    public void addingSpecifications() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getAddNewsSpecifications().click();
        productPage.getChooseSpecifications().click();
        productPage.getBottle().click();
        productPage.getSpecificationsAmount().sendKeys(Environment.SpecificationsAmount);
        productPage.getSpecificationsRetailPriceInputBox().sendKeys(Environment.SpecificationsRetailPrice);
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }

    //修改成本价
    @Test(priority = 38)
    public void costPriceChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getCostPriceChangeButton().click();
        productPage.getCostPriceInputBox().sendKeys(Environment.CostPrice);
        productPage.getConfirm().click();
    }

    //修改规格
    @Test(priority = 39)
    public void specificationsChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSpecificationsChangeButton().click();
        productPage.getBottle().click();
        productPage.getConfirm().click();
    }

    //修改零售价
    @Test(priority = 40)
    public void retailPriceChange() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getRetailPriceChangeButton().click();
        productPage.getRetailPriceInputBox().sendKeys(Environment.RetailPrice);
        productPage.getConfirm().click();
    }

    //修改批发价
    @Test(priority = 41)
    public void wholeSalePriceChange() {
        ProductPage productPage = new ProductPage(driver);
        WebElement category = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName+":id/tv_fix_discount_price")));
        category.click();
        //productPage.getWholeSalePriceChangeButton().click();
        productPage.getWholeSalePriceInputBox().sendKeys(Environment.WholeSalePrice);
        productPage.getConfirm().click();
    }

    //修改条码
    @Test(priority = 42)
    public void barCodeChange() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getBarCodeChangeButton().click();
        productPage.getBarCodeInputBox().sendKeys(Environment.BarCode);
        productPage.getBarCodeAdding().click();
        productPage.getConfirm().click();
        Thread.sleep(1500);
        List<AndroidElement> deleteButton = driver.findElementsByClassName("android.widget.Button");
        Thread.sleep(1000);
        deleteButton.get(2).click();
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }

    //修改会员价
    @Test(priority = 43)
    public void memberPriceChange() throws InterruptedException, SQLException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getSetUpMemberPrice().click();
        productPage.getSettingButtonForMemberPrice().click();
        productPage.getMemberPriceInputBox().sendKeys(Environment.MemberPrice);
        productPage.getConfirm().click();
        Thread.sleep(2000);
        //productPage.getSelectAll().click();
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        productPage.getSetUpAllMemberPrice().click();
        productPage.getSetUpMemberPriceInputBox().sendKeys(Environment.MemberPrice);
        productPage.getConfirm().click();
        Thread.sleep(2000);
        //productPage.getSelectAll().click();
        driver.findElementByAndroidUIAutomator("text(\"全选\")").click();
        productPage.getSetUpAllMemberPrice().click();
        productPage.getClearMemberPrice().click();
        Thread.sleep(500);
        productPage.getDetermine().click();
        Thread.sleep(1000);
        productPage.getBackButton().click();
    }

    //需求：扫码新增商品
    //思路：首先连接到开发环境的数据库环境，拿到开发环境的数据
    /*@Test(priority = 42)
    public void searchBarCodeAddProduct() throws SQLException, ClassNotFoundException,InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getProduct().click();
        ResultSet resultSet = connectJDBC();
        productPage.getAddProduct().click();
                 //        while (resultSet.next()) {
//            productPage.getSearchCodeBarToAddProduct().sendKeys(resultSet.getString("barcode"));
//            break;
//              }
        productPage.getSearchCodeBarToAddProduct().sendKeys("6923450658598");
        productPage.getSearch().click();
        productPage.getLongTerm().click();
        productPage.getSubmit().click();
        //productPage.getConfirm().click();
        Thread.sleep(1000);
        productPage.getBackButton().click();
    }*/

    //添加商品
    @Test(priority = 44)
    public void addingNewProduct() throws InterruptedException, SQLException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getAddProduct().click();
        Thread.sleep(1000);
        productPage.getSearch().click();

        WebElement category = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/tv_data")));
        category.click();
        //productPage.getCategoryOfAddingNewProduct().click();
        WebElement ricewineCategory = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/title")));
        ricewineCategory.click();

        Thread.sleep(1000);
        productPage.getSoap().click();
        productPage.getProductName().sendKeys(Environment.ProductName + Environment.getTime());
        productPage.getLongTerm().click();
        productPage.getSelect().click();
        Thread.sleep(1500);
        productPage.getBottle().click();
        productPage.getBarCodeForAddingProduct().click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys("1" + Environment.getRandomNum());
        productPage.getConfirm().click();
        //productPage.getSalePriceForAddingProduct().sendKeys("100");
//        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.RetailPrice);
//        productPage.getConfirm().click();
        productPage.getAddNewsSpecifications().click();
        //第二行的规格单位选择
        Thread.sleep(2000);
        addSecondProductInfo();
        productPage.getDelete().click();
        productPage.getAddNewsSpecifications().click();
 //       addSecondProductInfo();
//        productPage.SwipeDown();
//        productPage.getIntroduction().sendKeys(Environment.Introduction);
//        productPage.getAddingPicture().click();
//        productPage.getFirstImage().click();
//        productPage.getPictureConfirm().click();
//        TouchActions action = new TouchActions(driver);
//        action.scroll(productPage.getSubmit(), 10, 100);
//        action.perform();
        //productPage.swipeUp(driver);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"提交\"));");
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"提交\"));");

        productPage.getSubmit().click();
        Thread.sleep(1000);
        productPage.getBackButton().click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(1000);
        productPage.getRicewineCategory().click();
        Thread.sleep(2000);
        MobileElement xiajia= (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"下架\")");
        xiajia.click();
        productPage.getConfirm().click();
        productPage.getPutaway().click();
        productPage.getConfirm().click();
        Thread.sleep(1000);
    }

//    @Test(priority = 44)//增加第二个规格
    public  void addSecondProductInfo() {
        ProductPage productPage = new ProductPage(driver);
        List<AndroidElement> chooseButton = driver.findElementsById(Environment.PackageName + ":id/btn_choose_unit");
        chooseButton.get(1).click();
        productPage.getPiece().click();
        productPage.getAddingSecondSpecifications().click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.SecondSpecifications);
        productPage.getConfirm().click();
        List<AndroidElement> barCodeButton = driver.findElementsById(Environment.PackageName + ":id/ed_barcode");
        barCodeButton.get(1).click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys("2" + Environment.getRandomNum());
        productPage.getConfirm().click();
        List<AndroidElement> retailPriceButton = driver.findElementsById(Environment.PackageName + ":id/ed_retail_price");
        retailPriceButton.get(1).click();
        productPage.getBarCodeInputBoxForAddingProduct().sendKeys(Environment.SecondSpecificationsPrice);
        productPage.getConfirm().click();
    }

    //需求：先获取进货前的库存，然后获取进货后的库存，最后比对进货后的库存是不是等于进货前的库存-1
    //外采
    @Test(priority = 45)
    public void outSidePurchase() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.getOnShelvesOfSpinner().click();
        productPage.getAllOfSpinner().click();
        productPage.getDrinkCategory().click();
        List<WebElement> beforeStock = driver.findElementsById(Environment.PackageName + ":id/tv_stock");
        Thread.sleep(1500);
        String text = beforeStock.get(1).getText();//获取外采前的库存数量
        String beforeStockNumber = text.substring(0, text.length() - 1);
        int beforeStockNumber1 = Integer.parseInt(beforeStockNumber);
        int beforeStockNumber2 = beforeStockNumber1 + 1;
        productPage.getOutsidePurcase().click();//点击外采
        //productPage.getOutsidePurchaseAmount().sendKeys(Environment.PurchaseCount);//输入采购数量
        productPage.getPurchaseCount().click();//点击输入数量
        driver.findElementById(Environment.PackageName+":id/codeET").sendKeys("1");//输入购买1瓶
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        productPage.getPurchase().click();
        List<WebElement> afterStock = driver.findElementsById(Environment.PackageName + ":id/tv_stock");
        String afterStockNumber = afterStock.get(1).getText();
        String afterStockNumber1 = afterStockNumber.substring(0, afterStockNumber.length() - 1);
        int afterStockNumber2 = Integer.parseInt(afterStockNumber1);
        Assert.assertEquals(afterStockNumber2,beforeStockNumber2);

    }

    //作废
   /* @Test(priority = 46)
    public void cancellation() {
        ProductPage productPage = new ProductPage(driver);
        productPage.getOnShelvesOfSpinner().click();
        productPage.getSoldOutOfSpinner().click();
        productPage.getFoodAndOil().click();
        productPage.getDeleteProductButton().click();
        productPage.getConfirm().click();
        productPage.getDeleteProduct().click();
        productPage.getCancelDelete().click();
        productPage.getConfirm().click();
        productPage.getCloseButton().click();
    }*/

    public void xiahua(){
        int width=driver.manage().window().getSize().width;

        int height=driver.manage().window().getSize().height;

        int y1 = height*1/2; //下滑的开始点，从y1开始也就是屏幕二分之一处
        int y2 = height*3/4; //下滑的结束点，到y2结束也就是屏幕的四分之三处
        TouchAction tAction = new TouchAction(driver);
        PointOption point1 = PointOption.point(width / 2, y1);//上滑的开始点
        PointOption point2 = PointOption.point(width / 2, y2);//上滑的结束点
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();

        //tAction.press(width/2,y1).waitAction(Duration.ofMillis(1000)).moveTo(width/2,y2).release().perform();
    }
}
