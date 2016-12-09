package com.sheng.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sheng.example.dao.BookShopDao;
import com.sheng.example.entities.Book;

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
	@Override
	public List<Book> books_List() {
		return bookShopDao.getBooks();
	}
	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		return bookShopDao.getById(id);
	}
	@Override
	public void updateBook(Book book) {
		bookShopDao.updateBook(book);
	}

}
