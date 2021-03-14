package com.example.demo.mapper;

import com.example.demo.config.MyBatisConfig;
import com.example.demo.entity.Account;
import com.example.demo.entity.DeviceEntity;
import com.example.demo.utils.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * QBC
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = MyBatisConfig.class
)
public class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void queryByExample(){

        Example example=new Example(Account.class);
        example.orderBy("id").asc().orderBy("age").desc();
        Example.Criteria criteria01 = example.createCriteria();
        Example.Criteria criteria02 = example.createCriteria();
        criteria01
                .andGreaterThan("id",3)
                .andLessThan("id",5);
        criteria02
                .andGreaterThan("id",5)
                .andLessThan("age",24);
        example.or(criteria02);
        List<Account> accounts = accountMapper.selectByExample(example);
        System.out.println(accounts);
    }

    @Test
    public void updateBatch0(){


        List<Account> list = EntityUtils.createList(4, "zhangsan");
        accountMapper.updateBatch0(list);
    }
}