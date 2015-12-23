package info.devfiles.community.entities;

import info.devfiles.passport.entities.User;

public class Profile extends User {
	
	private String firstName;
	
	private String lastName;

	private String nickname;
	
	private Boolean showRealName;
	
	private String professionalHeadline;
	
	private String country;
	
	public Profile(String email, String password) {
		super(email, password);
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getShowRealName() {
		return showRealName;
	}

	public void setShowRealName(Boolean showRealName) {
		this.showRealName = showRealName;
	}

	public String getProfessionalHeadline() {
		return professionalHeadline;
	}

	public void setProfessionalHeadline(String professionalHeadline) {
		this.professionalHeadline = professionalHeadline;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
