package com.ecut.design;


import com.ecut.design.Config.util.MsgProducer;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootTest
class DesignApplicationTests {
       @Autowired
       UserRepository userRepository;
       @Autowired
       MsgProducer msgProducer;
       @Test
       public void findUserByExamQuery() {
              User user = new User();
              user.setUsername("wei" );

              ExampleMatcher matcher = ExampleMatcher.matching()
                      .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains())//模糊查询匹配开头，即{username}%
                      .withIgnorePaths("id");//忽略字段，即不管id是什么值都不加入查询条件
              Example<User> example = Example.of(user, matcher);
              List<User> userList = userRepository.findAll(example);
              System.out.println(userList);
       }
       @Test
      public void test(){
              for(int i=0;i<10;i++) {
                     msgProducer.sendMsg("测试"+i);
              }
      }

}
