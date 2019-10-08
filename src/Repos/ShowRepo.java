package Repos;
import Model.Show;
import Model.Theater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowRepo {
    private List<Show> showList = new ArrayList<>();
    private File fileName;
    private int showId = 0;

    public ShowRepo(File fileName){
        this.fileName = fileName;
    }

    public void showMenu() throws NoSuchElementException {
        try{
            Scanner showScanner = new Scanner(System.in);
            System.out.println("-Press 1 to see current shows" +
                    "\n-Press 2 to create show" +
                    "\n-Press 3 to delete a show");
            int input = showScanner.nextInt();
            switch (input){
                case 1:

                    System.out.println("Current shows:");
                    readShow();
                    break;
                case 2:

                    System.out.println("Create new show");
                    createShow();
                    toFile();
                    break;
                case 3:

                    //ikke lavet endnu
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }catch (InputMismatchException err){
            System.out.println("wrong input");
        }
    }

    public void fromFile() throws FileNotFoundException {
        try{
            Scanner fileScan = new Scanner(fileName);
            while(fileScan.hasNextLine()){

                String[] showLine = fileScan.nextLine().split("%%");

                int showId = Integer.parseInt(showLine[0]);
                int theaterId = Integer.parseInt(showLine[1]);
                String showTitle = showLine[2];
                String showGenre = showLine[3];
                int ageLimit = Integer.parseInt(showLine[4]);
                String showDate = showLine[5];
                int showStart = Integer.parseInt(showLine[6]);
                int showEnd = Integer.parseInt(showLine[7]);
                int remainingSeats = Integer.parseInt(showLine[8]);

                showList.add(new Show(showId, theaterId, showTitle, showGenre, ageLimit, showDate, showStart, showEnd, remainingSeats));
            }
            if (showList.isEmpty()){
                System.out.println("No bookings yet.");
            } else {
                showId = showList.get(showList.size() - 1).getShowId();
            }

        }catch (Exception e){
            System.out.println("Filen: " + e.getMessage());
        }
    }


    public void readShow(){
        for (Show show: showList) {
            System.out.println(show.toString());
            System.out.println();
        }
        if(showList.isEmpty()){
            System.out.println("List is empty");
        }
    }

    public void createShow(){

        TheaterRepo tr = new TheaterRepo();

        Scanner input= new Scanner(System.in);

        System.out.println("Theater number:");
        int tempTheaterNumber= input.nextInt();
        input.nextLine();
        System.out.println("Title of the movie: ");
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
        int remainingSeats = 22;

        tr.readTheater();
        ArrayList<Theater> theaterList = tr.getTheaterList();

        for(Theater t : theaterList){
            if(t.getTheaterNumber() == tempTheaterNumber){
                remainingSeats = t.getNumberOfSeats();
            }
        }

        this.showId++;

        showList.add(new Show(this.showId, tempTheaterNumber, tempTitle, tempGenre, tempAgeLimit, tempShowDate, tempStartTime, tempEndTime, remainingSeats));
    }

    public void toFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for(int i = 0; i < showList.size(); i++){
                if (i < showList.size()-1) {
                    bw.write(showList.get(i).getShowId() + "%%" + showList.get(i).getTheaterNumber() + "%%" +
                            showList.get(i).getTitle() + "%%" + showList.get(i).getGenre() + "%%" + showList.get(i).getAgeLimit() + "%%" +
                            showList.get(i).getShowDate() + "%%" + showList.get(i).getStartTime() + "%%" + showList.get(i).getEndTime() + "%%" +
                            showList.get(i).getRemainingSeats() + "\n");
                }else {
                    bw.write(showList.get(i).getShowId() + "%%" + showList.get(i).getTheaterNumber() + "%%" +
                            showList.get(i).getTitle() + "%%" + showList.get(i).getGenre() + "%%" + showList.get(i).getAgeLimit() + "%%" +
                            showList.get(i).getShowDate() + "%%" + showList.get(i).getStartTime() + "%%" + showList.get(i).getEndTime() + "%%" +
                            showList.get(i).getRemainingSeats());
                }

            }

            bw.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Show> getShowList() {
        return showList;
    }
}
