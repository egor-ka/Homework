package tasks.task7.task7_1;

import tasks.task7.task7_1.account.Account;

/**
 * Created by Egor on 16.09.2016.
 */
public class Transfer {

    private Account withdrawingAccount;
    private Account depositingAccount;
    private int transferAmount;

    public Transfer(Account withdrawingAccount, Account depositingAccount, int transferAmount) {
        this.withdrawingAccount = withdrawingAccount;
        this.depositingAccount = depositingAccount;
        this.transferAmount = transferAmount;
    }

    public boolean perform() {
        if (withdrawingAccount.withdrawMoney(transferAmount)) {
            depositingAccount.depositMoney(transferAmount);
            return true;
        }
        return false;
    }
}
