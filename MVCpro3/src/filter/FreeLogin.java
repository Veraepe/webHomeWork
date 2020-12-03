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
				//取值出来做操作
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
			//如果tag=1就可以做查询
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
					tag=0;//没查询到，或者cookie的username被删了。
				}
			}
			ud.close();
			}
		

		if(tag==2)
		{
			//进行过滤转发
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
		
		if(tag==0)//可以简化，就是我懒
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
	}//如果cookie空的就放行
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
