package tasks.task7.task7_1;

import tasks.task7.task7_1.account.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * Created by Egor on 16.09.2016.
 */
public class Bank {

    private ArrayList<Account> accountList;
    private ArrayList<Transfer> transferList;

    public Bank() {
        accountList = new ArrayList<>();
        transferList = new ArrayList<>();
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

    public void getTransferList(String name) {
        String fileText = readFile(name);

        Pattern patternTextString = Pattern.compile("(\\w+)\\s(\\w+)\\s(\\d+)");
        Matcher matcherTextString = patternTextString.matcher(fileText);

        int index = 0;
        while (matcherTextString.find(index)) {
                transferList.add(new Transfer(
                        getAccountByName(matcherTextString.group(1)),
                        getAccountByName(matcherTextString.group(2)),
                        parseInt(matcherTextString.group(3))));
            index = matcherTextString.end();
        }
    }

    public void performTransfers() {
        for (Transfer transfer: transferList) {
            transfer.perform();
        }
    }

    public void printAccounts() {
        for (Account account: accountList) {
            System.out.println(account.getName() + " holds <" + account.getMoney() + "> money");
        }
    }

    public ArrayList<Transfer> getTransferList() {
        return transferList;
    }


    private String readFile(String name) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    private Account getAccountByName(String name) {
        for (Account account: accountList) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }
}
