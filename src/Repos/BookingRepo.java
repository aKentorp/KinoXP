package Repos;

import Model.Booking;
import Model.Show;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BookingRepo {

    private int bookingId = 0;
    private List<Booking> bookingList = new ArrayList<>();
    private ShowRepo showRepo;
    private File fileName;

    public BookingRepo(File fileName, ShowRepo showRepo){
        this.showRepo = showRepo;
        this.fileName = fileName;
    }



    public void toFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for(int i = 0; i < bookingList.size(); i++){
                if (i < bookingList.size()-1) {
                    bw.write(bookingList.get(i).getPhoneNumber() + "%%" + bookingList.get(i).getShowId() + "%%" + bookingList.get(i).getBookingId() + "\n");
                } else {
                    bw.write(bookingList.get(i).getPhoneNumber() + "%%" + bookingList.get(i).getShowId() + "%%" + bookingList.get(i).getBookingId());
                }
            }
            bw.close();

        }
        catch (Exception err){

        }

    }

    public void fromFile(){ //TODO finish this
        try {
            Scanner bookingScanner = new Scanner(fileName);
            while(bookingScanner.hasNextLine()){
                String[] fileLine = bookingScanner.nextLine().split("%%");
                int phoneNumber = Integer.parseInt(fileLine[0]);
                int showId = Integer.parseInt(fileLine[1]);
                int bookingId = Integer.parseInt(fileLine[2]);

                this.bookingList.add(new Booking(phoneNumber, showId, bookingId));
            }
            if (bookingList.isEmpty()){
                System.out.println("No bookings yet.");
            } else {
                bookingId = bookingList.get(bookingList.size() - 1).getBookingId();
            }
        } catch(FileNotFoundException e){
            System.out.println("Filen: " + e.getMessage());
        }
    }

    public void createBooking(int phoneNumber, int showId, int bookingId){
        bookingList.add(new Booking(phoneNumber, showId, bookingId));
    }

    public void readBookingList(){
        System.out.println();
        System.out.println("Booking ID\t\tshow ID\t\tCustomer Number");
        for (int i = 0; i < bookingList.size(); i++){
            System.out.println(bookingList.get(i).toString());
        }
        System.out.println();
    }

    public void sellTicket(int showIndex, int phoneNumber){
        //Setting now amount of seats for that show
        showRepo.getShowList().get(showIndex).setRemainingSeats(showRepo.getShowList().get(showIndex).getRemainingSeats() - 1);
    }

    public void bookingMenu() throws NoSuchElementException {
        Scanner bookingInput = new Scanner(System.in);
        int choice;

        boolean sentinel = true;
        do {
            System.out.println("-Press 1: Create a Booking" +
                    "\n-Press 2: Show Bookinglist" +
                    "\n-Press 9: Exit Booking Menu");

            choice = bookingInput.nextInt();
            bookingInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Phone Number: ");
                    int phoneNumber = bookingInput.nextInt();
                    bookingInput.nextLine();
                    int length = String.valueOf(phoneNumber).length();
                    boolean showExists = false;

                    if (length != 8) {
                        System.out.println("Invalid Phone Number, Booking Canceled");
                    } else {
                        System.out.println("Enter a Show ID: ");
                        int showID = bookingInput.nextInt();
                        bookingInput.nextLine();
                        int showIndex = -1;
                        for (int i = 0; i < showRepo.getShowList().size(); i++) {
                            if (showRepo.getShowList().get(i).getShowId() == showID) {
                                showIndex = i;
                            }
                        }
                        if (showIndex != -1) {
                            this.bookingId++;
                            createBooking(phoneNumber, showID, bookingId);
                            sellTicket(showIndex, phoneNumber);
                        }else {
                            System.out.println("No show with that ID");
                        }
                    }
                    toFile();
                    break;
                case 2:
                    readBookingList();
                    break;
                case 9:
                    sentinel = false;
                    break;
            }
        } while (sentinel);
    }

}