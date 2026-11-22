package com.canteen2.model;

import javax.swing.*;

/**
 * 子类：学生就餐人员，按原价扣款
 */
public class StudentDiner extends Diner {
    private String className; // 学生独有：所在班级
    public StudentDiner(String cardId, String name, double balance, String className) {
        super(cardId, name, 1, balance); // 复用父类构造
        this.className = className;
    }
    @Override
    public boolean consume(double money) {
// 学生无折扣，直接复用父类规则
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
        //System.out.println(" 身份：在校学生，班级：" + className);
    }
}