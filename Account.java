public abstract class Account{
	Customer customer;
	double balance;
	int age;
	boolean vip;
	String firstName;
	public static int accountNumber=9999;
	public int lastaccountNumber;
	private int customerTYPE;
	private int typeAccount;
	
	private Customer customerType;
	Transaction [] transactions; 
	Transaction [] transtemp;
	public static final int INITSIZE=25;
	public Customer customerType() {
		return this.customerType;//returns customer type through type customer
	}
	public double getBalance(){
		return this.balance;//gets balance
	}
	public int getAge() {
		return this.age;//sets age
	}
	public int gettypeAccount() {
		return this.typeAccount;//returns type account
	}
	public void settypeAccount(int typeaccount) {
		this.typeAccount=typeaccount;//sets typeaccount
	}
	public String getfirstName() {
		return this.firstName;//returns firstname
	}
	public void setBalance(double v){
		this.balance=v;//sets balane
	}
	public void setvip(boolean vip) {
		this.vip=vip;//sets vip status
	}
	public boolean getvip() {
		return this.vip;//returns vip status
	}
	public Customer getCustomer(){//gets customer type
		return customer;
	}
	public int getlastaccountNumber(){
		return this.lastaccountNumber;//returns last account number
	}
	public Account(){
		transactions=new Transaction[INITSIZE];
		lastaccountNumber=accountNumber;
		accountNumber++;//cosntructor for account
	}
	public void reallocate(){
		for (int x=0;x<transactions.length-1; x++)
		    	if (x==transactions.length-1) {
					transtemp=new Transaction[transactions.length];
					for(int i=0; i<transactions.length-1;i++){
						transtemp[i]=transactions[i];
					}//checks if transactions are full and doubles it if full
					transactions=new Transaction[transactions.length*2];
					for(int i=0;i<transtemp.length-1;i++){
						transactions[i]=transtemp[i];
				//move tempbackto trans
		}
		    	}
	}
	public String toString(){
		if(getCustomerTYPE()==0) {
		String s="Name: "+customer.getfirstName()+" Customer Type: Senior"+" Balance:"+ balance+" Account Number:"+getlastaccountNumber();
		return s;
		}
		if(getCustomerTYPE()==1) {
			String s="Name: "+customer.getfirstName()+" Customer Type: Adult"+" Balance:"+ balance+" Account Number:"+getlastaccountNumber();
			return s;	
		}
		if(getCustomerTYPE()==2) {
			String s="Name: "+customer.getfirstName()+" Customer Type: Student"+" Balance:"+ balance+" Account Number:"+getlastaccountNumber();
			return s;
		}//returns description of customer
		return "";
	}
	public void setCustomer(Customer c){//set customer type
		this.customer=c;
	}
	public void setCustomerType(int x) {
		this.customerTYPE=x;//set customer type through int
	}
	public int getCustomerTYPE() {
		return this.customerTYPE;//gets customertype
	}
	
	public abstract double makeDeposit(double amount);
	public abstract double withdraw(double moneyin);//abstract methods
	public abstract double addInterest();
}