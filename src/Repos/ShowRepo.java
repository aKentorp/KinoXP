package Repos;
import Model.Show;
import Model.Theater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowRepo {
    List<Show> showList = new ArrayList<>();

    public void readShow(){
        try{
            Scanner fileScan = new Scanner(new File("textFiles/showInfo.txt"));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            while(fileScan.hasNextLine()){

                int showId = fileScan.nextInt();
                int theaterId = fileScan.nextInt();
                String[] tempShowTitle = fileScan.next().split("_");
                String showTitle = "";
                String showGenre = fileScan.next();
                int ageLimit = fileScan.nextInt();
                String showDate = fileScan.next();
                int showStart = fileScan.nextInt();
                int showEnd = fileScan.nextInt();

                for (int i = 0; i < tempShowTitle.length; i++){
                    String prefix = "";
                    if(i < tempShowTitle.length){ prefix = " "; }else{ prefix = ""; }
                    showTitle += tempShowTitle[i] + prefix;
                }

                showList.add(new Show(showId, theaterId, showTitle, showGenre, ageLimit, showDate, showStart, showEnd));
                //System.out.println(fileScan.next());
            }

        }catch (Exception ex){

        }

        for (Show show: showList) {
            System.out.println(show.toString("display"));
            System.out.println();
        }
    }

    public void toFile(){
        showList.add(new Show(1, 1, "Avatar", "sci-fi", 18, "2019-9-12", 18, 21));
        showList.add(new Show(1, 1, "Die_Hard", "Action", 21, "2019-01-01", 21, 24));

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
