package Lv2;

import utils.TextColor;

public class MenuItem {
    private String name;
    private double price;
    private String description;

    public MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void choose(){
        System.out.println("이름:" + name);
        System.out.println("가격: " + price);
        System.out.println("설명: " + description);
    }

    //오버라이딩
    public String toString(){
        //return TextColor.Y + name + TextColor.E + price + description;
        return TextColor.Y + name + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + price + TextColor.E + TextColor.O + " | " + TextColor.E + description;
    }

}
