/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.hspf.schuster.rs.jax.example.Account;
import de.hspf.schuster.rs.jax.example.AccountRepository;
import de.hspf.schuster.rs.jax.example.TimeService;
import static org.easymock.EasyMock.expect;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.easymock.PowerMock.replayAll;

/**
 *
 * @author Marcel
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeService.class})
public class TimeServiceTest {
    private AccountRepository accountRepository;
    
    public TimeServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        accountRepository = new AccountRepository();
        accountRepository.init();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void whenCreateAccount_ResponseShouldNotBeNull() {
        Account account = new Account();
        
        PowerMock.mockStatic(TimeService.class);
        expect(TimeService.getCurrentTime()).andReturn("test");
        replayAll();
        
        assertNotNull("Response should not be null", accountRepository.createAccount(account));
    }
}
