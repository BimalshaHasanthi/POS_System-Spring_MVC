package lk.speedy.spring.repository;
import lk.speedy.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value="SELECT id FROM Customer")
    List<String> getAllIds();
}
