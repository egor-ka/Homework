package tasks.task7.task7_1.account;

import tasks.task7.task7_1.account.Account;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Egor on 16.09.2016.
 */
public class ConcurrentAccount extends Account {

    private static Lock lock = new ReentrantLock();

    public ConcurrentAccount(String name, int money) {
        super(name, money);
    }

    public ConcurrentAccount(String name) {
        super(name, 0);
    }

    @Override
    public void depositMoney(int moneyAmount) {
        lock.lock();
        money += moneyAmount;
        lock.unlock();
    }

    @Override
    public boolean withdrawMoney(int moneyAmount) {
        lock.lock();
        if (money < moneyAmount) {
            lock.unlock();
            return false;
        }
        money -= moneyAmount;
        lock.unlock();
        return true;
    }
}
