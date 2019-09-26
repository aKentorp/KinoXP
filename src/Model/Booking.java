package Model;

public class Booking {
    private int phoneNumber;
    private int showId;

    public Booking(int phoneNumber, int showId) {
        this.phoneNumber = phoneNumber;
        this.showId = showId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getShowId() { return showId; }

    public void setShowId(int showId) { this.showId = showId; }

    public void removeAvailableSeatFromShow(){

    }
}