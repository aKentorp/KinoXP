import Model.Booking;
import Model.Show;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


class BookingTest {

    private Booking book = new Booking(12345678,1,2);


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