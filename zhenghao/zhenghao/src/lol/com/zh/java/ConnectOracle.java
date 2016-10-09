package lol.com.zh.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZH on 2016/1/27.
 */
public class ConnectOracle {
    public static String username = "briup";
    public static String password = "briup";
    public static String urlName = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String driverName = "oracle.jdbc.driver.OracleDriver";
    public static Connection connection = null;

    public static Connection getConnection() throws Exception{
        Class.forName(driverName);
        connection = DriverManager.getConnection(urlName,username,password);
        return connection;
    }

    public static List<Hero> getHeroList(){
        List<Hero> list = new ArrayList<>();
        String sql = "select * from hero_introduce";
        Statement statement = null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            conn = ConnectOracle.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                Hero p = new Hero();
                p.setHeroName(rs.getString(2));
                p.setHeroQ(rs.getString(3));
                p.setHeroW(rs.getString(4));
                p.setHeroE(rs.getString(5));
                p.setHeroR(rs.getString(6));
                p.setHeroPassive(rs.getString(7));
                p.setHeroImg(rs.getString(8));
                list.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String args[]){

        List<Hero> list = ConnectOracle.getHeroList();
        for(Hero hero:list){
            System.out.println(hero);
        }
    }
}
