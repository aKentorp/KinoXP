public class Theater {

    public Theater(int theaterNumber, int numberOfSeats) {
        this.theaterNumber = theaterNumber;
        this.numberOfSeats = numberOfSeats;
    }

    public Theater() {
    }

    private int theaterNumber;
    private int numberOfSeats;




    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Theater number: " + this.theaterNumber + "\n Number of seats: " + this.numberOfSeats;
    }
}
