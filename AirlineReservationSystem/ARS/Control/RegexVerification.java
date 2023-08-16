package ARS.Control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ARS.Model.DBFunctionalities;
import ARS.Model.DataBase;

public class RegexVerification {
	
// password and user_name validation 
	public void loginValidation(String username, String password) {	
		
		Scanner input = new Scanner(System.in);
		
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"
                     + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(password);
		if(match.matches()) {
			 System.out.println("valid password ");
			 System.out.println();
			 adminValidation(username,password);
			 
		}
		else {
			System.out.println("password invalid");
		}
		
		input.close();
	}
	
// email validation
	public void signupValidation(String email) {
		String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(email);
		if(match.matches()) {
			 System.out.println("valid email");
		}
		else {
			System.out.println("email invalid");
		}
	}

// validation for admin login
	public void adminValidation(String username, String password) {
		
		Scanner input = new Scanner(System.in);
		String[] str = {username, password};
		String line;
		int count=0;
		
		try {
			 BufferedReader reader = new BufferedReader(new FileReader("E:\\\\Eclipse IDE webdev\\\\Reacll\\\\fileconcepts\\\\SampleFile.txt"));
	 		 while((line = reader.readLine())!= null) {
	 			for(String temp : str) {
	 				if(line.equals(temp)) {
	 					count++;
	 				}
	 			}
	 		 }
	 		 reader.close();
		 } catch(Exception exception) {
			 exception.printStackTrace();
		 }
		 
		 if(count==2) {
			 
			 System.out.println("Loged in as admin\n");
			 
			 DataBase dbobj = new DBFunctionalities();
			 
			 System.out.println("1.add data in list \n2.add data in file \n3.remove data in list \n4.remove data in file");
			 long option = input.nextInt();
			 
			 if(option == 1) {
				 dbobj.addinlist();
			 }	
			 else if(option == 2) {
				 dbobj.addinfile();
			 }	
			 else if(option == 3) {
				 dbobj.removeinlist();
			 }
			 else if(option == 4) {
				 dbobj.removeinfile();
			 }
			 else
				 System.out.println("Invalid option");
			 	 
		 }
		 else {
			 System.out.println("login invalid/n Signup first");
			 SignupPage obj = new SignupPage();
			 obj.signup();
		 }
		 
	input.close();
	}
}

