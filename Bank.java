/*
 * Bank.java
 *
 * Created on July 21, 2004, 1:23 AM
 */

public class Bank {
    private Account[] accounts;
    private int size=0;
    
    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;    
    private static final int SENIOR = 0;
    private static final int ADULT = 1;    
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;
    
    /** Creates a new instance of Bank */
    public Bank() {  
    	accounts = new Account[INIT_CAPACITY];
       
    }

    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public String addAccount(String customerName,int customerAge, int customerType, boolean VIP, int typeAccount){
        reallocate();
    	if(customerType==0){
        //Makes acount type in array
        Senior senior= new Senior(VIP); 
            senior.setfirstName(customerName);
            senior.setAge(customerAge);
            senior.setvip(VIP);
        
            if(typeAccount==SAVINGS) {
        	SavingsAccount savingsaccount= new SavingsAccount();
        	savingsaccount.setBalance(0);
        	savingsaccount.setCustomer(senior);
        	savingsaccount.setCustomerType(0);
        	savingsaccount.setvip(VIP);
        	savingsaccount.settypeAccount(0);
        	accounts[size]= savingsaccount;
        	size+=1;
        	return Integer.toString(savingsaccount.getlastaccountNumber());
        }
        if(typeAccount==CHECKING) {
        	CheckingAccount checkingaccount=new CheckingAccount();
        	checkingaccount.setBalance(0);
        	checkingaccount.setCustomer(senior);
        	checkingaccount.setCustomerType(0);
        	checkingaccount.setvip(VIP);
        	checkingaccount.settypeAccount(1);
        	accounts[size]= checkingaccount;
        	size+=1;
        	return Integer.toString(checkingaccount.getlastaccountNumber());
        }
  
    }
        if(customerType==1){
        Adult adult = new Adult();
        	adult.setfirstName(customerName);
            adult.setAge(customerAge);
        if(typeAccount==SAVINGS) {
            SavingsAccount savingsaccount= new SavingsAccount();
            savingsaccount.setBalance(0);
            savingsaccount.setCustomer(adult);
            savingsaccount.setCustomerType(1);
            savingsaccount.setvip(VIP);
            savingsaccount.settypeAccount(0);
            accounts[size]= savingsaccount;
        	size+=1;
            return Integer.toString(savingsaccount.getlastaccountNumber());
            }
        if(typeAccount==CHECKING) {
            CheckingAccount checkingaccount=new CheckingAccount();
            checkingaccount.setBalance(0);
            checkingaccount.setCustomer(adult);
            checkingaccount.setCustomerType(1);
            checkingaccount.setvip(VIP);
            checkingaccount.settypeAccount(1);
            accounts[size]= checkingaccount;
        	size+=1;
            return Integer.toString(checkingaccount.getlastaccountNumber());
            }    
        }
        if(customerType==2){
        Student student = new Student();
        	student.setfirstName(customerName);
            student.setAge(customerAge);
            
        if(typeAccount==SAVINGS) {
            SavingsAccount savingsaccount= new SavingsAccount();
            savingsaccount.setBalance(0);
            savingsaccount.setCustomer(student);
            savingsaccount.setCustomerType(2);
            savingsaccount.setvip(VIP);
            savingsaccount.settypeAccount(0);
            accounts[size]= savingsaccount;
        	size+=1;
            return Integer.toString(savingsaccount.getlastaccountNumber());
                }
        if(typeAccount==CHECKING) {
        	CheckingAccount checkingaccount=new CheckingAccount();
            checkingaccount.setBalance(0);
            checkingaccount.setCustomer(student);
            checkingaccount.setCustomerType(2);
            checkingaccount.setvip(VIP);
            checkingaccount.settypeAccount(1);
            accounts[size]=checkingaccount;
        	size+=1;
            return Integer.toString(checkingaccount.getlastaccountNumber());
                }
        }
       return "YEET";
} 
    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    
     public String makeDeposit(String accountNumber, double amount){
    	 if(find(accountNumber)==-1){
    		 String s = "Account not in system";
    		 return s;
    	 }
    	 int index=find(accountNumber);
    	 double temp=accounts[index].getBalance();
    	 double finalnumb = temp+amount;
    	 double newamount=accounts[index].makeDeposit(amount);//HOW TO ACCESS SAVINGSACCOUNT FROM ACCOUNT AND IF ITS POSSIBLE SO I CAN USE DEPOSIT
    	 accounts[index].setBalance(finalnumb);
    	 return Double.toString(newamount);
     }//deposits money 
    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     * ADD ADD INTEREST SOMEWHERE, NOT SURE WHERE THOUGH
     */    
     public String makeWithdrawal(String accountNumber, double amount){
    	 int index=find(accountNumber);//takes money out of account and if from checking adds charge
    	 double initial=accounts[index].getBalance();
    	 double newbalance=accounts[index].withdraw(amount);
    	 if(accounts[index].gettypeAccount()==1) {
    	 newbalance=accounts[index].customer.getCheckCharge()+newbalance;
    	 }
    	 accounts[index].setBalance(newbalance);
    	 if(find(accountNumber)==-1){
    		 String s = "Account not found in system";
    		 return s;
    	 }
    	  
    	 if(accounts[index].customer.getSavingsInterest()==0.07){
    		 if(newbalance < 0){
    			 String s = "You cannot overdraft more than u have";
    			 accounts[index].setBalance(initial);
    			 return s;
    		 }
    	 }
    	 if (newbalance<-500){
    		 accounts[index].setBalance(initial);
    		 String s = "You can't withdraw more than 500 over your budget";
    		 return s;
    	 }
    	 
    	 if(newbalance<0) {
    		 if (accounts[index].customer.getSavingsInterest()==0.03){
 				if(newbalance>-500){
 					accounts[index].setBalance(newbalance-25);
 				}
 			}
 			}
 			if (accounts[index].getvip()==true){
 				if(newbalance>=-100){
 					accounts[index].setBalance(newbalance);
 				}
 				if(accounts[index].getvip()==true){
 					accounts[index].setBalance(newbalance-5);
 				}
 			}
 			if(accounts[index].customer.getSavingsInterest()==0.08 && accounts[index].getvip()==false){
 				accounts[index].setBalance(newbalance-10);
 	}
    	 return Double.toString(accounts[index].getBalance());
}
         //ASK FOR VIP
    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */  
     public String getAccount(String accountNumber){
        int index = find(accountNumber);//gets account info
        if (find(accountNumber)==-1) {
        	String s="Account not found in system";
        			return s;
        }
        return(accounts[index].toString());
    }
    
    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
      */ 
    private int find(String accountNumber){
    	for(int k=0;k<size;k++){//finds account using accountnumber
    		if (Integer.parseInt(accountNumber)==(accounts[k].getlastaccountNumber())) {
    			return k;
    		}
    	}
    	return -1;
    }
    //CHECK THIS PART ASK WHY IT DOESNT WORK

 /***********************************************************************

    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    
    private void reallocate() {
    	if(size==accounts.length) {
        Account[] accounttemp;
        accounttemp=new Account[accounts.length];
        for(int j=0;j<=accounts.length-1;j++){
            accounttemp[j]=accounts[j];
        }//checks if there is space in array and doubles it
        int length=accounts.length;
        accounts= new Account[length*2];
        for(int k=0;k<=accounts.length-1;k++){
        	 if (accounttemp[k]==null) {
             	break;
             }
        	accounts[k]=accounttemp[k];
           
        }
    }
    }
   
    public String addInterest(String accountNumber) {
	   	 if(find(accountNumber)==-1){
			 String s = "Account not found in system";
			 return s;
		 }//adds interest to account depending on the accoutnt ype
		 int index=find(accountNumber);
		 double newbalance=accounts[index].addInterest();
		 return Double.toString(newbalance);
	     }
}
