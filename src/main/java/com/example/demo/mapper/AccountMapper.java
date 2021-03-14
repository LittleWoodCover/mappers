package com.example.demo.mapper;

import base.BaseMapper;
import com.example.demo.entity.Account;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface AccountMapper extends BaseMapper<Account>, Mapper<Account> {
}
