public class Senior extends Customer{
	private double SAVINGS_INTEREST=0.08;
	private double CHECK_INTEREST=0.04;
	private double CHECK_CHARGE=0.01;//cent
	private double OVERDRAFT_PENALTY=10;//UP TO 500
	private boolean vip;
	
	
	public Senior(boolean vip){
		if(vip==true){
		double SAVINGS_INTEREST=0.1;
		double CHECK_INTEREST=0.04;
		double CHECK_CHARGE=0;//cent
		double OVERDRAFT_PENALTY=0;
		}
	}
	public double getSavingsInterest(){
		return SAVINGS_INTEREST;//gets saving interest
	}
	public double getCheckInterest(){
		return CHECK_INTEREST;//gets checking interest
	}
	public double getCheckCharge(){
		return CHECK_CHARGE;//checks charge
	}
}