package demodabs;
import java.sql.*;


public class curdopra {

	 public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/demodb";  
	        String user = "root";
	        String password = "123456";

	        Connection con = null;
	        PreparedStatement pstmtInsert = null;
	        PreparedStatement pstmtSelect = null;
	        PreparedStatement pstmtUpdate = null;
	        PreparedStatement pstmtDelete = null;
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to database");

	            String insertQuery = "INSERT INTO stud (id, name, email) VALUES (?, ?, ?)";
	            pstmtInsert = con.prepareStatement(insertQuery);
	            pstmtInsert.setInt(1, 1); //
	            pstmtInsert.setString(2, "Ganesh");
	            pstmtInsert.setString(3, "g@gmail.com");
	            int rowsInserted = pstmtInsert.executeUpdate();
	            System.out.println("Inserted rows: " + rowsInserted);

	            String selectQuery = "SELECT * FROM stud";
	            pstmtSelect = con.prepareStatement(selectQuery);
	            rs = pstmtSelect.executeQuery();
	            System.out.println("Stud Table Data:");
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id")
	                        + " | Name: " + rs.getString("name")
	                        + " | Email: " + rs.getString("email"));
	            }

	            String updateQuery = "UPDATE stud SET email = ? WHERE name = ?";
	            pstmtUpdate = con.prepareStatement(updateQuery);
	            pstmtUpdate.setString(1, "ganesh.updated@gmail.com");
	            pstmtUpdate.setString(2, "Ganesh");
	            int rowsUpdated = pstmtUpdate.executeUpdate();
	            System.out.println("Updated rows: " + rowsUpdated);

	            String deleteQuery = "DELETE FROM stud WHERE name = ?";
	            pstmtDelete = con.prepareStatement(deleteQuery);
	            pstmtDelete.setString(1, "Ganesh");
	            int rowsDeleted = pstmtDelete.executeUpdate();
	            System.out.println("Deleted rows: " + rowsDeleted);

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } 
	        finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmtInsert != null) pstmtInsert.close();
	                if (pstmtSelect != null) pstmtSelect.close();
	                if (pstmtUpdate != null) pstmtUpdate.close();
	                if (pstmtDelete != null) pstmtDelete.close();
	                if (con != null) con.close();
	                System.out.println("Resources closed!");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	 
	    }

}
