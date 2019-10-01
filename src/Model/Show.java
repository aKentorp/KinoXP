package Model;

import java.util.Date;

public class Show {
    private int showId;
    private int theaterNumber;
    private String title;
    private String genre;
    private int ageLimit;
    private String showDate;
    private int startTime; //militær format eg. 2130 for 21:30
    private int endTime;
    private int remainingSeats;

    public Show(int showId, int theaterNumber, String title, String genre, int ageLimit, String showDate, int startTime, int endTime) {
        this.showId = showId;
        this.title = title;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.theaterNumber = theaterNumber;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String toString(String overload) {
        if(overload.equalsIgnoreCase("display")){
            return "Title: " + this.title +"\n Genre: " + this.genre + "\n Age limit: " + this.ageLimit + "\n Theater number: " + this.theaterNumber + "\n show date: " + this.showDate + "\n Start time: " + this.startTime + "\n End time: " + this.endTime + "\n Remaining seats: "+ this.remainingSeats;
        }else{
            return getShowId() + " " + getTheaterNumber() + " " + getTitle() + " " + getGenre() + " " + getAgeLimit() + " " + getShowDate() + " " + getStartTime() + " " + getEndTime() + "\n";
        }
    }
}
