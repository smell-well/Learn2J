import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;




public class IOTest {
    static long mmax = 0, mmin = Integer.MAX_VALUE;
    static String mmax_f = "", mmin_f = "";
    public static void main(String[] args){
        //创建文件对象
        //使用绝对或相对路径的方式创建文件对象
        File f1 = new File("C:\\Users\\62568\\Desktop\\Learn2J\\TestFolder");
        System.out.println("f1的路径: " + f1.getAbsolutePath());

        File f2 = new File("./test.exe");
        System.out.println("f2的路径: " + f2.getAbsolutePath());

        //以f1为父目录
        File f3 = new File(f1, "test.exe");
        System.out.println("f3的路径: " + f3.getAbsolutePath());

        File C_windows = new File("C:\\Windows");
        File[] fs = C_windows.listFiles();

        int min = 0x7fffffff, max = 0;
        String  min_f = "", max_f = "";
        for(File file : fs)
        {
            if(file.isFile())
            {
                if(min > file.length())
                {
                    min = (int) file.length();
                    min_f = file.getName();
                }
                if(max < file.length())
                {
                    max = (int) file.length();
                    max_f = file.getName();
                }
            }
        }
        System.out.println("共有" + fs.length + "个文件");
        System.out.println("最小的文件为" + min_f + ", 大小为" + min);
        System.out.println("最大的文件为" + max_f + ", 大小为" + max);

        recursive(C_windows);
        System.out.println("最小的文件为" + mmin_f + ", 大小为" + mmin);
        System.out.println("最大的文件为" + mmax_f + ", 大小为" + mmax);


    }

    public static void recursive(File f){
        if(f.isFile()){
            if(mmin > f.length())
            {
                mmin = f.length();
                mmin_f = f.getName();
            }
            if(mmax < f.length())
            {
                mmax = f.length();
                mmax_f = f.getName();
            }
        }
        else{
            File[] fs = f.listFiles();
            if(fs != null){
                for(File file : fs)
                {
                    recursive(file);
                }
            }
        }
    }

}