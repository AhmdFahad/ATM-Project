package main;

import java.util.ArrayList;

public class CustomerMannger {

	public static ArrayList<Customer> customerArray = new ArrayList<Customer>();
	
	public static void addObjectToArray(String id, String report, String name, String phoneNumber, String password, double balance) {
		new Customer(id, report, name, phoneNumber, password, balance);
	}
	public static boolean cheakIdAndPassword(String id, String password) {
		try {
			return (CustomerMannger.customerArray.get(Integer.parseInt(id)).getPassword().equals(password) ? true
					: false);
		} catch (Exception e) {
			return false;
		} 
	}
	
	public static void createCustomer(String name, String phoneNumber, String password) {
		new Customer(name, phoneNumber, password);
	}
	public static void createSaveAccountCustomer(String name, String phoneNumber, String password) {
		new SaveAccountCustomer(name, phoneNumber, password);
	}

	public static void withdraw(double wihdraw, Customer customer) {
		if (wihdraw <= customer.getBalance() && wihdraw >0) {
			customer.setBalance(customer.getBalance() - wihdraw);
			customer.setReport(customer.getReport() + ("WithDraw: " + wihdraw + " | "));
			System.out.println("You Withdraw : "+wihdraw);
		} else if (wihdraw < 0) {
			Window.printWithDrawMinesErrorWindow();
		} else {
			Window.printWithdrawNoMoneyErrorWindow();

		}
	}

	public static void deposit(double deposit, Customer customer) {
		if (deposit > 0) {
			customer.setBalance(deposit + customer.getBalance());
			customer.setReport(customer.getReport() + ("Deposit : " + deposit + " | "));
			System.out.println("You deposit : "+deposit);
		} else if (deposit == 0)
			Window.printDepositZeroErrorWindow();
		else {
			Window.printDepositMinesErrorWindow();
		}
	}

	private CustomerMannger() {

	}

}
