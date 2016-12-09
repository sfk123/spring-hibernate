package com.sheng.example.dao;

import java.util.List;

import com.sheng.example.entities.Book;

public interface BookShopDao {
	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String inbn);
	public void updateUserAccount(String username,int price);
	List<Book> getBooks();
	Book getById(int id);
	void updateBook(Book book);
}
