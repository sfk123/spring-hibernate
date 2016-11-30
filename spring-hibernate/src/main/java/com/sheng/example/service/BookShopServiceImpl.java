package com.sheng.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheng.example.dao.BookShopDao;

@Service
public class BookShopServiceImpl implements BookShopService{

	@Autowired
	private BookShopDao bookShopDao;
	@Override
	public void purchase(String username, String isbn) {
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		System.out.println("价格:"+price);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
		
	}

}
