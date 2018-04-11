package project.Models;

public class UserFactory {

	public static User getUser(String userType) {

		if (userType.equals(Student.className))
			return new Student();
		else if (userType.equals(Teacher.className))
			return new Student();

		return null;
	}

}
