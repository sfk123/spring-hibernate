package com.text.spring.hibernate.dao;

public interface BookShopDao {
	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String inbn);
	public void updateUserAccount(String username,int price);
}
