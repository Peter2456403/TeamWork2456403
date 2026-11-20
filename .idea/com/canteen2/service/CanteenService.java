package com.canteen2.service;
import com.canteen2.model.Diner;
import java.util.ArrayList;
/**
 * 二号食堂业务：人员登记、刷卡消费、营收统计
 */
public class CanteenService {
    // 父类引用集合，可同时存放学生与教职工对象
    private ArrayList<Diner> dinerList = new ArrayList<>();
    private double totalIncome = 0; // 累计营业收入
   public void registerDiner(Diner diner) {
    if (diner == null || diner.getCardId() == null || diner.getCardId().trim().isEmpty()) {
        System.out.println("登记失败：卡号为空");
        return;
    }
    if (findDinerByCardId(diner.getCardId()) != null) {
        System.out.println("登记失败：卡号 " + diner.getCardId() + " 已存在");
        return;
    }
    dinerList.add(diner);
}
    public Diner findDinerByCardId(String cardId) {
        if (cardId == null) return null;
    String key = cardId.trim();
        for (Diner d : dinerList) {
            if (d.getCardId().equals(cardId)) {
                return d;
            }
        }
        return null;
    }
    /**
     * 刷卡消费：金额计算交给对象自身，此处不做类型判断
     */
    public String cardConsume(String cardId, double originMoney) {
        if (!(originMoney > 0) || !Double.isFinite(originMoney)) {
        return "消费失败：金额必须大于 0";
    }
        Diner diner = findDinerByCardId(cardId);
        if (diner == null) {
            return "错误：卡号不存在！";
        }
        double before = diner.getBalance();
       if(before<originMoney){
           return String.format("消费失败！余额不足，当前余额%。2f元",before);
       }
        if(!dinner.consume(originMoney)){
            return"消费失败：账户状态异常，请联系管理员";
        }
        totalIncome += before - diner.getBalance();
        return String.format("消费成功！剩余余额 %.2f 元", diner.getBalance());
    }
    public void showAllDiner() {
        if (dinerList.isEmpty()) {
            System.out.println("暂无登记的就餐人员");
            return;
        }
        for (Diner d : dinerList) {
            d.showInfo(); // 多态：自动调用子类重写版本
        }
    }
    public double getTotalIncome() {
        return totalIncome;
    }
}
