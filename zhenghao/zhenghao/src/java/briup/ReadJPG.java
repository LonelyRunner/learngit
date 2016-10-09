package java.briup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by ZH on 2016/1/7.
 */
public class ReadJPG {
    public static void main(String args[]){
        File file = new File("a.txt");
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
