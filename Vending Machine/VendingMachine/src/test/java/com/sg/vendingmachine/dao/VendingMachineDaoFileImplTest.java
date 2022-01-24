package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stuart
 */
public class VendingMachineDaoFileImplTest {

    VendingMachineDaoFileImpl instance = new VendingMachineDaoFileImpl("testItems.txt", "testCoins.txt");
    public static void tearDownClass() {
    }

    // Each test, set up the class to have two items
    @Before
    public void setUp() {
        instance.clearInventory();
        InventoryItem item = new InventoryItem("Test Item 1");
        item.setPrice(new BigDecimal("1.50"));
        item.setStockLevel(1);
        instance.addItem(item);

        InventoryItem item2 = new InventoryItem("Test Item 2");
        item.setPrice(new BigDecimal("2.50"));
        item.setStockLevel(2);
        instance.addItem(item2);
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test of getAllItems method, of class VendingMachineDaoFileImpl.
     */
    @Test
    public void testGetAllItems() {
        assertEquals(2, instance.getAllItems().size());
    }
    
    @Test
    public void testSaveAndLoadItems() throws Exception {
        instance.saveItems();
        instance.clearInventory();
        instance.loadItems();
        assertNotEquals(0, instance.getAllItems().size());
        assertNotEquals(null, instance.getCoins());
    }
}
