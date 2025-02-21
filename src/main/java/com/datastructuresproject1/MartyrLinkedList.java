package com.datastructuresproject1;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MartyrLinkedList {
	// Attributes of MartyrLinkedList
	private MartyrNode Front, Back;
	private int Size, martyrTotalMale, martyrTotalFemale;
	private double martyrAgeAvg;

	// Default constructor
	public MartyrLinkedList() {
		Front = Back = null;
		Size = 0;
	}

	// Getter method for retrieving the front
	public MartyrNode getFront() {
		return Front;
	}

	// Setter method for setting the front
	public void setFront(MartyrNode front) {
		Front = front;
	}

	// Getter method for retrieving the back
	public MartyrNode getBack() {
		return Back;
	}

	// Setter method for setting the back
	public void setBack(MartyrNode back) {
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

	// Getter method for retrieving the martyrTotalMale counter
	public int getMartyrTotalMale() {
		return martyrTotalMale;
	}

	// Setter method for setting the martyrTotalMale counter
	public void setMartyrTotalMale(int martyrTotalMale) {
		this.martyrTotalMale = martyrTotalMale;
	}

	// Getter method for retrieving the martyrTotalFemale counter
	public int getMartyrTotalFemale() {
		return martyrTotalFemale;
	}

	// Setter method for setting the martyrTotalFemale counter
	public void setMartyrTotalFemale(int martyrTotalFemale) {
		this.martyrTotalFemale = martyrTotalFemale;
	}

	// Getter method for retrieving the martyrAgeAvg counter
	public double getMartyrAgeAvg() {
		return martyrAgeAvg;
	}

	// Setter method for setting the martyrAgeAvg counter
	public void setMartyrAgeAvg(double martyrAgeAvg) {
		this.martyrAgeAvg = martyrAgeAvg;
	}

	/* Methods go here */
	public void addFirst(Object element) {
		MartyrNode newNode;
		newNode = new MartyrNode(element);
		// Empty List
		if (Size == 0) {
			Front = Back = newNode;
		} else {
			newNode.setNext(Front);
			Front = newNode;
		}
		// update Size
		Size++;
	}

	// Method that retrieves the first element in the list
	public Object getFirst() {
		// Empty List
		if (Size == 0)
			return null;
		else
			return Front.getElement();
	}

	// Method that add element to the end of the list
	public void addLast(Object element) {
		MartyrNode newNode;
		newNode = new MartyrNode(element);
		// Empty List
		if (Size == 0) {
			Front = Back = newNode;
		} else {
			Back.setNext(newNode);
			Back = newNode; // Or Back=Back.next;
		}
		// update Size
		Size++;
	}

	// Method that retrieves the last element in the list
	public Object getLast() {
		if (Size == 0)
			return null;
		else
			return Back.getElement();
	}

	// Method that retrieves an element from a specific index in the list
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
		// If the index was neither the first nor the last
		else if (index > 0 && index < Size - 1) {
			MartyrNode current = Front;
			// Iterates over the element in the list
			for (int i = 0; i < index; i++)
				current = current.getNext();
			return current.getElement();
		}
		// out of boundary
		else
			return null;
	}

	// Getter method that retrieves the size
	public int size() {
		return Size;
	}

	// Method that add an element to a specific index in the list
	public void add(int index, Object element) {
		// If the list was empty, the element will be added as the first
		if (index == 0)
			addFirst(element);
		// If the list was full
		else if (index >= size())
			addLast(element);
		// If the list has elements
		else {
			MartyrNode newNode = new MartyrNode(element);
			// used to advance to proper position
			MartyrNode current = Front;
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
		// more than one element in the list
		else {
			MartyrNode current = Front;
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
			MartyrNode current = Front;
			for (int i = 0; i < index - 1; i++)
				current = current.getNext();
			current.setNext(current.getNext().getNext());
			Size--;
			return true;
		}
		// out of boundary(invalid index)
		else
			return false;
	}

	// Clear the list by removing all elements
	public void clear() {
		Front = null;
		Size = 0;
	}

	// Find the index of the first occurrence of the specified element
	public int find(Object element) {
		MartyrNode current = Front;
		int index = 0;

		// If the element was a Martyr
		if (element instanceof Martyr) {
			while (current != null) {
				Martyr m = ((Martyr) current.getElement());
				Martyr m1 = (Martyr) element;
				// If the martyr's name is same as the martyr in the list, the index will be
				// returned
				if (m.getName().equalsIgnoreCase(m1.getName()) && m.getDate().equalsIgnoreCase(m1.getDate())
						&& m.getLocation().equalsIgnoreCase(m1.getLocation())
						&& m.getDistrict().equalsIgnoreCase(m1.getDistrict()) && m.getGender() == (m1.getGender())
						&& m.getAge() == (m1.getAge())) {
					return index;
				}
				current = current.getNext();
				index++;
			}
			return -1; // Element not found
		}
		return -1;
	}

	// Find the index of the first occurrence of the specified element
	public int findInsert(Object element) {
		MartyrNode current = Front;
		int index = 0;

		// If the element was a Martyr
		if (element instanceof Martyr) {
			while (current != null) {
				Martyr m = ((Martyr) current.getElement());
				Martyr m1 = (Martyr) element;
				// If the martyr's name is same as the martyr in the list except if it was a
				// "Name unknown to B'Tselem", the index will be returned
				if (m.getName().equalsIgnoreCase(m1.getName()) && m.getDate().equalsIgnoreCase(m1.getDate())
						&& m.getLocation().equalsIgnoreCase(m1.getLocation())
						&& m.getDistrict().equalsIgnoreCase(m1.getDistrict()) && m.getGender() == (m1.getGender())
						&& m.getAge() == (m1.getAge())) {
					if (!m.getName().equals("Name unknown to B'Tselem"))
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

	// Find the index of the first occurrence of the specified element
	public int findByName(String name) {
		MartyrNode current = Front;
		int index = 0;
		while (current != null) {
			Martyr m = ((Martyr) current.getElement());
			// If the martyr's name is same as the martyr in the list, the index will be
			// returned
			if (m.getName().equalsIgnoreCase(name)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		// Element not found
		return -1;
	}

	// Find the index of the first occurrence of the specified element
	public int findByNameAndDate(String name, String date) {
		MartyrNode current = Front;
		int index = 0;
		while (current != null) {
			Martyr m = ((Martyr) current.getElement());
			// If the martyr's name and date is same as the martyr in the list, the index
			// will be returned
			if (m.getName().trim().equalsIgnoreCase(name.trim()) && m.getDate().trim().equals(date.trim())) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		// Element not found
		return -1;
	}

	public void insertMartyrSorted(MartyrNode newNode, TextArea txtArea, Label lbl) {
		// Check if the martyr already exists
		if (findInsert(newNode.getElement()) != -1) {
			// Martyr already exists, do not insert
			txtArea.appendText(((Martyr) newNode.getElement()).getName() + " does exist from before!\n");
			lbl.setText(((Martyr) newNode.getElement()).getName() + " does exist from before!\n");
			return;
		}

		// Check if the martyr is male or female and increment the counters
		if (((Martyr) newNode.getElement()).getGender() == 'M' || ((Martyr) newNode.getElement()).getGender() == 'm') {
			martyrTotalMale++;
			if (((Martyr) newNode.getElement()).getAge() < 0)
				martyrAgeAvg += 0;
			else
				martyrAgeAvg += ((Martyr) newNode.getElement()).getAge();
		} else if (((Martyr) newNode.getElement()).getGender() == 'F'
				|| ((Martyr) newNode.getElement()).getGender() == 'f') {
			martyrTotalFemale++;

			if (((Martyr) newNode.getElement()).getAge() < 0)
				martyrAgeAvg += 0;
			else
				martyrAgeAvg += ((Martyr) newNode.getElement()).getAge();
		}

		// Insert the martyr sorted by age
		if (Front == null || ((Martyr) Front.getElement()).getAge() >= ((Martyr) newNode.getElement()).getAge()) {
			newNode.setNext(Front);
			Front = newNode;
			lbl.setText(((Martyr) newNode.getElement()).getName() + " has been inserted successfully!\n");
		}
		// If the list wasn't empty
		else {
			MartyrNode current = Front;
			// If the martyr's age is greater than the next martyr, it will insert it after
			// the next
			while (current.getNext() != null
					&& ((Martyr) current.getNext().getElement()).getAge() < ((Martyr) newNode.getElement()).getAge()) {
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			lbl.setText(((Martyr) newNode.getElement()).getName() + " has been inserted successfully!\n");
		}
		// Update the Back reference if newNode is the last node
		if (newNode.getNext() == null) {
			Back = newNode;
		}
		// Increment the size of the list
		Size++;
	}

	// Method that updates a martyr
	public void updateMartyr(String name, Martyr newMartyr, TextArea txtArea, Label lbl) {
		lbl.setVisible(true);
		// Search for the martyr by name
		int index = findByName(name);

		if (index != -1) {
			// Remove the old martyr record
			remove(index);

			// Insert the updated martyr record sorted
			insertMartyrSorted(new MartyrNode(newMartyr), txtArea, lbl);
			lbl.setText("Martyr record updated successfully.");
		} else {
			lbl.setText("Martyr with name " + name + " not found. No updates were made.");
		}
	}

	// Method that returns the node that contains the target martyr
	public MartyrNode findNode(Object element) {
		MartyrNode current = Front;
		// If the element is a martyr
		if (element instanceof Martyr) {
			while (current != null) {
				Martyr m = ((Martyr) current.getElement());
				Martyr m1 = (Martyr) element;
				// If the martyr's info is same as the target martyr, it will return the node
				if (m.getName().equalsIgnoreCase(m1.getName()) && m.getDate().equalsIgnoreCase(m1.getDate())
						&& m.getLocation().equalsIgnoreCase(m1.getLocation())
						&& m.getDistrict().equalsIgnoreCase(m1.getDistrict()) && m.getGender() == (m1.getGender())
						&& m.getAge() == (m1.getAge())) {
					return current;
				}
				current = current.getNext();
			}
			// Element not found
			return null;
		}
		// Node with the wanted name was not found
		return null;
	}

	// Method that searches for a martyr
	public void searchMartyr(String name, TextArea txtArea, Label lbl) {
		MartyrNode current = Front;
		boolean found = false;
		lbl.setVisible(false);
		txtArea.setText("");
		lbl.setText("");

		while (current != null) {
			// Assuming each node contains an element representing a martyr
			Martyr m = (Martyr) current.getElement();
			if ((m).getName().toLowerCase().contains(name.toLowerCase())) {
				txtArea.setVisible(true);
				// Found the node with the matching name
				String gender = "";
				if (m.getGender() == 'M' || m.getGender() == 'm') {
					gender = "Male";
				} else if (m.getGender() == 'F' || m.getGender() == 'f') {
					gender = "Female";
				} else if (m.getGender() == 'N') {
					gender = "Unknown";
				}

				// If the martyr's age was -1 that means that it's empty
				String age = "";
				if (m.getAge() == -1) {
					age = "NA";
					txtArea.appendText("Name: " + (m).getName() + "\n" + "Date of Death : " + m.getDate() + "\n"
							+ "Age : " + age + "\n" + "Location : " + m.getLocation() + "\n" + "District : "
							+ m.getDistrict() + "\n" + "Gender : " + gender + "\n\n");
				} else {
					txtArea.appendText("Name: " + (m).getName() + "\n" + "Date of Death : " + m.getDate() + "\n"
							+ "Age : " + m.getAge() + "\n" + "Location : " + m.getLocation() + "\n" + "District : "
							+ m.getDistrict() + "\n" + "Gender : " + gender + "\n\n");
				}
				found = true;
			}
			current = current.getNext();
		}

		// Print message only if no matching node was found
		if (!found) {
			lbl.setVisible(true);
			txtArea.setVisible(false);
			// Node with the target name wasn't found
			lbl.setText("No names were found!");
		}
	}

	// Method that checks the number of existence martyrs
	public int check(String name, TextArea txtArea, Label lblActionDelete) {
		String gender;
		String age;
		int k = 0;

		MartyrNode current = Front;

		// If the list wasn't empty
		while (current != null) {
			Martyr martyr = (Martyr) current.getElement();

			// If the martyr's name contain the name of the target name, the counter was be
			// incremented
			if (martyr.getName().trim().equalsIgnoreCase(name.trim())) {
				k++;

				// If the number was more than one martyr, it will show the textArea and print
				// on it all the martyrs with that name
				if (k > 1) {
					// Organizing the nodes
					lblActionDelete.setVisible(true);
					lblActionDelete.setText("Please enter the date of death of the martyr that you want to delete!");
					txtArea.setVisible(true);
				}

				// Display the details of the martyr
				if (martyr.getGender() == 'M' || martyr.getGender() == 'm') {
					gender = "Male";
				} else if (martyr.getGender() == 'F' || martyr.getGender() == 'f') {
					gender = "Female";
				} else {
					gender = "NA";
				}

				// If the age was unavailable it will print it as NA
				if (martyr.getAge() < 0) {
					age = "NA";
				} else {
					age = String.valueOf(martyr.getAge());
				}

				txtArea.appendText("Name: " + martyr.getName() + "\nDate Of Death: " + martyr.getDate() + "\nAge: "
						+ age + "\nLocation: " + martyr.getLocation() + "\nDistrict: " + martyr.getDistrict()
						+ "\nGender: " + gender + "\n\n");
			}
			current = current.getNext();
		}
		// The number of martyrs with the same name will be returned
		return k;
	}

	// Method that inform the user that the martyr wanted to be deleted doesn't
	// exist
	public void deleteMartyr0(String name, Label lbl) {
		lbl.setText("Error! Can't delete this martyr: " + name + " because s/he doesn't exist.");

	}

	// Method that deletes a martyr from the list by name
	public void deleteMartyr1(String name, Label lbl) {
		if (remove(findByName(name)))
			lbl.setText(name + " has been deleted!");
		else
			lbl.setText(name + " has not been deleted!");
	}

	// Method that deletes a martyr from the list by name and date
	public void deleteMartyrWithDate(String name, String date, Label lbl) {
		if (remove(findByNameAndDate(name, date)))
			lbl.setText(name + " has been deleted!");
		else
			lbl.setText(name + " hasn't been deleted!");
	}

	// Method that prints the martyrs within the list
	public void print() {
		MartyrNode current = Front;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	// Method that prints the martyrs within a list
	public void print(MartyrNode current) {
		if (current != null) {
			System.out.println(current.getElement());
			print(current.getNext());
		}
	}
}
