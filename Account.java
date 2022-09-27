package amdocs.banking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
	private static String name;
	private static String gender;
	private static String dob;
	private static String mobile;
	private static String email;
	private static String pin;
	private static int balance;

	private static int accountNo;
	
	static Scanner sc=new Scanner(System.in);

	public static void openAccount(Statement stmt) throws SQLException{
		System.out.println(" Name: ");
		name=sc.next();
		
		System.out.println("Gender(m/f/others): ");
		gender=sc.next();
		
		System.out.println("Date of Birth (dd/mm/yyyy): ");
		dob=sc.next();
		
		System.out.println("mobile number: ");
		mobile=sc.next();
		
		System.out.println("email: ");
		email=sc.next();
		
		System.out.println("PIN/Password (3 digits): ");
		pin=sc.next();
		String save= "insert into customer(cust_name, gender , dob , mobile_no , email , pin , balance , account_no) values('"+name+"','"+gender+"', '"+dob+"','"+mobile+"','"+email+"','"+pin+"','"+balance+"',null)";
		
		try {
			ResultSet rs = stmt.executeQuery(save);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs1= stmt.executeQuery("select max(account_No) from customer");
		System.out.println('\n');
		System.out.println("Account has been generated.....");
		while(rs1.next()) {
			System.out.println("Your Account Number : " +rs1.getInt(1));
			System.out.println('\n');
		}
	    myConnection.menu(stmt);
	}

}
