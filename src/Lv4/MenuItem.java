package Lv4;
import utils.TextColor;

public class MenuItem {

    //필드 선언
    private String name;
    private double price;
    private String description;

    // 생성자
    public MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 필드를 활용한 메서드
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
