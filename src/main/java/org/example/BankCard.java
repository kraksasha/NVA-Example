package org.example;

import lombok.Data;
import java.util.List;
@Data
public abstract class BankCard {

    private int balance;

    public abstract void addMoney(int money);
    public abstract boolean buy(int money);
    public abstract int getMyBalance();
    public abstract List<Integer> getMyAllMoney();
}
