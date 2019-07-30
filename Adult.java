public class Adult extends Customer{
	public static final double SAVINGS_INTEREST=0.03;
	public static final double CHECK_INTEREST=0.04;
	public static final double CHECK_CHARGE=0.01;//cent
	public static final double OVERDRAFT_PENALTY=10;//UP TO 500
	private int customerType=0;
	private String firstName;
	private String lastName;
	private int age;
	private int customerNumber;
	//DO OVERDRAFT
	public Adult(){
		super();//constructor
	}
	public double getSavingsInterest(){
		return SAVINGS_INTEREST;//gets saving interest
	}
	public double getCheckInterest(){
		return CHECK_INTEREST;//gets check interest
	}
	public double getCheckCharge(){
		return CHECK_CHARGE;//gets checkcharge
	}

}