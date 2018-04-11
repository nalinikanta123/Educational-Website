package project.Models;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
	
	private String userName;
	private String password;
	private String email;
	private String gender;
	private String profile;
	private String type;
	private int userID;
	private static AtomicInteger count = new AtomicInteger((int)Math.random());

	public Account(){
		userID = count.incrementAndGet();
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Account(String userName, String password, String email, String gender,String type) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.type = type;
		userID = count.incrementAndGet();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUserName(String name) {
		userName = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    public void setGender(String type) {
		gender = type ;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}


	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", profile=" + profile + ", type=" + type + ", userID=" + userID + "]";
	}



}
