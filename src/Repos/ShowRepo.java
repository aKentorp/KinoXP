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
        Scanner input= new Scanner(System.in);

        System.out.println("ID for the movie:");
        int tempID= input.nextInt();
        System.out.println("Theater number:");
        int tempTheaterNumber= input.nextInt();
        input.nextLine();
        System.out.println("Title of the movie (use _ instead of spaces): ");
        String tempTitle = input.nextLine();
        System.out.println("Genre:");
        String tempGenre= input.nextLine();
        System.out.println("Age limit: ");
        int tempAgeLimit = input.nextInt();
        input.nextLine();
        System.out.println("Date of the movie:");
        String tempShowDate= input.nextLine();
        System.out.println("Start time:");
        int tempStartTime= input.nextInt();
        System.out.println("End time:");
        int tempEndTime= input.nextInt();
        showList.add(new Show(tempID,tempTheaterNumber,tempTitle,tempGenre,tempAgeLimit,tempShowDate,tempStartTime,tempEndTime));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("textFiles/showInfo.txt",true));

            for (Show show: showList) {
                bw.write(show.toString("save"));

            }

            bw.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
