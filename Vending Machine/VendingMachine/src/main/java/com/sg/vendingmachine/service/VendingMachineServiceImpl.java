package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.InventoryItem;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ShantelJ
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    private VendingMachineDao dao;
    private BigDecimal balance;
    private Change coinInventory;
    private List<InventoryItem> itemList;
    private Change returnedChange;

    public VendingMachineServiceImpl(VendingMachineDao dao) throws VendingMachineDaoException {
        this.dao = dao;
        balance = new BigDecimal("0.00");
        try {
            dao.loadItems();
        } catch (VendingMachineDaoException e) {
            throw e;
        }
        itemList = dao.getAllItems();
        itemList.sort(Comparator.comparing(InventoryItem::getName));
        coinInventory = dao.getCoins();
    }

    @Override
    public void setCoins(Change coins) {
        coinInventory = coins;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Change getCoinInventory() {
        return coinInventory;
    }

    @Override
    public void adjustCoinInventory(Change coinAdjustments) throws OutOfCoinsException {
        if (((coinAdjustments.getQuarters() < 0) && (coinAdjustments.getQuarters() * -1 > coinInventory.getQuarters()))
                || ((coinAdjustments.getDimes() < 0) && (coinAdjustments.getDimes() * -1 > coinInventory.getDimes()))
                || ((coinAdjustments.getNickels() < 0) && (coinAdjustments.getNickels() * -1 > coinInventory.getNickels()))
                || ((coinAdjustments.getPennies() < 0) && (coinAdjustments.getPennies() * -1 > coinInventory.getPennies()))) {
            throw new OutOfCoinsException("You requested more coins than are available. No changes were made.");
        }

        coinInventory.adjustBy(coinAdjustments);
    }

    // Don't worry about which property changed, just replace the item
    @Override
    public void updateItem(InventoryItem item) {
        int i = itemList.indexOf(item);
        itemList.remove(i);
        itemList.add(i, item);
    }

    @Override
    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    @Override
    public InventoryItem getItem(String name) throws ItemNotFoundException {
        for (InventoryItem item : itemList) {
            if (name.equals(item.getName())) {
                return item;
            }
        }

        throw new ItemNotFoundException("Item does not exist.");
    }

    @Override
    public List<InventoryItem> getAllItems() {
        return itemList;
    }

    @Override
    public BigDecimal addMoney(Change coins) {
        balance = balance.add(coins.getBalance());
        coinInventory.adjustBy(coins);
        return balance;
    }

    @Override
    public BigDecimal addMoney(BigDecimal money) {
        return addMoney(new Change(money));
    }

    @Override
    public void vendItem(String name) throws ItemNotFoundException, InsufficientFundsException, ZeroInventoryException {
        InventoryItem item = getItem(name);
        if (item.getStockLevel() <= 0) {
            throw new ZeroInventoryException("Item out of stock.");
        }

        if (balance.compareTo(item.getPrice()) < 0) {
            throw new InsufficientFundsException("Insufficient funds, please add more and try again.");
        }

        balance = balance.subtract(item.getPrice());
        item.setStockLevel(item.getStockLevel() - 1);
        updateItem(item);
    }

    @Override
    public Change coinReturn() throws OutOfCoinsException {
        returnedChange = coinInventory.subtractRespectingPositiveCoinTotals(new Change(balance));      
        
        if(coinInventory.getBalance().intValue() == 0) {
            throw new OutOfCoinsException("This machine is out of change. Call us at 555-555-5555 for more information.");
        }
        balance = new BigDecimal("0.00");
        return returnedChange;
    }

    // Needed for testing
    @Override
    public void clearInventory() {
        itemList.clear();
    }

    @Override
    public void quit() throws VendingMachineDaoException {
        dao.saveItems(itemList, coinInventory);
    }

    @Override
    public void refill(int restockLevel) {
        itemList.forEach((item) -> item.setStockLevel(restockLevel));
    }

    @Override
    public void removeItem(int item) throws ItemNotFoundException {
        if (-1 < item && item < itemList.size()) {
            itemList.remove(item);
        } else {
            throw new ItemNotFoundException("Item not found.");
        }
    }

    @Override
    public Change createAdjustmentVector(Change adjustment) {

        return new Change(adjustment.getQuarters() - coinInventory.getQuarters(),
                          adjustment.getDimes() - coinInventory.getDimes(),
                          adjustment.getNickels() - coinInventory.getNickels(),
                          adjustment.getPennies() - coinInventory.getPennies());
    }
    
    @Override
    public Change getErrorReturnedChange() {
        return returnedChange;
    }
}
