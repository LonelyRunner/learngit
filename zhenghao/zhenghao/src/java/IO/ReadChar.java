package java.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZH on 2016/1/7.
 */
public class ReadChar {
    public static void main(String args[]){
        try{
            char c ;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter characters, 'q' to quit.");
            do{
              c = (char)br.read();
                System.out.println(c);
            }while(c != 'q');

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
