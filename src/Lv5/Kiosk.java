package Lv5;
import utils.TextColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kiosk {
    private List<Menu> menus;
    private List<MenuItem> cart = new ArrayList<>();

    //Kiosk 생성자(메뉴 리스트 받기)
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    //Main에 있는 반복 실행문 Kiosk로 이동// Start 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);
        int num = -1;

        //입력값이 0일경우 프로그램 종료
        while (num != 0) {
            System.out.println("\n====================");
            System.out.println("[SHAKESHACK MENU]");

            //반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(TextColor.R + (i + 1) + ". " + TextColor.E + menus.get(i).getCategory());
            }
            System.out.println(TextColor.R + "0. " + TextColor.E + "뒤로가기");
            System.out.println("====================");

//            장바구니 구현
            if(!cart.isEmpty()){
                viewCart();
            }

            if (sc.hasNextInt()) {
                int numinput = sc.nextInt();
                sc.nextLine(); // 입력 버퍼
                if(numinput == 0) {
                    //프로그램 종료
                    System.out.println("Move to Main");
                    return;
                    } else if(numinput >= 1 && numinput <= menus.size()){
                    //올바른 숫자라면 display 호출
                    Menu select = menus.get(numinput - 1);
                    display(select, sc);
                }else {
                    try {
                        cart(numinput, sc);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        //스캐너 닫기
        sc.close();
    }

    private void display(Menu menu, Scanner sc) {
        System.out.println("\n====================");
        System.out.println("[" + menu.getCategory() + " MENU]");


        List<MenuItem> items = menu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.print(TextColor.R + (i + 1) + "." + TextColor.E);
            items.get(i).getprint();
        }
        System.out.println(TextColor.R + "0. " + TextColor.E + "Move to Main");
        System.out.println("====================");

        if (sc.hasNextInt()) {
            int numinputs = sc.nextInt();
            sc.nextLine(); // 입력 버퍼

            if (numinputs == 0) {
                //프로그램 종료
                System.out.println("Move to Main");
            } else if (numinputs >= 1 && numinputs <= items.size()) {
                //선택한 메뉴 설명
                MenuItem select = items.get(numinputs - 1);
                System.out.println("\n====================");
                System.out.println("메뉴 설명");
                select.choose();
                System.out.println("====================");
                System.out.println(TextColor.R + "1. " + TextColor.E + "장바구니에 담기");
                System.out.println(TextColor.R + "0. " + TextColor.E + "Move to Main");

                if (sc.hasNextInt()) {
                    int reinput = sc.nextInt();
                    sc.nextLine(); // 입력 버퍼

                    switch (reinput) {
                        case 0:
                            System.out.println("\n**메뉴판으로 이동합니다.\n");
                            break;
                        case 1:
                            inCart(select);
                            break;
                        default:
                            System.out.println("**0 - 1 중 입력해주세요");
                    }
                } else {
                    System.out.println("**숫자로 입력해주세요.");
                    sc.nextLine(); // 입력 버퍼
                }
            } else {
                System.out.println("**올바른 메뉴를 선택하세요.");
            }
        } else {
            System.out.println("**숫자로 입력해주세요.");
            sc.nextLine(); // 입력 버퍼 // 잘못된 입력 제거
        }
    }

    public void inCart(MenuItem item) {
        System.out.println("선택하신 메뉴가 장바구니에 추가되었습니다.");
        cart.add(item);
    }

    public void viewCart() {
        System.out.println("[장바구니 목록]");
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            cart.stream()
                    .map(item -> (cart.indexOf(item) + 1) + "." + item.getName() + " | W " + item.getPrice())
                    .forEach(System.out::println);
//            for (int i = 0; i < cart.size(); i++) {
//                System.out.println((i + 1) + ". " + cart.get(i).getName() + " | W " + cart.get(i).getPrice());
//            }
            double totalprice = 0;
            for (MenuItem item : cart) {
                totalprice += item.getPrice();
            }
            totalprice *= 1000;
            System.out.println("\n총 가격: W " + totalprice);
        }
        System.out.println(TextColor.R + (menus.size() + 1) + ". " + TextColor.E + "상품 구매하기");
        System.out.println(TextColor.R + (menus.size() + 2) + ". " + TextColor.E + "전체 비우기");
        System.out.println(TextColor.R + (menus.size() + 3) + ". " + TextColor.E + "선택 비우기");
        System.out.println("====================");
    }

    public void order(Scanner sc) {
        double totalprice = 0;
        int totalpriceInt;
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i).getName() + " | W " + cart.get(i).getPrice());
            }
            for (MenuItem item : cart) {
                totalprice += item.getPrice();
            }
            totalpriceInt = (int) (totalprice * 1000);
            System.out.println("\n총 가격: W " + totalpriceInt);
        }
        System.out.println("총 결제금액은 " + totalpriceInt + "원입니다.");
        System.out.println("결제 하시겠습니까? Yes : 1 / No : 2");
        System.out.println("====================");
        String yorn = sc.nextLine();
        if (yorn.equals("1")) {
            System.out.println("====================");
            System.out.println("할인혜택을 선택해주세요");
            System.out.println("1. 국가유공자 (10% 할인)");
            System.out.println("2. 군인 (5% 할인)");
            System.out.println("3. 학생 (3% 할인)");
            System.out.println("4. 일반");
            System.out.println("====================");
            Discount discounttpye = Discount.NON;
            String userType = "";
            if(sc.hasNextInt()){
                int index = sc.nextInt();
                sc.nextLine();
                switch (index){
                    case 1:
                        discounttpye = Discount.PDS;
                        userType = "국가유공자";
                        break;
                    case 2:
                        discounttpye = Discount.MILL;
                        userType = "군인";
                        break;
                    case 3:
                        discounttpye = Discount.STU;
                        userType = "학생";
                        break;
                    case 4:
                        discounttpye = Discount.NON;
                        break;
                    default:
                        System.out.println("**잘못된 번호입니다.");
                }
            }else{
                System.out.println("**숫자로 입력해주세요.");
            }
            int disconutPrice = (int) (totalpriceInt * discounttpye.getDiscounType());
            int totalPriceDisconut = totalpriceInt - disconutPrice;
            System.out.println("====================");
            System.out.println(userType + " 할인금액은 " + disconutPrice + "원입니다.");
            System.out.println("최종 결제금액은 " + totalPriceDisconut + "원입니다.");
            System.out.println("이용해주셔서 감사합니다.");
            System.out.println("====================");
            cart.clear();
        } else if (yorn.equals("2")) {
            System.out.println("주문 결제가 취소되었습니다.");
        } else {
            System.out.println("**잘못된 번호를 입력하였습니다.");
        }
    }

    public void removeCart(Scanner sc){
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        System.out.print("\n삭제할 상품 번호를 입력하세요 (취소: 0): ");
        if (sc.hasNextInt()) {
            int index = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 정리

            if (index == 0) {
                System.out.println("삭제를 취소합니다.");
            } else if (index >= 1 && index <= cart.size()) {
                String removedItem= cart.get(index -1).getName();
                cart = cart.stream()
                        .filter(item -> !item.getName().equals(removedItem))
                        .collect(Collectors.toList());
//                MenuItem removedItem = cart.remove(index - 1);
                System.out.println(removedItem + "이(가) 장바구니에서 삭제되었습니다.");
            } else {
                System.out.println("**잘못된 번호입니다.");
            }
        } else {
            System.out.println("**숫자로 입력해주세요.");
            sc.nextLine();
        }
    }

    public void cart(int numinput, Scanner sc){
        if(cart.isEmpty() && (numinput == menus.size() + 1 || numinput == menus.size() + 2 || numinput == menus.size() + 3)){
            throw new IllegalStateException("**올바른 숫자를 입력해주세요");
        }

        if (numinput == menus.size() + 1) {//메뉴 추가 대비 하드코딩X
            System.out.println("구매창으로 이동합니다.\n");
            System.out.println("====================");
            order(sc);
        } else if (numinput == menus.size() + 2){
            cart.clear();
            System.out.println("장바구니를 비웠습니다.");
        } else if (numinput == menus.size() + 3){
            System.out.println("삭제 하실 제품을 선택해주세요");
            removeCart(sc);
        } else {
            System.out.println("입력값을 확인해 주세요");
        }
    }
}