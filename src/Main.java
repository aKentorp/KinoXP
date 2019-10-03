import Model.Booking;
import Model.Show;
import Model.Theater;
import Repos.BookingRepo;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.io.File;
import java.util.*;

public class Main {
    private List<Show> showList = new ArrayList<>();




    private boolean login = false;

    public static void main(String[] args) {
        Main main = new Main();

        BookingRepo bRepo = new BookingRepo();
        bRepo.fromFile(new File("textFiles/bookings.txt"));

        main.run(bRepo);

    }

    public void run(BookingRepo bRepo){
        Scanner input = new Scanner(System.in);
        TheaterRepo tRepo = new TheaterRepo();
        BookingRepo bookingRepo = new BookingRepo();

        tryLogin();


            while (login) {

                try {
                    System.out.println("****** KINO ****** \n -Press 1 for bookings \n -Press 2 for shows \n -Press 3 for theaters \n -Press 4 to exit the program" );
                    int menuInput= input.nextInt();
                    switch (menuInput){

                        case 1:
                            bookingRepo.bookingMenu();
                            /*bookingMenu(bRepo);*/
                            break;
                        case 2:
                            showShows();
                            //shows
                            break;
                        case 3:
                            //theater
                            showTheaters();
                            break;
                        case 4:
                            //quit program
                            System.out.println("Quitting the program...");
                            login = false;
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



    /*public void bookingMenu(BookingRepo bRepo){
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
    }*/


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

                System.out.println("Create new show");
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

    public void showTheaters() throws NoSuchElementException{
        try {
            TheaterRepo theaterRepo= new TheaterRepo();
            Scanner theaterScanner = new Scanner(System.in);
            System.out.println("-Press 1 to add Theater \n -Press 2 to show theaters");
            int choice = theaterScanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Create a new theater");
                    theaterRepo.toFile();
                case 2:
                    System.out.println("List of theaters");
                    theaterRepo.showTheaters();
            }

        }catch (InputMismatchException err){
            System.out.println("Wrong input");
        }

    }

    public void tryLogin(){
        Scanner loginScanner = new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String userName = loginScanner.nextLine();

        System.out.println("Enter Password: ");
        String password = loginScanner.nextLine();


        if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            login = true;
        }



    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }


}
