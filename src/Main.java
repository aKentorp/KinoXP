import Model.Show;
import Repos.ShowRepo;
import Repos.TheaterRepo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Show> showList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main(); main.run();
    }

    public void run(){
        TheaterRepo tp = new TheaterRepo();
        tp.createTheater(1, 1);


        ShowRepo sp = new ShowRepo();
        sp.createShow();
    }
}
