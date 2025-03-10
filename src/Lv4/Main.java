package Lv4;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Menu> menu = Menu.getMenu();

        //객체 생성
        Kiosk kiosks = new Kiosk(menu);
        kiosks.start();
    }
}
