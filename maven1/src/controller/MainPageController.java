package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ICarouselService;
import service.IMenuService;
import vo.Carousel;
import vo.Menu;

@Controller
public class MainPageController {
	@Autowired
	private IMenuService is;
	
	@RequestMapping(value = "/getMenuContent.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Menu> getToNav(HttpSession session, HttpServletResponse response){
		ArrayList<Menu> mlist=is.getAllMenuMsg();
		
		return mlist;
	}
	
}
