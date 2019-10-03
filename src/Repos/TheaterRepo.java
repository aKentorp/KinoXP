package Repos;
import Model.Show;
import  Model.Theater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheaterRepo {
    List<Theater> theaterList = new ArrayList<>();

    public TheaterRepo() {
        readTheater();
    }

    public void toFile(int id, int seatNumbers){
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

    public void showTheaters(){
        for (Theater theater : theaterList) {
            System.out.println("Theater id: " + theater.getTheaterNumber() + " - total seats: " + theater.getNumberOfSeats());
        }
    }


    public void readTheater(){
        try{
            Scanner fileScan = new Scanner(new File("textFiles/theaterInfo.txt"));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            while(fileScan.hasNextLine()){
                int theaterId = fileScan.nextInt();
                int numberOfSeats = fileScan.nextInt();
                theaterList.add(new Theater(theaterId, numberOfSeats));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }




}
