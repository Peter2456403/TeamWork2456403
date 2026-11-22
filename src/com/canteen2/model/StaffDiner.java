package com.canteen2.model;

public class StaffDiner extends Diner {
    private String department;

    public StaffDiner(String cardId, String name, double balance, String department) {
        super(cardId, name, 2, balance);
        this.department = department;
    }

    @Override
    public boolean consume(double money) {
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
    public void showInfo() {
        super.showInfo();
        System.out.println(" 身份：教职工，部门：" + department + "，就餐八五折");
    }
}
