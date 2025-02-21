package com.datastructuresproject1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DistrictLinkedList {
	// Attributes of DistrictLinkedList
	private DistrictNode Front, Back;
	private int Size;

	// Default constructor
	public DistrictLinkedList() {
		Front = Back = null;
		Size = 0;
	}

	// Getter method for retrieving the front
	public DistrictNode getFront() {
		return Front;
	}

	// Setter method for setting the front
	public void setFront(DistrictNode front) {
		Front = front;
	}

	// Getter method for retrieving the back
	public DistrictNode getBack() {
		return Back;
	}

	// Setter method for setting the back
	public void setBack(DistrictNode back) {
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

	// Inserts the given element at the beginning of the list
	public void addFirst(Object element) {
		DistrictNode newNode;
		newNode = new DistrictNode(element);
		// Empty List
		if (Size == 0)
			Front = Back = newNode;
		// Not empty list
		else {
			newNode.setNext(Front);
			Front.setPrev(newNode);
			Front = newNode;
		}
		Size++;
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

	public Object getLast() {
		// Empty List
		if (Size == 0)
			return null;
		else
			// Last element
			return Back.getElement();
	}

	// Method that adds element to a specific index in the list
	public void add(int index, Object element) {
		// Empty list
		if (index == 0) {
			addFirst(element);
		}
		// If the list was full
		else if (index >= getSize()) {
			addLast(element);
		}
		// If the list has elements
		else {
			DistrictNode newNode = new DistrictNode(element);
			// Used to advance to proper position
			DistrictNode current = Front;
			// Iterates over elements
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			current.getNext().setPrev(newNode); // Set the previous node of the next node to newNode
			current.setNext(newNode);
			// update size
			Size++;
		}
	}

	// Method that adds element to the end of the list
	public void add(Object element) {
		add(size(), element);
	}

	// Method that adds element at the end of the list
	public void addLast(Object element) {
		DistrictNode newNode = new DistrictNode(element); // Create a new node

		// Empty List
		if (Size == 0) {
			Front = Back = newNode;
		} else {
			newNode.setPrev(Back); // Set the previous node of the new node to the current Back
			Back.setNext(newNode); // Set the next node of the current Back to the new node
			Back = newNode; // Update Back to point to the new node
		}
		Size++;
	}

	// Method that removes the first element of the list
	public boolean removeFirst() {
		// empty list
		if (Size == 0)
			return false;
		// one element inside list
		else if (Size == 1) {
			Front = Back = null;
		} else {
			// Update the next node of the current Front
			Front = Front.getNext();
			Front.setPrev(null); // Set the previous reference of the new Front to null
		}
		// update size
		Size--;
		return true;
	}

	// Method that removes an element from specific index
	public boolean remove(int index) {
		// empty list or invalid index
		if (Size == 0 || index < 0 || index >= Size)
			return false;
		// remove first element
		else if (index == 0)
			return removeFirst();
		// remove last element
		else if (index == Size - 1)
			return removeLast();
		else {
			DistrictNode current = Front;
			// Traverse to the node before the one to be removed
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			// Update references to remove the node
			current.setNext(current.getNext().getNext());
			current.getNext().setPrev(current); // Update the previous reference of the next node
			Size--;
			return true;
		}
	}

	// Method that removes the last element in the list
	public boolean removeLast() {
		// empty list
		if (Size == 0)
			return false;
		// one element inside the list
		else if (Size == 1) {
			Front = Back = null;
		} else {
			Back = Back.getPrev();
			// Remove the connection to the next node
			Back.setNext(null);
		}
		// Update size
		Size--;
		return true;
	}

	// Method that removes an element from a specific index
	public Object get(int index) {
		// index out of bounds
		if (index < 0 || index >= Size) {
			return null;
		}
		// first element
		else if (index == 0) {
			return getFirst();
		}
		// last element
		else if (index == Size - 1) {
			return getLast();
		}
		// If the element was neither in the first nor the end
		else {
			DistrictNode current;
			// Determine whether to traverse from the front or the back based on index
			if (index <= Size / 2) {
				current = Front;
				for (int i = 0; i < index; i++) {
					current = current.getNext();
				}
			} else {
				current = Back;
				for (int i = Size - 1; i > index; i--) {
					current = current.getPrev();
				}
			}
			return current.getElement();
		}
	}

	// Retrieve the size of the list
	public int size() {
		return Size;
	}

	// Clear the list by removing all elements
	public void clear() {
		Front = null;
		Size = 0;
	}

	// Find the index of the first occurrence of the specified element
	public int find(Object element) {
		DistrictNode current = Front;
		int index = 0;
		while (current != null) {
			// If the district name is same as the district target, return the index
			if (((District) current.getElement()).getName().equalsIgnoreCase((String) element)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		// Element not found
		return -1;
	}

	public void insertDistrictSorted(DistrictNode newNode, Label lbl) {
		// Check if the list is empty or if the new district comes before the first one
		// alphabetically
		if (Front == null || (((District) Front.getElement()).getName())
				.compareToIgnoreCase(((District) newNode.getElement()).getName()) >= 0) {
			newNode.setNext(Front);
			// If the list is not empty, set the previous reference of the current Front
			// node to the new node
			if (Front != null) {
				Front.setPrev(newNode);
			} else {
				Back = newNode; // If the list is empty, set Back to newNode
			}
			Front = newNode; // Set Front to newNode
			// Set the head attribute of newNode to the locationList of the District
			newNode.setHead(((District) newNode.getElement()).getLocationList());
			// Display success message
			lbl.setText(
					"District '" + ((District) newNode.getElement()).getName() + "' has been inserted successfully.\n");
		} else {
			// If the new district comes after the first one alphabetically, find its
			// appropriate position
			DistrictNode current = Front;
			while (current.getNext() != null && (((District) current.getNext().getElement()).getName())
					.compareToIgnoreCase(((District) newNode.getElement()).getName()) < 0) {
				current = current.getNext();
			}
			// Insert the new district node at the appropriate position
			newNode.setNext(current.getNext());
			newNode.setPrev(current);
			// If newNode is not the last node, set the previous reference of the next node
			// to newNode
			if (current.getNext() != null) {
				current.getNext().setPrev(newNode);
			} else {
				Back = newNode; // If newNode is the last node, update Back reference
			}
			current.setNext(newNode);
			// Set the head attribute of newNode to the locationList of the District
			newNode.setHead(((District) newNode.getElement()).getLocationList());
			// Display success message
			lbl.setText(
					"District '" + ((District) newNode.getElement()).getName() + "' has been inserted successfully.\n");
		}
		Size++; // Increment the size of the list
	}

	// Method that renames the district
	public void renameDistrict(String oldName, String newName, Label lbl) {
		// Check if oldName or newName are empty
		if (oldName.isEmpty()) {
			lbl.setText("Enter the district name that you want to rename first!");
			return;
		} else if (newName.isEmpty()) {
			lbl.setText("Enter the new district name for '" + oldName + "'.");
			return;
		}

		// Find the old district node
		DistrictNode oldDistrictNode = findNode(new District(oldName));
		// Create a reference to the old district node
		DistrictNode newDistrictNode = oldDistrictNode;

		// Check if the new name already exists
		if (find(newName) != -1) {
			lbl.setText("Error! Can't rename this district because the new name already exists!");
			return;
		}

		// Check if the old district node exists
		if (oldDistrictNode != null) {
			// Remove the old district node from the list
			remove(find(oldName));
			// Set the name of the district to the new name
			((District) newDistrictNode.getElement()).setName(newName);
			// Insert the renamed district node sorted into the list
			insertDistrictSorted(newDistrictNode, lbl);
			// Display success message
			lbl.setText(oldName + " district has been renamed to " + newName);
		} else {
			lbl.setText(oldName + " district doesn't exist!");
		}
	}

	// Method that renames the location
	public void renameLocation(String district, String oldName, String newName, Label lbl) {
		// Check if district, oldName, or newName are empty
		if (district.isEmpty()) {
			lbl.setText("Enter the district name first!");
			return;
		} else if (oldName.isEmpty()) {
			lbl.setText("Enter the location name that you want to rename first!");
			return;
		} else if (newName.isEmpty()) {
			lbl.setText("Enter the new location name for '" + oldName + "'.");
			return;
		}

		// Find the district node
		DistrictNode districtNode = findNode(new District(district));

		// Check if the district node exists
		if (districtNode == null) {
			lbl.setText("Error! This district doesn't exist!");
			return;
		}

		// Get the location list of the district
		LocationLinkedList locationList = districtNode.getHead();

		// Check if the new name already exists in the location list
		if (locationList.find(new Location(newName)) != -1) {
			lbl.setText("Error! Can't rename this location because the new name already exists!");
			return;
		}

		// Find the old location node
		LocationNode oldLocationNode = locationList.findNode(new Location(oldName));
		// Create a reference to the old location node
		LocationNode newLocationNode = oldLocationNode;

		// Check if the old location node exists
		if (oldLocationNode != null) {
			// Remove the old location node from the list
			locationList.remove(locationList.find(oldLocationNode));
			// Set the name of the location to the new name
			((Location) newLocationNode.getElement()).setName(newName);
			// Insert the renamed location node sorted into the list
			locationList.insertLocationSorted(newLocationNode, lbl);
			// Display success message
			lbl.setText(oldName + " has been updated successfully to " + newName + ".");
		} else {
			lbl.setText(oldName + " location doesn't exist!");
		}
	}

	// Method that returns the node with the same target info
	public DistrictNode findNode(Object data) {
		DistrictNode current = Front;
		while (current != null) {
			// Each node contains an element representing a name
			if (((District) current.getElement()).getName().equalsIgnoreCase(((District) data).getName())) {
				return current; // Found the node with the matching name
			}
			current = current.getNext();
		}
		return null; // Node with the target name not found
	}

	// Method that updates a district
	public void updateDistrict(String oldDis, String newDis, Label lbl) {
		// Check if both names are filled
		if (oldDis.isEmpty()) {
			lbl.setText("Enter the district name that you want to update first!");
			return;
		} else if (newDis.isEmpty()) {
			lbl.setText("Enter the new district name for " + oldDis + ".");
			return;
		}

		// Check if both names are the same
		if (oldDis.equals(newDis)) {
			lbl.setText("The new district name is the same as the old one. No updates needed.");
			return;
		}

		// Check the existence of the old district name
		int oldDisNodeIndex = find(oldDis);

		// If there was no district from the list with the same name, we can't update
		if (oldDisNodeIndex == -1) {
			lbl.setText(oldDis + " district doesn't exist!");
			return;
		}

		// Check the existence of the new district name
		int newDisNodeIndex = find(newDis);

		// If the new district doesn't exist from before, remove the old district and
		// insert the new one
		if (newDisNodeIndex == -1) {
			remove(oldDisNodeIndex);
			insertDistrictSorted(new DistrictNode(new District(newDis)), lbl);
			lbl.setText(oldDis + " has been updated succesfully to " + newDis + ".");
		} else {
			// If both old and new district names exist and they are different, remove the
			// old district
			if (oldDisNodeIndex != newDisNodeIndex) {
				remove(oldDisNodeIndex);
				lbl.setText(oldDis + " has been updated succesfully to " + newDis + ".");
			}
		}
	}

	// Method that updates the location
	public void updateLocation(String district, String oldLoc, String newLoc, Label lbl) {
		// check if the names are filled
		if (district.isEmpty()) {
			lbl.setText("Enter a district name first!");
			return;
		} else if (oldLoc.isEmpty()) {
			lbl.setText("Enter the location name that you want to update first!");
			return;
		} else if (newLoc.isEmpty()) {
			lbl.setText("Enter the new location name for " + oldLoc + ".");
			return;
		}

		// Find the district node
		DistrictNode districtNode = findNode(new District(district));
		if (districtNode == null) {
			lbl.setText("The district name is wrong, try again!");
			return;
		}

		// Check if the new location name is the same as the old one
		if (oldLoc.equalsIgnoreCase(newLoc)) {
			lbl.setText("The new location name is the same as the old one. No updates needed.");
			return;
		}

		// Check if the location exist in different district
		if (findLocation(newLoc) != null) {
			lbl.setText("Error: The new location exist in different district!");
			return;
		}

		// Find the location list for the specified district
		LocationLinkedList locationList = (LocationLinkedList) districtNode.getHead();

		// Check if the old location exists in the specified district
		int oldLocIndex = locationList.find(new Location(oldLoc));
		if (oldLocIndex == -1) {
			lbl.setText("The old location does not exist in the specified district.");
			return;
		}

		// Remove the old location from the specified district
		locationList.remove(oldLocIndex);

		// Add the new location to the specified district
		locationList.insertLocationSorted(new LocationNode(new Location(newLoc)), lbl);

		lbl.setText("Location updated successfully.");
	}

	// Method to update a martyr's information
	public void updateMartyr(DistrictNode districtNode, MartyrLinkedList martyrList, String district, String location,
			String oldMart, Martyr newMart, TextArea txtArea, Label lbl) {
		// Check if district, location, oldMart, or newMart are empty
		if (district.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter a district name first!");
			return;
		} else if (location.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter a location name first!");
			return;
		} else if (oldMart.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter the martyr details that you want to update first!");
			return;
		} else if (newMart == null) {
			lbl.setVisible(true);
			lbl.setText("Enter the new martyr details for " + oldMart + ".");
			return;
		}

		// Check if the old martyr exists in the specified location
		int oldLocIndex = martyrList.findByName(oldMart);
		if (oldLocIndex == -1) {
			lbl.setVisible(true);
			lbl.setText("The old martyr does not exist in the specified location.");
			return;
		}

		// Remove the old martyr from the specified location
		martyrList.remove(oldLocIndex);

		// Check if the new martyr's location and district match the provided ones
		if (location.equalsIgnoreCase(newMart.getLocation()) && district.equalsIgnoreCase(newMart.getDistrict())) {
			// Add the new martyr to the specified location
			lbl.setVisible(true);
			martyrList.insertMartyrSorted(new MartyrNode(newMart), txtArea, lbl);
			lbl.setText("Martyr updated successfully.");
		}
		// If the martyr was updated to a different location
		else if (!location.equalsIgnoreCase(newMart.getLocation())
				&& district.equalsIgnoreCase(newMart.getDistrict())) {
			// Get the reference to the locationList of the district
			LocationLinkedList locationList1 = (LocationLinkedList) districtNode.getHead();
			// Insert the new location if it doesn't exist
			Location loc = new Location(newMart.getLocation());
			LocationNode locationNode1 = locationList1.findNode(loc);
			if (locationNode1 == null) {
				locationNode1 = new LocationNode(loc);
				lbl.setVisible(true);
				locationList1.insertLocationSorted(locationNode1, lbl);
			}

			// Insert the new martyr into the sorted location
			Martyr martyr = newMart;
			MartyrNode martyrNode = new MartyrNode(martyr);
			// Get the reference to the martyrList of the location
			MartyrLinkedList martyrList1 = locationNode1.getHead();
			lbl.setVisible(true);
			martyrList1.insertMartyrSorted(martyrNode, txtArea, lbl);
			lbl.setText("Martyr updated successfully.");
		}
		// If the martyr was updated to a different location and different district
		else if (!district.equalsIgnoreCase(newMart.getDistrict())
				&& !location.equalsIgnoreCase(newMart.getLocation())) {
			// Insert the new district if it doesn't exist
			District dis = new District(newMart.getDistrict());
			DistrictNode districtNode1 = findNode(dis);
			if (districtNode1 == null) {
				districtNode1 = new DistrictNode(dis);
				lbl.setVisible(true);
				insertDistrictSorted(districtNode1, lbl);
			}
			// Get the reference to the locationList of the district
			LocationLinkedList locationList1 = (LocationLinkedList) districtNode1.getHead();

			// Insert the new location if it doesn't exist
			Location loc = new Location(newMart.getLocation());
			LocationNode locationNode1 = locationList1.findNode(loc);
			if (locationNode1 == null) {
				locationNode1 = new LocationNode(loc);
				lbl.setVisible(true);
				locationList1.insertLocationSorted(locationNode1, lbl);
			}

			// Insert the new martyr into the sorted location
			Martyr martyr = newMart;
			MartyrNode martyrNode = new MartyrNode(martyr);
			// Get the reference to the martyrList of the location
			MartyrLinkedList martyrList1 = locationNode1.getHead();
			lbl.setVisible(true);
			martyrList1.insertMartyrSorted(martyrNode, txtArea, lbl);
			lbl.setText("Martyr updated successfully.");
		}
	}

	// Method that deletes a location
	public void deleteLocation(String district, String location, Label lbl) {
		DistrictNode disNode = findNode(new District(district));

		// Check if the district exist or not
		if (disNode == null) {
			lbl.setVisible(true);
			lbl.setText(district + " district doesn't exist!");
			return;
		}

		// Check the existence of the location
		LocationLinkedList locationList = disNode.getHead();
		int locationNodeIndex = locationList.find(new Location(location));

		if (locationNodeIndex == -1) {
			lbl.setVisible(true);
			lbl.setText(location + " location doesn't exist!");
			return;
		}

		// Notify the user whether the delete was successful or failed
		if (locationList.remove(locationNodeIndex)) {
			lbl.setVisible(true);
			lbl.setText(location + " has been deleted succesfully!");
		} else {
			lbl.setVisible(true);
			lbl.setText(location + " hasn't been deleted!");
		}

	}

	// Method that deletes a district
	public void deleteDistrict(String district, Label lbl) {
		// Check the existence of the district
		int index = find(district);
		if (index == -1) {
			lbl.setVisible(true);
			lbl.setText(district + " district doesn't exist!");
			return;
		}
		// Notify the user whether the delete was successful or failed
		if (remove(index)) {
			lbl.setVisible(true);
			lbl.setText(district + " has been deleted succesfully!");
		} else {
			lbl.setVisible(true);
			lbl.setText(district + " hasn't been deleted!");
		}
	}

	// Method to display statistics of martyrs in a certain location
	public void showCertainLocStat(String districtName, String locationName, TextArea txtArea, Label lbl) {
		// Check if districtName or locationName are empty
		if (districtName.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter a district name first!");
			return;
		} else if (locationName.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter a location name!");
			return;
		}

		// Find the district
		DistrictNode districtNode = findNode(new District(districtName));

		if (districtNode == null) {
			lbl.setVisible(true);
			lbl.setText("District '" + districtName + "' not found.");
			return;
		}

		// Find the location within the district
		LocationNode current = districtNode.getHead().findNode(new Location(locationName));

		if (current == null) {
			lbl.setVisible(true);
			lbl.setText("Location '" + locationName + "' not found in district '" + districtName + "'.");
			return;
		}

		// Current is pointing to the node containing the specified location name
		Location location = (Location) current.getElement();
		txtArea.setVisible(true);
		txtArea.appendText("Location: " + location.getName());

		MartyrLinkedList martyrList = (MartyrLinkedList) current.getHead();

		int totalMartyrs = martyrList.getSize();
		int totalMaleMartyrs = martyrList.getMartyrTotalMale();
		int totalFemaleMartyrs = martyrList.getMartyrTotalFemale();
		double totalMartyrAges = martyrList.getMartyrAgeAvg();
		double averageAge = 0;

		// Calculate average age
		if (totalMartyrs > 0) {
			averageAge = totalMartyrAges / totalMartyrs;
		}

		// Print out the collected statistics
		lbl.setVisible(false);
		txtArea.appendText("\nTotal martyrs: " + totalMartyrs);
		txtArea.appendText("\nTotal male martyrs: " + totalMaleMartyrs);
		txtArea.appendText("\nTotal female martyrs: " + totalFemaleMartyrs);
		txtArea.appendText("\nAverage martyrs age: " + String.format("%.2f", averageAge));

		// If there was more than one martyr
		if (totalMartyrs > 1) {
			MartyrNode track = martyrList.getFront();

			// Let the track starts from where is greater than zero because we might have
			// martyrs with age -1 that is considered as empty
			while (track != null && ((Martyr) track.getElement()).getAge() < 0) {
				track = track.getNext();
			}

			Martyr youngest = (Martyr) track.getElement();

			// Find and print youngest martyrs
			txtArea.appendText("\nYoungest martyr(s): ");
			while (track != null) {
				if (((Martyr) track.getElement()).getAge() < youngest.getAge()) {
					youngest = (Martyr) track.getElement();
				}
				track = track.getNext();
			}
			txtArea.appendText(youngest.getName() + " ,Age: " + youngest.getAge());

			// Find and print oldest martyrs
			txtArea.appendText("\nOldest martyr(s): ");
			Martyr oldest = (Martyr) martyrList.getBack().getElement();
			txtArea.appendText(oldest.getName() + " ,Age: " + oldest.getAge());
			for (int i = martyrList.getSize() - 2; i >= 0; i--) {
				Martyr curr = (Martyr) martyrList.get(i);
				Martyr previous = (Martyr) martyrList.get(i + 1);
				if (curr.getAge() != previous.getAge()) {
					break;
				}
				txtArea.appendText(curr.getName() + " ,Age: " + curr.getAge());
			}
		}
		// If their was only one martyr
		else if (totalMartyrs == 1) {
			txtArea.appendText("\n" + ((Martyr) martyrList.getFront().getElement()).getName()
					+ " is the only martyr in this location so can't be compared!");
		}
	}

	// Method that shows statistics for a district
	public void showStatistics(DistrictNode current, TextArea txtArea, Label lbl) {
		if (current != null) {
			// The district that was sent to the method
			District district = (District) current.getElement();
			txtArea.setText("");
			lbl.setText("District: " + district.getName());
			txtArea.appendText("District: " + district.getName());

			// The locationList that the district is referencing to
			LocationLinkedList locationList = (LocationLinkedList) current.getHead();

			int totalMartyr = 0;
			int totalMale = 0;
			int totalFemale = 0;
			double average = 0;

			// Iterate over the locations within the district
			LocationNode currentLocation = locationList.getFront();
			while (currentLocation != null) {
				MartyrLinkedList martyrList = (MartyrLinkedList) currentLocation.getHead();
				totalMartyr += martyrList.getSize();
				totalMale += martyrList.getMartyrTotalMale();
				totalFemale += martyrList.getMartyrTotalFemale();
				average += martyrList.getMartyrAgeAvg();

				// Move to the next location
				currentLocation = currentLocation.getNext();
			}

			// Calculate average age of martyrs
			if (totalMartyr > 0) {
				average /= totalMartyr;
			} else {
				average = 0.0;
			}

			// Show the average number just with two decimals
			String formattedAverage = String.format("%.2f", average);

			// Print the statistics on the textArea
			txtArea.appendText("\nTotal martyrs: " + totalMartyr + "\nTotal male martyrs: " + totalMale
					+ "\nTotal female martyrs: " + totalFemale + "\nTotal martyrs age average: " + formattedAverage
					+ "\nThe date with maximum number of martyrs (MM/DD/YYYY): " + findDateWithMaxMartyrs(current)
					+ "\n");

		}
	}

	// Method that finds the date with max number of martyrs
	public String findDateWithMaxMartyrs(DistrictNode targetNode) {
		String maxDate = null;
		int maxCount = 0;

		if (targetNode != null) {
			LocationLinkedList locationList = (LocationLinkedList) targetNode.getHead();

			// Iterate through locations within the target district
			LocationNode currentLocation = locationList.getFront();
			while (currentLocation != null) {
				MartyrLinkedList martyrList = currentLocation.getHead();

				// Iterate through martyrs and compare counts
				int currentCount = 0;
				String currentDate = null;
				MartyrNode currentMartyr = martyrList.getFront();
				while (currentMartyr != null) {
					Martyr martyr = (Martyr) currentMartyr.getElement();
					String date = martyr.getDate();

					if (currentDate == null || !date.equals(currentDate)) {
						// New date encountered, reset counters
						currentDate = date;
						currentCount = 1;
					} else {
						currentCount++;
					}
					// Update max values if current count is higher
					if (currentCount > maxCount) {
						maxCount = currentCount;
						maxDate = currentDate;
					}
					currentMartyr = currentMartyr.getNext();
				}

				currentLocation = currentLocation.getNext();
			}
		}

		return maxDate;
	}

	// Method that prints statistics on a file with the district name
	public void writeOnFile(DistrictNode current, Label lbl) {
		// Check if the current district node is not null
		if (current != null) {
			District district = (District) current.getElement();
			String fileName = district.getName().concat(".txt"); // Construct the file name with the district name
			try (PrintWriter writer = new PrintWriter(new File(fileName))) {
				// Write district information to the file
				writer.println("District: " + district.getName());

				// Iterate over locations within the district
				LocationLinkedList locationList = (LocationLinkedList) current.getHead();
				int totalMartyr = 0;
				int totalMale = 0;
				int totalFemale = 0;
				double average = 0;

				LocationNode currentLocation = locationList.getFront();
				while (currentLocation != null) {
					// Calculate total martyrs, male, female, and average age
					MartyrLinkedList martyrList = (MartyrLinkedList) currentLocation.getHead();
					totalMartyr += martyrList.getSize();
					totalMale += martyrList.getMartyrTotalMale();
					totalFemale += martyrList.getMartyrTotalFemale();
					average += martyrList.getMartyrAgeAvg();
					currentLocation = currentLocation.getNext();
				}

				// Calculate average age of martyrs
				if (totalMartyr > 0) {
					average /= totalMartyr;
				} else {
					average = 0.0;
				}

				// Format average age to two decimal places
				String formattedAverage = String.format("%.2f", average);

				// Write statistics to the file
				writer.println("\nTotal martyrs: " + totalMartyr);
				writer.println("Total male martyrs: " + totalMale);
				writer.println("Total female martyrs: " + totalFemale);
				writer.println("Total martyrs age average: " + formattedAverage);
				writer.println(
						"The date with maximum number of martyrs (MM/DD/YYYY): " + findDateWithMaxMartyrs(current));
				lbl.setText("District Information has been uploaded to the file!");
			} catch (IOException e) {
				// Handle any file writing errors appropriately
				lbl.setText("Error writing to file: " + e.getMessage());
			}
		}
	}

	public void showStatistics() {
		DistrictNode current = Front;
		while (current != null) {
			District district = (District) current.getElement();
			System.out.println("District: " + district.getName());

			LocationLinkedList locationList = (LocationLinkedList) current.getHead();

			int totalMartyr = 0;
			int totalMale = 0;
			int totalFemale = 0;
			double average = 0;

			// Iterate over the locations within the district
			LocationNode currentLocation = locationList.getFront();
			while (currentLocation != null) {
				MartyrLinkedList martyrList = (MartyrLinkedList) currentLocation.getHead();
				totalMartyr += martyrList.getSize();
				totalMale += martyrList.getMartyrTotalMale();
				totalFemale += martyrList.getMartyrTotalFemale();
				average += martyrList.getMartyrAgeAvg();

				// Move to the next location
				currentLocation = currentLocation.getNext();
			}

			System.out.println("Total martyrs: " + totalMartyr + "\nTotal male martyrs: " + totalMale
					+ "\nTotal female martyrs: " + totalFemale + "\nTotal martyrs age average: "
					+ (totalMartyr > 0 ? average / totalMartyr : 0.0)
					+ "\nThe date that has the maximum number of martyrs: " + findDateWithMaxMartyrs(current) + "\n"); 
			current = current.getNext(); // Move to the next district
		}
	}

	// Method that search for a location by name
	public LocationNode findLocation(String name) {
		DistrictNode currentDistrict = Front;

		// Iterate over each district in the district list
		while (currentDistrict != null) {
			LocationLinkedList district = (LocationLinkedList) currentDistrict.getHead();
			LocationNode currentLocation = district.getFront();

			// Search for the location within the current district
			while (currentLocation != null) {
				Location location = (Location) currentLocation.getElement();
				if (location.getName().equalsIgnoreCase(name)) {
					// Location found, return the node containing it
					return currentLocation;
				}
				currentLocation = currentLocation.getNext();
			}

			// Move to the next district
			currentDistrict = currentDistrict.getNext();
		}

		// Location not found in any district
		return null;
	}

	public DistrictNode findLocationsDistrict(String name) {
		DistrictNode currentDistrict = Front;

		// Iterate over each district in the district list
		while (currentDistrict != null) {
			LocationLinkedList district = (LocationLinkedList) currentDistrict.getHead();
			LocationNode currentLocation = district.getFront();

			// Search for the location within the current district
			while (currentLocation != null) {
				Location location = (Location) currentLocation.getElement();
				if (location.getName().equalsIgnoreCase(name)) {
					// Location found, return the node containing it
					return currentDistrict;
				}
				currentLocation = currentLocation.getNext();
			}

			// Move to the next district
			currentDistrict = currentDistrict.getNext();
		}

		// Location not found in any district
		return null;
	}

	// Method that returns the number of martyrs with a certain date
	public int displayNumberDate(String date) {
		int countMart = 0;

		DistrictNode currentDistrict = Front;

		// Iterate over each district in the district list
		while (currentDistrict != null) {
			LocationNode currentLocation = currentDistrict.getHead().getFront();

			// Iterate over each location within the current district
			while (currentLocation != null) {
				MartyrNode currentMartyr = currentLocation.getHead().getFront();

				// Iterate over each martyr within the current location
				while (currentMartyr != null) {
					Martyr martyr = (Martyr) currentMartyr.getElement();
					if (martyr.getDate().equals(date)) {
						// Found a martyr with the same date of death
						countMart++;
					}
					currentMartyr = currentMartyr.getNext();
				}

				// Move to the next location within the current district
				currentLocation = currentLocation.getNext();
			}

			// Move to the next district
			currentDistrict = currentDistrict.getNext();
		}

		return countMart;
	}

	// Method that searches for martyrs by part of the name
	public void searchMartyrByName(String district, String location, String name, TextArea txtArea, Label lbl) {
		// Check if the district name is provided
		if (district.isEmpty()) {
			lbl.setVisible(true);
			txtArea.setVisible(false);
			lbl.setText("Enter a district name first!");
			return;
		} else if (location.isEmpty()) {
			// Check if the location name is provided
			lbl.setVisible(true);
			txtArea.setVisible(false);
			lbl.setText("Enter a location name!");
			return;
		}

		// Find the specified district node
		DistrictNode districtNode = findNode(new District(district));
		if (districtNode == null) {
			// Handle the case when the district is not found
			lbl.setVisible(true);
			txtArea.setVisible(false);
			lbl.setText("The district is wrong!");
			return;
		}

		// Get the location list of the specified district
		LocationLinkedList locationList = districtNode.getHead();

		// Find the specified location node
		LocationNode locationNode = locationList.findNode(new Location(location));
		if (locationNode == null) {
			// Handle the case when the location is not found
			lbl.setVisible(true);
			txtArea.setVisible(false);
			lbl.setText("The location is wrong!");
			return;
		}

		// Get the martyr list of the specified location
		MartyrLinkedList martyrList = locationNode.getHead();

		// Search for martyrs by part of the name within the specified location
		martyrList.searchMartyr(name, txtArea, lbl);
	}

	// Method that check the existence of a martyr
	public boolean searchMartyr(Martyr newMart, Label lbl) {
		DistrictNode currentDistrict = Front;
		while (currentDistrict != null) {
			// Iterates locations
			LocationLinkedList locationList = (LocationLinkedList) currentDistrict.getHead();
			LocationNode currentLocation = locationList.getFront();
			while (currentLocation != null) {
				// Iterates martyrs
				MartyrLinkedList martyrList = (MartyrLinkedList) currentLocation.getHead();
				MartyrNode currentMartyr = martyrList.getFront();
				while (currentMartyr != null) {
					Martyr m = (Martyr) currentMartyr.getElement();
					Martyr m1 = newMart;
					if (m.getName().equalsIgnoreCase(m1.getName()) && m.getDate().equalsIgnoreCase(m1.getDate())
							&& m.getGender() == (m1.getGender()) && m.getAge() == (m1.getAge())) {
						if (!m.getName().equals("Name unknown to B'Tselem")) {
							// If the martyr exist
							lbl.setText("This martyr exist in this or different location");
							return true;
						}
					}

					currentMartyr = currentMartyr.getNext();
				}

				currentLocation = currentLocation.getNext();
			}

			currentDistrict = currentDistrict.getNext();
		}

		return false;
	}

	// Method that write the martyrs info on the required textFileds
	public void returnMartyr(MartyrLinkedList martyrList, String name, TextField txtMartName, TextField txtMartDate,
			TextField txtMartAge, TextField txtMartLoc, TextField txtMartDis, RadioButton rbMale, RadioButton rbFemale,
			RadioButton rbUnknown) {
		// returns the target martyr by name
		Martyr mart = (Martyr) martyrList.get(martyrList.findByName(name));
		if (mart != null) {
			// Write the martyr's info on the target textFileds
			txtMartName.setText(mart.getName());

			// If the age of the martyr was -1 that means that it's empty
			if (mart.getAge() == -1)
				txtMartAge.setText("");
			else
				txtMartAge.setText(mart.getAge() + "");

			txtMartDate.setText(mart.getDate());
			txtMartLoc.setText(mart.getLocation());
			txtMartDis.setText(mart.getDistrict());

			// set the radioButtons according to the gender
			if (mart.getGender() == 'M' || mart.getGender() == 'm') {
				rbMale.setSelected(true);
			} else if (mart.getGender() == 'F' || mart.getGender() == 'f') {
				rbFemale.setSelected(true);
			} else if (mart.getGender() == 'N' || mart.getGender() == 'n')
				rbUnknown.setSelected(true);
		}

	}

	// Method that prints the elements inside the list
	public void print() {
		DistrictNode current = Front;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	// Method that prints the elements inside the list from certain node
	public void print(DistrictNode current) {
		if (current != null) {
			System.out.println(current.getElement());
			print(current.getNext());
		}
	}

}
