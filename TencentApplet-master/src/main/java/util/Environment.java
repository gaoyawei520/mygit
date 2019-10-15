package util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class Environment {
    public static final String PackageName="com.tencent.mm";
    public static final String DeviceName = "Android Device";
    public static final String ProductOfGoods = "拉菲奥希";
    public static final String PurchaseCount = "1";
    public static final String SpecificationsAmount = "12";
    public static final String SpecificationsRetailPrice = "8000";
    public static final String CostPrice = "4";
    public static final String RetailPrice = "300";
    public static final String WholeSalePrice = "6";
    public static final String BarCode = "7788414";
    public static final String MemberPrice = "250";
    public static final String ProductName = "茅台测试";
    public static final String SecondSpecifications = "12";
    public static final String SecondSpecificationsPrice = "200";
    public static final String Introduction = "TestIntroduction";
   private static AndroidDriver driver;

    public static String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("MM年dd日HH时mm分ss秒");
        String format = df.format(new Date());
        return format;
    }

    public static int getRandomNum(){
        Random random = new Random();
        int num = random.nextInt(999999999)+1000000;
        return num;
    }

    public static WebElement implicitWaitById(String path, int time){
        WebElement Button = (new WebDriverWait(driver, time))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
        return Button;
    }

    public static WebElement implicitWaitByClassname(String path, int time){
        WebElement Button = (new WebDriverWait(driver, time))
                .until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
        return Button;
    }

    public static WebElement implicitWaitByXpath(String path, int time){
        WebElement Button = (new WebDriverWait(driver, time))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        return Button;
    }


}
