package de.hspf.schuster.rs.jax.example;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author marcel.viehmaier
 */
@Stateless
@Path("accounts")
public class AccountService {

    @Inject
    AccountRepository accountRepository;

    @GET
    @Path("accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Account> getAccounts() {
        return accountRepository.getAccounts();
    }
    
    @GET
    @Path("account/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("1000") int accountId) {
        return accountRepository.getAccount(accountId);
    }
    
    @POST
    @Path("account")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postAccount(Account account) {
        return accountRepository.createAccount(account);
    }
    
    @PUT
    @Path("account/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account putAccount(@PathParam("accountId") int accountId, Account account) {
        return accountRepository.updateAccount(accountId, account);
    }
    
    @DELETE
    @Path("account/{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAccount(@PathParam("1000") int accountId) {
        accountRepository.deleteAccount(accountId);
    }

}
