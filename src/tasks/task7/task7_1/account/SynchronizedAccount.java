package tasks.task7.task7_1.account;

import tasks.task7.task7_1.account.Account;

/**
 * Created by Egor on 16.09.2016.
 */
public class SynchronizedAccount extends Account {

    public SynchronizedAccount(String name, int money) {
        super(name, money);
    }

    public SynchronizedAccount(String name) {
        super(name, 0);
    }

    @Override
    public synchronized void depositMoney(int moneyAmount) {
        money += moneyAmount;
    }

    @Override
    public synchronized boolean withdrawMoney(int moneyAmount) {
        if (money < moneyAmount) {
            return false;
        }
        money -= moneyAmount;
        return true;
    }

}
