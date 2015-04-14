import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Time implements Serializable{
	
	
	//Attributes
	public static enum Month{ JANUARY, FEBUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER}
	

	private Month currentMonth;
	private int currentMonthnumber = 1;
	private int currentYear;
	
	//Constructor
	
	public Time(){
		
		this.setCurrentMonth(Month.NOVEMBER);
		this.currentMonthnumber += this.getCurrentMonth().ordinal();
		this.setCurrentYear(2014);
		
	}
	
	
	//Methods
	
	
	
	
	
	 //Writes to serialized file
	 public void writeToSerializedFile(File file, Time time)
	 {
		    try 
		    {
		        ObjectOutputStream output2 = new ObjectOutputStream(
		                                    new FileOutputStream(file));
		        output2.writeObject(time);
		        
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	 }
	
	 
	 //Reads from serialized file
	 public Time readFromSerializedFile(File file) 
	 {
		    Time tImport = null;
		    try 
		    {
		        ObjectInputStream input2 = new ObjectInputStream(
		                                  new FileInputStream("Time.bat"));
		      tImport = (Time)input2.readObject();   
		      
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		       e.printStackTrace();
		    }
		    return tImport;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setTime(String setmonth , int setYear){
		
		this.setCurrentMonth(Month.valueOf(setmonth.toUpperCase()));
		this.currentMonthnumber += getCurrentMonth().ordinal();
		this.setCurrentYear(setYear);
	}

	public void nextMonth(){
		
		currentMonthnumber++;
		if(currentMonthnumber == 13){
			currentMonthnumber = 1;
			setCurrentYear(getCurrentYear() + 1);
		}
				
		setCurrentMonth(MonthNameFinder(currentMonthnumber));
		
	}
	
	public Month MonthNameFinder(int number){
		
		switch (number){
			
			case 1:
				return Month.JANUARY;
			case 2:
				return Month.FEBUARY;
			case 3:
				return Month.MARCH;
			case 4:
				return Month.APRIL;
			case 5:
				return Month.MAY;
			case 6:
				return Month.JUNE;
			case 7:
				return Month.JULY;
			case 8:
				return Month.AUGUST;
			case 9:
				return Month.SEPTEMBER;
			case 10:
				return Month.OCTOBER;
			case 11:
				return Month.NOVEMBER;
			case 12:
				return Month.DECEMBER;
				
		}
		return Month.JANUARY;
	}
	
	public String toString(){
		
		return "               " + this.getCurrentMonth().name() + " " + this.currentMonthnumber + " " + getCurrentYear();
	}
	public String toWriteFile(){
		
		return "Time:" + ";month=" +this.getCurrentMonth().name() + ";year=" + this.getCurrentYear();
		
	}


	public Month getCurrentMonth() {
		return currentMonth;
	}


	public void setCurrentMonth(Month currentMonth) {
		this.currentMonth = currentMonth;
	}


	public int getCurrentYear() {
		return currentYear;
	}


	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
}
