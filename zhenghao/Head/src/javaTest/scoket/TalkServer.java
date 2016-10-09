package javaTest.scoket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ZH on 2016/5/24.
 */
public class TalkServer {
    public static void main(String args[]){
        try{
            ServerSocket server = null;
            try{
                server = new ServerSocket(4700);
            }catch(Exception e){
                System.out.println("Cannot be listened:"+e);
            }
            Socket socket = null;
            socket = server.accept();
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client:"+is.readLine());
            line = sin.readLine();
            while(!line.equals("bye")){
                os.println(line);
                os.flush();
                System.out.println("Server:"+line);
                System.out.println("Client:"+is.readLine());
                line = sin.readLine();
            }
            os.close(); //关闭Socket输出流
            is.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
            server.close(); //关闭ServerSocket
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
