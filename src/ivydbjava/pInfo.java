package ivydbjava;

import static ivydbjava.pSched.DB_URL;
import ivydbjava.paccounts;
import static ivydbjava.paccounts.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 2ndyrGroupC
 */
public class pInfo {

    paccounts Pacc = new paccounts();
    private String fname;
    private String lname;
    private int age;
    private int Fk;
    Scanner scan = new Scanner(System.in);
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/devilleres";
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;

    public pInfo() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void createPinfo() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("--------> Personal Information Form <--------");
        System.out.print("Firstname: ");
        fname = scan.next();
        System.out.print("Lastname: ");
        lname = scan.next();
        System.out.print("Age: ");
        age = scan.nextInt();
        try {
            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String Nsql;
            Nsql = "SELECT MAX(id) FROM accounts";
            ResultSet rs = stmt.executeQuery(Nsql);
            while (rs.next()) {
                //Retrieve by column name
                Fk = rs.getInt("MAX(id)");
            }
            String sql;
            sql = "INSERT INTO `personalinformation`(`accID`, `name`, `lastname`, `age`) VALUES ('" + Fk + "','" + fname + "','" + lname + "','" + age + "')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------------> Information SAVED!!!! :)");
    }

    public void updatepInfo() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.print("Account ID: ");
        int ID = scan.nextInt();

        System.out.print("New name: ");
        String Nname = scan.next();

        System.out.print("New lastname: ");
        String Nlname = scan.next();

        System.out.print("New age: ");
        int Nage = scan.nextInt();

        try {
            stmt = conn.createStatement();
            String another = "Select * from personalinformation where accID=" + ID;
            ResultSet rs = stmt.executeQuery(another);
            if (rs.next()) {
                String sql;
                sql = "UPDATE `personalinformation` SET `name`='" + Nname + "',`lastname`='" + Nlname + "',`age`='" + Nage + "' WHERE accID=" + ID;
                stmt.executeUpdate(sql);
            } else {
                String anotherSql="INSERT INTO `personalinformation`(`accID`, `name`, `lastname`, `age`) VALUES ('" + ID + "','" + Nname + "','" + Nlname + "','" + Nage + "')";
                stmt.executeUpdate(anotherSql);
            }

        } catch (Exception e) {
        }
        System.out.println("---------------> Information UPDATED!!!! :)");
    }

    public void retrieveAllpInfo() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("********-- List of Personal Information --********");

        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM personalinformation";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("");
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int accid = rs.getInt("accID");
                String first = rs.getString("name");
                String last = rs.getString("lastname");
                int age = rs.getInt("age");
                //Display values
                System.out.println(id+"\t" + accid+"\t" + first+"\t" + last+"\t" + age);
//                System.out.print("\t" + accid);
//                System.out.print("\t" + first);
//                System.out.println("\t" + last);
//                System.out.println("\t" + age);
            }
        } catch (Exception e) {
        }
    }

    public void delpInfo() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.print("Account ID: ");
        int id = scan.nextInt();
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM `personalinformation` WHERE accID=" + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
        System.out.println("---------------> Information Deleted!!! :)");
    }

}
