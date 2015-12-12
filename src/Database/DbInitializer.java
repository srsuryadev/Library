/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suryadev
 */
public class DbInitializer {
    
    
   static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
   static final String DB_URL = "jdbc:derby://localhost:1527/Library";

   static final String USER = "nbuser";
   static final String PASS = "nbuser";
   public static Connection conn = null;
   public Statement stmt = null;
   
   public DbInitializer() throws ClassNotFoundException, SQLException{
      
      Class.forName(JDBC_DRIVER);
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();

   }
   
   public static Connection getConnection(){
       
       return conn;
   }
   
   public void createTables() throws SQLException{
       
       String sql = "CREATE TABLE BOOKS " +
                   "(bookid INTEGER not NULL, " +
                   " bookname VARCHAR(255), " + 
                   " bookauthor VARCHAR(255), " + 
                   " bookpubblisher VARCHAR(255), " +
                   " bookposition VARCHAR(255), " +
                   " bookavailable VARCHAR(255), " +
                   " memberid INTEGER, " +
                   " bookprice INTEGER, " +
                   " bookadded DATE, " +
                   " bookimage VARCHAR(255), " +
                   " PRIMARY KEY ( bookid ))";
   
    //  String checkSql = "SELECT COUNT(*) FROM `tableName`";
      int count; 
  //    ResultSet rs = stmt.executeQuery(checkSql);
      count = 1; 
      if(count == 0){
        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
      }
      else{
        System.out.println("Tables already Exists");
      }
      
       
   }
   
}
