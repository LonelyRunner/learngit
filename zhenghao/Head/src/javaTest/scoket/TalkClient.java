package javaTest.scoket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ZH on 2016/5/24.
 */
public class TalkClient {
    public static void main(String args[]){
        try{
            Socket socket = new Socket("127.0.0.1",4700);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            System.out.println("client:"+socket.getOutputStream().toString());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readLine;
            readLine = sin.readLine();
            while(!readLine.equals("bye")){
                os.println(readLine);
                os.flush();
                System.out.println("Client:"+readLine);
                System.out.println("Server:"+is.readLine());
                readLine = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
