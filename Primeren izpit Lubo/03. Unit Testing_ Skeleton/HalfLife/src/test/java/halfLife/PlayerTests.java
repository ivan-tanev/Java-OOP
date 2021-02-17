package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    @Test
    public void testConstructorCreateInstance() {
        Player player = new Player("Ivan", 100);
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetUsername() {
        Player player = new Player("Ivan", 100);
        String actualName = player.getUsername();
        String expectedName = "Ivan";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetInvalidUsername() {
        Player player = new Player(null, 100);
    }

    @Test
    public void testGetHealth() {
        Player player = new Player("Ivan", 100);
        int actualHealth = player.getHealth();
        int expectedHealth = 100;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidHealth() {
        new Player("Ivan", -100);
    }

    @Test
    public void testGetGuns() {
        Player player = new Player("Ivan", 100);
        int actualLength = player.getGuns().size();
        int expectedLength = 0;
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testTakeDamageBelowZero() {
        Player player = new Player("Ivan", 100);
        player.takeDamage(200);
    }

    @Test
    public void testTakeDamage() {
        Player player = new Player("Ivan", 100);
        player.takeDamage(20);
        int actualHealth = player.getHealth();
        int expectedHealth = 80;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGun() {
        Player player = new Player("Ivan", 100);
        player.addGun(null);
    }

    @Test
    public void testAddValidGun() {
        Player player = new Player("Ivan", 100);
        Gun gun = new Gun("AK-47", 30);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun,actualGun);
    }

    @Test
    public void testRemoveGun() {
        Player player = new Player("Ivan", 100);
        Gun gun = new Gun("AK-47", 30);
        player.addGun(gun);
        boolean actualResult = player.removeGun(gun);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testGetValidGun() {
        Player player = new Player("Ivan", 100);
        Gun gun = new Gun("AK-47", 30);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun, actualGun);
    }

    @Test
    public void testGetInvalidGun() {
        Player player = new Player("Ivan", 100);
        Gun gun = new Gun("AK-47", 30);
        player.addGun(gun);
        Gun expectedGun = null;
        Gun actualGun = player.getGun("M-16");
        Assert.assertNull(actualGun);
    }
}
