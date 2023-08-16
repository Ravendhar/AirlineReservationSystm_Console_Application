package ARS.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public abstract class DataBase {
	
	Map<String, List<String>> FlightNames = new LinkedHashMap<>();
	List<String> lufthansa = new ArrayList<>();
	List<String> boeing  = new ArrayList<>();
	List<String> airbus = new ArrayList<>();
	
	protected String lufthansa_file_path;
	protected String boeing_file_path;
	protected String airbus_file_path;
		
		
	
// default database for every viewers	 
	public DataBase() {
	        FlightNames.put("Lufthansa (from salem to chennai)", lufthansa);
	        FlightNames.put("Boeing (from chennai to coimbatore)", boeing);
	        FlightNames.put("Airbus (from coimbatore to salem)", airbus);
	}
	
	
	public abstract void addinlist();
	
	public abstract void removeinlist();
	
	public abstract void displaylist();
	
	public abstract void flightnames();
	
	public abstract void addinfile();
	
	public abstract void removeinfile();
	
	public abstract void displayfile();
	
	public abstract void properties();
	

}
