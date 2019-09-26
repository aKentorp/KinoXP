package Repos;

import Model.Booking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingRepo {



    public List<Booking> createBookingList(){
        try {
            Scanner bookingScanner = new Scanner(new File("textFiles/bookings.txt"));
        }catch(Exception e){
            System.out.println(e);
        }
        List<Booking> bookingList = new ArrayList<>();


        return bookingList;
    }
}
