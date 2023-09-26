 
package TaxCalculationApp;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

class Property {
	private double baseValueOfLand;
	private char isInCity;
	private int ageOfProperty;
	private double propertyTax;
	private int id;
	private int builduparea;
	private double tax;

	
	public Property(int id, int builduparea, double baseValueOfLand, int ageOfProperty, char isInCity, double tax) {
		this.baseValueOfLand = baseValueOfLand;
		this.isInCity = isInCity;
		this.ageOfProperty = ageOfProperty;
		this.id = id;
		this.builduparea = builduparea;
		this.tax = tax;
		this.calculatePropertyTax();
	}



	public int getBuilduparea() {
		return builduparea;
	}



	public double getTax() {
		return tax;
	}



	public int getId() {
		return id;
	}



	public double getBaseValueOfLand() {
		return baseValueOfLand;
	}

	public char getIsInCity() {
		return isInCity;
	}

	public int getAgeOfProperty() {
		return ageOfProperty;
	}

	public double getPropertyTax() {
		return propertyTax;
	}

	public Property() {
		// Default Constructor
	}

	void calculatePropertyTax() {
		double ageFactor;
		if (isInCity == 'Y') {
			ageFactor = 1.5; // Age factor for properties in the city
		} else {
			ageFactor = 1.0; // Age factor for properties outside the city
		}

		if (isInCity == 'Y') {
			propertyTax = (builduparea * ageFactor * baseValueOfLand) + (0.5 * builduparea);
		} else {
			propertyTax = builduparea * ageFactor * baseValueOfLand;
		}
	}

}

class Vehicle {
	int RegNum;
	String brand;
	int maxvelocity;
	int noOfSeats;
	String vehicleType;
	float cost;
	float tax;

	
	public Vehicle(int RegNum, String brand, int maxvelocity, int noOfSeats, String vehicleType, float cost, float tax) {
		this.RegNum = RegNum;
		this.brand = brand;
		this.maxvelocity = maxvelocity;
		this.noOfSeats = noOfSeats;
		this.vehicleType = vehicleType;
		this.cost = cost;
		this.tax = tax;
	}

	public int getRegNum() {
		return RegNum;
	}

	public String getBrand() {
		return brand;
	}

	public int getMaxvelocity() {
		return maxvelocity;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public float getCost() {
		return cost;
	}

	public float getTax() {
		return tax;
	}



	public Vehicle() {

	}

	void calculateVehicleTax() {
		switch (vehicleType) {
		case "PETROL":
			tax = (float) (maxvelocity + noOfSeats + (0.10 * cost));
			break;
		case "DIESEL":
			tax = (float) (maxvelocity + noOfSeats + (0.11 * cost));
			break;
		case "CNG/LPG":
			tax = (float) (maxvelocity + noOfSeats + (0.12 * cost));
			break;
		default:
			System.out.println("Invalid vehicle type");
		}
	}

}
class TaxEntry {
	private String particular;
	private int quantity;
	private double tax;

	public TaxEntry(String particular, int quantity, double tax) {
		this.particular = particular;
		this.quantity = quantity;
		this.tax = tax;
	}

	public String getParticular() {
		return particular;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTax() {
		return tax;
	}
}

class PropertyOperations {
	
	static List<Property> propertyList = new ArrayList<>();

	public PropertyOperations() {
		Property property1 = new Property(1, 200, 15000, 3, 'N', 18000000);
		Property property2 = new Property(2, 10, 5000, 1, 'Y', 0);
		Property property3 = new Property(3, 20, 5000, 3, 'N', 0);
		Property property4 = new Property(4, 30, 25000, 2, 'Y', 300003);
		Property property5 = new Property(5, 25, 15000, 2, 'Y', 0);

		propertyList.add(property1);
		propertyList.add(property2);
		propertyList.add(property3);
		propertyList.add(property4);
		propertyList.add(property5);
	}
	
		public void addPropertyDetails1() {
		    Scanner scanner = new Scanner(System.in);

		    try {
		        System.out.print("ENTER THE BASE VALUE OF LAND - ");
		        double baseValueOfLand = Double.parseDouble(scanner.nextLine());
		        if (baseValueOfLand < 5000) {
		            throw new IllegalArgumentException("Base value of land should be greater than or equal to 5000.");
		        }

		        System.out.print("ENTER THE BUILT-UP AREA OF LAND - ");
		        int builtUpArea = Integer.parseInt(scanner.nextLine());
		        if (builtUpArea < 20) {
		            throw new IllegalArgumentException("Built-up area should be greater than or equal to 20.");
		        }

		        System.out.print("ENTER THE AGE OF LAND IN YEARS - ");
		        int ageOfProperty = Integer.parseInt(scanner.nextLine());
		        if (ageOfProperty < 1) {
		            throw new IllegalArgumentException("Age of property should be greater than or equal to 1.");
		        }

		        System.out.print("IS THE LAND LOCATED IN CITY? (Yes: y or Y/ No: n or N) ");
		        String isInCityInput = scanner.nextLine();
		        char isInCity = isInCityInput.charAt(0);

		        if (!isInCityInput.equals("y") && !isInCityInput.equals("Y") && !isInCityInput.equals("N") && !isInCityInput.equals("n")) {
		            throw new IllegalArgumentException("Invalid input for 'isInCity.' Please use 'y' or 'Y' for Yes or 'n' or 'N' for No.");
		        }
		        
		        System.out.print("ENTER TAX - ");
		        double tax = Double.parseDouble(scanner.nextLine());

		        if (tax < 500) {
		            throw new IllegalArgumentException("tax must be grater than 500.");
		        }

		        Property property = new Property(propertyList.size() + 1, builtUpArea, baseValueOfLand, ageOfProperty, isInCity, tax);
		        propertyList.add(property);

		        System.out.println("Property Details Added Successfully!");
		    } catch (NumberFormatException e) {
		        System.out.println("Input must be in a valid number format.");
		    } catch (IllegalArgumentException e) {
		        System.out.println(e.getMessage());
		    }
		}

//		Scanner scanner = new Scanner(System.in);
	

	public void viewPropertyDetails() {
		if (propertyList.isEmpty()) {
			System.out.println("No properties available.");
		} else {
			System.out.println("=======================================================================================");
			System.out.println("BUILT-UP AREA\tID\tBASE PRICE\tAGE (YEARS)\tIN CITY\t\tPROPERTY TAX\t|");
			System.out.println("=======================================================================================");

			for (int i = 0; i < propertyList.size(); i++) {
				Property property = propertyList.get(i);

				System.out.println(property.getBuilduparea() + "\t\t" + property.getId() + "\t" +
						property.getBaseValueOfLand() + "\t\t" + property.getAgeOfProperty() + "\t\t" +
						(property.getIsInCity() == 'Y' ? "Y" : "N") + "\t\t" + property.getPropertyTax()+"\t|");
				System.out.println("====================================================================================");

			}
		}
	}


	public void calculatePropertyTax(Scanner scanner) {

		System.out.println("=====================================================================================");
		System.out.println("BUILT-UP AREA\tID\tBASE PRICE\tAGE (YEARS)\tIN CITY\t\tPROPERTY TAX");
		System.out.println("=====================================================================================");

		for (int i = 0; i < propertyList.size(); i++) {
			Property property = propertyList.get(i);

			System.out.println(property.getBuilduparea() + "\t\t" + property.getId() + "\t" +
					property.getBaseValueOfLand() + "\t\t" + property.getAgeOfProperty() + "\t\t" +
					(property.getIsInCity() == 'Y' ? "Y" : "N") + "\t\t" + property.getPropertyTax());
		}
		System.out.println("enter your id to calculate tax");
		int propertyId=scanner.nextInt();
		for (Property property : propertyList) {
			if (property.getId() == propertyId) {
				property.calculatePropertyTax();
				System.out.println("Property Tax for Property ID " + propertyId + " is " + property.getPropertyTax());
				return;
				
			}
			
		}
		System.out.println("Property with ID " + propertyId + " not found.");
	}


	public void propertytaxmenu(Scanner scanner) {
		System.out.println(" ");
		System.out.println("1. ADD PROPERTY DETAILS");
		System.out.println("2. CALCULATE PROPERTY TAX ");
		System.out.println("3. DISPLAY ALL PROPERTIES");
		System.out.println("4. BACK TO MAIN  MENU");


		System.out.print("ENTER YOUR CHOICE: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		switch (choice) {
		case 1:
			addPropertyDetails1();
			break;
		case 2:
			calculatePropertyTax(scanner);
			break;
		case 3:
			viewPropertyDetails();
			break;
		case 4:
			break;
		default:
			System.out.println("INVALID CHOICE! PLEASE TRY AGAIN.");
			break;
		}
	}

	public static List<TaxEntry> getPropertyTaxSummary() {
		double totalPropertyTax = calculateTotalPropertyTax();
		List<TaxEntry> taxSummaries = new ArrayList<>();
		taxSummaries.add(new TaxEntry("Properties", propertyList.size(), totalPropertyTax));
		return taxSummaries;
	}
	public static double calculateTotalPropertyTax() {
		double totalTax = 0.0;
		for (Property property : propertyList) {
			totalTax += property.getPropertyTax();
		}
		return totalTax;
	}
}

class Vehicleoperations{
	Scanner sc=new Scanner(System.in);
	static List<Vehicle> vehiclelist=new ArrayList<Vehicle>();
	
	public Vehicleoperations() {
		Vehicle vahicle1=new Vehicle(0001, "honda", 150, 2, "PETROL",50000,15152);
		Vehicle vahicle2=new Vehicle(0012, "yamaha", 150, 2, "PETROL",70000,20152);
		Vehicle vahicle3=new Vehicle(1234, "sample", 234, 2, "PETROL",60000,20236);
		Vehicle vahicle4=new Vehicle(1234, "4", 5, 5, "PETROL",61000,00);
		Vehicle vahicle5=new Vehicle(0213, "tvs", 125, 2, "PETROL",60000,00);
		Vehicle vahicle6=new Vehicle(1356, "suzuki", 220, 2, "PETROL",50000,222);
		Vehicle vahicle7=new Vehicle(1236, "suzuki", 300, 2, "PETROL",50000,6302);
		Vehicle vahicle8=new Vehicle(2314, "yamaha", 120, 2, "PETROL",50000,5622);
		Vehicle vahicle9=new Vehicle(0022, "bajaj", 150, 2, "PETROL",50000,8652);



		vehiclelist.add(vahicle1);
		vehiclelist.add(vahicle2);
		vehiclelist.add(vahicle3);
		vehiclelist.add(vahicle4);
		vehiclelist.add(vahicle5);
		vehiclelist.add(vahicle6);
		vehiclelist.add(vahicle7);
		vehiclelist.add(vahicle8);
		vehiclelist.add(vahicle9);

		
	}
	public void addVehicleDetails() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.print("ENTER THE VEHICLE REGISTRATION NUMBER - ");
		    int regNumber = Integer.parseInt(scanner.nextLine());
		    if (regNumber < 1 ) {
		    	throw new IllegalArgumentException("Registration number should be greater than or equal to 1.");
		    }
		  
		        
			System.out.print("ENTER BRAND OF THE VEHICLE - ");
			String brand = scanner.nextLine();
			if (brand == "" ) {
	            throw new IllegalArgumentException("Brand name should not be empty.");
	        }

			System.out.print("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE (KMPH) - ");
			int maxVelocity = Integer.parseInt(scanner.nextLine());
			if (maxVelocity < 120 ) {
	            throw new IllegalArgumentException("maxVelocity of the vehicle should be more than 120.");
			}else if(maxVelocity > 300) {
	            throw new IllegalArgumentException("maxVelocity of the vehicle should be  less than 300.");
	        }

			System.out.print("ENTER CAPACITY (NUMBER OF SEATS) OF THE VEHICLE - ");
	        int noOfSeats = Integer.parseInt(scanner.nextLine());
	    	if (noOfSeats < 2 ) {
	            throw new IllegalArgumentException("noOfSeats of the vehicle should be more than 1.");
			}else if(noOfSeats > 1000000) {
	            throw new IllegalArgumentException("noOfSeats of the vehicle should be  less than 50.");
	        }
	       
	    try {
	    	
		System.out.println("CHOOSE THE TYPE OF THE VEHICLE");
		System.out.println("1. PETROL DRIVEN");		
		System.out.println("2. DIESEL DRIVEN");
		System.out.println("3. CNG/LPG DRIVEN");
		
		
	    } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Vehicle type must be numeric.");
        }
	    
	    int vehicleType = Integer.parseInt(scanner.nextLine());
		String type;
		switch (vehicleType) {
		case 1:
			type = "PETROL";
			break;
		case 2:
			type = "DIESEL";
			break;
		case 3:
			type = "CNG/LPG";
			break;
		default:
			type = "Unknown";
			break;
		}
		

		System.out.print("ENTER THE PURCHASE COST OF THE VEHICLE - ");
		float cost = Float.parseFloat(scanner.nextLine());
		
		if (cost < 50000  ) {
            throw new IllegalArgumentException("cost of the vehicle should be more than 5000.");
		}else if(cost > 1000000) {
            throw new IllegalArgumentException("cost of the vehicle should be less than 1000000.");
        }

		System.out.print("ENTER THE TAX FOR THE VEHICLE - ");
		float tax = Float.parseFloat(scanner.nextLine());
		if (tax < 5000) {
            throw new IllegalArgumentException("tax must be grater than 500.");
        }

		Vehicle vehicle = new Vehicle(regNumber, brand, maxVelocity, noOfSeats, type, tax, cost);
		vehiclelist.add(vehicle);

		System.out.println("Vehicle Details Added Successfully!");
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	    }}



	public void DisplayVehicle() {

		System.out.println("==================================================================================");
		System.out.println("RegNum\tBrand\t\t\tMaxVelocity\tNoOfSeats\tVehicleType\tTax\tCost");
		System.out.println("==================================================================================");

		for (Vehicle allvehicle : vehiclelist) {
			System.out.println(allvehicle.getRegNum() + "\t" + allvehicle.getBrand() + "\t" +
					allvehicle.getMaxvelocity() + "\t" +"\t"+"\t"+ allvehicle.getNoOfSeats() + "\t" +
					allvehicle.getVehicleType() + "\t" +"\t"+ allvehicle.getCost() + "\t\t" + allvehicle.getTax());
		}
	}




	public void calculateVehicleTaxByRegNum1() {
		System.out.println("ENTER THE REGISTRATION NUMBER OF VEHICLE TO CALCULATE THE TAX");
		int regNumber=sc.nextInt();
		for (Vehicle vehicle : vehiclelist) {
			if (vehicle.getRegNum() == regNumber) {
				vehicle.calculateVehicleTax();
				System.out.println("Vehicle Tax for Registration Number " + regNumber + " is " + vehicle.getTax());
				return;
			}
		}
		System.out.println("Vehicle with Registration Number " + regNumber + " not found.");
	}



	public void vehicletaxmenu(Scanner scanner) {
		System.out.println(" ");
		System.out.println("1. ADD VEHICLE DETAILS");
		System.out.println("2. CALCULATE VEHICLE TAX ");
		System.out.println("3. DISPLAY ALL VEHICLE");
		System.out.println("4. BACK TO MAIN  MENU");


		System.out.print("ENTER YOUR CHOICE: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		switch (choice) {
		case 1:
			addVehicleDetails();
			
			break;
		case 2:
			calculateVehicleTaxByRegNum1();
			break;
		case 3:
			DisplayVehicle();
			break;
		case 4:
			break;
		default:
			System.out.println("INVALID CHOICE! PLEASE TRY AGAIN.");
			break;
		}
	}

	public static List<TaxEntry> getVehicleTaxSummary() {
		double totalVehicleTax = calculateTotalVehicleTax();
		List<TaxEntry> taxSummaries = new ArrayList<>();
		taxSummaries.add(new TaxEntry("Vehicles", vehiclelist.size(), totalVehicleTax));
		return taxSummaries;
	}

	public static double calculateTotalVehicleTax() {
		double totalTax = 0.0;
		for (Vehicle vehicle : vehiclelist) {
			vehicle.calculateVehicleTax();
			totalTax += vehicle.getTax();
		}
		return totalTax;
	}
}	

class TaxMain{
	public void calculateTotalTax() {
		List<TaxEntry> propertyTaxSummary = PropertyOperations.getPropertyTaxSummary();
		List<TaxEntry> vehicleTaxSummary = Vehicleoperations.getVehicleTaxSummary();

		double grandTotal = 0.0;
		System.out.println("==============================================");
		System.out.println("SR. NO.\tPARTICULAR\tQUANTITY\tTAX");
		System.out.println("==============================================");

		int srNo = 1;
		for (TaxEntry summary : propertyTaxSummary) {
			grandTotal += summary.getTax();
			System.out.println(srNo++ + "\t" + summary.getParticular() + "\t\t" + summary.getQuantity() + "\t" + summary.getTax());
		}

		for (TaxEntry summary : vehicleTaxSummary) {
			grandTotal += summary.getTax();
			System.out.println(srNo++ + "\t" + summary.getParticular() + "\t\t" + summary.getQuantity() + "\t" + summary.getTax());
		}
		System.out.println("==============================================");
		System.out.println("TOTAL\t\t\t\t\t" + grandTotal);
		System.out.println("==============================================");

	}

}
public class TaxCalculationApp {
	public static void main(String[] args) {
		PropertyOperations propery = new PropertyOperations();
		Vehicleoperations vehicles = new Vehicleoperations();
		TaxMain totaltax=new TaxMain();

		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------");
		System.out.println("WELCOME TO TAX CALCULATION APP");
		System.out.println("-------------------------------");

		System.out.println("PLEASE LOGIN TO CONTINUE");

		System.out.print("USERNAME: ");
		String username = scanner.nextLine();

		System.out.print("PASSWORD: ");
		String password = scanner.nextLine();

		if (login(username, password)) {
			System.out.println("LOGIN SUCCESSFUL!");

			boolean exit = false;
			

			while (!exit) {
				System.out.println("\nOPTIONS:");
				System.out.println("1. PROPERTY TAX");
				System.out.println("2. VEHICLE TAX");
				System.out.println("3. TOTAL");
				System.out.println("4. EXIT");

				System.out.print("ENTER YOUR CHOICE: ");
			try {
				int choice = scanner.nextInt();
			
				scanner.nextLine (); // Consume the newline character
				

				switch (choice) {
				case 1:
					propery.propertytaxmenu(scanner);
					break;
				case 2:
					vehicles.vehicletaxmenu(scanner);
					break;
				case 3:
					totaltax.calculateTotalTax();
					break;
				case 4:
					exit = true;
					System.out.println("Thanks Visit Again.");
					break;
				default:
					System.out.println("INVALID CHOICE! PLEASE TRY AGAIN.");
					break;
				}
				}catch(InputMismatchException e) {
					System.out.println("input must be a numeric ");
					scanner.next(); //this consumes the invalid token
				}
			}
		} else {
			System.out.println("LOGIN FAILED! INVALID USERNAME OR PASSWORD.");
		}

		scanner.close();
	}
	private static boolean login(String username, String password) {

		return username.equalsIgnoreCase("Ganesh") && password.equals("Ganesh123");
	}
}

