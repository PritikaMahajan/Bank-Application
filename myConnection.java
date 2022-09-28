package amdocs.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class myConnection {

	public static void main(String[] args) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
				String username="scott";
				String password="tiger";
				
				Connection con=DriverManager.getConnection(url, username, password);
				    System.out.println("CONNECTION CREATED SUCCESSFULLY");
				    Statement stmt=con.createStatement();
				    menu(stmt);
				    }
			catch(Exception e) {
				e.printStackTrace();
			}
		}


		public static void menu(Statement stmt) throws SQLException{
			System.out.println("....BANKING SYSTEM....");
			System.out.println("1. login");
			System.out.println("2. create account/sign up");
			System.out.println("3. exit");
			
			System.out.print("enter your choice: ");
		
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				Operation.Login(stmt);
				break;
			case 2:
			    Account.openAccount(stmt);
			    break;
			case 3:
				System.exit(0);
		    default:
		    	System.out.println("enter valid choice ");
			menu(stmt);
			}
		

	}

}
