package Lv1;
import utils.TextColor;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner 활성화
        Scanner sc = new Scanner(System.in);

        int num = -1;

        //메뉴 선택 반복문
        while(num != 0) {
            //메뉴판
            System.out.println("\n====================");
            System.out.println("[SHAKESHACK MENU]");
            System.out.println(TextColor.R + "1. " + TextColor.E + TextColor.Y + "ShackBurger   " + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + "6.9 " + TextColor.E + TextColor.O + "| " + TextColor.E + "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println(TextColor.R + "2. " + TextColor.E + TextColor.Y + "SmokeShack    " + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + "8.9 " + TextColor.E + TextColor.O + "| " + TextColor.E + "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println(TextColor.R + "3. " + TextColor.E + TextColor.Y + "Cheeseburger  " + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + "6.9 " + TextColor.E + TextColor.O + "| " + TextColor.E + "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println(TextColor.R + "4. " + TextColor.E + TextColor.Y + "Hamburger     " + TextColor.E + TextColor.O + "| " + TextColor.E + TextColor.Y + "W " + TextColor.E + TextColor.R + "5.4 " + TextColor.E + TextColor.O + "| " + TextColor.E + "비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println(TextColor.R + "0. " + TextColor.E + "종료");
            System.out.println("====================");
            System.out.print("\n번호를 선택해 주세요\n: ");

            //예외 처리
            if(sc.hasNextInt()){
                int numinput = sc.nextInt();
                sc.nextLine(); // 입력 버퍼

                if(numinput>=0 && numinput <= 4) {
                    num = numinput;
                }else {
                    System.out.println("**4가지 메뉴 중 하나를 선택해주세요.");
                }
            } else {
                System.out.println("**숫자로 입력해주세요.");
                sc.next(); //잘못 입력된 값 삭제
            }
        }
        System.out.println("**프로그램을 종료합니다.");
        sc.close();
    }
}
