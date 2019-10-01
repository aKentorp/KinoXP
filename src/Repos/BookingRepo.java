package Repos;

import Model.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingRepo {

    List<Booking> bookingList = new ArrayList<>();


    public void toFile (){
    bookingList.add(new Booking(12345678,1,2));
    bookingList.add(new Booking(87654321,2,3));

    try{
        FileWriter fw = new FileWriter("C:\\Users\\OggyMan\\Documents\\DAT18B\\Opgaver\\KinoXP\\textFiles\\bookings.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Booking book: bookingList) {
            bw.write(book.toString());
        }
        bw.close();

    }
    catch (Exception err){

    }

    }

    public List<Booking> createBookingList(){ //TODO finish this
        try {
            Scanner bookingScanner = new Scanner(new File("textFiles/bookings.txt"));
        }catch(Exception e){
            System.out.println(e);
        }
        List<Booking> bookingList = new ArrayList<>();


        return bookingList;
    }



}
