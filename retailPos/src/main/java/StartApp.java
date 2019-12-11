import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.SQLException;
import java.util.List;

public class StartApp extends Base {

    public static void login(AndroidDriver driver) throws SQLException, InterruptedException {
        //ResultSet result = accessDataBaseForLogin();
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.inputUserName().sendKeys(ExcelDataDriven.getValueFromExcel(0,1));
        loginPage.inputUserName().sendKeys(LoginPage.USERNAME);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        //loginPage.inputPassword().sendKeys(ExcelDataDriven.getValueFromExcel(1,1));
        loginPage.inputPassword().sendKeys(LoginPage.PASSWORD);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

        loginPage.submit().click();
        Thread.sleep(5000);
       /* WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        allowButton.click();*/
    }

    //需求：如果登陆框有账号直接输入密码，如果登陆框没有账号输入账号和密码
    public static void loginOnlyForPassword(AndroidDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword().sendKeys(LoginPage.PASSWORD);
      /*  if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
*/
        loginPage.submit().click();
    }

    public static void switchToOldCashier(AndroidDriver driver){
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.getSwitchToOldCashier().click();
    }


    public static void addRegularMemberNumber(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/memberCardScanTV")));
//        CashButton.click();
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.REGULARMEMBER);
        cashierPage.confirmButton().click();
    }

    public static void addWholeSaleMemberNumber(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.WHOLESALEMEMBER);
        cashierPage.confirmButton().click();
    }

    public static void addVipMember(AndroidDriver driver){
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addMember().click();
        cashierPage.inputMemberPhoneNumber().sendKeys(cashierPage.VIPMEMBER);
        cashierPage.confirmButton().click();
    }

    //清除商品
    public static void clearProduct(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(1);
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPSMALLPACK);
        cashierPage.search().click();
        cashierPage.clearProduct().click();
        cashierPage.confirmButton().click();
    }

    //优惠券扫描
    public static void couponScan(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPSMALLPACK);
        cashierPage.search().click();
        cashierPage.couponScanButton().click();
        cashierPage.confirmButton().click();
    }

    //挂单与解挂
    public static void pendingAndHangingOrder(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pendingOrder().click();
        cashierPage.hangingOrder().click();
    }

    //添加赠品
    public static void addfreebie(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.addfreebies().click();
        cashierPage.scanCodeBar().sendKeys(cashierPage.TESTSOAPBIGPACK);
        cashierPage.confirmButton().click();
    }

    //输入物流码
    public static void logisticsCodeAdd(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.logisticsCodeButton().click();
        cashierPage.logisticsCodeInputLine().sendKeys(cashierPage.LOGISTICSCODE);
        //driver.hideKeyboard();
        cashierPage.confirmButton().click();
    }

    //改价
    public static void changePrice(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.changePrice().click();
        cashierPage.changePriceInputLine().sendKeys(cashierPage.PRICEAFTERCHANGED);
        cashierPage.confirmButton().click();
    }

    //删除商品
    public static void deleteProduct(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.deleteProductButton().click();
        cashierPage.confirmButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();

//        cashierPage.cashSaleButton().click();
//        cashierPage.totalPayButton().click();
    }

    //普通会员赊账支付
    public static void regularMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.getNewCashier().click();    //收款
        cashierPage.creditSaleButton().click(); //赊账
        cashierPage.totalPayButton().click(); //支付
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    public static void vipMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2);
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.getNewCashier().click();
        cashierPage.creditSaleButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //批发会员赊账支付
    public static void wholeSaleMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        Thread.sleep(2);
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        WebElement search = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/btn_search")));
        search.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditSaleButton().click(); //赊账
        cashierPage.totalPayButton().click(); //支付
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //VIP会员现金支付
    public static void vipMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        Thread.sleep(100);
        cashierPage.search().click();
        cashierPage.getNewCashier().click();
        Thread.sleep(1000);
        //cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //普通会员现金支付
    public static void regularMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
//        CashButton.click();
        Thread.sleep(1000);
        cashierPage.getNewCashier().click();  //收款
        cashierPage.cashSaleButton().click();  //现金
        cashierPage.getPrintReceipt().click();//取消打印小票
        cashierPage.totalPayButton().click();  //支付
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //批发会员现金支付
    public static void wholeSaleMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
//        CashButton.click();
        Thread.sleep(1000);
        cashierPage.getNewCashier().click();  //收款
        cashierPage.cashSaleButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //vip会员储蓄卡支付
    public static void vipMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        cashierPage.getNewCashier().click();
        cashierPage.debitCardButton().click();//储蓄卡
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //普通会员储蓄卡支付
    public static void regularMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
//        CashButton.click();
        Thread.sleep(1000);
        cashierPage.getNewCashier().click();  //收款
        cashierPage.debitCardButton().click();  //储蓄卡
        cashierPage.totalPayButton().click();  //支付
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //批发会员储蓄卡支付
    public static void wholeSaleMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/xianjinLL")));
//        CashButton.click();
        //cashierPage.cashSaleButton().click();\
        cashierPage.getNewCashier().click();  //收款
        cashierPage.debitCardButton().click(); //储蓄卡
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //vip会员信用卡支付
    public static void vipMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addVipMember(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        Thread.sleep(1000);
        cashierPage.getNewCashier().click();
        cashierPage.creditCardButton().click();//信用卡
        cashierPage.confirmButton().click();
        cashierPage.getPrintReceipt().click();//勾选打印小票
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //普通会员信用卡支付
    public static void regularMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addRegularMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.NonUNIFORMPRODUCT);
        cashierPage.search().click();
        Thread.sleep(1000);
        //cashierPage.cashSaleButton().click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditCardButton().click();//信用卡
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //批发会员信用卡支付
    public static void wholeSaleMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        addWholeSaleMemberNumber(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.UNIFORMPRODUCT);
        cashierPage.search().click();
        Thread.sleep(1000);
        //cashierPage.cashSaleButton().click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditCardButton().click();  //信用卡
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //散客赊账支付，支付应该不成功
    public static void walkingMemberCreditSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);  //切换会员为散客
        cashierPage.noCodeProductButton().click(); //无条码商品
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click(); //增加数量
        }
        cashierPage.returnCashierDesktopButton().click(); //返回收银台
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditSaleButton().click(); //赊账
        Thread.sleep(500);
        driver.findElementById(Environment.PackageName+":id/iv_close").click();//关闭支付面板
    }

    //散客现金支付
    public static void walkingMemberCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver); //切换会员为散客
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //散客会员储蓄卡支付
    public static void walkingMemberDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.debitCardButton().click();//储蓄卡
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //散客会员信用卡支付
    public static void walkingMemberCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.noCodeProductButton().click();
        for (int i = 0; i < 3; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
        cashierPage.returnCashierDesktopButton().click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditCardButton().click();//信用卡
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //带分的散装商品现金支付
    public static void bulkGoodsCashSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 1; i++) {
            cashierPage.noCodeProductAddButton().click();
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.cashSaleButton().click(); //现金
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //带分的散装商品储蓄卡支付
    public static void bulkGoodsDebitCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 1; i++) {
            cashierPage.noCodeProductAddButton.click(); //增加数量+
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.debitCardButton().click(); //储蓄卡
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //带分的散装商品信用卡支付
    public static void bulkGoodsCreditCardSale(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.pressWalkingMemberButton(driver);
        cashierPage.scanCodeBar().sendKeys(cashierPage.BULKGOODSWITHCENTS);
        cashierPage.search().click();
        for (int i = 0; i < 2; i++) {
            cashierPage.noCodeProductAddButton.click();
        }
//        WebElement CashButton = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("com.yijiupi.retail:id/xianjinLL")));
//        CashButton.click();
        cashierPage.getNewCashier().click();  //收款
        cashierPage.creditCardButton().click(); //信用卡
        cashierPage.confirmButton().click();
        cashierPage.totalPayButton().click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("text(\"确认\")").click();
    }

    //退款
    public static void reFund(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyTrade().click();
        WebElement allowButton = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(Environment.PackageName + ":id/orderNoTV")));
        List<WebElement> orderlists = driver.findElementsById(Environment.PackageName + ":id/orderNoTV");
        String text = orderlists.get(1).getText();
        System.out.println(text);
        cashierPage.reFundButton().click();
        cashierPage.reFundInputLine().sendKeys(text);
        cashierPage.search().click();
        cashierPage.getChooseAllItem().click();
        //cashierPage.noCodeProductAddButton().click();
        cashierPage.secondRefundButton().click();
        cashierPage.enSureRefundButton().click();
        cashierPage.getInputBoxOfLastSixNumber().sendKeys(text.substring(text.length()-6));
        cashierPage.confirmButton().click();

    }

    public static void pressDailyTrade(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyTrade().click();
    }

    public static void pressDailyReport(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.dailyReport().click();
    }

    public static void pressRegisterCommission(AndroidDriver driver) {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.registerCommission().click();
    }

    public static void handOver(AndroidDriver driver) throws InterruptedException {
        CashierPage cashierPage = new CashierPage(driver);
        cashierPage.handOvers().click();
        Thread.sleep(4000);
        cashierPage.handOversButton().click();
        driver.findElement(By.id(Environment.PackageName + ":id/tv_ok")).click();
    }
}
