package ARS.Control;


import java.util.Scanner;
import ARS.Model.DBFunctionalities;
import ARS.Model.DataBase;

public abstract class HomePage{
	
// Display Flight details and login/sign_up options 	
	public void homepage() {
		Scanner input = new Scanner(System.in);
		DataBase obj = new DBFunctionalities();
		obj.flightnames();
		
		System.out.println();
		
		System.out.println("Enter 1 for login and 2 for signup");
		long option = input.nextInt();
		
		if(option == 1) {
			LoginPage loginobj = new LoginPage();
			loginobj.login();
		}
			
		else if(option == 2) {
			SignupPage signupobj = new SignupPage();
			signupobj.signup();
		}
			
		else {
			System.out.println("invalid option, type again: ");
			homepage();
		}
			
//		
		input.close();
		
	}
	
	
	abstract void login();
	abstract void signup();
	
//  Instantiating Validation class
	RegexVerification validation = new RegexVerification();

}

