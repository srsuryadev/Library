/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryObjects;

/**
 *
 * @author suryadev
 */
public class MemberBook {
    
    public Integer memberId;
    public Integer bookId;
    public String datetaken;
    public String expectedate;
    public Integer fine;
    
    public MemberBook(Integer memberId, Integer bookId, String datetaken, String expectedate, Integer fine){
        this.memberId = memberId;
        this.bookId = bookId;
        this.datetaken = datetaken;
        this.expectedate = expectedate;
        this.fine = fine;
    }

    public MemberBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
