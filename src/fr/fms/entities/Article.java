package fr.fms.entities;

public class Article{
	private int id;
	private String description;
	private String brand;
	private double price;
	private int idCategory;
	
	public Article(int id, String description, String brand, double price, int idCategory) {
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.idCategory = idCategory;
	}
	

	public Article(String description, String brand, double price, int idCategory) {
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.idCategory = idCategory;
	}


	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	@Override
	public String toString() {
		return "Article [description=" + description + ", brand=" + brand + ", price=" + price + "]";
	}
	



	
	
}
