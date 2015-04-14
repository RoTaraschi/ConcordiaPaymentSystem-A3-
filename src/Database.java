
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;




 class Database implements Serializable
 {
	
	//Attributes
	private ArrayList<Person> database = new ArrayList<Person>();
	private static final long serialVersionUID = 6346004521206723327L;
	
	//Constructors
	public Database()
	{}
	
	public Database(ArrayList<Person> importDatabase)
	{
		this.database = importDatabase;
	}
	
//------------------------------------------METHODS
	
	
	
//-----------------SERIALIZATION
	 //Writes to TIME.bat serialized file
	 public void writeToSerializedFile(File file, Database database)
	 {
		    try 
		    {
		        ObjectOutputStream output = new ObjectOutputStream(
		                                    new FileOutputStream(file));
		        output.writeObject(database);
		        
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	 }
	
	 
	 //Reads from Time.bat serialized file
	 public Database readFromSerializedFile(File file) 
	 {
		    Database dImport = null;
		    try 
		    {
		        ObjectInputStream input = new ObjectInputStream(
		                                  new FileInputStream("ConcordiaSystem999.bat"));
		      dImport = (Database) input.readObject();    
		      
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		       e.printStackTrace();
		    }
		    return dImport;
	}
//---------------END OF SERIALIZATION	
	 
	 
		public void MoneyPayout(){
			
			double taPayout = 0;
			double facultyPayout = 0;
			double staffPayout = 0;
			
			for(int i = 0; i < this.getDatabaseSize(); i++)
			{
				
				if(this.getDatabase().get(i).getClass().equals(Staff.class)){
					
					staffPayout += this.database.get(i).showMonthPay();
					
					
				}
				
				if(this.getDatabase().get(i).getClass().equals(Faculty.class)){
					
					facultyPayout += this.database.get(i).showMonthPay();
				}
				
				if(this.database.get(i).getClass().equals(Student.class)){
					
						taPayout += this.database.get(i).showMonthPay();
				}			
			}
			
			System.out.println("Payouts For Faculty is : $" + facultyPayout + "\n" +
								"Payouts For Staff is : $" + staffPayout + "\n" +
								"Payout For TA is : $" + taPayout		);
		
		}
	 
	 
	 
	 
	 
	 
	 
	
		public void searchByID(int searchID){
			
			for(int i = 0; i < this.getDatabaseSize(); i++)
			{
				
				if(this.database.get(i).getID()== searchID)
				{
				
					System.out.println(this.database.get(i).toString());
					DatabaseEditMenuOfPersoni(i);
					
				}
				
				
			}
			
			System.out.println("\n\nNo person with that ID found.\n");
			
		}
	 
	 
	 
	 
	 //Shows a list of everyone, how much they are paid this month, and the total paid out by Concordia
	 public void showAllPaystubs()
	 {
		 String pattern = "$##0.00";
		 DecimalFormat decimalFormat = new DecimalFormat(pattern);

		double totalForMonth =0;
		 
		 System.out.println();
		 for(int i = 0; i < this.getDatabaseSize(); i++)
		 {
			 
			 String format = decimalFormat.format(this.database.get(i).showMonthPay());
			 totalForMonth = totalForMonth + this.database.get(i).showMonthPay();
			 System.out.printf( (i+1) + "%30s %30s %n",this.database.get(i).getName(),format);
			
			
		 }
		 String total = decimalFormat.format(totalForMonth);
		 System.out.printf("\n %30s %29s %n", "TOTAL: " , total + "\n\n");
	 }
	
	
	
	//This is the method that pays everyone accordingly when the calender is moved forward
	public void payAllOneMonth()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			if(this.database.get(i).getClass() == Student.class)
			{
				this.database.get(i).setAccountBalance(((Student) this.database.get(i)).getMonthPay());
			}
			
			if(this.database.get(i).getClass() == Faculty.class)
			{
				this.database.get(i).setAccountBalance(((Faculty) this.database.get(i)).getMonthPay());
			}
			
			if(this.database.get(i).getClass() == Staff.class)
			{
			this.database.get(i).setAccountBalance(((Staff) this.database.get(i)).getMonthPay());
			}
		}
	}
	
	
	
	//adds a single person to the database
	public void addToDatabase(Person newPerson)
	{
		this.database.add(newPerson);
	}
	
	
	
	
	public ArrayList<Person> getDatabase() 
	{
		return this.database;
	}
	
	
//----------------------------------ALL VARIOUS LISTS	
	
	
	//prints the entire database
	public void showAll()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
		System.out.println(this.database.get(i).toString()); //The Magic!
		}
	}
	
	public void showAllCurrentStudents()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Student.class){
				if(((Student) this.database.get(i)).getStatus() == Student.Status.CURRENT)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
			
		}
	}
	
	public void showAllAlumniStudents()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Student.class){
				if(((Student) this.database.get(i)).getStatus() == Student.Status.ALUMNI)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
		}
	}
	
	public void showPermanentFaculty()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Faculty.class){
				if(((Faculty) this.database.get(i)).getFacultyContract() == Faculty.FacultyContract.PERMANENT)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
		}
	}
	
	public void showPartTimeFaculty()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Faculty.class){
				if(((Faculty) this.database.get(i)).getFacultyContract() == Faculty.FacultyContract.PART_TIME)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
		}
	}
	
	
	public void showPartStaff()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Staff.class){
				if(((Staff) this.database.get(i)).getStaffContract() == Staff.StaffContract.PART_TIME)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
		}
	}
	
	public void showPermanentStaff()
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getClass() == Staff.class){
				if(((Staff) this.database.get(i)).getStaffContract() == Staff.StaffContract.PERMANENT)
				{
					System.out.println(this.database.get(i).toString());
				}
			}
		}
	}
//---------------------------END OF LISTS
	

	
	//returns the number of entries in the database.
	public int getDatabaseSize()
	{
		return this.database.size();
	}
	
	
	//Checks ID to make sure they are unique
	public boolean checkID(int ID)
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			if (this.database.get(i).getID() == ID)
			{
				System.out.println("\nDuplicate ID! Person not added to Database. Please Try Again.\n");
				return false;
			}
		}
		return true;
	}
	
	
//--------------------------INDIVIDUAL SEARCH (which becomes the editor/deleter)
	
	
	
	public void searchByName(String searchParam)
	{
		for(int i = 0; i < this.getDatabaseSize(); i++)
		{
			
			if(this.database.get(i).getName().indexOf(searchParam) >= 0)
			{
				System.out.println(this.database.get(i).toString()); 	
				DatabaseEditMenuOfPersoni(i);
			}
		}
	}
	
	
	
	private void DatabaseEditMenuOfPersoni(int i){
				Menu.editMenu();
				
				int editMenuChoice;
				int editTypeChoice = 0;
			
				editMenuChoice = Edit.getScanner().nextInt();
				
				
				//handles deletion
				if(editMenuChoice == 2)
				{
					this.database.remove(i);
				}
				
//--------------------------------EDITORS-----------------------//
				
				//STUDENT EDITOR
				if(editMenuChoice == 1)
				{
					
					if(this.database.get(i).getClass() == Student.class)
					{
						Menu.editStudentMenu();
						
						editTypeChoice = Edit.getScanner().nextInt();
						
						switch(editTypeChoice)
						{
						case 1: this.database.get(i).setName();break;
						case 2: ((Student) this.database.get(i)).setStatus();break;		
						case 3: ((Student) this.database.get(i)).setTAStatus();break;
						case 4: ((Student) this.database.get(i)).setContractLength();break;
						case 5: ((Student)this.database.get(i)).setPayRate();break;
						case 6: ((Student)this.database.get(i)).setHours();break;
						default: break;
						}
					}
					
					
/////////--------------FACULTY EDITOR
					if(this.database.get(i).getClass() == Faculty.class)
					{
						Menu.editFacultyMenu();
						
						editTypeChoice = Edit.getScanner().nextInt();
						
						switch(editTypeChoice)
						{
						case 1: this.database.get(i).setName();break;
						case 2: ((Faculty) this.database.get(i)).setFacultyContract();break;		
						case 3: ((Faculty) this.database.get(i)).setNumOfCourses();break;
						case 4: ((Faculty) this.database.get(i)).setPayRate();break;	
						case 5: ((Faculty) this.database.get(i)).setContractLength();break;
						//case 6: ((Student)this.database.get(i)).setHours();break;
						default: break;
						}
					}
					
					
////-------------------STAFF EDITOR
					if(this.database.get(i).getClass() == Staff.class)
					{
						Menu.editStaffMenu();
						
						editTypeChoice = Edit.getScanner().nextInt();
						
						switch(editTypeChoice)
						{
						case 1: this.database.get(i).setName();break;
						case 2: ((Staff) this.database.get(i)).setCommission();break;
						case 3: ((Staff) this.database.get(i)).setPayRate();break;
						
						//Should add more editing here.
//						case 4: ((Faculty) this.database.get(i)).setPayRate();break;	
//						case 5: ((Faculty) this.database.get(i)).setContractLength();break;
//						case 6: ((Student)this.database.get(i)).setHours();break;
						default: break;
						}
					}
					

				}
				
//------------------------------END OF EDITORS---------------//	
			}
		

}
