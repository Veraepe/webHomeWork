package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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
		String check=request.getParameter("autoLogin");
		
		System.out.println(check);
		request.setCharacterEncoding("utf-8");
		//��ȡ����
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		System.out.println(verifyCode);
		//��ȡ��֤���servlet����Ž�session�Ķ�����Ҳ������֤��
		HttpSession session=request.getSession();
		//ȡ����֤��
		String realVCode=(String)session.getAttribute("verifyCode");//�Ǹ�obj����
		System.out.println("real="+realVCode);
		System.out.println("code="+verifyCode+"userName"+userName);
		
		//�Ƚ�
		Map<String,Object> map=new HashMap<String,Object>();
		if(!(realVCode.equals(verifyCode)) )//equalsIgnoreCase���Ӵ�Сд
		{
			map.put("code", 1);
			map.put("info","��֤�벻��ȷ");	
		}
		else
		{
			//��֤����ȷ
			UserDao ud=new UserDao();//�����������ݿ������
			User u=null;
			try {
				u=ud.getbyname(userName);
				if(u==null)
				{
					map.put("code", 2);
					map.put("info","�û���������");	
				}
				else if(!(u.getPassword().equals(password)))
				{
					map.put("code", 3);
					map.put("info","���벻��ȷ");	
				}
				else
				{
					session.setAttribute("userName", userName);
					/*if(u.getRole().equals("admin"))
					{
					forwardPath="/managementmain.jsp";
					}
					else
					{
						forwardPath="/main.jsp";
					}
					*/
					if(check!=null)
					{
						//setcookie
						Cookie c=new Cookie("uname", userName);
						c.setMaxAge(60*60*24*7);
						c.setPath("/");
						response.addCookie(c);
						Cookie c1=new Cookie("pword",password);
						c1.setMaxAge(60*60*24*7);
						c1.setPath("/");
						response.addCookie(c1);
						
						//System.out.println("cookieDEif");
					}
					map.put("code", 0);
					map.put("info","");
				}
				//ud.close();
			} catch (SQLException e) {
			}
		}
		
		String jsonStr=new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
