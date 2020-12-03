package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tool.JdbcUtil;
import vo.Province;

public class ProvinceDao {
		
	private JdbcUtil jdbc;
	private Connection con;
	
	public ProvinceDao(){
		
		this.jdbc=new JdbcUtil();
		this.con=this.jdbc.getConnection();
	}
	
	public ArrayList<Province> getAllprovince() throws Exception
	{
		ArrayList<Province> plist=new ArrayList<Province>();
		String sql="select * from t_province";
		PreparedStatement ps=this.con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			int provinceCode=rs.getInt("provinceCode");
			String provinceName=rs.getString("provinceName");
			Province p=new  Province(provinceCode, provinceName);
			plist.add(p);
		}
		return plist;
	}
	
	public void close()
	{
			this.jdbc.close();
	}
	
}
