package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tool.JdbcUtil;
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
	
	public void close() throws SQLException{
		this.jdbc.close();
	}
	
}
	

