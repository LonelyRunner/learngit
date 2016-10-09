package java.IO;

import java.io.*;

/**
 * Created by ZH on 2016/1/7.
 */
public class ReadView {
    public static void main(String args[]) throws IOException{
        InputStream is = new FileInputStream("E:/zh.jpg");
        OutputStream os = new FileOutputStream("E:/a.txt");
        byte[] buff = new byte[4096];
        int len = 0;
        while ((len = is.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        System.out.println("文件读取成功！");
        os.close();
        is.close();
    }
}
