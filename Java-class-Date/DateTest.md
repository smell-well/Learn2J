### 打印日期类
>注：默认初始日期为1970年1月1日8点0分

`public class Main {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.print("now: ");
        System.out.println(d1);
        System.out.println();

        Date d2 = new Date(5000);// 5000ms
        System.out.print("从1970年开始: ");
        System.out.println(d2);
    }
}`
