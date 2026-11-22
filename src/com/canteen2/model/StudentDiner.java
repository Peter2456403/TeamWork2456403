package com.canteen2.model;

import javax.swing.*;

public class StudentDiner extends Diner {
    private String className;

    public StudentDiner(String cardId, String name, double balance, String className) {
        super(cardId, name, 1, balance);
        this.className = className;
    }

    @Override
    public boolean consume(double money) {
        return super.consume(money);
    }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    @Override
    public void showInfo(JFrame TextOutput) {
        super.showInfo(TextOutput);
        JLabel pDiscount = new JLabel("1");
        JLabel pCome = new JLabel("班级："+className);
        TextOutput.add(pDiscount);
        TextOutput.add(pCome);
        /*super.showInfo();
        System.out.println(" 身份：在校学生，班级：" + className);*/
    }
}
