package com.datastructuresproject1;

public class District {
	// Attributes of District
	private String name;
	private LocationLinkedList locationList;

	// Default constructor
	public District() {
		locationList = new LocationLinkedList();
	}

	// Constructor with parameters
	public District(String name) {
		this.name = name;
		locationList = new LocationLinkedList();
	}

	// Constructor with parameters
	public District(String name, LocationLinkedList locationList) {
		this.name = name;
		this.locationList = locationList;
	}

	// Getter method for retrieving the name
	public String getName() {
		return name;
	}

	// Setter method for setting the name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for retrieving the locationLinkedList
	public LocationLinkedList getLocationList() {
		return locationList;
	}

	// Setter method for setting the locationLinkedList
	public void setLocationList(LocationLinkedList locationList) {
		this.locationList = locationList;
	}

	// Override toString method to provide a meaningful string representation of the
	// District object
	@Override
	public String toString() {
		return "District [name=" + name + ", locationList=" + locationList + "]";
	}
}
