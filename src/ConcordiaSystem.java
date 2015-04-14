
import java.util.*;
import java.io.*;


//testset


public class ConcordiaSystem implements Serializable
{
	
	
	public static void main(String[] args)
	{
		
	/* 
	Developed by Mike Basdeo & Roman Taraschi
	
	The Purpose of this program is to Pay Concordia Employees.
	
	
	*/
		
		
		
		
		
		
		
						

		//Initializes database and time.

		
		/**
		 * 
		 * Use This for initializing
		 */
//	Time time = new Time(); 
//	Database ConcordiaSystem = new Database();
		
		
		
		/**
		 * Use this after initialized.
		 * 
		 */
		//Reads database from serialized file.
		Database ConcordiaSystem = new Database().readFromSerializedFile(new File("ConcordiaSystem999.bat"));
		Time time = new Time().readFromSerializedFile(new File("Time.bat"));
	 

//--------------Temporary student creation for testing
  	
		
		/**
		 * Use this for Initializing
		 */
//		Student s1 = new Student("Jim", Student.Status.CURRENT, Student.TA.IS_TA, 123456789, 12.00, 500, 4, 20);   //add contract length					
//		Student s2 = new Student("Mike Basdeo", Student.Status.ALUMNI, Student.TA.NOT_QUALIFIED, 123123, 0, 0, 0, 0);
//		
//		
//		Staff st1 = new Staff("Scruffy the Janitor", Staff.StaffContract.PERMANENT,Staff.StaffDepartment.BOOKSTORE, 555555, 15000, -1, 1000, 0);
//		Staff st2 = new Staff("Al Bundy", Staff.StaffContract.PART_TIME, Staff.StaffDepartment.CUSTODIAL,55555, 120, 2, 0, 0.10);
//		
//		Faculty f1 = new Faculty("Professor Dumbledore", Faculty.FacultyContract.PERMANENT, 666, 50.00, 0, -1,-1, 5);
//		Faculty f2 = new Faculty("Dr Evil", Faculty.FacultyContract.PART_TIME, 666777, 45.00, 500, 1, 20, 2);
//	
//	    	
//	    	
//		ConcordiaSystem.addToDatabase(s1);
//		ConcordiaSystem.addToDatabase(s2);
//		ConcordiaSystem.addToDatabase(st1);
//		ConcordiaSystem.addToDatabase(st2);
//		ConcordiaSystem.addToDatabase(f1);
//		ConcordiaSystem.addToDatabase(f2);
		
		
//--------Just to keep a starting total
		System.out.println(ConcordiaSystem.getDatabaseSize());
		
		
		
		
		//Time Testing
		

		
		//infinite loop calls the Main Menu method from the Menu Class
		while(true)
		{
			
			System.out.print(time);
			Menu.mainMenu();
			
			
			
			//handles all possible choices for the main menu. exits loop on choice of 9. Most are not done.
			Scanner kb  = new  Scanner(System.in);
			
			int mainMenuChoice = 0;
			mainMenuChoice = kb.nextInt();
			
			
			//This adds any person.
			if(mainMenuChoice == 1)
			{
				Person newPerson = AddPerson.addNewPerson();
				
			
				
				//Checks for duplicate ID's before adding person to database.
				if(ConcordiaSystem.checkID(newPerson.getID()) == true)
				{
					ConcordiaSystem.addToDatabase(newPerson);
				}
				
			}
			
			
			//Total amount of money to be paid out
			if(mainMenuChoice == 7){
				System.out.println("\n\n");
				ConcordiaSystem.MoneyPayout(); //The Magic!
				System.out.println("\n\n");
			}
			
			
			
			//------------------HERES WHERE THE FINANCES ARE HANDLED	
			//Move time forward one month
			if(mainMenuChoice == 3)
			{
				time.nextMonth();
				System.out.println("\n\n\n" +time);
				
				ConcordiaSystem.payAllOneMonth();//This is the giant method in the database class that will handle the finances.
			}
			
			
			
			
			
			
			//-----------------Shows entire database	
			if(mainMenuChoice == 8)
			{
				Menu.listMenu();
				int listMenuChoice = 0;
				listMenuChoice = kb.nextInt();
				
				switch(listMenuChoice)
				{
				case 1 : ConcordiaSystem.showAll(); break;
				case 2 : ConcordiaSystem.showAllCurrentStudents(); break;
				case 3 : ConcordiaSystem.showAllAlumniStudents(); break;
				case 4 : ConcordiaSystem.showPermanentFaculty();break;
				case 5 : ConcordiaSystem.showPartTimeFaculty();break;
				case 6 : ConcordiaSystem.showPartStaff();break;
				case 7 : ConcordiaSystem.showPermanentStaff();break;
				case 8 : continue;
				default: break;
				}
					
					
			}
			
			//Exits the program and saves database to serialized file.	
			if(mainMenuChoice == 9)
			{
			
				ConcordiaSystem.writeToSerializedFile(new File("ConcordiaSystem999.bat"), ConcordiaSystem);
				
				time.writeToSerializedFile(new File("Time.bat"), time);
				
				System.out.println("Exiting Database");
				System.exit(0);
			}
			
			
			//--------------------------Locates individuals.	
			
			if(mainMenuChoice == 4)
			{
				Menu.searchMenu();
				
				int searchMenuChoice;
				String searchInput;
				searchMenuChoice = kb.nextInt();
				
				if(searchMenuChoice == 1)
				{
					System.out.println("Please enter the name you wish to search for:");
					searchInput = kb.next();
					ConcordiaSystem.searchByName(searchInput);
				}
				if(searchMenuChoice == 2){
					System.out.println("Please enter someone's ID");
					searchInput = kb.next();
					ConcordiaSystem.searchByID(Integer.parseInt(searchInput));
					
				}
				
				if(searchMenuChoice == 9)
				{
					continue;
				}
			}
			
			
			
			//----------------------------------------------------------------
			
			if (mainMenuChoice ==6)
			{
				Menu.financeMenu();
				int searchMenuChoice = kb.nextInt();
				
				if(searchMenuChoice == 1)
				{
					ConcordiaSystem.showAllPaystubs();
				}
				if(searchMenuChoice == 2)
				{
					continue;
				}
				
			}
			
			
			//Not implemented, but would allow user to advance to a specific month.
//			if(mainMenuChoice == 5)
//			{
//				Menu.nextMonthMenu();
//				
//				int nextMonthChoice = kb.nextInt();
//				
//				if(nextMonthChoice == 1)
//				{
//					Time advancedTime = new Time();
//					advancedTime.setTime(time.getCurrentMonth().name(), time.getCurrentYear());
//					advancedTime.nextMonth();
//					
//					Database advancedConcordiaSystem = new Database(ConcordiaSystem.getDatabase());		
//				}
//			
//			}
		
		}
	
	}
	
}

