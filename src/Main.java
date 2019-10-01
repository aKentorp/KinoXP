import Model.Show;
import Repos.BookingRepo;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Show> showList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main(); main.run();

    }

    public void run(){
        Scanner input = new Scanner(System.in);
    int run =1;



            while (run== 1) {
                try {
                    System.out.println("****** KINO ****** \n -Press 1 for bookings \n -Press 2 for shows \n -Press 3 for theaters \n -Press 4 to exit the program" );
                    int menuInput= input.nextInt();
                    switch (menuInput){

                        case 1:
                            //Bookings

                            break;
                        case 2:
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
}
