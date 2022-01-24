package com.sg.vendingmachine.dto;

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
public class ChangeTest {

    Change instance = new Change();

    public ChangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testJustQuarters() {
        instance.setBalance(new BigDecimal("1.0"));
        assertEquals(4, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndDimes() {
        instance.setBalance(new BigDecimal("1.10"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndNickelsAndDimes() {
        instance.setBalance(new BigDecimal("1.15"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testQuartersAndNickelsAndDimesandPennies() {
        instance.setBalance(new BigDecimal("1.16"));
        assertEquals(4, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }

    @Test
    public void testZeroBalance() {
        instance.setBalance(new BigDecimal("0"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testDimesAndNickelsAndPennies() {
        instance.setBalance(new BigDecimal("0.16"));
        assertEquals(0, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }

    @Test
    public void testNickelsAndPennies() {
        instance.setBalance(new BigDecimal("0.06"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
    }

    @Test
    public void testPennies() {
        instance.setBalance(new BigDecimal("0.03"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(3, instance.getPennies());
    }

    @Test
    public void testNickels() {
        instance.setBalance(new BigDecimal("0.05"));
        assertEquals(0, instance.getQuarters());
        assertEquals(0, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }

    @Test
    public void testDimes() {
        instance.setBalance(new BigDecimal("0.20"));
        assertEquals(0, instance.getQuarters());
        assertEquals(2, instance.getDimes());
        assertEquals(0, instance.getNickels());
        assertEquals(0, instance.getPennies());
    }
    
    @Test
    public void testCoinsConstructor() {
        instance = new Change(1,1,1,1);
        assertEquals(1, instance.getQuarters());
        assertEquals(1, instance.getDimes());
        assertEquals(1, instance.getNickels());
        assertEquals(1, instance.getPennies());
        assertEquals(new BigDecimal("0.41"), instance.getBalance());
    }
    
    @Test
    public void testAddCoins() {
        instance.adjustBy(1, 1, 1, 1);
        assertEquals(new BigDecimal("0.41"), instance.getBalance());
    }
    
    @Test
    public void testAddCoinsTwice() {
        instance.adjustBy(1, 1, 1, 1);
        instance.adjustBy(1, 1, 1, 1);
        assertEquals(new BigDecimal("0.82"), instance.getBalance());
    }
    
    @Test
    public void testAdjustNegativeCoins() {
        instance.setBalance(new BigDecimal("0.00"));
        instance.adjustBy(new Change(-5,-5,-5,-5));
        assertEquals(new Change(-5,-5,-5,-5), instance);
        assertEquals(new BigDecimal("-2.05"),instance.getBalance());
    }
    
    @Test
    public void testSubtract() {
        Change c1 = new Change(1,1,1,1);
        Change c2 = new Change(1,1,1,1);
        assertEquals(new BigDecimal("0.41"), c1.subtractRespectingPositiveCoinTotals(c2).getBalance());
        assertEquals(new BigDecimal("0.00"), c1.getBalance());
        assertEquals(0, c1.getQuarters());
        assertEquals(0, c1.getDimes());
        assertEquals(0, c1.getNickels());
        assertEquals(0, c1.getPennies()); 
    }
    
    @Test
    public void testSubtractBig() {
        Change c1 = new Change(1,1,1,1);
        Change c2 = new Change(5,5,5,5);
        assertEquals(new BigDecimal("0.41"), c1.subtractRespectingPositiveCoinTotals(c2).getBalance());
        assertEquals(new BigDecimal("0.00"), c1.getBalance());
        assertEquals(0, c1.getQuarters());
        assertEquals(0, c1.getDimes());
        assertEquals(0, c1.getNickels());
        assertEquals(0, c1.getPennies()); 
    }
    
    @Test
    public void testSubtractNoQuarters() {
        Change c1 = new Change(0,10,10,10); // 1.60
        Change c2 = new Change(2,5,5,5);    // 1.30
        Change result = c1.subtractRespectingPositiveCoinTotals(c2);
        assertEquals(new BigDecimal("1.30"), result.getBalance());
        assertEquals(new BigDecimal("0.30"), c1.getBalance());
        assertEquals(0, result.getQuarters());
        assertEquals(10, result.getDimes());
        assertEquals(5, result.getNickels());
        assertEquals(5, result.getPennies()); 
        assertEquals(0, c1.getQuarters());
        assertEquals(0, c1.getDimes());
        assertEquals(5, c1.getNickels());
        assertEquals(5, c1.getPennies()); 
    }
}
