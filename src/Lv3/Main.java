package Lv3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //List 선언 및 초기화
        List<MenuItem> menuItem = new ArrayList<>();

        //객체 생성
        Kiosk kiosk = new Kiosk(menuItem);
        kiosk.start();
    }
}
