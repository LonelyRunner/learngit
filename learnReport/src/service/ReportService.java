package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Profit;
import jdbc.JdbcConnect;

public class ReportService {
	
	public static List<Profit> getProfitList(){
		List<Profit> result = new ArrayList<>();
		ResultSet rs,rs1;
		Statement st,st1;
		//查询商品名称、交易数量、交易笔数
		String  sql1 = "select gl.goods_name goodsName,\n" +
		               "sum(ti.trading_number) totalTradingNumber,\n" +
		               "count(gl.goods_name) totalNum\n" +
		               "from goodslist gl,trading_information ti\n" +
		               "where ti.trading_goods_id = gl.goods_id\n" +
		               "group by gl.goods_name";
		try {
			Connection connection = JdbcConnect.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(sql1);
			while(rs.next()){
				Profit profit = new Profit();
				profit.setGoodsName(rs.getString("goodsName"));
				profit.setTimes(rs.getInt("totalTradingNumber"));
				profit.setTradingNum(rs.getInt("totalNum"));
				
				st1 = connection.createStatement();
				//查询利润
				String sql2 = "select (gl.selling_price-gl.cost_price) profit "
						+ " from goodslist gl"
						+ " where gl.goods_name=\'"+profit.getGoodsName()+"\'";
				System.out.println(sql2);
				rs1 = st1.executeQuery(sql2);
				while(rs1.next()){
					profit.setProfit(profit.getTimes()*rs1.getInt("profit"));
				}
				result.add(profit);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------service---------------");
		for(Profit profit : result){
			System.out.println(profit);
		}
		System.out.println("-------------service---------------");
		return result;
	}
}
