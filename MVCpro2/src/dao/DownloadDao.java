package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import tool.JdbcUtil;
import vo.Download;

public class DownloadDao {

	private JdbcUtil jdbc;
	private Connection con;
	
	public DownloadDao(){
		
		this.jdbc=new JdbcUtil();
		this.con=this.jdbc.getConnection();
	}
	
	public Download getById(int id) throws SQLException
	{
		Download d1 = null;
		String sql="select * from t_downloadlist where id=?";
		PreparedStatement ps=this.con.prepareStatement(sql);
		//ps.setString(1,id);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			//String password=rs.getString("password");
			//String role=rs.getString("role");
			String name=rs.getString("name");
			String path=rs.getString("path");
			String description=rs.getString("description");
			String size=filesizeTransfer(rs.getLong("size"));
			int star=rs.getInt("star");
			String image=rs.getString("image");
			String time=rs.getString("time");
			d1=new Download(id, name, path, description, size, star, image, time);
		}

		return d1; 
	}
	
	public ArrayList<Download> queryALL() throws SQLException
	{
		ArrayList<Download> dlist=new ArrayList<Download>();
		String sql="select * from t_downloadlist";
		PreparedStatement ps=this.con.prepareStatement(sql);
		//ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String path=rs.getString("path");
			String description=rs.getString("description");
			String size=filesizeTransfer(rs.getLong("size"));
			int star=rs.getInt("star");
			String image=rs.getString("image");
			String time=rs.getString("time");
			Download d=new Download(id, name, path, description, size, star, image, time);
			dlist.add(d);
			System.out.println("hhhhh"+id+name+path);
		}
		return dlist;
	}
	
	
	public String filesizeTransfer(long fileSize)
	{
		String tool=null;
		DecimalFormat df=new DecimalFormat("######0.000");//#表示有数字填数字，没数字填空
														//0表示如果没有数字则填0
		double size=(double)fileSize;
		if(size>1024*1024*1024)//g
		{
			size=size/(1024*1024*1024);
			tool=df.format(size)+"G";
		}
		else if(size>1024*1024)
		{
			size=size/(1024*1024);
			tool=df.format(size)+"MB";
		}
		else if(size>1024)
		{
			size=size/(1024);
			tool=df.format(size)+"KB";
		}
		else
		{
			tool=df.format(size)+"B";
		}
	return tool;
	}
	
	public void close() throws SQLException
	{
		this.jdbc.close();
		
	}
	
}
