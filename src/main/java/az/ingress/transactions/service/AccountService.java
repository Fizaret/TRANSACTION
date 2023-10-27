package az.ingress.transactions.service;
import az.ingress.transactions.model.Account;
import az.ingress.transactions.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final EntityManagerFactory entityManagerFactory;

    public void transferProxy(Long fromId,Long toId,Double amount) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            Account from = em.find(Account.class,fromId);
            Account to = em.find(Account.class,toId);
            transfer(from,to,amount);
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.getTransaction().commit();
            em.close();
        }
    }

    public void transfer(Account from,Account to,Double amount) throws Exception{
        if (from.getBalance() <=amount){
            throw new RuntimeException("Balance Not Enough");
        }
        from.setBalance(from.getBalance() - amount);
        log.info("I am waiting for 5 second,because internet connection is not siuatable");
        to.setBalance(to.getBalance() + amount);
        Thread.sleep(10000);



    }

}
