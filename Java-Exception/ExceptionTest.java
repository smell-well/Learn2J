import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args) {

        File f= new File("d:/LOL.exe");

        try{
            System.out.println("试图打开 d:/LOL.exe");
            new FileInputStream(f);
            System.out.println("成功打开");
        }
        catch(FileNotFoundException e){
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }
        finally{
            System.out.println("无论文件是否存在， 都会执行的代码");
        }

        try{
            ExceptionTest et = new ExceptionTest();
            et.CETest();
        } catch (CustomizedException e) {
            e.printStackTrace();
        }
    }

    public class CustomizedException extends Exception {
        public CustomizedException() {};
        public CustomizedException(String msg) {
            super(msg);
        }
    }

    public void CETest() throws CustomizedException {
        throw new CustomizedException("这是自定义的一个异常");
    }


}
