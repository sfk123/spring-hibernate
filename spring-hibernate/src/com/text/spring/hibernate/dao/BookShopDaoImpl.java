package com.text.spring.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql="select price from Book where isbn=?";
		Query query=getSession().createQuery(hql).setString(0, isbn);		
		return (Integer)query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		String hql2="select b.stock from Book b where b.isbn=?";
		int stock=(int)getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		System.out.println("���:"+stock);
		if(stock==0){
			//��治��
			System.out.println("��治��");
			throw new BookStockeException("��治��");
			
		}
		String hql="update Book b set b.stock=b.stock-1 where b.isbn=?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
		System.out.println("���¿�����");
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String hql2="select a.balance from Account a where a.userName=?";
		int balance=(int)getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if(balance<price){
			//����
			System.out.println("����");
			throw new UserAccountException("����");
		}
		String hql="update Account a set a.balance=a.balance-? where a.userName=?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
