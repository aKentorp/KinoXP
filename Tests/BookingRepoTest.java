import Model.Booking;
import Repos.BookingRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

class BookingRepoTest {

    BookingRepo bkr = new BookingRepo();

    @Test
    void createBookingList() {
        Booking testBooking = new Booking(123132, 1, 1);

        ArrayList<Booking> testList = bkr.createBookingList();

        assertThat(testList, hasItem(testBooking) );
    }
}