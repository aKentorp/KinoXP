package Repos;

import Model.Booking;
import Model.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BookingRepo {

    List<Booking> bookingList = new ArrayList<>();


    public void toFile (){
        try{
            FileWriter fw = new FileWriter("textFiles\\bookings.txt");
            BufferedWriter bw = new BufferedWriter(fw);


            for (int i = 0; i < bookingList.size(); i++){
                if (i < (bookingList.size()-1)){
                    bw.write(bookingList.get(i).getPhoneNumber() + "_" + bookingList.get(i).getShowId() + "_" + bookingList.get(i).getBookingId() + "\n");
                } else {
                    bw.write(bookingList.get(i).getPhoneNumber() + "_" + bookingList.get(i).getShowId() + "_" + bookingList.get(i).getBookingId());
                }
            }
            bw.close();

        }
        catch (Exception err){

        }

    }

    public void fromFile(File fileName){ //TODO finish this
        try {
            Scanner bookingScanner = new Scanner(fileName);
            while(bookingScanner.hasNextLine()){
                String[] fileLine = bookingScanner.nextLine().split("_");
                int phoneNumber = Integer.parseInt(fileLine[0]);
                int showId = Integer.parseInt(fileLine[1]);
                int bookingId = Integer.parseInt(fileLine[2]);

                this.bookingList.add(new Booking(phoneNumber, showId, bookingId));
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    public void createBooking(int phoneNumber, int showId, int bookingId){
        bookingList.add(new Booking(phoneNumber, showId, bookingId));
    }

    public void readBookingList(){
        System.out.println();
        System.out.println("Customer Number\t\tshow ID\t\tBooking ID");
        for (int i = 0; i < bookingList.size(); i++){
            System.out.println(bookingList.get(i).toString());
        }
        System.out.println();
    }

    public void sellTicket(int showID, int phoneNumber){
        int tempHighestBookingNumber = 0;

        ShowRepo showRepo = new ShowRepo();
        showRepo.readShow();

        for(Show show : showRepo.showList){
            if(show.getShowId() == showID && show.getRemainingSeats() > 0){
                show.setRemainingSeats(show.getRemainingSeats() - 1);

                for(Booking booking : bookingList){
                    if(booking.getBookingId() > tempHighestBookingNumber){
                        tempHighestBookingNumber++;
                    }
                }
                Booking newBooking = new Booking(phoneNumber, showID, tempHighestBookingNumber);

                bookingList.add(newBooking);
            }

            else{
                System.out.println("No seats left");
            }
        }


    }
}