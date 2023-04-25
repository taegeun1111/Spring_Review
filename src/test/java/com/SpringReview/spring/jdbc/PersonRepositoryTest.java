package com.SpringReview.spring.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @Test
    @DisplayName("사람의 이름과 나이 정보를 잘 입력")
    void saveTest(){
        Person p = new Person();
        p.setAge(60);
        p.setPersonName("rl3333홍");

        repository.save(p);
    }

    @Test
    @DisplayName("update")
    public void updateTest(){
        Person p = new Person();
        p.setPersonName("23232332323");
        p.setAge(99);
        p.setId(1L);
        repository.update(p);
    }

    @Test
    public void findAllTest(){
        List<Person> all = repository.findAll();
        for (Person person : all) {
            System.out.println("person = " + person);
        }
    }

    @Test
    public void findOneTest(){
        long inputNum = 3L;
        Person one = repository.findOne(inputNum);
        System.out.println("one = " + one);
    }
}