/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csc4380jchackofinalproject;
import com.mysql.jdbc.Statement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author admin
 */
public class modelFinalPersonalInformation {
    public void modelFinalPersonalInformation() throws InterruptedException{
        
        
        
        try{
            
            /********************** Create Database ********************************/
            
            host = "jdbc:mysql://localhost:3306";
            uName = "student";
            uPass = "";
            
            //sql = "DROP DATABASE sqlpersonalinformation";
            sql = "CREATE DATABASE sqlpersonalinformation";
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            stmt.executeUpdate(sql);
            
            con.close();
            
             
                    
            
        }
        catch(SQLException err){
            //System.out.println(err.getMessage());
            //System.out.println("Database already exists");
        }
        
        try{
            /********************** Create Table ********************************/
            
            
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
           
            sql = "CREATE TABLE PersonalInformation " +
                   "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                   " Name VARCHAR(255), " + 
                   " Gender VARCHAR(255), " + 
                   " Age INTEGER, " + 
                    " Address VARCHAR(255), " + 
                " FatherName VARCHAR(255), " + 
                " MotherName VARCHAR(255), " + 
                " SiblingNumber INTEGER, " +
                " PartnerName VARCHAR(255), " + 
                " ChildrenNumber INTEGER, " +
                   " PRIMARY KEY ( id ))";
            
            
            stmt.executeUpdate(sql);
            
            
            sql = "INSERT INTO PersonalInformation (Name, Gender, Age, Address," +
                    "FatherName, MotherName, SiblingNumber, PartnerName, ChildrenNumber)" +
                    "VALUES ('Default Dan', 'Male', '42', '123 Sesame St.', 'Alpha Dan', " +
                    "'Beta Dan', '12', 'Lovely Lucy', '2')";
            
            stmt.executeUpdate(sql);
            
            
            
            System.out.println("Table Created");
            
            con.close();
            
        }
        catch(SQLException err){
            //System.out.println(err.getMessage());
            //System.out.println("Table already exists");
        }
    }
    
    /***************Shows the default results**********************/
    public ResultsObject DefaultResults(){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
           
            strQuery = "SELECT * FROM personalinformation WHERE id = 1";
        
            rs = stmt.executeQuery(strQuery);
            while(rs.next()){
                //System.out.println(rs.getString("Name"));
                intFindId = rs.getInt("id");
                strFindName = rs.getString("Name");
                strFindGender = rs.getString("Gender");
                intFindAge = rs.getInt("Age");
                strFindAddress = rs.getString("Address");
                strFindFatherName = rs.getString("FatherName");
                strFindMotherName = rs.getString("MotherName");
                intFindSiblingNumber = rs.getInt("SiblingNumber");
                strFindPartnerName = rs.getString("PartnerName");
                intFindChildrenNumber = rs.getInt("ChildrenNumber");
                
                //ResultsObject objResults = new ResultsObject();
                objResults.intFindId = intFindId;
                objResults.strFindName = strFindName;
                objResults.strFindGender = strFindGender;
                objResults.intFindAge = intFindAge;
                objResults.strFindAddress = strFindAddress;
                objResults.strFindFatherName = strFindFatherName;
                objResults.strFindMotherName = strFindMotherName;
                objResults.intFindSiblingNumber = intFindSiblingNumber;
                objResults.strFindPartnerName = strFindPartnerName;
                objResults.intFindChildrenNumber = intFindChildrenNumber;
                
            }
            
            con.close();
            return objResults;
            
        }
        catch(SQLException err){
            //System.out.println(err.getMessage());
            strFindName = "Error";
            return objResults;
            
        }
        
        
        
        
        
        
    }
    
    /************Updates each field when changed******************/
    public void UpdateName(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET Name = '" + objResults.strFindName + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateGender(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET Gender = '" + objResults.strFindGender + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateAge(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET Age = '" + objResults.intFindAge + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateAddress(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET Address = '" + objResults.strFindAddress + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateFather(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET FatherName = '" + objResults.strFindFatherName + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateMother(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET MotherName = '" + objResults.strFindMotherName + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateSibling(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET SiblingNumber = '" + objResults.intFindSiblingNumber + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdatePartner(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET PartnerName = '" + objResults.strFindPartnerName + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
            }
        }
    public void UpdateChildren(ResultsObject objResults){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
        
            con = DriverManager.getConnection(host, uName, uPass);
            
            //System.out.println("Connected");
            
            stmt = (Statement) con.createStatement();
            
            
            sql = "UPDATE personalinformation " +
                    "SET ChildrenNumber = '" + objResults.intFindChildrenNumber + "' " + 
                    "WHERE id = " + objResults.intFindId;
            
            stmt.executeUpdate(sql);
            System.out.println("Table Updated");
            
            con.close();
        }
        catch(SQLException err){
                System.out.println(err.getMessage());
                
            }
        }
    
    /***********       Adds people      **************/
    public int AddPerson(){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = (Statement) con.createStatement();
            
            //adds new id to database to be used
            sql = "INSERT INTO PersonalInformation (Name, Gender, Age, Address," +
                    "FatherName, MotherName, SiblingNumber, PartnerName, ChildrenNumber)" +
                    "VALUES ('Unknown', 'Unknown', '0', 'Unknown', 'Unknown', " +
                    "'Unknown', '0', 'Unknown', '0')";
            
            stmt.executeUpdate(sql);
            System.out.println("New Person Added");
            
            //Newest id will always have the highest value
            sql = "SELECT MAX(id) FROM personalinformation";
            
            rs = stmt.executeQuery(sql);
            
            //gets the newest id
            while(rs.next()){
                objResults.intFindId = rs.getInt(1);
                
            }
            
            //returns the newest id to controller
            con.close();
            return objResults.intFindId;
            
            
        }
        catch(SQLException err){
            
            System.out.println(err.getMessage());
            return objResults.intFindId;
        }
        
    }
    
    /******************   Search method   ********************/
    public ResultsObject Search(int intId){
        try{
            host = "jdbc:mysql://localhost:3306/sqlpersonalinformation";
            uName = "student";
            uPass = "";
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = (Statement) con.createStatement();
            
            sql = "SELECT * FROM personalinformation WHERE id = " + intId;
            //System.out.println(intId);
            rs = stmt.executeQuery(sql);
            
            
            
            while(rs.next()){
                objResults.intFindId = rs.getInt("id");
                objResults.strFindName = rs.getString("Name");
                objResults.strFindGender = rs.getString("Gender");
                objResults.intFindAge = rs.getInt("Age");
                objResults.strFindAddress = rs.getString("Address");
                objResults.strFindFatherName = rs.getString("FatherName");
                objResults.strFindMotherName = rs.getString("MotherName");
                objResults.intFindSiblingNumber = rs.getInt("SiblingNumber");
                objResults.strFindPartnerName = rs.getString("PartnerName");
                objResults.intFindChildrenNumber = rs.getInt("ChildrenNumber");
                objResults.boolSearchError = false;
            }
            
            //checks if the id searched is not in the database
            if(!rs.isAfterLast()){
                //System.out.println("Errir");
                objResults.boolSearchError = true;
                //return objResults;
                
            }
            
            
            con.close();
            return objResults;
            
        }
        catch(SQLException err){
            
            
            System.out.println(err.getMessage());
            return objResults;
        }
        
        
    }
    
    
    
    String strQuery;
    
    
    int intFindId;
    String strFindName;
    String strFindGender;
    int intFindAge;
    String strFindAddress;
    String strFindFatherName;
    String strFindMotherName;
    int intFindSiblingNumber;
    String strFindPartnerName;
    int intFindChildrenNumber;
    
    Boolean boolSearchError;
    
    ResultSet rs;
    Connection con;
    String strEmptyCheck;
    String host;
    String uName;
    String uPass;
    String sql;
    Statement stmt = null;
    
    ResultsObject objResults = new ResultsObject();
    
    class ResultsObject{
        int intFindId;
        String strFindName;
        String strFindGender;
        int intFindAge;
        String strFindAddress;
        String strFindFatherName;
        String strFindMotherName;
        int intFindSiblingNumber;
        String strFindPartnerName;
        int intFindChildrenNumber;
        
        Boolean boolSearchError;
    }
    
    
}
