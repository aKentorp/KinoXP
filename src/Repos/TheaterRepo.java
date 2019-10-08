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
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TheaterRepo {
    ArrayList<Theater> theaterList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

   public TheaterRepo() throws NoSuchElementException {
        readTheater();
    }

    public void toFile(){

        System.out.println("Theater number: ");
        int tempTheaternumber =input.nextInt();
        System.out.println("Number of seats: ");
        int tempNumberOfSeats = input.nextInt();
        theaterList.add(new Theater(tempTheaternumber,tempNumberOfSeats));



        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("textFiles/theaterInfo.txt"));

            for (Theater th: theaterList) {
                bw.write(th.toString());
            }

            bw.close();
        }catch (Exception ex){

        }
    }

    public void showTheaters(){
        for (Theater theater : theaterList) {
            System.out.println("Theater id: " + theater.getTheaterNumber() + " - total seats: " + theater.getNumberOfSeats());
        }
    }


    public void readTheater() throws NoSuchElementException {
        try{
            Scanner fileScan = new Scanner(new File("textFiles/theaterInfo.txt"));

            while(fileScan.hasNextLine()){
                int theaterId = fileScan.nextInt();
                int numberOfSeats = fileScan.nextInt();
                theaterList.add(new Theater(theaterId, numberOfSeats));
            }
        }catch (Exception ex){

         }
    }


    public ArrayList<Theater> getTheaterList(){

       return theaterList;
    }




}
