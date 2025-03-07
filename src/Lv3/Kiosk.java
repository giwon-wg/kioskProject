package Lv3;
import utils.TextColor;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItem;

    //Kiosk 생성자(메뉴 리스트 받기)
    public Kiosk(List<MenuItem> menuItems){
        this.menuItem = menuItems;
    }

    //Main에 있는 반복 실행문 Kiosk로 이동// Start 메서드
    public void start(){
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
