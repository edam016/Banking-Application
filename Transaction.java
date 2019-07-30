import java.util.Date;

public class Transaction{
	private byte transaction;
	private String type;
	private double amount;
	private double fees;
	private String description;
	Date date=new Date();
	//not sure about date for this one
	public Transaction() {}	

	public double getamount(){
		return amount;//gets amount
	}
	public double getfees(){
		return fees;//gets fees
	}
	public String gettype(){
		return type;//gets type in string
	}
	public void setamount(double amount) {
		this.amount=amount;//sets amount
	}

	public String processTransaction(){
		if(transaction==0){
			type="deposit";
		}
		else if(transaction==1){
			type="withdraw";//process transaction description
		}
		else{
			type="added interest";
		}
		description = "Transaction Type: "+type+" Amount: "+amount+" Date:"+ date+" Fees: "+fees;
		return description;
	}
}