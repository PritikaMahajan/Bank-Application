package amdocs.banking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operation {
	static Scanner sc= new Scanner(System.in);
	private static int withdraw;
	private static int balance;
	 public static void Login(Statement stmt) throws SQLException{
		 System.out.print("Account number: ");
		 String account=sc.next();
		 
		 System.out.println("PIN/Password: ");
		 String pass=sc.next();
		 ResultSet rs=stmt.executeQuery("select * from customer where account_no= '"+account+"' and pin='"+pass+"' ");
		 if(rs.next()) {
			 System.out.println("login Successful");
			 menu2(stmt,account);
					 
		 }
		 else {
			 System.out.println("invalid username or password");
			 System.out.println("try again");
			 myConnection.menu(stmt);
		 }
	 }
	 public static void menu2(Statement stmt,String account) throws SQLException{
		 System.out.println("1. withdraw money");
		 System.out.println("2. deposit money");
		 System.out.println("3. view balance");
		 System.out.println("4. delete account");
		 System.out.println("5. back");
		 System.out.println("6. exit");
		 
		 System.out.println("enter your choice: ");
		 int choice=sc.nextInt();
		 
		 switch(choice) {
		 case 1:
			 System.out.print("Enter money to be withdrawn: ");
			 withdraw = sc.nextInt();
			 if(balance>=withdraw) {
				 balance=balance-withdraw;
				 System.out.println("please collect your money");
			 }
			 else {
				 System.out.println("insufficient balance");
			 }
			 menu2(stmt,account);
			 break;
		 case 2:
			 System.out.println("enter amount to be deposited: ");
			 int deposit=sc.nextInt();
			 balance=balance+deposit;
			 System.out.println("Your money has been successfully deposited");
			 menu2(stmt,account);
			 break;
			 
		 case 3:
			 System.out.println(" balance: "+balance);
			 menu2(stmt,account);
			
			 break;
		 case 4:
			 System.out.println("Delete an Account: ");
			 System.out.println("enter account number which you want to delete: ");
			 account=sc.next();
			 System.out.println("enter PIN: ");
			 String pass = sc.next();
			 try {
				 stmt.executeUpdate("delete from customer where account_no='"+account+"' and pin='"+pass+"' ");
				 System.out.println("Account deactivated");
				 
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
			 myConnection.menu(stmt);
			 break;
			 
		 case 5:
			 myConnection.menu(stmt);
			 
		 case 6:
			 System.exit(0);
		 default:
			System.out.println("enter valid choice");
			menu2(stmt,account);
		 }
		 System.out.println(".....THANKYOU.....");
		 			 
			 
		 }

}
