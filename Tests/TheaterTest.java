import Model.Theater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheaterTest {

    private Theater theater = new Theater(1, 2);

    @Test
    void getTheaterNumber() {


        assertEquals(5, theater.getTheaterNumber());
    }
}