import Model.Show;
import Repos.ShowRepo;
import Repos.TheaterRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

class showRepoTest {
    Scanner input = new Scanner(System.in);
    private TheaterRepo theaterRepo = new TheaterRepo();
    private ShowRepo showRepo = new ShowRepo();
    private Show show1 = new Show(1, 2, "The Horror Show!", "horror", 16,  "10-10-2019", 2130, 2300, 250);

    @Test
    void createShow() {
        List<Show> actualShows = new ArrayList<>();  //Listen der skal checkes
        actualShows.add(show1); //Listen får tilføjet et show

        assertThat(actualShows, hasItem(show1));  //arrerter at actualShows har item 'show1', som det burde, da det lige er blevet tilføjet
    }
}