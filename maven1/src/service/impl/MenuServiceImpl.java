package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMenuDAO;
import service.IMenuService;
import vo.Menu;
@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private IMenuDAO menuDao;
	
	public ArrayList<Menu> getAllMenuMsg()
	{
		return menuDao.getAll();
	}

}
