import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;



public class mysqlConnection {
	

	public static void main(String[] args) 
	{
		try 
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","Braude");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
           // createTableCourses(conn);
            //printFlights(conn);
            UpdateFlightPrice(conn, 387, 500);
            updateAllFlights(conn);
            System.out.println();
            updateDistFlights(conn, 1000);
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}
	
	public static void printFlights(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM flights;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getInt(1)+"  " +rs.getString(2)+"  " +rs.getString(3)+"  " +rs.getInt(4)+"  " +rs.getFloat(5));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void selectFlightPrice(Connection con1,int FNum){
		Statement stmt;
		try {
			
			stmt = con1.createStatement();
			ResultSet rs= stmt.executeQuery("Select num,price From flights Where num="+ FNum );
			rs.next();
	 		System.out.println("the price is: " + rs.getInt(1)+"  " +rs.getFloat(2));
		} catch (SQLException e) {	e.printStackTrace();}
		 		
	}

	
	public static void UpdateFlightPrice(Connection con1,int FNum,float newPrice){
		Statement stmt;
		try {
			selectFlightPrice(con1, FNum);
			stmt = con1.createStatement();
			stmt.executeUpdate("update flights set price=" + newPrice + "where num=" + FNum);
			selectFlightPrice(con1, FNum);
		} catch (SQLException e) {	e.printStackTrace();}
		 		
	}
	 
	public static void updateAllFlights(Connection con1){
		Statement stmt;
		try {
			System.out.println("Old Table:");
			printFlights(con1);
			System.out.println();
			
			stmt = con1.createStatement();
			HashMap<Integer, Float> prices=new HashMap<Integer,Float>();
			ResultSet rs = stmt.executeQuery("SELECT num,price FROM flights;");
	 		
			while(rs.next())
	 		{
				
				prices.put(rs.getInt(1), rs.getFloat(2)+50);
			} 
			rs.close();
			
			Set set = prices.entrySet();
		    Iterator iterator = set.iterator();
		    PreparedStatement updatePrice = con1.prepareStatement("UPDATE flights "+"SET price = ? WHERE num = ?");
		    while(iterator.hasNext()) {
		         Map.Entry mentry = (Map.Entry)iterator.next();
		         updatePrice.setFloat(1,(float) mentry.getValue());
		         updatePrice.setInt(2,(int) mentry.getKey());
		         updatePrice.executeUpdate();
		   
		    }
			updatePrice.close();
			System.out.println("Updating Table:");
			printFlights(con1);
		} catch (SQLException e) {	e.printStackTrace();}
		 	
	}
	
	
	public static void updateDistFlights(Connection con1,int dist){
		Statement stmt;
		try {
			System.out.println("Old Table:");
			printDist(con1,dist);
			System.out.println();
			
			stmt = con1.createStatement();
			HashMap<Integer, Float> prices=new HashMap<Integer,Float>();
			ResultSet rs = stmt.executeQuery("SELECT num,price FROM flights Where distance > "+ dist);
	 		
			while(rs.next())
	 		{
				
				prices.put(rs.getInt(1), rs.getFloat(2)+50);
			} 
			rs.close();
			
			Set set = prices.entrySet();
		    Iterator iterator = set.iterator();
		    PreparedStatement updatePrice = con1.prepareStatement("UPDATE flights "+"SET price = ? WHERE num = ?");
		    while(iterator.hasNext()) {
		         Map.Entry mentry = (Map.Entry)iterator.next();
		         updatePrice.setFloat(1,(float) mentry.getValue());
		         updatePrice.setInt(2,(int) mentry.getKey());
		         updatePrice.executeUpdate();
		   
		    }
			updatePrice.close();
			System.out.println("Updating Table:");
			printDist(con1,dist);
		} catch (SQLException e) {	e.printStackTrace();}
		 	
	}
	
	public static void printDist(Connection con,int dist)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM flights Where distance > "+ dist);
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getInt(1)+"  " +rs.getString(2)+"  " +rs.getString(3)+"  " +rs.getInt(4)+"  " +rs.getFloat(5));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}
}


