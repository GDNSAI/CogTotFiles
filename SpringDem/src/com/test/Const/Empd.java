package com.test.Const;

public class Empd {
	public Empd(int id,Test address,String name) {
		this.address=address;
		this.id=id;
		this.name=name;
	}
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Empd [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public Test getAddress() {
		return address;
	}
	public void setAddress(Test address) {
		this.address = address;
	}
	private String name;
	private Test address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
