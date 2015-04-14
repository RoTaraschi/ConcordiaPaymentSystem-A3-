import java.util.*;


class AddPerson {
	
	public static Person addNewPerson()
	{
		//infinite loop that returns to the previous loop on choice of 7
		//common attributes of all Person objects are handled in this first block
		while(true)
		{
		
			
			Scanner kb = new Scanner(System.in);
			String tempName;
			int tempID;
			
			
			
			System.out.println("\n\nWelcome! Lets add a person!\n");
			
			System.out.print("Name: ");
			tempName = kb.nextLine();
			
			System.out.println("Which category does the new person fall under?\n");
			System.out.println("1: Student - Current");
			System.out.println("2: Student -  Alumni");
			System.out.println("3: Faculty - Permanent");
			System.out.println("4: Faculty - Part Time");
			System.out.println("5: Staff - Permanent");
			System.out.println("6: Staff - Part Time");
			System.out.println("7 - Cancel\n\n");
			
			System.out.print("Please make a selection:");
			
			int userChoice;
			userChoice = kb.nextInt();
			
			
			
		
//-------------------------Beginning of Student Creation
		if(userChoice == 1 || userChoice == 2)
		{
			int tempTA;
			double tempPayRate = 0;
			double tempAccountBalance = 0;
			int tempContractLength = 0;
			int tempHoursPerMonth = 0;
			
			Student.TA tempTAStatus = Student.TA.NOT_QUALIFIED;
			Student.Status tempStatus = Student.Status.CURRENT;
			
			//If Current Student
			if(userChoice == 1)
			{
				System.out.println("Is this student a TA or a Grad TA?\n");
				System.out.println("1 - TA\n");
				System.out.println("2 - Grad TA\n");
				System.out.println("3 - Not a TA");
				
				tempTA = kb.nextInt();
				switch(tempTA)
				{
					case 1: tempTAStatus = Student.TA.IS_TA; break;
					case 2: tempTAStatus = Student.TA.IS_GRADTA; break;
					default: tempTAStatus = Student.TA.QUALIFIES;
				}
				
				
				//Handles the pay rate
				if(tempTAStatus == Student.TA.IS_TA ||tempTAStatus == Student.TA.IS_GRADTA)
				{
					System.out.println("Please enter the base pay rate per hour for the TA position:");
					tempPayRate = kb.nextDouble();
					
					System.out.println("Please enter the TA contract length");
					tempContractLength = kb.nextInt();
					
					System.out.println("How Many hours per month will this TA work?");
					tempHoursPerMonth = kb.nextInt();
					
					
					if(tempTAStatus == Student.TA.IS_GRADTA)
					{
						tempPayRate = tempPayRate *  1.2;
					}	
				}
				
			}
			
			System.out.print("Enter new student ID number:");
			tempID = kb.nextInt();
			
			
			
			
			
			
			
			//if Alumni Student
			if(userChoice == 2)
			{
				tempStatus = Student.Status.ALUMNI;
				tempTAStatus = Student.TA.NOT_QUALIFIED;
				tempContractLength = -1;
			}
			
			Student newStudent = new Student(tempName, tempStatus, tempTAStatus, tempID, tempPayRate, tempAccountBalance, tempContractLength, tempHoursPerMonth);
			
			return newStudent;
		}
//------------------------End of Student Creation	
	

		//I think that part time faculty members might need a countdown attribute added to them for monthly calculations.
	
		
		
//-----------------------Beginning of Faculty Creation
		
		
		if(userChoice == 3 ||userChoice ==4)
		{
			double tempPayRate = 0;
			double tempAccountBalance = 0;
			int tempContractLength = 0;
			int tempClassSize = 0;
			int tempNumOfCourses = 0;
			int tempHoursPerMonth= 0;
			
			Faculty.FacultyContract tempFacultyContract = null;
			
			//Handles Full Time Faculty
			if(userChoice == 3)
			{
				tempFacultyContract = Faculty.FacultyContract.PERMANENT;
				
				tempHoursPerMonth = -1;
				
				System.out.println("Please enter the annual salary rate per year: ");
				
				tempPayRate = kb.nextDouble()/12; // puts in the salary per month
				
				tempContractLength = -1;
				System.out.println("Please enter the number of Courses being taught: ");
				tempNumOfCourses = kb.nextInt();
					
			}
			
			
			//Handles Part Time Faculty
			if(userChoice == 4)
			{
			
				tempFacultyContract = Faculty.FacultyContract.PART_TIME;
				
				System.out.println("Please enter the fixed pay rate per hour: ");
				tempPayRate = kb.nextDouble();
				
				System.out.println("Please enter the number of hours per month: ");
				tempHoursPerMonth = kb.nextInt();
				
				
				System.out.println("Please enter the number of Courses being taught(max 2): ");
				tempNumOfCourses = kb.nextInt();
				
				
				//Adds Money to account balance for one class
				if(tempNumOfCourses == 1)
				{
					System.out.println("Please enter the class size: ");
					tempClassSize = kb.nextInt();	
					
					
				
					if(tempClassSize > 40 && tempClassSize < 60)
					{
						tempAccountBalance = tempAccountBalance + 500;
					}
					if(tempClassSize > 60)
					{
						tempAccountBalance = tempAccountBalance + 1000;
					}
				}
				
				//Adds money to account balance for two classes
				if(tempNumOfCourses == 2)
				{
					System.out.println("Please enter the first class size: ");
					tempClassSize = kb.nextInt();	
					
					if(tempClassSize > 40 && tempClassSize < 60)
					{
						tempAccountBalance = tempAccountBalance + 500;
						System.out.println("Additional $500 placed in faculty members account");
					}
					if(tempClassSize > 60)
					{
						tempAccountBalance = tempAccountBalance + 1000;
						System.out.println("Additional $1000 placed in faculty members account");
					}
					
					
					System.out.println("Please enter the second class size: ");
					tempClassSize = kb.nextInt();	
					
					if(tempClassSize > 40 && tempClassSize < 60)
					{
						tempAccountBalance = tempAccountBalance + 500;
						System.out.println("Additional $500 placed in faculty members account");
					}
					if(tempClassSize > 60)
					{
						tempAccountBalance = tempAccountBalance + 1000;
						System.out.println("Additional $1000 placed in faculty members account");
					}
				}	
				
				
				System.out.println("Please enter the contract length: ");
				tempContractLength = kb.nextInt();
				
				
			}	
			
			
		
			System.out.print("Enter new Faculty ID number:");
			tempID = kb.nextInt();
			
		Faculty newFaculty = new Faculty(tempName, tempFacultyContract, tempID, 
				tempPayRate, tempAccountBalance, tempContractLength,tempHoursPerMonth, tempNumOfCourses);

		return newFaculty;	
		}
//-------------------------------End of Faculty Creation
		

		
//------------------------------Beginning of Staff Creation
		
		//Permanent Staff
	if(userChoice == 5)
	{
		
		Staff.StaffContract tempStaffContract = Staff.StaffContract.PERMANENT;
		Staff.StaffDepartment tempStaffDepartment = Staff.StaffDepartment.MISC;
		double tempPayRate;
		int tempContractLength;
		double tempAccountBalance = 0;
		int tempComissionChoice;
		int tempComission = 0;
		double tempComissionPercent =0;
		
		int tempDepartmentChoice;
		
		System.out.println("Please enter the department of the new staff member: ");
		System.out.println("1 - Bookstore ");
		System.out.println("2 - Custodial ");
		System.out.println("3 - Administration ");
		System.out.println("4 - Marketing ");
		
		tempDepartmentChoice = kb.nextInt();
		
		switch(tempDepartmentChoice)
		{
			case 1: tempStaffDepartment = Staff.StaffDepartment.BOOKSTORE; break;
			case 2: tempStaffDepartment = Staff.StaffDepartment.CUSTODIAL; break;
			case 3: tempStaffDepartment = Staff.StaffDepartment.ADMINISTRATION; break;
			case 4: tempStaffDepartment = Staff.StaffDepartment.MARKETING; break;
			default: tempStaffDepartment = Staff.StaffDepartment.MISC;break;
		}
		
		
		
		System.out.println("What is the annual salary of the staff member: ");
		//we will pay the person an equal portion every month. possible bad design but I think we
		//should just go with it for now.
		tempPayRate = (kb.nextDouble())/12;
		
		System.out.println("Does this staff member have a comission?");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		tempComissionChoice = kb.nextInt();
		
		if(tempComissionChoice == 1)
		{
			if(tempStaffDepartment.equals(Staff.StaffDepartment.BOOKSTORE)){
				if(Staff.StaffDepartment.getBookstoreComission()!=0){
					System.out.println("Please Enter The Comission of the Bookstore");
					tempComission = kb.nextInt();
					Staff.StaffDepartment.setBookstoreComission(tempComission);					
				}
				
				
				
				
			}
			
			if(tempStaffDepartment.equals(Staff.StaffDepartment.CUSTODIAL)){
				if(Staff.StaffDepartment.getCustodialComission() != 0){
					
					System.out.println("Please Enter The Comission of the Custodian(in decimal)");
					tempComission = kb.nextInt();
					Staff.StaffDepartment.setCustodialComission(tempComission);
					
				}	
			}
			
			System.out.println("Please Enter the Comission Percentage of total sales(in decimal)");
			tempComissionPercent = kb.nextDouble();
					
		}
		
		tempContractLength = -1;
		
		System.out.println("Please enter the new Staff ID: ");
		tempID = kb.nextInt();
		
		Staff newStaff = new Staff(tempName, tempStaffContract, tempStaffDepartment, tempID, tempPayRate, tempContractLength, tempAccountBalance, tempComissionPercent);
		return newStaff;	
	}
	
	
	//Part-Time Staff
	if(userChoice == 6)
	{
		
		Staff.StaffContract tempStaffContract = Staff.StaffContract.PART_TIME;
		Staff.StaffDepartment tempStaffDepartment = Staff.StaffDepartment.MISC;
		double tempPayRate;
		int tempContractLength;
		double tempAccountBalance = 0;
		int tempComissionChoice = 0;
		int tempComission = 0;
		double tempComissionPercent = 0;
		int tempDepartmentChoice = 0;
		
		System.out.println("Please enter the department of the new staff member: ");
		System.out.println("1 - Bookstore ");
		System.out.println("2 - Custodial ");
		System.out.println("3 - Administration ");
		System.out.println("4 - Marketing ");
		
		tempDepartmentChoice = kb.nextInt();
		
		switch(tempDepartmentChoice)
		{
			case 1: tempStaffDepartment = Staff.StaffDepartment.BOOKSTORE; break;
			case 2: tempStaffDepartment = Staff.StaffDepartment.CUSTODIAL; break;
			case 3: tempStaffDepartment = Staff.StaffDepartment.ADMINISTRATION; break;
			case 4: tempStaffDepartment = Staff.StaffDepartment.MARKETING; break;
			default: tempStaffDepartment = Staff.StaffDepartment.MISC;break;
		}
		
		//Commission Here
		System.out.println("Does this staff member have a comission?");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		tempComissionChoice = kb.nextInt();
		
		if(tempComissionChoice == 1)
		{
			if(tempStaffDepartment.equals(Staff.StaffDepartment.BOOKSTORE)){
				if(Staff.StaffDepartment.getBookstoreComission()!=0){
					System.out.println("Please Enter The Comission of the Bookstore(in decimal)");
					tempComission = kb.nextInt();
					Staff.StaffDepartment.setBookstoreComission(tempComission);					
				}
				
			}
			
			if(tempStaffDepartment.equals(Staff.StaffDepartment.CUSTODIAL)){
				if(Staff.StaffDepartment.getCustodialComission() != 0){
					
					System.out.println("Please Enter The Comission of the Custodian(in decimal)");
					tempComission = kb.nextInt();
					Staff.StaffDepartment.setCustodialComission(tempComission);
					
				}						
			}
		
			System.out.println("Please Enter the Comission Percentage of total Sales(in decimal)");
			tempComissionPercent = kb.nextDouble();
			
		}
		
		
		
		
		
		System.out.println("Please enter the annual salary of the staff member: ");
		tempPayRate = kb.nextDouble();
		
		System.out.println("Please enter the contract length (years):");
		tempContractLength = kb.nextInt();
		
		System.out.println("Please enter the new Staff ID: ");
		tempID = kb.nextInt();
		
		Staff newStaff = new Staff(tempName, tempStaffContract,tempStaffDepartment, tempID, tempPayRate, tempContractLength, tempAccountBalance, tempComissionPercent);
		return newStaff;
		
		
	}
		
		
//------------------------------End of Staff Creation
		
		//Jumps back to the main menu.
			if(userChoice == 7)
			{
				break;
			}
		
		}
		
		//necessary to ensure a return of person.
		return null;
	
		
		
	}

}
