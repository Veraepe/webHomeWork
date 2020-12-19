package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;
@WebServlet(urlPatterns="/login.do")
public class login extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public login() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取属性
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		
		//获取验证码的servlet里面放进session的东西，也就是验证码
		HttpSession session=request.getSession();
		//取出验证码
		String realVCode=(String)session.getAttribute("verifyCode");//是个obj类型
		
		//比较
		String forwardPath="";//转发程序的url
		if(!(realVCode.equalsIgnoreCase(verifyCode)) )//equalsIgnoreCase无视大小写
		{
			request.setAttribute("info","验证码不正确");
			forwardPath="/error.jsp";
		}
		else
		{
			//验证码正确
			UserDao ud=new UserDao();//建立了与数据库的连接
			User u=null;
			try {
				u=ud.getbyname(userName);
				if(u==null)
				{
					request.setAttribute("info","用户名不正确");
					forwardPath="/error.jsp";
				}
				else if(!(u.getPassword().equals(password)))
				{
					request.setAttribute("info","密码不正确");
					forwardPath="/error.jsp";
				}
				else
				{
					session.setAttribute("userName", userName);
					forwardPath="/main.jsp";
				}
				//ud.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		//请求转发（因为可以共用一个request）
		RequestDispatcher rd=request.getRequestDispatcher(forwardPath);//获取转发对象
		rd.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
