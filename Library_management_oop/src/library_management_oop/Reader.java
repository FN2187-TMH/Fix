package library_management_oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader extends User implements Serializable{
    
    private String id;
    private int fine;
    static int index = 1;
    
    public Reader(String name, String phone, String email) {
        super(name, phone, email);
        this.id = String.format("READER_%05d", index++);
    }

    public String getId() {
        return id;
    }
    
    public int getFine(String currentDate) {
        fine = 0;
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("ORDER.in"))){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Order> orders = (ArrayList<Order>) input.readObject();
            // Lay data
            for (Order order : orders) {
                if (order.getReaderId().equals(this.getId())) { // so sanh id trong order voi id reader
                    try {
                        Date reDate = order.getReturnDate();
                        Date current = sdf.parse(currentDate);

                        int distance = (int) ((current.getTime() - reDate.getTime()) / (1000 * 60 * 60 * 24)); // tinh ngay tu mili giay
                        if(distance > 0) {
                            fine += distance * 10000;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return fine;
    }
    
    public void addOrder(Order order) {
            
        try {
            ObjectInputStream in_;
            in_ = new ObjectInputStream(new FileInputStream("BOOK.dat"));
            ArrayList<Book> book_list = (ArrayList<Book>) in_.readObject();
            
            for(Book book : book_list){
                if(book.getIsbn().equals(order.getIsbn())){
                    book.setNumberBook();
                    break;
                }
            }
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BOOK.dat"));
            out.writeObject(book_list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
        try {
            
            ObjectInputStream in;
            in = new ObjectInputStream(new FileInputStream("ORDER.dat"));
            ArrayList<Order> order_list = (ArrayList<Order>) in.readObject();
            in.close();
            order_list.add(order);
            

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ORDER.dat"));
            out.writeObject(order_list);
            out.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    

    
    
    

    @Override
    public String toString(){
        return String.format("%50s\n", id) +
                String.format("%50s\n", name) +
                String.format("%50s\n", phone) +
                String.format("%50s\n", email) ;
    }
    
}
