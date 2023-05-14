/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Name: David White
Class: CIS2572
Instructor: Barry Speller
Assignment: Unit 17 Binary IO
File: Addressbook.java
Description: Write a program that stores, retrieves, adds and updates address.
 */
public class AddressBook extends Application {
    //create UI
    protected Addressbookpane pane = new Addressbookpane();
    // string length for attributes
    final int NAME = 32;
    final int STREET = 32;
    final int CITY = 20;
    final int STATE = 2;
    final int ZIP = 5;
    protected int count = 0;
    
    @Override
    public void start(Stage primaryStage) {
        // create and register handlers
        pane.addButton.setOnAction(e -> addNewAddress());
        pane.firstButton.setOnAction(e -> firstAddress());
        pane.nextButton.setOnAction(e -> nextAddress());
        pane.previousButton.setOnAction(e -> previousAddress());
        pane.lastButton.setOnAction(e -> lastAddress());
        pane.updateButton.setOnAction(e -> updateAddress());
        
        // create scene and place it in staage
        Scene scene = new  Scene(pane, 360, 130);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // write address to file
    private void addNewAddress() {
        // create a random access file
        try (
                RandomAccessFile inout =
                        new RandomAccessFile("addressbook.dat", "rw");
            ){
                inout.seek(inout.length());
                write(inout);
        }
        catch (FileNotFoundException ex){System.out.println("File not Found!");}
        catch (IOException ex){System.out.println("IO Exception");}
        }  
    
    // read the first address from file
    private void firstAddress() {
        try ( RandomAccessFile inout =
                new RandomAccessFile("addressbook.dat", "rw");
        ){
            if (inout.length() > 0) {
                inout.seek(0);
                read(inout);
                System.out.println("Reading address #1");
            } 
            else System.out.println("Address is empty!");
            
        }
        catch (IOException ex){System.out.println("IO Exception");}
    }
    
    // read next address from file
    private void nextAddress(){
        try ( RandomAccessFile inout =
                new RandomAccessFile("addressbook.dat", "rw");
        ){
            if (inout.length() > 0) {
                inout.seek(count * 91);
                read(inout);
                count++;
                System.out.println("Reading address #" + count);
            } 
            else System.out.println("End of file!");
            
        }
        catch (IOException ex){System.out.println("IO Exception");}
    }
    
    // read previous address from file
    private void previousAddress(){
        try ( RandomAccessFile inout =
                new RandomAccessFile("addressbook.dat", "rw");
        ){
            if (count > 1) {
                count--;
            } 
            else count = 1;
            inout.seek(count * 91);
            read(inout);
            count++;
            System.out.println("Reading address #" + count);
            
        }
        catch (IOException ex){System.out.println("IO Exception");}
    }
    
    // read last address from file
    private void lastAddress(){
        try ( RandomAccessFile inout =
                new RandomAccessFile("addressbook.dat", "rw");
        ){
            count = ((int)inout.length()) / 91;
            inout.seek((count * 91) - 91);
            read(inout);
            System.out.println("Reading address #" + count);
        }
        catch (IOException ex){System.out.println("IO Exception");}
    }
    
    private void  updateAddress(){
        try ( RandomAccessFile inout =
                new RandomAccessFile("addressbook.dat", "rw");
        ){
           inout.seek(count * 91 - 91);
           write(inout);
            
        }
        catch (IOException ex){System.out.println("IO Exception");}
        }
    
    // write address to file
    private void write(RandomAccessFile inout) throws IOException{
        inout.write(fixedLength(pane.nameTextField.getText().getBytes(), NAME));
        inout.write(fixedLength(pane.streetTextField.getText().getBytes(), STREET));
        inout.write(fixedLength(pane.cityTextField.getText().getBytes(), CITY));
        inout.write(fixedLength(pane.stateTextField.getText().getBytes(), STATE));
        inout.write(fixedLength(pane.zipCodeTextField.getText().getBytes(), ZIP));
        System.out.println("Address #" + count + " saved!");
    }
    
    // read address from file
    private void read(RandomAccessFile inout) throws IOException {
        int pos;
        
        // read name field
        byte[] name = new byte[NAME];
        pos = inout.read(name);
        pane.nameTextField.setText(new String(name));
        
        // read street field
        byte [] street = new byte[STREET];
        pos += inout.read(street);
        pane.streetTextField.setText((new String(street)));
        
        // read city field
        byte[] city = new byte[CITY];
        pos += inout.read(city);
        pane.cityTextField.setText((new String(city)));
        
        // read state field
        byte[] state = new byte[STATE];
        pos += inout.read(state);
        pane.stateTextField.setText(new String(state));
        
        // read zip field
        byte[] zip = new byte[ZIP];
        pos += inout.read(zip);
        pane.zipCodeTextField.setText(new String(zip));
    }
    
    private byte[] fixedLength(byte[] x, int n) {
        byte[] b = new byte[n];
        for (int i = 0; i < x.length; i++) {
            b[i] = x[i];
        }
        return b;
    } 
}
