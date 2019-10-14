/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivydbjava;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class menu {

    paccounts PACC = new paccounts();
    pInfo PIN = new pInfo();
    pSched ps = new pSched();
    Scanner scan = new Scanner(System.in);

    public void mymenu() {
        System.out.println("\t\t\t\t\t********** TRANSACTIONS **********");
        System.out.println("\t\t\t\t\t\t [1]...CREATE");
        System.out.println("\t\t\t\t\t\t [2]...RETRIEVE");
        System.out.println("\t\t\t\t\t\t [3]...UPDATE");
        System.out.println("\t\t\t\t\t\t [4]...DELETE");
        System.out.println("\t\t\t\t\t\t [5]...EXIT");

    }

    public void createmenu() {
        System.out.println("\t\t\t\t\t========= CREATE TRANSACTION =========");
        System.out.println("\t\t\t\t\t\t[1]...ACCOUNT");
        System.out.println("\t\t\t\t\t\t[2]...PERSONAL INFORMATION");
        System.out.println("\t\t\t\t\t\t[3]...SCHEDULE");
        System.out.println("\t\t\t\t\t\t[4]...EXIT");

    }

    public void retrievemenu() {
        System.out.println("\t\t\t\t\t>>>>>>>>> RETRIEVE TRANSACTION <<<<<<<<<");
        System.out.println("\t\t\t\t\t\t[1]...ACCOUNT");
        System.out.println("\t\t\t\t\t\t[2]...PERSONAL INFORMATION");
        System.out.println("\t\t\t\t\t\t[3]...SCHEDULE");
        System.out.println("\t\t\t\t\t\t[4]...EXIT");

    }

    public void updatemenu() {
        System.out.println("\t\t\t\t\t######### UPDATE TRANSACTION #########");
        System.out.println("\t\t\t\t\t\t[1]...ACCOUNT");
        System.out.println("\t\t\t\t\t\t[2]...PERSONAL INFORMATION");
        System.out.println("\t\t\t\t\t\t[3]...SCHEDULE");
        System.out.println("\t\t\t\t\t\t[4]...EXIT");
    }

    public void deletemenu() {
        System.out.println("\t\t\t\t\t--------- DELETE TRANSACTION ---------");
        System.out.println("\t\t\t\t\t\t[1]...PERSONAL INFORMATION");
        System.out.println("\t\t\t\t\t\t[2]...SCHEDULE");
        System.out.println("\t\t\t\t\t\t[3]...EXIT");
    }

    public void start() throws SQLException {
        while (true) {
            mymenu();
            System.out.print("\t\t\t\t\t\t--> ");
            int c = scan.nextInt();
            switch (c) {
                case 1:
                    while (true) {
                        createmenu();
                        System.out.print("\t\t\t\t\t\t--> ");
                        int a = scan.nextInt();
                        switch (a) {
                            case 1:
                                PACC.createAccounts();
                                break;
                            case 2:
                                PIN.createPinfo();
                                break;
                            case 3:
                                ps.createPinfo();
                                break;
                        }
                        if (a == 4) {
                            break;
                        } else {
                            continue;
                        }
//                    break;
                    }
                    break;
                case 2:
                    while (true) {
                        retrievemenu();
                        System.out.print("\t\t\t\t\t\t--> ");
                        int b = scan.nextInt();
                        switch (b) {
                            case 1:
                                PACC.retrieveAllAcc();
                                break;
                            case 2:
                                PIN.retrieveAllpInfo();
                                break;
                            case 3:
                                ps.retrieveAllpsched();
                                break;

                        }
                        if (b == 4) {
                            break;
                        } else {
                            continue;
                        }

                    }
                    break;
                case 3:
                    while (true) {
                        updatemenu();
                        System.out.print("\t\t\t\t\t\t--> ");
                        int d = scan.nextInt();
                        switch (d) {
                            case 1:
                                PACC.updateAccount();
                                break;
                            case 2:
                                PIN.updatepInfo();
                                break;
                            case 3:
                                ps.updatepPsched();
                                break;

                        }
                        if (d == 4) {
                            break;
                        } else {
                            continue;
                        }

                    }
                    break;
                case 4:
                    while (true) {
                        deletemenu();
                        System.out.print("\t\t\t\t\t\t--> ");
                        int e = scan.nextInt();
                        switch (e) {
                            case 1:
                                PIN.delpInfo();
                                break;
                            case 2:
                                ps.delpSched();
                                break;
                            case 3:
                                break;
                        }
                        if (e == 3) {
                            break;
                        } else {
                            continue;
                        }

                    }
                    break;
                case 5:
                    System.out.println("\t******** Goodbye and have a nice day!!! ********");
                    break;
            }
            if (c == 5) {
                break;
            } else {
                continue;
            }

        }
    }

}
