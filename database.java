import java.util.*;
import java.sql.*;
public class database
{
	public static String query = "";
	static PreparedStatement statement;	
	static Connection con;
	static ResultSet resultset;
	public static  String name;
	public static int id;
	public static int choice;
	public static void main(String[] args)
	{
		 Scanner s  = new Scanner(System.in);
		try
		{	 
   			mainMenu();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

		public static void mainMenu()
		{
		  Scanner s = new Scanner(System.in);
			try
			{
			do
   			 {
       	 		System.out.println("Database CRUD");
   			 System.out.println("1.) Create Records");
        	 System.out.println("2.) Read Records");
        	 System.out.println("3.) Update Records");
        	 System.out.println("4.) Delete Records");
        	  choice = s.nextInt();
   			 
        	  	switch(choice)
        	 {
        	 	case 1:
	        	 	con  = DriverManager.getConnection("jdbc:odbc:database");
	   				System.out.print("Enter Student No.: ");
	   			    id = s.nextInt();
	   		     	s.nextLine();
	   			    System.out.print("Enter Your Name: ");
	   			    name = s.nextLine();
	   			    query = "insert into tbl_sample (ID,Student_Name) VALUES (?,?);";
	   				insert(query);
   			    break;
   			   
   			    case 2:
   			    	con  = DriverManager.getConnection("jdbc:odbc:database");
	   				System.out.print("Enter Student No. to Display: ");
	   			    id = s.nextInt();
	   			    query = "select * from tbl_sample where ID=?";
	   				read(query);
   			    break;

   			    case 3:
	   			    con  = DriverManager.getConnection("jdbc:odbc:database");
	   				System.out.print("Enter Student No. to Update: ");
	   			    id = s.nextInt();
	   		     	s.nextLine();
	   			    System.out.print("Update Name: ");
	   			    name = s.nextLine();
	   			    query = "update tbl_sample set Student_Name=? where ID=?";
	   				update(query);
	   			break;

   				case 4:
   					con  = DriverManager.getConnection("jdbc:odbc:database");
	   				System.out.print("Enter Student No. to Delete: ");
	   			    id = s.nextInt();
	   			    query = "delete from tbl_sample where ID=?";
	   				delete(query);
	   		    break;
        	 }

   			 }while(choice <= 0 || choice > 4 );
   			}catch(Exception ex)
   			{
   				ex.getMessage();
   				mainMenu();
   			}
		}

	public static void insert(String insert_query)
	{
		try
		{
			statement = con.prepareStatement(insert_query);
   			 statement.setInt(1,id);
   			 statement.setString(2,name);
   			 
   			 statement.executeUpdate();
   			 System.out.println("Insert Success!");
    		 con.close();
    		 mainMenu();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			mainMenu();
		}
	}

	public static void update(String update_query)
	{
		try
		{
			statement = con.prepareStatement(update_query);
   			 statement.setString(1,name);
   			 statement.setInt(2,id);
   			 
   			 statement.executeUpdate();
   			 System.out.println("Update Success!");
    		 con.close();
    		 mainMenu();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			mainMenu();
		}
	}

	public static void delete(String delete_query)
	{
		try
		{
			statement = con.prepareStatement(delete_query);
   			 statement.setInt(1,id);   			 
   			 statement.executeUpdate();
   			 System.out.println("Record delete Success!");
    		 con.close();
    		 mainMenu();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			mainMenu();
		}
	}

	public static void read(String read_query)
	{
		try
		{
			statement = con.prepareStatement(read_query);
   			 statement.setInt(1,id);   			 
   			// statement.executeUpdate();
   			 //System.out.println("Record delete Success!");
    		 //while
			resultset = statement.executeQuery();
			while(resultset.next())
			{
    		 System.out.print("Displaying.. "+resultset.getString(2));
			}
			 System.out.println();
			con.close();
			mainMenu();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			mainMenu();
		}
	}
}