package tasks.task7.task7_1.account;

/**
 * Created by Egor on 16.09.2016.
 */
public abstract class Account {
    protected String name;
    protected int money;

    public Account() {}

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public Account(String name) {
        this(name, 0);
    }

    public abstract void depositMoney(int moneyAmount);

    public abstract boolean withdrawMoney(int moneyAmount);

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
