package bankSafe;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    @Before
    public void setUp() throws OperationNotSupportedException, IllegalArgumentException{
        Map<String, Item> vaultCells = new LinkedHashMap<>();
        vaultCells.put("A1", null);
        vaultCells.put("A2", null);
        vaultCells.put("A3", null);
        vaultCells.put("A4", null);
        vaultCells.put("B1", null);
        vaultCells.put("B2", null);
        vaultCells.put("B3", null);
        vaultCells.put("B4", null);
        vaultCells.put("C1", null);
        vaultCells.put("C2", null);
        vaultCells.put("C3", null);
        vaultCells.put("C4", null);
    }

    @Test
    public void testConstructor(){
        BankVault bankVault = new BankVault();
//        Item item = new Item("Ivan", "123");
//        vaultCells.put("A1", item);
        assertNotNull(bankVault);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCells(){
        BankVault bankVault = new BankVault();
        Map<String, Item> vaultCells = new LinkedHashMap<>();
        Item item = new Item("Ivan", "123");
        String cell = "A1";
        vaultCells.put(cell, item);

        bankVault.getVaultCells().remove(0);
        bankVault.getVaultCells();
    }

    @Test
    public void testGetVaultCells1(){
        BankVault bankVault = new BankVault();

        bankVault.getVaultCells();
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem("A1", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItem() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem(null, item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItem1() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        //bankVault.getVaultCells().get(null);
        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullItem2() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem("A1", null);
    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullItem() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem("A1", item);
        bankVault.removeItem(null, item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNullItem2() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Ivan", "123");
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", null);
    }
}