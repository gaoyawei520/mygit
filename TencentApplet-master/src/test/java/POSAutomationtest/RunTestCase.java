package POSAutomationtest;

import POSAutomationPageResource.Base;
import PageSource.CategoryPage;
import PageSource.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.Environment;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RunTestCase extends Base {

    private AndroidDriver driver;//全局变量

    @BeforeClass//设置
    public void setUp() throws IOException, InterruptedException {
//        Runtime.getRuntime().exec("cmd /c start E:\\Appium\\startappium.bat");
//        Thread.sleep(3000L);
        driver = Base.SetUp();
    }

    @Test
    public void AccessApplet() throws InterruptedException, IOException {
        Thread.sleep(2000);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getFind().click();
        loginPage.getSearchFor().click();
        loginPage.getSearch().click();
        Thread.sleep(2000);
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("adb shell input tap 281.7 309.8");//点击小程序开发助手的历史记录
        Thread.sleep(5000);
        runtime.exec("adb shell input tap 550.5 714.4");//点击小程序开发助手
        Thread.sleep(6000);
        runtime.exec("adb shell input tap 381.6 707.4");//点击体验版
        Thread.sleep(12000);
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getCategory().click();
        System.out.println("所有的contexts:" + driver.getContextHandles());
        driver.context("WEBVIEW_com.tencent.mm:toolsmp");///////换驱动
        Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("所有的windowsHandles" + windowHandles);
        for (String windowHandle : windowHandles) {
            System.out.println("切换到对应的windowHandle：" + windowHandle);
            driver.switchTo().window(windowHandle);
            Thread.sleep(5000);
            if (driver.getPageSource().contains("五粮液")) {
                break;
            }
        }
//
    }

    @Test
    public void buyItem() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);
        List<WebElement> categoryMenu = driver.findElements(By.className("categoryMenu"));
        categoryMenu.get(1).click();//点击五粮液类目
        Thread.sleep(2000);
        List<WebElement> WuliangyeProduct = driver.findElements(By.className("product-intro"));
        WuliangyeProduct.get(1).click();//点击商品
        Thread.sleep(1500);
        windows("立即购买");
        Environment.implicitWaitById("purchase",10);
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/wx-view[2]/wx-view[2]/wx-button")).click();//点击提交订单
        categoryPage.getConfirm().click();
    }

    public void windows(String s) throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("所有的windowsHandles" + windowHandles);
        for (String windowHandle : windowHandles) {
            System.out.println("切换到对应的windowHandle：" + windowHandle);
            driver.switchTo().window(windowHandle);
            Thread.sleep(5000);
            if (driver.getPageSource().contains(s)) {
                break;
            }
        }
    }
}
