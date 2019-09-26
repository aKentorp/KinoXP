package Repos;
import Model.Show;
import Model.Theater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShowRepo {
    List<Show> showList = new ArrayList<>();

    public void createShow(){
        showList.add(new Show(1, "Avatar", "sci-fi", 18, 1, new Date(2019-9-12), 18, 21));
        showList.add(new Show(1, "Avatar", "sci-fi", 18, 1, new Date(2019-9-12), 21, 24));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("textFiles/showInfo.txt"));

            for (Show show: showList) {
                bw.write(show.toString("save"));
            }

            bw.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /*public void createShow(Scanner input){
        System.out.println("Title of the show: ");
        System.out.println("Genre of the show: ");
        System.out.println("Age limit of the show: ");
        System.out.println("Theater number: ");
        System.out.println("Show date: ");
        System.out.println("Start time: ");
        System.out.println("End time: ");
        System.out.println("Remaning seats: ");


        //TODO input menu ti
        //TODO Write to a file (Filereaderc and bufferedwriter)
    }*/
}
