import java.util.Date;

public class SavingsAccount extends Account{
	
	
	private int i=0;
	Date date=new Date();
	int customerType;
	public double makeDeposit(double moneyin){
		
		balance=balance+moneyin;
		Transaction t1 = new Transaction();
		transactions[i]=t1;
		t1.setamount(moneyin);
		transactions[i].getamount();
		transactions[i].gettype();
		transactions[i].date=date;//makes deposit
		i++;
		return balance;
	
	}
	public double withdraw(double moneyout){
		//update this portion
		double balance2;
		balance2=getBalance() - moneyout;
		Transaction t2 = new Transaction();
		transactions[i]=t2;
		t2.setamount(balance2);
		transactions[i].getamount();
		transactions[i].gettype();
		transactions[i].date=date;//withdraws money from account index and stores in transaction
		return balance2;
	}
	public double addInterest(){
		
		//fix interest for vip
		
		if(customer.getvip()==false) {
			balance=balance*customer.getSavingsInterest()+balance;
			}
			if (customer.getvip()==true) {
				balance=balance*0.1+balance;
			}
		
		Transaction t3 = new Transaction();
	
		transactions[i]=t3;
		t3.setamount(balance*customer.getSavingsInterest());
		transactions[i].getamount();
		transactions[i].gettype();//adds interest in account index and stores in transaction
		transactions[i].date=date;
		return balance;
	}
}