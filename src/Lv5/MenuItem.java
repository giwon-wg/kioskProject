package Lv5;
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

    //Getter
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }

    // 필드를 활용한 메서드
    public void choose(){
        System.out.println("이름:" + getName());
        System.out.println("가격: " + getPrice());
        System.out.println("설명: " + getDescription());
    }

    //오버라이딩
//    public String toString(){
//        //return TextColor.Y + name + TextColor.E + price + description;
//        return TextColor.Y + name + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + price + TextColor.E + TextColor.O + " | " + TextColor.E + description;
//    }

    public void getprint(){
        System.out.println(TextColor.Y + getName() + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + getPrice() + TextColor.E + TextColor.O + " | " + TextColor.E + getDescription());
    }

}
