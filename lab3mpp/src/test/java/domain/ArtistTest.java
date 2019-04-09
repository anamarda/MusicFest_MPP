package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArtistTest {
    Artist a1;

    @Before
    public void setUp() throws Exception {
        a1 = new Artist("1", "a1");
    }

    @After
    public void tearDown() throws Exception {
        a1 = null;
    }

    @Test
    public void getID() { assertEquals(a1.getID(), "1");}

    @Test
    public void setID(){
        a1.setID(a1.getID());
        assertEquals(a1.getID(), "1");
    }

    @Test
    public void getName() { assertEquals(a1.getName(), "a1");}

    @Test
    public void setName(){
        a1.setName(a1.getName());
        assertEquals(a1.getName(), "a1");
    }
}

