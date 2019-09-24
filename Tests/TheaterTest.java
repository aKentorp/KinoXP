import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

    private Theater theater = new Theater();

    @Test
    void getTheaterNumber() {


        assertEquals(5, theater.getTheaterNumber());
    }
}