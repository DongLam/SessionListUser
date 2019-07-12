package Model;

import java.util.List;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String intro;
	private String gender;
	private List<String> hobby;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public Customer() {
		// Do Nothing
	}

	public Customer(String firstName, String lastName, String email, String intro, String gender, List<String> hobby) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.intro = intro;
		this.hobby = hobby;
		this.gender = gender;
	}


	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
}
