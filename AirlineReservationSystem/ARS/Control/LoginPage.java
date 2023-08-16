package ARS.Control;

import java.util.Scanner;

public class LoginPage extends HomePage{
	
	Scanner input = new Scanner(System.in);
	public String username; 
	public String password;
	
	// login method for existing user/admin
	public void login() {
		System.out.println("Enter username & password");
		username = input.nextLine();
		password = input.nextLine();
		validation.loginValidation(username,password);
	}

	@Override
	public void signup() {}
}

