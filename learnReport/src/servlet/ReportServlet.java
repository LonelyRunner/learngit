package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Profit;
import service.ReportService;

public class ReportServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		List<Profit> profits = ReportService.getProfitList();
		System.out.println("----------servlet-----------");
		for(Profit profit : profits){
			System.out.println(profit);
		}
		System.out.println("----------servlet-----------");
		//将获取的利润保存到session中
		request.getSession().setAttribute("profits", profits);
		response.sendRedirect("index.jsp");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
