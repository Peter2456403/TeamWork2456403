package com.canteen2.view;
import com.canteen2.service.CanteenService;

public class Main {
    public static void main(String[] args) {
        CanteenService service = new CanteenService();
        ConsoleMenu menu = new ConsoleMenu(service);
        menu.run();
    }
}