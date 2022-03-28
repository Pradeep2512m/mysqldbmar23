package com.harman.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employeedata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("Select an option :");
            System.out.println("1 . Add an employee ");
            System.out.println("2 . view all employee ");
            System.out.println("3. Exit");
            option = in.nextInt();
            switch (option){
                case 1 :
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companyDb?autoReconnect=true&useSSL=false", "root", "");
                        String empcode,empname,empphone,empemail,empdesignation,empsalary,empcompanyname,empaddress;
                        System.out.println("Enter the code :");
                        empcode = in.next();
                        System.out.println("Enter the name :");
                        empname = in.next();
                        System.out.println("Enter the Mobile no :");
                        empphone= in.next();
                        System.out.println("Enter the email :");
                        empemail= in.next();
                        System.out.println("Enter the designation :");
                        empdesignation = in.next();
                        System.out.println("Enter the salary :");
                        empsalary = in.next();
                        System.out.println("Enter the company name :");
                        empcompanyname = in.next();
                        System.out.println("Enter the address :");
                        empaddress = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employees`(`empcode`, `empname`, `empphone`, `empemail`, `empdesignation`, `empsalary`, `empcompanyname`, `empaddress`) VALUES('"+empcode+"','"+empname+"','"+empphone+"','"+empemail+"','"+empdesignation+"',"+empsalary+",'"+empcompanyname+"','"+empaddress+"')");
                        System.out.println("Inserted sucessfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2 :
                    System.out.println("View all employees selected");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/companyDb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `empcode`, `empname`, `empphone`, `empemail`, `empdesignation`, `empsalary`, `empcompanyname`, `empaddress` FROM `employees` WHERE 1");
                        while (rs.next()){
                            System.out.println("empcode = " + rs.getInt("empcode"));
                            System.out.println("empname = "+ rs.getString("empname"));
                            System.out.println("empphone = "+ rs.getBigDecimal("empphone"));
                            System.out.println("empemail = "+ rs.getString("empemail"));
                            System.out.println("empdesignation = "+ rs.getString("empdesignation"));
                            System.out.println("empsalary = " + rs.getInt("empsalary"));
                            System.out.println("empcompanyname = " + rs.getString("empcompanyname"));
                            System.out.println("empaddress= " + rs.getString("empaddress"));

                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 3 :
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}