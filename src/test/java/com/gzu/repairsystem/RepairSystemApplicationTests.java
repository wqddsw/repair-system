package com.gzu.repairsystem;

import com.gzu.repairsystem.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gzu.repairsystem.mapper.UserMapper;
import java.util.List;

@SpringBootTest
class RepairSystemApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}