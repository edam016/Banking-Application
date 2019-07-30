import java.util.Date;

public class CheckingAccount extends Account{
	
	
	private int i=0;
	Date date=new Date();
	public double makeDeposit(double moneyin){
		
		balance=balance+moneyin;
		Transaction t1 = new Transaction();
		transactions[i]=t1;
		t1.setamount(moneyin);
		transactions[i].getamount();//deposits money into account
		transactions[i].gettype();
		transactions[i].date=date;
		i++;
		return balance;
	}
	public double withdraw(double moneyout){
		//update this portion
		double balance2;//withdraws money from account
		balance2=getBalance() - moneyout;
		Transaction t2 = new Transaction();
		transactions[i]=t2;
		t2.setamount(balance2);
		transactions[i].getamount();
		transactions[i].gettype();
		transactions[i].date=date;
		return balance2;
	}
	public double addInterest(){
		//add vip
		if(customer.getvip()==false) {
		balance=balance*customer.getCheckInterest()+balance;
		}
		if (customer.getvip()==true) {
			balance=balance*0.04+balance;
		}
		Transaction t3 = new Transaction();
		transactions[i]=t3;
		t3.setamount(balance*customer.getCheckInterest());
		transactions[i].getamount();
		transactions[i].gettype();
		transactions[i].date=date;//adds interest to account depending on type
		return balance;
	}
}