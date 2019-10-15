import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.springframework.util.Assert;
//import java.time.Duration;

public class RunTestnew extends BaseForShopKeeper {

    private AndroidDriver driver;//全局变量

    @BeforeClass//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = BaseForShopKeeper.SetUp();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
    }

    @AfterClass//关闭App
    public void tearDown() {
        //driver.closeApp();
    }

  /*  @Test(priority = 0)//登陆,已取消每次登陆
    public void login() throws IOException, SQLException, InterruptedException {
        LoginPageForShopKeeper loginPageForShopKeeper = new LoginPageForShopKeeper(driver);
        Thread.sleep(4000L);
        loginPageForShopKeeper.inputUserName().sendKeys(LoginPageForShopKeeper.USERNAME);
//        WebElement username = (new WebDriverWait(driver, 20))
//                .until(presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View[3]/android.widget.EditText")));
//        username.sendKeys("18888886667");
        List<AndroidElement> password = driver.findElementsByClassName("android.widget.EditText");
        password.get(1).sendKeys(LoginPageForShopKeeper.PASSWORD);
        // driver.hideKeyboard();  //隐藏键盘
        List<AndroidElement> login = driver.findElementsByClassName("android.widget.TextView");
        login.get(1).click();
    }*/

    @Test(priority = 1)//等待9秒
    public void 启动等待() throws InterruptedException {
        Thread.sleep(9000);
        //waittool.waittool(driver, By.name("易酒批零西藏舞阳店"), 15);// 等待某元素加载，5S未能加载变为超时
        //waittool.waittool(driver, (By) driver.findElementByAndroidUIAutomator("text(\"易酒批零西藏舞阳店\")"),15);
    }

    @Test(priority = 2)//切换店铺  之前是舞阳店,现在改成明珠店
    public void 切换店铺() throws InterruptedException {
        //MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();//点击切换按钮
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店\")").click();
        //mainPageForShopKeeper.getfeifeijiuba().click();
        Thread.sleep(2000);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠店\")").click();
        //mainPageForShopKeeper.getwuyangdian().click();
        Reporter.log("切换店铺");
        //mainPageForShopKeeper.getTibetWuYangShop().click();
//        List<AndroidElement> tiBet = driver.findElementsByClassName("android.widget.TextView");
//        //System.out.println(tiBet);
//        tiBet.get(0).click();
//        WebElement abc = driver.findElement(By.xpath("//android.widget.TextView[@bounds='[35,231][1045,284]'][@enabled=true]"));
//        abc.click();
        //MobileBy.xpath("//android.widget.TextView[@bounds='[35,231][1045,284]'][@enabled=true]");

    }


    //报表
    @Test(priority = 3)//今日销售额_商品销售报表 saleToday
    public void 今日销售额() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getSalesRevenue().click();//今日销售额(元)
        Thread.sleep(1000L);
        driver.findElementByAndroidUIAutomator("text(\"商品销售报表\")");//校验跳转页面正确
        mainPageForShopKeeper.getWineCategory().click();//葡萄酒
        Thread.sleep(1000L);
//        MobileElement xiangqing = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@instance='7']"));//详情按钮>
//        xiangqing.click();
        MobileElement xiangqing = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[4]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView");
        xiangqing.click();
        Thread.sleep(2500L);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView"); //返回按钮
        backButton.get(0).click();
        Thread.sleep(100L);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView"); //返回按钮
        backButton1.get(0).click();
        Reporter.log("今日销售额");
    }


    @Test(priority = 4)//今日利润(元)--商品销售报表 todayProfit
    public void 今日利润() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getTodayRevenue().click();// 今日利润(元)
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"商品销售报表\")");//校验跳转页面正确
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Reporter.log("今日利润");
    }

    @Test(priority = 5)//待接单页面-线上订单 waitingOrders
    public void 待接单() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getWaitingOrders().click();//待接单
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"线上订单\")");//校验跳转页面正确
        mainPageForShopKeeper.getSearchBarForOrders().sendKeys("1695325874563");
        mainPageForShopKeeper.getSearch().click();
        mainPageForShopKeeper.getAcceptOrders().click();//已接单
        mainPageForShopKeeper.getCompleteOrders().click();//已完成
        mainPageForShopKeeper.getCancelOrders().click();//已取消
        Thread.sleep(2000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Reporter.log("待接单");
    }

    @Test(priority = 6)//今日比数-交易流水dealFlow
    public void 今日比数() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getTodayFlow().click();
//        WebElement username = (new WebDriverWait(driver, 20))
//                .until(presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View[3]/android.widget.EditText")));
//       username.sendKeys("18888886667");
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"交易流水\")");//校验跳转页面正确
        mainPageForShopKeeper.getTotalOrders().click();  //全部订单
        mainPageForShopKeeper.getOfflineOrders().click();//线下订单
        mainPageForShopKeeper.getAllCashier().click();//全部收银员
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[1]").click();//第一个收银员
        Thread.sleep(2000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        //driver.pressKeyCode(AndroidKeyCode.BACK);  //使用安卓自带返回键返回
        //driver.findElementsByClassName("android.widget.ImageView");
        Reporter.log("今日比数");
    }

    @Test(priority = 7)//订单查询 ordersearch
    public void 订单查询() throws InterruptedException {
        Thread.sleep(200);
        driver.findElementByAndroidUIAutomator("text(\"订单查询\")").click();//打开订单查询
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc='测试控件_时间控件_起']/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        driver.findElementById("android:id/date_picker_header_year").click();//调整开始时间为前年
        driver.findElementById("android:id/text1").click();
        driver.findElementById("android:id/button1").click();//点击确定
        Thread.sleep(3000);

        //获取第二个订单的订单号
        WebElement dingdanhao=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]");
        String num=dingdanhao.getText();
        String nu=num.substring(4);//订单号获取成功
        driver.findElementByAccessibilityId("测试控件_搜索输入框").clear();
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys(nu);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc='测试控件_详情']/android.widget.ImageView[1]").click();//详情
        Thread.sleep(2000);
        WebElement dingdanhao1=driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[2]");
        String nu1=dingdanhao1.getText();
        Assert.assertEquals(nu,nu1,"订单详情订单号有误");//断言两个订单号是否一致
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(200);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();//切换订单状态进行搜索
        driver.findElementByAndroidUIAutomator("text(\"待付款\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"待付款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已付款\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已付款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        driver.findElementByAndroidUIAutomator("text(\"商家拒单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"商家拒单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"用户拒单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"用户拒单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"待付款取消\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"待付款取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"支付中\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"支付中\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已付款取消\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已付款取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        Thread.sleep(2000);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Reporter.log("订单查询");
    }


    @Test(priority = 8)//线上订单  1查询 2接单 3拒单  OrderOnline
    public void 线上订单() throws InterruptedException {
        MainPageForShopKeeper orderform = new MainPageForShopKeeper(driver);
        orderform.getOrderForm().click();//打开订单管理
        orderform.getSearchBarForOrders().sendKeys("17671607988"); //搜索框输入
        orderform.getSearch().click();  //点击搜索
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"筛选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"普通订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"微信支付\")").click();
        driver.findElementByAndroidUIAutomator("text(\"近7天\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2000);
        orderform.getAcceptOrders().click();  //已接单
        //driver.findElementByAccessibilityId("测试控件_详情").click();
        //driver.navigate().back();//使用安卓自带返回键返回
        orderform.getCompleteOrders().click(); //已完成
        orderform.getCancelOrders().click();  //已取消
        orderform.getwaitOrder().click();  //待接单
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByAndroidUIAutomator("text(\"筛选\")").click();
        driver.findElementByAndroidUIAutomator("text(\"重置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        AndroidElement dingdan0= (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]");
        String num0=dingdan0.getText();
        String nu0=num0.substring(4);
        dingdan0.click();
        Thread.sleep(2000);
        AndroidElement dingdanx=(AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[2]");
        String NU=dingdanx.getText();
        Assert.assertEquals(nu0,NU,"详情和列表的订单号不一致");
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu0);   //接单
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"接单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+num0+"\")");
        driver.findElementByAndroidUIAutomator("text(\"完成订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+num0+"\")");
        driver.findElementByAndroidUIAutomator("text(\"待接单\")").click();        //拒单1
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        AndroidElement dingdan= (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]");
        String num=dingdan.getText();
        String nu=num.substring(4);
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"拒单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已取消\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+num+"\")");
        driver.findElementByClassName("android.widget.EditText").clear();    //拒单2
        driver.findElementByAndroidUIAutomator("text(\"待接单\")").click();
        AndroidElement dingdan2= (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]");
        String num2=dingdan2.getText();
        String nu2=num2.substring(4);
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu2);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"接单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+num2+"\")");
        driver.findElementByAndroidUIAutomator("text(\"用户拒单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已取消\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\""+num2+"\")");
        Thread.sleep(100);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Reporter.log("线上订单");
    }


    @Test(priority = 9)//直供代销订单  简单点击就好  OrderStraight
    public void 直供代销订单() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"直供代销订单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"直供代销订单\")");
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        driver.findElementByAndroidUIAutomator("text(\"待接单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Reporter.log("直供代销订单");
    }

    @Test(priority = 10)//退货订单  1更改时间 2查看详情  OrderRefund
    public void 退货订单() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"退货订单\")").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();//更改查询时间
        Thread.sleep(2000);
        AndroidElement dingdanhao= (AndroidElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView[4]");
        String num=dingdanhao.getText();
        String nu=num.substring(4);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys(nu);
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"退款金额：\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"退货订单详情\")");
        driver.findElementByAndroidUIAutomator("text(\""+num+"\")");
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(100);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Reporter.log("退货订单");

    }






    @Test(priority = 11)//配送管理    1配送员列表  2待配送列表 3配送详情   此处有滑动
    public void 配送管理() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        Thread.sleep(1000);
        mainPageForShopKeeper.huadong();
        Thread.sleep(100);
        mainPageForShopKeeper.getpeisongguanli().click();//打开配送管理_配送员列表
        Thread.sleep(2000);
        List<AndroidElement> qiehuan = driver.findElementsByClassName("android.widget.ImageView");
        qiehuan.get(1).click();//切换店铺
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店\")").click();
        Thread.sleep(1000);
        qiehuan.get(1).click();//切换店铺
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠店\")").click();
        Thread.sleep(1000);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(4).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"按商品汇总\")").click();
        Thread.sleep(3000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();//返回
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys("花");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"已启用\")").click();//待配送列表
        Thread.sleep(1000);
        mainPageForShopKeeper.getpeisongzhong().click();//配送详情
        Thread.sleep(2000);
        mainPageForShopKeeper.getbiangengpeisongyuan().click();
        Thread.sleep(2000);
        List<AndroidElement> quxiao = driver.findElementsByClassName("android.widget.ImageView");
        quxiao.get(0).click();//取消
        mainPageForShopKeeper.getpeisongchenggong().click();
        mainPageForShopKeeper.getquxiao().click();
        mainPageForShopKeeper.getjushou().click();
        mainPageForShopKeeper.getquxiao().click();
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();//返回
        Thread.sleep(1000);
        mainPageForShopKeeper.getyipeisong().click();
        mainPageForShopKeeper.getdaipeisong().click();
        mainPageForShopKeeper.getyipeisong().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getpeisongwancheng().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getback().click();
        Thread.sleep(500);
        mainPageForShopKeeper.getback().click();
        Thread.sleep(500);
        mainPageForShopKeeper.getback().click();
        Reporter.log("配送管理");

    }







    @Test(priority = 12)//商品销售报表
    public void 商品销售报表() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getbaobiao().click();
        Thread.sleep(2000L);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
       //mainPageForShopKeeper.getProduct().click();
        /*List<AndroidElement> yingshou = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"营收\")");
        yingshou.get(0).click();*/
        //driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"营收\")").get(0).click;
        Thread.sleep(3000L);
        driver.findElementByAndroidUIAutomator("text(\"白酒\")").click();
        driver.findElementByAndroidUIAutomator("text(\"葡萄酒\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部\")").click();
        Thread.sleep(3000L);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        Thread.sleep(3000L);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(200L);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Reporter.log("商品销售报表");
    }

    @Test(priority = 13)//商品销售排行
    public void 商品销售排行() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"商品销售排行\")").click();
        Thread.sleep(2500L);
        driver.findElementByAndroidUIAutomator("text(\"销量最高\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"今日\")").click();
        driver.findElementByAndroidUIAutomator("text(\"近7天\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"近7天\")").click();
        driver.findElementByAndroidUIAutomator("text(\"近30天\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"近30天\")").click();
        driver.findElementByAndroidUIAutomator("text(\"近60天\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"近60天\")").click();
        driver.findElementByAndroidUIAutomator("text(\"今日\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"销售额最高\")").click();
        Thread.sleep(2000L);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys("老坛酸菜");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"销量最高\")").click();
        Thread.sleep(2000L);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000L);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("商品销售排行");
    }

    @Test(priority = 14)//交易流水
    public void 交易流水() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"交易流水\")").click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"交易流水\")");
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"全部订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线下订单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"线下订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线上订单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"线上订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线下退款\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"线下退款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线上拒单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"线上拒单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线上订单取消\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"线上订单取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"充值\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"充值\")").click();
        driver.findElementByAndroidUIAutomator("text(\"提现\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"提现\")").click();
        driver.findElementByAndroidUIAutomator("text(\"还款\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"还款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"收款\")").click();
        driver.findElementByAndroidUIAutomator("text(\"全部订单\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"全部收银员\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();
        driver.findElementByAndroidUIAutomator("text(\"全部收银员\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("交易流水");
    }

    @Test(priority = 15)//进销存报表
    public void 进销存报表() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getjinxiaocunbaobiao().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"进销存报表\")");
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠店\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("进销存报表");
    }

    @Test(priority = 16)//单品进销存
    public void 单品进销存() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"单品进销存\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"单品进销存\")");
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys("mt");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("单品进销存");
    }


    @Test(priority = 17)//单品进销存
    public void 营收报表() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"营收报表\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"营收报表\")");
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.huadong();
        mainPageForShopKeeper.huadong();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("营收报表");
    }





    @Test(priority = 18)//战略产品  此处有滑动
    public void 战略产品() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.huadong();                                 //***滑动
        Thread.sleep(100);
        SoftAssert assertion = new SoftAssert();//软断言开始
        mainPageForShopKeeper.getstrategy().click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").clear();
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys("酒鬼");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        String a=driver.findElementByXPath("text(\"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]\")").getText();
        assertion.assertTrue(a.contains("酒鬼"), "字段不匹配,搜索到的内容有误");
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]").click();//查看详情
        Thread.sleep(1000);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"销售明细\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"进货明细\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").clear();
        mainPageForShopKeeper.getSearch().click();//点击搜索
        Thread.sleep(2000);
        mainPageForShopKeeper.getSearch().click();//点击搜索
        mainPageForShopKeeper.getSearch().click();//点击搜索
        mainPageForShopKeeper.getback().click();//返回
        assertion.assertAll();//断言结束的地方
        Reporter.log("战略产品");
    }


    @Test(priority = 19)//促销活动 1优惠券 2订单优惠
    public void 促销活动() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getcuxiao().click();
        Thread.sleep(2500);  //1优惠券
        mainPageForShopKeeper.getyifabu().click();  //已发布
        Thread.sleep(1000);
        mainPageForShopKeeper.getdaifabu().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getyixiajia().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getquanbu().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"新增\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        driver.findElementByAndroidUIAutomator("text(\"优惠劵分类\")").click();
        driver.findElementByAndroidUIAutomator("text(\"普通优惠券 \")").click();
        driver.findElementByAndroidUIAutomator("text(\"优惠券类型\")").click();
        driver.findElementByAndroidUIAutomator("text(\"抵用劵 \")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("最最最新无门槛5毛优惠券");
        driver.findElementByAndroidUIAutomator("text(\"优惠劵金额\")").sendKeys("0.5");
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]").click();///选择结束时间
        driver.findElementById("android:id/next").click();//选择下个月
        driver.findElementByAndroidUIAutomator("text(\"1\")").click();//1号
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"请输入金额\")").sendKeys("0");
        driver.findElementByAndroidUIAutomator("text(\"优惠劵张数\")").sendKeys("100");
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getdaifabu().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"发布\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getyifabu().click();  //已发布
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"领取记录\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"领取记录\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        driver.findElementByAndroidUIAutomator("text(\"下架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);

        //2订单优惠
        mainPageForShopKeeper.getdingdanyouhui().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getdaifabu().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getyixiajia().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getyifabu().click();  //已发布
        Thread.sleep(1000);
        mainPageForShopKeeper.getquanbu().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"新增\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"新增订单优惠活动\")");
        driver.findElementByClassName("android.widget.EditText").sendKeys("最最最新8折优惠");
        driver.findElementByAndroidUIAutomator("text(\"活动类型\")").click();
        driver.findElementByAndroidUIAutomator("text(\"打折 \")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]").click();//选择结束时间
        driver.findElementById("android:id/next").click();//选择下个月
        driver.findElementByAndroidUIAutomator("text(\"1\")").click();//1号
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByAndroidUIAutomator("text(\"参与方式\")").click();
        driver.findElementByAndroidUIAutomator("text(\"线下 \")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.EditText[1]").sendKeys("0.5");//参与优惠起步金额
        driver.findElementByAndroidUIAutomator("text(\"输入0.01-1之间的小数\")").sendKeys("0.8");//输入折扣比例
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[13]/android.widget.EditText[1]").sendKeys("1000");//最大优惠金额
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(2500);
        mainPageForShopKeeper.getdaifabu().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"发布\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getyifabu().click();  //已发布
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"下架\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("促销活动");

    }

    @Test(priority = 20)//分销店长_17671607988必须为分销店长,不然有问题
    public void 分销店长() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        driver.findElementByAndroidUIAutomator("text(\"分销店长\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("17671607988");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getyongjinmingxi().click(); //佣金明细
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]").click();//查看详情
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"佣金明细\")");
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Thread.sleep(100);
        mainPageForShopKeeper.getfenxiaohuiyuan().click(); //分销会员
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("17671607988");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.ImageView").click();//返回
        Reporter.log("分销管理");
    }
        //driver.navigate().back();//返回



          //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");滑动直到找到元素为止,webview为变量



    @Test(priority = 21)//分销商品
    public void 分销商品() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getfenxiaoshangpin().click();//分销商品
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("酒鬼");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getbianjimingdan().click();
        mainPageForShopKeeper.getquxiao().click();
        mainPageForShopKeeper.getbianjimingdan().click();
        mainPageForShopKeeper.gettebiemingdan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2500);
        mainPageForShopKeeper.getfenxiaoshezhi().click();
        mainPageForShopKeeper.getquxiao().click();
        mainPageForShopKeeper.getfenxiaoshezhi().click();
        mainPageForShopKeeper.gettichengshuru().sendKeys("5");
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.gettebiemingdan().click();//特别名单
        Thread.sleep(3000);
        mainPageForShopKeeper.getfenxiaoshezhi().click();
        mainPageForShopKeeper.gettichengshuru().sendKeys("8");
        Thread.sleep(500);
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getbianjimingdan().click();
        mainPageForShopKeeper.getheimingdan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2500);
        mainPageForShopKeeper.getheimingdan().click();//黑名单
        Thread.sleep(2000);
        mainPageForShopKeeper.getbianjimingdan().click();
        mainPageForShopKeeper.getbaimingdan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getbaimingdan().click();
        Thread.sleep(2000);
        Reporter.log("分销商品");
        driver.findElementByClassName("android.widget.ImageView").click();
    }


    @Test(priority = 22)//任务中心
    public void 任务中心() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getrenwuzhongxin().click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"任务中心\")");
        mainPageForShopKeeper.getshuoming().click();
        mainPageForShopKeeper.getwozhidaole().click();
        mainPageForShopKeeper.getchakangengduorenwu().click();
        Thread.sleep(2500);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getyuefan().click();
        mainPageForShopKeeper.getnianfan().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getback().click();
        Thread.sleep(100);
        mainPageForShopKeeper.getback().click();
        Reporter.log("任务中心");
    }


    @Test(priority = 23)//店铺类目
    public void 店铺类目() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"店铺类目\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"排序\")").click();//一级类目排序
        Thread.sleep(500);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//向上
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();//向下
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();//向下
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();//置顶
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();//置顶
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"二级类目\")").click();//二级类目排序
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"排序\")").click();
        Thread.sleep(500);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//向上
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();//向下
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();//向下
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();//置顶
        Thread.sleep(100);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.TextView[1]").click();//置顶
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("店铺类目");
    }


    @Test(priority = 24)//员工管理   此处有滑动
    public void 员工管理() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.huadong();//滑动
        mainPageForShopKeeper.huadong();//滑动
        mainPageForShopKeeper.getyuangongguanli().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getyuangongerweima().click();//员工二维码
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        mainPageForShopKeeper.getbianji().click();//编辑
        mainPageForShopKeeper.getxiaoshoujingli().click();
        mainPageForShopKeeper.getshouyinyuan().click();
        mainPageForShopKeeper.getpeisongyuan().click();
        mainPageForShopKeeper.getdianzhang().click();
        mainPageForShopKeeper.getqiyong().click();
        mainPageForShopKeeper.gettingyong1().click();
        mainPageForShopKeeper.getquxiao().click();
        mainPageForShopKeeper.getbianji().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getxinzeng().click();//新增
        mainPageForShopKeeper.getqueren().click();
        mainPageForShopKeeper.getquxiao().click();
        Thread.sleep(100);
        mainPageForShopKeeper.getxinzeng().click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("厉害了");
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.EditText[1]").sendKeys("17671607988");//输入手机号
        mainPageForShopKeeper.getdianzhang().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("7988");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("员工管理");
    }


    @Test(priority = 24)//员工业绩
    public void 员工业绩() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getyuangongyeji().click();
        Thread.sleep(3000);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]").click();//查看收银业绩
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"收银业绩\")");
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]").click();//查看收银提成明细
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"收银提成明细\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"收银员\")").click(); //切换销售经理业绩
        driver.findElementByAndroidUIAutomator("text(\"销售经理\")").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]").click();//进入详情
        Thread.sleep(2500);
        mainPageForShopKeeper.getxiaoshoue().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getkehu().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getweixiadanhuiyuan().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getyixiadanhuiyuan().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinhuiyuan().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxiaoshouticheng().click();
        Thread.sleep(1500);
        driver.findElementByClassName("android.widget.ImageView").click();//返回列表
        Thread.sleep(100);
        mainPageForShopKeeper.getxiaoshoujingli1().click();
        mainPageForShopKeeper.getshouyinyuan1().click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("员工业绩");
    }


    @Test(priority = 25)//二维码推广 1我的员工码 2销售推广码
    public void 二维码推广() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.geterweimatuiguang().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.gettuiguangshuju().click();//查看推广数据
        Thread.sleep(2000);
        mainPageForShopKeeper.getxiadanhuiyuan().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getzhucehuiyuan().click();
        Thread.sleep(1000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();//返回
        mainPageForShopKeeper.getchakanerweima().click();//查看二维码
        Thread.sleep(1000);
        mainPageForShopKeeper.getbaocuntupian().click();
        Thread.sleep(1000);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        mainPageForShopKeeper.getxinzeng().click();//新增   销售推广码
        Thread.sleep(1000);
        mainPageForShopKeeper.getxiaoshoujingli1().click();
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]").click();
        mainPageForShopKeeper.getxinzeng().click();//名称为空无法新增
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("你大爷还是你大爷");
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"销售推广码\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"你大爷还是你大爷\")");
        driver.findElementByAndroidUIAutomator("text(\"查看推广数据\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.ImageView").click();
        driver.findElementByAndroidUIAutomator("text(\"查看二维码\")").click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.ImageView").click();
        driver.findElementByAndroidUIAutomator("text(\"作废\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("二维码推广");
        }

    @Test(priority = 26)//角色权限 1app权限 2POS权限  查询 编辑 重置还原
    public void 角色权限() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("text(\"角色权限\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"管家APP系统角色权限\")").click();//app权限
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"权限初始化\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"查看权限\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"报表\")").click();
        driver.findElementByAndroidUIAutomator("text(\"商品\")").click();
        driver.findElementByAndroidUIAutomator("text(\"会员与员工\")").click();
        driver.findElementByAndroidUIAutomator("text(\"库存\")").click();
        driver.findElementByAndroidUIAutomator("text(\"门店\")").click();
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"订单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"报表\")").click();
        driver.findElementByAndroidUIAutomator("text(\"商品\")").click();
        driver.findElementByAndroidUIAutomator("text(\"会员与员工\")").click();
        driver.findElementByAndroidUIAutomator("text(\"库存\")").click();
        driver.findElementByAndroidUIAutomator("text(\"门店\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"POS收银系统角色权限\")").click();//POS权限
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"权限初始化\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"查看权限\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"收银\")").click();
        driver.findElementByAndroidUIAutomator("text(\"商品\")").click();
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"编辑\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"收银\")").click();
        driver.findElementByAndroidUIAutomator("text(\"商品\")").click();
        driver.findElementByAndroidUIAutomator("text(\"会员\")").click();
        driver.findElementByAndroidUIAutomator("text(\"设置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("角色权限");
    }




    @Test(priority = 27)//库存管理
    public void 库存管理() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getkucunguanli().click();
        Thread.sleep(2500);
        mainPageForShopKeeper.getputaojiu().click();
        mainPageForShopKeeper.getputaojiu().click();
        Thread.sleep(1000);
        driver.findElementByAccessibilityId("测试控件_搜索输入框").sendKeys("酒鬼");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2500);
        String mingcheng = driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[7]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        boolean c=mingcheng.contains("酒鬼");
        Assert.assertTrue(c,"搜索到的内容有误");
        mainPageForShopKeeper.getkucunbiandongmingxi().click();
        Thread.sleep(1500);
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");
        xuanze.get(3).click();//选择开始时间
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(500);
        mainPageForShopKeeper.getshezhikucunyujing().click();
        mainPageForShopKeeper.getquxiao().click();
        mainPageForShopKeeper.getshezhikucunyujing().click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("3");
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"库存预警：3瓶\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("库存管理");
    }


    @Test(priority = 28)//进货管理 1查询 2进货 3退货
    public void 进货管理() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getjinhuoguanli().click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("测试控件_时间控件_起").click();
        Thread.sleep(500);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getyitijiao().click();
        Thread.sleep(500);
        mainPageForShopKeeper.getyiquxiao().click();
        Thread.sleep(500);
        mainPageForShopKeeper.getyiruku().click();
        Thread.sleep(500);
        mainPageForShopKeeper.getquanbu().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getquanbugongyingshang().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"本地供应商\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"本地供应商\")").click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getquanbugongyingshang().click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("茅台");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);

        mainPageForShopKeeper.getdianpuzicai().click();//店铺自采  进货
        List<AndroidElement> sousuo = driver.findElementsByClassName("android.widget.ImageView");
        sousuo.get(1).click();//搜索
        List<AndroidElement> sousuokuang = driver.findElementsByClassName("android.widget.EditText");
        sousuokuang.get(0).sendKeys("茅台葡萄酒");
        mainPageForShopKeeper.getSearch().click();//搜索
        mainPageForShopKeeper.getSearch().click();
        Thread.sleep(2500);
        MobileElement jiahao = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]");
        jiahao.click();
        jiahao.click();
        Thread.sleep(3000);
        List<AndroidElement> jiage = driver.findElementsByClassName("android.widget.EditText");
        jiage.get(0).clear();
        jiage.get(0).sendKeys("20");
        List<AndroidElement> shuliang = driver.findElementsByClassName("android.widget.EditText");
        shuliang.get(1).sendKeys("3");
        mainPageForShopKeeper.getjiarugouwuche().click();
        Thread.sleep(2500);
        try {
            driver.findElementByAndroidUIAutomator("text(\"去进货\")");
        }
        catch (Exception e){
            driver.findElementByAndroidUIAutomator("text(\"继续\")").click();
            Thread.sleep(2500);
            driver.findElementByAndroidUIAutomator("text(\"去进货\")");
        }
        finally {
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            mainPageForShopKeeper.getqujinhuo().click();
            Thread.sleep(2000);
            mainPageForShopKeeper.gettijiao().click();
            Thread.sleep(500);
            List<AndroidElement> gouxuan3 = driver.findElementsByClassName("android.widget.ImageView");
            gouxuan3.get(3).click();//勾选
            mainPageForShopKeeper.gettijiao().click();
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("text(\"提交成功\")");//校验提交成功
            Thread.sleep(2000);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(1000);

            driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]").click();  //打开进货单详情退货
            Thread.sleep(1000);
            mainPageForShopKeeper.gettuihuo().click();//新建退货单
            Thread.sleep(2500);
            mainPageForShopKeeper.gettijiao().click();//未勾选点击提交
            Thread.sleep(500);
            List<AndroidElement> gouxuan = driver.findElementsByClassName("android.widget.ImageView");
            gouxuan.get(1).click();//勾选
            Thread.sleep(100);
            List<AndroidElement> gouxuan1 = driver.findElementsByClassName("android.widget.ImageView");
            gouxuan1.get(2).click();//取消勾选
            mainPageForShopKeeper.gettijiao().click();//未勾选点击提交
            Thread.sleep(500);
            gouxuan1.get(2).click();//再次勾选
            mainPageForShopKeeper.gettijiao().click();
            Thread.sleep(100);
            driver.findElementByAndroidUIAutomator("text(\"商品破损 \")").click();
            mainPageForShopKeeper.gettijiao().click();
            Thread.sleep(1000);
            //driver.findElementByAndroidUIAutomator("text(\"提交成功\")");//校验提交成功
            Thread.sleep(2000);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            mainPageForShopKeeper.gettuihuodan().click();//退货单
            mainPageForShopKeeper.getqueren().click();
            Thread.sleep(2500);
            mainPageForShopKeeper.getyitijiao().click();
            Thread.sleep(500);
            mainPageForShopKeeper.getyituihuo().click();
            Thread.sleep(500);
            mainPageForShopKeeper.getyijujue().click();
            Thread.sleep(500);
            mainPageForShopKeeper.getquanbu().click();
            Thread.sleep(2500);
            //mainPageForShopKeeper.getxiangming().click();
            driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]").click();//打开详情
            Thread.sleep(1000);
            driver.findElementByClassName("android.widget.ImageView").click();
            Thread.sleep(500);
            mainPageForShopKeeper.getjinhuodan().click();//进货单
            mainPageForShopKeeper.getqueren().click();
            Thread.sleep(2500);
            driver.findElementByClassName("android.widget.ImageView").click();
            Reporter.log("进货管理");
        }
    }

    @Test(priority = 29)//库存调拨
    public void 库存调拨() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getkucundiaobo().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getdiaochudan().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getdiaorudan().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getdiaobodan().click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//查看详情
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"调拨单详情\")");//校验页面正确
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(2000);

        mainPageForShopKeeper.getxinzeng().click();//新增
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"调入店铺\")").click();//选择调入店铺
        //mainPageForShopKeeper.getfeifeijiuba1().click();
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店 \")").click();
        Thread.sleep(100);
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getqueding().click();//未勾选商品点击确认无效
        Thread.sleep(100);
        List<AndroidElement> gouxuan = driver.findElementsByClassName("android.widget.ImageView");
        gouxuan.get(3).click();//勾选
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(100);
        mainPageForShopKeeper.getbaocun().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.gettijiaodiaobodan().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("库存调拨");
    }


    @Test(priority = 30)//盘存单
    public void 盘存单() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getpancundan().click();//盘存单
        Thread.sleep(2000);
        List<AndroidElement> riqi = driver.findElementsByClassName("android.widget.ImageView");
        riqi.get(3).click();
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        //mainPageForShopKeeper.getpancunren().click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//查看详情
        Thread.sleep(2500);
        driver.findElementByAndroidUIAutomator("text(\"详细信息\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinjianpancundan().click();//新建盘存单
        Thread.sleep(100);
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getqueding().click();//未勾选商品点击确认无效
        Thread.sleep(100);
        List<AndroidElement> gouxuan1 = driver.findElementsByClassName("android.widget.ImageView");
        gouxuan1.get(3).click();//勾选
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(100);
        mainPageForShopKeeper.getbaocun().click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//查看详情
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//查看详情
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"提交\")").click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("盘存单");
    }

    @Test(priority = 31)//报损单
    public void 报损单() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getbaosundan().click();//报损单
        Thread.sleep(2500);
        List<AndroidElement> riqi = driver.findElementsByClassName("android.widget.ImageView");
        riqi.get(3).click();
        Thread.sleep(1000);
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//查看详情
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"详细信息\")");
        driver.findElementByClassName("android.widget.ImageView").click();
        Thread.sleep(100);
        mainPageForShopKeeper.getxinjianbaosundan().click();//新建报损单
        Thread.sleep(100);
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(3000);
        mainPageForShopKeeper.getqueding().click();//未勾选商品点击确认无效
        Thread.sleep(100);
        List<AndroidElement> gouxuan2 = driver.findElementsByClassName("android.widget.ImageView");
        gouxuan2.get(3).click();//勾选
        mainPageForShopKeeper.getqueding().click();
        mainPageForShopKeeper.gettijiao().click();
        Thread.sleep(2500);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("报损单");
    }



    @Test(priority = 32)//门店设置
    public void 门店设置() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getmendianshezhi().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getbianji().click();//编辑
        Thread.sleep(500);
        List<AndroidElement> riqi = driver.findElementsByClassName("android.widget.ImageView");
        riqi.get(2).click();//开始日期
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(500);
        List<AndroidElement> riqi1 = driver.findElementsByClassName("android.widget.ImageView");
        riqi1.get(3).click();//结束日期
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(500);
        List<AndroidElement> shuru = driver.findElementsByClassName("android.widget.EditText");
        shuru.get(0).clear();//配送费
        shuru.get(0).sendKeys("1");
        Thread.sleep(500);
        List<AndroidElement> shuru1 = driver.findElementsByClassName("android.widget.EditText");
        shuru1.get(1).clear();//配送公里
        shuru1.get(1).sendKeys("100");
        Thread.sleep(500);
        List<AndroidElement> shuru2 = driver.findElementsByClassName("android.widget.EditText");
        shuru2.get(2).clear();//免费配送金额
        shuru2.get(2).sendKeys("600");
        Thread.sleep(500);
        MobileElement kaiguan = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[12]/android.widget.ImageView[1]");//负库存收银
        kaiguan.click();
        Thread.sleep(200);
        kaiguan.click();
        mainPageForShopKeeper.getbaocun().click();
        Thread.sleep(2000);
        driver.findElementByClassName("android.widget.ImageView").click();
        Reporter.log("门店设置");
    }


    @Test(priority = 33)//供应商管理
    public void gongyingshangguanlitest() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getgongyingshangguanli().click();
        mainPageForShopKeeper.gethuazhi().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getbianji().click();//编辑
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getxinzeng().click();//新增
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinzeng().click();
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();//返回
        Thread.sleep(500);
        mainPageForShopKeeper.gethuazhi().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getgongyingshangshangpin().click();//供应商商品
        mainPageForShopKeeper.getshanchu().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        mainPageForShopKeeper.getshanchu().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.gettianjia().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getputaojiu().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getquanbutianjia().click();
        Thread.sleep(1000);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();//返回
        Thread.sleep(500);
        List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
        backButton2.get(0).click();
        Thread.sleep(200);
        List<AndroidElement> backButton3 = driver.findElementsByClassName("android.widget.ImageView");
        backButton3.get(0).click();
        Reporter.log("供应商管理");
    }
//    @Test(priority = 32)//next case
//    public void nextCase(){
//        JUnitCore core= new JUnitCore();
//        core.run(a1shangpincase.class);
//    }
    @Test(priority = 34)//商城公告
    public void 商城公告() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getshangchenggonggao().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinzenggonggao().click();
        mainPageForShopKeeper.getqueding().click();
        mainPageForShopKeeper.getquxiao().click();
        List<AndroidElement> qiehuan = driver.findElementsByClassName("android.widget.ImageView");
        qiehuan.get(1).click();//切换店铺
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"易酒批零明珠2店\")").click();
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();//返回
        Reporter.log("商城公告");

}

    @Test(priority = 35)//投诉与建议
    public void 投诉与建议() throws InterruptedException {}


    @Test(priority = 36)//消息
    public void 消息() throws InterruptedException {}

    @Test(priority = 37)//我的
    public void 我的() throws InterruptedException {}



    }