package repo;

import domain.Artist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArtistDbRepoTest {
    ArtistDbRepo repo;

    @Before
    public void setUp() throws Exception {
        repo = new ArtistDbRepo();
    }

    @After
    public void tearDown() throws Exception {
        repo = null;
    }

    @Test
    public void findAll(){
        String ID = repo.findAll().iterator().next().getID();
//        System.out.println(ID);
        assertEquals(ID, "1");
    }
}
