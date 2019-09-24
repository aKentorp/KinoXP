import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {

    private Show show = new Show();
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
        assertEquals(12, show.setAgeLimit());
    }

    @Test
    void getTheaterNumber() {
        assertEquals(2, show.getTheaterNumber());
    }

    @Test
    void setTheaterNumber() {
        assertEquals(2, show.setTheaterNumber());
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