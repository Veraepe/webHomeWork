package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

public class FreeLogin implements Filter {

	String notCheckPath;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		Cookie[] cookies= request.getCookies();
		int tag=0;
		String valuename="";
		String pword="";
		String path=request.getServletPath();
		System.out.println(path);
		String userNameStr="";
		String passWordStr="";
	if(cookies!=null)
	{
		if(notCheckPath.indexOf(path)==-1)
		{
		//	System.out.println("is tag1");
		for(Cookie c:cookies)
		{
			valuename=c.getName();
			System.out.println(valuename);
			if("uname".equals(valuename))
			{		
				//ȡֵ����������
				userNameStr=c.getValue();	
				tag=1;
				//System.out.println("is tag1");
			}
			
			if("pword".equals(valuename))
			{
				passWordStr=c.getValue();
				tag=1;
			}
			
		}
		
		if(tag==1)
		{
			//���tag=1�Ϳ�������ѯ
			UserDao ud=new UserDao();
			User u=null;
			try {
				u=ud.getbyname(userNameStr);
				//System.out.println(u.toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				//System.out.println(u.toString());
				if(u!=null)
				{
					if(u.getPassword().equals(passWordStr))
					{
						tag=2;
					}
				}
				else
				{
					tag=0;//û��ѯ��������cookie��username��ɾ�ˡ�
				}
			}
			ud.close();
			}
		

		if(tag==2)
		{
			//���й���ת��
			HttpSession session=request.getSession();
			session.setAttribute("userName", userNameStr);
			
			if(path.equals("/index.html") || path.equals("/"))
			{
				request.getRequestDispatcher("/main.jsp").forward(request, arg1);
				return;
			}
			else {
				arg2.doFilter(arg0, arg1);
			}
			
		}
		
		if(tag==0)//���Լ򻯣���������
		{
			arg2.doFilter(arg0, arg1);
		}
		
		}
		else
		{
			arg2.doFilter(arg0, arg1);
		}
	}
	else
	{
			arg2.doFilter(arg0, arg1);
			//System.out.println("233333.");
	}//���cookie�յľͷ���
		System.out.println("tag="+tag);
		//arg2.doFilter(arg0,arg1);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		notCheckPath=arg0.getInitParameter("notCheckPath");
	}

}
