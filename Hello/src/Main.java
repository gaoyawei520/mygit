import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("开始");
        System.out.println("");
        //简单循环
        /*{int a=0;
        int b=1;
        while(b<=100){
            a=a+b;
            b++;       }
        System.out.println("a="+a);}*/

        //if使用
        /*System.out.println("请输入一个数字");
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        if(c>100){ System.out.println("你是傻逼"); }
        else if(c<10){ System.out.println("你还是很傻逼"); }
        else {System.out.println("foolish");}*/

        //循环套用
        /*打印多排五角星
        * */

    /*    for(int a=1;a<=5;a++){
            for(int b=1;b<=6-a;b++){
                System.out.print("☆"); }
            System.out.println();
        }*/

        /*for(int a=1;a<=5;a++){
            for(int b=1;b<=6-a;b++){
                System.out.print("☆"); }
            System.out.println();
        }*/

  /*      int [] arr={9,1,2,5,4,7,6,8,10,11,12,13,14,15,16,0,47};
        int [] brr=new int[] {1,3,2,4,5};
        int [] crr=new int[5];
        crr[0]=6;crr[1]=5;crr[2]=4;crr[3]=8;crr[4]=7;
        sort1(crr);
        printarr(crr);
        sort0(crr);
        printarr(crr);
        sort11(arr);
        printarr(arr);
        sort00(arr);
        printarr(arr);*/



       /* String t = "a||b||c||d";

        String[] temp = t.split("\\|\\|");*/
       String c="\\|\\|";
       String num="你妹的";
       String k="text(\""+num+"\")";
       String d="true";
       boolean e=d=="true";
        System.out.println(e);
        System.out.println(k);
        System.out.println(c);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String tim="散装商品"+df.format(new Date());
        System.out.println(tim);

        double q=0.135; double w=1.125600;double t=0.9906;
        boolean y=q+t==w;
        System.out.println(y);
        String s=String.valueOf(t);
        int i=s.length();
        System.out.println(i);
        System.out.println("结束");
    }


    //定义一个方法,比较两个数的大小
    public static void compare(int a,int b) {
        if(a>b){ System.out.println(a+">"+b); }
        else if(a==b){ System.out.println(a+"="+b); }
        else{ System.out.println(a+"<"+b); }
    }

    //定义一个方法,置换两个数,无效
    public static void swap(int a,int b){
        int c;
        c=a;
        a=b;
        b=c; }
    //置换两个小数,无效
    public static void swap(double a,double b){
        double c;
        c=a;
        a=b;
        b=c;
    }
    //置换数组中的两个数,有效
    public  static void swap(int[] arr,int a,int b){
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }

    /*数组中的数字从大到小排序
     1新建数组
     2新建方法→数组中数字排序
     比较数组中前后两个数的大小,前者大于后者就互换位置,把较大的数放在右边,这样最右边的数就是最大的  正序
     比较数组中前后两个数的大小,前者小于后者就互换位置,把较大的数放在右边,这样最右边的数就是最小的  倒叙
     假设数组中5个数,需要比较换位4回合,每回合比较次数分别为4 3 2 1,回合数为1 2 3 4,这样大圈套小圈的思想就可以使用了
     n个数比较,共n-1个回合,回合数x,比较次数为n-x
     */
    //正序排列数组
    public static void sort1(int[] arr){
        for(int a=0;a<arr.length-1;a++){
            for(int b=0;b<arr.length-a-1;b++) {
                if(arr[b]>arr[b+1]){swap(arr,b,b+1);}
         } }  }

    //倒叙排列数组
    public static void sort0(int[] arr){
        for(int a=0;a<arr.length-1;a++){
            for(int b=0;b<arr.length-a-1;b++) {
                if(arr[b]<arr[b+1]){swap(arr,b,b+1);}
            } }  }



    /*打印数组:获取数组的长度length,然后打印arr[0]→arr[length-1]  */
    public static void printarr(int arr[]){
        System.out.print("{");
        for(int a=0;a<arr.length;a++) {
            if(a!=arr.length-1){System.out.print(arr[a]+",");}
            else{ System.out.print(arr[a]);}
                                        }
        System.out.println("}");
    }

    /*优化数组排序时的性能,多使用栈内存,少使用堆内存
    数组中数字排序
    比较数组中前后两个数的大小,前者大于后者就互换位置,把较大的数放在右边,这样最右边的数就是最大的  正序
    比较数组中前后两个数的大小,前者小于后者就互换位置,把较大的数放在右边,这样最右边的数就是最小的  倒叙
    优化方案,之前需要多次在栈内存中换位,现在每次数组值比大小则记下需要的数组索引,完成一次循环再换位置
    */
    //正序排列数组优化
    public static void sort11(int[] arr){
        for(int a=1;a<=arr.length-1;a++){
            int b;int max;
            for(b=1,max=0;b<=arr.length-a;b++) {
                if(arr[max]<arr[b]){max=b;} }
                if(max!=b-1){swap(arr,max,b-1);}
        }  }

    //倒序排列数组优化
    public static void sort00(int[] arr){
        for(int a=1;a<=arr.length-1;a++){
            int b;int max;
            for(b=1,max=0;b<=arr.length-a;b++) {
                if(arr[max]>arr[b]){max=b;} }
            if(max!=b-1){swap(arr,max,b-1);}
        }  }

}
