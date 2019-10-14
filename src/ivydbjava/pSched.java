/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivydbjava;

import static ivydbjava.pInfo.DB_URL;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class pSched {

    private String course;
    private int year;
    private int accid;
    private String subject;
    private String sched;
    private int unit;
    private Scanner scan = new Scanner(System.in);
    private String quit = "y";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/devilleres";
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;

    public pSched() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSched() {
        return sched;
    }

    public void setSched(String sched) {
        this.sched = sched;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getQuit() {
        return quit;
    }

    public void setQuit(String quit) {
        this.quit = quit;
    }

    public void createPinfo() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("--------> Personal Schedule Form <--------");
        try {
            while (true) {
                System.out.print("Course: ");
                course = scan.next();

                System.out.print("Year: ");
                year = scan.nextInt();

                System.out.print("Subject: ");
                subject = scan.next();

                System.out.print("Schedule: ");
                sched = scan.next();

                System.out.print("Unit(s): ");
                unit = scan.nextInt();

                try {
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String Nsql;
                    Nsql = "SELECT MAX(id) FROM accounts";
                    ResultSet rs = stmt.executeQuery(Nsql);
                    while (rs.next()) {
                        //Retrieve by column name
                        accid = rs.getInt("MAX(id)");
                    }
                    String sql;
                    sql = "INSERT INTO `personalschedule`(`accID`, `course`, `year`, `subject`, `schedule`, `unit`) VALUES ('" + accid + "','" + course + "','" + year + "','" + subject + "','" + sched + "','" + unit + "')";
                    stmt.executeUpdate(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Schedule saved!");

                System.out.print("\t\t\t*** Would you like to input another course? ***\n \t\t\tEnter 'y' if YES and 'n' if NO\n \t\t\tYour choice: ");
                quit = scan.next();
                if ("n".equals(quit)) {
                    break;
                } else {
                    continue;
                }
            }

        } catch (Exception e) {
            System.out.println("Error diri");
            System.out.println(e);
        }
    }

    public void updatepPsched() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.print("Account ID: ");
        int ID = scan.nextInt();

        System.out.print("Course: ");
        String Ncourse = scan.next();

        System.out.print("Year: ");
        int Nyear = scan.nextInt();

        System.out.print("Subject: ");
        String Nsubject = scan.next();

        System.out.print("Schedule: ");
        String Nsched = scan.next();

        System.out.print("Unit(s): ");
        int Nunit = scan.nextInt();

        try {
            stmt = conn.createStatement();
            String another = "Select * from personalschedule where accID=" + ID;
            ResultSet rs = stmt.executeQuery(another);
            if (rs.next()) {
                String sql;
                sql = "UPDATE `personalschedule` SET `course` = '" + Ncourse + "', `year`= '" + Nyear + "', `subject`= '" + Nsubject + "', `schedule`= '" + Nsched + "', `unit`= '" + Nunit + "' WHERE accID=" + ID;
                stmt.executeUpdate(sql);
            }else{
                String Nsql="INSERT INTO `personalschedule`(`accID`, `course`, `year`, `subject`, `schedule`, `unit`) VALUES ('" + ID + "','" + Ncourse + "','" + Nyear + "','" + Nsubject + "','" + Nsched + "','" + Nunit + "')";
                stmt.executeUpdate(Nsql);
            }
        } catch (Exception e) {
        }
        System.out.println("---------------> Schedule UPDATED!!!! :)");
    }

    public void retrieveAllpsched() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("********-- List of Personal Schedule --********");

        try {
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM personalschedule";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("");
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int accid = rs.getInt("accID");
                String course = rs.getString("course");
                int year = rs.getInt("year");
                String sub = rs.getString("subject");
                String sched = rs.getString("schedule");
                int unit = rs.getInt("unit");
                //Display values
                System.out.println(id+"\t" + accid+"\t" + course+"\t" + year+"\t" + sub+"\t" + sched+"\t" + unit);
//                System.out.print("\t" + accid);
//                System.out.print("\t" + course);
//                System.out.println("\t" + year);
//                System.out.println("\t" + sub);
//                System.out.println("\t" + sched);
//                System.out.println("\t" + unit);
            }
        } catch (Exception e) {
        }
        
    }

    public void delpSched() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.print("Account ID: ");
        int id = scan.nextInt();
        try {
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM `personalschedule` WHERE accID=" + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
        }
        System.out.println("---------------> Schedule Deleted!!! :)");
    }

}
