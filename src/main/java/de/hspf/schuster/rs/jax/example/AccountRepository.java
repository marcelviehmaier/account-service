package de.hspf.schuster.rs.jax.example;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author marcel.viehmaier
 */
@Singleton
public class AccountRepository {

    private final static Logger LOGGER = Logger.getLogger(AccountRepository.class.getName());
    private static int idCounter = 1000;
    private final ArrayList<Account> accountList = new ArrayList();

    @PostConstruct
    public void init() {
        LOGGER.info("Initialize AccountRepository Singleton...");
    }

    public ArrayList<Account> getAccounts() {
        return accountList;
    }

    public Account getAccount(int accountId) {
        for (Account account : accountList) {
            if (account.getId() == (accountId))  {
                LOGGER.log(Level.INFO, "Return Account with id {0}", account.getId());
                return account;
            }
        }
        LOGGER.log(Level.INFO, "Account with id {0} not found", accountId);
        return null;
    }

    public Account createAccount(Account account) {
        LOGGER.info("Create new Account...");
        account.setId(idCounter);
        accountList.add(account);
        idCounter += 1;
        LOGGER.info("Created account at " + TimeService.getCurrentTime());
        return account;
    }
    
    public Account updateAccount(int accountId, Account account) {
        LOGGER.info("test" + accountId);
        for (Account acc : accountList) {
            if (acc.getId() == (accountId))  {
                LOGGER.log(Level.INFO, "Change Account with id {0}", acc.getId());
                acc.setUsername(account.getUsername());
                acc.setFirstName(account.getFirstName());
                acc.setLastName(account.getLastName());
                acc.setPassword(account.getPassword());
                acc.setEmail(account.getEmail());
                return account;
            }
        }
        LOGGER.log(Level.INFO, "Account with id {0} not found", accountId);
        return null;
    }
    
    public void deleteAccount(int accountId) {
        for (Account acc : accountList) {
            if (acc.getId() == (accountId))  {
                LOGGER.log(Level.INFO, "Delete Account with id {0}", accountId);
                accountList.remove(acc);
            }
        }
    }
}
