import Model.Theater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {
private Theater theater = new Theater(5,50);
    @Test
    void getTheaterNumber() {
        assertEquals(50,theater.getNumberOfSeats());
    }

    @Test
    void getNumberOfSeats() {
    }

    @Test
    void testToString() {
        assertEquals("Theater number: 5\n" +
                " Number of seats: 50", theater.toString() );
    }
}