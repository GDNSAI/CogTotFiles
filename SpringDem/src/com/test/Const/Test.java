package com.test.Const;

public class Test {
	private int id;
	private String street;
	private String city;
	@Override
	public String toString() {
		return "Test [id=" + id + ", street=" + street + ", city=" + city + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
