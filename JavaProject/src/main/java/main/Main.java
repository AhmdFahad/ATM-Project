package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		//Customer c=new SaveAccountCustomer("Ahmed", "50044343", "4343"); 
		loadJsonFileToSystem();
		run();
	}
	
	
	
	private static Scanner scanner = new Scanner(System.in);
	private static char choose;
	private static String loginAccount;

	public static void run() {
		Customer.giveId();
		while (true) {
			Window.printFirstWindow();
			choose = scanner.next().charAt(0);
			System.out.println("you choose : " + choose);

			// ==============================
			if (choose == '1') {
				loginAccount();
			}
			// ==============================Open Account
			else if (choose == '2') {
				openAccount();
			}

			// ============================== Exit
			else if (choose == '3') {
				exit();
				break;
			}
			// =================================================
			else {
				System.out.println("Choose Corect !!!");
			}

			// ===============================
		}
	}

	public static void loginAccount() {

		if (CustomerMannger.customerArray.size() == 0) {
			Window.printLoginNoAccountProblemWindow();
			return;
		}

		Window.printLoginWindow();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String id = "";
		String passw = "";
		try {
			System.out.print("Enter ID :");
			id = in.readLine();
			System.out.print("Enter password : ");
			passw = in.readLine();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		while (true) {
			if (CustomerMannger.cheakIdAndPassword(id, passw)) {

				loginAccount = id;
				System.out.println("welcome to bank : "
						+ CustomerMannger.customerArray.get(Integer.parseInt(loginAccount)).getName());
				Window.printMainWindow();
				choose = scanner.next().charAt(0);
				if (choose == '1') {
					accountManager();
				} else if (choose == '2') {
					Atm();
				} else if (choose == '3') {
					loginAccount = null;
					break;
				} else {
					System.out.println("Choose Corect !!!");

				}

			} else {
				System.out.println("!Id or Password is inCorrect");
				break;
			}
		}

	}

	public static void Atm() {
		while (true) {
			Window.printATMWindow();
			choose = scanner.next().charAt(0);
			if (choose == '1') {
				System.out.println(
						"You have : " + CustomerMannger.customerArray.get(Integer.parseInt(loginAccount)).getBalance());
			} else if (choose == '2') {

				System.out.println("Enter withdraw ammount : ");
				try {
					CustomerMannger.withdraw(scanner.nextDouble(),
							CustomerMannger.customerArray.get(Integer.parseInt(loginAccount)));
				} catch (Exception e) {
					System.out.println("Enter Corect");
				}

			} else if (choose == '3') {
				System.out.println("Enter ammount to Deposit : ");
				try {
					CustomerMannger.deposit(scanner.nextDouble(),
							CustomerMannger.customerArray.get(Integer.parseInt(loginAccount)));
				} catch (Exception e) {
					System.out.println("Enter Corect");
				}
			} else if (choose == '4') {
				break;

			}

			else {
				System.out.println("Choose Corect !!!");
			}
		}
	}

	public static void accountManager() {
		Window.printAccountWindow();
		choose = scanner.next().charAt(0);
		if (choose == '1') {
			System.out.println(CustomerMannger.customerArray.get(Integer.parseInt(loginAccount)).getReport());
		} else if (choose == '2') {
			return;
		} else {
			System.out.println("Choose Corect !!!");
		}

	}

	public static void openAccount() {
		Window.printOpenAccountPageOneWindow();
		choose = scanner.next().charAt(0);
		if (choose == '1') {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name, phoneNumber, password;
			try {
				System.out.println("Enter the name :");
				name = in.readLine();
				System.out.println("Enter the phoneNumber:");
				phoneNumber = in.readLine();
				System.out.println("Enter the password :");
				password = in.readLine();
				CustomerMannger.createCustomer(name, phoneNumber, password);
			} catch (Exception e) {
			}

		} else if (choose == '2') {

		} else {
			System.out.println("Choose Corect !!!");

		}

	}

	public static void exit() {
		Window.printExitWindow();
		scanner.close();
		saveToJsonFile();
		System.exit(0);
	}

	public static String readDatafromeJson(String path) {
		String data = "";
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
		}
		return data;
	}

	public static void loadJsonFileToSystem() {
		StringBuilder s = new StringBuilder(readDatafromeJson("data/data.json"));
		if (s.length() == 0)
			return;
		s.deleteCharAt(0);
		s.deleteCharAt(s.length() - 1);
		String[] arr = s.toString().split("}");
		for (int i = 0; i < arr.length; i++) {
			StringBuilder x = new StringBuilder(arr[i]);
			for (int j = 0; j < arr[i].length(); j++) {
				if (x.charAt(j) == ',')
					x.deleteCharAt(j);
				if (x.charAt(j) == '{')
					break;

			}
			x.append("}");
			arr[i] = x.toString();
			arr[i] = arr[i].replace("	", "");
	        try {
				Object obj = new JSONParser().parse(arr[i]);
		        JSONObject jsonObj = (JSONObject) obj;
		        String id=(String)jsonObj.get("id");
		        String report=(String)jsonObj.get("report");
		        String name=(String)jsonObj.get("name");
		        String phoneNumber=(String)jsonObj.get("phoneNumber");
		        String password=(String)jsonObj.get("password");
		        double balance = ((Number)jsonObj.get("balance")).doubleValue();
		        CustomerMannger.addObjectToArray(id, report, name, phoneNumber, password, balance);
	        } catch (ParseException e) {
			}

		}
	}

	@SuppressWarnings({ "unchecked" })
	public static void saveToJsonFile() {
		JSONObject[] arr = new JSONObject[CustomerMannger.customerArray.size()];
		FileWriter file;
		try {
			file = new FileWriter("data/data.json");
			for (int i = 0; i < CustomerMannger.customerArray.size(); i++) {
				arr[i] = new JSONObject();
				arr[i].put("report", CustomerMannger.customerArray.get(i).getReport());
				arr[i].put("balance", CustomerMannger.customerArray.get(i).getBalance());
				arr[i].put("password", CustomerMannger.customerArray.get(i).getPassword());
				arr[i].put("phoneNumber", CustomerMannger.customerArray.get(i).getPhoneNumber());
				arr[i].put("id", CustomerMannger.customerArray.get(i).getId());
				arr[i].put("name", CustomerMannger.customerArray.get(i).getName());
				if (i == 0)
					file.write("[");
				file.write(arr[i].toJSONString());
				if (i == (CustomerMannger.customerArray.size() - 1))
					file.write("]");
				else
					file.write(",");
			}
			file.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
