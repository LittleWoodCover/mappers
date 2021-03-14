package com.example.demo.mapper;

import com.example.demo.config.MyBatisConfig;
import com.example.demo.entity.Account;
import com.example.demo.entity.DeviceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        MyBatisConfig.class
})
public class DeviceMapperTest {

    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    ApplicationContext context;

    @Test
    public void test(){

        System.out.println(deviceMapper.getCount());
        DeviceEntity deviceEntity = deviceMapper.selectByPrimaryKey("0");
        System.out.println(deviceEntity);
    }

    @Test
    public void isExists(){

        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setDeviceId("0");
        System.out.println(deviceMapper.existsWithPrimaryKey(deviceEntity));

        DeviceEntity entity=new DeviceEntity();
        entity.setDeviceName("test");
        System.out.println(deviceMapper.existsWithPrimaryKey(entity));

    }

    @Test
    public void insert(){
        Account account=new Account();
        account.setAccountName("zhangsan");
        account.setAge(18);

        System.out.println(accountMapper.insert(account));
        System.out.println(account.getId());
    }

    /**
     * 非主键字段如果为空就不加入sql语句中
     */
    @Test
    public void insertSelective(){
        Account account=new Account();
        account.setAccountName("zhangsan");

        System.out.println(accountMapper.insertSelective(account));
        System.out.println(account.getId());
    }

    @Test
    public void updateByPrimaryKeySelective(){
        Account account=new Account();
        account.setId(2l);
        account.setAge(19);
        System.out.println(accountMapper.updateByPrimaryKeySelective(account));
        System.out.println(account.getId());
    }

    @Test
    public void deleteByPrimaryKey(){
        Account account=new Account();
        account.setId(2l);
        account.setAge(19);
        //delete方法非常危险，一不小心就会删空表！！！
        System.out.println(accountMapper.deleteByPrimaryKey(account));
    }


}