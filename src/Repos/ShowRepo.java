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
}
