/*
会员的测试,目前独立出来了

*/


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Huiyuan_test extends BaseForShopKeeper {
    private AndroidDriver driver;//全局变量

    public static void main(String[] args) {
        Huiyuan_test huiyuan=new Huiyuan_test();
        try {
            huiyuan.setUp();
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
        driver = (AndroidDriver) BaseForShopKeeper.SetUp();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //隐式等待
    }
    @AfterClass//结束关闭App
    public void tearDown() {
        //driver.closeApp();
    }




    @Test//等待9秒(priority = 1)
    public void 启动等待() throws InterruptedException {
        Reporter.log("启动成功");
        Thread.sleep(9000);
        //waittool.waittool(driver, By.name("易酒批零西藏舞阳店"), 15);// 等待某元素加载，5S未能加载变为超时
        //waittool.waittool(driver, (By) driver.findElementByAndroidUIAutomator("text(\"易酒批零西藏舞阳店\")"),15);

    }


    /*首先滑动屏幕打开会员管理
    会员列表: 切换列表   还款   变更会员类型  设置会员价格  设置顺便带 设置会员标签
    会员详情: 赊账记录   变更会员状态   会员订单 编辑会员
    新增会员
    */
    @Test(priority = 2)//会员管理____会员列表
    public void huiyuanliebiao() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        Thread.sleep(100);
        //mainPageForShopKeeper.huadong();
        driver.findElementByAndroidUIAutomator("text(\"会员关系\")").click();
        mainPageForShopKeeper.gethuiyuanguanli().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"会员管理\")");
        Reporter.log("已打开会员管理");}


    @Test(priority = 3)//会员管理____搜索会员
    public void search() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getzhuceshijian().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getshezhangjine().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getshezhangedu().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxiadanshijian().click();
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("17671607988");
        mainPageForShopKeeper.getSearch().click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"  17671607988\")");//校验搜索成功
        Reporter.log("搜索会员");}




    @Test(priority = 4)//会员管理____还款  (条件是不要有低于1块钱的赊账,不然可能有问题)
    public void huankuan() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        Thread.sleep(100);
        //首先获取之前的赊账金额
        MobileElement beforeNum= (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[8]");
        String num1=beforeNum.getText();
      /*  String num1=num1.replace(",","");
        System.out.println(num1);
        int nu1=Integer.parseInt(num1);*/
        int nu1=Integer.parseInt(Pattern.compile("[^0-9]").matcher(num1).replaceAll("").trim());//把字符串转换为整数,同时去掉当中的逗号
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"还款\"));");
        mainPageForShopKeeper.gethuankuan().click();    //还款
        mainPageForShopKeeper.gethuankuan().click();
        mainPageForShopKeeper.gethuankuanshuru().sendKeys("1");
        List<AndroidElement> xuanze = driver.findElementsByClassName("android.widget.ImageView");//请选择
        xuanze.get(1).click();
        Thread.sleep(3000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView").click();
        driver.findElementById("android:id/date_picker_header_year").click();
        driver.findElementByAndroidUIAutomator("text(\"2017\")").click();
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(3000);
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView").click();
        driver.findElementByAndroidUIAutomator("text(\"确定(1)\")").click();
       // List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        //backButton.get(0).click();//返回
        Thread.sleep(500);
        List<AndroidElement> xuanze1 = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"请选择\")");
        xuanze1.get(0).click();
        mainPageForShopKeeper.getxianjin().click();
        mainPageForShopKeeper.getzhifubao().click();
        mainPageForShopKeeper.getweixin().click();
        mainPageForShopKeeper.getyinhangzhuanzhang().click();
        List<AndroidElement> guanbi = driver.findElementsByClassName("android.widget.ImageView");//请选择
        guanbi.get(0).click();//关闭窗口,x和>属性相同
        mainPageForShopKeeper.getqueren().click();
        //List<AndroidElement> backButton1 = driver.findElementsByClassName("android.widget.ImageView");
        //backButton1.get(0).click();
        Thread.sleep(3000);
        MobileElement afterNum= (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[8]");
        String num2=beforeNum.getText();
        num2=num2.replace(",","");
        int nu2=Integer.parseInt(num2);
        Assert.assertEquals(nu1-1,nu2,"还款后的赊账金额不正确");
        System.out.println(nu1+"  "+nu2);
        Reporter.log("还款完成");}


    @Test(priority = 5)//会员管理____变更会员类型
    public void biangengleixing() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        Thread.sleep(100);
        mainPageForShopKeeper.getbiangengleixing().click();//变更会员类型
        mainPageForShopKeeper.getpifahuiyuan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"批发会员\")");//校验变更成功没有
        mainPageForShopKeeper.getbiangengleixing().click();
        mainPageForShopKeeper.getputonghuiyuan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"普通会员\")");//校验变更成功没有
        mainPageForShopKeeper.getbiangengleixing().click();
        mainPageForShopKeeper.getviphuiyuan().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"VIP会员\")");//校验变更成功没有
        Reporter.log("变更会员类型");
    }

    @Test(priority = 6)//会员管理____设置/清空会员价格
    public void huiyuanjia() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.gethuiyuanjiage().click();//设置会员价格
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"设置会员价格\")").click();
        List<AndroidElement> jiageshuru = driver.findElementsByClassName("android.widget.EditText");
        jiageshuru.get(0).sendKeys("30");
        mainPageForShopKeeper.getqueding().click();
        try {
            mainPageForShopKeeper.getjixushezhi().click();
        } catch (Exception e) {
        } finally {
            Thread.sleep(2000);
            driver.findElementByAndroidUIAutomator("text(\"30\")");
            mainPageForShopKeeper.getqingkongjiage().click();
            mainPageForShopKeeper.getqueren().click();
            Thread.sleep(2500);
            String num=driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[3]").getText();
            SoftAssert assertion = new SoftAssert();
            assertion.assertEquals(num,"---","会员价清除失败,显示的不是---");//软断言,失败后不会停止运行
            //Assert.assertEquals(num,"---","会员价清除失败,显示的不是---");
            List<AndroidElement> backButton2 = driver.findElementsByClassName("android.widget.ImageView");
            backButton2.get(0).click();
            Reporter.log("设置/清空会员价格");
            assertion.assertAll();
        }
    }

    @Test(priority = 7)//会员管理____设置顺便带
    public void shunbiandai() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"设置顺便带\"));");//滑动直到找到元素为止,webview为变量
        try {
            mainPageForShopKeeper.getshunbiandai().click();//设置顺便带
            Thread.sleep(1000);
            mainPageForShopKeeper.getquxiaoshunbiandai().click();//取消设置顺便带
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("text(\"设置顺便带\")");
        } catch (Exception e) {
            mainPageForShopKeeper.getquxiaoshunbiandai().click();//取消设置顺便带
            Thread.sleep(1000);
            mainPageForShopKeeper.getshunbiandai().click();//设置顺便带
            Thread.sleep(1000);
            driver.findElementByAndroidUIAutomator("text(\"取消顺便带\")");
        } finally {
            Reporter.log("设置顺便带");
        }
    }

    @Test(priority = 8)//会员管理____会员标签
    public void biaoqian() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.gethuiyuanbiaoqian().click();//设置会员标签
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("text(\"重置\")").click();
        driver.findElementByAndroidUIAutomator("text(\"保存\")").click();
        //mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        Reporter.log("设置会员标签");}


    @Test(priority = 9)//会员管理____赊账额度
    public void shezhangedu() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getzuihouxiadan().click();//会员详情_赊账额度
        Thread.sleep(1000);
        List<AndroidElement> shezhangedu = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"赊账额度\")");
        shezhangedu.get(1).click();//赊账额度
        List<AndroidElement> edushuru = driver.findElementsByClassName("android.widget.EditText");
        edushuru.get(0).clear();
        edushuru.get(0).sendKeys("8888.8");
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"8888.8\")");
        shezhangedu.get(1).click();//赊账额度
        List<AndroidElement> edushuru1 = driver.findElementsByClassName("android.widget.EditText");
        edushuru1.get(0).clear();
        edushuru1.get(0).sendKeys("9999.9");
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"9999.9\")");
        Reporter.log("变更赊账额度");
        mainPageForShopKeeper.getshezhangjilu().click();//赊账记录
        Thread.sleep(2500);
        driver.navigate().back();//返回
        Reporter.log("打开赊账记录");}


    @Test(priority = 10)//会员管理____变更会员状态
    public void huiyuanzhuangtai() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getbiangengzhuangtai().click();//变更会员状态
        mainPageForShopKeeper.gettingyong().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"停用\")");
        mainPageForShopKeeper.getbiangengzhuangtai().click();
        mainPageForShopKeeper.getdongjie().click();
        mainPageForShopKeeper.getqueding().click();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"冻结\")");
        mainPageForShopKeeper.getbiangengzhuangtai().click();
        mainPageForShopKeeper.getzhengchang().click();
        mainPageForShopKeeper.getqueding().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"正常\")");
        Reporter.log("变更会员状态");}


    @Test(priority = 11)//会员管理____会员订单
    public void huiyuandingdan() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.gethuiyuandingdan().click();//会员订单
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"会员订单\")");
        driver.findElementByAndroidUIAutomator("text(\"已接单\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已完成\")").click();
        driver.findElementByAndroidUIAutomator("text(\"已取消\")").click();
        driver.findElementByAndroidUIAutomator("text(\"待接单\")").click();
        Thread.sleep(2500);
        List<AndroidElement> backButton3 = driver.findElementsByClassName("android.widget.ImageView");
        backButton3.get(0).click();
        Reporter.log("会员订单");}

    @Test(priority = 12)//会员管理____赠送红包
    public void zengsonghongbao() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
        Thread.sleep(100);
        driver.findElementByClassName("android.widget.EditText").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("15271727066");
        driver.findElementByAndroidUIAutomator("text(\"搜索\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"  15271727066\")");
        driver.findElementByAndroidUIAutomator("text(\"最后下单时间：\")").click();//打开会员详情
        driver.findElementByAndroidUIAutomator("text(\"最后下单时间：\")").click();//打开会员详情
        Thread.sleep(2500);
        mainPageForShopKeeper.huadong();//上滑,页面向下滑动
        Thread.sleep(100);
        mainPageForShopKeeper.huadong();//上滑
        Thread.sleep(100);
        mainPageForShopKeeper.huadong();//上滑
        Thread.sleep(100);
        mainPageForShopKeeper.xiahua();//下滑,页面向上
        Thread.sleep(100);
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"赠送红包\"));");//滑动直到找到元素为止,webview为变量
        driver.findElementByAndroidUIAutomator("text(\"赠送红包\")").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("2.5");
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"2.5元红包\")");//校验红包发成功了没
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
        Thread.sleep(1000);
        //driver.findElementByAndroidUIAutomator("text(\"已废弃\")");//校验废弃成功,但是无法识别这个提示,所以放弃了
        Reporter.log("赠送红包");

    }


    @Test(priority = 13)//会员管理____新增赠品券
    public void zengpinquan() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.huadong();//上滑
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"发放赠品券\"));");//滑动直到找到元素为止,webview为变量
        driver.findElementByAndroidUIAutomator("text(\"发放赠品券\")").click();
        Thread.sleep(1000);
        List<AndroidElement> backButton = driver.findElementsByClassName("android.widget.ImageView");
        backButton.get(0).click();
    }

    @Test(priority = 14)//会员管理____编辑会员
    public void huiyuanbianji() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getbianji().click();//编辑
        Thread.sleep(1000);
        driver.findElementByClassName("android.widget.EditText").clear();
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(1000);//没有填会员名无法保存
        List<AndroidElement> edittext = driver.findElementsByClassName("android.widget.EditText");
        edittext.get(0).sendKeys("西酱");
        edittext.get(2).sendKeys("没有");
        driver.findElementByAndroidUIAutomator("text(\"男\")").click();
        driver.findElementByAndroidUIAutomator("text(\"女\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//生日
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        edittext.get(3).sendKeys("不知道");
        edittext.get(4).sendKeys("还是不知道");
        mainPageForShopKeeper.getqueren().click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("text(\"编辑\")");
        mainPageForShopKeeper.getback().click();
        //driver.navigate().back();//返回
        Reporter.log("编辑会员");
    }

    @Test(priority = 15)//会员管理____新增会员
    public void huiyuanxinzeng() throws InterruptedException {
        MainPageForShopKeeper mainPageForShopKeeper = new MainPageForShopKeeper(driver);
        mainPageForShopKeeper.getxinzenghuiyuan().click();
        Thread.sleep(1000);
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"新增\")");//未填会员名称无法新增成功
        List<AndroidElement> edittext = driver.findElementsByClassName("android.widget.EditText");
        edittext.get(0).sendKeys("GYW+1");
        edittext.get(1).sendKeys("17671607988");
        driver.findElementByAndroidUIAutomator("text(\"普通会员\")").click();
        driver.findElementByAndroidUIAutomator("text(\"批发会员\")").click();
        driver.findElementByAndroidUIAutomator("text(\"VIP会员\")").click();
        edittext.get(2).sendKeys("9999");
        edittext.get(3).sendKeys("厉害了老铁");
        driver.findElementByAndroidUIAutomator("text(\"女\")").click();
        driver.findElementByAndroidUIAutomator("text(\"男\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();//生日
        driver.findElementByAndroidUIAutomator("text(\"确定\")").click();
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[8]/android.widget.EditText[1]").sendKeys("一直很厉害");
        driver.findElementByXPath("//android.view.ViewGroup/android.view.ViewGroup[9]/android.widget.EditText[1]").sendKeys("还是很厉害");
        mainPageForShopKeeper.getxinzeng().click();
        Thread.sleep(1500);
        driver.findElementByAndroidUIAutomator("text(\"新增\")");//已有手机号相同的会员,无法新增成功
        mainPageForShopKeeper.getback().click();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("text(\"会员管理\")");
        Reporter.log("新增会员");
        mainPageForShopKeeper.getback().click();//返回
    }

}
