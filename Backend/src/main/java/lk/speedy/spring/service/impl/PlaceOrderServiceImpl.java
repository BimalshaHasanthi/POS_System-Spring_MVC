package lk.speedy.spring.service.impl;

import lk.speedy.spring.dto.CustomerDTO;
import lk.speedy.spring.dto.ItemDTO;
import lk.speedy.spring.dto.OrderDTO;
import lk.speedy.spring.entity.Item;
import lk.speedy.spring.entity.OrderDetail;
import lk.speedy.spring.entity.Order;
import lk.speedy.spring.repository.CustomerRepo;
import lk.speedy.spring.repository.ItemRepo;
import lk.speedy.spring.repository.OrderRepo;
import lk.speedy.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getOrderId() {
        Order top = orderRepo.findTopByOrderByIdDesc();
        if(top!=null){
            Integer index = Integer.getInteger(top.getId().split("-")[1]);
            ++index;
            return index<10 ? "O-00000"+index : index<100 ? "O-0000"+index : index<1000 ? "O-000"+index : index<10000 ? "O-00"+index : index<100000 ? "O-0"+index : "O-"+index;
        }
        return "O-000001";
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if(!customerRepo.findById(id).isPresent()){
            throw new RuntimeException("Customer "+id+" Doesn't Exist...");
        }
        return modelMapper.map(customerRepo.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public ItemDTO getItem(String code) {
        if(!itemRepo.findById(code).isPresent()){
            throw new RuntimeException("Item "+code+" Doesn't Exist...");
        }
        return modelMapper.map(itemRepo.findById(code).get(), ItemDTO.class);
    }

    @Override
    public void purchaseOrder(OrderDTO dto) {
        Order order = modelMapper.map(dto, Order.class);
        if(!orderRepo.existsById(dto.getId())){

            orderRepo.save(order);

            if(dto.getDetailList().isEmpty()){
                throw new RuntimeException("Your Cart is Empty...");
            }

            for(OrderDetail detail: order.getDetailList()){
                Item item = itemRepo.findById(detail.getItemCode()).orElse(new Item());
                item.setQuantity(item.getQuantity()-detail.getQuantity());
                itemRepo.save(item);
            }

        }else{
            throw new RuntimeException("Order "+dto.getId()+" Already Exists...");
        }
    }
}