package domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    Employee e1;

    @Before
    public void setUp() throws Exception {
        e1 = new Employee("1", "n1", "l1");
    }

    @After
    public void tearDown() throws Exception {
        e1 = null;
    }

    @Test
    public void getID() { assertEquals(e1.getID(), "1");}

    @Test
    public void setID(){
        e1.setID(e1.getID());
        assertEquals(e1.getID(), "1");
    }

    @Test
    public void getName() { assertEquals(e1.getName(), "n1");}

    @Test
    public void setName(){
        e1.setName(e1.getName());
        assertEquals(e1.getName(), "n1");
    }

    @Test
    public void getLocation() { assertEquals(e1.getLocation(), "l1");}

    @Test
    public void setLocation(){
        e1.setLocation(e1.getLocation());
        assertEquals(e1.getLocation(), "l1");
    }
}
