import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPageForShopKeeper {
    AndroidDriver driver;
    public static final String USERNAME = "18888886666";
    public static final String PASSWORD = "886666";

    //初始化页面元素
    public LoginPageForShopKeeper(AndroidDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
//        PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),this);
    }

    //用户名
    @AndroidFindBy(uiAutomator = "text(\"请输入手机号\")")
    AndroidElement username;


    //密码
    @AndroidFindBy(uiAutomator = "text(\"请输入密码\")")
    AndroidElement password;

    //登陆按钮
    @AndroidFindBy(uiAutomator = "text(\"登录\")")
    AndroidElement submit;

    //登陆按钮
    @AndroidFindBy(uiAutomator = "text(\"今日利润(元)\")")
    AndroidElement todayRevenue;

    public AndroidElement inputUserName(){
        return username;
    }

    public AndroidElement inputPassword(){
        return password;
    }

    public AndroidElement submit(){
        return submit;
    }

    public AndroidElement getTodayRevenue() {
        return todayRevenue;
    }
}
