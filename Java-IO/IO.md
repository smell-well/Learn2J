## 主要内容
### 1.创建文件对象
```Java
File f1 = new File("C:\\Users\\62568\\Desktop\\Learn2J\\TestFolder");
        System.out.println("f1的路径: " + f1.getAbsolutePath());

        File f2 = new File("./test.exe");
        System.out.println("f2的路径: " + f2.getAbsolutePath());

        //以f1为父目录
        File f3 = new File(f1, "test.exe");
        System.out.println("f3的路径: " + f3.getAbsolutePath());

```
<br />

## 练习
### 1.遍历文件夹

>一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。
遍历这个目录下所有的文件(不用遍历子目录)
找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

```Java
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
```

### 2.遍历子文件
>要求同上，但需考虑子文件夹
```java

```