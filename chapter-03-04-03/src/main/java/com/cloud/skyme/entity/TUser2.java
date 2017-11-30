package com.cloud.skyme.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TUser2 {
    private Integer id;

    private String username;

    private Byte state;

    private Boolean isdel;

    private Date addTime;

    private BigDecimal money;

    private Float leftMoney;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Float getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(Float leftMoney) {
        this.leftMoney = leftMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}