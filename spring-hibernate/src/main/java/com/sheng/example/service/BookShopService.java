package com.sheng.example.service;

import java.util.List;

import com.sheng.example.entities.Book;

public interface BookShopService {
	public void purchase(String username,String isbn);
	List<Book> books_List();
	Book getById(int id);
	void updateBook(Book book);
}
