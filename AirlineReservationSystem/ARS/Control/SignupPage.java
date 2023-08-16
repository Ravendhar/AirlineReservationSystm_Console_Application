package ARS.Control;

import java.util.Scanner;

public class SignupPage extends HomePage{
	
	Scanner input = new Scanner(System.in);
	String username; 
	String password;
	String email;
	
	// sign_up method for new users
	public void signup() {
		System.out.println("Enter username, password & email: ");
		username = input.nextLine();
		password = input.nextLine();
		email = input.nextLine();
		validation.signupValidation(email);
		validation.loginValidation(username,password);
	}

	@Override
	public void login() {}

}

