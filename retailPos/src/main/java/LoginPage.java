import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public AndroidDriver driver;
    public static final String USERNAME = "18888886667";
    public static final String PASSWORD = "886667";


    //初始化页面元素
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Duration duration = Duration.ofSeconds(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
        //PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),this);
    }
    //用户名
    @AndroidFindBy(id = Environment.PackageName +"id/userNameET")
    AndroidElement username;

    //密码
    @AndroidFindBy(id = Environment.PackageName +":id/userPwdET")
    AndroidElement password;

    //登陆按钮
    @AndroidFindBy(uiAutomator = "text(\"登录\")")
    AndroidElement submit;

    @AndroidFindBy(uiAutomator = "text(\"Allow\")")
    AndroidElement callAllow;

    public AndroidElement inputUserName(){
        return username;
    }

    public AndroidElement inputPassword(){
        return password;
    }

    public AndroidElement submit(){
        return submit;
    }

    public AndroidElement callAllow(){
        return callAllow;
    }
}
