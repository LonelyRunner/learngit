package briup.connectOracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperateFacade {
    public static String userName = "briup";
    public static String password = "briup";
    public static String urlName = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static String driverName = "oracle.jdbc.driver.OracleDriver";
    public static Connection conn = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;


    public static Connection getConn() throws SQLException,ClassNotFoundException{
        Class.forName(driverName);
        conn = DriverManager.getConnection(urlName,userName,password);
        return conn;
    }

    /**
     * @return 获取所有数据
     * @throws Exception
     */
    public static List<Hero> getAllResult() throws Exception{
        List result = new ArrayList<Hero>();
        String sql = "select * from hero_introduce";
        statement = OperateFacade.getConn().createStatement();
        resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);
        while(resultSet.next()){
            String heroName = resultSet.getString(1);
            String heroQ = resultSet.getString(2);
            String heroW = resultSet.getString(3);
            String heroE = resultSet.getString(4);
            String heroR = resultSet.getString(5);
            String heroPassive = resultSet.getString(6);
            String heroImg = resultSet.getString(7);
            Hero hero = new Hero(heroName,heroQ,heroW,heroE,heroR,heroPassive,heroImg);
            result.add(hero);
        }
        closeAboutMethod();
        return result;
    }

    /**
     * 保存hero
     * @param hero
     * @throws Exception
     */
    public static void saveHero(Hero hero) throws Exception{
        System.out.println("hero 保 存 中 ......");
        Integer id = getMaxId()+1;
        String sql = "insert into hero_introduce(id,HERO_NAME,HERO_Q,HERO_W,HERO_E,HERO_R,HERO_PASSIVE,HERO_IMG) " +
                " values("+id+",'"+hero.getHeroName()+"','"+hero.getHeroQ()+"','"+hero.getHeroW()+"','"
                +hero.getHeroE()+"','"+hero.getHeroR()+"','"+hero.getHeroPassive()+"','"+hero.getHeroImg()+"')";
        conn = getConn();
        statement = conn.createStatement();
        int i = statement.executeUpdate(sql);
        if(i>0){
            System.out.println("hero 保 存 成 功......");
        }
        closeAboutMethod();
    }

    /**
     * @return 获取最大id
     * @throws Exception
     */
    public static Integer getMaxId() throws Exception{
        Integer id = 0;
        String getBigId = "select max(id) from hero_introduce";
        conn = getConn();
        resultSet = conn.createStatement().executeQuery(getBigId);
        while(resultSet.next()){
            id = resultSet.getBigDecimal(1).intValue();
            System.out.println(id);
        }
        closeAboutMethod();
        return id;
    }

    /**
     * 根据id更新对应数据
     * @param id
     */
    public static void updateHeroById(Integer id,String heroQ) throws Exception{
        System.out.println("数 据 更 新 中......");
        String sql = "update hero_introduce set hero_Q=? where id=?";
        preparedStatement = getConn().prepareStatement(sql);
        preparedStatement.setString(1,heroQ);
        preparedStatement.setInt(2,id);
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("数 据 更 新 success ! ! !");
        }
        closeAboutMethod();
    }

    public static void deleteById(int id) throws Exception{
        System.out.println("删 除 进 行 中......");
        StringBuilder stringBuilder = new StringBuilder("delete hero_introduce where id = ");
        stringBuilder.append(id);
        statement = getConn().createStatement();
        int i = statement.executeUpdate(stringBuilder.toString());
        if(i>0){
            System.out.println("删 除 成 功 ! ! !");
        }
    }

    /**
     *
     * @throws Exception
     */
    public static void closeAboutMethod() throws Exception{
        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
    public static void main(String args[]) throws Exception{
        //增
        Hero heroToSave = new Hero("疾风剑豪","斩钢闪","风瀑之墙","踏前斩","狂风绝息斩","浪客之道","../../yaSuo.img");
        saveHero(heroToSave);
        //改
        updateHeroById(7,"斩钢闪1");
        //删
        deleteById(8);
        //查
        List<Hero> list = OperateFacade.getAllResult();
        for(Hero hero : list){
            System.out.println(hero);
        }
    }
}
