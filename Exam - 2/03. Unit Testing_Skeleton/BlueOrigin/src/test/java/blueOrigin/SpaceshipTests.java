package blueOrigin;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class SpaceshipTests {

    @Test(expected = NullPointerException.class)
    public void testSpaceshipConstructorWithNULL(){
        new Spaceship(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpaceshipConstructorBellowZero(){
        new Spaceship("Kon", -10);
    }

    @Test
    public void testSpaceshipGETName(){
        Spaceship spaceship = new Spaceship("Kon", 10);
        assertEquals("Kon", spaceship.getName());
    }

    @Test
    public void testSpaceshipGETCapacity(){
        Spaceship spaceship = new Spaceship("Kon", 10);
        assertEquals(10, spaceship.getCapacity());
    }

    @Test
    public void testAddAstronaut(){
        //Spaceship spaceship = new Spaceship("Kon", 10);

        Astronaut astronaut = new Astronaut("Ivo", 15.0);
        Collection<Astronaut> astronauts = new ArrayList<>();
        assertTrue(astronauts.add(astronaut));
    }

    @Test
    public void testSpaceshipGETAstro(){
        Spaceship spaceship = new Spaceship("Kon", 10);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpaceshipAddAstro(){
        Spaceship spaceship = new Spaceship("Kon", 10);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpaceshipAddAstro2(){
        Spaceship spaceship = new Spaceship("Kon", 1);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testSpaceshipRemove(){
        Spaceship spaceship = new Spaceship("Kon", 5);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        assertTrue(spaceship.remove("Ivo"));
    }

    @Test
    public void testSpaceshipRemoveEx(){
        Spaceship spaceship = new Spaceship("Kon", 5);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        assertFalse(spaceship.remove("asd"));
    }

    @Test
    public void testSpaceshipGETCount(){
        Spaceship spaceship = new Spaceship("Kon", 10);
//        Astronaut astronaut = new Astronaut("Ivo", 15.0);
//        Collection<Astronaut> astronauts = new ArrayList<>();
//
//        astronauts.add(astronaut);
        spaceship.getCount();
        assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpaceshipAddAstro23(){
        Spaceship spaceship = new Spaceship("Kon", 3);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);
        Astronaut astronaut1 = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void testSpaceshipAddAs(){
        Spaceship spaceship = new Spaceship("Kon", 3);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);
        Astronaut astronaut1 = new Astronaut("Anto", 15.0);

        spaceship.add(astronaut);
        spaceship.add(astronaut1);
    }

    @Test
    public void testSpaceshipRemove2(){
        Spaceship spaceship = new Spaceship("Kon", 5);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);

        spaceship.add(astronaut);
        assertFalse(spaceship.remove(null));
    }

    @Test
    public void testSpaceshipGETCount2(){
        Spaceship spaceship = new Spaceship("Kon", 10);
        Astronaut astronaut = new Astronaut("Ivo", 15.0);
        Collection<Astronaut> astronauts = new ArrayList<>();

        spaceship.getCount();
    }

}
