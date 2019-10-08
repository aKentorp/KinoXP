package Model;

import Repos.TheaterRepo;

import java.util.Date;

public class Show {
    TheaterRepo tr = new TheaterRepo();

    private int showId;
    private int theaterNumber;
    private String title;
    private String genre;
    private int ageLimit;
    private String showDate;
    private int startTime; //militær format eg. 2130 for 21:30
    private int endTime;
    private int remainingSeats;

    public Show(int showId, int theaterNumber, String title, String genre, int ageLimit, String showDate, int startTime, int endTime, int remainingSeats) {
        this.showId = showId;
        this.title = title;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.theaterNumber = theaterNumber;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remainingSeats = remainingSeats;


     }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public String toString() {
        String tempStart = String.valueOf(this.startTime);
        char[] startArr = tempStart.toCharArray();
        String showStart = startArr[0] +""+ startArr[1] + ":" + startArr[2] +""+ startArr[3];

        String tempEnd = String.valueOf(this.endTime);
        char[] endArr = tempEnd.toCharArray();
        String showEnd = endArr[0] +""+ endArr[1] + ":" + endArr[2] + "" + endArr[3];

        return "ShowId: " + this.showId + "\nTitle: " + this.title +"\nGenre: " + this.genre + "\nAge limit: " + this.ageLimit +
                "\nTheater number: " + this.theaterNumber + "\nshow date: " + this.showDate + "\nStart time: " + showStart +
                "\nEnd time: " + showEnd + "\nRemaining seats: "+ this.remainingSeats;
    }
}
