import Model.Theater;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

    private Theater theater = new Theater(1, 2);

    @Test
    void getTheaterNumber() {


        assertEquals(5, theater.getTheaterNumber());
    }
}