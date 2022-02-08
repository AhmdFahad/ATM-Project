package main;

import java.util.Date;

public class Customer {
	//==========
	private static String loadId() {
		if (CustomerMannger.customerArray.size() == 0) {
			return "0";
		} else {
			int x = Integer
					.parseInt(CustomerMannger.customerArray.get(CustomerMannger.customerArray.size() - 1).getId());
			x++;
			return x + "";
		}
	}

	public static void giveId() {
		idGive = loadId();
	}
	
	private static void countId() {
		int id = Integer.parseInt(idGive);
		++id;
		idGive = id + "";
	}

	private static String idGive;
	
	public static void setIdGive(String idGive) {
		Customer.idGive = idGive;
	}



	private final String id;
	private String report;
	private String name, phoneNumber, password;
	private double balance;
	private Date date;


	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", balance=" + balance + ", date=" + date + "]";
	}

	public String getId() {
		return id;
	}

	public Customer(String name, String phoneNumber, String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		date = new Date();
		id = idGive;
		countId();
		report = "";
		report += "Account Create in :" + date.toString() + " | ";
		CustomerMannger.customerArray.add(this);
		System.out.println("=======================================================");
		System.out.println("  Done!! You opened Account         ");
		System.out.println("=======================================================");
		System.out.println(this.toString());
		System.out.println("=======================================================");

	}

	// to add object
	public Customer(String id, String report, String name, String phoneNumber, String password, double balance) {
		this.id = id;
		this.report = report;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.balance = balance;
		CustomerMannger.customerArray.add(this);
	}
	
	
	
	
	
	
	
private int loans;
	
	public int getLoans() {
		return loans;
	}

	public void setLoans(int loans) {
		this.loans = loans;
		setBalance(getBalance()-loans);
	}
}