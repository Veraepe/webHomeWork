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
		String sql="select * from t_newuser where userName=?";
		PreparedStatement ps=this.con.prepareStatement(sql);
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			String password=rs.getString("password");
			String role=rs.getString("role");
			String province=rs.getString("province");
			String city=rs.getString("city");
			String telephone=rs.getString("telephone");
			String email=rs.getString("email");
			u=new User(name, password, role,province,city,telephone,email);
		}
		
		return u;
	}
	
	public ArrayList<User> queryALL() throws SQLException
	{
		ArrayList<User> dlist=new ArrayList<User>();
		String sql="select * from t_newuser";
		PreparedStatement ps=this.con.prepareStatement(sql);
		//ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User d;
			String name=rs.getString("userName");
			String password=rs.getString("password");
			String role=rs.getString("role");
			String province=rs.getString("province");
			String city=rs.getString("city");
			String telephone=rs.getString("telephone");
			String email=rs.getString("email");
			d=new User(name, password, role,province,city,telephone,email);
			dlist.add(d);
		}
		return dlist;
	}
	
	public void insertToUser(User u) throws Exception
	{
		u.setRole("user");
		String sql="insert into t_newuser(userName,password,role,province,city,telephone,email) values(?,?,?,?,?,?,?)";
		PreparedStatement ps=this.con.prepareStatement(sql);
		ps.setString(1,u.getUserName());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getRole());
		ps.setString(4,u.getProvince());
		ps.setString(5,u.getProvince());
		ps.setString(6,u.getTelephone());
		ps.setString(7,u.getEmail());
		
		int index=ps.executeUpdate();
		System.out.println("user表"+index+"条被修改");
	}
	
	
	public void close(){
		this.jdbc.close();
	}
	
}
	

