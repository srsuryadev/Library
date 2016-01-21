/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import Database.DbInitializer;
import java.sql.SQLException;
import javax.swing.JFrame;
import librarysystem.UI.BookEdit;
import librarysystem.UI.Home;
import librarysystem.UI.HomePage;
import librarysystem.UI.MemberBookUI;

/**
 *
 * @author suryadev
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        DbInitializer db = new DbInitializer();
        db.createTables();
     //   JFrame bookEdit = new BookEdit();
     //   bookEdit.setVisible(true);
      //  JFrame mb = new MemberBookUI();
      //  mb.setVisible(true);
        JFrame h = new HomePage();
        h.setVisible(true);
    }
    
}
