package com.champion;

import com.champion.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringSecurityApplicationTests {


    @Test
    public void test() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
        boolean matches = passwordEncoder.matches("1234", "$2a$10$J65S519hkmZwkWMEJH9UQOK0aJOMG3OXxd08Ogn0pJ79mgZJdmi/e");
        System.out.println(matches);
    }

    @Autowired
    private MenuMapper mapper;
    @Test
    void Test1(){
        List<String> strings = mapper.selectPermsByUserId(2L);
        strings.forEach(System.out::println);
    }
}


