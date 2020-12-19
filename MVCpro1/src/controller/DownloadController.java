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
		//获取对象
		try {
		d=dld.getById(Integer.parseInt(id));
		dld.close();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		String path=request.getServletContext().getRealPath("/WEB-INF/"+d.getPath());//访问webinf里面的东西
		String fileName=path.substring(path.lastIndexOf("\\")+1);//获取得到的路径中，最后一个\的位置，然后将其加一，然后再由substring进行截取
		//String fileName=d.getName();
		//设置下载头控制浏览器进行下载
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
	
		//进行下载
		//字节流
		InputStream in=new FileInputStream(path);
		int len=0;
		//缓存区
		byte buffer[]=new byte[1024];
		
		ServletOutputStream out=response.getOutputStream();//从response获取输出流
		//将fileinputStream输入到out
		while((len=in.read(buffer))!=-1)//len表示in用read方法读到buffer中字节的数量，当读取完了就是-1
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
