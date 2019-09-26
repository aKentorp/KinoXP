package Model;

public class Booking {
    private int bookingId;
    private int phoneNumber;
    private int showId;

    public Booking(int phoneNumber, int showId, int bookingId) {
        this.phoneNumber = phoneNumber;
        this.showId = showId;
        this.bookingId = bookingId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getShowId() { return showId; }

    public void setShowId(int showId) { this.showId = showId; }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString(){
        return getPhoneNumber() + " " + getShowId() + " " + getBookingId() +"\n";
    }
}
