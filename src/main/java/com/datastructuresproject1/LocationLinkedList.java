package com.datastructuresproject1;

import javafx.scene.control.Label;

public class LocationLinkedList {
	// Attributes of LocationLinkedList
	private LocationNode Front, Back;
	private int Size;

	// Default constructor
	public LocationLinkedList() {
		Front = Back = null;
		Size = 0;
	}

	// Getter method for retrieving the front
	public LocationNode getFront() {
		return Front;
	}

	// Setter method for setting the front
	public void setFront(LocationNode front) {
		Front = front;
	}

	// Getter method for retrieving the back
	public LocationNode getBack() {
		return Back;
	}

	// Setter method for setting the back
	public void setBack(LocationNode back) {
		Back = back;
	}

	// Getter method for retrieving the size
	public int getSize() {
		return Size;
	}

	// Setter method for setting the size
	public void setSize(int size) {
		Size = size;
	}

	/* Methods go here */
	public void addFirst(Object element) {
		LocationNode newNode;
		newNode = new LocationNode(element);
		// Empty List
		if (Size == 0) {
			Front = Back = newNode;
		} else { // Not empty list
			newNode.setNext(Front);
			Front = newNode;
		}
		Size++;// update Size
	}

	// Getter method for retrieving the firstElement
	public Object getFirst() {
		// Empty List
		if (Size == 0)
			return null;
		else
			// First element
			return Front.getElement();
	}

	// Method that adds element at the end of the list
	public void addLast(Object element) {
		LocationNode newNode;
		newNode = new LocationNode(element);
		if (Size == 0) { // Empty List
			Front = Back = newNode;
		} else {
			Back.setNext(newNode);
			Back = newNode; // Or Back=Back.next;
		}
		Size++; // update Size
	}

	// Getter method for retrieving the lastElement
	public Object getLast() {
		// Empty list
		if (Size == 0)
			return null;
		else
			// Last element
			return Back.getElement();
	}

	// Getter method for retrieving element at specific index
	public Object get(int index) {
		// empty list
		if (Size == 0)
			return null;
		// first element
		else if (index == 0)
			return getFirst();
		// last element
		else if (index == Size - 1)
			return getLast();
		// neither first nor last
		else if (index > 0 && index < Size - 1) {
			LocationNode current = Front;
			// iterates over elements
			for (int i = 0; i < index; i++)
				current = current.getNext();
			return current.getElement();
		} else
			return null; // out of boundary
	}

	// Return the size of the list
	public int size() {
		return Size;
	}

	// Method that adds element to a specific index in the list
	public void add(int index, Object element) {
		// Empty list
		if (index == 0)
			addFirst(element);
		// If the list was full
		else if (index >= size())
			addLast(element);
		// If the list has elements
		else {
			LocationNode newNode = new LocationNode(element);
			// used to advance to proper position
			LocationNode current = Front;
			// Iterates over elements
			for (int i = 0; i < index - 1; i++)
				current = current.getNext();
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			// update size
			Size++;
		}
	}

	// Method that adds element to the end of the list
	public void add(Object element) {
		add(size(), element);
	}

	// Method that removes the first element
	public boolean removeFirst() {
		// empty list
		if (Size == 0)
			return false;
		// one element inside list
		else if (Size == 1)
			Front = Back = null;
		// more than one element in the list
		else
			Front = Front.getNext();
		// update size
		Size--;
		return true;
	}

	// Method that removes the last element of the list
	public boolean removeLast() {
		// empty list
		if (Size == 0)
			return false;
		// one element inside the list
		else if (Size == 1)
			Front = Back = null;
		else {
			// more than one element in the list
			LocationNode current = Front;
			for (int i = 0; i < Size - 2; i++)
				current = current.getNext();
			current.setNext(null);
			Back = current;
		}
		// update size
		Size--;
		return true;
	}

	// Method that removes element at specific index
	public boolean remove(int index) {
		// empty linked list
		if (Size == 0)
			return false;
		// remove first element
		else if (index == 0)
			return removeFirst();
		// remove last element
		else if (index == getSize() - 1)
			return removeLast();
		// iterates over locations to find the target index
		else if (index > 0 && index < Size - 1) {
			LocationNode current = Front;
			for (int i = 0; i < index - 1; i++)
				current = current.getNext();
			current.setNext(current.getNext().getNext());
			Size--;
			return true;
		} else
			// out of boundary(invalid index)
			return false;
	}

	// Clear the list by removing all elements
	public void clear() {
		Front = null;
		Size = 0;
	}

	// Find the index of the first occurrence of the specified element
	public int find(Object element) {
		LocationNode current = Front;
		int index = 0;
		// if the element is a location
		if (element instanceof Location) {
			// Iterates over locations
			while (current != null) {
				// If the location's name is same as the location in the list, the index will be
				// returned
				if (((Location) current.getElement()).getName().equalsIgnoreCase(((Location) element).getName())) {
					return index;
				}
				current = current.getNext();
				index++;
			}
			// Element not found
			return -1;
		}
		// Element not found
		return -1;
	}

	// Method to insert a location to the list but sorted alphabetically
	public void insertLocationSorted(LocationNode newNode, Label lbl) {
		// The location wanted to be added
		Location loc = (Location) newNode.getElement();

		// Check the existence of the location in the list
		if (find(loc) != -1) {
			lbl.setText("Error! This location already exists in this district!");
			return;
		}

		// If the list is empty or the new location comes before the first one
		// alphabetically
		if (Front == null || ((Location) Front.getElement()).getName()
				.compareToIgnoreCase(((Location) newNode.getElement()).getName()) >= 0) {
			newNode.setNext(Front);
			Front = newNode;
			// Set the head attribute of newNode to this list
			newNode.setHead(((Location) newNode.getElement()).getMartyrList());
			lbl.setText("Location '" + ((Location) newNode.getElement()).getName() + "' has been added successfully.");
		} else {
			LocationNode current = Front;
			// Find the appropriate position to insert the new location
			while (current.getNext() != null && ((Location) current.getNext().getElement()).getName()
					.compareToIgnoreCase(((Location) newNode.getElement()).getName()) < 0) {
				current = current.getNext();
			}
			// Insert the new location node at the appropriate position
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			// Set the head attribute of newNode to this list
			newNode.setHead(((Location) newNode.getElement()).getMartyrList());
			lbl.setText("Location '" + ((Location) newNode.getElement()).getName() + "' has been added successfully.");
		}
		// Update the Back reference if newNode is the last node
		if (newNode.getNext() == null) {
			Back = newNode;
		}
		// Increment the size of the list
		Size++;
	}

	// Method to retrieve the node that contains the target element
	public LocationNode findNode(Object data) {
		LocationNode current = Front;
		// Iterates over locations
		while (current != null) {
			// If the location's name is same as the location in the list, return the node
			if (((Location) current.getElement()).getName().equalsIgnoreCase(((Location) data).getName())) {
				return current; // return the node with the matching name
			}
			current = current.getNext();
		}
		// Node with the target element was not found
		return null; 
	}

	// Method that deletes a martyr from the location list
	public void deleteMartyr(String location, Martyr martyr) {
		//The node that contains the wanted location name
		LocationNode locNode = findNode(new Location(location));

		// If the location node was not found it will inform the user
		if (locNode == null) {
			System.out.println(location + " location was not found.");
			return;
		}

		// Get the martyrList that the location is pointing at
		MartyrLinkedList martyrList = locNode.getHead();

		// If the martyrList was empty, it will inform the user
		if (martyrList == null) {
			System.out.println("No martyrs found in this location: " + location + ".");
			return;
		}

		// Search for the target martyr
		int martyNodeIndex = martyrList.find(martyr);

		// If the martyr was not found, it will inform the user
		if (martyNodeIndex == -1) {
			System.out.println("Martyr '" + martyr.getName() + "' was not found in this location: " + location + ".");
			return;
		}

		// If the martyr was deleted successfully, it will inform the user
		if (martyrList.remove(martyNodeIndex)) {
			System.out.println("Martyr '" + martyr.getName() + "' has been deleted successfully from this location: "
					+ location + ".");
		} else {
			// If the martyr was not deleted, it will inform the user
			System.out.println("'" + martyr.getName() + "' hasn't been deleted from this location: " + location + ".");
		}
	}

	// Method that prints the elements inside the list
	public void print() {
		LocationNode current = Front;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	// Method that prints the elements inside the list from certain node
	public void print(LocationNode current) {
		if (current != null) {
			System.out.println(current.getElement());
			print(current.getNext());
		}
	}
}