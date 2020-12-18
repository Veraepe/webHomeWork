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
import vo.Carousel;

@Controller
public class MainPageCarouselController {
	@Autowired
	private ICarouselService ics;
	

	@RequestMapping(value = "/getCarouselContent.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Carousel> getToCarousel(HttpSession session, HttpServletResponse response)
	{
		ArrayList<Carousel> clist=ics.getAllCarouselMsg();
		return clist;
	}
}
