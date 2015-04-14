import java.io.Serializable;
import java.text.DecimalFormat;


class Staff extends Person implements Payable, Serializable{
	
	//Attributes
	public enum StaffContract
	{
		PERMANENT, PART_TIME;
	}
	
	public enum StaffDepartment
	{
		BOOKSTORE, CUSTODIAL, ADMINISTRATION, MARKETING, MISC;
		
		private static int BookstoreComission;
		private static int CustodialComission;
		
		
		public static int getBookstoreComission(){
			return BookstoreComission;	
		}
		public static int getCustodialComission(){
			return CustodialComission;
		}
		
		public static void setBookstoreComission(int BookstoreComission){
			
			StaffDepartment.BookstoreComission = BookstoreComission;
		}
		public static void setCustodialComission(int CustodialComission){
			
			StaffDepartment.CustodialComission = CustodialComission;
			
		}
		
	}
	
	private StaffContract staffContract;
	private StaffDepartment staffDepartment;
	private double staffComissionPercentage;
	private double staffComission;
	private int monthsPayableLeft;
	

	
	//Constructors
	
	public Staff(String name,StaffContract staffContract, StaffDepartment staffDepartment, int ID, double payRate,int contractLength, double accountBalance, double staffComissionPercentage)
	{
		super(name, ID, payRate, accountBalance, contractLength);
		this.staffContract = staffContract;
		this.staffDepartment = staffDepartment;
		this.staffComissionPercentage = staffComissionPercentage;
		this.monthsPayableLeft = 12;
		if(staffDepartment.equals(StaffDepartment.BOOKSTORE))
			this.staffComission = StaffDepartment.getBookstoreComission()*staffComissionPercentage;
		if(staffDepartment.equals(StaffDepartment.CUSTODIAL))
			this.staffComission = StaffDepartment.getCustodialComission()*staffComissionPercentage;
	}
	
	//ReadWriteFileConstructor
		public Staff(String name,StaffContract staffContract, StaffDepartment staffDepartment, int ID, double payRate,int contractLength, double accountBalance, double staffComissionPercentage,int monthsPayableLeft)
		{
			super(name, ID, payRate, accountBalance, contractLength);
			this.staffContract = staffContract;
			this.staffDepartment = staffDepartment;
			this.staffComission = staffComission;
			this.monthsPayableLeft = monthsPayableLeft;
		}
	
	
	
//-------------------------METHODS
	
		public void setCommission()
		{
			System.out.println("Please enter the new commission rate (in decimal): ");
			double newComission = Edit.getScanner().nextDouble();
			System.out.println("\n\n Commission changed from " + this.staffComission + " to " +  newComission);
			this.staffComission = newComission;
		}
		
		public void setPayRate()
		{
				double newPayRate;
				System.out.println("Please enter the new annual pay rate");
				newPayRate = Edit.getScanner().nextDouble();
				System.out.println("Pay rate changed from " + this.getPayRate() + " to " + newPayRate);
				this.setPayRate(newPayRate);
		}
		
		
		
		
		
		//Shows amount for current month
		public double showMonthPay() 
		{
			if(this.staffContract == StaffContract.PERMANENT)
			{
				return (this.getPayRate()/12);
			}
	
			if(this.staffContract == StaffContract.PART_TIME)
			{
				//creates a random number to generate total sales for each employee to find commission.
				double lower = 100.00;
				double upper = 500.00;
				double result = Math.random() * (upper - lower) + lower;
			
				return (this.getPayRate()/12) + staffComission * result;
			}
			return 0;
		}
		
		
		
		
		//Pays the various staff members accordingly
		public double getMonthPay() 
		{
			if(this.staffContract == StaffContract.PERMANENT)
			{
				return (this.getPayRate()/12);
			}
	
			if(this.staffContract == StaffContract.PART_TIME)
			{
				//creates a random number to generate total sales for each employee to find commission.
				double lower = 100.00;
				double upper = 500.00;
				double result = Math.random() * (upper - lower) + lower;
			
				return (this.getPayRate()/12) + staffComission * result;
			}
			return 0;
		}
		
		
		
		
		
	public StaffContract getStaffContract()
	{
		return this.staffContract;
	}
	
	public String toString()
	{
		
		 String pattern = "$##0.00";
		 DecimalFormat decimalFormat = new DecimalFormat(pattern);
		 
			return "STAFF  -  " + " Department:" + this.staffDepartment + "   |  Name:" + this.getName() +  "   |  Contract:" + this.staffContract + "\n           Contract Length:" + this.getContractLengthString()
					+ "   |  Annual Salary: " + decimalFormat.format(this.getPayRate()) + "   |  Comission: " + this.staffComission + "   |  Account Balance: " + decimalFormat.format(this.getAccountBalance()) + "\n\n\n";
	}

public String toWriteFile()
	{
		
		return "Staff:" + ";name=" + this.getName() + 
				   ";ID="+ this.getID() + 
				   ";payRate" + this.getPayRate() + 
				   ";accountBalance=" + this.getAccountBalance() + 
				   ";contractLength="+ this.getContractLength() +
				   ";StaffContract=" + this.staffContract +
				   ";StaffComission=" + this.staffComission +
				   ";monthsPayableLeft=" + this.monthsPayableLeft;
	}
	
	
	public void generatePaystub(String time) 
	{
			
	}
}
//------------END OF Staff Class