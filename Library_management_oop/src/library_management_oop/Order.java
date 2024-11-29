/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_oop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private String id, readerId, isbn;
    private Date borrowDate, returnDate;
    private static int index = 1;

    public Order(String readerId, String isbn, String borrowDate, String returnDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.id = String.format("ORDER%05d", index++);
        this.readerId = readerId;
        this.isbn = isbn;
        this.borrowDate = sdf.parse(borrowDate);
        this.returnDate = sdf.parse(returnDate);  
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
    
    public String getReaderId() {
        return readerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    
}
