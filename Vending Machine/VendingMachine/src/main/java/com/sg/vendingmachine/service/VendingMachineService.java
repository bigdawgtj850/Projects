package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ShantelJ
 */
public interface VendingMachineService {
    void setCoins(Change coins);
            
    BigDecimal getBalance();

    Change getCoinInventory();
    
    void adjustCoinInventory(Change coinAdjustments) throws OutOfCoinsException;
    
    void updateItem(InventoryItem item);

    void addItem(InventoryItem item);

    InventoryItem getItem(String name) throws ItemNotFoundException;

    List<InventoryItem> getAllItems();

    BigDecimal addMoney(Change coins);

    BigDecimal addMoney(BigDecimal money);
    
    void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException;
    
    Change coinReturn() throws OutOfCoinsException;
    
    void clearInventory();
    
    void quit() throws VendingMachineDaoException;
    
    void refill(int restockLevel);
    
    void removeItem(int item) throws ItemNotFoundException;
    
    Change createAdjustmentVector(Change adjustment);
    
    Change getErrorReturnedChange();
}
