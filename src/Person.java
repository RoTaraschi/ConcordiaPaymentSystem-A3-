import java.io.*;
import java.util.*;

abstract class Person implements Serializable
{
	
	//transient Scanner kb = new Scanner(System.in);
	
	
	//Attributes of all people
	private String name;
	private int ID;
	private double payRate;
	private double accountBalance;
	private int contractLength;
	
	
	//Constructors
	
	public Person()
	{
		this.name = "John Smith";
		this.ID = 0;
		this.accountBalance = 0;
		this.payRate = 0;
		this.contractLength = -1;
		
	}
	public Person(String name, int ID, double payRate, double accountBalance, int contractLength)
	{
		this.name = name;
		this.payRate = payRate;
		this.accountBalance = accountBalance;
		this.contractLength = contractLength;
		this.ID = ID;
	}
	
	
	
	
	//Methods
	
	public double getMonthPay()
	{
		return 0;
	}
	public abstract double showMonthPay();
	
	
	public void contractLengthPaid()
	{
		this.contractLength = contractLength -1;
	}
	
	
	
	public void setAccountBalance(double monthlyPay)
	{
		this.accountBalance = this.accountBalance + monthlyPay;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setContractLength(int newContractLength)
	{
		this.contractLength = newContractLength;
	}
	
	public void setName()
	{
		
		String newName;
		System.out.println("Enter the new name: ");
		newName = Edit.getScanner().nextLine();
		
		System.out.println(this.name + " has been changed to " + newName);
		
		this.name = newName;
		
		
	}
	
	public int getID()
	{
		return this.ID;
	}
		
	public void setPayRate(double newPayRate)
	{
		this.payRate = newPayRate;
	}
	
	public double getPayRate()
	{
		return this.payRate;
	}
	
	public int getContractLength()
	{
		return this.contractLength;
	}
	
	public String getContractLengthString()
	{
		if(this.getContractLength() < 0)
		{
			return "N/A";
		}
		else
		{	
			String str = String.valueOf(this.getContractLength());
			return str;
		}
		
		
	}
	
	public double getAccountBalance()
	{
		return this.accountBalance;
	}
	
	
	public void addMoney(double pay)
	{
		this.accountBalance = this.accountBalance + pay;
	}
	
	public String toString()
	{
		return "Name: " + "\n\n\n";
		
	}

}