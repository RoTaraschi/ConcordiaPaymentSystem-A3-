import java.io.Serializable;
import java.text.DecimalFormat;


class Student extends Person implements Payable, Serializable{
	
	//Attributes
	public enum Status
	{
		CURRENT, ALUMNI;
	}
	
	
	
	public enum TA
	{
		NOT_QUALIFIED, QUALIFIES, IS_TA, IS_GRADTA;
	}
	
	private Status status;
	private TA TA;
	private int hoursPerMonth;
	private int monthsPayableLeft;
	
	//Constructors
	public Student(String name, Status status, TA TA, int ID, double payRate, double accountBalance, int contractLength, int hoursPerMonth)
	{
		super(name, ID, payRate, accountBalance, contractLength);
		
		this.status = status;
		this.TA = TA;
		this.hoursPerMonth  = hoursPerMonth;
		this.monthsPayableLeft = this.getContractLength();
	}
	
//-------------------METHODS
	

	
	
	
	
	
	
	//changes the student status when called in the edit menu
	public Status getStatus()
	{
		return this.status;
	}
	
	
	
	
	
	public double showMonthPay()
	{
		if(this.getContractLength() > 0)
		{	
			if(this.TA == TA.IS_TA)
			{
				return (this.hoursPerMonth * this.getPayRate());
			}
			
			if(this.TA == TA.IS_GRADTA)
			{
				return (this.hoursPerMonth * ((1.2) *this.getPayRate()));
			}
			else
			{
				return 0;
			}
		}

			return 0;	
		
	}

	
	/**
	 * GETMONTHPAY!!
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public double getMonthPay()
	{
		
			
		if(this.getContractLength() > 0)
		{	
			if(this.TA == TA.IS_TA)
			{
				this.monthsPayableLeft--;
				this.contractLengthPaid();
				return (this.hoursPerMonth * this.getPayRate());
			}
			
			if(this.TA == TA.IS_GRADTA)
			{
				this.monthsPayableLeft--;
				return (this.hoursPerMonth * ((1.2) *this.getPayRate()));
			}
			else
			{
				this.monthsPayableLeft--;
				return 0;
			}
		}
		else
		{
			return 0;
		}	
		
	}
	
	public void setStatus()
	{
		
		System.out.println("Change to Alumni or Current?");
		System.out.println("1 - Current");
		System.out.println("2 - Alumni");
		int statusChoice;
		statusChoice = Edit.getScanner().nextInt();
		
		switch(statusChoice)
		{
		
		case 1: System.out.println("Status has changed from " + this.status + " to " + Status.CURRENT);
			this.status = Status.CURRENT;
			this.TA = TA.QUALIFIES;
			break;
		
		case 2: System.out.println("Status has changed from " + this.status + " to " + Status.ALUMNI);
				this.status = Status.ALUMNI; 
				this.TA = TA.NOT_QUALIFIED;break;
			
		default: break;
		}
		
	}
	
	
	public void setPayRate()
	{
		if(this.TA == TA.NOT_QUALIFIED || this.TA == TA.QUALIFIES)
		{
			System.out.println("This student does not have a TA job.");
		}
		else
		{
			double newPayRate;
			System.out.println("Please enter the new pay rate");
			newPayRate = Edit.getScanner().nextDouble();
			System.out.println("Pay rate changed from " + this.getPayRate() + " to " + newPayRate);
			this.setPayRate(newPayRate);
		}
	}
	
	public void setHours()
	{
		int newHours;
		if(this.TA == TA.NOT_QUALIFIED || this.TA == TA.QUALIFIES)
		{
			System.out.println("This student does not have a TA position.\n\n");
			this.hoursPerMonth = 0;
		}
		else
		{
		System.out.println("Please enter the new hours per month: ");
		newHours = Edit.getScanner().nextInt();
		System.out.println("Hours changed from " +this.hoursPerMonth +  " to " + newHours);
		this.hoursPerMonth = newHours;
		
		
		}
		
	}
	
	//Changes TA Status (with alumni check) when called from the edit block in Database
	public void setTAStatus()
	{
		System.out.println("Change to Current TA, Grad TA, or Not a TA?");
		System.out.println("1 - Current TA");
		System.out.println("2 - Not TA");
		System.out.println("3 - Grad TA");
		
		
		
		int statusChoice;
		statusChoice = Edit.getScanner().nextInt();
		
		switch(statusChoice)
		{
		
		case 1: 
		{
			if(this.status == Status.ALUMNI)
			{
				System.out.println("Only Current Students can be TA's.");
			}
			
			if(this.status == Status.CURRENT){
			System.out.println("TA Status has changed from " + this.TA + " to " + TA.IS_TA);
			this.TA = TA.IS_TA;
			}
			break;
		}
		case 2: 
		{
			if(this.status == Status.ALUMNI)
			{
				System.out.println("Only Current Students can be TA's.");
			}
			else
			{
			System.out.println("TA Status has changed from " + this.TA + " to " + TA.QUALIFIES);
			this.TA = TA.QUALIFIES;break;
			}
		}
		
		case 3:
		{
			if(this.status == Status.ALUMNI)
			{
				System.out.println("Only Current Students can be TA's.");
			}
			else
			{
			System.out.println("TA Status has changed from " + this.TA + " to " + TA.IS_GRADTA);
			this.TA = TA.IS_GRADTA; break;
			}
		}
			default: break;
		}	
	}
		
	public void setContractLength()
	{
		if(this.TA == TA.NOT_QUALIFIED || this.TA == TA.QUALIFIES)
		{
			System.out.println("Student is not working and has no contract to set");
		}
		else{
		
		System.out.println("Please enter the new contract length: ");
		int newContractLength;
		newContractLength = Edit.getScanner().nextInt();
		
		System.out.println("Contract length has been changed from " + this.getContractLength() + " to " + newContractLength);
		this.setContractLength(newContractLength);
		this.monthsPayableLeft += 12;
		}
	}
	
	public int getMonthsPayabLeleft() {
		return monthsPayableLeft;
	}
	
	public Student getStudent()
	{
		return Student.this;
	}
		
	public String toString()
	{
		
		 String pattern = "$##0.00";
		 DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		return "STUDENT  -  "+"Name: " + this.getName() + "  |  Student Status: " + 
	    this.status + "  |  TA_Status: " + this.TA + "  |  ID:" +this.getID() +  "  \n            Contract Length: " + this.getContractLengthString()
	    + "   |  Pay Rate: " + decimalFormat.format(this.getPayRate()) + "   |  Hours per month: " + this.hoursPerMonth +  "  |  Account Balance: " + decimalFormat.format(this.getAccountBalance()) + "\n\n\n";
		
	}

	@Override
	public void generatePaystub(String time) {
		
		System.out.println(this.getName() + "Payed amount for the month of " + time +"\n" +
						this.hoursPerMonth + "hour @ $"  + this.getPayRate() + "/hr \n "
						+  "Amount Payed : $" + this.hoursPerMonth*this.getPayRate());		
		
	}

	

}
