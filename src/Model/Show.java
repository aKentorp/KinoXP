package Model;

import java.util.Date;

public class Show {

    private String title;
    private String genre;
    private int ageLimit;
    private int theaterNumber;
    private Date showDate;
    private Date startTime;
    private Date endTime;
    private int remainingSeats;

    public Show(String title, String genre, int ageLimit, int theaterNumber, Date showDate, Date startTime, Date endTime) {
        this.title = title;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.theaterNumber = theaterNumber;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    @Override
    public String toString() {
        return "Title: " + this.title +"\n Genre: " + this.genre + "\n Age limit: " + this.ageLimit + "\n Theater number: " + this.theaterNumber + "\n show date: " + this.showDate + "\n Start time: " + this.startTime + "\n End time: " + this.endTime + "\n Remaining seats: "+ this.remainingSeats;
    }
}
