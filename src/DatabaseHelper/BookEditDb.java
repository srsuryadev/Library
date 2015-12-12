/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseHelper;

import Database.DbInitializer;
import LibraryObjects.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suryadev
 */

public class BookEditDb {
    
    Statement stmt = null;
        
    public BookEditDb() throws SQLException{
        Connection conn = DbInitializer.conn;
        stmt = (Statement)conn.createStatement() ;
    }
    
    public boolean add(Book b) throws SQLException{

        //bookadded field should be added in the place of null which is of DATE data type
      String sql = "INSERT INTO BOOKS " +
                   "VALUES ( "+ b.bookId+", ' "+ b.bookName+"','"+b.bookAuthor+"','"+
              b.bookPublisher+"','"+b.bookPosition+"','"+b.bookAvailable+"',"+b.memberId+","
              +b.bookPrice+",null,'"+b.bookImage+"')";
      int count = stmt.executeUpdate(sql);
      
      if(count == 0){
          return false;
      }
      return true;

        
    }
    
    public boolean update(Book b) throws SQLException{
      
        this.delete(b.bookId);
        return this.add(b);
    }
    
    public boolean delete(Integer bookId) throws SQLException{
      
        String sql = "DELETE FROM BOOKS WHERE bookid ="+bookId;
        int count = stmt.executeUpdate(sql);
        
        if(count == 0) return false;
        return true;
    }
    
    public Book getBook(Integer bookId) throws SQLException{
        
        String sql = "Select * from Books where bookId ="+bookId.toString();
        System.out.println(bookId.toString());
       
        ResultSet rs = stmt.executeQuery(sql);
        Book b = null;
      
        if(rs.next()){
            System.out.println("Row is there!");
            b = new Book(rs.getInt("bookId"),rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("bookPubblisher"),rs.getString("bookPosition"),rs.getString("bookAvailable"),rs.getInt("memberId"),rs.getInt("bookPrice"),rs.getString("bookAdded"),rs.getString("bookImage"));
        }
        return b;
    
    }
}
