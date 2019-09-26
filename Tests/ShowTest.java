import Model.Show;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {

    private Show show = new Show(1, "Avengers", "Action", 18, 1, new Date(), 1, 2);
    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getGenre() {
    }

    @Test
    void setGenre() {
    }

    @Test
    void getAgeLimit() {
        assertEquals(12, show.getAgeLimit());
    }

    @Test
    void setAgeLimit() {
        show.setAgeLimit(25);
        assertEquals(25, show.getAgeLimit());
    }

    @Test
    void getTheaterNumber() {
        assertEquals(2, show.getTheaterNumber());
    }

    @Test
    void setTheaterNumber() {
        show.setTheaterNumber(10);
        assertEquals(2, show.getTheaterNumber());
    }

    @Test
    void getShowDate() {
    }

    @Test
    void setShowDate() {
    }

    @Test
    void getStartTime() {
    }

    @Test
    void setStartTime() {
    }

    @Test
    void getEndTime() {
    }

    @Test
    void setEndTime() {
    }
}