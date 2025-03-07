package Lv2;
import utils.TextColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public void main() {
        //List 선언 및 초기화
        List<MenuItem> menuItem = new ArrayList<>();

        //add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItem.add(new MenuItem(" ShackBurger   ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem(" SmokeShack    ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItem.add(new MenuItem(" Cheeseburger  ", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItem.add(new MenuItem(" Hamburger     ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        //Scanner 선언
        Scanner sc = new Scanner(System.in);
        int num = -1;

        //입력값이 0일경우 프로그램 종료
        while(num != 0) {
            System.out.println("\n====================");
            System.out.println("[SHAKESHACK MENU]");

            //반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for(int i = 0; i < menuItem.size(); i++){
                System.out.println(TextColor.R + (i + 1)+ TextColor.E + "." + menuItem.get(i));
            }
            System.out.println(TextColor.R + "0. " + TextColor.E + "뒤로가기");
            System.out.println("====================");
            System.out.print("\n번호를 선택해 주세요\n: ");

            //숫자 입력받기 밑 입력된 숫자에 따른 처리
            if(sc.hasNextInt()){
                int numinput = sc.nextInt();
                sc.nextLine(); // 입력 버퍼

                if(numinput == 0) {
                    //프로그램 종료
                    System.out.println("**메인으로 이동합니다.");
                    return;
                }else if(numinput >= 1 && numinput <= menuItem.size()){
                    //선택한 메뉴 설명
                    System.out.println("\n선택한 번호는 " + numinput + "번 입니다.");
                    System.out.println("\n====================");
                    System.out.println("메뉴 설명");
                    menuItem.get(numinput-1).choose();
                    System.out.println("====================");
                }else {
                    //정상적인 번호가 아닐시 예외처리
                    System.out.println("**4가지 메뉴 중 하나를 선택해주세요.");
                }
            } else {
                //정수 입력이 아닐시 예외처리
                System.out.println("**숫자로 입력해주세요.");
                sc.next(); //잘못 입력된 값 삭제
            }
        }
        //스캐너 닫기
        sc.close();
    }
}
