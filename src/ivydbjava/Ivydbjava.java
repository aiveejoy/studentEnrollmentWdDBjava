/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivydbjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2ndyrGroupC
 */
public class Ivydbjava {

//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/devilleres";
//
//    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "";

    public static void main(String[] args) throws SQLException {
        paccounts acc=new paccounts();
        menu m=new menu();
        acc.connectdb();
        m.start();

        
        
//        .....................................................
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            String uName=
//            sql = "UPDATE accounts set USERNAME='AIVEE' WHERE ID=2";
//            stmt.executeUpdate(sql);
//
//            //STEP 5: Extract data from result set
////      while(rs.next()){
////         //Retrieve by column name
////         int id  = rs.getInt("id");
////         String first = rs.getString("username");
////         String last = rs.getString("email");
////
////         //Display values
////         System.out.print("ID: " + id);
////         System.out.print(", username: " + first);
////         S
//                conn.close();ystem.out.println(", email: " + last);
////      }
//            //STEP 6: Clean-up environment
////      rs.close();
//            stmt.close();
//            conn.close();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } //Handle errors for JDBC
//        finally {
//            //finally block used to close resources
//            if (stmt != null) {
//                stmt.close();
//            } // nothing we can do
//            if (conn != null) {
//            } //end finally try
//        }//end try
//        System.out.println("Goodbye!");
    }//end main

}
