package PageSource;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CategoryPage {
    AndroidDriver driver;

    public CategoryPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    public AndroidElement getCategory() {
        return category;
    }

    @AndroidFindBy(uiAutomator = "text(\"类目\")")
    AndroidElement category;


    @AndroidFindBy(className = "plusNum")
    AndroidElement addCart;

    @AndroidFindBy(uiAutomator = "text(\"确定\")")
    AndroidElement confirm;

    public AndroidElement getConfirm() {
        return confirm;
    }

    public AndroidElement getAddCart() {
        return addCart;
    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
