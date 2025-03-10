package Lv5;
import utils.TextColor;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    //Kiosk 생성자(메뉴 리스트 받기)
    public Kiosk(List<Menu> menus){
        this.menus = menus;
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
            for(int i = 0; i < menus.size(); i++){
                System.out.println(TextColor.R + (i + 1) + ". " + TextColor.E + menus.get(i).getCategory());
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
                }else if(numinput >= 1 && numinput <= menus.size()){
                    //올바른 숫자라면 display 호출
                    Menu select = menus.get(numinput - 1);
                    display(select, sc);
                }else {
                    //정상적인 번호가 아닐시 예외처리
                    System.out.println("**올바른 카테고리를 선택하세요.");
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

    private void display(Menu menu, Scanner sc){
        System.out.println("\n====================");
        System.out.println("["+ menu.getCategory() + " MENU]");


        List<MenuItem> items = menu.getMenuItems();
        for (int i = 0; i < items.size(); i++){
            System.out.println((i+1) + "." + items.get(i));
        }
        System.out.println(TextColor.R + "0. " + TextColor.E + "뒤로가기");
        System.out.println("====================");
        System.out.print("\n번호를 선택해 주세요\n: ");

        if(sc.hasNextInt()) {
            int numinputs = sc.nextInt();
            sc.nextLine(); // 입력 버퍼

            if (numinputs == 0) {
                //프로그램 종료
                System.out.println("**메인으로 이동합니다.");
            } else if (numinputs >= 1 && numinputs <= items.size()) {
                //선택한 메뉴 설명
                MenuItem select = items.get(numinputs - 1);
                System.out.println("\n선택한 번호는 " + numinputs + "번 입니다.");
                System.out.println("\n====================");
                System.out.println("메뉴 설명");
                select.choose();
                System.out.println("====================");

                System.out.print("\n뒤로 가기를 원하신다면 0번, 구매를 원하신다면 1번, 장바구니에 넣기는 2번을 눌러주세요\n: ");
                if (sc.hasNextInt()) {
                    int reinput = sc.nextInt();
                    sc.nextLine(); // 입력 버퍼

                    switch (reinput) {
                        case 0:
                            System.out.println("\n**메뉴판으로 이동합니다.\n");
                            break;
                        case 1:
                            System.out.println("\n구매 기능은 구현중입니다.\n");
                            break;
                        case 2:
                            System.out.println("\n장바구니 기능은 구현중입니다.\n");
                            break;
                        default:
                            System.out.println("**0 - 2 중 입력해주세요");
                    }
                } else {
                        System.out.println("**숫자로 입력해주세요.");
                        sc.nextLine(); // 입력 버퍼
                }
            }else {
                    System.out.println("**올바른 메뉴를 선택하세요.");
            }
        }else {
            System.out.println("**숫자로 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 // 잘못된 입력 제거
        }
    }
}