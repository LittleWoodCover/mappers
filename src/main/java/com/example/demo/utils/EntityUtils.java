package com.example.demo.utils;

import com.example.demo.entity.Account;
import com.example.demo.entity.DeviceEntity;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {

    public static List<DeviceEntity> createList(int count){

        List<DeviceEntity> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            DeviceEntity deviceEntity=new DeviceEntity();
            deviceEntity.setDeviceName("test");
            deviceEntity.setDeviceId(i+"");
            list.add(deviceEntity);
         }
        return list;
    }

    public static List<Account> createList(int begin, String name){

        List<Account> list=new ArrayList<>();

        for(int i=begin;i<begin+3;i++){
            Account account=new Account();
            account.setId(Long.valueOf(i));
            account.setAccountName(name+i);
            list.add(account);
        }
        return list;
    }
}
