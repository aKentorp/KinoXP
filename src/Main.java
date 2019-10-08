import Model.Booking;
import Model.Show;
import Model.Theater;
import Repos.BookingRepo;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private boolean login = false;
    private ShowRepo showRepo;
    private BookingRepo bookingRepo;

    public Main(){
        try {
            File showFile = new File("textFiles\\showInfo.txt");
            showRepo = new ShowRepo(showFile);
            showRepo.fromFile();
            File bookingFile = new File("textFiles\\bookings.txt");
            bookingRepo = new BookingRepo(bookingFile, showRepo);
            bookingRepo.fromFile();
        } catch (FileNotFoundException e){

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);


        tryLogin();


        while (login) {
            System.out.println();
            try {
                System.out.println("****** KINO ******" +
                        "\n-Press 1 for booking menu" +
                        "\n-Press 2 for shows" +
                        "\n-Press 3 for theaters" +
                        "\n-Press 9 to exit the program" );
                int menuInput= input.nextInt();
                switch (menuInput){

                    case 1:
                        bookingRepo.bookingMenu();
                        break;
                    case 2:
                        showRepo.showMenu();
                        //shows
                        break;
                    case 3:
                        //theater
                        showTheaters();
                        break;
                    case 9:
                        //quit program
                        System.out.println("Quitting the program...");
                        login = false;
                        bookingRepo.toFile();
                        showRepo.toFile();
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




    public void showTheaters() throws NoSuchElementException{
        try {
            TheaterRepo theaterRepo = new TheaterRepo();
            Scanner theaterScanner = new Scanner(System.in);
            System.out.println("-Press 1 to add Theater" +
                            "\n-Press 2 to show Theaters" +
                            "\n-Press 9 to exit Theater Menu");
            int choice = theaterScanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Create a new theater");
                    theaterRepo.toFile();
                    break;
                case 2:
                    System.out.println("List of theaters");
                    theaterRepo.showTheaters();
                    break;
                case 9:
                    break;
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
}
