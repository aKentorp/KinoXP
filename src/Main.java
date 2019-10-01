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
                    System.out.println("****** KINO ******");

                }catch (InputMismatchException err){
                        System.out.println("Wrong input");
                        input.next();
                    }
            }




        TheaterRepo tp = new TheaterRepo();
        tp.createTheater(1, 1);


        ShowRepo sp = new ShowRepo();
        sp.createShow();

        BookingRepo bp = new BookingRepo();
        bp.createBooking();

    }
}
