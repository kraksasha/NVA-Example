package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DebitCard debitCard = new DebitCard();
        CreditCard creditCard = new CreditCard(debitCard);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Вы можете произвести такие операции как: пополнить, купить, баланс");
        while (true){
            System.out.println("Введите требуемую операцию");
            String data = bufferedReader.readLine();
            if (data.equalsIgnoreCase("пополнить")){
                System.out.println("Введите сумму");
                String dataMoney = bufferedReader.readLine();
                int dataMoneyParse = Integer.parseInt(dataMoney);
                creditCard.addMoney(dataMoneyParse);
                System.out.println("Успешное пополнение");
                List<Integer> list = creditCard.getMyAllMoney();
                System.out.println("Кредитная карта с лимитом: " + list.get(0));
                System.out.println("Кредитная часть: " + list.get(1));
                System.out.println("Собственные средства: " + list.get(2));
                System.out.println("Бонусы по дебетовой карте: " + list.get(3));
            }

            if (data.equalsIgnoreCase("купить")){
                System.out.println("Введите стоимость покупки");
                String dataMoney = bufferedReader.readLine();
                int dataMoneyParse = Integer.parseInt(dataMoney);
                if (creditCard.buy(dataMoneyParse)){
                    System.out.println("Успешное списание");
                    List<Integer> list = creditCard.getMyAllMoney();
                    System.out.println("Кредитная карта с лимитом: " + list.get(0));
                    System.out.println("Кредитная часть: " + list.get(1));
                    System.out.println("Собственные средства: " + list.get(2));
                    System.out.println("Бонусы по дебетовой карте: " + list.get(3));
                } else {
                    System.out.println("Недостаточно средств");
                }
            }

            if (data.equalsIgnoreCase("баланс")){
                List<Integer> list = creditCard.getMyAllMoney();
                System.out.println("Кредитная карта с лимитом: " + list.get(0));
                System.out.println("Кредитная часть: " + list.get(1));
                System.out.println("Собственные средства: " + list.get(2));
                System.out.println("Бонусы по дебетовой карте: " + list.get(3));
            }
        }
    }
}