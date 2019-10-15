import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShopPageForShopKeeper {
    AndroidDriver driver;
    public static final String WHOLESALEDISCOUNTAMOUNT = "1";
    public static final String INVENTORYAMOUNTBIGPACK = "2000";
    public static final String INVENTORYAMOUNTSMALLPACK = "1";

    //初始化页面
    public ShopPageForShopKeeper(AndroidDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
        //PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    //商品管理图标
    @AndroidFindBy(uiAutomator = "text(\"商品管理\")")
    AndroidElement shopManagement;
    //置顶按钮
    @AndroidFindBy(uiAutomator = "text(\"置顶\")")
    AndroidElement isTop;
    //取消置顶按钮
    @AndroidFindBy(uiAutomator = "text(\"取消置顶\")")
    AndroidElement cancelIsTop;
    //改价/规格
    @AndroidFindBy(uiAutomator = "text(\"改价/规格\")")
    AndroidElement gaijia;
    //新增规格
    @AndroidFindBy(uiAutomator = "text(\"新增规格\")")
    AndroidElement xinzengguige;
    //请选择
    @AndroidFindBy(uiAutomator = "text(\"请选择\")")
    AndroidElement qingxuanze;
    //改零售价
    @AndroidFindBy(uiAutomator = "text(\"改零售价\")")
    AndroidElement gailingshoujia;
    //改零售价
    @AndroidFindBy(uiAutomator = "text(\"改批发价\")")
    AndroidElement gaipifajia;
    //改VIP价
    @AndroidFindBy(uiAutomator = "text(\"改VIP价\")")
    AndroidElement gaivipjia;
    //条码
    @AndroidFindBy(uiAutomator = "text(\"条码\")")
    AndroidElement tiaoma;
    //上架
    @AndroidFindBy(uiAutomator = "text(\"上架\")")
    AndroidElement shangjia;
    //下架
    @AndroidFindBy(uiAutomator = "text(\"下架\")")
    AndroidElement xiajia;
    //确认
    @AndroidFindBy(uiAutomator = "text(\"确认\")")
    AndroidElement queren;
    //修改单位
    @AndroidFindBy(uiAutomator = "text(\"修改单位\")")
    AndroidElement xiugaidanwei;
    //新增
    @AndroidFindBy(uiAutomator = "text(\"新增\")")
    AndroidElement xinzeng;
    //瓶
    @AndroidFindBy(uiAutomator = "text(\"瓶\")")
    AndroidElement ping;
    @AndroidFindBy(uiAutomator = "text(\"新增条码\")")
    AndroidElement xinzengtiaoma;
    //取消按钮
    @AndroidFindBy(uiAutomator = "text(\"取消\")")
    AndroidElement quxiao;
    //白酒类目
    @AndroidFindBy(uiAutomator = "text(\"白酒\")")
    AndroidElement baijiu;
    //汾酒
    @AndroidFindBy(uiAutomator = "text(\"汾酒\")")
    AndroidElement fenjiu;
    //全部类目
    @AndroidFindBy(uiAutomator = "text(\"全部类目\")")
    AndroidElement quanbuleimu;
    //盘存按钮
    @AndroidFindBy(uiAutomator = "text(\"盘存\")")
    AndroidElement takeInventory;
    //确定按钮
    @AndroidFindBy(uiAutomator = "text(\"确定\")")
    AndroidElement queding;
    //设置提成
    @AndroidFindBy(uiAutomator = "text(\"设置提成\")")
    AndroidElement shezhiticheng;
    //进货
    @AndroidFindBy(uiAutomator = "text(\"进货\")")
    AndroidElement jinhuo;
    //进货
    @AndroidFindBy(uiAutomator = "text(\"外采\")")
    AndroidElement waicai;
    //更换(供应商)
    @AndroidFindBy(uiAutomator = "text(\"更换\")")
    AndroidElement replace;
    //本地供应商
    @AndroidFindBy(uiAutomator = "text(\"本地供应商\")")
    AndroidElement wujin;
    //编辑按钮
    @AndroidFindBy(uiAutomator = "text(\"编辑\")")
    AndroidElement edit;
    //保存按钮
    @AndroidFindBy(uiAutomator = "text(\"保存\")")
    AndroidElement save;
    //已上架
    @AndroidFindBy(uiAutomator = "text(\"已上架\")")
    AndroidElement yishangjia;
    //已下架
    @AndroidFindBy(uiAutomator = "text(\"已下架\")")
    AndroidElement yixiajia;
    //详情
    @AndroidFindBy(uiAutomator = "text(\"详情\")")
    AndroidElement xiangqing;
    //成本价
    @AndroidFindBy(uiAutomator = "text(\"成本价\")")
    AndroidElement chengbenjia;
    //作废
    @AndroidFindBy(uiAutomator = "text(\"作废商品\")")
    AndroidElement zuofei;
    //更换图片
    @AndroidFindBy(uiAutomator = "text(\"更换图片\")")
    AndroidElement genghuantupian;
    //相机
    @AndroidFindBy(uiAutomator = "text(\"相机 \")")
    AndroidElement xiangji;
    //相册
    @AndroidFindBy(uiAutomator = "text(\"相册 \")")
    AndroidElement xiangce;


    //作废商品
    @AndroidFindBy(uiAutomator = "text(\"作废商品\")")
    AndroidElement zuofeishangpin;
    //取消作废
    @AndroidFindBy(uiAutomator = "text(\"取消作废\")")
    AndroidElement quxiaozuofei;

    public AndroidDriver getDriver() {
        return driver;
    }
    public AndroidElement getShopManagement() {
        return shopManagement;
    }
    public AndroidElement getIsTop() {
        return isTop;
    }
    public AndroidElement getCancelIsTop() {
        return cancelIsTop;
    }
    public AndroidElement getquxiao() { return quxiao; }
    public AndroidElement getgaijia() {
        return gaijia;
    }
    public AndroidElement getxinzengguige() {
        return xinzengguige;
    }
    public AndroidElement getqingxuanze() {
        return qingxuanze;
    }
    public AndroidElement getgailingshoujia() {
        return gailingshoujia;
    }
    public AndroidElement getgaipifajia() {
        return gaipifajia;
    }
    public AndroidElement getgaivipjia() {
        return gaivipjia;
    }
    public AndroidElement gettiaoma() {
        return tiaoma;
    }
    public AndroidElement getshangjia() {
        return shangjia;
    }
    public AndroidElement getxiajia() {
        return xiajia;
    }
    public AndroidElement getqueren() {
        return queren;
    }
    public AndroidElement getxiugaidanwei() {
        return xiugaidanwei;
    }
    public AndroidElement getxinzeng() {
        return xinzeng;
    }
    public AndroidElement getping() {
        return ping;
    }
    public AndroidElement getxinzengtiaoma() {
        return xinzengtiaoma;
    }
    public AndroidElement getTakeInventory() {
        return takeInventory;
    }
    public AndroidElement getqueding() { return queding; }
    public AndroidElement getshezhiticheng() { return shezhiticheng; }
    public AndroidElement getjinhuo() { return jinhuo; }
    public AndroidElement getwaicai() { return waicai; }
    public AndroidElement getbaijiu() { return baijiu; }
    public AndroidElement getfenjiu() { return fenjiu; }
    public AndroidElement getquanbuleimu() { return quanbuleimu; }
    public AndroidElement getwujin() { return wujin; }
    public AndroidElement getEdit() { return edit; }
    public AndroidElement getSave() { return save; }
    public AndroidElement getyishangjia() { return yishangjia; }
    public AndroidElement getyixiajia() { return yixiajia; }
    public AndroidElement getxiangqing() { return xiangqing; }
    public AndroidElement getreplace() { return replace; }
    public AndroidElement getchengbenjia() { return chengbenjia; }
    public AndroidElement getzuofei() { return zuofei; }
    public AndroidElement getgenghuantupian() { return genghuantupian; }
    public AndroidElement getxiangji() { return xiangji; }
    public AndroidElement getxiangce() { return xiangce; }
    public AndroidElement getzuofeishangpin() { return zuofeishangpin; }
    public AndroidElement getquxiaozuofei() { return quxiaozuofei; }


}