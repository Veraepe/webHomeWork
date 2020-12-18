package test;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.logging.LogManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;


import vo.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatis {
	
	//private static java.util.logging.Logger log =LogManager.getLogManager().getLogger(Test.class.getName());
	@Autowired
//	private static IUserService userService;
	
	//@Test
	public static void main(String[] args) {
		Menu m;
		ArrayList<Menu> mlist=new ArrayList<Menu>();
		m=new Menu("1","1","1","1","1");
		mlist.add(m);
		m=new Menu("2","2","2","2","@");
		mlist.add(m);
		m=new Menu("3","3","3","3","3");
		mlist.add(m);
		
		
		
		String jsonstr="";
		jsonstr=new Gson().toJson(mlist);
		//System.out.println(userService.get("ddddd").getCity());
	}
}

