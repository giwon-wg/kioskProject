package Lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category){
        this.category = category;
        this.menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        menuItems.add(item);
    }

    public String getCategory(){
        return category;
    }

    public  List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public static List<Menu> getMenu(){
        List<Menu> menu = new ArrayList<>();

        //add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        Menu burgerMenu = new Menu("BURGER");
        burgerMenu.addItem(new MenuItem(" ShackBurger   ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem(" SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem(" CheeseBurger  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem(" HamBurger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menu.add(burgerMenu);

        Menu drinkMenu = new Menu("DRINK");
        drinkMenu.addItem(new MenuItem(" Coke           ", 1.5, "시원한 코카콜라"));
        drinkMenu.addItem(new MenuItem(" Sprite         ", 1.5, "시원한 사이다"));
        drinkMenu.addItem(new MenuItem(" Dr. Pepper     ", 1.5, "시원한 닥터페퍼"));
        drinkMenu.addItem(new MenuItem(" Milk Shake     ", 2.5, "달달한 밀크 쉐이크"));
        menu.add(drinkMenu);

        Menu DessertsMenu = new Menu("DESSERTS");
        DessertsMenu.addItem(new MenuItem(" French Fries     ", 3.5, "갓 튀긴 감자튀김"));
        DessertsMenu.addItem(new MenuItem(" Nuggets          ", 3.5, "치킨 베이스의 너겟"));
        DessertsMenu.addItem(new MenuItem(" Mozzarella Stick ", 3.5, "모짜렐라 치즈 스틱"));
        menu.add(DessertsMenu);

        return menu;
    }
}
