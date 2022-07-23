package lk.speedy.spring.repository;

import lk.speedy.spring.config.JpaConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = JpaConfig.class)
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {
    @Autowired
    CustomerRepo repo;

    @Test
    void getAllIds() {
        List<String> allIds = repo.getAllIds();
        allIds.forEach(System.out::println);
    }
}