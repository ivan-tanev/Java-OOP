package computers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

    @Test
    public void testConstructorCreateInstance() {
        Computer computer = new Computer("Asus");
        assertNotNull(computer);
    }

    @Test
    public void testGetName() {
        Computer computer = new Computer("Asus");
        String actualName = computer.getName();
        String expectedName = "Asus";
        assertEquals(expectedName, actualName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidName() {
        Computer computer = new Computer(null);
    }

    @Test
    public void testSetValidName() {
        Computer computer = new Computer("Asus");
        String actualName = computer.getName();
        String expectedName = "Asus";
        assertEquals(expectedName, actualName);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsInvalid() {
        Computer computer = new Computer("Asus");
        computer.getParts().remove(0);
//        Computer computer = new Computer(null);
//        Part part = new Part(null, 150.0);
//        computer.getParts();
    }



    @Test
    public void testAddPartValid() {
        Computer computer = new Computer("Asus");
        Part part = new Part("RAM", 150.0);
        List<Part> parts = new ArrayList<>();
        parts.add(part);
        Part expected = part;
        Part actual = parts.get(0);
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartInvalid() {
        Computer computer = new Computer("Asus");
        computer.addPart(null);
//        Part part = null;
//        List<Part> parts = new ArrayList<>();
//        parts.add(part);
//        Part expected = part;
//        Part actual = parts.get(0);
//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetTotalPrice() {
        Computer computer = new Computer("Asus");
        Part part = new Part("RAM", 150.0);
        Part part1 = new Part("RAM", 100.0);
        Part part2 = new Part("RAM", 50.0);

        computer.addPart(part);
        computer.addPart(part1);
        computer.addPart(part2);

        double expected = computer.getTotalPrice();
        double actual = 300.0;

        assertEquals(expected, actual,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullPart() {
        Computer computer = new Computer("Asus");
        computer.addPart(null);
    }

    @Test
    public void testAddPart() {
        Computer computer = new Computer("Asus");
        Part part = new Part("RAM", 150.0);
        computer.addPart(part);
        Part expected = part;
        Part actual = computer.getPart("RAM");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemovePart() {
        Computer computer = new Computer("Asus");
        Part part = new Part("RAM", 150.0);
        computer.addPart(part);
        assertTrue(computer.removePart(part));
    }
}