public abstract class Customer{
	private int lastCustomerNumber=9999;
	private int counter=0;
	private String firstName;
	private String lastName;
	private int age;
	private int customerNumber;
	private boolean vip;


	public String toString(){
		String s= firstName+":"+lastName+":"+age;
		return s;
		//presents info through tring
	}
	
	public Customer(){
		customerNumber=lastCustomerNumber+counter;
		counter+=1;
		//constructor for customer
	}
	public boolean isequals(String firstName, String lastName, int age, int customerNumber){
		if(this.firstName==firstName && this.lastName == lastName && this.age==age && this.customerNumber==customerNumber){
			return true;
		}
		else{
			return false;
			//checks if equal
		}
	}
	public abstract double getSavingsInterest();
	public abstract double getCheckInterest();//abstract methods
	public abstract double getCheckCharge();
	public String getfirstName(){//gets firstname
		return this.firstName;
	}
	
	public void setfirstName(String s){//sets firstname
		this.firstName=s;
	}
	public String getlastName(){//gets lastname
		return this.lastName;
	}
	public int getCustomerNumber(){//gets customernumber
		return this.customerNumber;
	}
	public void setCustomerNumber(int number){
		this.customerNumber=number;//sets customernumber
	}
	public void increment(){//increments customer numb
		this.customerNumber++;
	}
	public void setlastName(String s){//sets lastname
		this.lastName=s;
	}
	public void setAge(int a){//sets age
		this.age=a;
	}
	public int getAge(){//gets age
		return this.age;
	}
	public boolean getvip(){//gets vipstatus
		return this.vip;
	}
	public void setvip(boolean vip){//sets vip status
		this.vip=vip;
	}

}