package test.task7.task7_1;

import org.junit.Before;
import org.junit.Test;
import tasks.task7.task7_1.*;
import tasks.task7.task7_1.account.Account;
import tasks.task7.task7_1.account.ConcurrentAccount;
import tasks.task7.task7_1.account.SynchronizedAccount;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 17.09.2016.
 */
public class BankTest {

    private static final String FILE_NAME = "C:/Users/Egor/IdeaProjects/Homework/src/resources/task7/task7_1/transfer_info.txt";

    private Bank bank;
    private ArrayList<Account> concurrentAccounts;
    private ArrayList<Account> synchronizedAccounts;

    @Before
    public void setUp() {
        bank = new Bank();
        concurrentAccounts = new ArrayList<>();
        synchronizedAccounts = new ArrayList<>();

        concurrentAccounts.add(new ConcurrentAccount("account_1", 1000));
        concurrentAccounts.add(new ConcurrentAccount("account_2", 1000));
        concurrentAccounts.add(new ConcurrentAccount("account_3", 1000));

        synchronizedAccounts.add(new SynchronizedAccount("account_1", 1000));
        synchronizedAccounts.add(new SynchronizedAccount("account_2", 1000));
        synchronizedAccounts.add(new SynchronizedAccount("account_3", 1000));
    }

    @Test
    public void synchronizedAccountsBankTest() {
        bank.setAccountList(synchronizedAccounts);
        bank.getTransferList(FILE_NAME);

        System.out.println("Before synchronized transfers:");
        bank.printAccounts();

        Thread thread = getPerformTransferThread();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After synchronized transfers:");
        bank.printAccounts();

        assertEquals("Wrong result", 1100, synchronizedAccounts.get(0).getMoney());
    }

    @Test
    public void concurrentAccountsBankTest() {
        bank.setAccountList(concurrentAccounts);
        bank.getTransferList(FILE_NAME);

        System.out.println("Before concurrent transfers:");
        bank.printAccounts();

        Thread thread = getPerformTransferThread();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("After concurrent transfers:");
        bank.printAccounts();

        assertEquals("Wrong result", 1100, concurrentAccounts.get(0).getMoney());
    }

    public Thread getPerformTransferThread() {
        ArrayList<Transfer> transfers = bank.getTransferList();

        return new Thread(new Runnable() {
            @Override
            public void run() {
                for (Transfer transfer: transfers) {
                    transfer.perform();
                }
            }
        });
    }
}
