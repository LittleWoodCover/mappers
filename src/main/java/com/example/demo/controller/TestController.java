package com.example.demo.controller;

import com.example.demo.entity.DeviceEntity;
import com.example.demo.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @Autowired
    DeviceMapper mapper;

    @RequestMapping("count")
    public String getCount(){

        return mapper.getCount()+"";
    }

    @RequestMapping("insert")
    public Integer insert(){
        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setDeviceId("111");
        deviceEntity.setDeviceName("000000");
        return mapper.insert(deviceEntity);
    }
}
