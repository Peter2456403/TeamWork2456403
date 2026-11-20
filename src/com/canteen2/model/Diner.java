package com.canteen2.model;
/**
 * 父类：二号食堂就餐人员
 */
public class Diner {
    // 封装：字段全部私有，外部不能直接访问
    private String cardId; // 就餐卡号
    private String name; // 姓名
    private int typeTag; // 人员类型：1 学生，2 教职工
    // protected：同包及子类可见，其他包不可见
    protected double balance; // 账户余额
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
    /**
     * 消费扣款，由子类重写（多态核心）
     * @param money 菜品原始金额
     * @return 扣款成功返回 true，余额不足返回 false
     */
    public boolean consume(double money) {
        if (balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    }
    public void showInfo() {
        System.out.printf("卡号：%s 姓名：%s 类型：%d 余额：%.2f 元%n",
                cardId, name, typeTag, balance);
    }
}