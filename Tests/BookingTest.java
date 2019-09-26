import Model.Booking;
import Model.Show;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void getPhoneNumber() {
        List<Show> showList = new ArrayList<>();
        showList.add(new Show(1, "Avengers", "Action", 18, 1, new Date(), 1,2 ));
        Booking booking = new Booking(12345678, 1);

        assertEquals(12345678, booking.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void getShowList() {
    }

    @Test
    void setShowList() {
    }
}