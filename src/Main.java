import Model.Show;
import Repos.BookingRepo;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.util.*;

public class Main {
    private List<Show> showList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main(); main.run();

    }

    public void run(){
        Scanner input = new Scanner(System.in);
    int run =1;



            while (run== 1) {
                ShowRepo showRepo=new ShowRepo();
                showRepo.toFile();
                try {
                    System.out.println("****** KINO ****** \n -Press 1 for bookings \n -Press 2 for shows \n -Press 3 for theaters \n -Press 4 to exit the program" );
                    int menuInput= input.nextInt();
                    switch (menuInput){

                        case 1:
                            //Bookings


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
    public void showBooking(){

    }
    public void showShows() throws NoSuchElementException {
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
                break;
            case 3:
                break;
            default:
                System.out.println("wrong input");
                break;
        }
    }
}
