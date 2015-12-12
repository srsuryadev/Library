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

public class Book {
    
    public Integer bookId;
    public String bookName;
    public String bookAuthor;
    public String bookPublisher;
    public String bookPosition;
    public String bookAvailable;
    public Integer memberId;
    public Integer bookPrice;
    public String bookAdded;
    public String bookImage;
    
    public Book(Integer bookId,String bookName,String bookAuthor,String bookPublisher,String bookPosition,String bookAvailable,
            Integer memberId,Integer bookPrice,String bookAdded,String bookImage){
               
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAdded = bookAdded;
        this.bookAuthor = bookAuthor;
        this.bookAvailable = bookAvailable;
        this.bookImage = bookImage;
        this.bookPosition = bookPosition;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
        this.memberId = memberId;
    }

    public Book() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
