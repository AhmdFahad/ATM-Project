package main;

public class SaveAccountCustomer extends Customer{
	private int loans;
	
	public int getLoans() {
		return loans;
	}

	public void setLoans(int loans) {
		this.loans = loans;
		setBalance(getBalance()-loans);
	}
	public SaveAccountCustomer(String name, String phoneNumber, String password) {
		super(name, phoneNumber, password);
	}

}
