import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainPageForShopKeeper {
    AndroidDriver driver;
    public static final String Maotai = "maotai";

    //初始化页面
    public MainPageForShopKeeper(AndroidDriver driver) {
        this.driver = driver;
        Duration duration = Duration.ofSeconds(5);
        PageFactory.initElements(new AppiumFieldDecorator(driver, duration), this);
        //PageFactory.initElements(new AppiumFieldDecorator(driver,5,TimeUnit.SECONDS),this);
    }
    //易酒批零西藏舞阳店
    @AndroidFindBy(uiAutomator = "text(\"易酒批零西藏舞阳店\")")
    AndroidElement wuyangdian;
    //舞阳线上店
    @AndroidFindBy(uiAutomator = "text(\"易酒批零拉萨舞阳线上店\")")
    AndroidElement wuyangxianshangdian;
    //飞飞酒吧
    @AndroidFindBy(uiAutomator = "text(\"汉阳飞飞酒吧\")")
    AndroidElement feifeijiuba;
    //汉阳飞飞酒吧
    @AndroidFindBy(uiAutomator = "text(\"汉阳飞飞酒吧 \")")
    AndroidElement feifeijiuba1;

    //返回按钮
    @AndroidFindBy(className = "android.widget.ImageView")
    MobileElement back;
    //返回按钮列表
    @AndroidFindBy(className = "android.widget.ImageView") public static List<WebElement> tupian;
    //第一个输入框
    @AndroidFindBy(className = "android.widget.EditText")
    MobileElement edit;

    //输入框列表
    @AndroidFindBy(className = "android.widget.TextView") public static List<WebElement> edit0;

    //时间控件
    //时间面板-年
    @AndroidFindBy(id = "android:id/date_picker_header_year") public static AndroidElement nian;
    //选择2017年
    @AndroidFindBy(uiAutomator = "text(\"2017\")") public static AndroidElement nian2017;
    //开始时间按钮-(会员管理-还款-选择订单)
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public static AndroidElement huankuankaishishijian;



    //订单查询
    @AndroidFindBy(uiAutomator = "text(\"订单查询\")") public static AndroidElement dingdanchaxun;
    //开始时间-订单查询
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
            public static AndroidElement dingdanchaxunshijian;



    //营业报表

    //营业报表
    @AndroidFindBy(uiAutomator = "text(\"商品销售报表\")")
    AndroidElement baobiao;
    //今日销售额
    @AndroidFindBy(uiAutomator = "text(\"今日销售额(元)\")")
    AndroidElement salesRevenue;
    //葡萄酒类目
    @AndroidFindBy(uiAutomator = "text(\"葡萄酒\")")
    AndroidElement wineCategory;
    //商品按钮
    @AndroidFindBy(uiAutomator = "text(\"商品\")")
    AndroidElement product;
    //搜索框
    @AndroidFindBy(uiAutomator = "text(\"请输入商品名称或助记码\")")
    AndroidElement searchBar;
    //搜索按钮
    @AndroidFindBy(uiAutomator = "text(\"搜索\")")
    AndroidElement search;
    //返回按钮
    @AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[23,59][61,97]']")
    AndroidElement returnButton;
    //今日利润按钮
    @AndroidFindBy(uiAutomator = "text(\" 今日利润(元)\")")
    AndroidElement todayRevenue;




    //交易流水
    //交易流水
    @AndroidFindBy(uiAutomator = "text(\"交易流水\")")
    AndroidElement liushui;
    //今日流水按钮
    @AndroidFindBy(uiAutomator = "text(\" 今日笔数\")")
    AndroidElement todayFlow;
    //全部订单按钮
    @AndroidFindBy(uiAutomator = "text(\"全部订单\")")
    AndroidElement totalOrders;
    //线下订单按钮
    @AndroidFindBy(uiAutomator = "text(\"线下订单\")")
    AndroidElement offlineOrders;
    //全部收银员按钮
    @AndroidFindBy(uiAutomator = "text(\"全部收银员\")")
    AndroidElement allCashier;
    //收银员李达//张三
    @AndroidFindBy(uiAutomator = "text(\"李达\")")
    AndroidElement cashierLida;







    //订单管理

    //首页待接单入口按钮
    @AndroidFindBy(uiAutomator = "text(\" 待接单\")")
    AndroidElement waitingOrders;
    @AndroidFindBy(uiAutomator = "text(\"待接单\")")
    AndroidElement waitOrder;
    //订单管理
    @AndroidFindBy(uiAutomator = "text(\"线上订单\")")
    AndroidElement OrderForm;
    //订单号和会员手机号搜索框
    @AndroidFindBy(uiAutomator = "text(\"请输入或扫订单号/会员手机号\")")
    AndroidElement searchBarForOrders;
    //已接单按钮
    @AndroidFindBy(uiAutomator = "text(\"已接单\")")
    AndroidElement acceptOrders;
    //已完成按钮
    @AndroidFindBy(uiAutomator = "text(\"已完成\")")
    AndroidElement completeOrders;
    //已取消按钮
    @AndroidFindBy(uiAutomator = "text(\"已取消\")")
    AndroidElement cancelOrders;
    //近7天按钮
    @AndroidFindBy(uiAutomator = "text(\"近7天\")")
    AndroidElement sevenDaysButton;
    //今天按钮
    @AndroidFindBy(uiAutomator = "text(\"今天\")")
    AndroidElement todayButton;
    //更多按钮
    @AndroidFindBy(uiAutomator = "text(\"更多\")")
    AndroidElement morebutton;





    //战略产品

    //战略产品
    @AndroidFindBy(uiAutomator = "text(\"战略产品\")")
    AndroidElement strategy;
    //战略商品
    @AndroidFindBy(uiAutomator = "text(\"全兴特曲润蓝38度500ml\")")
    AndroidElement quanxing;
    //销售明细
    @AndroidFindBy(uiAutomator = "text(\"销售明细\")")
    AndroidElement xiaoshou;
    //进货明细
    @AndroidFindBy(uiAutomator = "text(\"进货明细\")")
    AndroidElement jinhuo;
    //搜索框
    @AndroidFindBy(uiAutomator = "text(\"输入名称/助记码\")")
    AndroidElement searchbar1;
    //搜索框2
    @AndroidFindBy(uiAutomator = "text(\"输入名称/条码\")")
    AndroidElement searchbar2;
    //搜索框3
    @AndroidFindBy(uiAutomator = "text(\"输入商品名称\")")
    AndroidElement searchbar3;


    //促销活动
    //促销活动入口
    @AndroidFindBy(uiAutomator = "text(\"促销活动\")")
    AndroidElement cuxiao;
    //优惠券
    @AndroidFindBy(uiAutomator = "text(\"优惠劵\")")
    AndroidElement youhuiquan;
    //订单优惠
    @AndroidFindBy(uiAutomator = "text(\"订单优惠\")")
    AndroidElement dingdanyouhui;
    //全部
    @AndroidFindBy(uiAutomator = "text(\"全部\")")
    AndroidElement quanbu;
    //已发布
    @AndroidFindBy(uiAutomator = "text(\"已发布\")")
    AndroidElement yifabu;
    //待发布
    @AndroidFindBy(uiAutomator = "text(\"待发布\")")
    AndroidElement daifabu;
    //已下架
    @AndroidFindBy(uiAutomator = "text(\"已下架\")")
    AndroidElement yixiajia;


    //分销管理
    //分销管理入口
    @AndroidFindBy(uiAutomator = "text(\"分销管理\")")
    AndroidElement fenxiao;
    //点击夏阳
    @AndroidFindBy(uiAutomator = "text(\"夏阳-15671650279\")")
    AndroidElement xiayang1;
    //分销会员
    @AndroidFindBy(uiAutomator = "text(\"分销会员\")")
    AndroidElement fenxiaohuiyuan;
    //佣金明细
    @AndroidFindBy(uiAutomator = "text(\"佣金明细\")")
    AndroidElement yongjinmingxi;
    //分销商品
    @AndroidFindBy(uiAutomator = "text(\"分销商品\")")
    AndroidElement fenxiaoshangpin;
    //分销店长
    @AndroidFindBy(uiAutomator = "text(\"分销店长\")")
    AndroidElement fenxiaodianzhang;
    //白名单
    @AndroidFindBy(uiAutomator = "text(\"白名单\")")
    AndroidElement baimingdan;
    //特别名单
    @AndroidFindBy(uiAutomator = "text(\"特别名单\")")
    AndroidElement tebiemingdan;
    //黑名单
    @AndroidFindBy(uiAutomator = "text(\"黑名单\")")
    AndroidElement heimingdan;
    //分销提成设置
    @AndroidFindBy(uiAutomator = "text(\"分销提成设置\")")
    AndroidElement fenxiaoshezhi;
    // 编辑所属名单
    @AndroidFindBy(uiAutomator = "text(\" 编辑所属名单\")")
    AndroidElement bianjimingdan;
    //确认
    @AndroidFindBy(uiAutomator = "text(\"确定\")")
    AndroidElement queding;
    //取消
    @AndroidFindBy(uiAutomator = "text(\"取消\")")
    AndroidElement quxiao;
    //提成比例输入框
    @AndroidFindBy(uiAutomator = "text(\"请输入0-100的数字\")")
    AndroidElement tichengshuru;



    //进销存报表jinxiaocunbaobiao
   //分销管理入口
    @AndroidFindBy(uiAutomator = "text(\"进销存报表\")")
    AndroidElement jinxiaocunbaobiao;
    //查看详情
    @AndroidFindBy(uiAutomator = "text(\" 查看详情\")")
    AndroidElement chakanxiangqing;



    //任务中心
    //任务中心
    @AndroidFindBy(uiAutomator = "text(\"任务中心\")")
    AndroidElement renwuzhongxin;
    //说明
    @AndroidFindBy(uiAutomator = "text(\"说明\")")
    AndroidElement shuoming;
    //说明
    @AndroidFindBy(uiAutomator = "text(\"我知道了\")")
    AndroidElement wozhidaole;
    //查看更多任务
    @AndroidFindBy(uiAutomator = "text(\"查看更多任务\")")
    AndroidElement chakangengduorenwu;
    //月返
    @AndroidFindBy(uiAutomator = "text(\"月返\")")
    AndroidElement yuefan;
    //年返
    @AndroidFindBy(uiAutomator = "text(\"年返\")")
    AndroidElement nianfan;


    //会员管理
    //会员管理入口
    @AndroidFindBy(uiAutomator = "text(\"会员管理\")")
    AndroidElement huiyuanguanli;
    //下单时间
    @AndroidFindBy(uiAutomator = "text(\"下单时间\")")
    AndroidElement xiadanshijian;
    //赊账金额
    @AndroidFindBy(uiAutomator = "text(\"赊账金额\")")
    AndroidElement shezhangjine;
    //赊账金额
    @AndroidFindBy(uiAutomator = "text(\"注册时间\")")
    AndroidElement zhuceshijian;
    //赊账额度
    @AndroidFindBy(uiAutomator = "text(\"赊账额度\")")
    AndroidElement shezhangedu;
    //还款
    @AndroidFindBy(uiAutomator = "text(\"还款\")")
    AndroidElement huankuan;
    //还款金额输入框
    @AndroidFindBy(uiAutomator = "text(\"请输入还款金额\")")
    AndroidElement huankuanshuru;
   //现金
   @AndroidFindBy(uiAutomator = "text(\"现金\")")
   AndroidElement xianjin;
   //支付宝
   @AndroidFindBy(uiAutomator = "text(\"支付宝\")")
   AndroidElement zhifubao;
   //微信
   @AndroidFindBy(uiAutomator = "text(\"微信\")")
   AndroidElement weixin;
   //银行转账
   @AndroidFindBy(uiAutomator = "text(\"银行转账\")")
   AndroidElement yinhangzhuanzhang;
   //确认
   @AndroidFindBy(uiAutomator = "text(\"确认\")")
   AndroidElement queren;
   //赊账记录
   @AndroidFindBy(uiAutomator = "text(\"赊账记录\")")
   AndroidElement shezhangjilu;
   //变更会员类型
   @AndroidFindBy(uiAutomator = "text(\"会员类型\")")
   AndroidElement biangengleixing;
   //普通会员
   @AndroidFindBy(uiAutomator = "text(\"普通会员\")")
   AndroidElement putonghuiyuan;
    //vip会员
    @AndroidFindBy(uiAutomator = "text(\"VIP会员\")")
    AndroidElement viphuiyuan;
   //批发会员
   @AndroidFindBy(uiAutomator = "text(\"批发会员\")")
   AndroidElement pifahuiyuan;
   //会员价格
   @AndroidFindBy(uiAutomator = "text(\"会员价格\")")
   AndroidElement huiyuanjiage;
   //继续设置
   @AndroidFindBy(uiAutomator = "text(\"继续设置\")")
   AndroidElement jixushezhi;
   //清空会员价格
   @AndroidFindBy(uiAutomator = "text(\"清空会员价格\")")
   AndroidElement qingkongjiage;
   //设置顺便带
   @AndroidFindBy(uiAutomator = "text(\"设置顺便带\")")
   AndroidElement shunbiandai;
   //取消顺便带
   @AndroidFindBy(uiAutomator = "text(\"取消顺便带\")")
   AndroidElement quxiaoshunbiandai;
   //最后下单时间:
   @AndroidFindBy(uiAutomator = "text(\"最后下单时间：\")")
   AndroidElement zuihouxiadan;
   //变更会员状态
   @AndroidFindBy(uiAutomator = "text(\"变更会员状态\")")
   AndroidElement biangengzhuangtai;
   //正常
   @AndroidFindBy(uiAutomator = "text(\"正常\")")
   AndroidElement zhengchang;
   //停用
   @AndroidFindBy(uiAutomator = "text(\"停用\")")
   AndroidElement tingyong;
   //冻结
   @AndroidFindBy(uiAutomator = "text(\"冻结\")")
   AndroidElement dongjie;
   //会员订单
   @AndroidFindBy(uiAutomator = "text(\"会员订单\")")
   AndroidElement huiyuandingdan;
   //编辑
   @AndroidFindBy(uiAutomator = "text(\"编辑\")")
   AndroidElement bianji;
   //新增
   @AndroidFindBy(uiAutomator = "text(\"新增\")")
   AndroidElement xinzeng;
   //新增会员
   @AndroidFindBy(uiAutomator = "text(\"新增会员\")")
   AndroidElement xinzenghuiyuan;




    //会员标签
    //会员标签入口
    @AndroidFindBy(uiAutomator = "text(\"会员标签\")")
    AndroidElement huiyuanbiaoqian;




    //员工管理
    //员工管理入口
    @AndroidFindBy(uiAutomator = "text(\"员工管理\")")
    AndroidElement yuangongguanli;
    //查看业绩
    @AndroidFindBy(uiAutomator = "text(\"查看业绩\")")
    AndroidElement chakanyeji;
    //销售提成
    @AndroidFindBy(uiAutomator = "text(\"销售提成\")")
    AndroidElement xiaoshouticheng;
    //收银提成
    @AndroidFindBy(uiAutomator = "text(\"收银提成\")")
    AndroidElement shouyinticheng;
    //销售额
    @AndroidFindBy(uiAutomator = "text(\"销售额\")")
    AndroidElement xiaoshoue;
    //客户
    @AndroidFindBy(uiAutomator = "text(\"客户\")")
    AndroidElement kehu;
    //查看二维码
    @AndroidFindBy(uiAutomator = "text(\"查看二维码\")")
    AndroidElement chakanerweima;
    //员工二维码
    @AndroidFindBy(uiAutomator = "text(\"员工二维码\")")
    AndroidElement yuangongerweima;
    // 销售经理
    @AndroidFindBy(uiAutomator = "text(\" 销售经理\")")
    AndroidElement xiaoshoujingli;
    // 收银员
    @AndroidFindBy(uiAutomator = "text(\" 收银员\")")
    AndroidElement shouyinyuan;
    // 配送员
    @AndroidFindBy(uiAutomator = "text(\" 配送员\")")
    AndroidElement peisongyuan;
    // 店长
    @AndroidFindBy(uiAutomator = "text(\"店长\")")
    AndroidElement dianzhang;
    // 启用
    @AndroidFindBy(uiAutomator = "text(\" 启用\")")
    AndroidElement qiyong;
    // 停用
    @AndroidFindBy(uiAutomator = "text(\" 停用\")")
    AndroidElement tingyong1;





    //员工业绩
    //员工业绩入口
    @AndroidFindBy(uiAutomator = "text(\"员工业绩\")")
    AndroidElement yuangongyeji;
    //高飞
    @AndroidFindBy(uiAutomator = "text(\"高飞  18912345678\")")
    AndroidElement gaofei;
    //新会员
    @AndroidFindBy(uiAutomator = "text(\"新会员\")")
    AndroidElement xinhuiyuan;
    //未下单会员
    @AndroidFindBy(uiAutomator = "text(\"未下单会员\")")
    AndroidElement weixiadanhuiyuan;
    //已下单会员
    @AndroidFindBy(uiAutomator = "text(\"已下单会员\")")
    AndroidElement yixiadanhuiyuan;
    // 销售经理
    @AndroidFindBy(uiAutomator = "text(\"销售经理\")")
    AndroidElement xiaoshoujingli1;
    // 收银员
    @AndroidFindBy(uiAutomator = "text(\"收银员\")")
    AndroidElement shouyinyuan1;
    //夏阳
    @AndroidFindBy(uiAutomator = "text(\"夏阳-15671786729\")")
    AndroidElement xiayang;



    //二维码推广
    //二维码推广入口
    @AndroidFindBy(uiAutomator = "text(\"二维码推广\")")
    AndroidElement erweimatuiguang;
    //查看推广数据
    @AndroidFindBy(uiAutomator = "text(\"查看推广数据\")")
    AndroidElement tuiguangshuju;
    //注册会员
    @AndroidFindBy(uiAutomator = "text(\"注册会员(0)\")")
    AndroidElement zhucehuiyuan;
    //下单会员
    @AndroidFindBy(uiAutomator = "text(\"下单会员(0)\")")
    AndroidElement xiadanhuiyuan;
    //保存图片
    @AndroidFindBy(uiAutomator = "text(\"保存图片\")")
    AndroidElement baocuntupian;
    //高飞
    @AndroidFindBy(uiAutomator = "text(\"高飞\")")
    AndroidElement gaofei1;




    //库存管理
    //库存管理入口
    @AndroidFindBy(uiAutomator = "text(\"库存管理\")")
    AndroidElement kucunguanli;
    //葡萄酒
    @AndroidFindBy(uiAutomator = "text(\"葡萄酒\")")
    AndroidElement putaojiu;
    //库存变动明细
    @AndroidFindBy(uiAutomator = "text(\"库存变动明细\")")
    AndroidElement kucunbiandongmingxi;
    //设置库存预警
    @AndroidFindBy(uiAutomator = "text(\"设置库存预警\")")
    AndroidElement shezhikucunyujing;
    //商品库存
    @AndroidFindBy(uiAutomator = "text(\"商品库存\")")
    AndroidElement shangpinkucun;
    //盘存单
    @AndroidFindBy(uiAutomator = "text(\"盘存单\")")
    AndroidElement pancundan;
    //盘存人
    @AndroidFindBy(uiAutomator = "text(\"盘存人：刘永飞\")")
    AndroidElement pancunren;
    //新建盘存单
    @AndroidFindBy(uiAutomator = "text(\"新建盘存单\")")
    AndroidElement xinjianpancundan;
    //保存
    @AndroidFindBy(uiAutomator = "text(\"保存\")")
    AndroidElement baocun;
    //提交
    @AndroidFindBy(uiAutomator = "text(\"提交\")")
    AndroidElement tijiao;
    //报损单
    @AndroidFindBy(uiAutomator = "text(\"报损单\")")
    AndroidElement baosundan;
    //报损人
    @AndroidFindBy(uiAutomator = "text(\"报损人：刘永飞\")")
    AndroidElement baosunren;
    //新建报损单
    @AndroidFindBy(uiAutomator = "text(\"新建报损单\")")
    AndroidElement xinjianbaosundan;









    //进货管理
    //进货管理入口
    @AndroidFindBy(uiAutomator = "text(\"进货管理\")")
    AndroidElement jinhuoguanli;
    //全部供应商
    @AndroidFindBy(uiAutomator = "text(\"全部供应商\")")
    AndroidElement quanbugongyingshang;
    //华致
    @AndroidFindBy(uiAutomator = "text(\"华致\")")
    AndroidElement huazhi;
    //高粱酒
    @AndroidFindBy(uiAutomator = "text(\"高梁原酒55度2L\")")
    AndroidElement gaoliangjiu;
    //退货
    @AndroidFindBy(uiAutomator = "text(\"退货\")")
    AndroidElement tuihuo;
    //已提交
    @AndroidFindBy(uiAutomator = "text(\"已提交\")")
    AndroidElement yitijiao;
    //已取消
    @AndroidFindBy(uiAutomator = "text(\"已取消\")")
    AndroidElement yiquxiao;
    //已入库
    @AndroidFindBy(uiAutomator = "text(\"已入库\")")
    AndroidElement yiruku;
    //退货单
    @AndroidFindBy(uiAutomator = "text(\"退货单\")")
    AndroidElement tuihuodan;
    //进货单
    @AndroidFindBy(uiAutomator = "text(\"进货单\")")
    AndroidElement jinhuodan;
    //已退货
    @AndroidFindBy(uiAutomator = "text(\"已退货\")")
    AndroidElement yituihuo;
    //已拒绝
    @AndroidFindBy(uiAutomator = "text(\"已拒绝\")")
    AndroidElement yijujue;
    //香茗
    @AndroidFindBy(uiAutomator = "text(\"香酩葡萄汽泡酒5度750ml\")")
    AndroidElement xiangming;
    //店铺自采
    @AndroidFindBy(uiAutomator = "text(\"店铺自采\")")
    AndroidElement dianpuzicai;
    //店铺自采
    @AndroidFindBy(uiAutomator = "text(\"加入购物车\")")
    AndroidElement jiarugouwuche;
    //
    @AndroidFindBy(uiAutomator = "text(\"去进货\")")
    AndroidElement qujinhuo;





    //库存调拨
    //库存调拨入口
    @AndroidFindBy(uiAutomator = "text(\"库存调拨\")")
    AndroidElement kucundiaobo;
    //调拨单
    @AndroidFindBy(uiAutomator = "text(\"调拨单\")")
    AndroidElement diaobodan;
    //调拨单
    @AndroidFindBy(uiAutomator = "text(\"调出单\")")
    AndroidElement diaochudan;
    //调拨单
    @AndroidFindBy(uiAutomator = "text(\"调入单\")")
    AndroidElement diaorudan;
    //提交调拨单
    @AndroidFindBy(uiAutomator = "text(\"提交调拨单\")")
    AndroidElement tijiaodiaobodan;




    //门店管理
    //门店管理入口
    @AndroidFindBy(uiAutomator = "text(\"门店设置\")")
    AndroidElement mendianshezhi;
    //配送设置
    @AndroidFindBy(uiAutomator = "text(\"配送设置\")")
    AndroidElement peisongshezhi;
    //门店公告
    @AndroidFindBy(uiAutomator = "text(\"门店公告\")")
    AndroidElement mendiangonggao;
    //新增公告
    @AndroidFindBy(uiAutomator = "text(\"新增公告\")")
    AndroidElement xinzenggonggao;




    //配送管理
    //配送管理入口
    @AndroidFindBy(uiAutomator = "text(\"配送管理\")")
    AndroidElement peisongguanli;
    //待配送：
    @AndroidFindBy(uiAutomator = "text(\"待配送：\")")
    AndroidElement daipeisong1;
    //待配送
    @AndroidFindBy(uiAutomator = "text(\"待配送\")")
    AndroidElement daipeisong;
    //已配送
    @AndroidFindBy(uiAutomator = "text(\"已配送\")")
    AndroidElement yipeisong;
    //配送中
    @AndroidFindBy(uiAutomator = "text(\"配送中\")")
    AndroidElement peisongzhong;
    //配送完成
    @AndroidFindBy(uiAutomator = "text(\"配送完成\")")
    AndroidElement peisongwancheng;
    //变更配送员
    @AndroidFindBy(uiAutomator = "text(\"变更配送员\")")
    AndroidElement biangengpeisongyuan;
    //配送成功
    @AndroidFindBy(uiAutomator = "text(\"配送完成\")")
    AndroidElement peisongchenggong;
    //拒收
    @AndroidFindBy(uiAutomator = "text(\"用户拒收\")")
    AndroidElement jushou;






    //供应商管理
    //供应商管理入口
    @AndroidFindBy(uiAutomator = "text(\"供应商管理\")")
    AndroidElement gongyingshangguanli;
    //查看供应商商品
    @AndroidFindBy(uiAutomator = "text(\"供应商商品\")")
    AndroidElement gongyingshangshangpin;
    //删除
    @AndroidFindBy(uiAutomator = "text(\"删除\")")
    AndroidElement shanchu;
    //添加
    @AndroidFindBy(uiAutomator = "text(\"添加\")")
    AndroidElement tianjia;
    //啤酒
    @AndroidFindBy(uiAutomator = "text(\"啤酒\")")
    AndroidElement pijiu;
    //全部添加
    @AndroidFindBy(uiAutomator = "text(\"全部添加\")")
    AndroidElement quanbutianjia;
    //商城公告
    @AndroidFindBy(uiAutomator = "text(\"商城公告\")")
    AndroidElement shangchenggonggao;




    //门店管理
    @AndroidFindBy(uiAutomator = "text(\"门店管理\")")
    AndroidElement mendianguanli;
    //查看供应商商品
    @AndroidFindBy(uiAutomator = "text(\"查看供应商商品\")")
    AndroidElement chakangongyingshangshangpin;

    public AndroidElement getwuyangdian() {
        return wuyangdian;
    }
    public AndroidElement getTodayRevenue() {
        return todayRevenue;
    }
    public AndroidElement getTodayFlow() {
        return todayFlow;
    }
    public AndroidElement getTotalOrders() {
        return totalOrders;
    }
    public AndroidElement getOfflineOrders() {
        return offlineOrders;
    }
    public AndroidElement getAllCashier() {
        return allCashier;
    }
    public AndroidElement getCashierLida() {
        return cashierLida;
    }
    public AndroidElement getWaitingOrders() {
        return waitingOrders;
    }
    public AndroidElement getSearchBarForOrders() {
        return searchBarForOrders;
    }
    public AndroidElement getAcceptOrders() {
        return acceptOrders;
    }
    public AndroidElement getCompleteOrders() {
        return completeOrders;
    }
    public AndroidElement getCancelOrders() {
        return cancelOrders;
    }
    public AndroidElement getSevenDaysButton() {
        return sevenDaysButton;
    }
    public AndroidElement getTodayButton() {
        return todayButton;
    }
    public AndroidDriver getDriver() { return driver; }
    public AndroidElement getwuyangxianshangdian() { return wuyangxianshangdian; }
    public AndroidElement getfeifeijiuba() { return feifeijiuba; }
    public AndroidElement getfeifeijiuba1() { return feifeijiuba1; }
    public AndroidElement getSalesRevenue() {
        return salesRevenue;
    }
    public AndroidElement getWineCategory() {
        return wineCategory;
    }
    public AndroidElement getProduct() {
        return product;
    }
    public AndroidElement getSearchBar() {
        return searchBar;
    }
    public AndroidElement getSearch() {
        return search;
    }
    public AndroidElement getReturnButton() {
        return returnButton;
    }
    public AndroidElement getOrderForm() { return OrderForm; }
    public AndroidElement getwaitOrder() { return waitOrder; }
    public AndroidElement getbaobiao() { return baobiao; }
    public AndroidElement getliushui() { return liushui; }
    public AndroidElement getmorebutton() { return morebutton; }
    public AndroidElement getcuxiao() { return cuxiao; }
    public AndroidElement getstrategy() { return strategy; }
    public AndroidElement getquanxing() { return quanxing; }
    public AndroidElement getxiaoshou() { return xiaoshou; }
    public AndroidElement getjinhuo() { return jinhuo; }
    public AndroidElement getsearchbar1() { return searchbar1; }
    public AndroidElement getsearchbar2() { return searchbar2; }
    public AndroidElement getsearchbar3() { return searchbar3; }
    public AndroidElement getquanbu() { return quanbu; }
    public AndroidElement getyifabu() { return yifabu; }
    public AndroidElement getdaifabu() { return daifabu; }
    public AndroidElement getyixiajia() { return yixiajia; }
    public AndroidElement getyouhuiquan() { return youhuiquan; } //点击优惠券
    public AndroidElement getdingdanyouhui() { return dingdanyouhui; }
    public AndroidElement getfenxiao() { return fenxiao; }
    public AndroidElement getjinxiaocunbaobiao() { return jinxiaocunbaobiao; }
    public AndroidElement getrenwuzhongxin() { return renwuzhongxin; }
    public AndroidElement getshuoming() { return shuoming; }
    public AndroidElement getwozhidaole() { return wozhidaole; }
    public AndroidElement getchakangengduorenwu() { return chakangengduorenwu; }
    public AndroidElement getyuefan() { return yuefan; }
    public AndroidElement getnianfan() { return nianfan; }
    public AndroidElement getchakanxiangqing() { return chakanxiangqing; }


    public AndroidElement getxiayang() { return xiayang; }
    public AndroidElement getxiayang1() { return xiayang1; }
    public AndroidElement getfenxiaohuiyuan() { return fenxiaohuiyuan; }
    public AndroidElement getyongjinmingxi() { return yongjinmingxi; }
    public AndroidElement getfenxiaoshangpin() { return fenxiaoshangpin; }
    public AndroidElement getfenxiaodianzhang() { return fenxiaodianzhang; }
    public AndroidElement getbaimingdan() { return baimingdan; }
    public AndroidElement gettebiemingdan() { return tebiemingdan; }
    public AndroidElement getheimingdan() { return heimingdan; }
    public AndroidElement getfenxiaoshezhi() { return fenxiaoshezhi; }
    public AndroidElement getbianjimingdan() { return bianjimingdan; }
    public AndroidElement getqueding() { return queding; }
    public AndroidElement getquxiao() { return quxiao; }
    public AndroidElement gettichengshuru() { return tichengshuru; }
    public AndroidElement gethuiyuanguanli() { return huiyuanguanli; }
    public AndroidElement getxiadanshijian() { return xiadanshijian; }
    public AndroidElement getshezhangjine() { return shezhangjine; }
    public AndroidElement getzhuceshijian() { return zhuceshijian; }

    public AndroidElement getshezhangedu() { return shezhangedu; }
    public AndroidElement gethuankuan() { return huankuan; }
    public AndroidElement gethuankuanshuru() { return huankuanshuru; }
    public AndroidElement getxianjin() { return xianjin; }
    public AndroidElement getzhifubao() { return zhifubao; }
    public AndroidElement getweixin() { return weixin; }
    public AndroidElement getyinhangzhuanzhang() { return yinhangzhuanzhang; }
    public AndroidElement getqueren() { return queren; }
    public AndroidElement getshezhangjilu() { return shezhangjilu; }

    public AndroidElement getbiangengleixing() { return biangengleixing; }
    public AndroidElement getputonghuiyuan() { return putonghuiyuan; }
    public AndroidElement getviphuiyuan() { return viphuiyuan; }
    public AndroidElement getpifahuiyuan() { return pifahuiyuan; }
    public AndroidElement gethuiyuanjiage() { return huiyuanjiage; }
    public AndroidElement getjixushezhi() { return jixushezhi; }
    public AndroidElement getqingkongjiage() { return qingkongjiage; }
    public AndroidElement getshunbiandai() { return shunbiandai; }
    public AndroidElement getquxiaoshunbiandai() { return quxiaoshunbiandai; }
    public AndroidElement getzuihouxiadan() { return zuihouxiadan; }
    public AndroidElement getbiangengzhuangtai() { return biangengzhuangtai; }
    public AndroidElement getzhengchang() { return zhengchang; }
    public AndroidElement gettingyong() { return tingyong; }
    public AndroidElement getdongjie() { return dongjie; }
    public AndroidElement gethuiyuandingdan() { return huiyuandingdan; }
    public AndroidElement getbianji() { return bianji; }
    public AndroidElement gethuiyuanbiaoqian() { return huiyuanbiaoqian; }
    public AndroidElement getxinzeng() { return xinzeng; }
    public AndroidElement getxinzenghuiyuan() { return xinzenghuiyuan; }
    public AndroidElement getyuangongguanli() { return yuangongguanli; }
    public AndroidElement getchakanyeji() { return chakanyeji; }
    public AndroidElement getxiaoshouticheng() { return xiaoshouticheng; }
    public AndroidElement getshouyinticheng() { return shouyinticheng; }
    public AndroidElement getxiaoshoue() { return xiaoshoue; }
    public AndroidElement getkehu() { return kehu; }
    public AndroidElement getqujinhuo() { return qujinhuo; }
    public AndroidElement getchakanerweima() { return chakanerweima; }
    public AndroidElement getyuangongerweima() { return yuangongerweima; }
    public AndroidElement getxiaoshoujingli() { return xiaoshoujingli; }
    public AndroidElement getshouyinyuan() { return shouyinyuan; }
    public AndroidElement getpeisongyuan() { return peisongyuan; }
    public AndroidElement getdianzhang() { return dianzhang; }
    public AndroidElement getqiyong() { return qiyong; }
    public AndroidElement gettingyong1() { return tingyong1; }
    public AndroidElement getyuangongyeji() { return yuangongyeji; }
    public AndroidElement getgaofei() { return gaofei; }
    public AndroidElement getxinhuiyuan() { return xinhuiyuan; }
    public AndroidElement getweixiadanhuiyuan() { return weixiadanhuiyuan; }
    public AndroidElement getyixiadanhuiyuan() { return yixiadanhuiyuan; }
    public AndroidElement geterweimatuiguang() { return erweimatuiguang; }
    public AndroidElement gettuiguangshuju() { return tuiguangshuju; }
    public AndroidElement getzhucehuiyuan() { return zhucehuiyuan; }
    public AndroidElement getxiadanhuiyuan() { return xiadanhuiyuan; }
    public AndroidElement getbaocuntupian() { return baocuntupian; }
    public AndroidElement getshouyinyuan1() { return shouyinyuan1; }
    public AndroidElement getxiaoshoujingli1() { return xiaoshoujingli1; }
    public AndroidElement getgaofei1() { return gaofei1; }
    public AndroidElement getkucunguanli() { return kucunguanli; }
    public AndroidElement getputaojiu() { return putaojiu; }
    public AndroidElement getkucunbiandongmingxi() { return kucunbiandongmingxi; }
    public AndroidElement getshezhikucunyujing() { return shezhikucunyujing; }
    public AndroidElement getshangpinkucun() { return shangpinkucun; }
    public AndroidElement getpancundan() { return pancundan; }
    public AndroidElement getbaosundan() { return baosundan; }
    public AndroidElement getpancunren() { return pancunren; }
    public AndroidElement getxinjianpancundan() { return xinjianpancundan; }
    public AndroidElement getxinjianbaosundan() { return xinjianbaosundan; }
    public AndroidElement getbaocun() { return baocun; }
    public AndroidElement gettijiao() { return tijiao; }
    public AndroidElement getbaosunren() { return baosunren; }
    public AndroidElement getjinhuoguanli() { return jinhuoguanli; }
    public AndroidElement getquanbugongyingshang() { return quanbugongyingshang; }
    public AndroidElement gethuazhi() { return huazhi; }
    public AndroidElement getgaoliangjiu() { return gaoliangjiu; }
    public AndroidElement gettuihuo() { return tuihuo; }
    public AndroidElement getyitijiao() { return yitijiao; }
    public AndroidElement getyiquxiao() { return yiquxiao; }
    public AndroidElement getyiruku() { return yiruku; }
    public AndroidElement gettuihuodan() { return tuihuodan; }
    public AndroidElement getjinhuodan() { return jinhuodan; }
    public AndroidElement getyituihuo() { return yituihuo; }
    public AndroidElement getyijujue() { return yijujue; }
    public AndroidElement getxiangming() { return xiangming; }
    public AndroidElement getdianpuzicai() { return dianpuzicai; }
    public AndroidElement getjiarugouwuche() { return jiarugouwuche; }
    public AndroidElement getkucundiaobo() { return kucundiaobo; }
    public AndroidElement getdiaobodan() { return diaobodan; }
    public AndroidElement getdiaochudan() { return diaochudan; }
    public AndroidElement getdiaorudan() { return diaorudan; }
    public AndroidElement gettijiaodiaobodan() { return tijiaodiaobodan; }
    public AndroidElement getmendianshezhi() { return mendianshezhi; }
    public AndroidElement getpeisongshezhi() { return peisongshezhi; }
    public AndroidElement getmendiangonggao() { return mendiangonggao; }
    public AndroidElement getxinzenggonggao() { return xinzenggonggao; }
    public AndroidElement getpeisongguanli() { return peisongguanli; }
    public AndroidElement getdaipeisong1() { return daipeisong1; }
    public AndroidElement getdaipeisong() { return daipeisong; }
    public AndroidElement getyipeisong() { return yipeisong; }
    public AndroidElement getpeisongzhong() { return peisongzhong; }
    public AndroidElement getpeisongwancheng() { return peisongwancheng; }
    public AndroidElement getbiangengpeisongyuan() { return biangengpeisongyuan; }
    public AndroidElement getpeisongchenggong() { return peisongchenggong; }
    public AndroidElement getjushou() { return jushou; }
    public AndroidElement getgongyingshangguanli() { return gongyingshangguanli; }
    public AndroidElement getgongyingshangshangpin() { return gongyingshangshangpin; }
    public AndroidElement getshanchu() { return shanchu; }
    public AndroidElement gettianjia() { return tianjia; }
    public AndroidElement getpijiu() { return pijiu; }
    public AndroidElement getquanbutianjia() { return quanbutianjia; }
    public AndroidElement getshangchenggonggao() { return shangchenggonggao; }
    public AndroidElement getmendianguanli() { return mendianguanli; }
    public AndroidElement getchakangongyingshangshangpin() { return chakangongyingshangshangpin; }

    public MobileElement getback() { return back; }
    public MobileElement getedit(){return edit;}
    public AndroidElement getnian(){return nian;}
    public AndroidElement getnian2017(){return nian2017;}
    public AndroidElement gethuankuankaishishijian(){return huankuankaishishijian;}
    public AndroidElement getdingdanchaxun(){return dingdanchaxun;}
    public AndroidElement getdingdanchaxunshijian(){return dingdanchaxunshijian;}

    //上滑
    public void huadong(){
        int width=driver.manage().window().getSize().width;

        int height=driver.manage().window().getSize().height;

        int y1 = height*2/3; //上滑的开始点，从y1开始也就是屏幕的四分之三处
        int y2 = height*1/4; //上滑的结束点，到y2结束也就是屏幕的三分之一处
        TouchAction tAction = new TouchAction(driver);
        PointOption point1 = PointOption.point(width / 2, y1);//上滑的开始点
        PointOption point2 = PointOption.point(width / 2, y2);//上滑的结束点
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();

        //tAction.press(width/2,y1).waitAction(Duration.ofMillis(1000)).moveTo(width/2,y2).release().perform();
    }
   //下滑
   public void xiahua(){
       int width=driver.manage().window().getSize().width;

       int height=driver.manage().window().getSize().height;

       int y1 = height*1/2; //下滑的开始点，从y1开始也就是屏幕的二分之一处
       int y2 = height*6/7; //下滑的结束点，到y2结束也就是屏幕的七分之六处
       TouchAction tAction = new TouchAction(driver);
       PointOption point1 = PointOption.point(width / 2, y1);//上滑的开始点
       PointOption point2 = PointOption.point(width / 2, y2);//上滑的结束点
       WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
       tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();
       //tAction.press(width/2,y1).waitAction(Duration.ofMillis(1000)).moveTo(width/2,y2).release().perform();
   }
    //右滑
    public void youhua(){
        int width=driver.manage().window().getSize().width;


        int height=driver.manage().window().getSize().height;

        int x1 = width*1/4; //右滑的开始点，从x1开始也就是屏幕的四分之一处
        int x2 = width*3/4; //右滑的结束点，到x2结束也就是屏幕的四分之三处
        TouchAction tAction = new TouchAction(driver);
        PointOption point1 = PointOption.point(x1, height/2);//右滑的开始点
        PointOption point2 = PointOption.point(x2, height/2);//右滑的结束点
        WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(1000));//滑动时间
        tAction.press(point1).waitAction(waitOptions).moveTo(point2).release().perform();

        //tAction.press(x1,height/2).waitAction(Duration.ofMillis(1000)).moveTo(x2,height/2).release().perform();
    }
}

