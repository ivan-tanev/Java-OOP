package halfLife;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void Test_usernameShouldThrowException(){
        Player player = new Player(null, 50);
    }

    @Test
    public void Test_usernameShouldWork(){
        Player player = new Player("Pesho", 50);

        assertEquals("Pesho", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void Test_usernameWithEmptyShouldThrowException(){
        Player player = new Player("", 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_healthShouldThrowException(){
        Player player = new Player("Pesho", -10);
    }

    @Test
    public void Test_healthShouldWork(){
        Player player = new Player("Pesho", 50);

        assertEquals(50, player.getHealth());
    }

    @Test
    public void Test_gunsShouldWork(){
        Gun gun = new Gun("Pepo", 10);
        Player player = new Player("Pesho", 50);
        player.addGun(gun);

        List<Gun> expected = List.of(gun);

        assertEquals(expected, player.getGuns());
    }

    @Test
    public void Test_takeShouldWork(){
        Player player = new Player("Pesho", 50);
        player.takeDamage(5);

        assertEquals(45, player.getHealth());
    }

    @Test
    public void Test_takeShouldWorkV2(){
        Player player = new Player("Pesho", 5);
        player.takeDamage(5);

        assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void Test_takeShouldThrowException(){
        Player player = new Player("Pesho", 0);
        player.takeDamage(10);

    }

    @Test
    public void Test_addGunShouldWork(){
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("Pecata", 5);
        player.addGun(gun);

        assertEquals(List.of(gun), player.getGuns());
    }

    @Test(expected = NullPointerException.class)
    public void Test_addGunShouldThrowException(){
        Player player = new Player("Pesho", 50);

        player.addGun(null);
    }

    @Test
    public void Test_removeGunShouldWork(){
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("Pecata", 5);
        player.addGun(gun);

        assertTrue(player.removeGun(gun));
    }

    @Test
    public void Test_getGunShouldWork(){
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("Pecata", 5);
        player.addGun(gun);
        player.getGun("Pecata");

        assertEquals(gun, player.getGun("Pecata"));
    }

    @Test
    public void Test_getGunShouldReturnNull(){
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("Pecata", 5);
        player.addGun(gun);
        player.getGun("Pecata");

        assertNull(player.getGun("Gosho"));
    }
}
