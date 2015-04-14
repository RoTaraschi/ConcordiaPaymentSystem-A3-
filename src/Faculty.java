import java.io.Serializable;
import java.text.DecimalFormat;

class Faculty extends Person implements Payable, Serializable {
	
	//Attributes
	public enum FacultyContract
	{
		PERMANENT, PART_TIME;
	}
	
	private FacultyContract facultyContract;
	//private int classSize;
	private int numOfCourses;
	private int monthsPayableLeft;
	private int hoursPerMonth;
	private int facultyCounter;
	

	
	//Constructors
	public Faculty(String name, FacultyContract facultyContract, 
			int ID, double payRate, double accountBalance, int contractLength,int hoursPerMonth, int numOfCourses)
	{
		super(name, ID, payRate, accountBalance, contractLength); // if full time salary per month is stored in payrate
		//this.classSize = classSize;
		this.numOfCourses = numOfCourses;
		this.facultyContract = facultyContract;
		this.facultyCounter = 0;
		
		if(this.facultyContract.equals(FacultyContract.PERMANENT)){
			hoursPerMonth = 40; // full time
			monthsPayableLeft = -1; // forever payed
		}
		else{
			this.setHoursPerMonth(hoursPerMonth);
			this.monthsPayableLeft = 12;
		}
		
		
		
		
		
		
		
		
		//ReadWriteFileConstructor
//		public Faculty(String name, FacultyContract facultyContract, 
//				int ID, double payRate, double accountBalance, int contractLength,int hoursPerMonth, int numOfCourses, int monthsPayableLeft)
//		{
//			super(name, ID, payRate, accountBalance, contractLength);
//			
//			this.facultyContract = facultyContract;
//			//this.classSize = classSize;
//			this.numOfCourses = numOfCourses;
//			this.monthsPayableLeft = monthsPayableLeft;
//			this.setHoursPerMonth(hoursPerMonth);
//			
//		}
//		
	}

	
//------------------------------Methods
	

	
//-----------------------Handles the pay for Faculty
	
	
	public double showMonthPay() 
	{
		if(this.facultyContract.equals(FacultyContract.PERMANENT))
		{
		return this.getPayRate();		
		}
		//This controls the 4 term courses. After 4 months all of a part time faculty
		//members courses are removed and their contract is reset to 0.
		if(this.numOfCourses !=0){
			
			this.facultyCounter +=1;
			
			if(this.facultyContract.equals(FacultyContract.PART_TIME) && (this.facultyCounter % 4) != 0)
			{
				//this.contractLengthPaid();
				return this.getPayRate() * this.hoursPerMonth;
			}
			
			if(this.facultyContract.equals(FacultyContract.PART_TIME) && (this.facultyCounter % 4) == 0)
			{
				//this.numOfCourses = 0;
				//this.setContractLength(0);
				return this.getPayRate() * this.hoursPerMonth;
			}
			
		}
		
		return 0;
	}
	
	//--------------------------------
	
	
	
	
	public double getMonthPay() 
	{
		if(this.facultyContract.equals(FacultyContract.PERMANENT))
		{
		return this.getPayRate();		
		}
		
		
		//This controls the 4 term courses. After 4 months all of a part time faculty
		//members courses are removed and their contract is reset to 0.
		if(this.numOfCourses !=0){
			
			this.facultyCounter +=1;
			
			if(this.facultyContract.equals(FacultyContract.PART_TIME) && (this.facultyCounter % 4) != 0)
			{
				
				this.contractLengthPaid();
				return this.getPayRate() * this.hoursPerMonth;
			}
			
			if(this.facultyContract.equals(FacultyContract.PART_TIME) && (this.facultyCounter % 4) == 0)
			{
				
				this.numOfCourses = 0;
				this.setContractLength(0);
				return this.getPayRate() * this.hoursPerMonth;
			}
			
		}
		
		return 0;
	}
	
	
	
	public void setContractLength()
	{
		if(this.facultyContract == FacultyContract.PART_TIME)
		{
		System.out.println("Please enter the new contract length: ");
		int newContractLength;
		newContractLength = Edit.getScanner().nextInt();
		this.setContractLength(newContractLength);
		}
		else
		{
			System.out.println("Cannot change the hours of a permanent staff memeber");
		}
		
	}
	
	
	
	
	
	public void setPayRate()
	{
		System.out.println();

		if(this.facultyContract == FacultyContract.PERMANENT)
		{
			System.out.println("Please enter the fixed salary rate per month: ");
			double newPayRate;
			newPayRate = Edit.getScanner().nextDouble();
			this.setPayRate(newPayRate);
		}
		
		if(this.facultyContract == FacultyContract.PART_TIME)
		{
			System.out.println("Please enter the new pay rate per hour: ");
			double newPayRate;
			newPayRate = Edit.getScanner().nextDouble();
			this.setPayRate(newPayRate);
		}
		
	}
	
	
	
	
	
	
	public void setNumOfCourses()
	{
		System.out.println("Please enter the new number of courses (Max of 2):");
		int tempCourseChange = 0;
		tempCourseChange = Edit.getScanner().nextInt();
		
		System.out.println("Number of courses has changed from " + this.numOfCourses + " to " + tempCourseChange);
		this.numOfCourses = tempCourseChange;
		
		
		if(tempCourseChange == 1)
		{
			System.out.println("Please enter the class size: ");
			int tempClassSize = Edit.getScanner().nextInt();
			
			if(tempClassSize > 40 && tempClassSize < 60)
			{
				System.out.println("$500 has been added to faculty members account");
				this.addMoney(500);
			}
			if(tempClassSize > 60)
			{
				System.out.println("$1000 has been added to faculty members account");
				this.addMoney(1000);
			}
		}
		
		if(tempCourseChange == 2)
		{
			System.out.println("Please enter the first class size: ");
			int tempClassSize = Edit.getScanner().nextInt();	
			
			if(tempClassSize > 40 && tempClassSize < 60)
			{
				System.out.println("$500 has been added to faculty members account");
				this.addMoney(500);
			}
			if(tempClassSize > 60)
			{
				System.out.println("$1000 has been added to faculty members account");
				this.addMoney(1000);
			}
			
			
			System.out.println("Please enter the second class size: ");
			tempClassSize = Edit.getScanner().nextInt();
			
			if(tempClassSize > 40 && tempClassSize < 60)
			{
				
				System.out.println("$500 has been added to faculty members account");
				this.addMoney(500);
			}
		
			if( tempClassSize > 60)
			{
				System.out.println("$1000 has been added to faculty members account");
				this.addMoney(1000);
			}
		}	
		
		
		
		
		
	}
	
	
	
	
	
	public FacultyContract getFacultyContract()
	{
		return this.facultyContract;
	}
	
	public void setFacultyContract()
	{
		System.out.println("Change contract to:");
		System.out.println("1 - Permanent");
		System.out.println("2 - Part time");
		int tempContractChoice = 0;
		tempContractChoice = Edit.getScanner().nextInt();
		
		switch(tempContractChoice){
		case 1: 
			System.out.println("Contract has been changed from Part Time to Permanent" );
			this.facultyContract = facultyContract.PERMANENT; break;
		case 2: System.out.println("Contract has been changed from Permanent to Part Time" );
			this.facultyContract = facultyContract.PART_TIME; break;
		}
	}

	
	public String toString()
	{
		
		 String pattern = "$##0.00";
		 DecimalFormat decimalFormat = new DecimalFormat(pattern);
		 
		if(this.facultyContract == FacultyContract.PERMANENT)
		{
			return "FACULTY  -  " + "Name: " + this.getName() + "   |   Number of Courses:" + this.numOfCourses +
					"   |  Faculty Contract: " + this.facultyContract  + "  \n            Contract Length: " + this.getContractLengthString()
		    + "   |  Salary per Month: " + decimalFormat.format(this.getPayRate()) + "   |  Hours per Month: N/A" + "   |  Account Balance: " + decimalFormat.format(this.getAccountBalance()) + "\n\n\n";
			
		}
		else
		{
			return "FACULTY  -  " + "Name: " + this.getName() + "   |   Number of Courses:" + this.numOfCourses +
					"   |  Faculty Contract: " + this.facultyContract  + "  \n            Contract Length: " + this.getContractLengthString()
		    + "   |  Pay Rate: " + decimalFormat.format(this.getPayRate()) + "   |  Hours per Month: "+ this.hoursPerMonth + "   |  Account Balance: " + decimalFormat.format(this.getAccountBalance()) + "\n\n\n";
		}
		
		
		
		
		
	}
	
	public String toWriteFile(){
		
		return "FACULTY:" + ";name=" + this.getName() + 
				   ";ID="+ this.getID() + 
				   ";payRate" + this.getPayRate() + 
				   ";accountBalance=" + this.getAccountBalance() + 
				   ";contractLength="+ this.getContractLength() +
				   ";facultyContract=" + this.facultyContract +
				   ";numofCourses=" + this.numOfCourses +
				   ";monthsPayableLeft="+ this.monthsPayableLeft +
				   ";hoursPerMonth=" + this.hoursPerMonth;	
	}
	
	
	
	public int getHoursPerMonth() {
		return hoursPerMonth;
	}
	public void setHoursPerMonth(int hoursPerMonth) {
		if(hoursPerMonth < 41)
		this.hoursPerMonth = hoursPerMonth;
		else
		System.out.println("This Person is working more than 40 hours.Hours not changed");
	}
	


	@Override
	public void generatePaystub(String time) {
		if(this.facultyContract.equals(FacultyContract.PERMANENT)){
		System.out.println(this.getName() + "Payed amount for the month of " + time +"\n" +
				this.hoursPerMonth + "hour @ $"  + this.getPayRate() + "/hr \n "
				+  "Amount Payed : $" + this.hoursPerMonth*this.getPayRate());		

		}else{
			
			System.out.println(this.getName() + "Payed amount for the month of " + time +"\n" +
					this.hoursPerMonth + "hour @ $"  + this.getPayRate() + "/hr + Comission: $" + this.getAccountBalance()/12 +
					  "\nAmount Payed : $" + this.getMonthPay());		
	
		}
		
		
	}

}
//-----------------------END of Faculty Class