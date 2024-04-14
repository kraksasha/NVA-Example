package org.example;

import java.util.ArrayList;
import java.util.List;
public class CreditCard extends BankCard{
    private int creditPart;
    private DebitCard debitCard;
    private int bonusBefore;

    public CreditCard(DebitCard debitCard) {
        this.debitCard = debitCard;
        creditPart = Parametr.creditLimit;
        bonusBefore = 0;
    }

    @Override
    public void addMoney(int money) {
        if (creditPart != Parametr.creditLimit){
            int allSum = creditPart + money;
            if (allSum > Parametr.creditLimit){
                int partMoney = allSum - Parametr.creditLimit;
                int newAllSum = allSum - partMoney;
                creditPart = newAllSum;
                debitCard.setBalance(partMoney);
            } else {
                creditPart = allSum;
            }
        } else{
            int allSum = debitCard.getMyBalance() + money;
            debitCard.setBalance(allSum);
        }
    }

    @Override
    public boolean buy(int money) {
        if (debitCard.getMyBalance() >= money){
            int allSum = debitCard.getMyBalance() - money;
            debitCard.setBalance(allSum);
            bonusBefore = (int) (bonusBefore + money*Parametr.percentBonus);
            debitCard.setBonus(bonusBefore);
            return true;
        } else if (creditPart + debitCard.getMyBalance() >= money){
            int partMoney = money - debitCard.getMyBalance();
            bonusBefore = (int) (bonusBefore + debitCard.getMyBalance()*Parametr.percentBonus);
            debitCard.setBonus(bonusBefore);
            debitCard.setBalance(0);
            if (partMoney >= Parametr.minSumBuy){
                int cashBack = (int) (partMoney*Parametr.percentCashBack);
                int allSum = creditPart - partMoney + cashBack;
                creditPart = allSum;
            } else {
                int allSum = creditPart - partMoney;
                creditPart = allSum;
            }
            return true;
        }
        return false;
    }

    @Override
    public int getMyBalance() {
        return 0;
    }

    @Override
    public List<Integer> getMyAllMoney() {
        List<Integer> list = new ArrayList<>();
        list.add(Parametr.creditLimit);
        list.add(creditPart);
        list.add(debitCard.getMyBalance());
        list.add(debitCard.getBonus());
        return list;
    }
}
