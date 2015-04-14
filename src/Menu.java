import java.util.Scanner;


class Menu {
	
	public static void mainMenu()
	{
		
		System.out.println("\n--------------CONCORDIA DATABASE--------------");	
	System.out.println("\nWhat would you like to do?\n");
	System.out.println("1 - Add an individual");
	System.out.println("3 - Advance the Calender by one month.");
	System.out.println("4 - Search for an individual and view his/her info");
	System.out.println("6 - Finances");
	System.out.println("7 - Calculate the total amount of money that needs to be paid (TA, faculty, Staff)");
	System.out.println("8 - Generate List");
	System.out.println("9 - Exit\n\n");
	
	System.out.print("Please make a selection:");
	
	}
	
	public static void searchMenu()
	{
		for (int i=1; i<=20; i++)
		    System.out.println("\f");
	        
		System.out.println("1 - Search by Name");
		System.out.println("2 - Search by ID");
		System.out.println("9 - Go Back");
		
		
		
		 
	}
	
	public static void editMenu()
	{
		
		System.out.println("\nWhat would you like to do?\n");
		System.out.println("1 - Edit User");
		System.out.println("2 - Delete User");
		System.out.println("9 - Go back");
	}
	
	public static void editStudentMenu()
	{
		// ta status, contract length, current student, alumni, pay rate, hours per month
		System.out.println("\nWhat would you like to change?\n");
		System.out.println("1 - Change Name");
		System.out.println("2 - Change Student Status");
		System.out.println("3 - Change TA Status");
		System.out.println("4 - Change TA Contract Length");
		System.out.println("5 - Change TA Pay Rate");
		System.out.println("6 - Change TA Hours Per Month");
		System.out.println("9 - Go back");
	}
	
	public static void editFacultyMenu()
	{
		System.out.println("\nWhat would you like to do?\n");
		System.out.println("1 - Change name");
		System.out.println("2 - Change status");
		System.out.println("3 - Change the number of courses");
		System.out.println("4 - Change the pay rate");
		System.out.println("5 - Change contract length");
		System.out.println("9 - Go back");
	}
	
	public static void editStaffMenu()
	{
		System.out.println("\nWhat would you like to do?\n");
		System.out.println("1 - Change name");
		System.out.println("2 - Change commission rate");
		System.out.println("3 - Change annual salary");
		System.out.println("9 - Go back");
	}
	
	public static void listMenu()
	{
		System.out.println("\nWhat would you like to list?\n");
		System.out.println("1 - Show all people");
		System.out.println("2 - Show all current students");
		System.out.println("3 - Show all alumni students");
		System.out.println("4 - Show all permanent faculty members");
		System.out.println("5 - Show all part time faculty members");
		System.out.println("6 - Show all part time staff members");
		System.out.println("7 - Show all permanent staff members");
		System.out.println("8 - Go back");
	}
	
	
		public static void financeMenu()
		{
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("1 - Show paystubs and total for the current month");
			System.out.println("2 - Go back");
			
			
			
			
			
		}
	

//	//Not implemented
//	public static void nextMonthMenu(){
//		
//		System.out.println("Would you like to advance to the next month or a specific time?");
//		
//		System.out.println("1 - Next month");
//		System.out.println("2 - A specific month and year");
//	}
	
	
	

//	public static void nextMonthSubMenu(){
//		
//		//to be continued
//		
//		System.out.println("What would you like to do?");
//		System.out.println("1 - ");
//		
//		
//		
//	}











}
