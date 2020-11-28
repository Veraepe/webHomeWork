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

public class DifferentLogin implements Filter {

	private String notCheckPath;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		int tag=0;//0��δ��¼,1��ƽ��,2�ǹ���Ա
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		//��һ�����أ����ص���û�е�¼�ĺ���
	//	if((!userName.equals(""))||session.getAttribute("userName")!=null) {
		//�ж�Ҫ��Ҫ����
			
			//��ѯ�ǲ��ǹ���Ա������main.jspʱ����ǹ���Ա��ת����managermain.jsp������ͷ���
			//����management.jsp,�����admin��ô�ͷ��У��������ز��÷���
			if(notCheckPath.indexOf(path)==-1)
			{
			UserDao ud=new UserDao();
			User u=null;
			try 
			{
				u=ud.getbyname(userName);
				
			} 
			catch (SQLException e) {}
			finally 
			{
				if(u!=null)
				{
				System.out.println(u.toString());
				String role=u.getRole();
				System.out.println(role);
				if(role.equals("admin"))//����ǹ���Ա
					tag=2;
				else
					tag=1;
				
				}
				else
				{
					arg2.doFilter(arg0, arg1);
					return;
				}
				try {
					ud.close();
				} catch (SQLException e) {}
			}
		System.out.println("Diff"+tag);
		//�����ǹ���Ա����ƽ��������
		switch(tag) {
		case 2:
			request.setAttribute("role","admin");
			if(path.equals("/main.jsp")||path.equals("login.do"))
			{	request.getRequestDispatcher("/managementmain.jsp").forward(request, arg1);
			//ת����managementmain.jsp
			return;
			}
			else 
				arg2.doFilter(arg0, arg1);
		break;
		case 1:
			request.setAttribute("role","user");
			if(path.equals("/managementmain.jsp")||path.equals("/GetManagementList.do")||path.equals("/management.jsp"))
			{
				System.out.println("23333"+path);
				//ת����managementmain.jsp
				request.getRequestDispatcher("/main.jsp").forward(request, arg1);
				return;
			}
			else
			{
				arg2.doFilter(arg0, arg1);
			}
			break;
		}
		}
			else
			{
				arg2.doFilter(arg0, arg1);
			}
	//}
	//else //û��¼
	//{
		//if(!path.equals("management.jsp"))
		//{
	//		arg2.doFilter(arg0, arg1);
		//}
	//}
	
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		notCheckPath=arg0.getInitParameter("notCheckPath");
	}

}
