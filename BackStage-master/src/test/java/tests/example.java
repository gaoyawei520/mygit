package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.*;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogType;
import org.testng.annotations.*;
import pages.LoginPage;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.Driver;

public class example {

//    private static final Logger LOG = LoggerFactory.getLogger(example.class);




    //@BeforeClass
    @Test
    public static void qidong()    throws IOException, InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gaoyawei\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");//webdriver.gecko.driver  webdriver.firefox.bin  webdriver.firefox.marionette
//        WebDriver driver = new FirefoxDriver();
        //driver.get("http://retailop.release.yijiupidev.com/templates/loginNoCaptcha.html#/onlineOrderList.html");
        driver.get("https://easygoop.release.yijiupidev.com/templates/loginNoCaptcha.html");
        ((ChromeDriver) driver).findElementByName("username").click();
        ((ChromeDriver) driver).findElementByName("username").sendKeys("17671607988");
        ((ChromeDriver) driver).findElementByName("password").click();
        ((ChromeDriver) driver).findElementByName("password").sendKeys("a123456");
        ((ChromeDriver) driver).findElementById("btn_login").click();
        Thread.sleep(5000);
        driver.manage().window().maximize();//最大化窗口
        Thread.sleep(1000);
        ((ChromeDriver) driver).findElementByXPath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/input[1]").click();
        ((ChromeDriver) driver).findElementByXPath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/input[1]").sendKeys("1f565gd");
        ((ChromeDriver) driver).findElementByXPath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[7]/div[1]/div[1]/button[1]").click();
        Thread.sleep(2000);
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            String message = entry.getMessage();
            if (message.contains("js")) {
                System.out.println("页面错误");
            }
        }
           // System.out.println("     "+entry.getLevel()+ "   "+ message);}

        //driver.get("https://easygoop.yijiupi.com/templates/index.html;jsessionid=94D13CFE78F7529767E10E6D8B45AAC5#/orderList.html");



        driver.close();
   }


}
