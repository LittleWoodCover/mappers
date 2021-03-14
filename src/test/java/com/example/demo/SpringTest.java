package com.example.demo;


import com.example.demo.config.MyBatisConfig;
import com.example.demo.entity.DeviceEntity;
import com.example.demo.mapper.DeviceMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {


    public ApplicationContext getSpringEnv(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyBatisConfig.class);

        return context;
    }

    @Test
    public void getCount(){

        ApplicationContext context=getSpringEnv();

        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setDeviceId("0");
        DeviceMapper de = context.getBean(DeviceMapper.class);
        System.out.println(de.getCount());
        System.out.println(de.selectOne(deviceEntity));

    }

    public void isExists(){


    }
}