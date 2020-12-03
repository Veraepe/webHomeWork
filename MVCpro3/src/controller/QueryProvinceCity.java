package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CityDao;
import dao.ProvinceDao;
import vo.City;
import vo.Province;

@WebServlet(urlPatterns="/QueryProvinceCity.do")
public class QueryProvinceCity extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public QueryProvinceCity() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String provinceCode=request.getParameter("provinceCode");

		ArrayList<Province> plist = null;
		ArrayList<City> clist=null;
		String jsonstr = null;
		System.out.println("provinceCode"+provinceCode);
		if(provinceCode==null)//获取省份
		{
			ProvinceDao pd=new ProvinceDao();
			try 
			{
				plist=pd.getAllprovince();	
			} 
			catch (Exception e) {}
			finally 
			{
				
				jsonstr=new Gson().toJson(plist);
				pd.close();
			}
		}
		else//加载城市
		{
			System.out.println("我在这");
			CityDao cd=new CityDao();
			int code=Integer.parseInt(provinceCode);
			try 
			{
				clist=cd.queryByProvinceCode(code);
			} catch (Exception e) {}
			finally 
			{
				jsonstr=new Gson().toJson(clist);
				cd.close();
			}
		}
			
		//输出json字符串
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(jsonstr);
		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
