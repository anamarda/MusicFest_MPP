package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ShowTest {
    Show s;
    LocalDate date = LocalDate.now();

    @Before
    public void setUp() throws Exception {
        s = new Show("1", "l", date, 1, 0);
    }

    @After
    public void tearDown() throws Exception {
        s = null;
    }

    @Test
    public void getID() { assertEquals(s.getID(), "1");}

    @Test
    public void setID(){
        s.setID(s.getID());
        assertEquals(s.getID(), "1");
    }


    @Test
    public void getLocation() { assertEquals(s.getLocation(), "l");}

    @Test
    public void setLocation(){
        s.setLocation(s.getLocation());
        assertEquals(s.getLocation(), "l");
    }

    @Test
    public void getDate() { assertEquals(s.getDate(), date);}

    @Test
    public void setDate(){
        s.setDate(s.getDate());
        assertEquals(s.getDate(), date);
    }

    @Test
    public void getAvailable() { assertEquals(s.getNoAvailableTickets().intValue(), 1);}

    @Test
    public void setAvailable(){
        s.setNoAvailableTickets(s.getNoAvailableTickets());
        assertEquals(s.getNoAvailableTickets().intValue(), 1);
    }

    @Test
    public void getSold() { assertEquals(s.getNoSoldTickets().intValue(), 0);}

    @Test
    public void setSold(){
        s.setNoSoldTickets(s.getNoSoldTickets());
        assertEquals(s.getNoSoldTickets().intValue(), 0);
    }
}
