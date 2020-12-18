package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICarouselDAO;
import service.ICarouselService;

import vo.Carousel;

@Service
public class CarouselServiceImpl   implements ICarouselService{

	@Autowired
	private ICarouselDAO carouselDao;
	
	@Override
	public ArrayList<Carousel> getAllCarouselMsg() {
		// TODO Auto-generated method stub
		return carouselDao.getAll();
	}

}
