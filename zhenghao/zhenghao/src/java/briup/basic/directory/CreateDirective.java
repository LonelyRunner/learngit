package java.briup.basic.directory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by ZH on 2015/12/24.
 */
public class CreateDirective {
    public static void main(String args[]){
        String directories = "D:/范博毅/范/博/毅/范/博/毅/范/博/毅/范/博/毅";
        File file = new File(directories);
        boolean result =file.mkdirs();
        System.out.println("status is "+result);
        try{
            BufferedWriter out = new
                    BufferedWriter(new FileWriter("D:/范博毅/首先/祝你/圣诞快乐/然后/送你/一个/大/surprise/毅/范/博/毅/readme.txt"));
            out.write("大  SB");
            out.close();
            System.out.println
                    ("文件创建成功！");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
