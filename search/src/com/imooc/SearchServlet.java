package com.imooc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZH on 2016/11/1.
 */
public class SearchServlet extends HttpServlet {

    static List<String> dataSource = new ArrayList<>();
    static{
        dataSource.add("ajax");
        dataSource.add("ajax get");
        dataSource.add("ajax post");
        dataSource.add("ajax put");
        dataSource.add("branch");
        dataSource.add("git branch");
        dataSource.add("bitch");
        dataSource.add("james");
        dataSource.add("jone");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("Hello,success!");
        String keyWord = req.getParameter("keyword");
        List<String> list = getRelativeData(keyWord);
//        JSONArray jsonArray = JSONArray.fromObject(list);
        String str = "";
        for(String string : list){
            str += string+",";
        }
        System.out.println(str);
        resp.getWriter().write(str);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }

    public List<String> getRelativeData(String keyWord){
        List<String> returnList = new ArrayList<>();
        for(String d : dataSource){
            if(d.contains(keyWord)){
                returnList.add(d);
            }
        }
        return returnList;
    }
}
