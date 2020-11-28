package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tool.JdbcUtil;
import vo.Download;
import vo.User;

public class UserDao {
	
	private JdbcUtil jdbc;
	private Connection con;
	
	public UserDao(){
		
		this.jdbc=new JdbcUtil();
		this.con=this.jdbc.getConnection();
	}
	
	public User getbyname(String name) throws SQLException
	{
		User u=null;
		String sql="select * from t_user where userName=?";
		PreparedStatement ps=this.con.prepareStatement(sql);
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			String password=rs.getString("password");
			String role=rs.getString("role");
			u=new User(name, password, role);
		}
		
		return u;
	}
	
	public ArrayList<User> queryALL() throws SQLException
	{
		ArrayList<User> dlist=new ArrayList<User>();
		String sql="select * from t_user";
		PreparedStatement ps=this.con.prepareStatement(sql);
		//ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User d;
			String name=rs.getString("userName");
			String password=rs.getString("password");
			String role=rs.getString("role");
			d=new User(name, password, role);
			dlist.add(d);
		}
		return dlist;
	}
	
	
	
	
	public void close() throws SQLException{
		this.jdbc.close();
	}
	
}
	

