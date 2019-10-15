package PageSource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import util.Environment;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    AndroidDriver driver;

    //初始化页面元素
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),this);
    }

    @AndroidFindBy(uiAutomator = "text(\"发现\")")
     AndroidElement find;


    @AndroidFindBy(uiAutomator = "text(\"搜一搜\")")
    AndroidElement searchFor;

    @AndroidFindBy(uiAutomator = "text(\"搜索\")")
    AndroidElement search;

    public AndroidElement getSearch() {
        return search;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public AndroidElement getFind() {
        return find;
    }

    public AndroidElement getSearchFor() {
        return searchFor;
    }

    public void clickScreen(int x, int y, int duration,
                            AndroidDriver drivers) {
        JavascriptExecutor js = (JavascriptExecutor) drivers;
        HashMap tapObject = new HashMap();
        tapObject.put("x", x);
        tapObject.put("y", y);
        tapObject.put("duration", duration);
        js.executeScript("mobile: tap", tapObject);
    }
}
