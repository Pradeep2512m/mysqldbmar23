package com.harman.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Phonedata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("Select an option :");
            System.out.println("1 . Add an employee ");
            System.out.println("2 . view all employee ");
            System.out.println("3. Search phones based on brands ");
            System.out.println("4. Edit the smartphone using imei no ");
            System.out.println("5. Delete the smartphone using imei no");
            System.out.println("6. Exit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        String imei, brand, model, price;
                        System.out.println("Enter the imei no :");
                        imei = in.next();
                        System.out.println("Enter the brand :");
                        brand = in.next();
                        System.out.println("Enter the Model :");
                        model = in.next();
                        System.out.println("Enter the price :");
                        price = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `phone`(`imei`, `brand`, `model`, `price`) VALUES(" + imei + ",'" + brand + "','" + model + "'," + price + ")");
                        System.out.println("Inserted sucessfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View all smartphone");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `imei`, `brand`, `model`, `price` FROM `phone` WHERE 1");
                        while (rs.next()) {
                            System.out.println("imei = " + rs.getInt("imei"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("price = " + rs.getInt("price"));

                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        Scanner input=new Scanner(System.in);
                        String brand;
                        System.out.println("Enter the brand to be Searched: ");
                        brand = input.next();

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `phone` where `brand`='"+brand+"'");

                        while (rs.next()) {
                            System.out.println("imei = " + rs.getInt("imei"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("price = " + rs.getInt("price"));
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        Scanner input = new Scanner(System.in);
                        int imei;
                        System.out.println("Enter the imei to be Update: ");
                        imei = input.nextInt();

                        String brand, model, price;

                        System.out.println("Enter the brand: ");
                        brand = input.next();
                        System.out.println("Enter the model: ");
                        model = input.next();
                        System.out.println("Enter the price: ");
                        price = input.next();


                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `phone` SET `brand`='" + brand + "',`model`='" + model + "',`price`=" + price + " WHERE `imei`=" + imei);

                        System.out.println("Employee Details Updated Successfully !!!");

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    try {
                        int imei;
                        System.out.println("Enter the imei to be deleted:");
                        imei = in.nextInt();
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("DELETE FROM `phone` WHERE `imei`=" + imei);
                        System.out.println("Deleted sucessfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 6 :
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}



