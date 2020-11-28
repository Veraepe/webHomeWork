package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class IsIfLogin implements Filter {
	private String notCheckPath;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		int tag=0;//0是未登录,1是平名,2是管理员
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		System.out.println(userName);
		if(notCheckPath.indexOf(path)==-1)
		{
			if(session.getAttribute("userName")==null)
			{		
				request.getRequestDispatcher("/error.jsp").forward(request, arg1);
				return;
			}
			else
			{
				arg2.doFilter(arg0, arg1);
			}
		}
		else
		{
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		notCheckPath=arg0.getInitParameter("notCheckPath");
	}

}
