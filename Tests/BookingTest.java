import Model.Booking;
import Model.Show;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

class BookingTest {

    private Booking book =new Booking(12345678,1,2);

    @Test
    void getPhoneNumber() {
        List<Show> showList = new ArrayList<>();
        showList.add(new Show(1, "Avengers", "Action", 18, 1, new Date(), 1,2 ));
        Booking booking = new Booking(12345678, 1,2);

        assertEquals(12345678, booking.getPhoneNumber());
    }
    @Test
    void createBooking(){
        List<Booking> bookList = new ArrayList<>();
        bookList.add(book);

        assertThat(bookList, hasItem(book));
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