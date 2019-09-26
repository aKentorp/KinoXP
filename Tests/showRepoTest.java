import Model.Show;
import Repos.ShowRepo;
import Repos.TheaterRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

class showRepoTest {
    private TheaterRepo theaterRepo = new TheaterRepo();
    private ShowRepo showRepo = new ShowRepo();
    private Show show1 = new Show(1, "The Horror Show!", "horror", 16, 1, new Date(2019-9-26), 2130, 2300);

    @Test
    void createShow() {
        List<Show> actualShows = new ArrayList<>();  //Listen der skal checkes
        actualShows.add(show1); //Listen får tilføjet et show

        assertThat(actualShows, hasItem(show1));  //arrerter at actualShows har item 'show1', som det burde, da det lige er blevet tilføjet


    }
}