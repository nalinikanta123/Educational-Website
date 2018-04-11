package project.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import project.Models.*;

@Service
public class UserService {

	private static ArrayList<User> listOfUsers = new ArrayList<>();
	public static User loggedInUser;

	public static ArrayList<User> getAllUsers() {
		return listOfUsers;
	}

	public static void addUser(User U) {
		listOfUsers.add(U);
	}

	public static User getUser(int id) {
		for (int i = 0; i < listOfUsers.size(); i++) {
			User ith_user = listOfUsers.get(i);
			if (ith_user.getAccount().getUserID() == id) {
				return ith_user;
			}
		}
		return null;
	}

	public static void editUser(User user) {
		int target_id = user.getAccount().getUserID();
		for (int i = 0; i < listOfUsers.size(); i++) {
			User ith_user = listOfUsers.get(i);
			if (ith_user.getAccount().getUserID() == target_id) {
				listOfUsers.remove(ith_user);
				break;
			}
		}
		listOfUsers.add(user);
	}

	public static boolean checkValidLogin(String name, String pass) {

		for (int i = 0; i < listOfUsers.size(); i++) {
			Account ith_account = listOfUsers.get(i).getAccount();

			if (ith_account.getUserName().equals(name) && ith_account.getPassword().equals(pass)) {
				loggedInUser = listOfUsers.get(i);
				return true;
			}
		}

		return false;
	}

	// this function was also do (loggedInUser = U;) if returns true
	// TODO loggedInUser = U; in separate function
	public static boolean checkExistingEmail(String email) {

		for (int i = 0; i < listOfUsers.size(); i++) {
			User ith_user = listOfUsers.get(i);

			if (ith_user.getAccount().getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}
}
