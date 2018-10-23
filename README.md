# JAVA-CRUD-ODBC
This program contain CRUD operations of the database. I used Microsoft Access Database for this project via ODBC connection. 

Before you use the program. Make it sure that you have the following setup:

-A jdk version of 1.7 (32-bit)
-Microsoft Access Database

# ODBC Configuration
If you are using Windows 7 and above, click the Windows Button and search for "ODBC Data Sources". Usually, what pops out in the search is the 32-bit version of it. 

Once that you have clicked it, in the "User DSN" tab, click the "Add" button. 

As you click that, A "Create New Data Source" window will pop-up. Go search for the MS Access driver there.
*In my case, I have used the Microsoft Access Driver (*.mdb, .*,accdb). 

Then click the "Finish" button.

After clicking the "Finish" button, An "ODBC Microsoft Access Setup" form will pop-up. Fill up the "Data Source Name".
*In my case, I named my Data Source Name as database.

After that, Click the "Select" button under the Database Category. Locate your Access file and then Click "OK".

After that you will be redirected back to "ODBC Microsoft Access Setup" Form and then Click "OK".

Finally, select your created Data Source and then Click "OK".

# Using the ODBC Connection in your Program

On your Java program, write the following code in the main method.

try
{
  Connection connect = DriverManager.getConnection("jdbc:odbc:<name_of_your_database_in_Data_Source>");
  System.out.println("Connected!");
}catch(Exception ex)
{
  ex.getMessage();
}


If the code did not generate any error, you may do the honor of filling up the codes for Database.

I'll update the docs soon. Thanks and Happy coding!
