/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management_oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Manager extends User {

    public Manager(String name, String phone, String email) {
        super(name, phone, email);
    }

    public void addBook(Book book) {
        try {
            ObjectInputStream in;
            in = new ObjectInputStream(new FileInputStream("BOOK.dat"));
            ArrayList<Book> book_list = (ArrayList<Book>) in.readObject();
            in.close();
            book_list.add(book);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BOOK.dat"));
            out.writeObject(book_list);
            out.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void addReader(Reader reader) {
        try {
            ObjectInputStream in;
            in = new ObjectInputStream(new FileInputStream("READER.dat"));
            ArrayList<Reader> reader_list = (ArrayList<Reader>) in.readObject();
            reader_list.add(reader);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("READER.dat"));
            out.writeObject(reader_list);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public static void deleteReader(String id) {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in = new ObjectInputStream(new FileInputStream("READER.dat"));
            ArrayList<Reader> readerList = (ArrayList<Reader>) in.readObject();
            in.close();
            Iterator<Reader> iterator = readerList.iterator();
            while (iterator.hasNext()) {
                Reader reader = iterator.next();
                if (reader.getId().equals(id)) {
                    iterator.remove();
                }
            }
            out = new ObjectOutputStream(new FileOutputStream("READER.dat"));
            out.writeObject(readerList);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void deleteBook(String isbn) {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            in = new ObjectInputStream(new FileInputStream("BOOK.dat"));
            ArrayList<Book> bookList = (ArrayList<Book>) in.readObject();
            in.close();
            Iterator<Book> iterator = bookList.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.isbn.equals(isbn)) {
                    iterator.remove();
                }
            }
            out = new ObjectOutputStream(new FileOutputStream("BOOK.dat"));
            out.writeObject(bookList);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void readerList(){
        try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("READER.dat"));
            ArrayList<Reader> reader_list = (ArrayList<Reader>) out.readObject();
            
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void bookList(){
        try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("BOOK.dat"));
            ArrayList<Book> book_list = (ArrayList<Book>) out.readObject();
            
            
            for(Book i : book_list){
                System.out.println(i);
            }
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
