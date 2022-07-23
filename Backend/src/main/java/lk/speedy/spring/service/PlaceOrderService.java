package lk.speedy.spring.service;

import lk.speedy.spring.dto.CustomerDTO;
import lk.speedy.spring.dto.ItemDTO;
import lk.speedy.spring.dto.OrderDTO;

public interface PlaceOrderService {
    String getOrderId();
    CustomerDTO getCustomer(String id);
    ItemDTO getItem(String code);
    void purchaseOrder(OrderDTO dto);
}
