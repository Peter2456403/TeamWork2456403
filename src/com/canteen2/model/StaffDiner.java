package com.canteen2.model;

import javax.swing.*;

/**
 * 子类：教职工就餐人员，八五折优惠
 */
public class StaffDiner extends Diner {
    private String department; // 教职工独有：所属部门
    public StaffDiner(String cardId, String name, double balance, String department) {
        super(cardId, name, 2, balance);
        this.department = department;
    }
    @Override
    public boolean consume(double money) {
// 多态重写：教职工八五折
        double realPay = money * 0.85;
        if (balance >= realPay) {
            balance -= realPay;
            return true;
        }
        return false;
    }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    @Override
    public void showInfo(JFrame TextOutput) {
        super.showInfo(TextOutput);
        JLabel pDiscount = new JLabel("0.85");
        JLabel pCome = new JLabel("部门："+department);
        TextOutput.add(pDiscount);
        TextOutput.add(pCome);
        //System.out.println(" 身份：教职工，部门：" + department + "，就餐八五折");
    }
}