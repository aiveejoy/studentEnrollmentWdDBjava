package ivydbjava;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 2ndyrGroupC
 */
public class paccounts {

    private String Uname;
    private String Pass;
    Scanner scan = new Scanner(System.in);
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/devilleres";
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;

    public paccounts() {
    }

    public paccounts(String Uname, String Pass) {
        this.Uname = Uname;
        this.Pass = Pass;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String Uname) {
        this.Uname = Uname;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void connectdb() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(paccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createAccounts() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println(".... Personal Account Form ....");
        try {
            System.out.print("USERNAME: ");
            Uname = scan.next();

            System.out.print("PASSWORD: ");
            Pass = scan.next();

            while (Pass.length() < 8) {
                System.out.println("Password less than 8, please re-enter.");
                System.out.println(" Password: ");
                Pass = scan.next();
            }

            System.out.print("CONFIRM PASSWORD: ");
            String finalPass = scan.next();

            while (!Pass.matches(finalPass)) {
                System.out.println("---------------> ERROR DETECTED!!! :( \n----> PASSWORD MISMATCH <----");
                System.out.print("CONFIRM PASSWORD: ");
                finalPass = scan.next();
            }
            if (Pass.matches(finalPass)) {
                Pass = finalPass;
                System.out.println("---------------> Information SAVED!!!! :)");
                try {
                    //STEP 4: Execute a query
//                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "INSERT INTO `accounts`(`username`, `password`) VALUES ('" + Uname + "','" + Pass + "')";
                    stmt.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new IOException("wrong");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void updateAccount() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.print("ID: ");
        int ID = scan.nextInt();
        System.out.print("New Username: ");
        String Nuname = scan.next();
        System.out.print("New Password: ");
        String Npass = scan.next();
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE `accounts` SET `username`='" + Nuname + "',`password`='" + Npass + "' WHERE id=" + ID;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
        System.out.println("---------------> Account UPDATED!!!! :)");
    }

    public void retrieveAllAcc() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("********-- List of Accounts --********");

        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM accounts";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("");
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String first = rs.getString("username");
                String last = rs.getString("password");
                //Display values
                System.out.print(id);
                System.out.print("\t\t" + first);
                System.out.println("\t\t" + last);
            }
        } catch (Exception e) {
        }
    }

}
