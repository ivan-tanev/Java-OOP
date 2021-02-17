package computers;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    // TODO: Test ComputerManager

    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;

    @Before
    public void setUp(){
        this.computerManager = new ComputerManager();
        computer1 = new Computer("Asus", "ROG", 2000);
        computer2 = new Computer("HP", "Pavilion", 1500);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersList(){
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerNullValidation (){
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerValidation (){
        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer1);
    }

    @Test
    public void testAddComputer (){
        this.computerManager.addComputer(computer1);
        assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputer (){
        this.computerManager.getComputer(null , "testModel" );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerAnother (){
        this.computerManager.getComputer("testDifferentModel", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNoneExistingComputer (){
        this.computerManager.getComputer(computer1.getManufacturer(), computer1.getModel());
    }

    @Test
    public void testGetReturnCorrect() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Computer returned = this.computerManager.getComputer(computer1.getManufacturer(), computer1.getModel());
        assertNotNull(returned);

        assertEquals(computer1.getManufacturer(), returned.getManufacturer());
        assertEquals(computer1.getModel(), returned.getModel());
    }

    @Test
    public void testGetComputersByManufacturer() {
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        List<Computer> list = computerManager.getComputersByManufacturer(computer1.getManufacturer());

        assertNotNull(list);
        assertEquals(list.get(0).getManufacturer(), computer1.getManufacturer());
    }

    @Test
    public void testGetComputersByManufacturerWhenEmpty() {

        List<Computer> list = computerManager.getComputersByManufacturer(computer1.getManufacturer());

        assertNotNull(list);
        assertTrue(list.isEmpty());
    }
}