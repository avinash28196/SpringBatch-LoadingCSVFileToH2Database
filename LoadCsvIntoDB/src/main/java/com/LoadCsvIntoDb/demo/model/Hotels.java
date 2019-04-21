package com.LoadCsvIntoDb.demo.model;

public class Hotels {
	
	private Long id;
	private String name;
	private String description;
	private String city;
	private int rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Hotels(Long id, String name, String description, String city, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.rating = rating;
	}
	public Hotels()
	{
		
	}
	
	@Override
	public String toString() {
		return "Hotels [id=" + id + ", name=" + name + ", description=" + description + ", city=" + city + ", rating="
				+ rating + "]";
	}
	
	

}
