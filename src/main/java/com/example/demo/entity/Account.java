package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "qd_account")
public class Account {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
            //oracle数据库需要打开下面的注释：
            //,generator = "SELECT SEQ_ID.NEXTVAL FROM DUAL"
    )
    private Long id;

    private String accountName;

    private Integer age;

    /**
     * 表明这个字段在数据库里是没有的。不需要进行映射
     */
    @Transient
    private String message;
}
