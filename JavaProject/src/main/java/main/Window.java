package main;
/** 
 * A class have all text will print it in console
 * */
public class Window {
	public static void printFirstWindow() {
		System.out.println("|===========================================|");
		System.out.println("|              Welcome to Bank              |");
		System.out.println("|===========================================|");
		System.out.println("|1)login into account                       |");
		System.out.println("|2)open Account                             |");
		System.out.println("|3)Exit System                              |");
		System.out.println("|===========================================|\n");
		System.out.println(">");
	}
	
	public static void printLoginWindow() {
		System.out.println("|===========================================|");
		System.out.println("|                   login                   |");
		System.out.println("|===========================================|");
		loadCustomer();
		System.out.println("Choose Account by id !");
		System.out.println(">");
	}

	public static void printOpenAccountPageOneWindow() {
		System.out.println("|===========================================|");
		System.out.println("|               Open Account                |");
		System.out.println("|===========================================|");
		System.out.println("|We need your name, phoneNumber and password|");
		System.out.println("|===========================================|");
		System.out.println("|1)continue                                 |");
		System.out.println("|2)return                                   |");
		System.out.println(">");
	}

	public static void printOpenAccountPageTwoWindow() {
		System.out.println("|===========================================|");
		System.out.println("|               Open Account                |");
		System.out.println("|===========================================|");
		System.out.println("| Enter Your Name And Phone Number And your |" + "\npassword");

	}

	public static void printMainWindow() {
		System.out.println("|===========================================|");
		System.out.println("|                    Bank                   |");
		System.out.println("|===========================================|");
		System.out.println("|1)to account Mangger                       |");
		System.out.println("|2)to ATM(Automated Teller Machine)         |");
		System.out.println("|3)Exit Account !                           |");
		System.out.println("|===========================================|\n");
		System.out.println(">");
	}

	public static void printAccountWindow() {
		System.out.println("|===========================================|");
		System.out.println("|               Account Mangger             |");
		System.out.println("|===========================================|");
		System.out.println("|1)Report                                   |");
		System.out.println("|2)return                                   |");
		System.out.println("|===========================================|\n");
		System.out.println(">");
	}

	public static void printLoansWindow() {
		System.out.println("|===========================================|");
		System.out.println("|               Loans Mangger               |");
		System.out.println("|===========================================|");
		System.out.println("|1)Take loans                               |");
		System.out.println("|2)return                                   |");
		System.out.println("|===========================================|\n");
		System.out.println(">");
	}

	public static void printATMWindow() {
		System.out.println("|===========================================|");
		System.out.println("|                     ATM                   |");
		System.out.println("|===========================================|");
		System.out.println("|1)Balance                                  |");
		System.out.println("|2)Withdraw                                 |");
		System.out.println("|3)Deposit                                  |");
		System.out.println("|4)return                                   |");
		System.out.println("|===========================================|\n");
		System.out.println(">");
	}

	// load
	//
	private static void loadCustomer() {
		for (int i = 0; i < CustomerMannger.customerArray.size(); i++) {
			System.out.println("| ID : " + CustomerMannger.customerArray.get(i).getId()+", Name : "+CustomerMannger.customerArray.get(i).getName());
		}
	}
	

	// pop out
	public static void printLoginNoAccountProblemWindow() {
		System.out.println("|===========================================|");
		System.out.println("|     There is no account in the system     |");
		System.out.println("|===========================================|");
	}

	public static void printExitWindow() {
		System.out.println("|===========================================|");
		System.out.println("|        Thank you for usnig a bank         |");
		System.out.println("|===========================================|");
	}

	public static void printDepositMinesErrorWindow() {
		System.out.println("|===========================================|");
		System.out.println("|    You can Not Deposit a minus number     |");
		System.out.println("|===========================================|");
	}

	public static void printDepositZeroErrorWindow() {
		System.out.println("|===========================================|");
		System.out.println("|          You can Not Deposit Zero         |");
		System.out.println("|===========================================|");
	}

	public static void printWithdrawNoMoneyErrorWindow() {
		System.out.println("|===========================================|");
		System.out.println("|            You dont have money            |");
		System.out.println("|===========================================|");
	}

	public static void printWithDrawMinesErrorWindow() {
		System.out.println("|===========================================|");
		System.out.println("|          Withdraw without Minus           |");
		System.out.println("|===========================================|");
	}
	public static void printWrongPasswordErrorWindow() {
		System.out.println("|===========================================|");
		System.out.println("|        ID dont match with password        |");
		System.out.println("|===========================================|");
	}
	
	
	private Window() {
		
	}
}
