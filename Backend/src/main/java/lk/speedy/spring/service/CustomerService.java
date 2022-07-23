package lk.speedy.spring.service;

import lk.speedy.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    List<String> getAllCustomerIds();
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
}