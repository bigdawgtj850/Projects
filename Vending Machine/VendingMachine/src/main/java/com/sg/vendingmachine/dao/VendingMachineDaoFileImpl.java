package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.InventoryItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ShantelJ
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private ArrayList<InventoryItem> itemList;
    private Change coins;
    private String itemFile;
    private String coinFile;
    private final static String DELIMITER = "::";

    public VendingMachineDaoFileImpl(String itemFile, String coinFile) {
        this.itemList = new ArrayList<>();
        this.itemFile = itemFile;
        this.coinFile = coinFile;
        coins = new Change(0,0,0,0);
    }

    public VendingMachineDaoFileImpl() {
        this.itemList = new ArrayList<>();
        itemFile = "items.txt";
        coinFile = "coins.txt";
        coins = new Change(0,0,0,0);
    }

    // Needed for testing
    @Override
    public void addItem(InventoryItem item) {
        itemList.add(item);
    }

    @Override
    public List<InventoryItem> getAllItems() {
        List<InventoryItem> list = new ArrayList<>();
        itemList.forEach(item -> list.add(item));

        return list;
    }

    @Override
    public void loadItems() throws VendingMachineDaoException {
        Scanner scn;
        InventoryItem item;

        // First load items
        try {
            scn = new Scanner(new File(itemFile));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not open " + itemFile, e);
        }

        String currentLine;
        String[] currentTokens;
        while (scn.hasNextLine()) {
            currentLine = scn.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            // Skip malformed lines
            if (currentTokens.length == 3) {
                item = new InventoryItem(currentTokens[0]);
                item.setPrice(new BigDecimal(currentTokens[1]));
                item.setStockLevel(Integer.parseInt(currentTokens[2]));
                itemList.add(item);
            }

        }
        scn.close();

        // Then load coins
        try {
            scn = new Scanner(new File(coinFile));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("Could not open " + itemFile, e);
        }

        currentLine = scn.nextLine();
        currentTokens = currentLine.split(DELIMITER);

        int q, d, n, p;
        // Skip malformed lines
        if (currentTokens.length == 4) {
            q = Integer.parseInt(currentTokens[0]);
            d = Integer.parseInt(currentTokens[1]);
            n = Integer.parseInt(currentTokens[2]);
            p = Integer.parseInt(currentTokens[3]);
        } else {
            throw new VendingMachineDaoException("Coin file malformed, please check " + coinFile);
        }

        coins = new Change(q, d, n, p);
        scn.close();
    }

    @Override
    public void saveItems() throws VendingMachineDaoException {
        try {
            saveItems(itemList, coins);
        } catch (VendingMachineDaoException e) {
            throw e;
        }
    }

    @Override
    public void saveItems(List<InventoryItem> items, Change coins) throws VendingMachineDaoException {
        PrintWriter itemWriter, coinWriter;

        // First write items
        try {
            itemWriter = new PrintWriter(new FileWriter(itemFile));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not save inventory data.", e);
        }

        items.forEach(item -> itemWriter.println(
                item.getName() + DELIMITER
                + item.getPrice() + DELIMITER
                + item.getStockLevel() + DELIMITER));

        itemWriter.close();

        // Then write coins
        try {
            coinWriter = new PrintWriter(new FileWriter(coinFile));
        } catch (IOException e) {
            throw new VendingMachineDaoException("Could not save coin data.", e);
        }

        coinWriter.println(
                coins.getQuarters() + DELIMITER
                + coins.getDimes() + DELIMITER
                + coins.getNickels() + DELIMITER
                + coins.getPennies() + DELIMITER);
        coinWriter.close();
    }

    @Override
    public Change getCoins() {
        return coins;
    }

    @Override
    public void clearInventory() {
        itemList.clear();
    }
}
