import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;



public class Main {
    public static void main(String[] args) throws ParseException {

        Date d1 = new Date();
        System.out.print("now: ");
        System.out.println(d1);
        System.out.println();

        Date d2 = new Date(5000);// 5000ms
        System.out.print("从1970年开始: ");
        System.out.println(d2);


        Date now = new Date();
        System.out.println("now: " + now.toString());
        // getTime() 返回一个long型整数，每过 1ms 增加 1
        System.out.println("the value is " + now.getTime());

        // 通过System.currentTimeMillis() 获取与getTime() 相同的效果
        // 可能由于机器性能导致时间略有差异
        System.out.println("the value is " + System.currentTimeMillis());

        Date org = new Date(0);
        System.out.println("origin time: " + org.toString());
        System.out.println("the value is " + org.getTime());


        String t1 = "1995-01-01 00:00:00";
        String t2 = "1995-12-31 24:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long D_start = ((Date)sdf.parse(t1)).getTime();
        long D_end = ((Date)sdf.parse(t2)).getTime();

        long rd_date = D_start + (long)(Math.random()*(D_end - D_start));
        Date rd_Date = new Date(rd_date);
        System.out.println("the random time is " + rd_Date);


        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        Date d = new Date();
        System.out.println("now time is " + SDF.format(d) + " in format. ");


        SortDate();
        CalendarTest();
        FindlastDay();

    }

    public static void SortDate() throws ParseException {

        SimpleDateFormat cmp = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat start_end = new SimpleDateFormat("yyyy");
        SimpleDateFormat print = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String start = "1970";
        String end = "2001"; //因为用2000时生成的随机数到不了2000，所以使用2001
        long TimeStart = ((Date)start_end.parse(start)).getTime();
        long TimeEnd = ((Date)start_end.parse(end)).getTime();

        Date[] d_list = new Date[9];
        System.out.println("随机生成的日期为: ");
        for(int i=0; i<9; i++)
        {
            d_list[i] = new Date(TimeStart + (long)(Math.random()*(TimeEnd - TimeStart)));
            System.out.println(print.format(d_list[i]));
        }
        Comparator<Date> CMP = new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                String s1 = cmp.format(o1);
                String s2 = cmp.format(o2);
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(d_list, CMP);
        System.out.println("排序后的日期为：");
        for(Date i : d_list)
        {
            System.out.println(print.format(i));
        }

    }

    public static void CalendarTest() {
        //采用单例模式获取Calendar（抽象类）
        Calendar c = Calendar.getInstance();

        Date d = c.getTime();
        System.out.println("日历上的时间为: "+d.toString());

        Date set = new Date(0);
        //设置日历为初始时间
        c.setTime(set);

        //个人猜测 OF_xx 的意思是本月、本年的下一天
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println((c.getTime()).toString());
        c.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println((c.getTime()).toString());
        c.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println((c.getTime()).toString());

        c.set(Calendar.MONTH, 1);
        System.out.println((c.getTime()).toString());
    }

    public static void FindlastDay() {
        Date now = new Date();
        Calendar c = Calendar.getInstance();

        c.setTime(now);
        c.add(Calendar.MONTH, 2);
        c.set(Calendar.DAY_OF_MONTH, -2); // 0 为上个月最后一天
        System.out.println((c.getTime()).toString());

    }
}
