package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DownloadDao;
import vo.Download;

public class DownloadController extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DownloadController() {
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

		String id=request.getParameter("id");
		DownloadDao dld=new DownloadDao();
		Download d=null;
		//��ȡ����
		try {
		d=dld.getById(Integer.parseInt(id));
		dld.close();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		String path=request.getServletContext().getRealPath("/WEB-INF/"+d.getPath());//����webinf����Ķ���
		String fileName=path.substring(path.lastIndexOf("\\")+1);//��ȡ�õ���·���У����һ��\��λ�ã�Ȼ�����һ��Ȼ������substring���н�ȡ
		//String fileName=d.getName();
		//��������ͷ�����������������
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
	
		//��������
		//�ֽ���
		InputStream in=new FileInputStream(path);
		int len=0;
		//������
		byte buffer[]=new byte[1024];
		
		ServletOutputStream out=response.getOutputStream();//��response��ȡ�����
		//��fileinputStream���뵽out
		while((len=in.read(buffer))!=-1)//len��ʾin��read��������buffer���ֽڵ�����������ȡ���˾���-1
		{
			out.write(buffer,0,len);
		}
		in.close();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
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
