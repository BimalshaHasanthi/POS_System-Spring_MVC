package lk.speedy.spring.repository;

import lk.speedy.spring.entity.OrderDetail;
import lk.speedy.spring.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, OrderDetailPK> {

}



