package basic;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ATest{
    public static void main(String[]s){
        File filename = new File("F:/suncity.txt");
        String filein="你好！";
        RandomAccessFile mm=null;
        try{
            mm= new RandomAccessFile(filename,"rw");
            mm.writeBytes(filein);
        }catch(IOException e1){
            //TODO自动生成catch块
            e1.printStackTrace();
        }finally{
            if(mm!=null){
                try{
                    mm.close();
                }catch(IOException e2){
                    //TODO自动生成catch块
                    e2.printStackTrace();
                }
            }
        }
    }
}
