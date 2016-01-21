/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseHelper;

import Database.DbInitializer;
import LibraryObjects.MemberBook;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author suryadev
 */
public class MemberBookDb {
    
       
    Statement stmt = null;
        
    public MemberBookDb() throws SQLException{
        Connection conn = DbInitializer.conn;
        stmt = (Statement)conn.createStatement() ;
    }
    
    public boolean add(MemberBook b) throws SQLException{

        //bookadded field should be added in the place of null which is of DATE data type
      String sql = "INSERT INTO MEMBERBOOK " +
                   "VALUES ( "+ b.memberId+",  "+ b.bookId+","+"'1993-09-01'"+","+
              "'1993-09-01'"+","+b.fine+")";
      int count = stmt.executeUpdate(sql);
      
      if(count == 0){
          return false;
      }
      return true;
    }
    
    public boolean update(MemberBook b) throws SQLException{
      
        this.delete(b.memberId,b.bookId);
        return this.add(b);
    }
    
      public List<MemberBook> getBook(Integer memberId) throws SQLException{
        
        String sql = "Select * from MEMBERBOOK where memberid ="+memberId.toString();
        System.out.println(memberId.toString());
       
        ResultSet rs = stmt.executeQuery(sql);
        MemberBook b = null;
        List<MemberBook> lst = new LinkedList();
        while(rs.next()){
            System.out.println("Row is there!");
            b = new MemberBook(rs.getInt("memberid"),rs.getInt("bookid"),rs.getString("datetaken"),rs.getString("expectedate"),rs.getInt("fine"));
            lst.add(b);
        }
        return lst;
    }
    
      public boolean delete(Integer memberId, Integer bookId) throws SQLException{
      
        String sql = "DELETE FROM MEMBERBOOK WHERE memberid ="+memberId+" and bookid ="+bookId;
        int count = stmt.executeUpdate(sql);
        
        if(count == 0) return false;
        return true;
    }
}
