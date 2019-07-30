public class Student extends Customer{
	private String firstName;
	private String lastName;
	private int age;
	private int customerNumber;
	private int customerType=1;
	public static final double SAVINGS_INTEREST=0.07;
	public static final double CHECK_INTEREST=0.03;
	public static final double CHECK_CHARGE=0.02;//cent
	//if student, cannot get overdraft penalty

	public Student(){
		super();
	}
	public double getSavingsInterest(){
		return SAVINGS_INTEREST;//get saving interest
	}
	public double getCheckInterest(){
		return CHECK_INTEREST;//get check interest
	}
	public double getCheckCharge(){
		return CHECK_CHARGE;//get chekc charge
	}
}
