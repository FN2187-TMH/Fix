/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library_management_oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Library_management_oop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        try{    
            ArrayList<Reader> begin = new ArrayList<>(); 
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("READER.dat")); out.writeObject(begin);
            out.writeObject(begin);
            out.close();

            Manager Admin = new Manager("Hieu", "000000011111", "hieu@gmail.com"); 
            Admin.addReader(new Reader("1", "2", "3")); 
            Admin.addReader(new Reader("2", "3", "4"));

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("READER.dat"));
            ArrayList<Reader> list = (ArrayList<Reader>) in.readObject();
            in.close();

            for (Reader reader : list) { 
                System.out.println(reader);
            }
        
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
}
