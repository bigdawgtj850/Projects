package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 * @author ShantelJ
 */
public class Change {

    private BigDecimal balance;
    private int quarters, dimes, nickels, pennies;

    public Change() {
        this.balance = new BigDecimal("0.00");
        updateCoins();
    }

    public Change(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }

    public Change(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
        updateBalance();
    }

    private void updateCoins() {
        BigDecimal[] arr = balance.divideAndRemainder(new BigDecimal("0.25"));
        quarters = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.10"));
        dimes = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.05"));
        nickels = arr[0].intValue();
        arr = arr[1].divideAndRemainder(new BigDecimal("0.01"));
        pennies = arr[0].intValue();
    }

    private void updateBalance() {
        if (quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0) {
            balance = new BigDecimal("0.00");
        } else {
            balance = new BigDecimal(quarters * 0.25 + dimes * 0.10 + nickels * 0.05 + pennies * 0.01);
            balance = balance.setScale(2, RoundingMode.HALF_UP);
        }
    }

    public void adjustBy(int quarters, int dimes, int nickels, int pennies) {
        this.quarters += quarters;
        this.dimes += dimes;
        this.nickels += nickels;
        this.pennies += pennies;
        updateBalance();
    }

    public void adjustBy(Change change) {
        Change.this.adjustBy(change.getQuarters(), change.getDimes(), change.getNickels(), change.getPennies());
    }

    public Change subtractRespectingPositiveCoinTotals(Change changeNeeded) {
        int quartersNeeded = changeNeeded.getQuarters();
        int dimesNeeded = changeNeeded.getDimes();
        int nickelsNeeded = changeNeeded.getNickels();
        int penniesNeeded = changeNeeded.getPennies();
        int q, d, n, p;
        if (this.quarters >= quartersNeeded) {
            this.quarters -= quartersNeeded;
            q = quartersNeeded;
        } else {
            q = this.quarters;
            quartersNeeded -= this.quarters;
            this.quarters = 0;
            dimesNeeded += (quartersNeeded * 25) / 10;
            nickelsNeeded += (quartersNeeded * 25) % 10;
        }

        if (this.dimes >= dimesNeeded) {
            this.dimes -= dimesNeeded;
            d = dimesNeeded;
        } else {
            d = this.dimes;
            dimesNeeded -= this.dimes;
            this.dimes = 0;
            nickelsNeeded += dimesNeeded * 2;
        }

        if (this.nickels >= nickelsNeeded) {
            this.nickels -= nickelsNeeded;
            n = nickelsNeeded;
        } else {
            n = this.nickels;
            nickelsNeeded -= this.nickels;
            this.nickels = 0;
            penniesNeeded += nickelsNeeded * 5;
        }

        if (this.pennies >= penniesNeeded) {
            this.pennies -= penniesNeeded;
            p = penniesNeeded;
        } else {
            p = this.pennies;
            this.pennies = 0;
        }

        updateBalance();
        
        
        if(penniesNeeded > 0) {
            return new Change(q,d,n, -1*penniesNeeded);
        }
        
        return new Change(q, d, n, p);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // TODO: Remove and only use coin methods
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
        updateCoins();
    }

    public int getQuarters() {
        return quarters;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getPennies() {
        return pennies;
    }

    @Override
    public String toString() {
        return "Q: " + this.quarters
                + " D: " + this.dimes
                + " N: " + this.nickels
                + " P: " + this.pennies;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Change other = (Change) obj;
        if (this.quarters != other.quarters) {
            return false;
        }
        if (this.nickels != other.nickels) {
            return false;
        }
        if (this.dimes != other.dimes) {
            return false;
        }
        if (this.pennies != other.pennies) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        return true;
    }

}
