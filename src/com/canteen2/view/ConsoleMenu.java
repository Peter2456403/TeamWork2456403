package com.canteen2.view;
import com.canteen2.model.StaffDiner;
import com.canteen2.model.StudentDiner;
import com.canteen2.service.CanteenService;
import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ConsoleMenu {
    private Scanner scanner = new Scanner(System.in);
    private CanteenService service;
    public ConsoleMenu(CanteenService service) {
        this.service = service;
    }
    public void printMenu() {
        System.out.println("======== 二号食堂收费管理系统 ========");
        System.out.println("1、登记学生就餐人员");
        System.out.println("2、登记教职工就餐人员");
        System.out.println("3、刷卡消费");
        System.out.println("4、查看全部就餐人员");
        System.out.println("5、查看累计营业收入");
        System.out.println("0、退出系统");
        System.out.print("请输入功能编号：");
    }
    public void run() {
        JFrame mframe = new JFrame("学校第二食堂");
        mframe.setBackground(Color.white);
        mframe.setResizable(true);
        mframe.setLocation(500,500);
        mframe.setSize(600,800);
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mframe.setVisible(true);
        JButton StudentResiger = new JButton("学生就餐人员登记");
        JButton TeacherResiger = new JButton(" 教职工就餐人员登记");
        JButton Consumption = new JButton("刷卡消费");
        JButton AllCheck = new JButton("查看全部就餐人员");
        JButton AllMoney = new JButton("查看累计营业收入");
        JButton Exit = new JButton("退出系统");
        mframe.setLayout(new GridLayout(2,3));
        mframe.add(StudentResiger);
        mframe.add(TeacherResiger);
        mframe.add(Consumption);
        mframe.add(AllCheck);
        mframe.add(AllMoney);
        mframe.add(Exit);
        StudentResiger.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String card = JOptionPane.showInputDialog("卡号：");
                String name = JOptionPane.showInputDialog("姓名：");
                double bal = Double.parseDouble(JOptionPane.showInputDialog("初始金额："));
                String cls = JOptionPane.showInputDialog("班级：");
                service.registerDiner(new StudentDiner(card, name, bal, cls));
                JOptionPane.showMessageDialog(mframe,"学生登记完成！");
            }
        });
        TeacherResiger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String card = JOptionPane.showInputDialog("卡号：");
                String name = JOptionPane.showInputDialog("姓名：");
                double bal = Double.parseDouble(JOptionPane.showInputDialog("初始余额："));
                String dept = JOptionPane.showInputDialog("部门：");
                service.registerDiner(new StaffDiner(card, name, bal, dept));
                JOptionPane.showMessageDialog(mframe,"教职工登记完成！");
            }
        });
        Consumption.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String card = JOptionPane.showInputDialog("就餐卡号");
                double money = Double.parseDouble(JOptionPane.showInputDialog("菜品原始金额"));
                JOptionPane.showMessageDialog(mframe,service.cardConsume(card, money));
            }
        });
        AllCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                /*JFrame TextOutput = new JFrame("就餐人员清单");
                TextOutput.setBackground(Color.white);
                TextOutput.setResizable(true);
                TextOutput.setLocation(500,500);
                TextOutput.setSize(600,800);
                TextOutput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
                service.showAllDiner();
            }
        });
        AllMoney.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                JOptionPane.showMessageDialog(mframe,"累计营业收入："+ service.getTotalIncome()+"元");
            }
        }
        );
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        while (true) {
            printMenu();
            int op = scanner.nextInt();
            scanner.nextLine();
            switch (op) {
                case 1: {
                    System.out.print("卡号：");
                    String card = scanner.nextLine();
                    System.out.print("姓名：");
                    String name = scanner.nextLine();
                    System.out.print("初始余额：");
                    double bal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("班级：");
                    String cls = scanner.nextLine();
                    service.registerDiner(new StudentDiner(card, name, bal, cls));
                    System.out.println("学生登记完成！");
                    break;
                }
                case 2: {
                    System.out.print("卡号：");
                    String card = scanner.nextLine();
                    System.out.print("姓名：");
                    String name = scanner.nextLine();
                    System.out.print("初始余额：");
                    double bal = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("部门：");
                    String dept = scanner.nextLine();
                    service.registerDiner(new StaffDiner(card, name, bal, dept));
                    System.out.println("教职工登记完成！");
                    break;
                }
                case 3: {
                    System.out.print("就餐卡号：");
                    String card = scanner.nextLine();
                    System.out.print("菜品原始金额：");
                    double money = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(service.cardConsume(card, money));
                    break;
                }
                case 4:
                    System.out.println("------ 就餐人员清单 ------");
                    service.showAllDiner();
                    break;
                case 5:
                    System.out.printf("累计营业收入：%.2f 元%n", service.getTotalIncome());
                    break;
                case 0:
                    System.out.println("系统已退出。");
                    return;
                default:
                    System.out.println("选项无效，请重新输入！");
            }
            System.out.println();
        }
    }
}