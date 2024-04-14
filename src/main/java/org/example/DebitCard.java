package org.example;

import lombok.Data;

import java.util.List;
@Data
public class DebitCard extends BankCard{

    private int bonus;

    @Override
    public void addMoney(int money) {
        int allSum = getBalance() + money;
        setBalance(allSum);
    }

    @Override
    public boolean buy(int money) {
        return false;
    }

    @Override
    public int getMyBalance() {
        return getBalance();
    }

    @Override
    public List<Integer> getMyAllMoney() {
        return null;
    }
}
