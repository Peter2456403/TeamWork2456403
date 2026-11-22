package com.canteen2.model;

import javax.swing.*;

public class Diner {
    private String cardId;
    private String name;
    private int typeTag;
    protected double balance;

    public Diner(String cardId, String name, int typeTag, double balance) {
        this.cardId = cardId;
        this.name = name;
        this.typeTag = typeTag;
        this.balance = balance;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getTypeTag() { return typeTag; }
    public void setTypeTag(int typeTag) { this.typeTag = typeTag; }

    public double getBalance() { return balance; }

    public boolean consume(double money) {
        if (balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    }

    public void showInfo(JFrame TextOutput) {
        JLabel pCardid = new JLabel(cardId);
        JLabel pName = new JLabel(name);
        JLabel pType = new JLabel();
        if (typeTag==1)
            pType = new JLabel("学生");
        else if (typeTag==2)
            pType = new JLabel("老师");
        JLabel pMoney = new JLabel(""+balance);
        TextOutput.add(pCardid);
        TextOutput.add(pName);
        TextOutput.add(pType);
        TextOutput.add(pMoney);
        /*System.out.printf("卡号: %s 姓名: %s 类型: %d 余额: %.2f 元%n",
                cardId, name, typeTag, balance);*/
    }
}
