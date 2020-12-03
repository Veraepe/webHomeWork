package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tool.JdbcUtil;
import vo.City;

import java.util.ArrayList;
public class CityDao {
	
	private JdbcUtil jdbc;
	private Connection con;
	
	public CityDao(){
		
		this.jdbc=new JdbcUtil();
		this.con=this.jdbc.getConnection();
	}
	
	public ArrayList<City> queryByProvinceCode(int code) throws Exception
	{
		ArrayList<City> clist=new ArrayList<City>();
		String sql="select * from t_city where provinceCode=?";
		PreparedStatement ps=this.con.prepareStatement(sql);
		ps.setInt(1,code);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			int provinceCode=rs.getInt("provinceCode");
			String provinceName=rs.getString("provinceName");
			int cityCode=rs.getInt("cityCode");
			String cityName=rs.getString("cityName");
			City c=new City(provinceCode, provinceName, cityCode, cityName);
			clist.add(c);
		}
		return clist;
	}
	
	
	public void close()
	{
			this.jdbc.close();
	}
	
}
