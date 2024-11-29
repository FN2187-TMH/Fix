/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_oop;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Book implements Serializable {

    public static String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int leftPadding = (width - text.length()) / 2;
        int rightPadding = width - text.length() - leftPadding;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leftPadding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        for (int i = 0; i < rightPadding; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static final long serialVersionUID = 1L;

    String isbn;
    String title;
    String author;
    String publisher;
    int numberBook;

    public Book(String isbn, String title, String author, String publisher, String numberBook) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numberBook = Integer.parseInt(numberBook);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook() {
        this.numberBook -=1 ;
    }  
    
    @Override
    public String toString() {
         return "|" + centerText(isbn, 50) + "|" + "\n" +
                 "|" + centerText(title, 50) + "|" + "\n" +
                 "|" + centerText(author, 50) + "|" +  "\n" +
                 "|" + centerText(publisher, 50) + "|" +  "\n" +
                 "|" + centerText(numberBook+"", 50) + "|" +"\n" +
                 "-------------------------------------------" ;
    }

}
