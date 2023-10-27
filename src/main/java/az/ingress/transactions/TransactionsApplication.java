package az.ingress.transactions;
import az.ingress.transactions.model.Account;
import az.ingress.transactions.repository.AccountRepository;
import az.ingress.transactions.service.AccountService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@RequiredArgsConstructor
public class TransactionsApplication implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(TransactionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        Account account1 = new Account();
        account1.setName("Fizaret");
        account1.setBalance(200.0);

        Account account2 = new Account();
        account2.setName("Ali");
        account2.setBalance(20000000.0);


    Account from = accountRepository.findById(3L).get();
    Account to = accountRepository.findById(4L).get();
        accountService.transferProxy(3l,4L,30.0);
    }
}

