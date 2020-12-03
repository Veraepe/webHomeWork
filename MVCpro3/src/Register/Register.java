package Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import vo.User;
@WebServlet(urlPatterns="/Register.do")
public class Register extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Register() {
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

		request.setCharacterEncoding("utf-8");
		int code=-1;
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String telephone=request.getParameter("telephone");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		
		User u=new User(userName, password, "", province, city, telephone, email);
		
		UserDao ud=new UserDao();
		try 
		{
			ud.insertToUser(u);
		} catch (Exception e) {}
		finally 
		{
			code=0;
		}
		ud.close();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code",code);
		String jsonStr=new Gson().toJson(map);		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(jsonStr);
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
