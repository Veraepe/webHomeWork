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

		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ����
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		
		//��ȡ��֤���servlet����Ž�session�Ķ�����Ҳ������֤��
		HttpSession session=request.getSession();
		//ȡ����֤��
		String realVCode=(String)session.getAttribute("verifyCode");//�Ǹ�obj����
		
		//�Ƚ�
		String forwardPath="";//ת�������url
		if(!(realVCode.equalsIgnoreCase(verifyCode)) )//equalsIgnoreCase���Ӵ�Сд
		{
			request.setAttribute("info","��֤�벻��ȷ");
			forwardPath="/error.jsp";
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
					request.setAttribute("info","�û�������ȷ");
					forwardPath="/error.jsp";
				}
				else if(!(u.getPassword().equals(password)))
				{
					request.setAttribute("info","���벻��ȷ");
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
		//����ת������Ϊ���Թ���һ��request��
		RequestDispatcher rd=request.getRequestDispatcher(forwardPath);//��ȡת������
		rd.forward(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
