package com.example.demo.mapper;

import base.BaseMapper;
import com.example.demo.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeviceMapper extends BaseMapper<DeviceEntity>, tk.mybatis.mapper.common.Mapper<DeviceEntity> {

    @Select("SELECT COUNT(1) FROM QD_DEVICE")
    int getCount();
}
