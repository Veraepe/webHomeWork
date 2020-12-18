package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Menu;

public interface IMenuDAO {

	public ArrayList<Menu> getAll() ;
	
}
