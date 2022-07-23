package lk.speedy.spring.repository;

import lk.speedy.spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {
    Order findTopByOrderByIdDesc();
}
