import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Element {

    AndroidDriver driver;

    //初始化页面
    public Element(AndroidDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
    }

    //组件

    //订单查询
    @AndroidFindBy(uiAutomator = "text(\"订单查询\")")
    AndroidElement dingdanchaxun;

    public AndroidElement getdingdanchaxun() {
        return dingdanchaxun;
    }


    //上滑
    public void shanghua() {
        int width = driver.manage().window().getSize().width;

        int height = driver.manage().window().getSize().height;

        int y1 = height * 3 / 4; //上滑的开始点，从y1开始也就是屏幕的四分之三处
        int y2 = height * 1 / 3; //上滑的结束点，到y2结束也就是屏幕的三分之一处
        TouchAction tAction = new TouchAction(driver);


        PointOption point1 = PointOption.point(width / 2, y1);//上滑的开始点
        PointOption point2 = PointOption.point(width / 2, y2);//上滑的结束点
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();
    }
}
