package model;

public class Student {
	private int id;
	private String firstname;
	private String lastname;
	private String streetAddress;
	private String postCode;
	private String postOffice;

	public Student() {
		id = -1;
		firstname = "";
		lastname = "";
		streetAddress = "";
		postCode = "";
		postOffice = "";
	}

	public Student(int id, String firstname, String lastname, String streetAddress, String postCode, String postOffice) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.streetAddress = streetAddress;
		this.postCode = postCode;
		this.postOffice = postOffice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String name) {
		this.firstname = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostOffice() {
		return postOffice;
	}

	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String toString() {
		return "Student [id=" + id + ", first name= " + firstname + ", last name= " + lastname + ", street address=" + streetAddress + ", postcode = " + postCode + ", post office = " + postOffice +"]";
	}
}
