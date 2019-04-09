package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TicketTest {
    Ticket t;
    Show s;
    Artist a;
    LocalDate date = LocalDate.now();

    @Before
    public void setUp() throws Exception {
        s = new Show("1", "l", date, 1, 0);
        t = new Ticket("1", s.getID(), "a");
    }

    @After
    public void tearDown() throws Exception {
        t = null;
        s = null;
    }

    @Test
    public void getID() { assertEquals(t.getID(), "1");}

    @Test
    public void setID(){
        t.setID(t.getID());
        assertEquals(t.getID(), "1");
    }

    @Test
    public void getShow() { assertEquals(t.getIDShow(), s.getID());}

    @Test
    public void setArtist(){
        t.setShow(t.getIDShow());
        assertEquals(t.getIDShow(), s.getID());
    }

    @Test
    public void getPurchaser() { assertEquals(t.getPurchaser(), "a");}

    @Test
    public void setPurchaser(){
        t.setPurchaser(t.getPurchaser());
        assertEquals(t.getPurchaser(), "a");
    }
}
