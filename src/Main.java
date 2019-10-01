import Model.Show;
import Repos.BookingRepo;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.io.File;
import java.util.*;

public class Main {
    private List<Show> showList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();

        BookingRepo bRepo = new BookingRepo();
        bRepo.fromFile(new File("textFiles/bookings.txt"));

        main.run(bRepo);

    }

    public void run(BookingRepo bRepo){
        Scanner input = new Scanner(System.in);
    int run =1;



            while (run== 1) {

                try {
                    System.out.println("****** KINO ****** \n -Press 1 for bookings \n -Press 2 for shows \n -Press 3 for theaters \n -Press 4 to exit the program" );
                    int menuInput= input.nextInt();
                    switch (menuInput){

                        case 1:
                            bookingMenu(bRepo);
                            break;
                        case 2:
                            showShows();
                            //shows
                            break;
                        case 3:
                            //theater
                            break;
                        case 4:
                            //quit program
                            System.out.println("Quitting the program...");
                            run=2;
                            break;
                        default:
                            //if the input is not 1-4, it will start the loop over
                            System.out.println("Not a valid input");
                            break;
                    }


                }catch (InputMismatchException err){
                        System.out.println("Wrong input");
                        input.next();
                    }
            }


    }

    public void bookingMenu(BookingRepo bRepo){
        Scanner input = new Scanner(System.in);
        boolean bookingRun = true;

        while (bookingRun){
            System.out.println("Press 1: create a booking." +
                    "\nPress 2: show booking list." +
                    "\nPress 9: exit bookings.");
            try {
                int bookingChoice = input.nextInt();
                input.nextLine();
                switch (bookingChoice){
                    case 1:
                        try{
                            System.out.print("What is customers phoneNumber: ");
                            int phoneNumber = input.nextInt();
                            int length = String.valueOf(phoneNumber).length();
                            if (length != 8){
                                System.out.println("Invalid phonenumber, booking not created");
                                break;
                            }
                            input.nextLine();

                            System.out.print("What is the show ID: ");
                            int showId = input.nextInt();
                            input.nextLine();

                            System.out.print("What is the booking ID: ");
                            int bookingId = input.nextInt();
                            input.nextLine();

                            bRepo.createBooking(phoneNumber, showId, bookingId);
                        }catch (InputMismatchException e){
                            System.out.println("Wrong input, booking not created");
                        }
                    case 2:
                        bRepo.readBookingList();
                        break;
                    case 9:
                        bookingRun = false;
                        break;
                    default:
                        System.out.println("Not a valid input");
                        break;
                }
            }catch (InputMismatchException err){
                System.out.println("Wrong input");
                input.next();
            }
        }
    }


    public void showShows() throws NoSuchElementException {
        try{
        ShowRepo showRepo = new ShowRepo();
        Scanner showScanner = new Scanner(System.in);
        System.out.println("-Press 1 to see current shows \n -Press 2 to create show \n -Press 3 to delete a show");
        int input = showScanner.nextInt();
        switch (input){
            case 1:
                System.out.println("Current shows:");
                showRepo.readShow();
                break;
            case 2:
                //TODO den her skal laves pænere med en scanner, så man selv kan skrive information om showet
                System.out.println("Create new show:");
                showRepo.toFile();
                break;
            case 3:
                //ikke lavet endnu
                break;
            default:
                System.out.println("wrong input");
                break;
        }
    }catch (InputMismatchException err){
            System.out.println("wrong input");
        }
    }
}
