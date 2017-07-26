
import com.juvenxu.mvnbook.account.account.persist.Account;
import com.juvenxu.mvnbook.account.account.persist.AccountPersistException;
import com.juvenxu.mvnbook.account.account.persist.AccountPersistService;
import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fujd
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;
    
    @Before
    public void prepare() throws AccountPersistException{
        File persistDataFile = new File("target/test-classes/persist-data.xml");
//        if(persistDataFile.exists()){
//            persistDataFile.delete();
//        }
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService)ctx.getBean("accountPersistService");
        
        
        
    }
    
    
    public void testReadAccount() throws AccountPersistException{
        Account account = service.readAccount("zhangsanid");
        
        assertNotNull(account);
        assertEquals("zhangsanid",account.getId());
    }
    
    
    @Test
    public void testCreatAccount() throws AccountPersistException{
        Account account = new Account();
        account.setId("id11");
        account.setName("name11");
        account.setEmail("email11");
        account.setPassword("passwor11");
        account.setActivated(true);
        
        Account acc1 = service.creatAccount(account);
        assertNotNull(acc1);
    }
}
