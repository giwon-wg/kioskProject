package Lv3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //List 선언 및 초기화
        List<MenuItem> menuItem = new ArrayList<>();

        //add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItem.add(new Lv3.MenuItem(" ShackBurger   ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new Lv3.MenuItem(" SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new Lv3.MenuItem(" Cheeseburger  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItem.add(new Lv3.MenuItem(" Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        //객체 생성
        Kiosk kiosk = new Kiosk(menuItem);
        kiosk.start();
    }
}
