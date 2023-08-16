package ARS.Model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class DBFunctionalities extends DataBase {
	
	//access allowed for user and admin
	public void addinlist() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("1.Lufthansa, 2.Boeing, 3.Airbus");
		System.out.println("Enter the key of your airline: ");
		long key = input.nextInt();
		System.out.println("Enter the number of count: ");
		long count = input.nextInt();
		System.out.println("Enter you're name: ");
		
		for(int i=0; i<count; i++) {
			if(key == 1) {
				String passenger = input.next();
				lufthansa.add(passenger);
				System.out.println("Booking Successful for" + i + "passenger");
				
			}
			else if(key == 2) {
				String passenger = input.next();
				boeing.add(passenger);
				System.out.println("Booking Successful for" + i + "passenger");
				
			}
			else if(key == 3) {
				String passenger = input.next();
				airbus.add(passenger);
				System.out.println("Booking Successful for" + i + "passenger");
				
			}
			else
				System.out.println("invalid option");
		}
		input.close();
		addinfile();
		
	}

	//access allowed for admin only
	public void removeinlist() {
		
			Scanner input = new Scanner(System.in);		
//			System.out.println("Authorized change");
			System.out.println("1.Lufthansa, 2.Boeing, 3.Airbus");
			System.out.println("Enter the key of your airline: ");
			int key = input.nextInt();
			System.out.println("Enter the number of count: ");
			int count = input.nextInt();
			displaylist();
			System.out.println();
			
			for(int i=0; i<count; i++) {
				if(key == 1) {
					System.out.println("Enter the name of passenger you're removing: ");
					String index = input.next();
					lufthansa.remove(index);
					displaylist();
					System.out.println();
					System.out.println("Removed Successfully");
				}
				else if(key == 2) {
					System.out.println("Enter the index of passenger you're removing: ");
					int index = input.nextInt();
					boeing.remove(index);
					displaylist();
					System.out.println();
					System.out.println("Removed Successfully");
				}
				else if(key == 3) {
					System.out.println("Enter the index of passenger you're removing: ");
					int index = input.nextInt();
					airbus.remove(index);
					displaylist();
					System.out.println();
					System.out.println("Removed Successfully");
				}
				else
					System.out.println("invalid option");
			}
		input.close();
		addinfile();
			
	}

	//access allowed for admin only
	public void displaylist() {
		for (Map.Entry<String, List<String>> entry : FlightNames.entrySet()) {
			int count = 0;
            String listName = entry.getKey();
            List<String> innerList = entry.getValue();
            System.out.println(listName + ":");
            for (String element : innerList) {
                System.out.print(element + " ");
                count++;
            }
            System.out.println("\npassenger count: "+count+"\n");			
        }
	}
	 
	//flight names present in list
	public void flightnames() {
		System.out.println("Available flights: ");
		 for (Map.Entry<String, List<String>> entry : FlightNames.entrySet()) {
	            String listName = entry.getKey();
	            System.out.println(listName);
		 }
	}

	//access allowed for admin only / backup database 
	public void addinfile() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1.Lufthansa, 2.Boeing, 3.Airbus");
		System.out.println("Enter the key of your airline: ");
		int key = input.nextInt();
		System.out.println("Enter the number of count: ");
		int count = input.nextInt();
		System.out.println("Enter you're name: ");
		properties();
		
		try {
			BufferedWriter lufthansa_writer = new BufferedWriter(new FileWriter(lufthansa_file_path, true));
			BufferedWriter boeing_writer = new BufferedWriter(new FileWriter(boeing_file_path, true));
			BufferedWriter airbus_writer = new BufferedWriter(new FileWriter(airbus_file_path, true));
			for(int i=0; i<count; i++) {
				int total =1;
				if(key == 1) {
					String passenger = input.next();
					lufthansa.add(passenger);
					lufthansa_writer.write("\n"+lufthansa.get(i));
					total=i+1;
					System.out.println("passenger number " + total + " added in the file database");
				}
				else if(key == 2) {
					String passenger = input.next();
					boeing.add(passenger);
					boeing_writer.write("\n"+boeing.get(i));
					total=i+1;
					System.out.println("passenger number " + total + " added in the file database");
					
				}
				else if(key == 3) {
					String passenger = input.next();
					airbus.add(passenger);
					airbus_writer.write("\n"+boeing.get(i));
					total=i+1;
					System.out.println("passenger number " + total + " added in the file database");
					
				}
				else
					System.out.println("invalid option");
			lufthansa_writer.flush();
			boeing_writer.flush();
			airbus_writer.flush();
			}
			
			lufthansa_writer.close();
			boeing_writer.close();
			airbus_writer.close();
		} catch (Exception exception) {
			exception.printStackTrace();	
		}
		displayfile();
		input.close();
	}

	//access allowed for admin only / backup database
	public void removeinfile() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.Lufthansa, 2.Boeing, 3.Airbus");
		System.out.println("Enter the key of your airline: ");
		int key = input.nextInt();
		String filePath;
		if(key == 1)
			filePath = "E:\\Eclipse IDE webdev\\AirlineReservationSystem\\ARS\\Model\\database\\lufthansa.txt";
		else if(key == 2)
			filePath = "E:\\Eclipse IDE webdev\\AirlineReservationSystem\\ARS\\Model\\database\\boeing.txt";
		else if(key == 3)
			filePath = "E:\\Eclipse IDE webdev\\AirlineReservationSystem\\ARS\\Model\\database\\airbus.txt";
		else {
			System.out.println("invalid key, type again");
			filePath = "E:\\Eclipse IDE webdev\\AirlineReservationSystem\\ARS\\Model\\database\\backup.txt";
			removeinfile();
		}		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
				
				System.out.println("Enter the name to be removed");
	            String lineToRemove = input.nextLine(); // Replace this with the line you want to remove
	            input.nextLine();
	            System.out.println("Enter the line index to be changed");
	            int lineindex = input.nextInt();
	            
	            String currentLine;
	            boolean status = false;
	            int templineindex = 0;
	            while ((currentLine = reader.readLine()) != null) {
	            	templineindex++;
	                if ((!currentLine.trim().equals(lineToRemove)) && (templineindex != lineindex)) {  
	                    writer.write(currentLine);
	                    writer.newLine();
	                    status = true;
	                }
	                
	            }
	            writer.flush();
	            writer.close();
	            reader.close();
	            
	            if(status)
	            	System.out.println("Database changed sussessfully");
	            else 
	            	System.out.println("Unable to change the database");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 	displayfile();
			input.close();
	}

	//access allowed for admin only / backup database	 
	public void displayfile() {
		
		properties();
		
		String[] filepaths = {lufthansa_file_path, boeing_file_path, airbus_file_path};
		for(String filepath:filepaths) {
			File file = new File(filepath);
			if (file.exists() && file.length() > 0) {
				 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                    String line;
	                    System.out.println("File: " + file.getName());
	                    System.out.println("-------------------------");
	                    while ((line = reader.readLine()) != null) {
	                        System.out.println(line);
	                    }
	                    System.out.println();
	                    reader.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
			}
		
		}
		
	}
	
	//property files
	public void properties() {
		Properties properties = new Properties();
		
		String fileName = "config.properties.txt"; // Just the file name

        URL resource = DataBase.class.getResource(fileName);
        if (resource != null) {
        	try(BufferedReader input = new BufferedReader(new FileReader(resource.getFile()))) {
        		
        		properties.load(input);
    			lufthansa_file_path = properties.getProperty("lufthansa_File");
                boeing_file_path = properties.getProperty("boeing_File");
                airbus_file_path = properties.getProperty("airbus_File"); 
        		
        	} catch (Exception exception) {
				exception.printStackTrace();
			} 
		}
     }
		
}
