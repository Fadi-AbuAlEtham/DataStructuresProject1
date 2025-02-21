package com.datastructuresproject1;

public class Location {
	// Attributes of Location
	private String name;
	private MartyrLinkedList martyrList;

	// Default constructor
	public Location() {
	}

	// Constructor with parameters
	public Location(String name) {
		this.name = name;
		martyrList = new MartyrLinkedList();
	}

	// Constructor with parameters
	public Location(String name, MartyrLinkedList martyrList) {
		this.name = name;
		this.martyrList = martyrList;
	}

	// Getter method for retrieving the name
	public String getName() {
		return name;
	}

	// Setter method for setting the name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for retrieving the martyrLinkedList
	public MartyrLinkedList getMartyrList() {
		return martyrList;
	}

	// Setter method for setting the martyrLinkedList
	public void setMartyrList(MartyrLinkedList martyrList) {
		this.martyrList = martyrList;
	}

	// Override toString method to provide a meaningful string representation of the
	// Location object
	@Override
	public String toString() {
//		return name;
		return "Location [name=" + name + ", martyrList=" + martyrList + "]";
	}

}
