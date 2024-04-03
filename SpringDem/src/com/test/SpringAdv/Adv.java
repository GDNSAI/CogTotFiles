package com.test.SpringAdv;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

public class Adv {
	private int id;
	private String name;
	private String city;
	private Map<Integer,String> mad;
	@Override
	public String toString() {
		return "Adv [id=" + id + ", name=" + name + ", mad=" + mad + "]";
	}
	public int getId() {
		return id;
	}
	@Required
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer,String> getMad() {
		return mad;
	}
	public void setMad(Map<Integer,String> mad) {
		this.mad = mad;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
