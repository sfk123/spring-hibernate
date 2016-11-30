package com.sheng.example.dao;

public interface BookShopDao {
	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String inbn);
	public void updateUserAccount(String username,int price);
}
