import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class shangpincase extends BaseForShopKeeper{

    private AndroidDriver driver;//全局变量

    public static void main(String[] args) {
        shangpincase shangpincase=new shangpincase();
        try {
            shangpincase.setUp();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass//开始启动
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = BaseForShopKeeper.SetUp();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
    }
    @AfterClass//结束关闭App
    public void tearDown() {
        //driver.closeApp();
    }



    /* 盘存 置顶 改价规格 进货外采
    成本价 提成 作废 商品编辑 搜索 取消作废
    商品  五粮液金牌 用来进货
    类目 白酒汾酒  用来外采
    第一次编辑需要手动授权,或者写好try catch也行

    */

    @Test//等待9秒(priority = 1)
    public void 启动等待() throws InterruptedException {
        Thread.sleep(9000);
        //waittool.waittool(driver, By.name("易酒批零西藏舞阳店"), 15);// 等待某元素加载，5S未能加载变为超时
        //waittool.waittool(driver, (By) driver.findElementByAndroidUIAutomator("text(\"易酒批零西藏舞阳店\")"),15);
        Reporter.log("启动成功");
    }

    @Test(dependsOnMethods="启动等待")//商品管理-盘存
    public void 商品盘存() throws InterruptedException{
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.huadong();
        //mainPageForShopKeeper.huadong();
        Thread.sleep(100);
        shopPageForShopKeeper.getShopManagement().click();//打开商品管理
        Thread.sleep(2000L);
        driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]").click();//搜索
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("五粮液金牌");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(3000L);
        shopPageForShopKeeper.getTakeInventory().click();  //盘存
        shopPageForShopKeeper.getTakeInventory().click();
        List<AndroidElement> inventoryInputBox = driver.findElementsByClassName("android.widget.EditText");
        inventoryInputBox.get(0).sendKeys("433");
        Thread.sleep(200L);
        List<AndroidElement> inventoryInputBox2 = driver.findElementsByClassName("android.widget.EditText");
        inventoryInputBox2.get(1).sendKeys("3");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(3000L);
        driver.findElementByAndroidUIAutomator("text(\"库存：433件3瓶\")");
        Reporter.log("盘存");
    }

    @Test(dependsOnMethods="商品盘存")//置顶
    public void 置顶() throws InterruptedException {
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        shopPageForShopKeeper.getIsTop().click();  //置顶
        Thread.sleep(1000L);
        shopPageForShopKeeper.getCancelIsTop().click();  //取消置顶
        Thread.sleep(1000L);
        Reporter.log("置顶");
    }


    @Test(dependsOnMethods="置顶")//改价规格   先改成本价,不然可能改价不成功
    public void 改价规格() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        shopPageForShopKeeper.getxiangqing().click();//打开详情
        Thread.sleep(3000L);
        List<AndroidElement> chengbenjia = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"成本价\")");
        chengbenjia.get(1).click();
        List<AndroidElement> shurukuang6 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang6.get(0).sendKeys("5");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getgaijia().click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getxinzengguige().click();//新增规格
        shopPageForShopKeeper.getqingxuanze().click();
        Thread.sleep(2000L);
        shopPageForShopKeeper.getxinzeng().click();
        List<AndroidElement> shurukuang0 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang0.get(0).sendKeys("66");
        shopPageForShopKeeper.getquxiao().click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getping().click();
        Thread.sleep(500L);
        List<AndroidElement> shurukuang = driver.findElementsByClassName("android.widget.EditText");
        shurukuang.get(0).sendKeys("6");
        shurukuang.get(1).sendKeys("100");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        shopPageForShopKeeper.getgailingshoujia().click();//改零售价
        List<AndroidElement> shurukuang1 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang1.get(0).sendKeys("18");
        Thread.sleep(100L);
        shopPageForShopKeeper.getqueding().click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
      //shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"￥18.00\")");
        shopPageForShopKeeper.getgaipifajia().click();//改批发价
        List<AndroidElement> shurukuang2 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang2.get(0).sendKeys("1");
        shopPageForShopKeeper.getqueding().click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        //shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"¥17.00\")");
        shopPageForShopKeeper.getgaivipjia().click();//改vip价
        List<AndroidElement> shurukuang3 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang3.get(0).sendKeys("2");
        shopPageForShopKeeper.getqueding().click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        //shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\" ￥16.00\")");
        shopPageForShopKeeper.gettiaoma().click();//条码
        Thread.sleep(1000L);
        shopPageForShopKeeper.getxinzengtiaoma().click();//新增
        Thread.sleep(200L);
        List<AndroidElement> shurukuang4 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang4.get(0).sendKeys("666666666");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(3000L);
        driver.findElementByAndroidUIAutomator("text(\"666666666\")");
        Thread.sleep(100L);
        List<AndroidElement> shanchu = driver.findElementsByClassName("android.widget.ImageView");//删除
        shanchu.get(1).click();
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(1000L);
        List<AndroidElement> fanhui = driver.findElementsByClassName("android.widget.ImageView");
        fanhui.get(0).click();
        shopPageForShopKeeper.getxiajia().click();//上下架
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getshangjia().click();
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getxiugaidanwei().click();//修改单位
        Thread.sleep(1000L);
        shopPageForShopKeeper.getxinzeng().click();
        List<AndroidElement> shurukuang5 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang5.get(0).sendKeys("666");
        shopPageForShopKeeper.getquxiao().click();
        shopPageForShopKeeper.getping().click();
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(3000L);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Reporter.log("改价规格");
    }



    @Test(dependsOnMethods="改价规格")//-进货
    public void 进货() throws InterruptedException {
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        WebElement jinhuo = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"进货\"));");//进货
        jinhuo.click();
        Thread.sleep(2000L);
//        List<AndroidElement> guige = driver.findElementsByClassName("android.view.ViewGroup");
//        guige.get(4).click();
        //选中小规格
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
        el1.click();
        Thread.sleep(100L);
        shopPageForShopKeeper.getreplace().click();  //更换供应商
        Thread.sleep(1000L);
        shopPageForShopKeeper.getwujin().click();
        //driver.findElementByAndroidUIAutomator("text(\"本地供应商\")").click();
        List<AndroidElement> shuru = driver.findElementsByClassName("android.widget.EditText");
        shuru.get(0).clear();
        shuru.get(0).sendKeys("5");
        shuru.get(1).sendKeys("2");
        try {
            shopPageForShopKeeper.getjinhuo().click();
        }
        catch (Exception e){
            driver.findElementByAndroidUIAutomator("text(\"继续\")").click();
        }
        finally {
            Thread.sleep(3000L);
            driver.findElementByAndroidUIAutomator("text(\"库存：433件5瓶\")");
            Reporter.log("进货");
        }
       }



    @Test(dependsOnMethods="进货")//-外采  采购前先盘点确认库存
    public void 外采() throws InterruptedException {
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(100L);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Thread.sleep(100L);
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        List<AndroidElement> leimu = driver.findElementsByClassName("android.widget.ImageView");//先切换到汾酒类目
        leimu.get(3).click();
        shopPageForShopKeeper.getbaijiu().click();
        shopPageForShopKeeper.getfenjiu().click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"盘存\")").click();//盘点确定商品数量
        driver.findElementByClassName("android.widget.EditText").sendKeys("66");
        List<AndroidElement> shuru2 = driver.findElementsByClassName("android.widget.EditText");
        shuru2.get(1).sendKeys("3");
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000L);
        shopPageForShopKeeper.getwaicai().click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getwujin().click();
        Thread.sleep(1000L);
        /*MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
        el2.click();*/
        //guige.get(4).click();
        driver.findElementByAndroidUIAutomator("text(\"1瓶\")").click();
        mainPageForShopKeeper.getedit().clear();
        mainPageForShopKeeper.getedit().sendKeys("10");
        List<AndroidElement> shurukuang = driver.findElementsByClassName("android.widget.EditText");
        shurukuang.get(1).sendKeys("3");
        try {
            shopPageForShopKeeper.getwaicai().click();
        }
        catch (Exception e){
            driver.findElementByAndroidUIAutomator("text(\"继续\")").click();
        }
        finally {
        Thread.sleep(3000L);
        driver.findElementByAndroidUIAutomator("text(\"库存：67件\")");
        leimu.get(3).click();
        shopPageForShopKeeper.getquanbuleimu().click();
        Thread.sleep(1000L);
        // List<AndroidElement> jixu = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"继续\")");
        //jixu.get(0).click();
        Reporter.log("外采");
        }
    }



    @Test(dependsOnMethods="外采")//商品-成本价提成作废
    public void  成本价提成作废() throws InterruptedException {
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        shopPageForShopKeeper.getxiangqing().click();//打开详情
        Thread.sleep(3000L);
        List<AndroidElement> chengbenjia = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"成本价\")");
        chengbenjia.get(1).click();
        List<AndroidElement> shurukuang = driver.findElementsByClassName("android.widget.EditText");
        shurukuang.get(0).sendKeys("8.8");
        shopPageForShopKeeper.getqueding().click();
        //shopPageForShopKeeper.getqueding().click();
        Thread.sleep(1500L);
        driver.findElementByAndroidUIAutomator("text(\"¥8.80/瓶\")");
        Reporter.log("设置成本");


        /*shopPageForShopKeeper.getshezhiticheng().click();//设置提成
        List<AndroidElement> shurukuang0 = driver.findElementsByClassName("android.widget.EditText");
        shurukuang0.get(0).clear();
        shurukuang0.get(0).sendKeys("1.1");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);
        driver.findElementByAndroidUIAutomator("text(\"¥1.10/瓶\")");
        Reporter.log("设置提成");*/

        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");//返回
        backButton.get(0).click();
        shopPageForShopKeeper.getyixiajia().click();
        Thread.sleep(3000L);
        shopPageForShopKeeper.getTakeInventory().click(); //作废商品,先把商品库存盘存为0,方便作废
        List<AndroidElement> inventoryInputBox = driver.findElementsByClassName("android.widget.EditText");
        inventoryInputBox.get(0).sendKeys("0");
        Thread.sleep(200L);
        List<AndroidElement> inventoryInputBox2 = driver.findElementsByClassName("android.widget.EditText");
        inventoryInputBox2.get(1).sendKeys("0");
        shopPageForShopKeeper.getqueding().click();
        Thread.sleep(2000L);//盘存为0
        shopPageForShopKeeper.getxiangqing().click();//进入详情
        Thread.sleep(2000L);
        shopPageForShopKeeper.getzuofei().click();
        shopPageForShopKeeper.getquxiao().click();
        shopPageForShopKeeper.getzuofei().click();
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(2000L);
        Reporter.log("商品作废");
//        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");//返回
//        backButton1.get(0).click();
//        Thread.sleep(2000L);
    }


    @Test(dependsOnMethods="成本价提成作废")//商品编辑
    public void 编辑() throws InterruptedException {
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        shopPageForShopKeeper.getyishangjia().click();
        Thread.sleep(2000L);
        shopPageForShopKeeper.getxiangqing().click();//详情
        Thread.sleep(2000L);
        shopPageForShopKeeper.getEdit().click();//编辑
        shopPageForShopKeeper.getgenghuantupian().click();//更换图片
        shopPageForShopKeeper.getxiangji().click();//相机
        Thread.sleep(1000L);
        try{
            driver.findElementByAndroidUIAutomator("text(\"拍照\")");
            driver.navigate().back();//使用安卓自带返回键返回
        }
        catch  (Exception e)
        {
            driver.findElementByAndroidUIAutomator("text(\"始终允许\")").click();
            driver.findElementByAndroidUIAutomator("text(\"始终允许\")").click();
            System.out.println("需要授权拍照和存储权限");
            Thread.sleep(1000L);
            driver.findElementByAndroidUIAutomator("text(\"拍照\")");
            driver.navigate().back();//使用安卓自带返回键返回
        }
        finally {
        Thread.sleep(100L);
        //driver.pressKeyCode(AndroidKeyCode.BACK);//使用安卓自带返回键返回
        shopPageForShopKeeper.getgenghuantupian().click();
        shopPageForShopKeeper.getxiangce().click();//相册
        Thread.sleep(1000L);
        driver.navigate().back();//使用安卓自带返回键返回
        shopPageForShopKeeper.getgenghuantupian().click();
        shopPageForShopKeeper.getquxiao().click();
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");//选择类目
        backButton.get(2).click();
        Thread.sleep(1000L);
        shopPageForShopKeeper.getbaijiu().click();
        Thread.sleep(100L);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");//选择类目
        backButton1.get(0).click();
        Thread.sleep(100L);
        AndroidElement shurukuang = (AndroidElement) driver.findElementsByClassName("android.widget.EditText").get(1);//助记码输入框
        String zhujima=shurukuang.getText();
        shurukuang.clear();
        shurukuang.sendKeys(zhujima);
        backButton.get(3).click();//保质期-长期非长期
        backButton.get(4).click();
        Thread.sleep(500L);
        List<AndroidElement> shurukuang1 = driver.findElementsByClassName("android.widget.EditText");//日期输入
        shurukuang1.get(1).sendKeys("12");
        List<AndroidElement> danwei = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\" 请选择单位\")");
        danwei.get(0).click();
        List<AndroidElement> yue = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"月\")");
        yue.get(0).click();
        Thread.sleep(500L);
        backButton.get(3).click();//勾选长期
        Thread.sleep(500L);
//        WebElement gouxuan = driver.findElement(By.xpath("//android.widget.ImageView[@instance='5']"));//勾选
//        gouxuan.click();
//        gouxuan.click();
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[12]/android.widget.ImageView");
        el1.click();//勾选线上售卖
        el1.click();
        shopPageForShopKeeper.getSave().click();
        Thread.sleep(3000L);
        List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
        backButton2.get(0).click();
       /* List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
        backButton2.get(0).click();*/
        Thread.sleep(3000L);
        Reporter.log("商品编辑");
        }
        // driver.pressKeyCode(AndroidKeyCode.BACK);  //使用安卓自带返回键返回

    }
    @Test(dependsOnMethods="编辑")//商品搜索
    public void 搜索() throws InterruptedException {
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        List<AndroidElement> sousuo = driver.findElementsByClassName("android.widget.ImageView");
        sousuo.get(1).click();
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getSearchBar().sendKeys("mt");
        mainPageForShopKeeper.getSearch().click();
        Thread.sleep(2000);
        shopPageForShopKeeper.getyixiajia().click(); //已下架
        shopPageForShopKeeper.getyishangjia().click();
        Thread.sleep(1000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(500);
        List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        backButton1.get(0).click();
        Thread.sleep(500);
        shopPageForShopKeeper.getyixiajia().click(); //已下架
        shopPageForShopKeeper.getyishangjia().click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"全部\")").click();
        List<AndroidElement> shoumai = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"线上售卖\")");
        shoumai.get(0).click();
        Thread.sleep(1000);
        shoumai.get(0).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"非线上售卖\")").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"非线上售卖\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"全部\")").click();
        Thread.sleep(1000);
//        List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
//        backButton2.get(0).click();
        Reporter.log("商品搜索");
    }

//    @Test(priority = 16)//next case
//    public void nextCase() throws InterruptedException {
//        JUnitCore core= new JUnitCore();
//        core.run(RunTestnew.class);
//    }
    @Test(dependsOnMethods="搜索")//新增商品  (priority = 1)//
    public void 新增商品() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"新增商品\")").click();
        Thread.sleep(100);
        driver.findElementByAndroidUIAutomator("text(\"新增\")").click();
        driver.findElementByAndroidUIAutomator("text(\"请扫入条形码\")").click();
        Thread.sleep(100);
        try {
            Thread.sleep(5000);
            driver.findElementByAndroidUIAutomator("text(\"商品条码\")");
            driver.navigate().back();//使用安卓自带返回键返回
            //driver.findElementByClassName("android.widget.ImageView").click();//返回,这个在这里返回太慢了
        }
        catch (Exception e){
            PointOption point1 = PointOption.point(668, 1863);
            (new TouchAction(driver)).tap(point1).perform();
            driver.findElementByAndroidUIAutomator("text(\"始终允许\")").click();
            Thread.sleep(100);
            driver.navigate().back();//使用安卓自带返回键返回
            //driver.findElementByClassName("android.widget.ImageView").click();//返回
        }
        finally {
            driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
            Thread.sleep(2000);
            driver.findElementByAndroidUIAutomator("text(\"白酒\")").click();
            driver.findElementByAndroidUIAutomator("text(\"全兴\")").click();
            driver.findElementByAndroidUIAutomator("text(\"白酒-全兴\")");
            //driver.findElementByAndroidUIAutomator("text(\"益达无糖口香糖沁凉薄荷味32g\")").click();
            List<AndroidElement> edittext=driver.findElementsByClassName("android.widget.EditText");
            edittext.get(1).sendKeys("益达无糖口香糖沁凉薄荷味32g");
            driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
            Thread.sleep(2000);
            driver.findElementByAndroidUIAutomator("text(\"本地供应商\")").click();
            Thread.sleep(100);
            driver.findElementByAndroidUIAutomator("text(\"本地供应商\")");
            driver.findElementByAndroidUIAutomator("text(\"非散装商品\")").click();
            driver.findElementByAndroidUIAutomator("text(\"散装商品\")").click();
            driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[13]/android.widget.ImageView[1]").click();//非长期
            driver.findElementByAndroidUIAutomator("text(\"请填写保质期\")").sendKeys("2");
            driver.findElementByAndroidUIAutomator("text(\" 请选择单位\")").click();//选择日期
            //driver.findElementByAndroidUIAutomator("text(\" 请选择单位\")").click();//选择日期
            driver.findElementByAndroidUIAutomator("text(\"年\")").click();
            driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[12]/android.widget.ImageView[1]").click();//选择长期
            driver.findElementByAndroidUIAutomator("text(\"新增\")").click();//新增规格
            driver.findElementByAndroidUIAutomator("text(\"请选择\")").click();
            Thread.sleep(2000);
            driver.findElementByAndroidUIAutomator("text(\"瓶\")").click();
            driver.findElementByAndroidUIAutomator("text(\"请输入零售价\")").sendKeys("5");
            driver.findElementByAndroidUIAutomator("text(\"请输入/扫入条形码\")").sendKeys("1234567890");
            driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
            Thread.sleep(100);
            mainPageForShopKeeper.huadong();
            mainPageForShopKeeper.huadong();
            driver.findElementByAndroidUIAutomator("text(\"请输入成本价\")").sendKeys("3");
            driver.findElementByAndroidUIAutomator("text(\"请输入库存数\")").sendKeys("6");
            driver.findElementByAndroidUIAutomator("text(\"请填写商品介绍\")").sendKeys("新口味新上市,欢迎选购");
            driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.ImageView[1]").click();//添加图片
            //driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.ImageView[1]").click();//添加图片
            driver.findElementByAndroidUIAutomator("text(\"相机 \")").click();
            try {
                driver.findElementByAndroidUIAutomator("text(\"拍照\")");//校验是否到了拍照页面
            }
            catch (Exception e){
                driver.findElementByAndroidUIAutomator("text(\"始终允许\")").click();
                driver.findElementByAndroidUIAutomator("text(\"拍照\")");
                System.out.println("需要授权拍照");
            }
            finally {
                driver.navigate().back();//使用安卓自带返回键返回
                driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.ImageView[1]").click();//添加图片
                driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
                driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[10]/android.widget.ImageView[1]").click();//添加图片
                driver.findElementByAndroidUIAutomator("text(\"相册 \")").click();
                driver.findElementById("com.android.documentsui:id/icon_thumb").click();
                driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[1]").click();//新增
                driver.findElementByAndroidUIAutomator("text(\"取消\")").click();
                driver.findElementByXPath("//android.widget.FrameLayout/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[1]").click();//新增
                driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
                Thread.sleep(3000);
                driver.findElementByAndroidUIAutomator("text(\"新增\")");//前面提示商品已存在,无法再次新增
                Reporter.log("新增商品");
                List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
                backButton2.get(0).click();//返回首页
                Thread.sleep(100);
            }

        }

    }


    @Test(dependsOnMethods="新增商品")//取消作废商品
    public void 作废商品() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
        backButton2.get(0).click();//返回首页
        Thread.sleep(2000);
        mainPageForShopKeeper.huadong();
        Thread.sleep(1);
        ShopPageForShopKeeper shopPageForShopKeeper = new ShopPageForShopKeeper(driver);
        shopPageForShopKeeper.getzuofeishangpin().click();
        Thread.sleep(1500);
        shopPageForShopKeeper.getquxiaozuofei().click();
        shopPageForShopKeeper.getquxiao().click();
        shopPageForShopKeeper.getquxiaozuofei().click();
        shopPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Reporter.log("取消作废商品");
    }





}


















