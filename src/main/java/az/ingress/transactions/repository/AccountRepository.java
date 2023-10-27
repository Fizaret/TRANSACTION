package az.ingress.transactions.repository;

import az.ingress.transactions.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account,Long>{
}
