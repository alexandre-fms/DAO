package fr.fms.entities;

import java.util.ArrayList;

public class Cart {
	private int idCart;
	private User userCart;
	private ArrayList<Article> articles;
	
	public Cart(int idCart, User userCart, ArrayList<Article> articles) {
		this.idCart = idCart;
		this.userCart = userCart;
		this.articles = articles;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public User getUserCart() {
		return userCart;
	}

	public void setUserCart(User userCart) {
		this.userCart = userCart;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Cart [idCart=" + idCart + ", userCart=" + userCart + ", articles=" + articles + "]";
	}
	
	
	

}
