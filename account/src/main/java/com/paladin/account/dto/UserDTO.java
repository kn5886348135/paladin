package com.paladin.account.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDTO {
    private String username;
    private int age;
    private String address;
    private String phoneNum;
    private String email;
    private String job;
    private String interest;
    private String note;
    private float salary;
    private double rent;
    private BigDecimal credit;
    private String birthDay;
    private String countNo;
    private byte sex;
    private short room;
    private long creditNO;
    private String nation;
    private String hoby;
    private String website;
}
