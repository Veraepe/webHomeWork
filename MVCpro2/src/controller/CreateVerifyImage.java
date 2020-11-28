package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImage;

public class CreateVerifyImage extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CreateVerifyImage() {
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

		//response.setContentType("text/html");
				//PrintWriter out = response.getWriter();
				CreateImage createimg=new CreateImage();
				//生成随机字符串
				String code=createimg.genreateRancode();
				//获取session
				HttpSession session=request.getSession();
				session.setAttribute("verifyCode", code);//将随机码放到session中，之后就可以利用它了
				response.setContentType("img/jpeg");//设置返回内容
				
				//保证刷新问题，不能留有缓存，因为需要有随机性
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				//设置验证码失效时间
				response.setDateHeader("Expires",0);
				
				//生成图片
				BufferedImage img=createimg.Createimg(code);
				//用字节流发回去
				ServletOutputStream sout=response.getOutputStream();
				ImageIO.write(img,"JPEG",sout);
				sout.flush();
				sout.close();
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
