package Repos;
import  Model.Theater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TheaterRepo {
    List<Theater> theaterList = new ArrayList<>();

    public void createTheater(int id, int seatNumbers){
        theaterList.add(new Theater(1, 20));
        theaterList.add(new Theater(2, 25));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("textFiles/theaterInfo.txt"));

            for (Theater th: theaterList) {
                bw.write(th.toString());
            }

            bw.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }




}
